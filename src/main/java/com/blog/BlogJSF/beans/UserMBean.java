package com.blog.BlogJSF.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.blog.BlogJSF.dao.UserDAO;
import com.blog.BlogJSF.dominio.User;
import com.blog.BlogJSF.util.BlogException;

@ManagedBean
@ViewScoped
public class UserMBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user = new User();
	private Integer userId;
	
	private UserDAO userDAO = new UserDAO();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public void excluir(User user) throws BlogException {
		userDAO.excluir(user);
	}
	
	public List<User> getLista() throws BlogException {
		List<User>lista = userDAO.listar();
		return lista;
	}
	
	public void editar(User user) throws BlogException {
		this.user = user;
		this.userId = user.getId();
	}
	
	public void gravar() throws BlogException {
		if(this.user.getId() == null) {
			userDAO.salvar(this.user);
		} else {
			userDAO.atualizar(this.user);
		}
		this.user = new User();
	}
}
