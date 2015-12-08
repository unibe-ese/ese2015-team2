package ch.eset2.model.dao;

import ch.eset2.model.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Marc Jost
 * @version 1.0
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {

    private static final long serialVersionUID = 1419934319475299144L;
    
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
