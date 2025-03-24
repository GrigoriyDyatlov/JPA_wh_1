package netology.ru.JPA_wh_1;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {
    @EmbeddedId
    private PersonID id;

    @Column(name = "city_of_living", length = 100)
    private String city_of_living;

    @Column(name = "phone_number", length = 11)
    private String phone_number;


}