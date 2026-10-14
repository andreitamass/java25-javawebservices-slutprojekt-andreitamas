package se.gritacademy.java25javawebservicesslutprojekt.service;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.gritacademy.java25javawebservicesslutprojekt.model.Person;
import se.gritacademy.java25javawebservicesslutprojekt.model.Tools;
import se.gritacademy.java25javawebservicesslutprojekt.repository.ToolRepository;

import java.util.List;

@Service
@Transactional
public class ToolService {

    private final ToolRepository toolRepository;

    public ToolService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
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
        toolRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Tool with id " + id + " was not found"
                ));
        toolRepository.deleteById(id);
    }

}
