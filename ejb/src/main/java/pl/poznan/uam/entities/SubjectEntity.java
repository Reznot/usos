package pl.poznan.uam.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class SubjectEntity extends AbstractEntity{

    public SubjectEntity(long id){
        super(id);
    }

    //TODO: id jako oznaczenie przedmotu+ rok np. DWRP2019
    private String subjectName;
    private String subjectCode;
    private String semester;
    private int year;
    @OneToMany(mappedBy = "subject")
    private Set<SubjectGroupEntity> subjectGroup;
    //TODO: czy 2 te same subjecty nie beda sie gryzc ze soba?
    @OneToMany(mappedBy = "subject1")
    private Set<GradeEntity> grades;
}
