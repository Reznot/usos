package pl.poznan.uam.Controllers;


import pl.poznan.uam.DAO.PersonDAO;
import pl.poznan.uam.DTOs.EmployeeDTO;
import pl.poznan.uam.DTOs.PersonDTO;
import pl.poznan.uam.DTOs.PersonShortDTO;
import pl.poznan.uam.DTOs.StudentDTO;
import pl.poznan.uam.Utils.PersonToEntity;
import pl.poznan.uam.entities.PersonEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
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
        List<PersonShortDTO> personList = personDAO.getAll().stream().map(PersonShortDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(personList).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json; charset=UTF-8")
    public Response getById(@PathParam("id") long id) {
        PersonShortDTO person = new PersonShortDTO(personDAO.getPersonById(id).get());
        return Response.status(200).entity(person).build();
    }

    @GET
    @Path("search")
    @Produces("application/json; charset=UTF-8")
    public Response findPersonByName(@Context UriInfo info) {
        String name = info.getQueryParameters().getFirst("name");
        String surname = info.getQueryParameters().getFirst("surname");
        List<PersonShortDTO> personList = personDAO.getAll().stream().filter(personEnt -> personEnt.getNameAndSurname().equals(name+" "+surname)).map(PersonShortDTO::new).collect(Collectors.toList());

        return Response.status(200).entity(personList).build();
    }




}
