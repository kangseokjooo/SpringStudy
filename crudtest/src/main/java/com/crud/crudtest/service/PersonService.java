package com.crud.crudtest.service;

import com.crud.crudtest.domain.Person;
import com.crud.crudtest.domain.PersonEntity;
import com.crud.crudtest.dto.PersonDTO;
import com.crud.crudtest.mapper.PersonMapper;
import com.crud.crudtest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private PersonRepository personRepository;

    public void insertPerson(PersonDTO personDTO){
        PersonEntity person=new PersonEntity();
        person.setUserid(personDTO.getUserid());
        person.setPassword(personDTO.getPassword());
        person.setName(personDTO.getName());
        personRepository.save(person);
        //personMapper.insertPerson(person);
    }
    //Login
    public PersonDTO getPerson(PersonDTO personDTO){
       Optional<PersonEntity> person=personRepository.findByUseridAndPassword(personDTO.getUserid(),personDTO.getPassword());

       PersonDTO data=new PersonDTO();

       data.setId( person.get().getId());

       return data;

    }

    public PersonDTO getPersonData(long id){
//        Person person=personMapper.getPersonData(id);
        Optional<PersonEntity> person=personRepository.findById(id);
        PersonDTO data=new PersonDTO();


        data.setUserid(person.get().getUserid());
        data.setPassword(person.get().getPassword());
        data.setName(person.get().getName());

        return data;

    }
    public void updatePerson(PersonDTO personDTO){
        PersonEntity person=personRepository.findByUserid(personDTO.getUserid());
//        person.setUserid(personDTO.getUserid());
        person.setPassword(personDTO.getPassword());
        person.setName(personDTO.getName());

        personRepository.save(person);
    }
    public void deletePerson(PersonDTO personDTO){
        personRepository.deleteByUserid(personDTO.getUserid());
//        personMapper.deletePerson(personDTO.getUserid());
    }
}
