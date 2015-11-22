package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.Offer;
import ch.eset2.model.dao.MessageFacade;
import ch.eset2.web.converter.DateConverter;
import ch.eset2.web.util.MessageState;
import ch.eset2.web.util.MessageType;
import ch.eset2.web.util.Navigation;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * CreateMessageBean provides a message send service.
 * It allows to persist a new message to the database.
 * {@link CreateMessageBean#init() } should be called from the server before
 * using any service of this class.
 * @author Mischa Wenger / Eve Mendoza
 */
@Named(value = "createOfferBean")
@ViewScoped
public class CreateOfferBean implements Serializable {
    
    @Inject
    private MessageFacade messageFacade;
    
    private Customer reciever;
    
    private Offer newOffer;
    /**
     * Creates a new instance of CreateMessageBean
     */
    public CreateOfferBean() {
    }
    
    @PostConstruct
    private void init(){
        newOffer = new Offer();
        Customer loggedInCustomer = (Customer) SecurityUtils.getSubject().getPrincipal();
        newOffer.setSender(loggedInCustomer.getUsername());
        
    }
    
    
    /**
     * Persists the new offer to the database.
     * @param receiver that should recieve the offer
     * @return the "sendSuccess.xhtml" page to indicate that the offer was sent.
     */
    public String createNewOffer(String receiver){
        setGivenParameters(receiver);
        messageFacade.create(newOffer);
        return Navigation.SENDSUCCESS;
    }
    
     private void setGivenParameters(String reciever){
        newOffer.setMessageType(MessageType.OFFER);
        newOffer.setDate(DateConverter.currentTimeAsString());
        newOffer.setMessageState(MessageState.NEW);
        newOffer.setReciever(reciever);
    }
    
          
    //getters and setters
    public Offer getNewOffer() {
        return newOffer;
    }

    public void setNewOffer(Offer newOffer) {
        this.newOffer = newOffer;
    }
        
    public Customer getReciever() {
        return reciever;
    }

    public void setReciever(Customer reciever) {
        this.reciever = reciever;
    }
}
