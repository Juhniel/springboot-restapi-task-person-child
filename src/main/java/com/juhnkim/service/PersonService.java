package com.juhnkim.service;

import com.juhnkim.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PersonService {

    List<Person> findAll();

    Person save(Person person);

    Optional<Person> findPersonWithOldestChild();
}
