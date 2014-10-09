/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab1.daoi;

import ch.heigvd.amt.lab1.pojo.Sensor;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bradock
 */
@Local
public interface SensorDAO {

    public void create(Sensor sensor);

    public void update(Sensor sensor);

    public void delete(Sensor sensor);

    public Sensor findById(Long id);

    public List<Sensor> findAll();

    public List<Sensor> findByDescription(String description);

    public List<Sensor> findByType(String type);
    
}
