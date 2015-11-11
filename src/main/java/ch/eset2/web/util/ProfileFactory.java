package ch.eset2.web.util;

import ch.eset2.model.Profile;
import ch.eset2.model.StudentProfile;
import ch.eset2.model.TutorProfile;

/**
 * Generates a Profile according to the provided account Type
 * 
 * @author Marc Jost
 * @version 1.0
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
