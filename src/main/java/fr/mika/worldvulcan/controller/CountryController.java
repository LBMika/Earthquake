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

@RestController
@RequestMapping("/countries")
public class CountryController {
    private CountryService service;
    private ModelMapper mapper;

    public CountryController(CountryService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CountryDTO> findAll() {
        return service.findAll();
    }

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

    @PostMapping
    public ResponseEntity<CountryDTO> save(@RequestBody CountrySaveDTO countryDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(countryDTO));
    }

    @PutMapping
    public ResponseEntity<CountryDTO> updateById(@RequestBody CountryUpdateDTO country) {
        return ResponseEntity.ok(this.service.update(country));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@RequestBody CountryDeleteDTO country) {
        this.service.deleteDyId(country);
        return ResponseEntity.ok(true);
    }
}
