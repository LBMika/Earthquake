package fr.mika.worldvulcan.controller;

import fr.mika.worldvulcan.dto.country.CountryDTO;
import fr.mika.worldvulcan.dto.country.CountryDeleteDTO;
import fr.mika.worldvulcan.dto.country.CountrySaveDTO;
import fr.mika.worldvulcan.dto.country.CountryUpdateDTO;
import fr.mika.worldvulcan.service.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Country Rest controller
 */
@RestController
@RequestMapping("/countries")
public class CountryController {
    private CountryService service;
    private ModelMapper mapper;

    public CountryController(CountryService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    /**
     * Find all countries in the DB
     * @return A list of countries with their info (id, name, code)
     */
    @GetMapping
    public List<CountryDTO> findAll() {
        return service.findAll();
    }

    /**
     * Find a country by its DB Id
     * @param id DB Id
     * @return A country with its info (id, name, code)
     */
    @GetMapping("{id}")
    public ResponseEntity<CountryDTO> getById(@PathVariable String id) {
        CountryDTO countryDTO = service.findById(id);
        ResponseEntity result;
        if (countryDTO==CountryDTO.NULL_COUNTRYDTO)
            result = ResponseEntity.notFound().build();
        else
            result = ResponseEntity.ok(countryDTO);
        return result;
    }

    /**
     * Save a new country in the DB
     * @param countryDTO Info of the country to save (name, code)
     * @return The saved country with its info (id, name, code)
     */
    @PostMapping
    public ResponseEntity<CountryDTO> save(@RequestBody CountrySaveDTO countryDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(countryDTO));
    }

    /**
     * Update an existing country in DB. The country's Id must be given.
     * @param country Country's info with its Id and the info to update
     * @return The country info after the update (id, name, code)
     */
    @PutMapping
    public ResponseEntity<CountryDTO> updateById(@RequestBody CountryUpdateDTO country) {
        return ResponseEntity.ok(this.service.update(country));
    }

    /**
     * Delete a country in the DB by its Id.
     * @param country DTO with only the country's Id
     * @return Always true
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@RequestBody CountryDeleteDTO country) {
        this.service.deleteDyId(country);
        return ResponseEntity.ok(true);
    }
}
