package at.refugeescode.mylisttodoUi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Initilaizer {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
