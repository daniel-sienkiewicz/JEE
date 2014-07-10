package com.example.jsfdemo.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

// moj walidator
@FacesValidator("serialNumberValidator")
public class SerialNumberValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		String sn = (String) value;

		// czy sn jest dluzszy nic 4 znaki
		if (sn.length() < 4) {
			FacesMessage message = new FacesMessage();
			message.setDetail("SN must consist of more than 4 characters");
			message.setSummary("SN must consist of more than 4 characters");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}

		// sprawdzanie SN do wzorca
		Pattern p = Pattern.compile(".+--+[a-z]+");
		Matcher m = p.matcher(sn);

		boolean matchFound = m.matches();

		if (!matchFound) {
			FacesMessage message = new FacesMessage();
			message.setDetail("Serial Number: sth--[a-z]");
			message.setSummary("Zly SN");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
}