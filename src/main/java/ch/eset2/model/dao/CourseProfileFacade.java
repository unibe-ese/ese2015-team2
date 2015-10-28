/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.model.dao;

import ch.eset2.model.CourseProfile;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author foxhound
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
    
}
