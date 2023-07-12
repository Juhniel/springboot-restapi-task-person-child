package com.juhnkim;

import com.juhnkim.entity.Person;
import com.juhnkim.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private PersonService personService;

    public Application(PersonService personService) {
        this.personService = personService;
    }


    @Bean
    public Supplier<List<Person>> findAll() {
        return () -> personService.findAll();
    }

    @Bean
    public Function<Person, Person> save() {
        return input -> personService.save(input);
    }

    @Bean
    public Supplier<Optional<Person>> findOldestChild() {
        return () -> personService.findPersonWithOldestChild();
    }
}
