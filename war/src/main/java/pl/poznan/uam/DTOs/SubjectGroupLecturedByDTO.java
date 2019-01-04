package pl.poznan.uam.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.poznan.uam.entities.PersonEntity;
import pl.poznan.uam.entities.SubjectGroupEntity;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectGroupLecturedByDTO implements Serializable {

    private int numberOfStudents;
    private int availablePlaces;
    private String groupShortcut;
    private String heldDate;
    private String classType;
    private long lecturer_id;
    private String name;

    public SubjectGroupLecturedByDTO(SubjectGroupEntity subjectGroup) {
        numberOfStudents = subjectGroup.getNumberOfStudents();
        availablePlaces = subjectGroup.getAvailablePlaces();
        groupShortcut = subjectGroup.getGroupShortcut();
        heldDate = subjectGroup.getHeldDate();
        classType = subjectGroup.getClassType();
        lecturer_id = subjectGroup.getLecturer_id();
        name = new PersonEntity(subjectGroup.getLecturer_id()).getName();
    }

    public String getName(){
        return name;
    }

    public long getLecturer_id(){
        return lecturer_id;
    }
}
