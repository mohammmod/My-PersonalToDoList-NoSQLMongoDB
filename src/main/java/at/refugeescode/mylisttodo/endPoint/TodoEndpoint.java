package at.refugeescode.mylisttodo.endPoint;

import at.refugeescode.mylisttodo.model.Todo;
import at.refugeescode.mylisttodo.persistence.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/todos")
@RestController
public class TodoEndpoint {
    private Repository repository;
    @PostMapping
    Todo addTodo(@RequestBody Todo todo){
        repository.save(todo);
        return todo;
    }

    @GetMapping
    List<Todo> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Todo findById(@PathVariable String id){
        return repository.findById(id).get();
    }

    @PutMapping("/{id}/done")
    Todo makeDone(@PathVariable String id){
        Todo todo = repository.findById(id).get();
        todo.setDone(true);
        return todo;
    }



}
