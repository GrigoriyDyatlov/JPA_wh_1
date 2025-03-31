package netology.ru.JPA_wh_1.repository;

import netology.ru.JPA_wh_1.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByCityOfLiving(String city_of_living);

    List<Person> findByAgeLessThanOrderByAgeAsc(Integer age);

    Optional<List<Person>> findByNameIgnoreCaseAndSurnameIgnoreCase(String name, String surname);


}