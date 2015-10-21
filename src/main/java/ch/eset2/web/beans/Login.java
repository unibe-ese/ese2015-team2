package ch.eset2.web.beans;

import ch.eset2.web.util.Navigation;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * {Insert description here}
 * @author Marc Jost, 17.10.2015
 */
@RequestScoped
@Named
public class Login implements Serializable {
    
    private String username;
    private String password;
    
    public String login(){
        SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));
        return Navigation.REGSUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
