package ch.eset2.web.beans;


import ch.eset2.model.Customer;
import ch.eset2.model.Message;
import ch.eset2.model.Offer;
import ch.eset2.model.dao.MessageFacade;
import ch.eset2.web.converter.DateConverter;
import ch.eset2.web.util.MessageState;
import ch.eset2.web.util.MessageType;
import ch.eset2.web.util.Navigation;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * Responsible to display an offer
 * 
 * @author Mischa Wenger
 * @version 1.0
 */
@Named
@ViewScoped
public class ViewOfferBean implements Serializable {
    
    
    @Inject
    private MessageFacade messageFacade;
    
    private Customer customer;
    
    private Offer offer;
    private boolean inReplyState = false;
    
    private boolean myOffer = false;
    
    public void init(){
        customer = offer.getReceiver();
        Customer loggedInCustomer = (Customer) SecurityUtils.getSubject().getPrincipal();
        myOffer = loggedInCustomer.getUsername().equals(customer.getUsername());
        if (offer.getMessageState() == MessageState.NEW){
            offer.setMessageState(MessageState.READ);
        }
        messageFacade.edit(offer);
    }
    
    public boolean isMyOffer(){
        return myOffer;
    }
    
    public String acceptOffer(){
       if (true && !offer.isAccepted()){ //Here would be a link to paypal etc. to confim that the user payed
       offer.setMessageState(MessageState.ACCEPTED);
       messageFacade.edit(offer);
       sendConfirmation();
       return Navigation.ACCEPTSUCCESS;
       }
       else {
       return Navigation.OFFERFAILED;
       }
    }

    
    private void sendConfirmation(){
        Message confirmation = new Message();
        confirmation.setMessageState(MessageState.NEW);
        confirmation.setMessageType(MessageType.MESSAGE);
        confirmation.setSubject("Angenommen: " + offer.getSubject());
        confirmation.setMessageText("Ihre Offerte wurde erfolgreich angenommen. <br/>"
                + "Hier sehen Sie die Konditionen: <br/>" +
                offer.toFormatedString());
        confirmation.setSender((Customer) SecurityUtils.getSubject().getPrincipal());
        confirmation.setReceiver(offer.getSender());
        confirmation.setSendDate(DateConverter.currentTimeAsString());
        messageFacade.create(confirmation);
        
    }
    /*public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
   
*/    
    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public boolean isInReplyState() {
        return inReplyState;
    }

    public void setInReplyState(boolean inReplyState) {
        this.inReplyState = inReplyState;
    }
    
    
    
}
