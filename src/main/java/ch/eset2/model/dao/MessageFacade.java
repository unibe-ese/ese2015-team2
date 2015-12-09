package ch.eset2.model.dao;

import ch.eset2.model.Customer;
import ch.eset2.model.Message;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * To access the {@link Message} from the database.
 * 
 * @author Mischa Wenger
 * @version 1.0
 */
@Stateless
public class MessageFacade extends AbstractFacade<Message> {

    private static final long serialVersionUID = 4539421951884723474L;

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
}