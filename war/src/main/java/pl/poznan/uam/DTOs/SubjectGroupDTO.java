package pl.poznan.uam.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.poznan.uam.entities.SubjectEntity;
import pl.poznan.uam.entities.SubjectGroupEntity;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectGroupDTO implements Serializable {
    private int numberOfStudents;
    private int availablePlaces;
    private String groupShortcut;
    private String heldDate;
    private String classType;

    public SubjectGroupDTO(SubjectGroupEntity subjectGroup){
        numberOfStudents = subjectGroup.getNumberOfStudents();
        availablePlaces = subjectGroup.getAvailablePlaces();
        groupShortcut = subjectGroup.getGroupShortcut();
        heldDate = subjectGroup.getHeldDate();
        classType = subjectGroup.getClassType();
    }
}
