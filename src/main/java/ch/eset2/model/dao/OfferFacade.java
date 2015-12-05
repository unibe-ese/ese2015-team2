package ch.eset2.model.dao;

import ch.eset2.model.Customer;
import ch.eset2.model.Offer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Mischa Wenger
 * @version 1.0
 */
@Stateless
public class OfferFacade extends AbstractFacade<Offer> {

    @PersistenceContext(unitName = "eset2_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OfferFacade() {
        super(Offer.class);
    }
   
    public List<Offer> findOfferByReceiver(Customer receiver){
        return em.createNamedQuery("Offer.findByReceiver").setParameter("receiver", receiver).getResultList();
    }
}
