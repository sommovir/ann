/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class Perceptron {

    private Float[] inputs;
    private Float[] weights;
    private float bias = ThreadLocalRandom.current().nextFloat();
    private float sigma = 0.5f; //adjustment speed
    private float potential = 0f;

    public Perceptron(int input_size) {
        this.inputs = new Float[input_size];
        this.weights = new Float[input_size];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Utils.randomNegativePositive();
//            System.out.println("random weight[" + i + "] = " + weights[i]);
        }
    }

    public void setInputs(Float... ins) throws Exception {
        if (ins.length != inputs.length) {
            throw new Exception("Lenghts Mismatch!");
        }
        for (int i = 0; i < ins.length; i++) {
            inputs[i] = ins[i];
        }
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
    public boolean activate() {

        float potenzialeAttivazione = 0;
        for (int i = 0; i < inputs.length; i++) {
            potenzialeAttivazione += (this.inputs[i] * this.weights[i]);
        }

//        System.out.println("BIAS = " + bias);
//        System.out.println("Potenziale di Attivazione = " + potenzialeAttivazione);
//        sum = 0.2f;
//        float result = (float) (1f/(1f+ Math.exp(-sum)));
        this.potential = potenzialeAttivazione;
        return potenzialeAttivazione >= 0;

    }

    public void adjust(boolean correctValue) {

        int givenAnswer = this.potential >= 0 ? 1 : 0; //A
        int correctAnswer = correctValue ? 1 : 0;      //A'

        System.out.println("OLD CONFIG: "+inputs[0]+"  "+inputs[1]+"  "+inputs[2]+"  -----  "+weights[0]+" "+weights[1]+" "+weights[2]+" -------> "+this.potential);
        
        for (int i = 0; i < inputs.length; i++) {
            this.weights[i] = this.weights[i] + (this.sigma * (correctAnswer - givenAnswer) * (this.inputs[i] == 0 ? 0.1f : this.inputs[i] ));
        }
        
        System.out.println("NEW CONFIG: "+inputs[0]+"  "+inputs[1]+"  "+inputs[2]+"  -----  "+weights[0]+" "+weights[1]+" "+weights[2]);
        System.out.println("----------------------");

    }

}
