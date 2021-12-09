package fr.mika.worldvulcan.configuration;

import fr.mika.worldvulcan.repository.CountryRepository;
import fr.mika.worldvulcan.service.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountryConfiguration {
    @Bean
    public CountryService countryService(CountryRepository repository, ModelMapper mapper) {
        return new CountryService(repository, mapper);
    }
}
