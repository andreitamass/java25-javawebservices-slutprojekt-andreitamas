package se.gritacademy.java25javawebservicesslutprojekt.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.gritacademy.java25javawebservicesslutprojekt.service.BorrowService;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping("/{personId}/tools/{toolId}")
    public void rentTool(@PathVariable Long personId,
                         @PathVariable Long toolId) {
        borrowService.rentTool(personId, toolId);
    }

}
