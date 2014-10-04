/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab1.services;

import java.util.LinkedList;
import javax.ejb.Local;

/**
 *
 * @author bradock
 */
@Local
public interface DataManagerLocal {

    public void insertData(Object o);

    public LinkedList<Object> getData();
    
}
