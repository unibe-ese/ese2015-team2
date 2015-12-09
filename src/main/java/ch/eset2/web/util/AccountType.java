package ch.eset2.web.util;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Holds Account Types. Could have been done as Enum. I know. 
 * 
 * @author Marc Jost
 * @version 1.0
 */
@Named
@ApplicationScoped
public class AccountType {
    public static final int STUDENT = 1;
    public static final int TUTOR = 2;
    
    // Getters for EL in sites, since accessing public fields is not possible
    public int getTUTOR() {
        return TUTOR;
    }
    
    public int getSTUDENT() {
        return STUDENT;
    }
}