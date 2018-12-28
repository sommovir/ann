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
    
    private Integer [] inputs;
    private Float [] weights;
    private float bias = ThreadLocalRandom.current().nextFloat();

    public Perceptron(int input_size) {
        this.inputs = new Integer[input_size];
        this.weights = new Float[input_size];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = ThreadLocalRandom.current().nextFloat();
        }
    }
    
    public void setInputs(Integer ... ins) throws Exception{
        if(ins.length != inputs.length){
            throw new Exception("Lenghts Mismatch!");
        }
        for (int i = 0; i < ins.length; i++) {
            inputs[i] = ins[i];
        }
    }
    
    
    public float activate(){
        
        float sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum+=(this.inputs[i] * this.weights[i]);
        }
        sum+=bias;
        return (float) (1f/(1f+ Math.exp(-sum)));
        
    }
    
    
    
}
