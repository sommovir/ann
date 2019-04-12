/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc.ann.events;

import it.cnr.istc.datasets.DataBucket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class TrainingEventManager {
    
    private static TrainingEventManager _instance = null;
    private List<TrainingListener> listeners = new ArrayList<>();
    
    public static TrainingEventManager getInstance() {
        if (_instance == null) {
            _instance = new TrainingEventManager();
            return _instance;
        } else {
            return _instance;
        }
    }
    
    private TrainingEventManager() {
        super();
    }
    
    public void addTrainingListener(TrainingListener listener){
        this.listeners.add(listener);
    }
    
    public void bucketDone(DataBucket bucket, boolean descent){
        for (TrainingListener listener : listeners) {
            listener.bucketDone(bucket, descent);
        }
    }
    
    
    
}
