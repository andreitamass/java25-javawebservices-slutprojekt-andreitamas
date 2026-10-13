package se.gritacademy.java25javawebservicesslutprojekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.gritacademy.java25javawebservicesslutprojekt.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}

//CRUD interface, instead of DAO