package com.juhnkim.controller;

import com.juhnkim.entity.Person;
import com.juhnkim.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public List<Person> getPerson() {
        return personService.findAll();
    }
    @PostMapping("/person")
    public String savePerson(@RequestBody Person person) {
        personService.save(person);
        return "Person has been saved";
    }

    @GetMapping("/person/oldest")
    public Optional<Person> oldestChild() {
        return personService.findPersonWithOldestChild();
    }
}
