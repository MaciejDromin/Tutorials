package pl.mlisowski.springtutorial.todos.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mlisowski.springtutorial.todos.application.port.ToDoRepository;
import pl.mlisowski.springtutorial.todos.domain.ToDo;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public List<ToDo> getAll() {
        log.debug("DEBUG!");
        log.info("Received getAll Todos request!");
        return toDoRepository.findAll();
    }

    public ToDo getByName(String name) {
        return toDoRepository.getToDoByName(name);
    }

}
