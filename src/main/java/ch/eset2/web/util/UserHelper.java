/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.util;

import ch.eset2.model.Customer;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 *
 * @author foxhound
 */
@SessionScoped
@Named
public class UserHelper implements Serializable {
    
    
    public long getMyProfileID(){
        return ((Customer) SecurityUtils.getSubject().getPrincipal()).getProfile().getId();
    }
}
