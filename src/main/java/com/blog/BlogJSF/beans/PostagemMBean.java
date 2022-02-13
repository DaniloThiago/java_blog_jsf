package com.blog.BlogJSF.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.blog.BlogJSF.dao.CategoriaDAO;
import com.blog.BlogJSF.dao.PostagemDAO;
import com.blog.BlogJSF.dao.UsuarioDAO;
import com.blog.BlogJSF.dominio.Categoria;
import com.blog.BlogJSF.dominio.Postagem;
import com.blog.BlogJSF.dominio.Usuario;
import com.blog.BlogJSF.util.BlogException;

@ManagedBean
@ViewScoped
public class PostagemMBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Postagem postagem = new Postagem();
	private Integer postagemId;
	private Usuario oUsuario;
	private Integer usuario;
	private Integer categoria;
	private Categoria oCategoria;

	private PostagemDAO postagemDAO = new PostagemDAO();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private CategoriaDAO categoriaDAO = new CategoriaDAO();
	
	private Date data = new Date();
	
	public Usuario getObjUsuario(Integer usuarioId) throws BlogException {
		return usuarioDAO.buscarId(usuarioId);
	}
	
	public Categoria getObjCategoria(Integer categoriaId) throws BlogException {
		return categoriaDAO.buscarId(categoriaId);
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	public Integer getPostagemId() {
		return postagemId;
	}

	public void setPostagemId(Integer postagemId) {
		this.postagemId = postagemId;
	}

	public Integer getUsuarioId() {
		return usuario;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuario = usuarioId;
	}
	
	public Usuario getUsuario() {
		return oUsuario;
	}

	public void setUsuario(Usuario usuario) {
		this.oUsuario = usuario;
	}

	public Integer getCategoriaId() {
		return categoria;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoria = categoriaId;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date date) {
		this.data = date;
	}

	public void excluir(Postagem postagem) throws BlogException {
		postagemDAO.excluir(postagem);
	}

	public List<Postagem> getLista() throws BlogException {
		List<Postagem> lista = postagemDAO.listar();
		return lista;
	}

	public List<Usuario> getListaUsuarios() throws BlogException {
		return usuarioDAO.listar();
	}
	
	public List<Categoria> getListaCategorias() throws BlogException{
		return categoriaDAO.listar();
	}

	public void editar(Postagem postagem) throws BlogException {
		this.postagem = postagem;
		this.postagemId = postagem.getId();
	}

	public void carregar() throws BlogException {

		if (this.postagemId != null) {
			this.postagem = postagemDAO.buscarId(this.postagemId);
			
			Integer usuarioId = this.postagem.getUsuario();

			this.oUsuario = this.getObjUsuario(usuarioId);

			Integer categoriaId = this.postagem.getCategoria();
			
			this.oCategoria = this.getObjCategoria(categoriaId);
			
			this.data = this.postagem.getData();
			
		} else {
			postagem = new Postagem();
		}
	}
	
	public void gravar() throws BlogException {
	
		try {
			postagem.setData(this.data);
			postagem.setUsuario(this.usuario);
			postagem.setCategoria(this.categoria);
			postagemDAO.salvar(this.postagem);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

			postagem = new Postagem();

	}

}
