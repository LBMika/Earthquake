package fr.mika.worldvulcan.dto.country;

public class CountrySaveDTO {
    public static final CountrySaveDTO NULL_COUNTRYSAVEDTO = new CountrySaveDTO("", "");

    private String name;
    private String code;

    public CountrySaveDTO() {
    }

    public CountrySaveDTO(String name, String code) {
        this.name = name;
        this.code = code;
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
}
