package com.crud.crudtest.service;

import com.crud.crudtest.domain.Person;
import com.crud.crudtest.dto.PersonDTO;
import com.crud.crudtest.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonMapper personMapper;

    public void insertPerson(PersonDTO personDTO){
        Person person=new Person();
        person.setUser_id(personDTO.getUser_id());
        person.setPassword(personDTO.getPassword());
        person.setName(personDTO.getName());

        personMapper.insertPerson(person);
    }
    //Login
    public PersonDTO getPerson(PersonDTO personDTO){
       Person person=personMapper.getPerson(personDTO.getUser_id(),personDTO.getPassword());

       PersonDTO data=new PersonDTO();

       data.setId( person.getId() );

       return data;

    }

    public PersonDTO getPersonData(long id){
        Person person=personMapper.getPersonData(id);
        PersonDTO data=new PersonDTO();

        data.setUser_id(person.getUser_id());
        data.setPassword(person.getPassword());
        data.setName(person.getName());
        return  data;
    }
    public void updatePerson(PersonDTO personDTO){
        Person person=new Person();
        person.setUser_id(personDTO.getUser_id());
        person.setPassword(personDTO.getPassword());
        person.setName(personDTO.getName());

        personMapper.updatePerson(person);
    }
    public void deletePerson(PersonDTO personDTO){
        personMapper.deletePerson(personDTO.getUser_id());
    }
}
