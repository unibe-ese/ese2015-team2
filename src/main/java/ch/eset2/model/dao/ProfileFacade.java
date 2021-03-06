package ch.eset2.model.dao;

import ch.eset2.model.Profile;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Responsible for handling the Entity Manager interactions in regards of the
 * {@link Profile} Entity.
 * 
 * @author Marc Jost
 * @version 1.0
 */
@Stateless
public class ProfileFacade extends AbstractFacade<Profile> {

    private static final long serialVersionUID = 2731491651718662166L;

    @PersistenceContext(unitName = "eset2_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfileFacade() {
        super(Profile.class);
    }
}