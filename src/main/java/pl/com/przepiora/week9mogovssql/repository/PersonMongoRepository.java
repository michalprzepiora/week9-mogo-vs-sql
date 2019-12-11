package pl.com.przepiora.week9mogovssql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.com.przepiora.week9mogovssql.model.PersonMongo;

@Repository
public interface PersonMongoRepository extends MongoRepository<PersonMongo,String> {

}
