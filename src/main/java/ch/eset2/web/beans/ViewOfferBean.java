package ch.eset2.web.beans;


import ch.eset2.model.Customer;
import ch.eset2.model.Offer;
import ch.eset2.model.dao.MessageFacade;
import ch.eset2.web.util.MessageState;
import ch.eset2.web.util.Navigation;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * Responsible to display an offer.
 * 
 * @author Mischa Wenger
 * @version 1.0
 */
@Named
@ViewScoped
public class ViewOfferBean implements Serializable {
    
    
    @Inject
    private MessageFacade messageFacade;
    
    @Inject
    private AddFriendBean addFriendBean;
    
    @Inject
    private ConfirmOfferBean confirmOfferBean;
    
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
    
    
    /**
     * Persists to the database that a customer has accepted the displayed offer.
     * The customers become friends when they have an accepted offer.
     * @return the navigationpage for fail, when the transaction failed or the
     *  offer was already accepted. Acceptsuccess when everything went ok.
     */
    public String acceptOffer(){
       if (true && !offer.isAccepted()){ //Here would be a link to paypal etc. to confim that the user payed
       offer.setMessageState(MessageState.ACCEPTED);
       messageFacade.edit(offer);
       addFriendBean.addFriend(offer.getReceiver(), offer.getSender());
       confirmOfferBean.confirm(offer);
       return Navigation.ACCEPTSUCCESS;
       }
       else {
       return Navigation.OFFERFAILED;
       }
    }
  
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
