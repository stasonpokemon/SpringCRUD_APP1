package com.dao;

import com.pojo.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Jack","Willyams",24));
        people.add(new Person(++PEOPLE_COUNT, "Pol","Jons",22));
        people.add(new Person(++PEOPLE_COUNT, "Terry","Pettys",18));
        people.add(new Person(++PEOPLE_COUNT, "Katy","Maccol",21));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
