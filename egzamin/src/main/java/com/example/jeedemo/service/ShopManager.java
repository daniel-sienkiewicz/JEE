package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Owner;
import com.example.jeedemo.domain.Shop;

@Stateless
public class ShopManager {
	@PersistenceContext
	EntityManager em;

	public void addShop(Shop shop, Long idOwner) {
		Owner owner = em.find(Owner.class, idOwner);
		shop.setOwner(owner);
		owner.setUsuniecie(owner.getUsuniecie() + 1);
		shop.setId(null);
		em.persist(shop);
	}

	public int deleteShop(Shop shop) {
		shop = em.find(Shop.class, shop.getId());
		if (shop.getUsuniecie() == 0) {
			Owner owner = shop.getOwner();
			owner.setUsuniecie(owner.getUsuniecie() - 1);
			em.remove(shop);
			return 1;
		}
		else 
			return 0;
	}

	@SuppressWarnings("unchecked")
	public List<Shop> getAllShops() {
		return em.createNamedQuery("shop.all").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Shop> getSShops(String town) {
		return em.createNamedQuery("shop.some").setParameter("town", town).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Shop> getSShopsName(String name) {
		return em.createNamedQuery("shop.name").setParameter("name", name).getResultList();
	}

	public void updateShop(Shop shop, Long ownerId) {
		Owner owner = em.find(Owner.class, ownerId);
		shop.setOwner(owner);
		em.merge(shop);
	}
}