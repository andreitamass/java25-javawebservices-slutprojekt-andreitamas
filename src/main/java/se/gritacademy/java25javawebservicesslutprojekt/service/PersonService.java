package se.gritacademy.java25javawebservicesslutprojekt.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import se.gritacademy.java25javawebservicesslutprojekt.model.Person;
import se.gritacademy.java25javawebservicesslutprojekt.repository.PersonRepository;

import java.util.List;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository; //Communicates with Database

    public PersonService(PersonRepository personRepository) { //Gets repo from constructor, Spring then takes information
        this.personRepository = personRepository;
    }

    public List<Person> listAll() { //Lists all users from list
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Person with id " + id + " was not found"
                        ));
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person update(Long id, Person updatePerson) { //Takes ID on current user to update
        Person existingPerson = findById(id); //Finds user

        existingPerson.setName(updatePerson.getName());
        existingPerson.setPhoneNumber(updatePerson.getPhoneNumber());

        return personRepository.save(existingPerson); //Saves the update
    }

    public void deleteById(Long id) {
        personRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Person with id " + id + " was not found"));
        personRepository.deleteById(id);
    }

}
