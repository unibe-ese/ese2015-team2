package ch.eset2.testing;

import ch.eset2.model.Customer;
import ch.eset2.model.Offer;
import ch.eset2.model.dao.CustomerFacade;
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
 * @author Mischa Wenger
 * @version 1.0
 */
@Singleton
@Startup
@DependsOn("DevelopmentDataUsers")
public class DevelopementDataOffers {

    @Inject
    private CustomerFacade customerFacade;

    @Inject
    private OfferFacade offerFacade;

    public DevelopementDataOffers() {

    }

    @PostConstruct
    public void initializeTestData() {
        createTestOffers();
    }

    private void createTestOffers() {
        try {

            Customer mischa = customerFacade.findCustomerByUsername("mischa.wenger").get(0);
            Customer eve = customerFacade.findCustomerByUsername("eve.mendoza").get(0);
            Customer ese = customerFacade.findCustomerByUsername("ese").get(0);
            Customer ese2 = customerFacade.findCustomerByUsername("ese2").get(0);
            
            Offer firstOffer = new Offer();
            firstOffer.setSubject("Computernetze");
            firstOffer.setReceiver(eve);
            firstOffer.setSender(mischa);
            firstOffer.setSendDate("20.11.2015 12:50:47");
            firstOffer.setMessageState(MessageState.NEW);
            firstOffer.setMessageType(MessageType.OFFER);
            firstOffer.setMessageText("Hier ist der erste Offer.");
            firstOffer.setFee(20.00);
            firstOffer.setCommission(2.00);
            firstOffer.setFirstAppointmentDay("30.11.2015");
            firstOffer.setFirstAppointmentTime("18:00");
            offerFacade.create(firstOffer);
            
            
            Offer secondOffer = new Offer();
            secondOffer.setSubject("Einführung in Informatik");
            secondOffer.setReceiver(ese2);
            secondOffer.setSender(ese);
            secondOffer.setSendDate("25.11.2015 12:55:47");
            secondOffer.setMessageState(MessageState.NEW);
            secondOffer.setMessageType(MessageType.OFFER);
            secondOffer.setMessageText("Gerne offeriere ich dir meine arkanen Künste.");
            secondOffer.setFee(20.00);
            secondOffer.setCommission(2.00);
            secondOffer.setFirstAppointmentDay("30.11.2015");
            secondOffer.setFirstAppointmentTime("18:00");
            offerFacade.create(secondOffer);

        } catch (Exception e) {
            // TBD
        }
    }

}
