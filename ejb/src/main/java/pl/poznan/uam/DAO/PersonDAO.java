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

    public Optional<PersonEntity> getPersonById(long id){
        return Optional.of(em.find(PersonEntity.class, id));
    }

    public List<PersonEntity> getAll(){
        return em.createQuery("select p from PersonEntity p", PersonEntity.class).getResultList();
    }

    public List<PersonEntity> getAllByPosition(String recievedPosition){
        return em.createQuery("select p from PersonEntity p where position=:pos",PersonEntity.class).setParameter("pos", recievedPosition).getResultList();
    }

    public List<PersonEntity> getPeopleWhoAreNotStudents(){
        return em.createQuery("select p from PersonEntity p where position!='student'",PersonEntity.class).getResultList();
    }

    public PersonEntity addPerson(PersonEntity person){
        em.persist(person);
        return person;
    }

    public void remove(long id) {
        em.remove(em.contains(new PersonEntity((id))) ? new PersonEntity(id) : em.merge(new PersonEntity((id))));
    }

    public PersonEntity update(PersonEntity person, long id) {
        person.setId(id);
        em.merge(person);
        return person;
    }

}
