package pl.poznan.uam.DAO;

import pl.poznan.uam.entities.PersonEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Stateless
public class PersonDAO {
    @PersistenceContext(unitName = "primary")
    protected EntityManager em;
    private Set<PersonEntity> personSet = new HashSet<>();

    public Optional<PersonEntity> getPersonById(long id){
        return Optional.of(em.find(PersonEntity.class, id));
    }

    public List<PersonEntity> getAll(){
        return em.createQuery("select p from PersonEntity p", PersonEntity.class).getResultList();
    }

    public PersonEntity addPerson(PersonEntity person){
        em.persist(person);
        return person;
    }

    public PersonEntity editPerson(PersonEntity person){
        PersonEntity fromDBase = personSet.stream().filter(p -> p.getId() == person.getId()).findFirst().get();
        fromDBase.update(person);
        return fromDBase;
    }

    public void remove(long id) {
        personSet.remove(new PersonEntity(id));
    }

    public PersonEntity update(PersonEntity personEntity) {
        Optional<PersonEntity> personFromDBase = personSet.stream().filter(p -> p.getId().equals(personEntity.getId())).findFirst();
        personFromDBase.ifPresent(db -> db.update(personEntity));
        return personFromDBase.get();
    }

}
