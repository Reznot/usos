/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.uam;

import pl.poznan.uam.entities.GradeEntity;
import pl.poznan.uam.entities.PersonEntity;
import pl.poznan.uam.entities.SubjectEntity;
import pl.poznan.uam.entities.SubjectGroupEntity;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@Singleton
@Startup
public class DatabaseInit {

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    @PostConstruct
    public void init(){
        PersonEntity person1 = new PersonEntity();
        person1.setName("Hubert");
        person1.setSurname("Staszek");
        person1.setEmail("hubsta1@st.amu.edu.pl");
        person1.setIndexNumber(426253);
        person1.setPesel("12345678901");
        person1.setPosition("student");

        PersonEntity person2 = new PersonEntity();
        person2.setName("Łukasz");
        person2.setSurname("Siwocha");
        person2.setEmail("luksiw1@st.amu.edu.pl");
        person2.setPesel("12345678901");
        person2.setPosition("prowadzący");
        person2.setTitles("profesor");

        PersonEntity person3 = new PersonEntity();
        person3.setName("Konrad");
        person3.setSurname("Sobaniec");
        person3.setEmail("konsob1@st.amu.edu.pl");
        person3.setIndexNumber(426254);
        person3.setPesel("12345678901");
        person3.setPosition("student");

        PersonEntity person4 = new PersonEntity();
        person4.setName("Jerzy");
        person4.setSurname("Jaworski");
        person4.setEmail("jrj@amu.edu.pl");
        person4.setPesel("12345678901");
        person4.setPosition("prowadzący");
        person4.setTitles("profesor");

        SubjectEntity subject = new SubjectEntity();
        subject.setSubjectName("Wstęp do Rachunku Prawdopodobieństwa");
        subject.setSemester("lato");
        subject.setSubjectCode("WRP17");
        subject.setYear(2017);
        subject.setEtcs(5);

        SubjectEntity subject2 = new SubjectEntity();
        subject2.setSubjectName("Analiza Matematyczna");
        subject2.setSemester("lato");
        subject2.setSubjectCode("ANI18");
        subject2.setYear(2018);
        subject2.setEtcs(6);

        SubjectGroupEntity subjectGroup = new SubjectGroupEntity();
        subjectGroup.setSubject(subject);
        subjectGroup.setAvailablePlaces(25);
        subjectGroup.setClassType("ćwiczenia");
        subjectGroup.setGroupShortcut("1CA");
        Set<PersonEntity> studentList = new HashSet<>();
        studentList.add(person1);

        subjectGroup.setStudents(studentList);
        subjectGroup.setNumberOfStudents(studentList.size());
        subjectGroup.setLecturer(person2);
        subjectGroup.setHeldDate("2014-02-10");

        SubjectGroupEntity subjectGroup2 = new SubjectGroupEntity();
        subjectGroup2.setSubject(subject2);
        subjectGroup2.setAvailablePlaces(25);
        subjectGroup2.setClassType("laboratoria");
        subjectGroup2.setGroupShortcut("1CF");

        subjectGroup2.setStudents(studentList);
        subjectGroup2.setNumberOfStudents(studentList.size());
        subjectGroup2.setLecturer(person4);
        subjectGroup2.setHeldDate("2015-02-10");

        GradeEntity grade = new GradeEntity();
        grade.setGrade(5);
        grade.setGradeFromSubjectGroup(subjectGroup);
        grade.setGradeFromSubject(subject);
        grade.setPerson(person1);

        GradeEntity grade3 = new GradeEntity();
        grade3.setGrade(4);
        grade3.setGradeFromSubjectGroup(subjectGroup2);
        grade3.setGradeFromSubject(subject2);
        grade3.setPerson(person1);

        em.persist(person1);
        em.persist(person4);
        em.persist(person3);
        em.persist(person2);
        em.persist(subject2);
        em.persist(subject);
        em.persist(subjectGroup2);
        em.persist(subjectGroup);
        em.persist(grade);
        em.persist(grade3);
    }
}
