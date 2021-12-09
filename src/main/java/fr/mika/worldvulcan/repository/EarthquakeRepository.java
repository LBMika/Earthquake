package fr.mika.worldvulcan.repository;

import fr.mika.worldvulcan.entity.Earthquake;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EarthquakeRepository extends MongoRepository<Earthquake, String> {
}
