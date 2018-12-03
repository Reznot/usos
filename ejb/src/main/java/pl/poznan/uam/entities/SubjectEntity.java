package pl.poznan.uam.entities;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class SubjectEntity extends AbstractEntity{
    private String subjectName;
    private String subjectCode;
}
