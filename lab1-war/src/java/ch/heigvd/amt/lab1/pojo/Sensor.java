/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab1.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author bradock
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name = "findAllSensor",
            query = "SELECT s FROM Sensor s"
    ),
    @NamedQuery(
            name = "findByDescriptionSensor",
            query = "SELECT s FROM Sensor s WHERE s.description LIKE :desc"
    ),
    @NamedQuery(
            name = "findById",
            query = "SELECT s FROM Sensor s WHERE s.id = :id"
    ),
    @NamedQuery(
            name = "findByTypeSensor",
            query = "SELECT s FROM Sensor s WHERE s.type LIKE :type"
    )
})
public class Sensor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String type;
    
    public Sensor(){}
    public Sensor(Long id, String description, String type){
        this.id = id;
        this.description = description;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }
}
