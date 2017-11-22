/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.udea.proovedorrestudea.model.Manufacturer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author hcamilo.lopez
 */
@Stateless
@Path("manufacturer")
public class ManufacturerFacadeREST extends AbstractFacade<Manufacturer> {

    @PersistenceContext(unitName = "com.udea_ProovedorRestUdea_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public ManufacturerFacadeREST() {
        super(Manufacturer.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Manufacturer entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes( MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Manufacturer entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces( MediaType.APPLICATION_JSON)
    public Manufacturer find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces( MediaType.APPLICATION_JSON)
    public List<Manufacturer> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces( MediaType.APPLICATION_JSON)
    public List<Manufacturer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
