package at.refugeescode.mylisttodoUi.view;

import at.refugeescode.mylisttodoUi.model.Todo;
import at.refugeescode.mylisttodoUi.service.TodoGetter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class Endpoint {


    private TodoGetter todoGetter;

    private String id;

    public Endpoint(TodoGetter todoGetter) {
        this.todoGetter = todoGetter;
    }
    @GetMapping
    String get(){
        return "home";
    }
    @PostMapping("/{id}/done")
    public String markDone(@PathVariable String id) {
        todoGetter.updateToDone(id);
        return "redirect:/";
    }

    @PostMapping("/{id}/undone")
    public String markunDone(@PathVariable String id) {
        todoGetter.updateToUnDone(id);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id){
        todoGetter.delete(id);
        return "redirect:/";
    }

    @PostMapping("/addtasks")
    public String addtasks(Todo todo){
        todoGetter.addSentences(todo);
        return "redirect:/";
    }

    @ModelAttribute("todos")
    List<Todo> getToDo() {
        return todoGetter.getToDoList();
    }

    @ModelAttribute("todo")
    Todo getSomething(){
        return new Todo();
    }
}
