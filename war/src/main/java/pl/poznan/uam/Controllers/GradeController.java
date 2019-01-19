package pl.poznan.uam.Controllers;

import com.itextpdf.text.DocumentException;
import pl.poznan.uam.DAO.GradeDAO;
import pl.poznan.uam.DTOs.EmployeeDTO;
import pl.poznan.uam.DTOs.Grade;
import pl.poznan.uam.DTOs.GradeDTO;
import pl.poznan.uam.DTOs.PersonShortDTO;
import pl.poznan.uam.Email;
import pl.poznan.uam.QueriesMapping.StudentWithSubjectAndGrades;
import pl.poznan.uam.Utils.GradeToEntity;
import pl.poznan.uam.Utils.PDFFromJson;
import pl.poznan.uam.Utils.PersonToEntity;
import pl.poznan.uam.entities.GradeEntity;
import pl.poznan.uam.entities.PersonEntity;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("grade")
public class GradeController {

    @EJB
    private GradeDAO gradeDAO;

    @EJB
    private Email email;

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
    public Response getStudentGrades(@Context UriInfo info) throws IOException, DocumentException, MessagingException {
        long studentId = Long.parseLong(info.getQueryParameters().getFirst("studentId"));
        PDFFromJson pdfFromJson = new PDFFromJson();
        String url = pdfFromJson.createSummary(gradeDAO.getStudentGradesFromAllSubjects(studentId));
        email.sendMail(gradeDAO.getStudentGradesFromAllSubjects(studentId).getEmail(), "Summary of your studies", "Hi!\n" +
                "Summary of your studies is now generated. To download it go "+url +
                "  Have a nice day!\n" +
                "  USOS\n");
        return Response.status(200).entity((gradeDAO.getStudentGradesFromAllSubjects(studentId))).build();
    }

}
