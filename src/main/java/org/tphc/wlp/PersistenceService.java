package org.tphc.wlp;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("persistence")
public class PersistenceService{
    
    @PersistenceContext
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findall")
    public Response findall(){
        return Response.ok(entityManager.createQuery("select s from SimpleEntity s").getResultList()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("insert")
    @Transactional
    public Response insert(){
        final List<SimpleEntity> list = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            SimpleEntity s = new SimpleEntity();
            list.add(s);
            entityManager.persist(s);
        }
        return Response.ok(list).build();
    }
}