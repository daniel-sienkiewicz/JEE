package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Watch;
import com.example.jsfdemo.service.WatchManager;

@SessionScoped
@Named("watchF")
public class WatchFrom implements Serializable {
	private Watch watch = new Watch();
	private ArrayList<Watch> searchWatch = new ArrayList<Watch>();

	@Inject
	private WatchManager watchMenager;

	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	// Akcja - dodawanie zegarka
	public String addWatchA() {
		watchMenager.addWatch(watch);
		return "watchList";
	}
	
	// Akcja - usuniecie zegarka
	public String dellWatchA() {
		watchMenager.delWatch(watch);
		return "watchList";
	}
	
	// Akcja - szukanie zegarka
	public String searchWatchA() {
		searchWatch = watchMenager.searchWatch(watch);
		return "searchWatchResult";
	}

	public List<Watch> getAllWatch() {
		return watchMenager.writeAllWatchs();
	}
	
	public List<Watch> getsearchWatch() {
		return searchWatch;
	}

	// Validators

	// sprawdzanie czy sn jest juz w bazie
	public void serialNumber(FacesContext context, UIComponent component, Object value) {

		String serialNumber = (String) value;

		for (Watch watch : watchMenager.writeAllWatchs()) {
			if (watch.getSerialNumber().equalsIgnoreCase(serialNumber)) {
				FacesMessage message = new FacesMessage("Watch with this serial number exists in database");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
}