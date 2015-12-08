package ch.eset2.testing;

import ch.eset2.model.ContactForm;
import ch.eset2.model.dao.ContactFormFacade;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Simple Class to create some initial Data in the database
 *
 * @author Eve Mendoza Quiros
 * @version 1.0
 */
@Singleton
@Startup
public class DevelopementDataContactForm {

    @Inject
    private ContactFormFacade contactFormFacade;

    public DevelopementDataContactForm() {

    }

    @PostConstruct
    public void initializeTestData() {
        createTestContactForm();
    }

    private void createTestContactForm() {
        try {
           
            ContactForm firstContactForm = new ContactForm();
            firstContactForm.setSubject("TestKontaktForm");
            firstContactForm.setSender("eve.mendoza");
            firstContactForm.setDate("20.11.2015 13:00:12");
            firstContactForm.setMessageText("Hier steht die Meldung von Eve Mendoza.");
            contactFormFacade.create(firstContactForm);

        } catch (Exception e) {
        }
    }

}
