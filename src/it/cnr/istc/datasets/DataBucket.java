/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc.datasets;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class DataBucket {
    
    private int size;
    
    private List<Dataset> datasets;

    public DataBucket(int size) {
        this.size = size;
        this.datasets = new ArrayList<>(size);
    }
    
    public void addDataset(Dataset data){
        if(this.datasets.size()== size){
            System.out.println("ERRORE TROPPI");
            return;
        }
        this.datasets.add(data);
    }
    
    
    
}
