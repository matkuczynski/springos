package pl.akademiakodu.springos.Dao;

import pl.akademiakodu.springos.Model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz Kuczyński on 31.07.2017.
 */
public class PersonDaoImpl implements PersonDao{

    static List<Person> people = new ArrayList<>();
    static {
        people.add(new Person(1L,"Adam", "Kowalski"));
        people.add(new Person(2L,"Adam", "Nakładam"));
        people.add(new Person(3L,"Jurek", "Ogórek"));
        people.add(new Person(4L,"Madam", "Kowalski"));
        people.add(new Person(5L,"Adrian", "Kowalski"));
    }
    public List<Person> findAll() {
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person("Maniek","Zguba"));
        persons1.add(new Person("Michał","Makarug"));
        persons1.add(new Person("a","a"));
        return persons1;

    }

    @Override
    public List<Person> findBySurname(String surname) {
        List<Person> results = new ArrayList<>();
        for (Person person:people){
            if(person.getSurname().equals(surname))
                results.add(person);
        }
        return results;
    }

    @Override
    public List<Person> findById(Long id) {
        List<Person> results = new ArrayList<>();
        for (Person person:people){
            if(person.getId().equals(id))
                results.add(person);
        }
        return results;
    }

    public List<Person> findAllPeople(){
        return people;
    }
}
