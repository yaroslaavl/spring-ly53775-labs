package com.example.springly53775.controller;

import com.example.springly53775.entity.Person;
import com.example.springly53775.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PeopleController {

    private final PersonService personService;

    @GetMapping("/people")
    public String showPeople(Model model) {
        model.addAttribute("people", personService.getPeople());
        return "people-list";
    }

    @GetMapping("/people/add")
    public String showAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "add-person";
    }

    @PostMapping("/people/add")
    public String addPerson(Person person) {
        personService.addPerson(person);
        return "redirect:/people";
    }
}
