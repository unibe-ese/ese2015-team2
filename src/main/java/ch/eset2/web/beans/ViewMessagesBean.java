/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.beans;

import ch.eset2.model.Message;
import ch.eset2.model.dao.MessageFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author foxhound
 */
@Named
@ViewScoped
public class ViewMessagesBean implements Serializable {
    
    @Inject
    private MessageFacade messageFacade;
    
    private List<Message> messages;
    
    @PostConstruct
    private void init(){
        messages = messageFacade.findAll();
    }
    
    public List<Message> getMessages(){
        return messages;
    }
    
}
