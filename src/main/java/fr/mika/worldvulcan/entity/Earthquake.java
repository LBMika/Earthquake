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
    private String location;
    private Date date;

    public Earthquake() {
    }

    public Earthquake(String id, String name, float magnitude, String location, Date date) {
        this.id = id;
        this.name = name;
        this.magnitude = magnitude;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
