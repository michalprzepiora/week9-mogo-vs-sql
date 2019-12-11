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

  @Autowired
  public Start(CsvService csvService,
      PersonService personService) {
    this.csvService = csvService;
    this.personService = personService;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void init() {
    List<PersonSql> personSqlList = csvService.getPersonSqlList();
    List<PersonMongo> personMongoList = csvService.getPersonMongoList();

    System.out.println("Wait 5 sec.");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    personService.saveToH2(personSqlList);
    personService.readFromH2();
    personService.saveToMongo(personMongoList);
    personService.readFromMongo();

  }


}
