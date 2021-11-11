/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.cnr.istc.test.nextlevel;

/**
 *
 * @author Luca
 */
public enum Level {
    
    EASY(0.4f),
    MEDIUM(0.6f),
    HARD(1.2f);

    private Level(float weight) {
        this.weight = weight;
    }
    
    
    
    private float weight;

    public float getWeight() {
        return weight;
    }
    
    
    
}
