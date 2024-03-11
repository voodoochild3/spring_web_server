package com.stefan.internship_assignment.helloWorldMessage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class HelloWorldMessageConfig {
    @Bean
    CommandLineRunner commandLineRunner(HelloWorldMessageRepository repository) {
        return args -> {
            List<HelloWorldMessage> messageList = Arrays.asList(
                    new HelloWorldMessage("Serbian", "Zdravo Svete"),
                    new HelloWorldMessage("English", "Hello World"),
                    new HelloWorldMessage("Italian", "Ciao Mondo"),
                    new HelloWorldMessage("Macedonian", "Zdravo Svetu"),
                    new HelloWorldMessage("German", "Hallo Welt"),
                    new HelloWorldMessage("Finnish", "Hei Maailma"),
                    new HelloWorldMessage("French", "Bonjour le Monde"),
                    new HelloWorldMessage("Spanish", "Hola Mundo"),
                    new HelloWorldMessage("Esperanto", "Saluton Mondo"),
                    new HelloWorldMessage("Japanese", "Kon'nichiwa Sekai")
            );

            repository.saveAll(messageList);
        };
    }
}
