package pl.poznan.uam.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Data
public class ScoreEntity extends AbstractEntity {

//    @OneToOne
//    private PersonEntity person;
//
//    @OneToOne
//    private SubjectGroupEntity subjectGroupEntity;
    private int score;

}
