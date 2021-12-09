package fr.mika.worldvulcan.dto.country;

public class CountryDeleteDTO {
    public static final CountryDeleteDTO NULL_COUNTRYDELETEDTO = new CountryDeleteDTO("0");

    private String id;

    public CountryDeleteDTO() {
    }

    public CountryDeleteDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
