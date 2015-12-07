package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.Offer;
import ch.eset2.model.dao.OfferFacade;
import ch.eset2.web.converter.DateConverter;
import ch.eset2.web.util.CommissionConstants;
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
 * CreateOfferBean provides an offer creation service.
 * It allows to persist a new offer to the database.
 * {@link CreateOfferBean#init() } should be called from the server before
 * using any service of this class.
 * 
 * @author Mischa Wenger 
 * @author Eve Mendoza
 * @version 2.0
 */
@Named(value = "createOfferBean")
@ViewScoped
public class CreateOfferBean implements Serializable {
    
    @Inject
    private OfferFacade offerFacade;
    
    private Customer receiver;
    
    private Offer newOffer;
    /**
     * Creates a new instance of CreateOfferBean
     */
    public CreateOfferBean() {
    }
    
    @PostConstruct
    private void init(){
        newOffer = new Offer();
        Customer loggedInCustomer = (Customer) SecurityUtils.getSubject().getPrincipal();
        newOffer.setSender(loggedInCustomer);
    }
    
    
    /**
     * Persists the new offer to the database.
     * @param receiver that should recieve the offer
     * @return the "sendSuccess.xhtml" page to indicate that the offer was sent.
     */
    public String createNewOffer(Customer receiver){
        newOffer.setMessageType(MessageType.OFFER);
        newOffer.setSendDate(DateConverter.currentTimeAsString());
        newOffer.setMessageState(MessageState.NEW);
        newOffer.setCommission(String.format("%.2f", newOffer.getFee() * CommissionConstants.COMMISSION));
        newOffer.setReceiver(receiver);
        offerFacade.create(newOffer);
        return Navigation.SENDSUCCESS;
    }
    
    //getters and setters
    public Offer getNewOffer() {
        return newOffer;
    }

    public void setNewOffer(Offer newOffer) {
        this.newOffer = newOffer;
    }
        
    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }
}
