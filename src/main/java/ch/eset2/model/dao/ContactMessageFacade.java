package ch.eset2.model.dao;

import ch.eset2.model.ContactMessage;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Eve Mendoza
 * @version 2.0
 */
@Stateless
public class ContactMessageFacade extends AbstractFacade<ContactMessage> {

    private static final long serialVersionUID = -6676082552827644496L;
    
    @PersistenceContext(unitName = "eset2_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactMessageFacade() {
        super(ContactMessage.class);
    }
    
   /* public List<Message> findMessageByReciever(String reciever){
        return em.createNamedQuery("Message.findByReciever").setParameter("reciever", reciever).getResultList();
    }
    
    public List<Offer> findOfferByReciever(String reciever){
        return em.createNamedQuery("Offer.findByReciever").setParameter("reciever", reciever).getResultList();
    }
*/
}
