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
    private long id;
    private int numberOfStudents;
    private int availablePlaces;
    private String groupShortcut;
    private String heldDate;
    private String classType;
    private long lecturer_id;
    private long subject_id;

    public SubjectGroupDTO(SubjectGroupEntity subjectGroup){
        numberOfStudents = subjectGroup.getNumberOfStudents();
        availablePlaces = subjectGroup.getAvailablePlaces();
        groupShortcut = subjectGroup.getGroupShortcut();
        heldDate = subjectGroup.getHeldDate();
        classType = subjectGroup.getClassType();
        lecturer_id = subjectGroup.getLecturer_id();
        subject_id = subjectGroup.getSubject_id();
        id = subjectGroup.getId();
    }

    public long getLecturer_id(){
        return lecturer_id;
    }

    public long getSubject_id(){
        return subject_id;
    }

    public long getId(){
        return id;
    }
}
