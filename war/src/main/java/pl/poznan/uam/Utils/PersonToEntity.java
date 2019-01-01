package pl.poznan.uam.Utils;

import pl.poznan.uam.DTOs.EmployeeDTO;
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

    public static PersonEntity employeeToEntity(EmployeeDTO employeeDTO){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setPesel(employeeDTO.getPesel());
        personEntity.setName(employeeDTO.getName());
        personEntity.setSurname(employeeDTO.getSurname());
        personEntity.setEmail(employeeDTO.getEmail());
        personEntity.setTitles(employeeDTO.getTitles());
        personEntity.setPosition(employeeDTO.getPosition());
        return personEntity;
    }
}
