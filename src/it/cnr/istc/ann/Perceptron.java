/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc.ann;

import it.cnr.istc.UtilsANN;
import it.cnr.istc.datasets.Dataset;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class Perceptron  {
    
    private float[] inputs;
    private float[] weights;
//    private float bias = 1;//ThreadLocalRandom.current().nextFloat();
    private float learningRate = 0.45f; //adjustment speed
    private float potential = 0f;
    private int lastActivationResult;

    public Perceptron(int input_size) {
        this.inputs = new float[input_size];
        this.weights = new float[input_size];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = UtilsANN.randomNegativePositive();
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

    public float[] getWeights() {
        return weights;
    }
    
    
    
    public int test(float...ins) throws Exception{
        setInputs(ins);
        return activate();
    }

    public void setLearningRate(float learningRate) {
        this.learningRate = learningRate;
    }
    
    public void decreaseLearningRate(float amount){
        if(this.learningRate-amount < 0){
            return;
        }
        this.learningRate-=amount;
        System.out.println("LE: "+this.learningRate);
    }

    public float getLearningRate() {
        return learningRate;
    }
    
    
    public void train(Dataset dataset){
        this.inputs = dataset.getInputs();
        dataset.setGivenAnswer(this.activate());
        int error = dataset.getError();
//        System.out.print("error: \t\t\t\t"+error);
        for (int i = 0; i < weights.length; i++) {
            //weights[i] +=  (error * inputs[i]);
             //this.weights[i] = this.weights[i] + (this.learningRate * (error) * this.inputs[i]);
             weights[i] +=  (error * inputs[i] * this.learningRate);
        }
//        System.out.print("\t\t-- weights: ");
//        for (float w : weights) {
//            System.out.print(w+", ");
//        }
//        System.out.println("");
    }
    
public int sign(float x){
        return x >= 0 ? 1 : -1;
    }

    public int activate() {

        float potenzialeAttivazione = 0;
        for (int i = 0; i < inputs.length; i++) {
            potenzialeAttivazione += (this.inputs[i] * this.weights[i]);
        }
        this.potential = potenzialeAttivazione;
        this.lastActivationResult = sign(this.potential);
        return this.lastActivationResult;

    }
    
    public float guessY(float x){
        float w0 = weights[0];
        float w1 = weights[1];
        float w2 = weights[2];
//        System.out.println(" - w2/w1 = "+w2/w1);
        return -(w2/w1) - (w0/w1) *x;
    }
    
    public void wrong(){
        System.out.println("<<<< WRONG >>>>>");
        int error = -this.lastActivationResult - this.lastActivationResult;
        for (int i = 0; i < weights.length; i++) {
             weights[i] +=  (error * inputs[i] * this.learningRate);
        }
        System.out.print("\t\t-- weights: ");
        for (float w : weights) {
            System.out.print(w+", ");
        }
        System.out.println("");
    }

//    public void adjust(boolean correctValue) {
//
//        int givenAnswer = this.potential >= 0 ? 1 : 0; //A
//        int correctAnswer = correctValue ? 1 : 0;      //A'
//        
//        
//
//        
//
//    }

}
