package netology.ru.JPA_wh_1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "surname", length = 55)
    private String surname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "city_of_living", length = 100)
    private String city_of_living;

    @Column(name = "phone_number", length = 11)
    private String phone_number;


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city_of_living='" + city_of_living + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}