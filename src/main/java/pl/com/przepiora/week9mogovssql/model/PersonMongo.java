package pl.com.przepiora.week9mogovssql.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PersonMongo {
  @Id
  private String id;
  private String name;
  private String surname;

  public PersonMongo(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public PersonMongo() {
  }

  @Override
  public String toString() {
    return "PersonMongo{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        '}';
  }
}
