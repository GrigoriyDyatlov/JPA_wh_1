package netology.ru.JPA_wh_1.controller;

import lombok.RequiredArgsConstructor;
import netology.ru.JPA_wh_1.service.PersonService;
import netology.ru.JPA_wh_1.person.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/by-city")
    public List<Person> getPersonByCity(@RequestParam String city){
        return personService.getPersonsByCity(city);
    }
}
