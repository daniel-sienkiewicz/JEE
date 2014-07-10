package com.example.jeedemo.web;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.jeedemo.domain.MyUser;
import com.example.jeedemo.domain.Watch;
import com.example.jeedemo.service.UserManager;

@SessionScoped
@Named("userF")
public class UserFormBean implements Serializable{

	private MyUser user = new MyUser();
	ListDataModel<MyUser> users = new ListDataModel<MyUser>();
	MyUser userToUpdate = new MyUser();
	String role;
	String grupa;
	
	public String getGrupa() {
		return grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

	@Inject
	private UserManager um;
	
	public String getRole() {
		return role;
	}
	
	public String role(Long id){
		return um.getRole(id);
	}

	public MyUser getUserToUpdate() {
		return userToUpdate;
	}

	public void setUserToUpdate(MyUser userToUpdate) {
		this.userToUpdate = userToUpdate;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
	
	public ListDataModel<MyUser> getAllUsers() {
		users.setWrappedData(um.getAllUsers());
		return users;
	}
	
	public String addUser() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		um.addUser(user, role);
		return "/home";
	}
	
	public String logout(HttpSession session, HttpServletRequest request) throws ServletException{
		session.invalidate();
		request.logout();
		return "home";
	}
	
	public String deleteUser() {
		MyUser userToDelete = users.getRowData();
		um.deleteUser(userToDelete);
		return null;
	}
	
	public String updateUser() {
		userToUpdate = users.getRowData();
		role = um.getRole(userToUpdate.getId());
		return "/admin/updateUser";
	}
	
	public String updateSUser() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		um.updateUser(userToUpdate, role);
		return "/admin/userList";
	}
	
	public void userName(FacesContext context, UIComponent component, Object value) {

		String userName = (String) value;

		for (MyUser user : um.getAllUsers()) {
			if (user.getUsername().equalsIgnoreCase(userName)) {
				FacesMessage message = new FacesMessage("User exists in database");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
}