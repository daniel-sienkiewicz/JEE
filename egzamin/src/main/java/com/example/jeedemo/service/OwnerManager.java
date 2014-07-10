package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Owner;

@Stateless
public class OwnerManager {
	@PersistenceContext
	EntityManager em;

	public void addOwner(Owner owner) {
		owner.setId(null);
		em.persist(owner);
	}

	public int deleteOwner(Owner owner) {
		owner = em.find(Owner.class, owner.getId());

		if (owner.getUsuniecie() == 0) {
			em.remove(owner);
			return 1;
		}
		else
			return 0;
	}

	@SuppressWarnings("unchecked")
	public List<Owner> getAllOwners() {
		return em.createNamedQuery("owner.all").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Owner> getSOwners(String name) {
		return em.createNamedQuery("owner.some").setParameter("name", name).getResultList();
	}

	public void updateOwner(Owner owner) {
		em.merge(owner);
	}
}