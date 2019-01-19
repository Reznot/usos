package pl.poznan.uam.DAO;

import pl.poznan.uam.QueriesMapping.GradesFromSubject;
import pl.poznan.uam.QueriesMapping.StudentWithSubjectAndGrades;
import pl.poznan.uam.QueriesMapping.SubjectWithGrade;
import pl.poznan.uam.entities.GradeEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    public StudentWithSubjectAndGrades getStudentGradesFromAllSubjects(long person_id){
//        List<Object[]> resultList = em.createQuery("select p.name, p.surname, g.grade, sg.classType, s.subjectName, " +
//                "(select concat(p.name,' ', p.surname) as lecturer from PersonEntity p join p.lecturedGroup sg) " +
//                "from GradeEntity g join g.person p join g.gradeFromSubjectGroup sg join g.gradeFromSubject s " +
//                "where p.id=:studentId", Object[].class).setParameter("studentId", person_id).getResultList();

        List<Object[]> resultList = em.createQuery("select p.name, p.surname,p.email, g.grade, sg.classType, s.subjectName " +
                "from GradeEntity g join g.person p join g.gradeFromSubjectGroup sg join g.gradeFromSubject s " +
                "where p.id=:studentId", Object[].class).setParameter("studentId", person_id).getResultList();


        List<SubjectWithGrade> subjectsAndGrades = new LinkedList<>();

        for(Object[] object : resultList){
            SubjectWithGrade subjectData = new SubjectWithGrade((int) object[3], object[4].toString(), object[5].toString());
            subjectsAndGrades.add(subjectData);
        }

        StudentWithSubjectAndGrades studentWithSubjectAndGrades = new StudentWithSubjectAndGrades(resultList.get(0)[0].toString(),
                resultList.get(0)[1].toString(), resultList.get(0)[2].toString(), subjectsAndGrades);

        return studentWithSubjectAndGrades;
    }

    public List<GradesFromSubject> getGradesFromSubjectGroup(String groupShortcut){
//        List<GradesFromSubject> resultList = em.createQuery("select new GradesFromSubject(p.name, p.surname, g.grade) from GradeEntity g
//        join g.person p join g.gradeFromSubjectGroup sg where sg.groupShortcut=:grShortcut", Object[].class)
//                .setParameter("grShortcut", groupShortcut).getResultList();
        List<Object[]> resultList = em.createQuery("select p.name, p.surname, g.grade from GradeEntity g " +
                "join g.person p join g.gradeFromSubjectGroup sg where sg.groupShortcut=:grShortcut", Object[].class)
                .setParameter("grShortcut", groupShortcut).getResultList();
        List<GradesFromSubject> gradesfinal = new LinkedList<>();
        for(Object[] object : resultList){
            GradesFromSubject grade = new GradesFromSubject(object[0].toString(), object[1].toString(), (int)object[2]);
            gradesfinal.add(grade);
        }
        return gradesfinal;
    }




}
