package fr.mika.worldvulcan.repository;

import fr.mika.worldvulcan.entity.Country;
import fr.mika.worldvulcan.entity.Vulcan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VulcanRepository extends MongoRepository<Vulcan, String> {
}
