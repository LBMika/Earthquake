package fr.mika.worldvulcan.service;

import fr.mika.worldvulcan.dto.country.CountryDTO;
import fr.mika.worldvulcan.dto.country.CountryDeleteDTO;
import fr.mika.worldvulcan.dto.country.CountrySaveDTO;
import fr.mika.worldvulcan.dto.country.CountryUpdateDTO;
import fr.mika.worldvulcan.entity.Country;
import fr.mika.worldvulcan.repository.CountryRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryService {
    private CountryRepository repository;
    private ModelMapper mapper;

    public CountryService(CountryRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CountryDTO> findAll() {
        List<CountryDTO> result = new ArrayList<CountryDTO>();
        this.repository.findAll().forEach(c -> result.add(this.mapper.map(c, CountryDTO.class)));
        return result;
    }

    public CountryDTO findById(String id) {
        Country country = this.repository.findById(id).orElse(Country.NULL_COUNTRY);
        CountryDTO result;
        if (country==Country.NULL_COUNTRY)
            result = CountryDTO.NULL_COUNTRYDTO;
        else
            result = this.mapper.map(country, CountryDTO.class);
        return result;
    }

    public CountryDTO save(CountrySaveDTO countryDTO) {
        Country country = this.repository.save(this.mapper.map(countryDTO, Country.class));
        return this.mapper.map(country, CountryDTO.class);
    }

    public CountryDTO update(CountryUpdateDTO countryToUpdate) {
        Country country = this.repository.save(this.mapper.map(countryToUpdate, Country.class));
        return this.mapper.map(country, CountryDTO.class);
    }

    public void deleteDyId(CountryDeleteDTO country) {
        this.repository.deleteById(country.getId());
    }
}
