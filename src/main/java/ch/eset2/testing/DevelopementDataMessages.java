package ch.eset2.testing;

import ch.eset2.model.Customer;
import ch.eset2.model.Message;
import ch.eset2.model.Offer;
import ch.eset2.model.dao.CustomerFacade;
import ch.eset2.model.dao.MessageFacade;
import ch.eset2.model.dao.OfferFacade;
import ch.eset2.web.util.MessageState;
import ch.eset2.web.util.MessageType;
import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Simple Class to create some initial Data in the database
 *
 * @author Marc Jost
 * @version 1.0
 */
@Singleton
@Startup
@DependsOn("DevelopmentDataUsers")
public class DevelopementDataMessages {

    @Inject
    private MessageFacade messageFacade;

    @Inject
    private CustomerFacade customerFacade;

    @Inject
    private OfferFacade offerFacade;

    public DevelopementDataMessages() {

    }

    @PostConstruct
    public void initializeTestData() {
        createTestMessages();
    }

    private void createTestMessages() {
        try {

            Customer marc = customerFacade.findCustomerByUsername("marc.jost").get(0);
            Customer mischa = customerFacade.findCustomerByUsername("mischa.wenger").get(0);
            Customer eve = customerFacade.findCustomerByUsername("eve.mendoza").get(0);

            Message firstMessage = new Message();
            firstMessage.setSubject("Testbetreff1");
            firstMessage.setReceiver(marc);
            firstMessage.setSender(mischa);
            firstMessage.setSendDate("20.11.2015 13:00:12");
            firstMessage.setMessageState(MessageState.NEW);
            firstMessage.setMessageText("Hier steht die Testnachricht von Mischa an Marc.");
            firstMessage.setMessageType(MessageType.MESSAGE);
            messageFacade.create(firstMessage);

            Message secondMessage = new Message();
            secondMessage.setSubject("TestBetreff2");
            secondMessage.setReceiver(mischa);
            secondMessage.setSender(marc);
            secondMessage.setSendDate("20.11.2015 13:12:22");
            secondMessage.setMessageState(MessageState.NEW);
            secondMessage.setMessageText("Hier steht die Testnachricht2 von Marc an Mischa.");
            secondMessage.setMessageType(MessageType.MESSAGE);
            messageFacade.create(secondMessage);

            Message thirdMessage = new Message();
            thirdMessage.setSubject("Testbetreff3");
            thirdMessage.setReceiver(eve);
            thirdMessage.setSender(eve);
            thirdMessage.setSendDate("20.11.2015 13:44:00");
            thirdMessage.setMessageState(MessageState.NEW);
            thirdMessage.setMessageText("Hier steht die Testnachricht3 von Eve an Eve.");
            thirdMessage.setMessageType(MessageType.MESSAGE);
            messageFacade.create(thirdMessage);

            Message fourthMessage = new Message();
            fourthMessage.setSubject("Testbetreff4");
            fourthMessage.setReceiver(mischa);
            fourthMessage.setSender(eve);
            fourthMessage.setSendDate("20.11.2015 12:10:19");
            fourthMessage.setMessageState(MessageState.NEW);
            fourthMessage.setMessageType(MessageType.MESSAGE);
            fourthMessage.setMessageText("Hier steht die Testnachricht4 von Eve an Mischa .");
            messageFacade.create(fourthMessage);

            Message fifthMessage = new Message();
            fifthMessage.setSubject("Testbetreff5");
            fifthMessage.setReceiver(eve);
            fifthMessage.setSender(mischa);
            fifthMessage.setSendDate("20.11.2015 12:59:47");
            fifthMessage.setMessageState(MessageState.NEW);
            fifthMessage.setMessageType(MessageType.MESSAGE);
            fifthMessage.setMessageText("Hier steht die Testnachricht5 vom Mischa an Eve.");
            messageFacade.create(fifthMessage);

            Offer firstOffer = new Offer();
            firstOffer.setSubject("TestOffer 1");
            firstOffer.setReceiver(eve);
            firstOffer.setSender(mischa);
            firstOffer.setSendDate("20.11.2015 12:50:47");
            firstOffer.setMessageState(MessageState.NEW);
            firstOffer.setMessageType(MessageType.OFFER);
            firstOffer.setMessageText("Hier ist der erste Offer.");
            firstOffer.setFee("20.00");
            firstOffer.setFirstAppointmentDay("30.11.2015");
            firstOffer.setFirstAppointmentTime("18:00");
            offerFacade.create(firstOffer);

        } catch (Exception e) {
            // TBD
        }
    }

}
