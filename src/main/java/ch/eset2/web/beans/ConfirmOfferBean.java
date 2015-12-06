/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.Message;
import ch.eset2.model.Offer;
import ch.eset2.model.dao.MessageFacade;
import ch.eset2.web.converter.DateConverter;
import ch.eset2.web.util.MessageState;
import ch.eset2.web.util.MessageType;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * Provides a service to confirm an {@link Offer} and creates a confirmation message.
 * 
 * @author Mischa Wenger
 * @version 2.0
 */
@RequestScoped
@Named
public class ConfirmOfferBean {
    
    @Inject
    private MessageFacade messageFacade;
    
   public void confirm(Offer offer){
        Message confirmation = new Message();
        confirmation.setMessageState(MessageState.NEW);
        confirmation.setMessageType(MessageType.MESSAGE);
        confirmation.setSubject("Angenommen: " + offer.getSubject());
        confirmation.setMessageText("Ihre Offerte wurde erfolgreich angenommen. Vielen Dank, dass Sie unsere Dienst nutzen!<br/>"
                + "Hier sehen Sie die Konditionen: <br/>" +
                offer.toHtmlFormatedString());
        confirmation.setSender((Customer) SecurityUtils.getSubject().getPrincipal());
        confirmation.setReceiver(offer.getSender());
        confirmation.setSendDate(DateConverter.currentTimeAsString());
        messageFacade.create(confirmation);
        
    }
    
}
