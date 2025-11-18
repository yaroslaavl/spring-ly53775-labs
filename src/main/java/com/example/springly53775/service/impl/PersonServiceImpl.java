package com.example.springly53775.service.impl;

import com.example.springly53775.entity.Person;
import com.example.springly53775.service.PersonService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private List<Person> people;

    @PostConstruct
    public void init(){
        people = new ArrayList<>();
        people.add(new Person("Jan", "Kowalski"));
        people.add(new Person("Anna", "Nowak"));
    }

    @Override
    public List<Person> getPeople() {
        return people;
    }

    @Override
    public Person getPerson(int id) {
        return people.get(id);
    }

    @Override
    public void addPerson(Person person) {
        people.add(person);
    }

    @Override
    public void updatePerson(int id, String name, String lastname) {
        Person person = people.get(id);
        person.setFirstName(name);
        person.setLastName(lastname);

    }

    @Override
    public void removePerson(int id) {
        people.remove(id);
    }
}
