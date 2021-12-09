package fr.mika.worldvulcan.configuration;

import fr.mika.worldvulcan.repository.EarthquakeRepository;
import fr.mika.worldvulcan.service.EarthquakeService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EarthquakeConfiguration {
    @Bean
    public EarthquakeService vulcanService(EarthquakeRepository repository, ModelMapper mapper) {
        return new EarthquakeService(repository, mapper);
    }
}
