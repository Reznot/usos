package pl.poznan.uam.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

//TODO: zapytać mistrza o te klasy, różnice między studentem a pracownikiem, jak to rozegrać

@Data
@AllArgsConstructor
public class PersonShortDTO implements Serializable {
    private Long id;
    private String name;
    private String surname;
}

