package pl.poznan.uam.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.poznan.uam.entities.GradeEntity;
import pl.poznan.uam.entities.PersonEntity;
import pl.poznan.uam.entities.SubjectEntity;
import pl.poznan.uam.entities.SubjectGroupEntity;

import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeDTO {
    private PersonEntity person;
    private SubjectGroupEntity gradeFromSubjectGroup;
    private SubjectEntity gradeFromSubject;
    private int grade;

    public GradeDTO(GradeEntity gradeEntity){
        person = gradeEntity.getPerson();
        gradeFromSubjectGroup = gradeEntity.getGradeFromSubjectGroup();
        gradeFromSubject = gradeEntity.getGradeFromSubject();
        grade = gradeEntity.getGrade();
    }
}
