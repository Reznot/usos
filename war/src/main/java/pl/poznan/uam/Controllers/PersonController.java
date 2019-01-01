package pl.poznan.uam.Controllers;


import pl.poznan.uam.DAO.PersonDAO;
import pl.poznan.uam.DTOs.PersonDTO;
import pl.poznan.uam.DTOs.PersonShortDTO;
import pl.poznan.uam.DTOs.StudentDTO;
import pl.poznan.uam.Utils.PersonToEntity;
import pl.poznan.uam.entities.PersonEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("person")
public class PersonController {

    @EJB
    private PersonDAO personDAO;

    @GET
    @Produces("application/json; charset=UTF-8")
    public Response getAll() {
        List<PersonDTO> ret = personDAO.getAll().stream().map(PersonDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    @POST
    @Path("addStudent")
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response addStudent(StudentDTO studentDTO) {
        PersonEntity personEnt = personDAO.addPerson(PersonToEntity.studentToEntity(studentDTO));
        StudentDTO finalStudentDTO = new StudentDTO(personEnt);
        return Response.status(201).entity(finalStudentDTO).build();
    }

    @POST
    @Path("addPerson")
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response addPerson(PersonDTO personDTO) {
        PersonEntity personEnt = personDAO.addPerson(PersonToEntity.toEntity(personDTO));
        PersonDTO finalPersonDTO = new PersonDTO(personEnt);
        return Response.status(201).entity(finalPersonDTO).build();
    }
}
