/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab1.services;

import java.util.LinkedList;
import javax.ejb.Singleton;

/**
 *
 * @author bradock
 */
@Singleton
public class DataManager implements DataManagerLocal {
    
    private LinkedList<Object> objects = new LinkedList<Object>();

    @Override
    public void	insertData(Object o){
        objects.add(o);
    }
    
    @Override
    public LinkedList<Object>	getData(){
        return objects;
    }
}
