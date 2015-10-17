package ch.eset2.web.beans;

import ch.eset2.web.util.Navigation;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * {Insert description here}
 * @author Marc Jost, 17.10.2015
 */
@RequestScoped
@Named
public class LogInOutBean implements Serializable {
    
    private String username;
    private String password;
    
    public String login(){
        System.out.println("FUCKING LOGIN");
        System.out.println(username);
        System.out.println(password);
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
