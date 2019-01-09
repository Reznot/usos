package pl.poznan.uam.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.poznan.uam.QueriesMapping.GradesFromSubject;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade implements Serializable {
    private int grade;
    private String name;
    private String surname;

    public Grade(GradesFromSubject gradesFromSubject) {
        name = gradesFromSubject.getName();
        surname = gradesFromSubject.getSurname();
        grade = gradesFromSubject.getGrade();
    }
}