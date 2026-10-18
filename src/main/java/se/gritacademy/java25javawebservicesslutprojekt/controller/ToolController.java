package se.gritacademy.java25javawebservicesslutprojekt.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import se.gritacademy.java25javawebservicesslutprojekt.model.Tools;
import se.gritacademy.java25javawebservicesslutprojekt.service.ToolService;

import java.util.List;

@RestController
@RequestMapping("/api/tools")
public class ToolController {

    private final ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @GetMapping
    public List<Tools> getAllTools() {
        return toolService.listAll();
    }

    @GetMapping("/{id}")
    public Tools getToolById(@PathVariable Long id) {
        return toolService.findById(id);
    }

    @PostMapping
    public Tools saveTool(@Valid @RequestBody Tools tools) {
        return toolService.save(tools);
    }

    @PutMapping("/{id}")
    public Tools updateTool(@PathVariable Long id, @Valid @RequestBody Tools tools) {
        return toolService.update(id, tools);
    }

    @DeleteMapping("/{id}")
    public void deleteToolById(@PathVariable Long id) {
        toolService.deleteById(id);
    }
}
