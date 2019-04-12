/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc.ann;

import it.cnr.istc.UtilsANN;
import it.cnr.istc.datasets.DataBucket;
import it.cnr.istc.datasets.Dataset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class PerceptronDescent {

    private float[] inputs;
    private float[] weights;
//    private float bias = 1;//ThreadLocalRandom.current().nextFloat();
    private float learningRate = 0.45f; //adjustment speed
    private float potential = 0f;
    private float lastActivationResult;

    public PerceptronDescent(int input_size) {
        this.inputs = new float[input_size];
        this.weights = new float[input_size];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = UtilsANN.randomNegativePositive();
        }
    }

    public float[] getWeights() {
        return weights;
    }

    public void setInputs(float... ins) throws Exception {
        if (ins.length != inputs.length) {
            throw new Exception("Lenghts Mismatch!");
        }
        for (int i = 0; i < ins.length; i++) {
            inputs[i] = ins[i];
        }
    }

    public void setLearningRate(float learningRate) {
        this.learningRate = learningRate;
    }

    public void decreaseLearningRate(float amount) {
        if (this.learningRate - amount < 0) {
            return;
        }
        this.learningRate -= amount;
        System.out.println("LE: " + this.learningRate);
    }

    public float getLearningRate() {
        return learningRate;
    }

    public void train(DataBucket bucket) {
//        bucket.shuffle();
        System.out.println("ORIGINIAL WEIGHTS w[" + weights[0] + ", " + weights[1] + ", " + weights[2]);
        //prepariamo i campioni da somministrare
        List<Dataset> samples = new ArrayList<>(bucket.getPackSize());
        for (int i = 0; i < bucket.getPackSize(); i++) {
            samples.add(bucket.getDatasets().get(i));
        }
        //inizializzo i delta-w a 0
        float[] dw = new float[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            dw[i] = 0f;
        }

        for (Dataset sample : samples) {
            float o = activate(sample.getInputs());
            for (int i = 0; i < dw.length; i++) {
                dw[i] = dw[i] + learningRate * (sample.getDesiredAnswer() - o) ;//* sample.getInputs()[i];
            }

        }
        for (int i = 0; i < weights.length; i++) {
            weights[i] += dw[i];
        }
        System.out.println("training DESCENT: w[" + weights[0] + ", " + weights[1] + ", " + weights[2]);

    }

    public int sign(float x) {
        return x >= 0 ? 1 : -1;
    }

    public float activate(float[] _inputs) {
        float potenzialeAttivazione = 0;
        for (int i = 0; i < _inputs.length; i++) {
            potenzialeAttivazione += (_inputs[i] * this.weights[i]);
        }
        return potenzialeAttivazione;
    }

    public float activate() {

        float potenzialeAttivazione = 0;
        for (int i = 0; i < inputs.length; i++) {
            potenzialeAttivazione += (this.inputs[i] * this.weights[i]);
        }
        this.potential = potenzialeAttivazione;
        this.lastActivationResult = this.potential;
        return this.lastActivationResult;

    }

    public float guessY(float x) {
        float w0 = weights[0];
        float w1 = weights[1];
        float w2 = weights[2];
//        System.out.println(" - w2/w1 = "+w2/w1);
        return -(w2 / w1) - (w0 / w1) * x;
    }

}
