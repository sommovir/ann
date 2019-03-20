/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc.datasets;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class Dataset {
    
    private float[] inputs;
    private int desiredAnswer;
    private int givenAnswer = 0;

    public Dataset(float[] inputs, int desiredAnswer) {
        this.inputs = inputs;
        this.desiredAnswer = desiredAnswer;
    }

    public float[] getInputs() {
        return inputs;
    }

    public void setInputs(float[] inputs) {
        this.inputs = inputs;
    }

    public int getDesiredAnswer() {
        return desiredAnswer;
    }

    public void setDesiredAnswer(int desiredAnswer) {
        this.desiredAnswer = desiredAnswer;
    }

    public void setGivenAnswer(int givenAnswer) {
        this.givenAnswer = givenAnswer;
    }

    public int getGivenAnswer() {
        return givenAnswer;
    }
    
    public int getError(){
        return this.desiredAnswer - this.givenAnswer;
    }
    
    
    
    
    
    
    
}
