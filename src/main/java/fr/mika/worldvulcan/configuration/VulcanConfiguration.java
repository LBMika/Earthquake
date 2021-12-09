package fr.mika.worldvulcan.configuration;

import fr.mika.worldvulcan.repository.VulcanRepository;
import fr.mika.worldvulcan.service.VulcanService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VulcanConfiguration {
    @Bean
    public VulcanService vulcanService(VulcanRepository repository, ModelMapper mapper) {
        return new VulcanService(repository, mapper);
    }
}
