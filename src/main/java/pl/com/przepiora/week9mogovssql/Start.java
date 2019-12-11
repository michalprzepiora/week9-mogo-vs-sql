package pl.com.przepiora.week9mogovssql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.com.przepiora.week9mogovssql.model.PersonMongo;
import pl.com.przepiora.week9mogovssql.model.PersonSql;
import pl.com.przepiora.week9mogovssql.service.CsvService;
import pl.com.przepiora.week9mogovssql.service.PersonService;

import java.util.List;

@Component
public class Start {

  private final CsvService csvService;
  private final PersonService personService;

  List<PersonSql> personSqlList;
  List<PersonMongo> personMongoList;

  @Autowired
  public Start(CsvService csvService,
      PersonService personService) {
    this.csvService = csvService;
    this.personService = personService;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void init() {
//    personSqlList = csvService.getPersonSqlList();
//    personMongoList = csvService.getPersonMongoList();

//    personService.saveToH2(personSqlList);
//    personService.readFromH2();
//    personService.saveToMongo(personMongoList);
//    personService.readFromMongo();

  }


}
