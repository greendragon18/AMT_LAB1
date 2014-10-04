/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab1.services;

import ch.heigvd.amt.lab1.model.Measure;
import java.util.LinkedList;

/**
 *
 * @author bradock
 */
public class MeasureService {
    
    public LinkedList<Measure> getMeasures(){
        
        LinkedList<Measure> measures = new LinkedList<Measure>();
        
        for(int i=0; i<10; i++){
            measures.add(new Measure("ID"+i, System.currentTimeMillis(), Math.random() + 2000));
        }
        
        return measures;
    } 
    
}
