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
    
    
    private List<Dataset> datasets;

    public DataBucket() {
        this.datasets = new ArrayList<>();
    }
    
    public void addDataset(Dataset data){
        this.datasets.add(data);
    }
    
    
    
}
