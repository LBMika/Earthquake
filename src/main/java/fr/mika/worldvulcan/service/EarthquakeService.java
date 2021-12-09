package fr.mika.worldvulcan.service;

import fr.mika.worldvulcan.dto.country.CountryDTO;
import fr.mika.worldvulcan.dto.earthquake.EarthquakeDTO;
import fr.mika.worldvulcan.dto.earthquake.EarthquakeDeleteDTO;
import fr.mika.worldvulcan.dto.earthquake.EarthquakeSaveDTO;
import fr.mika.worldvulcan.dto.earthquake.EarthquakeUpdateDTO;
import fr.mika.worldvulcan.entity.Country;
import fr.mika.worldvulcan.entity.Earthquake;
import fr.mika.worldvulcan.repository.EarthquakeRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeService {
    private EarthquakeRepository repository;
    private ModelMapper mapper;

    public EarthquakeService(EarthquakeRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EarthquakeDTO> findAll() {
        List<EarthquakeDTO> result = new ArrayList<EarthquakeDTO>();
        this.repository.findAll().forEach(c -> result.add(this.mapper.map(c, EarthquakeDTO.class)));
        return result;
    }

    public EarthquakeDTO findById(String id) {
        Earthquake earthquake = this.repository.findById(id).orElse(Earthquake.NULL_EARTHQUAKE);
        EarthquakeDTO result;
        if (earthquake==Earthquake.NULL_EARTHQUAKE)
            result = EarthquakeDTO.NULL_EARTHQUAKEDTO;
        else
            result = this.mapper.map(earthquake, EarthquakeDTO.class);
        return result;
    }

    public EarthquakeDTO save(EarthquakeSaveDTO earthquakeToSave) {
        Earthquake earthquake = this.repository.save(this.mapper.map(earthquakeToSave, Earthquake.class));
        return this.mapper.map(earthquake, EarthquakeDTO.class);
    }

    public EarthquakeDTO update(EarthquakeUpdateDTO earthquakeToUpdate) {
        Earthquake earthquake = this.repository.save(this.mapper.map(earthquakeToUpdate, Earthquake.class));
        return this.mapper.map(earthquake, EarthquakeDTO.class);
    }

    public void deleteDyId(EarthquakeDeleteDTO earthquake) {
        this.repository.deleteById(earthquake.getId());
    }
}
