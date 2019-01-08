package pl.poznan.uam.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class SubjectGroupEntity extends AbstractEntity{

    private int numberOfStudents;
    private int availablePlaces;
    private String groupShortcut;
    private String heldDate;   //TODO wpisuj np "Tueasday, 7PM"
    //TODO zrobic z tego enuma
    private String classType;

    @ManyToMany
    private Set<PersonEntity> students;

    @ManyToOne
    private PersonEntity lecturer;

    @ManyToOne
    private SubjectEntity subject;

    @OneToMany(mappedBy = "gradeFromSubjectGroup")
    private Set<GradeEntity> grades;

    public SubjectGroupEntity(long Id){
        super(Id);
    }

    public long getLecturer_id(){
        return lecturer.getId();
    }

    public long getSubject_id(){ //////wazne w kit
        return subject.getId();
    }

    public void addLecturer(PersonEntity lecturer){
        this.lecturer = lecturer;
    }

    public void addSubject(SubjectEntity subject){
        this.subject = subject;
    }

    public PersonEntity returnStudents(){
        return students.stream().findAny().get();
    }

    public GradeEntity returnGrades(){
        return grades.stream().findAny().get();
    }

    public void update(SubjectGroupEntity subjectGroup){
        students.add(subjectGroup.returnStudents());
        lecturer = subjectGroup.getLecturer();
        subject = subjectGroup.getSubject();
        grades.add(subjectGroup.returnGrades());
        numberOfStudents = subjectGroup.getNumberOfStudents();
        availablePlaces = subjectGroup.getAvailablePlaces();
        groupShortcut = subjectGroup.getGroupShortcut();
        heldDate = subjectGroup.getHeldDate();
        classType = subjectGroup.getClassType();
    }


}
