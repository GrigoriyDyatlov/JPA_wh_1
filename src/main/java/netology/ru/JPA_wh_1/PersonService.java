package netology.ru.JPA_wh_1;

import lombok.RequiredArgsConstructor;
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
