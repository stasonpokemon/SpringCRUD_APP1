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
        people.add(new Person(++PEOPLE_COUNT, "Jack","Willyams",24,"qwqqq@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Pol","Jons",22,"123ddqqwd@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Terry","Pettys",18,"vvvs123@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy","Maccol",21,"eqwqw1@icloud.com"));
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

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setSurname(person.getSurname());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());

    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
