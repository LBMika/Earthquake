package fr.mika.worldvulcan.controller;

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
import java.util.List;

@RestController
@RequestMapping("/earthquakes")
public class EarthquakeController {
    private EarthquakeService service;

    public EarthquakeController(EarthquakeService service) {
        this.service = service;
    }

    @GetMapping
    public List<EarthquakeDTO> findAll() {
        return this.service.findAll();
    }

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

    @PostMapping
    public ResponseEntity<EarthquakeDTO> save(@RequestBody EarthquakeSaveDTO earthquakeToSave) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(earthquakeToSave));
    }

    @PutMapping
    public ResponseEntity<EarthquakeDTO> updateById(@RequestBody EarthquakeUpdateDTO earthquake) {
        return ResponseEntity.ok(this.service.update(earthquake));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@RequestBody EarthquakeDeleteDTO earthquake) {
        this.service.deleteDyId(earthquake);
        return ResponseEntity.ok(true);
    }
}
