package pl.poznan.uam.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class PersonEntity extends AbstractEntity{
//TODO przemyśleć uprawnienia usera do dodawania ocen, jakie pole permission
    private int indexNumber;
    private String pesel;
    private String name;
    private String surname;
    private String email;
    private String titles;
    private int statusStance;
    private String position;
    @ManyToMany
    private Set<SubjectGroupEntity> subjectGroups;
    @OneToMany(mappedBy = "prowadzacy")
    private Set<SubjectGroupEntity> prowadzonagrupa;
    @OneToMany(mappedBy = "person")
    private Set<GradeEntity> grades;
}
