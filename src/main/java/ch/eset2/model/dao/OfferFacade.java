package ch.eset2.model.dao;

import ch.eset2.model.Customer;
import ch.eset2.model.Offer;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * To access the {@link Offer} from the database.
 * @author Mischa Wenger
 * @version 2.0
 */
@Stateless
public class OfferFacade extends AbstractFacade<Offer> implements Serializable {

    private static final long serialVersionUID = -2336343714463772160L;
    
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
