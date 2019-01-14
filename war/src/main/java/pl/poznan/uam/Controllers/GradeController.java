package pl.poznan.uam.Controllers;

import pl.poznan.uam.DAO.GradeDAO;
import pl.poznan.uam.DTOs.EmployeeDTO;
import pl.poznan.uam.DTOs.Grade;
import pl.poznan.uam.DTOs.GradeDTO;
import pl.poznan.uam.DTOs.PersonShortDTO;
import pl.poznan.uam.QueriesMapping.StudentWithSubjectAndGrades;
import pl.poznan.uam.Utils.GradeToEntity;
import pl.poznan.uam.Utils.PersonToEntity;
import pl.poznan.uam.entities.GradeEntity;
import pl.poznan.uam.entities.PersonEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("grade")
public class GradeController {

    @EJB
    private GradeDAO gradeDAO;

    @POST
    @Path("add")
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response addGrade(GradeDTO gradeDTO) {
        GradeEntity gradeEnt = gradeDAO.addGrade(GradeToEntity.gradeToEntity(gradeDTO));
        GradeDTO finalGradeDTO= new GradeDTO(gradeEnt);
        return Response.status(201).entity(finalGradeDTO).build();
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    public Response getGradesFromSubjectGroup(@Context UriInfo info) {
        String groupShortcut = info.getQueryParameters().getFirst("groupShortcut");
        List<Grade> gradesList = gradeDAO.getGradesFromSubjectGroup(groupShortcut).stream().map(Grade::new).collect(Collectors.toList());
        return Response.status(200).entity(gradesList).build();
    }

    @GET
    @Path("studentsummary")
    @Produces("application/json; charset=UTF-8")
    public Response getStudentGrades(@Context UriInfo info) {
        long studentId = Long.parseLong(info.getQueryParameters().getFirst("studentId"));
        return Response.status(200).entity((gradeDAO.getStudentGradesFromAllSubjects(studentId))).build();
    }

}
