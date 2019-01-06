package pl.poznan.uam.Utils;

import pl.poznan.uam.DTOs.SubjectGroupDTO;
import pl.poznan.uam.entities.PersonEntity;
import pl.poznan.uam.entities.SubjectEntity;
import pl.poznan.uam.entities.SubjectGroupEntity;

public class SubjectGroupToEntity {

    public static SubjectGroupEntity subjectGroupToEntity(SubjectGroupDTO subjectGroupDTO){
        SubjectGroupEntity subjectGroupEntity = new SubjectGroupEntity();

        subjectGroupEntity.setNumberOfStudents(subjectGroupDTO.getNumberOfStudents());
        subjectGroupEntity.setAvailablePlaces(subjectGroupDTO.getAvailablePlaces());
        subjectGroupEntity.setGroupShortcut(subjectGroupDTO.getGroupShortcut());
        subjectGroupEntity.setHeldDate(subjectGroupDTO.getHeldDate());
        subjectGroupEntity.setClassType(subjectGroupDTO.getClassType());
        subjectGroupEntity.addLecturer(new PersonEntity(subjectGroupDTO.getLecturer_id()));
        subjectGroupEntity.addSubject(new SubjectEntity(subjectGroupDTO.getSubject_id()));
        return subjectGroupEntity;
    }
}
