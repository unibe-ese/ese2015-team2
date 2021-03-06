package ch.eset2.model;

import ch.eset2.web.util.AccountType;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Models the relationship between a {@link Course} and {@link Profile}.
 * A CourseProfile holds only one {@link Course} and one {@link Profile}, but
 * courses and profile can hold many {@link CourseProfile} instances.
 * Modelled as a seperate Entity, since this "Join Table" has value of its own.
 * Special fields:
 * id: Every courseProfile has an unique id.
 * 
 * @author Marc Jost, 17.10.2015
 * @version 1.0
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "CourseProfile.findAllTutors", query = "SELECT f FROM CourseProfile f WHERE f.profile.customer.accountType = " + AccountType.TUTOR)
})
public class CourseProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn
    private Profile profile;
    
    @ManyToOne
    @JoinColumn
    private Course course;
    
    private double grade;
    
    private String passedInYear;
    
    private String fee;

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getPassedInYear() {
        return passedInYear;
    }

    public void setPassedInYear(String passedInYear) {
        this.passedInYear = passedInYear;
    }

    public Long getId() {
        return id;
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
     * Checks identity only for same unique {@link CourseProfile#id}.
     * @param object the object to be compare with.
     * @return true when instance of this class and id's are identical.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CourseProfile)) {
            return false;
        }
        CourseProfile other = (CourseProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.eset2.model.CourseProfile[ id=" + id + " ]";
    }
}