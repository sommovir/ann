/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc.test.nextlevel;

import it.cnr.istc.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class PerceptronTEST2 {

    private Float[] inputs;
    private Float[] weights;
    private float bias = ThreadLocalRandom.current().nextFloat();
    private float sigma = 0.5f; //adjustment speed
    private float potential = 0f;
    private int memoryForNullInputs = 1;

    public PerceptronTEST2(int input_size) {
        this.inputs = new Float[input_size];
        this.weights = new Float[input_size];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = UtilsANN.randomNegativePositive();
//            System.out.println("random weight[" + i + "] = " + weights[i]);
        }
    }

    public void setInputs(float... ins) throws Exception {
        if (ins.length != inputs.length) {
            throw new Exception("Lenghts Mismatch!");
        }
        for (int i = 0; i < ins.length; i++) {
            inputs[i] = ins[i];
        }
    }

    public boolean isNullInput() {
        for (Float input : inputs) {
            if(input != 0){
                return false;
            }
        }
        return true;
    }

//    public float activate(){
//        
//        float sum = 0;
//        for (int i = 0; i < inputs.length; i++) {
//            sum+=(this.inputs[i] * this.weights[i]);
//        }
//        sum+=bias;
//        System.out.println("BIAS = "+bias);
//        System.out.println("SUM = "+sum);
//        return (float) (1f/(1f+ Math.exp(-sum)));
//        
//    }
    public int activate() {
        
        if(isNullInput()){
            return this.memoryForNullInputs;
        }

        float potenzialeAttivazione = bias;
        for (int i = 0; i < inputs.length; i++) {
            potenzialeAttivazione += (this.inputs[i] * this.weights[i]);
        }

//        System.out.println("BIAS = " + bias);
//        System.out.println("Potenziale di Attivazione = " + potenzialeAttivazione);
//        sum = 0.2f;
//        float result = (float) (1f/(1f+ Math.exp(-sum)));
        this.potential = potenzialeAttivazione;
        if(potenzialeAttivazione <= 0.4){
            return 1;
        }else if(potenzialeAttivazione > 0.4 && potenzialeAttivazione <=0.7){
            return 2;
        }else{
            return 3;
        }

    }

    public void adjust(int correctValue) {
        
        if(isNullInput()){
            this.memoryForNullInputs = correctValue;
        }
        
         int givenAnswer =0; //A
        if(potential <= 0.4){
            givenAnswer =  1;
        }else if(potential > 0.4 && potential <=0.7){
            givenAnswer=  2;
        }else{
            givenAnswer =  3;
        }

        int correctAnswer = correctValue;      //A'

        System.out.println("OLD CONFIG: " + inputs[0] + "  " + inputs[1] + "  " + inputs[2] + "  -----  " + weights[0] + " " + weights[1] + " " + weights[2] + " -------> " + this.potential);

        for (int i = 0; i < inputs.length; i++) {
            this.weights[i] = this.weights[i] + (this.sigma * (correctAnswer - givenAnswer) * this.inputs[i]);
        }

        System.out.println("NEW CONFIG: " + inputs[0] + "  " + inputs[1] + "  " + inputs[2] + "  -----  " + weights[0] + " " + weights[1] + " " + weights[2]);
        System.out.println("----------------------");

    }

}
