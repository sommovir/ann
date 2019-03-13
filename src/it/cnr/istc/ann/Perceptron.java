/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc.ann;

import it.cnr.istc.Utils;
import it.cnr.istc.datasets.Dataset;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class Perceptron  {
    
    private float[] inputs;
    private float[] weights;
    private float bias = ThreadLocalRandom.current().nextFloat();
    private float learningRate = 0.1f; //adjustment speed
    private float potential = 0f;

    public Perceptron(int input_size) {
        this.inputs = new float[input_size];
        this.weights = new float[input_size];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Utils.randomNegativePositive();
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
    
    public void train(Dataset dataset){
        this.inputs = dataset.getInputs();
        dataset.setGivenAnswer(this.activate());
        int error = dataset.getError();
        for (int i = 0; i < weights.length; i++) {
            weights[i] += + error * inputs[i];
        }
    }
    
    public int sign(float x){
        return x >= 0 ? 1 : -1;
    }

    public int activate() {

        float potenzialeAttivazione = bias;
        for (int i = 0; i < inputs.length; i++) {
            potenzialeAttivazione += (this.inputs[i] * this.weights[i]);
        }
        this.potential = potenzialeAttivazione;
        return sign(this.potential);

    }

    public void adjust(boolean correctValue) {

        int givenAnswer = this.potential >= 0 ? 1 : 0; //A
        int correctAnswer = correctValue ? 1 : 0;      //A'

        

    }

}
