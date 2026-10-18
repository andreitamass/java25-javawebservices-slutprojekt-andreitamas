package se.gritacademy.java25javawebservicesslutprojekt.service;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.gritacademy.java25javawebservicesslutprojekt.model.Person;
import se.gritacademy.java25javawebservicesslutprojekt.model.Tools;
import se.gritacademy.java25javawebservicesslutprojekt.repository.PersonRepository;
import se.gritacademy.java25javawebservicesslutprojekt.repository.ToolRepository;

import java.util.List;

@Service
@Transactional
public class ToolService {

    private final ToolRepository toolRepository;
    private final PersonRepository personRepository;

    public ToolService(ToolRepository toolRepository,  PersonRepository personRepository) {
        this.toolRepository = toolRepository;
        this.personRepository = personRepository;
    }

    public List<Tools> listAll()  {
        return toolRepository.findAll();
    }

    public Tools findById(Long id) {
        return toolRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Tools with id " + id + " was not found"
                        ));
    }

    public Tools save(Tools tools) {
        return toolRepository.save(tools);
    }

    public Tools update(Long id, Tools updatedTools) {
        Tools existingTools = findById(id);

        existingTools.setToolsName(updatedTools.getToolsName());
        existingTools.setToolsDescription(updatedTools.getToolsDescription());

        return toolRepository.save(existingTools);
    }

    public void deleteById(Long id) {
        Tools tool = findById(id); //Checks if tool exists

        for (Person person : personRepository.findAll()) { //Checks for users in list
            if (person.getTools().contains(tool)) { //Checks if specific user has specific tool
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT, //Throws 409 if tool is linked with user
                        "Cannot delete tool due to it being borrowed to user"
                );
            }
        }
        toolRepository.delete(tool);
    }

}
