package netology.ru.JPA_wh_1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.Data;
import lombok.RequiredArgsConstructor;
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
        String query = "Select Person from Persons";
        TypedQuery<Person> personTypedQuery = entityManager.createQuery(query, Person.class);
        return personTypedQuery.getResultList().stream().filter(a -> a.getCity_of_living().equals(city)).toList();

    }

}
