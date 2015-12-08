package ch.eset2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * Represents a message sent from a {@link Customer} to an other.
 * Special fields:
 * receiver: The {@link Customer} that can see this message in his inbox.
 * id: Every message has an unique id.
 * 
 * @author Mischa Wenger
 * @version 1.0
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Message.findByReceiver", query = "SELECT f FROM Message f WHERE f.receiver = :receiver AND f.messageType = 1")
})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String subject;
    
    private int messageType;
    
    @Column(length = 2000)
    private String messageText;
   
    @OneToOne
    private Customer sender;
    
    @OneToOne
    private Customer receiver;
    
    private String sendDate;
    
    private int messageState;
      
    /**
     * Creates a short preview of 50 chars of the messageText.
     * @return the first 50 chars of the messageText. Whole messagetext if text
     * is shorter than 50 chars.
     */
    public String messageTextPreview(){
        if (messageText.length() <= 50){
            return messageText;
        }
        else {
            return messageText.substring(0, 50).concat("...");
        }
    }
    
    public int getMessageState() {
        return messageState;
    }

    public void setMessageState(int messageState) {
        this.messageState = messageState;
    }
    
    public boolean isNew() {
        return this.messageState == 1;
    }
    
     public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }
    
    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }
    
    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    
    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    
    /**
     * Checks identity only for same unique {@link Message#id}.
     * @param object the object to be compare with.
     * @return true when instance of this class and id's are identical.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.eset2.model.Message[ id=" + id + " ]";
    }
    
}
