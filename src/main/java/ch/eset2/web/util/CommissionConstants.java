package ch.eset2.web.util;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * This class stores the commission that the provider wants to earn on each
 * engagement.
 * 
 * @author Mischa Wenger
 * @version 2.0
 */
@Named
@ApplicationScoped
public class CommissionConstants {
    public static final double COMMISSION = 0.1;
    
    // Getters for EL in sites, since accessing public fields is not possible
    public double getCOMMISSIONInPercent() {
        return COMMISSION * 100;
    }
}