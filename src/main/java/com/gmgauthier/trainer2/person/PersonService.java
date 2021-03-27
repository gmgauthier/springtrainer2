package com.gmgauthier.trainer2.person;


import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    final private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        Optional<Person> personByEmail = personRepository.findPersonByEmail(person.getEmail());
        if (personByEmail.isPresent()){
            throw new InvalidRequestStateException("email address already exists");
        }
        personRepository.save(person);
    }

    public void deletePerson(String personEmail) {
        Optional<Person> person = personRepository.findPersonByEmail(personEmail);
        if (person.isEmpty()) {
            throw new EntityNotFoundException("Person does not exist in database");
        }
        personRepository.delete(person.get());
    }

    @Transactional
    public void updatePerson(String personEmail, String name, String email) {
        Optional<Person> person = personRepository.findPersonByEmail(personEmail);
        if (person.isEmpty()) {
            throw new EntityNotFoundException("Person does not exist in database");
        }
        //update name per requirement
        if (!(name==null) && !name.isBlank() && !name.equals(person.get().getName())){
            person.get().setName(name);
        }
        //update email address per requirement
        if (!(email==null) && !email.isBlank() && !email.equals(person.get().getEmail())){
            person.get().setEmail(email);
        }
    }

    // Original delete method. But who knows what the id's are??
    //    public void deletePerson(Long personId) {
    //        boolean exists = personRepository.existsById(personId);
    //        if (!exists){
    //            throw new EntityNotFoundException("Person does not exist in database");
    //        }
    //        personRepository.deleteById(personId);
    //    }
}
