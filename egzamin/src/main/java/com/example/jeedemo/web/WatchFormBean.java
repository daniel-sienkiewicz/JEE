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

import com.example.jeedemo.domain.Shop;
import com.example.jeedemo.domain.Watch;
import com.example.jeedemo.service.WatchManager;

@SessionScoped
@Named("watchF")
public class WatchFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Watch watch = new Watch();
	private ListDataModel<Watch> watches = new ListDataModel<Watch>();
	private ListDataModel<Watch> sWatch = new ListDataModel<Watch>();
	private ListDataModel<Shop> shops = new ListDataModel<Shop>();
	private Long makeId;
	private Long[] shopId;
	private Watch watchToShow = new Watch();
	private Watch watchToUpdate = new Watch();
	private double price;
	private int straplength = 1;

	@Inject
	private WatchManager wm;
	
	public int getStrapLength() {
		return straplength;
	}

	public void setStrapLength(int strapLength) {
		this.straplength = strapLength;
	}

	public Long[] getShopId() {
		return shopId;
	}

	public void setShopId(Long[] shopId) {
		this.shopId = shopId;
	}

	public Watch getWatchToUpdate() {
		return watchToUpdate;
	}

	public void setWatchToUpdate(Watch watchToUpdate) {
		this.watchToUpdate = watchToUpdate;
	}

	public Long getMakeId() {
		return makeId;
	}

	public void setMakeId(Long makeId) {
		this.makeId = makeId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public ListDataModel<Shop> getShops() {
		shops.setWrappedData(wm.getShops(watchToShow));
		return shops;
	}

	public ListDataModel<Watch> getAllWatch() {
		watches.setWrappedData(wm.getAllWatches());
		return watches;
	}

	public ListDataModel<Watch> getSWatch() {
		sWatch.setWrappedData(wm.getSWatches(price, straplength));
		return sWatch;
	}

	// Actions
	public String addWatch() {
		wm.addWatch(watch, makeId, shopId);
		return "watchList";
	}

	public String deleteWatch() {
		Watch watchToDelete = watches.getRowData();
		wm.deleteWatch(watchToDelete);
		return null;
	}

	public String showDetails() {
		watchToShow = watches.getRowData();
		return "details";
	}

	public String getSomeWatch() {
		sWatch.setWrappedData(wm.getSWatches(price, straplength));
		return null;
	}
	
	public String updateWatch(String serialNumber) {
		watchToUpdate = wm.getSWatchsName(serialNumber).get(0);
		makeId = watchToUpdate.getProducer().getId();
		
		int i = 0;
		for(Shop e : watchToUpdate.getShop()){
			shopId[i] = e.getId();
			i++;
		}
		
		return "updateWatch";
	}

	public String updateSWatch() {
		wm.updateWatch(watchToUpdate, makeId, shopId);
		return "watchList";
	}

	// Validators

	// sprawdzanie czy sn jest juz w bazie
	public void serialNumber(FacesContext context, UIComponent component, Object value) {

		String serialNumber = (String) value;

		for (Watch watch : wm.getAllWatches()) {
			if (watch.getSerialNumber().equalsIgnoreCase(serialNumber)) {
				FacesMessage message = new FacesMessage("Watch with this serial number exists in database");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
}