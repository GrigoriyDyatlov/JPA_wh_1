package netology.ru.JPA_wh_1.controller;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import netology.ru.JPA_wh_1.person.Person;
import netology.ru.JPA_wh_1.service.PersonService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/by-city")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public @ResponseBody List<Person> findAllByCityOfLiving(@RequestParam String city) {
        return personService.findAllByCityOfLiving(city);
    }

    @GetMapping("/byNameAndSurname")
    @RolesAllowed({"ROLE_DELETE", "ROLE_WRITE"})
    public @ResponseBody Optional<List<Person>> findByNameIgnoreCaseAndSurnameIgnoreCase(@RequestParam String name, @RequestParam String surname) {
        return personService.findByNameIgnoreCaseAndSurnameIgnoreCase(name, surname);
    }

    @GetMapping("/byAge")
    @RolesAllowed({"ROLE_READ"})
    public @ResponseBody List<Person> findByAgeLessThanOrderByAgeAsc(@RequestParam Integer age) {
        return personService.findByAgeLessThanOrderByAgeAsc(age);
    }

    @PostMapping("/add")
    @Secured("ROLE_WRITE")
    public @ResponseBody Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @GetMapping("/byName")
    @PostAuthorize("returnObject.getName == authentication.principal.username")
    public @ResponseBody Optional<Person> getByname(@RequestParam String name) {
        return personService.getByName(name);
    }
}
