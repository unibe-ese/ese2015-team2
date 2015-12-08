package ch.eset2.web.util;

import ch.eset2.model.Customer;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * Little Helper class to provide a point for EL in sites can access certain 
 * customer details.
 * 
 * @author Marc Jost
 * @version 1.0
 */
@SessionScoped
@Named
public class UserHelper implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Returns the ID of the currently logged in customer.
     * 
     * @return the ID of the currently logged in customer. 
     */
    public long getMyProfileID(){
        return ((Customer) SecurityUtils.getSubject().getPrincipal()).getProfile().getId();
    }
}
