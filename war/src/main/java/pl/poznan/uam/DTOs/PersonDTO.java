package pl.poznan.uam.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.poznan.uam.entities.GradeEntity;
import pl.poznan.uam.entities.PersonEntity;
import pl.poznan.uam.entities.SubjectGroupEntity;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO implements Serializable {
    private int indexNumber;
    private String pesel;
    private String name;
    private String surname;
    private String email;
    private String titles;
    private int statusStance;
    private String position;


    public PersonDTO(PersonEntity personEntity) {
        indexNumber = personEntity.getIndexNumber();
        pesel = personEntity.getPesel();
        name = personEntity.getName();
        surname = personEntity.getSurname();
        email = personEntity.getEmail();
        titles = personEntity.getTitles();
        statusStance = personEntity.getStatusStance();
        position = personEntity.getPosition();
    }


}
