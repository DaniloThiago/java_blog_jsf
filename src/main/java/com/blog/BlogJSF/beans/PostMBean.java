package com.blog.BlogJSF.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.blog.BlogJSF.dao.CategoryDAO;
import com.blog.BlogJSF.dao.PostDAO;
import com.blog.BlogJSF.dao.UserDAO;
import com.blog.BlogJSF.dominio.Category;
import com.blog.BlogJSF.dominio.Post;
import com.blog.BlogJSF.dominio.User;
import com.blog.BlogJSF.util.BlogException;

@ManagedBean
@ViewScoped
public class PostMBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Post post = new Post();
	private Integer postId;
	private User user;
	private Integer userId;
	private Category category;
	private Integer categoryId;

	private PostDAO postDAO = new PostDAO();
	private UserDAO userDAO = new UserDAO();
	private CategoryDAO categoryDAO = new CategoryDAO();
	
	private Date date = new Date();

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void excluir(Post post) throws BlogException {
		postDAO.excluir(post);
	}

	public List<Post> getLista() throws BlogException {
		List<Post> lista = postDAO.listar();
		return lista;
	}

	public List<User> getListaUsers() throws BlogException {
		return userDAO.listar();
	}
	
	public List<Category> getListaCategories() throws BlogException{
		return categoryDAO.listar();
	}

	public void editar(Post post) throws BlogException {
		this.post = post;
		this.postId = post.getId();
	}

	public void carregar() throws BlogException {

		if (this.postId != null) {
			this.post = postDAO.buscarId(this.postId);

			this.userId = this.post.getUser().getId();
			this.setUser(userDAO.buscarId(this.userId));

			this.categoryId = this.post.getCategory().getId();
			this.setCategory(categoryDAO.buscarId(this.categoryId));
			
			this.date = this.post.getDate();

		} else {
			post = new Post();
			setUser(new User());
			setCategory(new Category());

		}

	}

	public void gravar() throws BlogException {
		if (this.post.getId() == null) {
			postDAO.salvar(this.post);
		} else {
			postDAO.atualizar(this.post);
		}
		this.post = new Post();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
