package ch.eset2.web.converter;

import ch.eset2.model.Message;
import ch.eset2.model.dao.MessageFacade;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Converts IDs provided through URL Parameters to objects.
 * 
 * @author Mischa Wenger
 * @version 1.0
 */
@Named
@ApplicationScoped
public class MessageConverter implements Converter {
    
    @Inject
    private MessageFacade messageFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            Class<?> type = component.getValueExpression("value").getType(context.getELContext());
            return messageFacade.find(Long.valueOf(value));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid ID of Message", value)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Message) {
            Number id = ((Message) value).getId();
            return (id != null) ? id.toString() : null;
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Message", value)));
        }
    }
}