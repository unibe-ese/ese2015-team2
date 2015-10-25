package ch.eset2.model.dao;

import ch.eset2.model.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * {Insert description here}
 * @author Marc Jost, 17.10.2015
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {
    @PersistenceContext(unitName = "eset2_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
    public List<Customer> findCustomerByUsername(String username){
        return em.createNamedQuery("Customer.findByUsername").setParameter("username", username).getResultList();
    }

}
