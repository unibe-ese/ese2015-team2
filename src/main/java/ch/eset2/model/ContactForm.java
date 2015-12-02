package ch.eset2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/*
 * Represents a contactForm filled out by a user, either signed in or not.
 * Special fields:
 * id: Every ContactForm has an unique id.
 * @author Eve Mendoza Quiros, 1.12.2015
 * @version 1.0
 */
@Entity
public class ContactForm implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String subject;
    
    @Column(length = 2000)
    private String messageText;
   
    private String sender;
    
    private String date;
    
    //private final String emailaddon = "@students.unibern.ch";
      
    /**
     * Creates a short preview of 30 chars of the messageText.
     * @return the first 30 chars of the messageText. Whole messagetext if text
     * is shorter than 30 chars.
     */
    public String messageTextPreview(){
        if (messageText.length() <= 50){
            return messageText;
        }
        else {
            return messageText.substring(0, 50).concat("...");
        }
    }
    
     public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
    
    public void setId(Long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    
    /**
     * Checks identity only for same unique {@link ContactForm#id}.
     * @param object the object to be compare with.
     * @return true when instance of this class and id's are identical.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactForm)) {
            return false;
        }
        ContactForm other = (ContactForm) object;
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
