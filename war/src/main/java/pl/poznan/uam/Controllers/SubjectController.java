package pl.poznan.uam.Controllers;

import pl.poznan.uam.DAO.SubjectDAO;
import pl.poznan.uam.DTOs.SubjectDTO;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;


@Path("subjects")
public class SubjectController {

    @EJB
    private SubjectDAO subjectDAO;

    @GET
    @Produces("application/json; charset=UTF-8")
    public Response getAll(){
        List<SubjectDTO> ret = subjectDAO.getAll().stream().map(SubjectDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }
}
