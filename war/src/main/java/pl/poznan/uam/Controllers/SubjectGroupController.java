package pl.poznan.uam.Controllers;

import pl.poznan.uam.DAO.SubjectGroupDAO;
import pl.poznan.uam.DTOs.SubjectGroupDTO;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.stream.Collectors;

@Path("groups")
public class SubjectGroupController {

    @EJB
    private SubjectGroupDAO subjectGroupDAO;

    @GET
    @Produces("application/json; charset=UTF-8")
    public Response getAll() {
        List<SubjectGroupDTO> ret = subjectGroupDAO.getAll().stream().map(SubjectGroupDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Path("groupshortcut")
    @Produces("application/json; charset=UTF-8")
    public Response getByShortcut(@Context UriInfo info){
        String groupshortcut = info.getQueryParameters().getFirst("groupshortcut");

        List<SubjectGroupDTO> ret = subjectGroupDAO.getAll().stream().filter(sg -> sg.getGroupShortcut().equals(groupshortcut)).map(SubjectGroupDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Path("classtype")
    @Produces("application/json; charset=UTF-8")
    public Response getByClassType(@Context UriInfo info){
        String classtype = info.getQueryParameters().getFirst("type");

        List<SubjectGroupDTO> ret = subjectGroupDAO.getAll().stream().filter(sg -> sg.getClassType().equals(classtype)).map(SubjectGroupDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    //TODO metody do wyciagania po przedmiocie, prowadzcym itd w DAO, nowe dtos
}
