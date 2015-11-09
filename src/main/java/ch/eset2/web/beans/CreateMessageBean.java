/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.beans;

import ch.eset2.model.Message;
import ch.eset2.model.dao.MessageFacade;
import ch.eset2.web.util.Navigation;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Mischa Wenger / Eve Mendoza
 */
@Named(value = "createMessageBean")
@RequestScoped
public class CreateMessageBean implements Serializable {
    
    @Inject
    private MessageFacade messageFacade;
    
    private Message newMessage;
    
    /**
     * Creates a new instance of RegistrationBean
     */
    public CreateMessageBean() {
    }
    
    @PostConstruct
    private void init(){
        newMessage = new Message();
    }
    
    public String createNewMessage(){
        messageFacade.create(newMessage);
        return Navigation.REGSUCCESS;
    }

    public Message getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(Message newMessage) {
        this.newMessage = newMessage;
    }
}
