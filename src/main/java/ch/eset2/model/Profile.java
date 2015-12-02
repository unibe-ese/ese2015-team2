/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Represents a profile of a {@link Customer} to hold extended customer information.
 * The customers are represented by this class. Other customers may access the
 * {@link Profile}.
 * Special fields:
 * id: Every Profile has an unique id.
 * {@link #customer}: Every profile belongs to exactly one customer.
 * {@link #courseProfiles}: Relationship to courses the profileowner attends.
 * @author Marc Jost, 17.10.2015
 */
@Entity
public abstract class Profile implements Serializable {

    protected static final long serialVersionUID = 1L;
    
    protected String imageLink;

    protected String description = "Noch keine Profilbeschreibung";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    
    @OneToOne(mappedBy = "profile")
    protected Customer customer;
    
    @OneToMany(mappedBy ="profile", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected List<CourseProfile> courseProfiles;

    public void addCourseProfile(CourseProfile cp){
        courseProfiles.add(cp);
    }
    
    public void removeCourseProfile(CourseProfile cp){
        courseProfiles.remove(cp);
    }
    
    public List<CourseProfile> getCourseProfiles() {
        return courseProfiles;
    }

    public boolean hasCourseProfiles(){
        return !courseProfiles.isEmpty();
    }
    
    public void setCourseProfiles(List<CourseProfile> courseProfiles) {
        this.courseProfiles = courseProfiles;
    }
    
    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
    
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void testInit(){
        courseProfiles = new ArrayList<CourseProfile>(); 
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    
    /**
     * Checks identity only for same unique {@link Profile#id}.
     * @param object the object to be compare with.
     * @return true when instance of this class and id's are identical.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.eset2.model.Profile[ id=" + id + " ]";
    }
    
}
