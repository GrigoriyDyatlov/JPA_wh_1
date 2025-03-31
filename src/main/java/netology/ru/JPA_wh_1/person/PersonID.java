package netology.ru.JPA_wh_1.person;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class PersonID {

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "surname", length = 55)
    private String surname;

    @Column(name = "age")
    private Integer age;

    @Override
    public int hashCode() {
        return name.hashCode() + surname.hashCode() + age.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}