package pl.poznan.uam.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GradeEntity extends AbstractEntity {

    @ManyToOne
    private PersonEntity person;

    @ManyToOne
    private SubjectGroupEntity gradeFromSubjectGroup;

    @ManyToOne
    private SubjectEntity gradeFromSubject;

    private int grade;

}
