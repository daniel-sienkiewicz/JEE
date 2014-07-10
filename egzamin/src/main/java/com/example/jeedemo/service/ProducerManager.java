package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Producer;

@Stateless
public class ProducerManager {
	@PersistenceContext
	EntityManager em;

	public void addProducer(Producer producer) {
		producer.setId(null);
		em.persist(producer);
	}

	public int deleteProducer(Producer producer) {
		producer = em.find(Producer.class, producer.getId());

		if (producer.getUsuniecie() == 0) {
			em.remove(producer);
			return 1;
		}
		else
			return 0;
	}

	@SuppressWarnings("unchecked")
	public List<Producer> getAllProducers() {
		return em.createNamedQuery("producer.all").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Producer> getSProducers(String town) {
		return em.createNamedQuery("producer.some").setParameter("town", town).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Producer> getSProducersName(String name) {
		return em.createNamedQuery("producer.name").setParameter("name", name).getResultList();
	}

	public void updateProducer(Producer producer) {
		em.merge(producer);
	}
}