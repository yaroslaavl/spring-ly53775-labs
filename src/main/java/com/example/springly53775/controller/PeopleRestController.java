package com.example.springly53775.controller;

import com.example.springly53775.entity.Person;
import com.example.springly53775.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PeopleRestController {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getPeople() {
        return ResponseEntity.ok(personService.getPeople());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        try {
            return ResponseEntity.ok(personService.getPerson(id));
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable int id,
                                             @RequestParam String firstName,
                                             @RequestParam String lastName) {
        try {
            personService.updatePerson(id,  firstName, lastName);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePerson(@PathVariable int id) {
        try {
            personService.removePerson(id);
            return ResponseEntity.ok().build();
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
