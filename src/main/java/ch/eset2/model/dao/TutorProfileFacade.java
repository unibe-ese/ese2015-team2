package ch.eset2.model.dao;

import ch.eset2.model.TutorProfile;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Marc Jost
 * @version 1.0
 */
@Stateless
public class TutorProfileFacade extends AbstractFacade<TutorProfile> {

    @PersistenceContext(unitName = "eset2_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TutorProfileFacade() {
        super(TutorProfile.class);
    }
    
}
