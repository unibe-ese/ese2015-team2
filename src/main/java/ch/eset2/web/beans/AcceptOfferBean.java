package ch.eset2.web.beans;

import ch.eset2.model.Offer;
import ch.eset2.model.dao.MessageFacade;
import ch.eset2.web.util.MessageState;
import ch.eset2.web.util.Navigation;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Provides the service to accept an given {@link Offer}.
 *
 * @author Mischa Wenger
 * @version 2.0
 */
@RequestScoped
@Named
public class AcceptOfferBean {

    @Inject
    private MessageFacade messageFacade;
    
    @Inject
    private AddFriendBean addFriendBean;
    
    @Inject
    private ConfirmOfferBean confirmOfferBean;
    
    //The boolean that would be set by the paying process of paypal.
    private boolean successfulPayPalProcess = true; 
    
    /**
     * Persists to the database that a customer has accepted an {@link Offer}.
     * The customers become friends when they have an accepted offer.
     * @param offer that has to be accepted.
     * @return the navigationpage for fail, when the transaction failed or the
     * offer was already accepted. Acceptsuccess when everything went ok.
     */
    public String acceptOffer(Offer offer) {
        if (successfulPayPalProcess && !offer.isAccepted()) {
            offer.setMessageState(MessageState.ACCEPTED);
            messageFacade.edit(offer);
            addFriendBean.addFriend(offer.getReceiver(), offer.getSender());
            confirmOfferBean.confirm(offer);
            return Navigation.ACCEPTSUCCESS;
        } else {
            return Navigation.OFFERFAILED;
        }
    }

    public boolean isSuccessfulPayPalProcess() {
        return successfulPayPalProcess;
    }

    public void setSuccessfulPayPalProcess(boolean successfulPayPalProcess) {
        this.successfulPayPalProcess = successfulPayPalProcess;
    }
}
