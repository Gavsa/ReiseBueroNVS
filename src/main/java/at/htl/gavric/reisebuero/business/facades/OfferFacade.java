package at.htl.gavric.reisebuero.business.facades;

import at.htl.gavric.reisebuero.entity.Offer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class OfferFacade {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Offer offer){
        entityManager.persist(offer);
    }

    public List<Offer> findAll(){
        return entityManager.createQuery("select o from Offer o").getResultList();
    }

    public void setEm(EntityManager em) {
        this.entityManager = em;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
