package ch.eset2.web.beans;

import ch.eset2.web.util.Navigation;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.omnifaces.util.Faces;

/**
 * {Insert description here}
 *
 * @author Marc Jost, 17.10.2015
 */
@SessionScoped
@Named
public class LoginComponent implements Serializable {

    private String username;
    private String password;

    public void login() throws IOException {
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));
            SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(Faces.getRequest());
            Faces.redirect(savedRequest != null ? savedRequest.getRequestUrl() : Navigation.INDEX);
        } catch (AuthenticationException ex) {
            Logger.getLogger(LoginComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void logout() throws IOException {
        SecurityUtils.getSubject().logout();
        Faces.invalidateSession();
        Faces.redirect(Navigation.INDEX);
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
