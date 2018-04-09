package at.htl.gavric.reisebuero.business.facades;

import at.htl.gavric.reisebuero.entity.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CustomerFacade {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Customer customer){
        entityManager.persist(customer);
    }

    public List<Customer> findAll(){
        return entityManager.createQuery("select c from Customer c").getResultList();
    }

    public void setEm(EntityManager em) {
        this.entityManager = em;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}

