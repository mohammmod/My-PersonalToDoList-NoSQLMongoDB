package at.refugeescode.mylisttodo.initialize;

import at.refugeescode.mylisttodo.model.Todo;
import at.refugeescode.mylisttodo.persistence.Repository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class Initializer {
    @Bean
    ApplicationRunner applicationRunner(Repository repository){
        return args -> {
            repository.deleteAll();
            List<Todo> repositories = creatTaskes();

            System.out.println("tasks that we have to do ");

            repositories.stream()
                    .forEach(element -> System.out.println(element.getTask() +" "+ element.getDone()));
            repository.saveAll(repositories);
        };
    }

    private List<Todo> creatTaskes() {
        return Stream.of(
                new Todo("doing deshes",false),
                new Todo("Coding",false),
                new Todo("take Shower", false),
                new Todo("samoo", false)

        ).collect(Collectors.toList());
    }
}
