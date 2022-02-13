package com.blog.BlogJSF.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.blog.BlogJSF.dao.UsuarioDAO;
import com.blog.BlogJSF.dominio.Usuario;
import com.blog.BlogJSF.util.BlogException;

@ManagedBean
@ViewScoped
public class UsuarioMBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	private Integer usuarioId;
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public void excluir(Usuario usuario) throws BlogException {
		usuarioDAO.excluir(usuario);
	}
	
	public List<Usuario> getLista() throws BlogException {
		List<Usuario>lista = usuarioDAO.listar();
		return lista;
	}
	
	public void editar(Usuario usuario) throws BlogException {
		this.usuario = usuario;
		this.usuarioId = usuario.getId();
	}
	
	public void gravar() throws BlogException {
		if(this.usuario.getId() == null) {
			usuarioDAO.salvar(this.usuario);
		} else {
			usuarioDAO.atualizar(this.usuario);
		}
		this.usuario = new Usuario();
	}
}
