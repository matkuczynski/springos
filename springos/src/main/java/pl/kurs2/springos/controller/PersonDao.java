package pl.kurs2.springos.controller;

import pl.kurs2.springos.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDao implements pl.kurs2.springos.controller.dao.PersonDao{

    private static List<Person> people =new ArrayList<>();

    static {
        people.add(new Person("Adam","Kowalski"));
        people.add(new Person("Józiek","Kowalski"));
        people.add(new Person("Zenek","Kowalski"));
        people.add(new Person("Zosia","Kowalska"));

    }

    public List<Person> findAll() {
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person("kuba","rozruba"));
        persons1.add(new Person("Michał","Makarug"));
        persons1.add(new Person("a","a"));
        return persons1;

    }

    @Override
    public List<Person> findBySurname(String surname) {
        List<Person> results = new ArrayList<>();
        for (Person person:people){
            if(person.getSurname().equals(surname))
                people.add(person);
        }
        return results;
    }
}
