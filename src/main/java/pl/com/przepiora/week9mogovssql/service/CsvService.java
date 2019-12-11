package pl.com.przepiora.week9mogovssql.service;

import org.springframework.stereotype.Service;
import pl.com.przepiora.week9mogovssql.model.PersonMongo;
import pl.com.przepiora.week9mogovssql.model.PersonSql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CsvService {

  private static final String CSV_URL = "MOCK_DATA.csv";

  public List<PersonSql> getPersonSqlList() {
    return getStringArray().stream().map(array -> new PersonSql(array[0], array[1])).collect(
        Collectors.toList());
  }

  public List<PersonMongo> getPersonMongoList(){
    return getStringArray().stream().map(array -> new PersonMongo(array[0],array[1])).collect(
        Collectors.toList());
  }


  private List<String[]> getStringArray() {
    List<String[]> list = new ArrayList<>();
    String line = "";
    File file = new File(CSV_URL);
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
      while ((line = bufferedReader.readLine()) != null) {
        String[] splitLine = line.split(",");
        list.add(splitLine);
      }
      return list;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
