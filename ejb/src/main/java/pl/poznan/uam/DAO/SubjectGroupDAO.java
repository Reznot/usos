package pl.poznan.uam.DAO;

import pl.poznan.uam.entities.PersonEntity;
import pl.poznan.uam.entities.SubjectGroupEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Stateless
public class SubjectGroupDAO {

    @PersistenceContext(unitName = "primary")//nie wiem czy tak powinno byc
    protected EntityManager em;
    private Set<SubjectGroupEntity> subjectGroupSet = new HashSet<>();

    public Optional<SubjectGroupEntity> getSubjectGroupByID(long id){
        return Optional.of(em.find(SubjectGroupEntity.class, id));
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

    public SubjectGroupEntity addStudentToSubjectGroup(SubjectGroupEntity subjectGroup, PersonEntity person){
        subjectGroup.addStudents(person);
        em.merge(subjectGroup);
        return subjectGroup;
    }

    public List<SubjectGroupEntity> getSubjectGroupByLecturer(){
        //TypedQuery<SubjectGroupEntity> q =   TODO sprobuj potem to ograc z typed query (ale do czego to przechwycic???)
        return em.createQuery("SELECT sg FROM SubjectGroupEntity sg join fetch sg.lecturer", SubjectGroupEntity.class).getResultList();
    }

    //TODO remove
    //TODO PUT

    public SubjectGroupEntity editSubjectGroup(SubjectGroupEntity subjectGroup){
        SubjectGroupEntity fromDB = subjectGroupSet.stream().filter(s -> s.getId() == subjectGroup.getId()).findFirst().get();
        fromDB.update(subjectGroup);
        return fromDB;
    }

    public SubjectGroupEntity update(SubjectGroupEntity subjectGroup){
        Optional<SubjectGroupEntity> subjectGroupFromDB = subjectGroupSet.stream().filter(sg -> sg.getId().equals(subjectGroup.getId())).findFirst();
        subjectGroupFromDB.ifPresent(db -> db.update(subjectGroup));
        return  subjectGroupFromDB.get();
    }

}
