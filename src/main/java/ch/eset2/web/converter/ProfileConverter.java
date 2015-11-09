/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.converter;

import ch.eset2.model.Profile;
import ch.eset2.model.dao.ProfileFacade;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author foxhound
 */
@Named
@ApplicationScoped
public class ProfileConverter implements Converter {
    
    @Inject
    private ProfileFacade profileFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            Class<?> type = component.getValueExpression("value").getType(context.getELContext());
            return profileFacade.find(Long.valueOf(value));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid ID of Profile", value)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }

        if (value instanceof Profile) {
            Number id = ((Profile) value).getId();
            return (id != null) ? id.toString() : null;
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Profile", value)));
        }
    }
    
}
