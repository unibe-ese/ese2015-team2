package ch.eset2.model.dao;

import ch.eset2.model.StudentProfile;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Marc Jost
 * @version 1.0
 */
@Stateless
public class StudentProfileFacade extends AbstractFacade<StudentProfile> {

    @PersistenceContext(unitName = "eset2_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentProfileFacade() {
        super(StudentProfile.class);
    }
    
}
