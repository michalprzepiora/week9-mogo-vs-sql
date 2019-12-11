package pl.com.przepiora.week9mogovssql.service;

import org.springframework.stereotype.Service;
import pl.com.przepiora.week9mogovssql.model.PersonMongo;
import pl.com.przepiora.week9mogovssql.model.PersonSql;
import pl.com.przepiora.week9mogovssql.repository.PersonMongoRepository;
import pl.com.przepiora.week9mogovssql.repository.PersonSqlRepository;

import java.util.List;

@Service
public class PersonService {

  private PersonSqlRepository personSqlRepository;
  private PersonMongoRepository personMongoRepository;

  public PersonService(PersonSqlRepository personSqlRepository,
      PersonMongoRepository personMongoRepository) {
    this.personSqlRepository = personSqlRepository;
    this.personMongoRepository = personMongoRepository;
  }

  public void saveToH2(List<PersonSql> list) {
    personSqlRepository.saveAll(list);
  }

  public List<PersonSql> readFromH2() {
    return personSqlRepository.findAll();
  }

  public void saveToMongo(List<PersonMongo> list) {
    personMongoRepository.saveAll(list);
  }

  public List<PersonMongo> readFromMongo() {
    return personMongoRepository.findAll();
  }
}
