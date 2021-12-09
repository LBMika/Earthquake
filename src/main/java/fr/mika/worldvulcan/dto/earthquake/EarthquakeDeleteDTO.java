package fr.mika.worldvulcan.dto.earthquake;

import java.util.Date;

public class EarthquakeDeleteDTO {
    public static final EarthquakeDeleteDTO NULL_EARTHQUAKEDELETEDTO =
            new EarthquakeDeleteDTO("0");

    private String id;

    public EarthquakeDeleteDTO() {
    }

    public EarthquakeDeleteDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
