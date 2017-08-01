package pl.akademiakodu.springos.Dao;

import pl.akademiakodu.springos.Model.Person;

import java.util.List;

/**
 * Created by Mateusz Kuczyński on 31.07.2017.
 */
public interface PersonDao {

    List<Person> findAllPeople();

    List<Person> findById(Long id);

    List<Person> findBySurname(String surname);

}
