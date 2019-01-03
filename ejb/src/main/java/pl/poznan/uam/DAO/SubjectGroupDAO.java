package pl.poznan.uam.DAO;

import pl.poznan.uam.entities.SubjectGroupEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    public SubjectGroupEntity addSubjectGroup(SubjectGroupEntity subjectGroup){
        em.persist(subjectGroup);
        return subjectGroup;
    }

    //TODO remove

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
