package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.Message;
import ch.eset2.model.Offer;
import ch.eset2.model.dao.MessageFacade;
import ch.eset2.web.converter.DateConverter;
import ch.eset2.web.util.MessageState;
import ch.eset2.web.util.MessageType;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * Provides a service to confirm an {@link Offer} and to create a
 * confirmation message.
 * 
 * @author Mischa Wenger
 * @version 2.0
 */
@RequestScoped
@Named
public class ConfirmOfferBean implements Serializable {

    private static final long serialVersionUID = 2030159759374265509L;
    
    @Inject
    private MessageFacade messageFacade;
   
   /**
    * Confirms a given offer by sending a confirmation to the {@link Customer} 
    * that sent the offer. The confirmation message is formated with html.
    * @param offer that has to be confirmed.
    */ 
   public void confirm(Offer offer){
        Message confirmation = new Message();
        confirmation.setMessageState(MessageState.NEW);
        confirmation.setMessageType(MessageType.MESSAGE);
        confirmation.setSubject("Angenommen: " + offer.getSubject());
        confirmation.setMessageText("Ihre Offerte wurde erfolgreich angenommen. Vielen Dank, dass Sie unseren Dienst nutzen!<br/>"
                + "Hier sehen Sie die Konditionen: <br/>" +
                offer.toHtmlFormatedString());
        confirmation.setSender((Customer) SecurityUtils.getSubject().getPrincipal());
        confirmation.setReceiver(offer.getSender());
        confirmation.setSendDate(DateConverter.currentTimeAsString());
        messageFacade.create(confirmation);
    }
}