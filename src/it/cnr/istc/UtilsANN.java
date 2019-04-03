/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class UtilsANN {

    public static float randomNegativePositive() {

        boolean positive = ThreadLocalRandom.current().nextFloat() >= 0.5f ? true : false;

        float result = ThreadLocalRandom.current().nextFloat();

        return positive ? result : -result;

    }

    public static int generateRandomInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static float calculateStandarDeviation(float[] values) {

        if (values.length == 0) {
            return 0;
        }

        float sum = 0;
        for (float value : values) {
            sum += value;
        }
        float average = sum / values.length;
        System.out.println("average: " + average);

        float deviation = 0;
        for (float value : values) {
            deviation += ((value - average) * (value - average));
        }

        return (float) Math.sqrt(deviation / ((float) values.length - 1));

    }

}
