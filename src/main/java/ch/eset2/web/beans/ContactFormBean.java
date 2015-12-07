package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.ContactMessage;
import ch.eset2.model.dao.ContactMessageFacade;
import ch.eset2.web.converter.DateConverter;
import ch.eset2.web.util.Navigation;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;
//import javax.enterprise.context.RequestScoped;


/**
 * ContactFormBean provides a form for users to get in contact with staff.
 * It allows to persist a new ContactMessage to the database.
 {@link ContactFormBean#init() } should be called from the server before
 * using any service of this class.
 * @author Eve Mendoza Quiros
 * @version 2.0
 */
@Named(value = "contactFormBean")
@ViewScoped
public class ContactFormBean implements Serializable {
    
    @Inject
    private ContactMessageFacade contactMessageFacade;
    
    private ContactMessage newContactMessage;
    
    private final String emailaddon = "@students.unibern.ch";
    
    public ContactFormBean() {
    }
    
    @PostConstruct
    private void init(){
        newContactMessage = new ContactMessage();
        if(SecurityUtils.getSubject().isAuthenticated()){
        Customer loggedInCustomer = (Customer) SecurityUtils.getSubject().getPrincipal();
        newContactMessage.setSender(loggedInCustomer.getUsername()+ emailaddon);  
        }
    }
    
    /**
     * Persists the new ContactMessage to the database.
     * @return the "contacFormSuccess.xhtml" page to indicate that the message was sent.
     */
    public String createNewContactMessage(){
        contactMessageFacade.create(newContactMessage);
        newContactMessage.setDate(DateConverter.currentTimeAsString());
        return Navigation.CONTACTFORMSUCCESS;
    }
    
    
    private void setGivenParameters(String reciever){
        newContactMessage.setDate(DateConverter.currentTimeAsString());
    }
          
    //getters and setters
    public ContactMessage getNewContactMessage() {
        return newContactMessage;
    }

    public void setNewContactMessage(ContactMessage newContactMessage) {
        this.newContactMessage = newContactMessage;
    }
}
