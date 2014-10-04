/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab1.services;

import ch.heigvd.amt.lab1.model.Measure;
import java.util.LinkedList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author bradock
 */
@Stateless
public class MeasuresManager implements MeasuresManagerLocal {

    @EJB
    DataManagerLocal dataManager;
    
    @Override
    public void	logMeasure(Measure m){
        dataManager.insertData(m);
    }
          
    @Override
   public LinkedList<Object> getMeasures(){
       return dataManager.getData();
   }       
}
