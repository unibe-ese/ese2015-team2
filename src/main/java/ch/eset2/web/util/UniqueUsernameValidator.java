package ch.eset2.web.util;

import ch.eset2.model.Customer;
import ch.eset2.model.dao.CustomerFacade;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

/**
 * Responsible to display unique constraint violation on page level during
 * the registration process.
 * Will throw a ValidatorException if the username is already present in the database.
 * 
 * @author Marc Jost
 * @version 1.0
 */
@FacesValidator("uniqueUsernameValidator")
public class UniqueUsernameValidator implements Validator {

    @Inject
    private CustomerFacade customerFacade;
    
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        List<Customer> foundCustomers = customerFacade.findCustomerByUsername((String) value);
        if(!foundCustomers.isEmpty()) throw new ValidatorException(new FacesMessage("Diese Email ist bereits in Verwendung. Bitte wählen Sie eine andere."));
    }
}