package pl.poznan.uam.Controllers;

import pl.poznan.uam.DAO.SubjectDAO;
import pl.poznan.uam.DAO.SubjectGroupDAO;
import pl.poznan.uam.DTOs.SubjectDTO;
import pl.poznan.uam.DTOs.SubjectGroupDTO;
import pl.poznan.uam.DTOs.SubjectGroupLecturedByDTO;
import pl.poznan.uam.DTOs.SubjectGroupShortDTO;
import pl.poznan.uam.Utils.SubjectGroupToEntity;
import pl.poznan.uam.entities.SubjectEntity;
import pl.poznan.uam.entities.SubjectGroupEntity;

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

    @EJB
    private SubjectDAO subjectDAO;  //to sie moze wyjebac, be careful

    @GET
    @Produces("application/json; charset=UTF-8")
    public Response getAll() {
        List<SubjectGroupShortDTO> ret = subjectGroupDAO.getAll().stream().map(SubjectGroupShortDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Path("groupshortcut")
    @Produces("application/json; charset=UTF-8")
    public Response getByShortcut(@Context UriInfo info){
        String groupshortcut = info.getQueryParameters().getFirst("groupshortcut");

        List<SubjectGroupShortDTO> ret = subjectGroupDAO.getAll().stream().filter(sg -> sg.getGroupShortcut().equals(groupshortcut)).map(SubjectGroupShortDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Path("classtype")
    @Produces("application/json; charset=UTF-8")
    public Response getByClassType(@Context UriInfo info){
        String classtype = info.getQueryParameters().getFirst("type");

        List<SubjectGroupShortDTO> ret = subjectGroupDAO.getAll().stream().filter(sg -> sg.getClassType().equals(classtype)).map(SubjectGroupShortDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Path("lecturedBy")                                                                     //map(SubjectGroupLecturedByDTO::new
    @Produces("application/json; charset=UTF-8")
    public Response getByLecturer(@Context UriInfo info) {
        long lecturer_id = Integer.valueOf(info.getQueryParameters().getFirst("id"));

        List<SubjectGroupLecturedByDTO> ret = subjectGroupDAO.getSubjectGroupByLecturer().stream().filter(sg -> sg.getLecturer_id() == lecturer_id).map(ent -> new SubjectGroupLecturedByDTO(ent)).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Path("groupsBySubjectCode")
    @Produces("application/json; charset=UTF-8")
    public Response getBySubjectCode(@Context UriInfo info){
        String code = info.getQueryParameters().getFirst("code");

        SubjectEntity subject = subjectDAO.getAll().stream().filter(s -> s.getSubjectCode().equals(code)).findFirst().get();

        List<SubjectGroupShortDTO> ret = subjectGroupDAO.getAll().stream().filter(sg -> sg.getSubject_id() == subject.getId()).map(SubjectGroupShortDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    @POST
    @Path("addSubjectGroup")
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response addSubjectGroup (SubjectGroupDTO subjectGroupDTO){
        SubjectGroupEntity subjectGroupEnt = subjectGroupDAO.addSubjectGroup(SubjectGroupToEntity.subjectGroupToEntity(subjectGroupDTO));
        SubjectGroupDTO finalSubjectGroupDTO = new SubjectGroupDTO(subjectGroupEnt);
        return Response.status(201).entity(finalSubjectGroupDTO).build();
    }
    //TODO metody do wyciagania po przedmiocie, prowadzcym itd w DAO, nowe dtos, zmapowanie encji subjectGroup_Person
}
