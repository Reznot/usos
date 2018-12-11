/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.uam;

import pl.poznan.uam.entities.PersonEntity;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


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
        person2.setName("Lukasz");
        person2.setSurname("Siwocha");
        person2.setEmail("luksiw1@st.amu.edu.pl");
        person2.setPesel("12345678901");
        person2.setPosition("prowadzacy");
        person2.setTitles("profesor");

        em.persist(person1);
        em.persist(person2);



    }
}
