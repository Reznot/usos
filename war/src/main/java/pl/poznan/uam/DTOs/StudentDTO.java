package pl.poznan.uam.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.poznan.uam.entities.PersonEntity;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class StudentDTO implements Serializable {
    private int indexNumber;
    private String pesel;
    private String name;
    private String surname;
    private String email;
    private String position="student";
    private int statusStance=1;

    public StudentDTO(PersonEntity personEntity){
        indexNumber=personEntity.getIndexNumber();
        pesel=personEntity.getPesel();
        name=personEntity.getName();
        surname=personEntity.getSurname();
        email=personEntity.getEmail();
        statusStance=personEntity.getStatusStance();
        position= personEntity.getPosition();
    }
}
