/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import entity.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
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
 * @author yinqinghao
 */
@Stateless
@Path("entity.safehouse")
public class SafeHouseFacadeREST extends AbstractFacade<SafeHouse> {

    @PersistenceContext(unitName = "safeHouseWebServicePU")
    private EntityManager em;

    public SafeHouseFacadeREST() {
        super(SafeHouse.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(SafeHouse entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, SafeHouse entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public SafeHouse find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<SafeHouse> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<SafeHouse> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("/getNearestSafeHouse/{lat}/{lng}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getNearestSafeHouse(@PathParam("lat") double lat, 
            @PathParam("lng") double lng) {
        Object obj = em.createNativeQuery("SELECT s.*" +
                "      , ( ACOS( COS( RADIANS( ?1  ) ) " +
                "              * COS( RADIANS( s.Latitude ) )" +
                "              * COS( RADIANS( s.Longitude ) - RADIANS( ?2 ) )" +
                "              + SIN( RADIANS( ?3  ) )" +
                "              * SIN( RADIANS( s.Latitude ) )" +
                "          )" +
                "        * 6371000" +
                "        ) AS distance_in_km" +
                "  FROM safe_house s" +
                " ORDER BY distance_in_km ASC" +
                " LIMIT 1")
                .setParameter(1, lat)
                .setParameter(2, lng)
                .setParameter(3, lat)
                .getResultList();
        Object [] o = (Object[])((Vector)obj).get(0);
        Map<String, String> map = new HashMap<>();
        map.put("id", o[0].toString());
        map.put("lng", o[1].toString());
        map.put("lat", o[2].toString());
        map.put("placeName", o[3].toString());
        map.put("streetNum", o[4].toString());
        map.put("road", o[5].toString());
        map.put("roadType", o[6].toString());
        map.put("postcode", o[7].toString());
        map.put("state", o[8].toString());
        map.put("oType", o[9].toString());
        map.put("distance", o[10].toString());
        Gson gson = new Gson();
        String res = gson.toJson(map);
        return res;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
