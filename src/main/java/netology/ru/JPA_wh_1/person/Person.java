package netology.ru.JPA_wh_1.person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {
    @Id
    private PersonID personID;

    @Column(name = "city_of_living", length = 100)
    private String cityOfLiving;

    @Column(name = "phone_number", length = 11)
    private String phone_number;

    public String getName() {
        return personID.getName();
    }

    public String getSurname() {
        return personID.getSurname();
    }

    public Integer getAge() {
        return personID.getAge();
    }

    @Override
    public String toString() {
        return "Person{" +
                ", name='" + personID.getName() + '\'' +
                ", surname='" + personID.getSurname() + '\'' +
                ", age=" + personID.getAge() +
                ", city_of_living='" + cityOfLiving + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}