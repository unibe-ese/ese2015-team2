package ch.eset2.model.dao;

import ch.eset2.model.Customer;
import ch.eset2.model.Message;
import ch.eset2.model.Offer;
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
public class MessageFacade extends AbstractFacade<Message> {

    @PersistenceContext(unitName = "eset2_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MessageFacade() {
        super(Message.class);
    }
    
    public List<Message> findMessageByReceiver(Customer receiver){
        return em.createNamedQuery("Message.findByReceiver").setParameter("receiver", receiver).getResultList();
    }
    
    // TODO: Mischa, move this to seperate OfferFacade
    public List<Offer> findOfferByReceiver(Customer receiver){
        return em.createNamedQuery("Offer.findByReceiver").setParameter("receiver", receiver).getResultList();
    }
}
