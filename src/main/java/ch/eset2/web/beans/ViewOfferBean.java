package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.Offer;
import ch.eset2.model.dao.MessageFacade;
import ch.eset2.web.util.MessageState;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * Responsible to display an offer.
 *
 * @author Mischa Wenger
 * @version 2.0
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

    public void init() {
        customer = offer.getReceiver();
        Customer loggedInCustomer = (Customer) SecurityUtils.getSubject().getPrincipal();
        myOffer = loggedInCustomer.getUsername().equals(customer.getUsername());
        if (offer.getMessageState() == MessageState.NEW) {
            offer.setMessageState(MessageState.READ);
        }
        messageFacade.edit(offer);
    }

    public boolean isMyOffer() {
        return myOffer;
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
