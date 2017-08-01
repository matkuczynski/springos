package pl.akademiakodu.springos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.springos.Dao.PersonDaoImpl;
import pl.akademiakodu.springos.Model.Person;

/**
 * Created by Mateusz Kuczyński on 28.07.2017.
 */
@Controller
public class PersonController {

    private PersonDaoImpl personDaoImpl = new PersonDaoImpl();

    @GetMapping("/personadd")
    public String getPersons(ModelMap modelMap, PersonDaoImpl personDaoImpl) {
        modelMap.addAttribute("persons", personDaoImpl.findAll());
        return "person";
    }

    @PostMapping("/person")
    public String addPersonFromPerson(@ModelAttribute ModelMap modelMap, Person person) {
        System.out.println(person);
        modelMap.addAttribute("person", person);
        return "person";

    }


    @GetMapping("/person/search")
    public String search() {
        return "person/search";
    }

    @GetMapping("/person/results")
    public String results(@ModelAttribute Person person, ModelMap modelMap) {
        System.out.println("Parameter " + person.getSurname());
        String surname = person.getSurname();
        modelMap.addAttribute("people", personDaoImpl.findBySurname(surname));
        return "person/results";
    }

    @GetMapping("/person/displayAll")
    public String displayAll(ModelMap modelMap) {
        modelMap.addAttribute("people", personDaoImpl.findAllPeople());
            return "person/displayAll";

    }


    @GetMapping("/person/{id}")
    public String display(@PathVariable Long id, ModelMap modelMap){
        System.out.println("Moje id to: "+id);
        modelMap.addAttribute("people", personDaoImpl.findById(id));
        return "person/displayById";
    }
}
