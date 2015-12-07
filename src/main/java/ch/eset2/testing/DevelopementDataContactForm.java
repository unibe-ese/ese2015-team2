package ch.eset2.testing;

import ch.eset2.model.ContactMessage;
import ch.eset2.model.dao.ContactMessageFacade;
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
    private ContactMessageFacade contactFormFacade;

    public DevelopementDataContactForm() {

    }

    @PostConstruct
    public void initializeTestData() {
        createTestContactForm();
    }

    private void createTestContactForm() {
        try {
           
            ContactMessage firstContactForm = new ContactMessage();
            firstContactForm.setSubject("TestKontaktForm");
            firstContactForm.setSender("eve.mendoza");
            firstContactForm.setDate("20.11.2015 13:00:12");
            firstContactForm.setMessageText("Hier steht die Meldung von Eve Mendoza.");
            contactFormFacade.create(firstContactForm);

        } catch (Exception e) {
        }
    }

}
