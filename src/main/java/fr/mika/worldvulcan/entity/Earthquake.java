package fr.mika.worldvulcan.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Earthquake {
    public static final Earthquake NULL_EARTHQUAKE =
            new Earthquake("0","",0f,"",new Date());

    @Id
    private String id;
    private String name;
    private float magnitude;
    private String localisation;
    private Date date;

    public Earthquake() {
    }

    public Earthquake(String id, String name, float magnitude, String localisation, Date date) {
        this.id = id;
        this.name = name;
        this.magnitude = magnitude;
        this.localisation = localisation;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(float magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
