package pl.poznan.uam.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
@Data
public class SubjectGroupEntity extends AbstractEntity{

//    @OneToOne
//    private PersonEntity personEntity;

//    @OneToMany
//    private SubjectEntity subjectEntity;

//    @ManyToMany
//    private Set<PersonEntity> students;

    private int numberOfStudents;
    private int availablePlaces;
    private String groupShortcut;
    private String term;



}
