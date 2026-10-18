package se.gritacademy.java25javawebservicesslutprojekt.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.gritacademy.java25javawebservicesslutprojekt.model.Person;
import se.gritacademy.java25javawebservicesslutprojekt.model.Tools;
import se.gritacademy.java25javawebservicesslutprojekt.repository.PersonRepository;
import se.gritacademy.java25javawebservicesslutprojekt.repository.ToolRepository;

@Service
@Transactional
public class BorrowService {

    private final PersonRepository personRepository;
    private final ToolRepository toolRepository;

    public  BorrowService(PersonRepository personRepository, ToolRepository toolRepository) {
        this.personRepository = personRepository;
        this.toolRepository = toolRepository;
    }

    public void rentTool(Long personId, Long toolId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() ->
                        new RuntimeException("Person not found"));

        Tools tool = toolRepository.findById(toolId)
                .orElseThrow(() ->
                        new RuntimeException("Tool not found"));

        person.getTools().add(tool);

        personRepository.save(person);
    }


}
