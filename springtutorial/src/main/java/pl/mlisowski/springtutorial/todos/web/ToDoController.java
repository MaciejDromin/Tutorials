package pl.mlisowski.springtutorial.todos.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mlisowski.springtutorial.todos.application.ToDoService;
import pl.mlisowski.springtutorial.todos.domain.ToDo;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping
    public List<ToDo> getAll() {
        return toDoService.getAll();
    }

}
