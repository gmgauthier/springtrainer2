package com.gmgauthier.trainer2.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @PostMapping("/person")
    public void addNewPerson(@RequestBody Person person){
        personService.addNewPerson(person);
    }

    @DeleteMapping(path = "/person/{personEmail}")
    public void deletePerson(@PathVariable("personEmail") String personEmail){
        personService.deletePerson(personEmail);
    }

    @PutMapping(path = "/person/{personEmail}")
    public void updatePerson(
            @PathVariable("personEmail") String personEmail,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        personService.updatePerson(personEmail, name, email);
    }


}
