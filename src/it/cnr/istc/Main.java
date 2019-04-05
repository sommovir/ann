/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("PERCEPTRON TEST");
 
//            System.out.println("Y = "+y);
            
            PerceptronTEST p = new PerceptronTEST(3);
            p.setInputs(0.2f, 0.3f, 0.9f);
            boolean result = p.activate();
            System.out.println("RESULT = "+result);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
