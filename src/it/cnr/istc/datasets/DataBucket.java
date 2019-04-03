/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc.datasets;

import it.cnr.istc.UtilsANN;
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
        this.datasets = new ArrayList<>();
    }
    
    public void addDataset(Dataset data){
        this.datasets.add(data);
    }
    
    public float getErrorDeviationStandard(){
        float [] errors  = new float[size];
        
        for (int i=0;i<size;i++) {
            errors[i] = datasets.get(i).getError();
            System.out.println("error in dataset: "+errors[i]);
        }
        return UtilsANN.calculateStandarDeviation(errors);
    }

    public List<Dataset> getDatasets() {
        return datasets;
    }
    
    
    
    
}
