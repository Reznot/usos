package pl.poznan.uam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class PersonEntity extends AbstractEntity{

    private int indexNumber;
    private String pesel;
    private String name;
    private String surname;
    private String email;
    private String titles;
    private int statusStance;
    private String position;

    @ManyToMany(mappedBy = "students")
    private Set<SubjectGroupEntity> subjectGroups;

    @OneToMany(mappedBy = "lecturer")
    private Set<SubjectGroupEntity> lecturedGroup;

    @OneToMany(mappedBy = "person")
    private Set<GradeEntity> grades;

    public PersonEntity(long id) {
        super(id);
    }

    public void addSubjectGroup(SubjectGroupEntity subjectGroup) {
        this.subjectGroups.add(subjectGroup);
    }

    public SubjectGroupEntity returnSubjectGroup() {
        return subjectGroups.stream().findAny().get();
    }
    public SubjectGroupEntity returnLecturedGroup() {
        return lecturedGroup.stream().findAny().get();
    }
    public GradeEntity returnGrade() {
        return grades.stream().findAny().get();
    }

    public void update(PersonEntity person) {
        indexNumber=person.getIndexNumber();
        pesel = person.getPesel();
        name = person.getName();
        surname = person.getSurname();
        email = person.getEmail();
        titles = person.getTitles();
        statusStance = getStatusStance();
        position=person.getPosition();
        subjectGroups.add(person.returnSubjectGroup());
        lecturedGroup.add(person.returnLecturedGroup());
        grades.add(person.returnGrade());
    }

}
