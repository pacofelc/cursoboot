package com.cuatro.cursoboot.service.impl;

import com.cuatro.cursoboot.model.Person;
import com.cuatro.cursoboot.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService
{
  @Override
  public List<Person> getListPeople() {
    List<Person> people =new ArrayList<Person>();

    people.add(new Person("pepe",40));
    people.add(new Person("paco",41));
    people.add(new Person("pepa",42));

    return people;
  }
}
