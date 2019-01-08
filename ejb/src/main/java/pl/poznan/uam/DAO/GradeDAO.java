package pl.poznan.uam.DAO;

import org.graalvm.compiler.lir.LIRInstruction;
import pl.poznan.uam.QueriesMapping.GradesFromSubject;
import pl.poznan.uam.entities.GradeEntity;
import pl.poznan.uam.entities.PersonEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class GradeDAO {
    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    public GradeEntity addGrade(GradeEntity grade){
        em.persist(grade);
        return grade;
    }

    public List<GradesFromSubject> getGradesFromSubjectGroup(String groupShortcut){
        List<Object[]> resultList = em.createQuery("select p.name, p.surname, g.grade from GradeEntity g join g.person p join g.gradeFromSubjectGroup sg where sg.groupShortcut=:grShortcut", Object[].class)
                .setParameter("grShortcut", groupShortcut).getResultList();
        List<GradesFromSubject> gradesfinal = new LinkedList<>();
        for(Object[] object : resultList){
            GradesFromSubject grade = new GradesFromSubject(object[0].toString(), object[1].toString(), (int)object[2]);
            gradesfinal.add(grade);
        }
        return gradesfinal;
    }


}
