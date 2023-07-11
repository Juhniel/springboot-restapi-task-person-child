package com.juhnkim.controller;

import com.juhnkim.entity.Person;
import com.juhnkim.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {

    private static final Logger LOGGER = LogManager.getLogger(PersonController.class);

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public List<Person> getPerson() {

        LOGGER.info("Received request to get all persons");

        try {
            return personService.findAll();
        } catch(Exception e) {
            LOGGER.error("Failed to retrieve persons: ", e);
            throw e;
        }
    }

    @PostMapping("/person")
    public String savePerson(@RequestBody Person person) {

        LOGGER.info("Received request to save person with SSN: " + person.getSsn());
        try {
            personService.save(person);
            return "Person was successfully saved!";
        } catch(Exception e) {
            LOGGER.error("Failed to save person: ", e);
            throw e;
        }
    }

    @GetMapping("/person/oldest")
    public Optional<Person> oldestChild() {
        LOGGER.info("Received request to get the person with the oldest child");

        try {
            return personService.findPersonWithOldestChild();
        } catch(Exception e) {
            LOGGER.error("Failed to find the person with the oldest child: ", e);
            throw e;
        }
    }
}
