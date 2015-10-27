/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.util;

import ch.eset2.model.Profile;
import ch.eset2.model.StudentProfile;
import ch.eset2.model.TutorProfile;

/**
 *
 * @author foxhound
 */
public class ProfileFactory {
    
    public static Profile getProfile(int accountType){
        switch(accountType){
            case AccountType.STUDENT:
                return new StudentProfile();
            case AccountType.TUTOR:
                return new TutorProfile();
            default:
                return null;
        }
    }
}
