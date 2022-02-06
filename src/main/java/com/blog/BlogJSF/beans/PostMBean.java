package com.blog.BlogJSF.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.blog.BlogJSF.dao.PostDAO;
import com.blog.BlogJSF.dominio.Post;
import com.blog.BlogJSF.util.BlogException;

@ManagedBean
@ViewScoped
public class PostMBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4379149671555061374L;

	private Post post =  new Post();
	private Integer postId;
	
	private PostDAO postDAO = new PostDAO();

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
	
	public void excluir(Post post) throws BlogException {
		postDAO.excluir(post);
	}
	
	public List<Post> getlista() throws BlogException {
		List<Post>lista = postDAO.listar();
		return lista;
	}
	
	public void editar(Post post) throws BlogException {
		this.post = post;
		this.postId = post.getId();
	}
	
	public void gravar() throws BlogException {
		if(this.post.getId() == null) {
			postDAO.salvar(this.post);
		} else {
			postDAO.atualizar(this.post);
		}
		this.post = new Post();
	}
}
