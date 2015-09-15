package pl.plask.team.yplanner.bc.dao.impl;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import pl.plask.team.yplanner.bc.dao.HibernateDAO;
import pl.plask.team.yplanner.bc.model.ds.UserDS;

public class HibernateDAOImpl<T> implements HibernateDAO<T> {
	
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(value = TxType.SUPPORTS)
	public T get(Class<T> clazz, Long id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void save(T entity) {
		getSession().saveOrUpdate(entity);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(value = TxType.SUPPORTS)
	public List<T> getAll(Class<T> clazz) {
		return (List<T>) getSession().createCriteria(clazz).list();
	}
	
	@Override
	@Transactional(value = TxType.SUPPORTS)
	public Long count(Class<T> clazz) {
		return (Long) getSession().createCriteria(clazz).setProjection(Projections.count("id")).uniqueResult();
	}


	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
