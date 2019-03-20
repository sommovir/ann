/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc.ann;

import it.cnr.istc.datasets.Dataset;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class Trainer {
    private List<Dataset> trainingData = new ArrayList<>();
    private Perceptron perceptron = null;

    
    public Trainer(int inputSize){
        this.perceptron = new Perceptron(inputSize);
    }
    
    public void clearTrainingData(){
        this.trainingData.clear();
    }
    
    public void addTrainingData(Dataset data){
        this.trainingData.add(data);
    }
    
    public void train(){
        
        for (Dataset dataset : trainingData) {
            this.perceptron.train(dataset);
        }
        
    }

    public Perceptron getPerceptron() {
        return perceptron;
    }
    
    
    
    
}