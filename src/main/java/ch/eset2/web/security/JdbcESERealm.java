package ch.eset2.web.security;

import ch.eset2.model.Customer;
import ch.eset2.model.dao.CustomerFacade;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.omnifaces.config.BeanManager;

/**
 * Provides the authentication mechanism for Shiro. 
 * 
 * @author Marc Jost
 * @version 1.0
 */
public class JdbcESERealm extends JdbcRealm {
    
    private CustomerFacade customerFacade;
    
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        
        customerFacade = BeanManager.INSTANCE.getReference(CustomerFacade.class); // Since Shiro is not CDI aware, the customerFacade has to be looked up by JNDI
        Customer customer = customerFacade.findCustomerByUsername(username).get(0);
        if(customer == null) throw new AuthenticationException("Benutzer nicht gefunden");
        
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(customer, customer.getPassword(), getName());
        return info;
    }  
}
