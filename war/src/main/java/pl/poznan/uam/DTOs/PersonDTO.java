package pl.poznan.uam.DTOs;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonDTO implements Serializable {
    private String name;
    private String surname;
    private int pesel;
    private int index;
    private String mail;
    private int status;
    private int id;
    private String titles;
}
