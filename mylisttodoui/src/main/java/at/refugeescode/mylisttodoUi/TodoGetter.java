package at.refugeescode.mylisttodoUi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoGetter {
    private String task;

    private RestTemplate restTemplate;

    public TodoGetter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${mylistToDO.url}")
    private String myListToDoURL;


    public List<Todo> getToDoList(){
        return Arrays.asList(restTemplate.getForObject(myListToDoURL, Todo[].class));
    }
    public void updateToDone(String id){
        restTemplate.put(myListToDoURL + "/" + id + "/done", Todo.class);
    }

    public void updateToUnDone(String id){
        restTemplate.put(myListToDoURL + "/" + id + "/undone", Todo.class);
    }

    public void delete(String id){
        restTemplate.delete(myListToDoURL+"/"+ id + "/delete");
    }

    public void addSentences(Todo todo){
        this.task = todo.getTask();
        restTemplate.postForObject(myListToDoURL + "/addtasks", task, String.class);
    }
}
