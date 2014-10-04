/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab1.services;

import ch.heigvd.amt.lab1.model.Measure;
import java.util.LinkedList;
import javax.ejb.Local;

/**
 *
 * @author bradock
 */
@Local
public interface MeasuresManagerLocal {

    public void logMeasure(Measure m);

    public LinkedList<Object> getMeasures();
    
}
