package pl.poznan.uam.Controllers;

import pl.poznan.uam.DAO.SubjectDAO;

import javax.ejb.EJB;
import javax.ws.rs.Path;

@Path("subjects")
public class SubjectController {

    @EJB
    private SubjectDAO subjectDAO;


}
