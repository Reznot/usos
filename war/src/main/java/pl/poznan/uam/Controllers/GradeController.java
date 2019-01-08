package pl.poznan.uam.Controllers;

import pl.poznan.uam.DAO.GradeDAO;
import pl.poznan.uam.DTOs.Grade;
import pl.poznan.uam.DTOs.PersonShortDTO;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.stream.Collectors;

@Path("grade")
public class GradeController {

    @EJB
    private GradeDAO gradeDAO;

    @GET
    @Produces("application/json; charset=UTF-8")
    public Response getGradesFromSubjectGroup(@Context UriInfo info) {
        String groupShortcut = info.getQueryParameters().getFirst("groupShortcut");
        List<Grade> gradesList = gradeDAO.getGradesFromSubjectGroup(groupShortcut).stream().map(Grade::new).collect(Collectors.toList());
        return Response.status(200).entity(gradesList).build();
    }

}
