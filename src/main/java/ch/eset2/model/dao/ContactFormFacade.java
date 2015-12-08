package ch.eset2.model.dao;

import ch.eset2.model.ContactForm;
//import ch.eset2.model.Offer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Eve Mendoza
 * @version 2.0
 */
@Stateless
public class ContactFormFacade extends AbstractFacade<ContactForm> {

    @PersistenceContext(unitName = "eset2_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactFormFacade() {
        super(ContactForm.class);
    }
    
   /* public List<Message> findMessageByReciever(String reciever){
        return em.createNamedQuery("Message.findByReciever").setParameter("reciever", reciever).getResultList();
    }
    
    public List<Offer> findOfferByReciever(String reciever){
        return em.createNamedQuery("Offer.findByReciever").setParameter("reciever", reciever).getResultList();
    }
*/
}
