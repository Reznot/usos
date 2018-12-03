package pl.poznan.uam.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class SubjectGroupEntity extends AbstractEntity{

    @ManyToMany
    private Set<PersonEntity> students;

    //TODO: czy to zadziala?
    // chyba tak!
    @ManyToOne
    private PersonEntity prowadzacy;

    @ManyToOne
    private SubjectEntity subject;

    @OneToMany(mappedBy = "gradeFromSubject")
    private Set<GradeEntity> grades;

    private int numberOfStudents;
    private int availablePlaces;
    private String groupShortcut;
    private Date heldDate;
    //TODO zrobic z tego enuma
    private String typZajec;


}
