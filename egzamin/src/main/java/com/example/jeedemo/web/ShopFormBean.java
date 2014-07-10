package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Shop;
import com.example.jeedemo.service.ShopManager;

@SessionScoped
@Named("shopF")
public class ShopFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Shop shop = new Shop();
	private ListDataModel<Shop> shops = new ListDataModel<Shop>();
	private ListDataModel<Shop> sShops = new ListDataModel<Shop>();
	private Collection<Long> watches = new ArrayList<Long>();
	private Long ownerId;
	private String town;
	private Shop shopToUpdate = new Shop();

	@Inject
	private ShopManager sm;

	public Shop getShopToUpdate() {
		return shopToUpdate;
	}

	public void setShopToUpdate(Shop shopToUpdate) {
		this.shopToUpdate = shopToUpdate;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Collection<Long> getWatches() {
		return watches;
	}

	public void setWatches(Collection<Long> watches) {
		this.watches = watches;
	}

	public Shop getShop() {
		return shop;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public ListDataModel<Shop> getAllShop() {
		shops.setWrappedData(sm.getAllShops());
		return shops;
	}

	public ListDataModel<Shop> getSShop() {
		sShops.setWrappedData(sm.getSShops(town));
		return sShops;
	}

	// Actions
	public String addShop() {
		sm.addShop(shop, ownerId);
		return "shopList";
	}

	public String deleteShop() {
		int wynik;
		Shop shopToDelete = shops.getRowData();
		wynik = sm.deleteShop(shopToDelete);
		if (wynik == 1)
			return null;
		else
			return "delError";
	}

	public String getSomeShop() {
		sShops.setWrappedData(sm.getSShops(town));
		return null;
	}

	public String updateShop(String name) {
		shopToUpdate = sm.getSShopsName(name).get(0);
		ownerId = shopToUpdate.getOwner().getId();
		return "updateShop";
	}

	public String updateSShop() {
		sm.updateShop(shopToUpdate, ownerId);
		return "shopList";
	}

	// Validators
	public void shopName(FacesContext context, UIComponent component, Object value) {

		String shopName = (String) value;

		for (Shop shop : sm.getAllShops()) {
			if (shop.getName().equalsIgnoreCase(shopName)) {
				FacesMessage message = new FacesMessage("Shop exists in database");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
}