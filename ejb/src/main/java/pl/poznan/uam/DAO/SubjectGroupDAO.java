package pl.poznan.uam.DAO;

import pl.poznan.uam.entities.PersonEntity;
import pl.poznan.uam.entities.SubjectGroupEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Stateless
public class SubjectGroupDAO {

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;
    private Set<SubjectGroupEntity> subjectGroupSet = new HashSet<>();

    public Optional<SubjectGroupEntity> getSubjectGroupByID(long id){
        return Optional.of(em.find(SubjectGroupEntity.class, id));
       // return (SubjectGroupEntity) em.createQuery("SELECT sg from SubjectGroupEntity sg join fetch sg.students WHERE sg.id =:id").setParameter("id", id).getSingleResult();
    }

    public List<SubjectGroupEntity> getAll(){
        return em.createQuery("SELECT sg FROM SubjectGroupEntity sg", SubjectGroupEntity.class).getResultList();
    }

    public List<SubjectGroupEntity> getGroupsStudents(){
        return em.createQuery("SELECT sg from SubjectGroupEntity sg join fetch sg.students", SubjectGroupEntity.class).getResultList();
    }

    public SubjectGroupEntity addSubjectGroup(SubjectGroupEntity subjectGroup){
        em.persist(subjectGroup);
        return subjectGroup;
    }

    public List<SubjectGroupEntity> getSubjectGroupByLecturer(){
        //TypedQuery<SubjectGroupEntity> q =
        return em.createQuery("SELECT sg FROM SubjectGroupEntity sg join fetch sg.lecturer", SubjectGroupEntity.class).getResultList();
    }


    public SubjectGroupEntity editSubjectGroup(SubjectGroupEntity subjectGroup){
        SubjectGroupEntity fromDB = subjectGroupSet.stream().filter(s -> s.getId() == subjectGroup.getId()).findFirst().get();
        fromDB.update(subjectGroup);
        return fromDB;
    }

    public SubjectGroupEntity update(SubjectGroupEntity subjectGroup, long id){
        subjectGroup.setId(id);
        em.merge(subjectGroup);
        return subjectGroup;
    }

    public void remove(long id){
        em.remove(em.contains(new SubjectGroupEntity(id)) ? new SubjectGroupEntity(id) : em.merge(new SubjectGroupEntity(id)));
    }

    public void addStudentToGroup(SubjectGroupEntity subjectGroupEntity, PersonEntity personEntity){
        subjectGroupEntity.addStudents(personEntity);
        personEntity.addSubjectGroup(subjectGroupEntity);
        em.merge(subjectGroupEntity);
        em.merge(personEntity);
    }

    public SubjectGroupEntity addStudentToSubjectGroup(SubjectGroupEntity subjectGroup, PersonEntity person){
        subjectGroup.addStudents(person);
        em.merge(subjectGroup);
        return subjectGroup;
    }

    public SubjectGroupEntity addStudentToSubjectGroup2(Long groupId, Long personId){
        SubjectGroupEntity group = em.find(SubjectGroupEntity.class, groupId);
        PersonEntity person = em.find(PersonEntity.class, personId);
        group.addStudents(person);
        return group;
    }
}
