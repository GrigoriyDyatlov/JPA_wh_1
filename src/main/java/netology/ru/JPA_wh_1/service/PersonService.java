package netology.ru.JPA_wh_1.service;

import lombok.RequiredArgsConstructor;
import netology.ru.JPA_wh_1.person.Person;
import netology.ru.JPA_wh_1.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private PersonRepository personRepository;

    public List<Person> getPersonsByCity(String city){
        return personRepository.getPersonsByCity(city);
    }
}
