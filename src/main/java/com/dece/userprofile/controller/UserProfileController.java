package com.dece.userprofile.controller;

import com.dece.userprofile.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/v1")
public class UserProfileController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Person createUserProfile(Person person) {

        Person newPerson = new Person();
        // save to database here
        return  newPerson;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Person> getUserProfiles() {

        List<Person> personList = new ArrayList<>();
        Person newPerson = new Person();
        personList.add(newPerson);

        // save to database here
        return  personList;
    }
}
