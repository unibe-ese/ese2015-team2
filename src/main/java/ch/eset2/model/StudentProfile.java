package ch.eset2.model;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 * Extends the abstract class {@link Profile}.
 * In the current implementation there are no additional fields for StudentProfiles.
 * @author Marc Jost, 17.10.2015
 * @version 1.0
 */
@Entity
public class StudentProfile extends Profile implements Serializable {

    private static final long serialVersionUID = 8766845856123067712L;
    
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
        if (!(object instanceof StudentProfile)) {
            return false;
        }
        StudentProfile other = (StudentProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.eset2.model.StudentProfile[ id=" + id + " ]";
    }
    
}
