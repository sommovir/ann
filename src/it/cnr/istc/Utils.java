/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class Utils {
    
    public static float randomNegativePositive(){
        
        boolean positive = ThreadLocalRandom.current().nextFloat() >= 0.5f ? true : false;
        
        float result = ThreadLocalRandom.current().nextFloat();
        
        return positive ? result : -result;
        
    }
    
}
