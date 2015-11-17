package ch.eset2.model.dao;

import ch.eset2.model.CourseProfile;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Marc Jost
 * @version 1.0
 */
@Stateless
public class CourseProfileFacade extends AbstractFacade<CourseProfile> {

    @PersistenceContext(unitName = "eset2_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CourseProfileFacade() {
        super(CourseProfile.class);
    }
    
    public List<CourseProfile> findAllTutors(){
        return em.createNamedQuery("CourseProfile.findAllTutors").getResultList();
    }
}
