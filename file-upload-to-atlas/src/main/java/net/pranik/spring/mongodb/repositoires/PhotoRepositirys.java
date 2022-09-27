package net.pranik.spring.mongodb.repositoires;

import org.springframework.data.mongodb.repository.MongoRepository;
import net.pranik.spring.mongodb.modelss.PhotoModel;

public interface PhotoRepositirys extends MongoRepository<PhotoModel, String>
{

}
