package pl.poznan.uam.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.security.auth.Subject;

@Entity
@Data
public class GradeEntity extends AbstractEntity {

    @ManyToOne
    private PersonEntity person;

    @ManyToOne
    private SubjectGroupEntity gradeFromSubject;

    @ManyToOne
    private SubjectEntity subject1;

    private int grade;

}
