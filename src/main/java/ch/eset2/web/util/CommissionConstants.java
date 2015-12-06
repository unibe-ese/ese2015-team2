package ch.eset2.web.util;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * This class stores the commission that the provider wants to earn on each
 * engagement.
 * @author Mischa Wenger
 */

@Named
@ApplicationScoped
public class CommissionConstants {
    public static final double COMMISSION = 0.1;
    
    public double getCOMMISSIONInPercent() {
        return COMMISSION * 100;
}
}
