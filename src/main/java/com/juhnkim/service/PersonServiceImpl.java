package com.juhnkim.service;

import com.juhnkim.entity.Person;
import com.juhnkim.repository.PersonRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    private static final Logger LOGGER = LogManager.getLogger(PersonServiceImpl.class);

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person save(Person person) {
        personRepository.save(person);
        LOGGER.info("Saving person with SSN: {}", person.getSsn());

        return person;
    }

    @Override
    public Optional<Person> findPersonWithOldestChild() {
        return personRepository.findPersonWithOldestChild();
    }
}
