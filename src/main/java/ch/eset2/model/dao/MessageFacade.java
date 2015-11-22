package ch.eset2.model.dao;

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
    
    public List<Message> findMessageByReciever(String reciever){
        return em.createNamedQuery("Message.findByReciever").setParameter("reciever", reciever).getResultList();
    }
    
    public List<Offer> findOfferByReciever(String reciever){
        return em.createNamedQuery("Offer.findByReciever").setParameter("reciever", reciever).getResultList();
    }
}
