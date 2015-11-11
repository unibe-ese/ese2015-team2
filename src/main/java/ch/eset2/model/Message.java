package ch.eset2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a message sent from a {@link Customer} to an other.
 * Special fields:
 * reciever: The {@link Customer} that can see this message in his inbox.
 * id: Every message has an unique id.
 * @author Mischa Wenger, 17.10.2015
 * @version 1.0
 */
@Entity
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String subject;
    
    @Column(length = 2000)
    private String messageText;
   
    private String sender;
    
    private String reciever;
    
    
    /**
     * Creates a short preview of 30 chars of the messageText.
     * @return the first 30 chars of the messageText. Whole messagetext if text
     * is shorter than 30 chars.
     */
    public String messageTextPreview(){
        if (messageText.length() <= 30){
            return messageText;
        }
        else {
            return messageText.substring(0, 30).concat("...");
        }
    }
    
    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
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
