package ch.eset2.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Represents a client of our application and holds all its account information.
 * All clients are represented as instances of this class. 
 * Special fields:
 * id: Every customer has an unique id.
 * username: Every customer has an unique username that is used to log in.
 * accountType: Customers can either be a Student or a Tutor.
 * @author Marc Jost, 17.10.2015
 * @version 1.0
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Customer.findByUsername", query = "SELECT f FROM Customer f WHERE f.username = :username")
})
public class Customer implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected String firstName;
    protected String lastName;
    
    @NotNull
    @Column(unique = true)
    protected String username;
    
    @NotNull
    protected String password;
    @Pattern(regexp = "\\d{2}-\\d{3}-\\d{3}", message = "Ungültige Matrikelnummer. Format: xx-xxx-xxx")
    protected String matnr;
    protected String street;
    protected String zip;
    protected String city;
    protected String phone;
    protected int accountType; // TODO: Move this to Profile?

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    protected Profile profile;
    
//    @ManyToMany (fetch = FetchType.EAGER)
//    @JoinTable(name = "friends", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "friendId"))
//    private List<Customer> friends;
    
    @ManyToMany
    @JoinTable (name = "friends",
            joinColumns = 
                @JoinColumn(name = "customerId", referencedColumnName = "id"),
            inverseJoinColumns = 
                @JoinColumn (name = "friendId", referencedColumnName = "id"))
    private List<Customer> friends;
    
    @ManyToMany(mappedBy = "friends")
    private List<Customer> friendOf;
    
//    @ManyToMany (fetch = FetchType.EAGER)
//    @JoinTable(name = "friends", joinColumns = @JoinColumn(name = "friendId"), inverseJoinColumns = @JoinColumn(name = "id"))
//    private List<Customer> friendOf;
    
    @OneToMany
    private List<Message> messages;
    
    public void addFriend(Customer friend){
        friends.add(friend);
    }
    
    public void removeFriend(Customer friend){
        friends.remove(friend);
    }
    
    public List<Customer> getFriends() {
        return friends;
    }

    public void setFriends(List<Customer> friends) {
        this.friends = friends;
    }

    public List<Customer> getFriendOf() {
        return friendOf;
    }

    public void setFriendOf(List<Customer> friendOf) {
        this.friendOf = friendOf;
    }
    
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    public void addMessage(Message message){
        messages.add(message);
    }
    
    public void removeMessage(Message message){
        messages.remove(message);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compares an object to this customer, customers are identical when they
     * have the same {@link Customer#id}.
     * @param object to be compared with this customer.
     * @return true when the given object is a customer with the same id.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.eset2.model.Customer[ id=" + id + " ]";
    }

}
