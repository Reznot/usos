package pl.poznan.uam.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class PersonDTO implements Serializable {
    private Long id;
    private int index;
    private String  pesel;
    private int status;
    private String name;
    private String surname;
    private String titles;
    private String mail;
}
