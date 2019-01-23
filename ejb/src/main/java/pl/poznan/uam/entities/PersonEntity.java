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
@AllArgsConstructor
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
    public String getNameAndSurname(){
        return getName()+" "+getSurname();
    }

    public void updateEmployee(PersonEntity person) {
        email=person.getEmail();
        name=person.getName();
        surname=person.getSurname();
        pesel=person.getPesel();
        position=person.getPosition();
        titles = person.getTitles();
        statusStance=person.getStatusStance();
    }

    public void updateStudent(PersonEntity person) {
        email=person.getEmail();
        indexNumber=person.getIndexNumber();
        name=person.getName();
        surname=person.getSurname();
        pesel=person.getPesel();
        position=person.getPosition();
        statusStance=person.getStatusStance();
    }
}
