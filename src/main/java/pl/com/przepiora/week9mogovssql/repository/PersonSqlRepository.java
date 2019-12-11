package pl.com.przepiora.week9mogovssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.przepiora.week9mogovssql.model.PersonSql;

@Repository
public interface PersonSqlRepository extends JpaRepository<PersonSql, Long> {

}
