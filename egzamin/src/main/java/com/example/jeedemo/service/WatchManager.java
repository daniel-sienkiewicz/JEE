package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Producer;
import com.example.jeedemo.domain.Shop;
import com.example.jeedemo.domain.Watch;

@Stateless
public class WatchManager {

	@PersistenceContext
	EntityManager em;

	public void addWatch(Watch watch, long producerId, Long[] shopId) {
		List<Shop> shops = new ArrayList<Shop>();

		for (Long e : shopId) {
			Shop szop = new Shop();
			szop = em.find(Shop.class, e);
			szop.setUsuniecie(szop.getUsuniecie() + 1);
			shops.add(szop);
		}
		
		watch.setShop(shops);
		watch.setId(null);
		Producer make = em.find(Producer.class, producerId);
		make.setUsuniecie(make.getUsuniecie() + 1);
		watch.setProducer(make);
		em.persist(watch);
	}

	public void deleteWatch(Watch watch) {
		watch = em.find(Watch.class, watch.getId());
		Producer make = watch.getProducer();
		make.setUsuniecie(make.getUsuniecie() - 1);
		for(Shop e : watch.getShop()){
			e.setUsuniecie(e.getUsuniecie() - 1);
		}
		
		em.remove(watch);
	}
	
	public List<Shop> getShops(Watch watch) {
		watch = em.find(Watch.class, watch.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Shop> szops = new ArrayList<Shop>(watch.getShop());
		return szops;
	}

	@SuppressWarnings("unchecked")
	public List<Watch> getAllWatches() {
		return em.createNamedQuery("watch.all").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Watch> getSWatches(double price, int strapLength) {
		return em.createNamedQuery("watch.some").setParameter("price", price).setParameter("strapLength", strapLength).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Watch> getSWatchsName(String serialNumber) {
		return em.createNamedQuery("watch.up").setParameter("serialNumber", serialNumber).getResultList();
	}
	
	public void updateWatch(Watch watch, long producerId, Long[] shopId){
		List<Shop> shops = new ArrayList<Shop>();

		for (Long e : shopId) {
			Shop szop = new Shop();
			szop = em.find(Shop.class, e);
			shops.add(szop);
		}
		
		watch.setShop(shops);

		Producer make = em.find(Producer.class, producerId);
		watch.setProducer(make);
		em.merge(watch);
	}
}