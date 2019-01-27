package pl.poznan.uam.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class SubjectEntity extends AbstractEntity{

    public SubjectEntity(long id){
        super(id);
    }

    //TODO: id jako oznaczenie przedmotu+ rok np. DWRP2019
    private String subjectName;
    private String subjectCode;
    private String semester;
    private int year;
    private int etcs;
    @OneToMany(mappedBy = "subject")
    private Set<SubjectGroupEntity> subjectGroup;
    @OneToMany(mappedBy = "gradeFromSubject")
    private Set<GradeEntity> grades;

    public void addSubjectGroup(SubjectGroupEntity newSubjectGroup){
        this.subjectGroup.add(newSubjectGroup);
    }

    public void addGrade(GradeEntity newGrade){
        this.grades.add(newGrade);
    }

    public SubjectGroupEntity returnSubjectGroup(){
        return subjectGroup.stream().findAny().get();
    }

    public GradeEntity returnGrade(){
        return grades.stream().findAny().get();
    }

    public void update(SubjectEntity subject){
        subjectName = subject.getSubjectName();
        subjectCode = subject.getSubjectCode();
        semester = subject.getSemester();
        year = subject.getYear();
        etcs = subject.getEtcs();

        subjectGroup.add(subject.returnSubjectGroup());
        grades.add(subject.returnGrade());
    }
}
