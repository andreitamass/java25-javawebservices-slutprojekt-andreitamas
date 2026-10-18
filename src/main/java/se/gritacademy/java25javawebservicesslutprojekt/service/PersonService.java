package se.gritacademy.java25javawebservicesslutprojekt.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import se.gritacademy.java25javawebservicesslutprojekt.model.Person;
import se.gritacademy.java25javawebservicesslutprojekt.model.Tools;
import se.gritacademy.java25javawebservicesslutprojekt.repository.PersonRepository;
import se.gritacademy.java25javawebservicesslutprojekt.repository.ToolRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class PersonService {

    private final ToolRepository toolRepository;

    private final PersonRepository personRepository; //Communicates with Database

    public PersonService(PersonRepository personRepository, ToolRepository toolRepository) { //Gets repo from constructor, Spring then takes information
        this.personRepository = personRepository;
        this.toolRepository = toolRepository;
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

    public Person addTool(Long personId, Long toolId) {
        Person person = findById(personId); //Gets person with id

        Tools tool = toolRepository.findById(toolId) // Gets tool with id
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tool with id " + toolId + " was not found"));

        person.getTools().add(tool); //adds tools to person list

        return personRepository.save(person); //saves
    }

    public Person update(Long id, Person updatePerson) {
        Person existingPerson = findById(id);

        existingPerson.setName(updatePerson.getName()); //Updates user from POST
        existingPerson.setPhoneNumber(updatePerson.getPhoneNumber());

        return personRepository.save(existingPerson);
    }

    public void deleteById(Long id) {
        Person person = findById(id);

        person.getTools().clear();

        personRepository.delete(person);
    }

}
