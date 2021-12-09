package fr.mika.worldvulcan.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Vulcan {
    @Id
    private String id;
    private String name;
    private float magnitude;
    private Date date;
    @DBRef
    private Country country;
}
