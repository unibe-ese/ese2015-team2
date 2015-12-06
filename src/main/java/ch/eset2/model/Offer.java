package ch.eset2.model;

import ch.eset2.web.util.MessageState;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Pattern;

/**
 * Represents a message sent from a {@link Customer} to an other. Special
 * fields: reciever: The {@link Customer} that can see this message in his
 * inbox. id: Every message has an unique id.
 *
 * @author Mischa Wenger, 17.10.2015
 * @version 1.0
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Offer.findByReceiver", query = "SELECT f FROM Offer f WHERE f.receiver = :receiver AND f.messageType = 2")
})
public class Offer extends Message {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   
    private double fee;

    private double commission;
    
    @Pattern(regexp = "\\d{2}.\\d{2}.\\d{4}", message = "Ungültiges Format. Format: dd.mm.yyyy")
    private String firstAppointmentDay;

    @Pattern(regexp = "\\d{2}:\\d{2}", message = "Ungültiges Format. Format: xx:xx")
    private String firstAppointmentTime;

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }
    
    

    public String getFirstAppointmentDay() {
        return firstAppointmentDay;
    }

    public void setFirstAppointmentDay(String firstAppointmentDay) {
        this.firstAppointmentDay = firstAppointmentDay;
    }

    public String getFirstAppointmentTime() {
        return firstAppointmentTime;
    }

    public void setFirstAppointmentTime(String firstAppointmentTime) {
        this.firstAppointmentTime = firstAppointmentTime;
    }

     public boolean isAccepted(){
        return (super.getMessageState() == MessageState.ACCEPTED);
    }
    
    public String toHtmlFormatedString() {
       return ( "<br/" +
                "Subject: " + super.getSubject() + "<br/>" + 
                "Stundenlohn: " + fee + " CHF zuzüglich einmaliger Gebühr von " + commission + " CHF<br/>" + 
                "Erster Termin: " + firstAppointmentDay + " um " + firstAppointmentTime + " Uhr <br/> " +
                "Nachricht: " + super.getMessageText());
    }

    @Override
    public String toString() {
        return "ch.eset2.model.Offer[ id=" + id + " ]";
    }

}
