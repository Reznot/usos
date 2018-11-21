package pl.poznan.uam.DTOs;

import pl.poznan.uam.Entities.PersonEntity;

public class PersonDtoToEntity {

    public static PersonEntity toEntity(PersonDTO aEnt){
        PersonEntity ret = new PersonEntity();
        ret.setId(aEnt.getId());
        ret.setIndex(aEnt.getIndex());
        ret.setPesel(aEnt.getPesel());
        ret.setStatus(aEnt.getStatus());
        ret.setName(aEnt.getName());
        ret.setSurname(aEnt.getSurname());
        ret.setTitles(aEnt.getTitles());
        ret.setMail(aEnt.getMail());
        return ret;
    }
}
