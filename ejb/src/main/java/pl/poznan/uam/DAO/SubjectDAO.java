package pl.poznan.uam.DAO;

import pl.poznan.uam.entities.SubjectEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Stateless
public class SubjectDAO {

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;
    private Set<SubjectEntity> subjectSet = new HashSet<>();

    public Optional<SubjectEntity> getSubjectById(long id){
        return Optional.of(em.find(SubjectEntity.class, id)); //Tylko po PK?
    }

    public List<SubjectEntity> getAll(){
        return em.createQuery("SELECT s FROM SubjectEntity s", SubjectEntity.class).getResultList();
    }

    public SubjectEntity addSubject(SubjectEntity subject){
        em.persist(subject);
        return subject;
    }

    public void remove(long id){
        em.remove(em.contains(new SubjectEntity(id)) ? new SubjectEntity(id) : em.merge(new SubjectEntity(id)));
    }

    public SubjectEntity editSubject(SubjectEntity subject){
        SubjectEntity subjectFromDB = subjectSet.stream().filter(s -> s.getId() == subject.getId()).findFirst().get();
        return subjectFromDB;
    }

    public SubjectEntity update(SubjectEntity subjectEntity, long id){
        subjectEntity.setId(id);
        em.merge(subjectEntity);
        return subjectEntity;
    }

}
