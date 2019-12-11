package pl.com.przepiora.week9mogovssql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.przepiora.week9mogovssql.model.PersonSql;
import pl.com.przepiora.week9mogovssql.repository.PersonSqlRepository;
import pl.com.przepiora.week9mogovssql.service.CsvService;
import pl.com.przepiora.week9mogovssql.service.PersonService;

import java.util.List;

@RestController
public class Api {

  private final PersonService personService;
  @Autowired
  private CsvService csvService;

  @Autowired
  public Api(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping("/xxx")
  public void test() {
    List<PersonSql> personSqlList;
    personSqlList = csvService.getPersonSqlList();
    personService.saveToH2(personSqlList);


  }

}
