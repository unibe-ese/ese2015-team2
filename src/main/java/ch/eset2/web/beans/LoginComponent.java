package ch.eset2.web.beans;

import ch.eset2.web.util.Navigation;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

/**
 * The loginComponent provides the login and logout process.
 * It holds and validates username and passwort from given userinput.
 * LoginComponent establishes a session with {@link LoginComponent#login()}.
 * The caller must ensure that session is destroyed with the
 * {@link LoginComponent#logout()} method.
 * @author Marc Jost, 17.10.2015
 */
@SessionScoped
@Named
public class LoginComponent implements Serializable {

    private String username;
    private String password;

    
    /**
     * Establishes userSession due to given userinput.
     * @throws IOException if given userinput does not match username
     * or password in the database.
     */
    public void login() throws IOException {
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));
            SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(Faces.getRequest());
            Faces.redirect(savedRequest != null ? savedRequest.getRequestUrl() : Navigation.INDEX);
        } catch (AuthenticationException ex) {
            Messages.addGlobalError("Unbekannter Benutzer, bitte versuchen Sie es nochmals.");
            Logger.getLogger(LoginComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Destroys userSession and navigates the user back to the indexpage.
     * @throws IOException 
     */
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
