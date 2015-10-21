/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.beans;

import ch.eset2.web.util.Navigation;
import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;
import org.omnifaces.util.Faces;

/**
 *
 * @author foxhound
 */
@Named
@RequestScoped
public class Logout {
    
    public void logout() throws IOException {
        SecurityUtils.getSubject().logout();
        Faces.invalidateSession();
        Faces.redirect(Navigation.INDEX);
    }
}
