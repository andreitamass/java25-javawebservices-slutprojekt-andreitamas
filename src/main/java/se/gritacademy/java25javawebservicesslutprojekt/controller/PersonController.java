package se.gritacademy.java25javawebservicesslutprojekt.controller;

import org.springframework.web.bind.annotation.*;
import se.gritacademy.java25javawebservicesslutprojekt.model.Person;
import se.gritacademy.java25javawebservicesslutprojekt.repository.PersonRepository;
import se.gritacademy.java25javawebservicesslutprojekt.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/person") //Adress controller uses
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping //GET method to show all users
    public List<Person> listAll() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping //POST method to create user
    public Person create(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping("/{id}") //PUT method to update user
    public Person update(
            @PathVariable Long id,
            @RequestBody Person person) {
        return personService.update(id, person);
    }

    @DeleteMapping("/{id}") //DELETE method to delete user
    public void delete(@PathVariable Long id) {
        personService.deleteById(id);
    }





}
