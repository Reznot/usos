package pl.poznan.uam.Controllers;

import pl.poznan.uam.DAO.SubjectDAO;
import pl.poznan.uam.DTOs.SubjectDTO;
import pl.poznan.uam.Utils.SubjectToEntity;
import pl.poznan.uam.entities.SubjectEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
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

    @GET
    @Path("code")
    @Produces("application/json; charset=UTF-8")
    public Response getBySubjectCode(@Context UriInfo info){
        String code = info.getQueryParameters().getFirst("subjectcode");

        List<SubjectDTO> ret = subjectDAO.getAll().stream().filter(subject -> subject.getSubjectCode().equals(code)).map(SubjectDTO::new).collect(Collectors.toList());

        if (ret.size() == 0){
            return Response.status(404).build();//TODO atrapa, chyba tak nie moze zostac
        }
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Path("subjectname")
    @Produces("application/json; charset=UTF-8")
    public Response getBySubjectName(@Context UriInfo info){
        String name = info.getQueryParameters().getFirst("name");

        List<SubjectDTO> ret = subjectDAO.getAll().stream().filter(subject -> subject.getSubjectName().equals(name)).map(SubjectDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Path("byYear")
    @Produces("application/json; charset=UTF-8")
    public Response getByYear(@Context UriInfo info){
        int year = Integer.valueOf(info.getQueryParameters().getFirst("year"));

        List<SubjectDTO> ret = subjectDAO.getAll().stream().filter(subject -> subject.getYear() == year).map(SubjectDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Path("bysemester")
    @Produces("application/json; charset=UTF-8")
    public Response getBySemester(@Context UriInfo info){
        String semester = info.getQueryParameters().getFirst("semester");

        List<SubjectDTO> ret = subjectDAO.getAll().stream().filter(subject -> subject.getSemester().equals(semester)).map(SubjectDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    @POST
    @Path("addSubject")
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response addSubject(SubjectDTO subject){
        SubjectEntity subjectEnt = subjectDAO.addSubject(SubjectToEntity.subjectToEntity(subject));
        SubjectDTO finalSubjectDTO = new SubjectDTO(subjectEnt);
        return Response.status(201).entity(finalSubjectDTO).build();
    }

    @DELETE
    @Path("delete/{id}")
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response removeSubject(@PathParam("id") long id){
        subjectDAO.remove(id);
        return Response.status(204).build();
    }
    //TODO nie usuwa z bazy

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response editSubject(SubjectDTO subject){
        subjectDAO.update(SubjectToEntity.subjectToEntity(subject));
        return Response.status(200).entity(subject).build();
    }//TODO cos sie wypierdala; dopracuj
}
