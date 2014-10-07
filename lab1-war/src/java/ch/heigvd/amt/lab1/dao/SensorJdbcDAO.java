/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab1.dao;

import ch.heigvd.amt.lab1.daoi.SensorDAO;
import ch.heigvd.amt.lab1.pojo.Sensor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author bradock
 */
@Stateless
public class SensorJdbcDAO implements SensorDAO {
    
    @Resource(lookup="jdbc/AMTDatabase");
    DataSource ds;
    
    Connection connect = null;
    public SensorJdbcDAO() {
        try {
            connect = ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SensorJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void create(Sensor sensor){
        try{
            PreparedStatement insert = connect.prepareStatement("INSERT INTO sensors VALUES (NULL, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                insert.setString(1, sensor.getDescription());
                insert.setString(2, sensor.getType());

                insert.executeUpdate();

                // Recuperation de l'id
                ResultSet result = insert.getGeneratedKeys();
                result.next();
                sensor.setId(result.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(Sensor sensor){
        try {
            PreparedStatement update = connect.prepareStatement("UPDATE sensors SET description = ?, type = ?  WHERE idCaserne = ?");
            update.setString(1, sensor.getDescription());
            update.setString(2, sensor.getType());
            update.setInt(3, sensor.getId());
            update.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    @Override
    public void delete(Sensor sensor){
        try {
            connect.createStatement().executeUpdate("DELETE FROM sensors WHERE id = " + sensor.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Sensor findById(int id){
        Sensor sensor = new Sensor();
        try {
            ResultSet result = connect.createStatement().executeQuery(
                    "SELECT * FROM sensors WHERE id = " + id);
            if (result.first()) {
                sensor = new Sensor(id, result.getString("description"), result.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sensor;
    }
    
    @Override
    public List<Sensor> findAll(){
         LinkedList<Sensor> sensors = new LinkedList<Sensor>();
        try {
            ResultSet result = connect.createStatement().executeQuery("SELECT * FROM sensors");
            while (result.next()) {
                Sensor sensor = new Sensor(result.getInt("id"), result.getString("description"), result.getString("type"));
                sensors.add(sensor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sensors;
    }
    
    @Override
    public List<Sensor> findByDescription(String description){
        LinkedList<Sensor> sensors = new LinkedList<Sensor>();
        try {
            ResultSet result = connect.createStatement().executeQuery("SELECT * FROM sensors WHERE type LIKE '"+description+"'");
            while (result.next()) {
                Sensor sensor = new Sensor(result.getInt("id"), result.getString("description"), result.getString("type"));
                sensors.add(sensor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sensors;
    }
    
    @Override
    public List<Sensor> findByType(String type){
        LinkedList<Sensor> sensors = new LinkedList<Sensor>();
        try {
            ResultSet result = connect.createStatement().executeQuery("SELECT * FROM sensors WHERE type LIKE '"+type+"'");
            while (result.next()) {
                Sensor sensor = new Sensor(result.getInt("id"), result.getString("description"), result.getString("type"));
                sensors.add(sensor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sensors;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
