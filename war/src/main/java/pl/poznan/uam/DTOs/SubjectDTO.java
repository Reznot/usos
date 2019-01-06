package pl.poznan.uam.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.poznan.uam.entities.SubjectEntity;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO implements Serializable {
    private String subjectName;
    private String subjectCode;
    private String semester;
    private int year;
    private int etcs;

    public SubjectDTO(SubjectEntity subjectEntity){
        subjectName = subjectEntity.getSubjectName();
        subjectCode = subjectEntity.getSubjectCode();
        semester = subjectEntity.getSemester();
        year = subjectEntity.getYear();
        etcs = subjectEntity.getEtcs();
    }
}
