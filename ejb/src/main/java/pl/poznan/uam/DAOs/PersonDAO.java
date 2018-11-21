package pl.poznan.uam.DAOs;

import pl.poznan.uam.Entities.PersonEntity;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.*;

@Startup
@Singleton
public class PersonDAO {
    private final Set<PersonEntity> persons = new HashSet<>();

    public PersonDAO(){

    }

    @PostConstruct
    void  init(){
        persons.add(new PersonEntity(1l, 123456, "00998876543", 1, "Hubert", "Staszek", "dr inż", "kappa@gmail.com"));
        persons.add(new PersonEntity(2l, 654321, "11998876543", 1,
                "Łukasz", "Siwocha", "prof", "kappa2@gmail.com"));
    }

    public Optional<PersonEntity> getPersonById(long aId){
        return persons.stream().filter(e -> e.getId() == aId).findFirst();
    }

    public List<PersonEntity> getAll(){
        return new ArrayList(persons);
    }

    public PersonEntity addPerson(PersonEntity aPerson){
        aPerson.setId((long) (persons.size() + 1));
        persons.add(aPerson);
        return aPerson;
    }

    public PersonEntity editPerson(PersonEntity aPerson){
        PersonEntity fromDB = persons.stream().filter(e -> e.getId() == aPerson.getId()).findFirst().get();
        return  fromDB;
    }

    public void remove(long aId){
        persons.remove(new PersonEntity(aId));
    }

    public PersonEntity update(PersonEntity personEntity){
        Optional<PersonEntity> personFromDB = persons.stream().filter(ent -> ent.getId().equals(personEntity.getId())).findFirst();
        personFromDB.ifPresent(fromDb -> fromDb.update(personEntity));
        return personFromDB.get();
    }

}
