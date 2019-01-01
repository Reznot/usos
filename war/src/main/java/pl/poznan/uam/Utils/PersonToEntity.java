package pl.poznan.uam.Utils;

import pl.poznan.uam.DTOs.PersonDTO;
import pl.poznan.uam.DTOs.StudentDTO;
import pl.poznan.uam.entities.PersonEntity;

public class PersonToEntity {
    public static PersonEntity studentToEntity(StudentDTO studentDTO){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(studentDTO.getName());
        personEntity.setSurname(studentDTO.getSurname());
        personEntity.setEmail(studentDTO.getEmail());
        personEntity.setPesel(studentDTO.getPesel());
        personEntity.setIndexNumber(studentDTO.getIndexNumber());
        return personEntity;
    }

    public static PersonEntity toEntity(PersonDTO personDTO){
        PersonEntity personEntity = new PersonEntity();

        personEntity.setIndexNumber(personDTO.getIndexNumber());
        personEntity.setPesel(personDTO.getPesel());
        personEntity.setName(personDTO.getName());
        personEntity.setSurname(personDTO.getSurname());
        personEntity.setEmail(personDTO.getEmail());
        personEntity.setTitles(personDTO.getTitles());
        personEntity.setStatusStance(personDTO.getStatusStance());
        personEntity.setPosition(personDTO.getPosition());
        return personEntity;
    }
}
