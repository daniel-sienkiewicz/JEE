package com.example.shdemo.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Kawa;

@Component
@Transactional
public class KawaMangerHibernateImpl implements KawaManager {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int addNewKawa(Kawa kawa) {
		//kawa.setId(null);
		return (Integer) sessionFactory.getCurrentSession().save(kawa);
	}

	@Override
	public Kawa findKawaById(int id) {
		return (Kawa) sessionFactory.getCurrentSession().get(Kawa.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Kawa> getAllKawa() {
		return sessionFactory.getCurrentSession().getNamedQuery("kawa.all")
				.list();
	}

	@Override
	public void deleteKawa(Kawa kawa) {		
		sessionFactory.getCurrentSession().delete(kawa);
	}

	@Override
	public void updateKawa(Kawa kawa) {
		sessionFactory.getCurrentSession().update(kawa);		
	}
}