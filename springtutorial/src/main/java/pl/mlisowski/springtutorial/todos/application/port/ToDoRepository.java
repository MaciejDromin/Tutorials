package pl.mlisowski.springtutorial.todos.application.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mlisowski.springtutorial.todos.domain.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    ToDo getToDoByName(String name);

}
