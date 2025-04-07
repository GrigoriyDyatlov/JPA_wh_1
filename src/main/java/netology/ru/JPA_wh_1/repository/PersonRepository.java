package netology.ru.JPA_wh_1.repository;

import netology.ru.JPA_wh_1.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("select p from Person p where p.cityOfLiving = ?1")
    List<Person> findAllByCityOfLiving(String city);

    @Query("select p from Person p where p.age < ?1 order by p.age")
    List<Person> findByAgeLessThanOrderByAgeAsc(Integer age);

    @Query("select p from Person p where upper(p.name) = upper(?1) and upper(p.surname) = upper(?2)")
    Optional<List<Person>> findByNameIgnoreCaseAndSurnameIgnoreCase(String name, String surname);

    @Query("select p from Person p where upper(p.name) = upper(?1)")
    Optional<Person> getByName(String name);


}