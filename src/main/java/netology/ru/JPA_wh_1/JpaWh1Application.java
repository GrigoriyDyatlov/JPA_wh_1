package netology.ru.JPA_wh_1;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaWh1Application {

//    private final PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaWh1Application.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        var person1 = new Person();
//        person1.setName("Ivan");
//        person1.setSurname("Durak");
//        person1.setAge(21);
//        person1.setCity_of_living("MOSCOW");
//        var person2 = new Person();
//        person1.setName("Ivan");
//        person1.setSurname("Carevich");
//        person1.setAge(14);
//        person1.setCity_of_living("SLOBODA");
//        personRepository.save(person1);
//        personRepository.save(person2);
//    }
}
