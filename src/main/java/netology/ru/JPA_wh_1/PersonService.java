package netology.ru.JPA_wh_1;

import lombok.RequiredArgsConstructor;
import netology.ru.JPA_wh_1.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private PersonRepository personRepository;

    public List<Person> findAllByCity_of_living(String city) {
        return personRepository.findAllByCity_of_living(city);
    }

    public List<Person> findByAgeLessThanOrderByAgeAsc(Integer age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    public Optional<List<Person>> findByNameIgnoreCaseAndSurnameIgnoreCase(String name, String surname) {
        return personRepository.findByNameIgnoreCaseAndSurnameIgnoreCase(name, surname);
    }
}
