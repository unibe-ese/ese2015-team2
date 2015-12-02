package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.ContactForm;
import ch.eset2.model.dao.ContactFormFacade;
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
 * It allows to persist a new ContactForm to the database.
 * {@link ContactFormBean#init() } should be called from the server before
 * using any service of this class.
 * @author Eve Mendoza Quiros
 */
@Named(value = "contactFormBean")
@ViewScoped
public class ContactFormBean implements Serializable {
    
    @Inject
    private ContactFormFacade ContactFormFacade;
    
    private ContactForm newContactForm;
    
    private final String emailaddon = "@students.unibern.ch";
    
    /*
     * Creates a new instance of ContactFormBean
     */
    public ContactFormBean() {
    }
    
    @PostConstruct
    private void init(){
        newContactForm = new ContactForm();
        //if (currentUser.isAuthenticated()){
        if(SecurityUtils.getSubject().isAuthenticated()){
        Customer loggedInCustomer = (Customer) SecurityUtils.getSubject().getPrincipal();
        newContactForm.setSender(loggedInCustomer.getUsername()+ emailaddon);  
        }
    }
    
    /**
     * Persists the new ContactForm to the database.
     * @return the "contacFormSuccess.xhtml" page to indicate that the message was sent.
     */
    public String createNewContactForm(){
        ContactFormFacade.create(newContactForm);
        newContactForm.setDate(DateConverter.currentTimeAsString());
        return Navigation.CONTACTFORMSUCCESS;
    }
    
    
    private void setGivenParameters(String reciever){
        newContactForm.setDate(DateConverter.currentTimeAsString());
    }
          
    //getters and setters
    public ContactForm getNewContactForm() {
        return newContactForm;
    }

    public void setNewContactForm(ContactForm newContactForm) {
        this.newContactForm = newContactForm;
    }
}
