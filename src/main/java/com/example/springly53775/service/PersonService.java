package com.example.springly53775.service;

import com.example.springly53775.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getPeople();

    Person getPerson(int id);

    void addPerson(Person person);

    void updatePerson(int id, String name, String lastname);

    void removePerson(int id);
}
