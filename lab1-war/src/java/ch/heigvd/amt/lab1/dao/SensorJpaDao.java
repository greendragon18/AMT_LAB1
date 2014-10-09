/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab1.dao;

import ch.heigvd.amt.lab1.daoi.SensorDAO;
import ch.heigvd.amt.lab1.pojo.Sensor;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bradock
 */
@Stateless
public class SensorJpaDao implements SensorDAO {
    
    @PersistenceContext
    EntityManager em;
 

    @Override
    public void create(Sensor sensor) {
         em.persist(sensor);
         em.flush();
    }

    @Override
    public void update(Sensor sensor) {
        em.merge(sensor);
        em.flush();   
    }

    @Override
    public void delete(Sensor sensor) {
        em.remove(sensor);
        em.flush();
    }

    @Override
    public Sensor findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sensor> findAll() {
        return em.createNamedQuery("findAllSensor")
                .getResultList();
    }

    @Override
    public List<Sensor> findByDescription(String description) {
        return em.createNamedQuery("findByDescriptionSensor")
                .setParameter("desc", description)
                .getResultList();
    }

    @Override
    public List<Sensor> findByType(String type) {
        return em.createNamedQuery("findByTypeSensor")
                .setParameter("type", type)
                .getResultList();
    }
}
