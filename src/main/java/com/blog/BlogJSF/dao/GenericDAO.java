package com.blog.BlogJSF.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.blog.BlogJSF.util.HibernateUtil;
import com.blog.BlogJSF.util.BlogException;

public class GenericDAO<Entidade> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Class<Entidade> classe;

	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) throws BlogException {
		// 1. Abre a sessao
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {

			sessao.getTransaction().begin();
			sessao.save(entidade);
			sessao.getTransaction().commit();

		} catch (HibernateException he) {
			if (sessao.getTransaction().isActive()) {
				sessao.getTransaction().rollback();
			}
			throw new BlogException("Erro ao gravar registro: " + he.getMessage());
		} finally {
			// TODO: handle finally clause
			if (sessao.isOpen()) {
				sessao.close();
			}
		}
	}

	public void atualizar(Entidade entidade) throws BlogException {
		// 1. Abre a sessao
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {

			sessao.getTransaction().begin();
			sessao.update(entidade);
			sessao.getTransaction().commit();

		} catch (HibernateException he) {
			if (sessao.getTransaction().isActive()) {
				sessao.getTransaction().rollback();
			}
			throw new BlogException("Erro ao atualizar registro: " + he.getMessage());
		} finally {
			// TODO: handle finally clause
			if (sessao.isOpen()) {
				sessao.close();
			}
		}
	}

	public void excluir(Entidade entidade) throws BlogException {
		// 1. Abre a sessao
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {

			sessao.getTransaction().begin();
			sessao.delete(entidade);
			sessao.getTransaction().commit();

		} catch (HibernateException he) {
			if (sessao.getTransaction().isActive()) {
				sessao.getTransaction().rollback();
			}
			throw new BlogException("Erro ao atualizar registro: " + he.getMessage());
		} finally {
			// TODO: handle finally clause
			if (sessao.isOpen()) {
				sessao.close();
			}
		}
	}

	public List<Entidade> listar() throws BlogException {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Entidade> lista = null;

		try {

			sessao.getTransaction().begin();

			CriteriaQuery<Entidade> query = sessao.getCriteriaBuilder().createQuery(this.classe);
			query.select(query.from(this.classe));
			lista = sessao.createQuery(query).getResultList();
			sessao.getTransaction().commit();
		} catch (HibernateException he) {
			if (sessao.getTransaction().isActive()) {
				sessao.getTransaction().rollback();
			}
			throw new BlogException("Erro ao listar registros: " + he.getMessage());
		} finally {
			// TODO: handle finally clause
			if (sessao.isOpen()) {
				sessao.close();
			}
		}
		return lista;
	}

	public Entidade buscarId(Integer id) throws BlogException {
		// 1. Abre a sessao
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Entidade entidade = null;
		try {

			sessao.getTransaction().begin();
			entidade = (Entidade) sessao.find(classe, id);
			sessao.getTransaction().commit();

		} catch (HibernateException he) {
			if (sessao.getTransaction().isActive()) {
				sessao.getTransaction().rollback();
			}
			throw new BlogException("Erro ao atualizar registro: " + he.getMessage());
		} finally {
			// TODO: handle finally clause
			if (sessao.isOpen()) {
				sessao.close();
			}
		}
		return entidade;
	}

}
