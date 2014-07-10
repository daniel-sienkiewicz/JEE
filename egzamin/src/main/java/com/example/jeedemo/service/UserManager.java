package com.example.jeedemo.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.MyGroup;
import com.example.jeedemo.domain.MyUser;
import com.example.jeedemo.domain.Producer;
import com.example.jeedemo.domain.Shop;
import com.example.jeedemo.domain.Watch;

@Stateless
public class UserManager {
	@PersistenceContext
	EntityManager em;
	
	public void addUser(MyUser user, String role) throws NoSuchAlgorithmException, UnsupportedEncodingException {		
		MyGroup grupa = new MyGroup();
		grupa.setGroupname(role);
		grupa.setUsername(user.getUsername());
	    
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(user.getPassword().getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

	    user.setPassword(hexString.toString());
	    em.persist(grupa);
		em.persist(user);
	}
	
	public void updateUser(MyUser user, String role) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(user.getPassword().getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        
        MyGroup grupa = em.find(MyGroup.class, user.getId());
        grupa.setGroupname(role);
	    user.setPassword(hexString.toString());
		em.merge(user);
		em.merge(grupa);
	}
	
	public void deleteUser(MyUser user) {
		user = em.find(MyUser.class, user.getId());
		MyGroup grup = em.find(MyGroup.class, user.getId());
		em.remove(user);
		em.remove(grup);
	}
	
	@SuppressWarnings("unchecked")
	public List<MyUser> getAllUsers() {
		return em.createNamedQuery("user.all").getResultList();
	}
	
	public String getRole(Long id){
		return em.find(MyGroup.class, id).getGroupname();
	}
}