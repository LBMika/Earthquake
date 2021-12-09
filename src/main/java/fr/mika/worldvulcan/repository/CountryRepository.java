package fr.mika.worldvulcan.repository;

import fr.mika.worldvulcan.entity.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository extends MongoRepository<Country, String> {
}
