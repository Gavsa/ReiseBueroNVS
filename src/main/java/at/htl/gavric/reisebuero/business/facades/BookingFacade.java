package at.htl.gavric.reisebuero.business.facades;

import at.htl.gavric.reisebuero.entity.Booking;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BookingFacade {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Booking booking){
        entityManager.persist(booking);
    }

    public void update(Booking booking){
        entityManager.merge(booking);
    }

    public List findAll(){
        return entityManager.createQuery("select b from Booking b").getResultList();
    }



    public void setEm(EntityManager em) {
        this.entityManager = em;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
