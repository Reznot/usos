package pl.poznan.uam.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.poznan.uam.entities.PersonEntity;

import java.io.Serializable;

//TODO: zapytać mistrza o te klasy, różnice między studentem a pracownikiem, jak to rozegrać

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonShortDTO implements Serializable {
    private String name;
    private String surname;
    private String email;
    private String position;

    public PersonShortDTO(PersonEntity personEntity){
        name = personEntity.getName();
        surname = personEntity.getSurname();
        email = personEntity.getEmail();
        position = personEntity.getPosition();
    }
}

