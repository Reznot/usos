package pl.poznan.uam.Utils;

import pl.poznan.uam.DTOs.EmployeeDTO;
import pl.poznan.uam.DTOs.GradeDTO;
import pl.poznan.uam.entities.GradeEntity;
import pl.poznan.uam.entities.PersonEntity;

public class GradeToEntity {
    public static GradeEntity gradeToEntity(GradeDTO gradeDTO){
        GradeEntity gradeEnt = new GradeEntity();
        gradeEnt.setPerson(gradeDTO.getPerson());
        gradeEnt.setGradeFromSubjectGroup(gradeDTO.getGradeFromSubjectGroup());
        gradeEnt.setGradeFromSubject(gradeDTO.getGradeFromSubject());
        gradeEnt.setGrade(gradeDTO.getGrade());
        return gradeEnt;
    }
}
