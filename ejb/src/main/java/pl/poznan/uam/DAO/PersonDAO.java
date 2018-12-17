package pl.poznan.uam.DAO;

import pl.poznan.uam.entities.PersonEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Stateless
public class PersonDAO {

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;
    private Set<PersonEntity> persons = new HashSet<>();

    public List<PersonEntity> getAll(){
        return em.createQuery("SELECT p FROM PersonEntity p",PersonEntity.class).getResultList();
    }

    public PersonEntity addPerson(PersonEntity person){
        em.persist(person);
        return person;
    }

    public void remove(int id) {
        persons.remove(new PersonEntity(id));

    public PersonEntity editPerson(PersonEntity person){
        PersonEntity fromDB = persons.stream().filter(e -> e.getId() == person.getId()).findFirst().get();
        fromDB.update(person);
        return fromDB;
    }


    }

    public BookEntity update(BookEntity bookEntity) {
        Optional<BookEntity> bookFromDatabase = books.stream().filter(ent -> ent.getId().equals(bookEntity.getId())).findFirst();
        bookFromDatabase.ifPresent(fromDb -> fromDb.update(bookEntity));
        return bookFromDatabase.get();
    }

    public void test(){
        AuthorEntity author = em.find(AuthorEntity.class, 2l);
        author.getBooks().stream().forEach(System.out::println);
    }

}