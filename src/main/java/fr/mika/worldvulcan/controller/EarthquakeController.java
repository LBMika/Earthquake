package fr.mika.worldvulcan.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import fr.mika.worldvulcan.dto.country.CountryDTO;
import fr.mika.worldvulcan.dto.country.CountryDeleteDTO;
import fr.mika.worldvulcan.dto.country.CountrySaveDTO;
import fr.mika.worldvulcan.dto.country.CountryUpdateDTO;
import fr.mika.worldvulcan.dto.earthquake.EarthquakeDTO;
import fr.mika.worldvulcan.dto.earthquake.EarthquakeDeleteDTO;
import fr.mika.worldvulcan.dto.earthquake.EarthquakeSaveDTO;
import fr.mika.worldvulcan.dto.earthquake.EarthquakeUpdateDTO;
import fr.mika.worldvulcan.entity.Earthquake;
import fr.mika.worldvulcan.service.EarthquakeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Earthquake Rest controller
 */
@RestController
@RequestMapping("/earthquakes")
public class EarthquakeController {
    private EarthquakeService service;

    public EarthquakeController(EarthquakeService service) {
        this.service = service;
    }

    /**
     * Find all earthquake in the DB
     * @return A list of countries with their info (Id, name, magnitude, location, date)
     */
    @GetMapping
    public List<EarthquakeDTO> findAll() {
        return this.service.findAll();
    }

    /**
     * Find a specific earthquake by its Id
     * @param id Earthquake's Id
     * @return The found country with its info (Id, name, magnitude, location, date)
     */
    @GetMapping("{id}")
    public ResponseEntity<EarthquakeDTO> getById(@PathVariable String id) {
        EarthquakeDTO earthquakeDTO = service.findById(id);
        ResponseEntity result;
        if (earthquakeDTO==EarthquakeDTO.NULL_EARTHQUAKEDTO)
            result = ResponseEntity.notFound().build();
        else
            result = ResponseEntity.ok(earthquakeDTO);
        return result;
    }

    /**
     * Add an earthquake in DB. Must provide this info : name, magnitude, location, date
     * @param earthquakeToSave The new earthquake to save
     * @return The earthquake info (Id, name, magnitude, location, date)
     */
    @PostMapping
    public ResponseEntity<EarthquakeDTO> save(@RequestBody EarthquakeSaveDTO earthquakeToSave) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(earthquakeToSave));
    }

    /**
     * Update an existing earthquake in the DB. At least the Id must be given.
     * @param earthquake The earthquake to update with its Id and the info to upate
     * @return The newly updated earthquake (Id, name, magnitude, location, date)
     */
    @PutMapping
    public ResponseEntity<EarthquakeDTO> updateById(@RequestBody EarthquakeUpdateDTO earthquake) {
        return ResponseEntity.ok(this.service.update(earthquake));
    }

    /**
     * Delete an earthquake in the DB. Id must be given.
     * @param earthquake The DTO with only the earthquake's Id to delete
     * @return Always true
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@RequestBody EarthquakeDeleteDTO earthquake) {
        this.service.deleteDyId(earthquake);
        return ResponseEntity.ok(true);
    }
}
