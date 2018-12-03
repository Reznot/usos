package pl.poznan.uam.entities;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class PersonEntity extends AbstractEntity{

    private int indexNumber;
    private String pesel;
    private String name;
    private String surname;
    private String email;
    private String titles;
    private int statusStance;
    private String position;
}
