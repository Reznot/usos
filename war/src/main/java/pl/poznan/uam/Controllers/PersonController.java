package pl.poznan.uam.Controllers;


import pl.poznan.uam.DTOs.PersonDTO;
import pl.poznan.uam.DTOs.PersonShortDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("person")
public class PersonController {

    @GET
    @Produces("application/json; charset=UTF-8")
    public Response getAll() {

        PersonShortDTO person1 = new PersonShortDTO(1l, "Hubert", "Staszek");
        PersonShortDTO person2 = new PersonShortDTO(2l, "Łukasz", "Siwocha");

        ArrayList<PersonShortDTO> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);

        return Response.status(200).entity(personList).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json; charset=UTF-8")
    public Response getById(@PathParam("id") int id) {
        PersonDTO person = new PersonDTO(1l, 123456, "00998876543", 1,
                "Hubert", "Staszek", "dr inż", "kappa@gmail.com");
    return Response.status(200).entity(person).build();
    }

}
