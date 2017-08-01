package pl.kurs2.springos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kurs2.springos.model.Person;


@Controller
public class PersonController {

    private PersonDao personDao = new PersonDao();

    @GetMapping("/personadd")
    public String getPersons(ModelMap modelMap, PersonDao personDao){
        modelMap.addAttribute("persons", personDao.findAll());
        return "person";
    }

    @PostMapping("/person")
    public String addPersonFromPerson(@ModelAttribute ModelMap modelMap, Person person) {
        System.out.println(person);
        modelMap.addAttribute("person", person);
        return "person";

    }


    @GetMapping("/person/search")
    public String search(){
        return "person/search";
    }

    @GetMapping("/person/results")
    public String results(@ModelAttribute Person person, ModelMap modelMap){
        System.out.println("Parameter " + person.getSurname());
        String surname = person.getSurname();
        modelMap.addAttribute("people",personDao.findBySurname(surname));
        return "person/results";
    }
}
