package at.htl.gavric.reisebuero.business.facades;

import at.htl.gavric.reisebuero.entity.Payment;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PaymentFacade {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Payment payment){
        entityManager.persist(payment);
    }

    public List<Payment> findAll(){
        return entityManager.createQuery("select p from Payment p").getResultList();
    }

    public void setEm(EntityManager em) {
        this.entityManager = em;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
