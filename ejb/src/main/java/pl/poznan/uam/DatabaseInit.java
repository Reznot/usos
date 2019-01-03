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

        SubjectEntity subject = new SubjectEntity();
        subject.setSubjectName("Wstęp do Rachunku Prawdopodobieństwa");
        subject.setSemester("lato");
        subject.setSubjectCode("WRP17");
        subject.setYear(2017);
        subject.setEtcs(5);

        SubjectGroupEntity subjectGroup = new SubjectGroupEntity();
        subjectGroup.setSubject(subject);
        subjectGroup.setAvailablePlaces(25);
        subjectGroup.setClassType("ćwiczenia");
        subjectGroup.setGroupShortcut("1CA");
        Set<PersonEntity> studentList = new HashSet<>();
        studentList.add(person1);
        studentList.add(person3);
        subjectGroup.setStudents(studentList);
        subjectGroup.setNumberOfStudents(studentList.size());
        subjectGroup.setLecturer(person2);
        //todo lepiej ta date wpisz
        subjectGroup.setHeldDate("2014-02-10");

        GradeEntity grade = new GradeEntity();
        grade.setGrade(5);
        grade.setGradeFromSubject(subjectGroup);
        grade.setSubject1(subject);
        grade.setPerson(person1);


        em.persist(person1);
        em.persist(person2);
        em.persist(person3);
        em.persist(subject);
        em.persist(subjectGroup);
        em.persist(grade);

    }
}
