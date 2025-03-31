package netology.ru.JPA_wh_1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import netology.ru.JPA_wh_1.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Data
@org.springframework.stereotype.Repository
@RequiredArgsConstructor
public class PersonRepository {
    @Autowired
    private EntityManager entityManager;


@Transactional
    public List<Person> getPersonsByCity(String city) {
        String query = "Select Person from Persons where city_of_living=" + city;
        TypedQuery<Person> personTypedQuery = entityManager.createQuery(query, Person.class);
        return personTypedQuery.getResultList();

    }

}
