package net.nortlam.rest;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.nortlam.entity.Person;

/**
 *
 * @author Mauricio "Maltron" Leal */
@Stateless
@Path("person")
public class PersonResource {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @GET @Path("{ID}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Person findByID(@PathParam("ID")int ID) {
        return entityManager.find(Person.class, ID);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Person> findAll() {
        return (Collection<Person>)entityManager.createNamedQuery(Person.FIND_ALL).getResultList();
    }
}
