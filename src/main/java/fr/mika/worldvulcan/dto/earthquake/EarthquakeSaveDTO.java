package fr.mika.worldvulcan.dto.earthquake;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EarthquakeSaveDTO {
    public static final EarthquakeSaveDTO NULL_EARTHQUAKESAVEDTO =
            new EarthquakeSaveDTO("",0f,"", new Date());

    private String name;
    private float magnitude;
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;

    public EarthquakeSaveDTO() {
    }

    public EarthquakeSaveDTO(String name, float magnitude, String location, Date date) {
        this.name = name;
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
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
