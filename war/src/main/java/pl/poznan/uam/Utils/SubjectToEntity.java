package pl.poznan.uam.Utils;

import pl.poznan.uam.DTOs.SubjectDTO;
import pl.poznan.uam.entities.SubjectEntity;

public class SubjectToEntity {

    public static SubjectEntity subjectToEntity(SubjectDTO subjectDTO){
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubjectName(subjectDTO.getSubjectName());
        subjectEntity.setSubjectCode(subjectDTO.getSubjectCode());
        subjectEntity.setSemester(subjectDTO.getSemester());
        subjectEntity.setYear(subjectDTO.getYear());
        return subjectEntity;
    }
}
