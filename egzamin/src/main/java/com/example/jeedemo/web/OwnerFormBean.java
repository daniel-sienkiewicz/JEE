package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Owner;
import com.example.jeedemo.service.OwnerManager;

@SessionScoped
@Named("ownerF")
public class OwnerFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Owner owner = new Owner();
	private ListDataModel<Owner> owners = new ListDataModel<Owner>();
	private ListDataModel<Owner> sOwners = new ListDataModel<Owner>();
	Owner ownerToUpdate = new Owner();
	
	private String name;

	@Inject
	private OwnerManager om;
	
	public Owner getOwnerToUpdate() {
		return ownerToUpdate;
	}

	public void setOwnerToUpdate(Owner ownerToUpdate) {
		this.ownerToUpdate = ownerToUpdate;
	}

	public Owner getOwner() {
		return owner;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public ListDataModel<Owner> getAllOwner() {
		owners.setWrappedData(om.getAllOwners());
		return owners;
	}
	
	public ListDataModel<Owner> getSOwner() {
		sOwners.setWrappedData(om.getSOwners(name));
		return sOwners;
	}

	// Actions
	public String addOwner() {
		om.addOwner(owner);
		return "ownerList";
	}

	public String deleteOwner() {
		int wynik;
		Owner ownerToDelete = owners.getRowData();
		wynik = om.deleteOwner(ownerToDelete);
		
		if(wynik == 1)
			return null;
		else
			return "delError";
	}
	
	public String getSomeOwner() {
		sOwners.setWrappedData(om.getSOwners(name));
		return null;
	}
	
	public String updateOwner(String name){
		ownerToUpdate = om.getSOwners(name).get(0);
		return "updateOwner";
	}
	
	public String updateSOwner(){
		om.updateOwner(ownerToUpdate);
		return "ownerList";
	}

	// Validators
	public void ownerName(FacesContext context, UIComponent component, Object value) {

		String ownerName = (String) value;

		for (Owner owner : om.getAllOwners()) {
			if (owner.getName().equalsIgnoreCase(ownerName)) {
				FacesMessage message = new FacesMessage("Owner exists in database");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
}