package fr.mika.worldvulcan.dto.country;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class CountryDTO {
    public static final CountryDTO NULL_COUNTRYDTO = new CountryDTO("0", "", "");

    private String id;
    private String name;
    private String code;

    public CountryDTO() {
    }

    public CountryDTO(String id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CountryDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
