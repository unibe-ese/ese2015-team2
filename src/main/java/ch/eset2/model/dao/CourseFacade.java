package ch.eset2.model.dao;

import ch.eset2.model.Course;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Marc Jost
 * @version 1.0
 */
@Stateless
public class CourseFacade extends AbstractFacade<Course> implements Serializable {

    private static final long serialVersionUID = 7754837198994662864L;
    
    @PersistenceContext(unitName = "eset2_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CourseFacade() {
        super(Course.class);
    }
    
}
