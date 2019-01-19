package pl.poznan.uam.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.poznan.uam.entities.PersonEntity;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable {
    private String pesel;
    private String name;
    private String surname;
    private String email;
    private String titles;
    private String position;
    private int statusStance=1;

    public EmployeeDTO(PersonEntity personEntity){
        pesel=personEntity.getPesel();
        name=personEntity.getName();
        surname=personEntity.getSurname();
        email=personEntity.getEmail();
        titles=personEntity.getTitles();
        position=personEntity.getPosition();
        statusStance=personEntity.getStatusStance();
    }
}
