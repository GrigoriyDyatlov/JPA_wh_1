package netology.ru.JPA_wh_1.controller;

import lombok.RequiredArgsConstructor;
import netology.ru.JPA_wh_1.person.Person;
import netology.ru.JPA_wh_1.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/by-city")
    public @ResponseBody List<Person> findAllByCityOfLiving(@RequestParam String city) {
        return personService.findAllByCityOfLiving(city);
    }

    @GetMapping("/byNameAndSurname")
    public @ResponseBody Optional<List<Person>> findByNameIgnoreCaseAndSurnameIgnoreCase(@RequestParam String name, @RequestParam String surname) {
        return personService.findByNameIgnoreCaseAndSurnameIgnoreCase(name, surname);
    }

    @GetMapping("/byAge")
    public @ResponseBody List<Person> findByAgeLessThanOrderByAgeAsc(@RequestParam Integer age) {
        return personService.findByAgeLessThanOrderByAgeAsc(age);
    }
}
