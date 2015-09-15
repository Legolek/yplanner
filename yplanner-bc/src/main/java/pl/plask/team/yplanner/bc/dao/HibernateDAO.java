package pl.plask.team.yplanner.bc.dao;

import java.util.List;

import org.hibernate.Session;

public interface HibernateDAO<T> {
	
	public T get(Class<T> clazz, Long id);
	
	public void save(T entity);
	
	public List<T> getAll(Class<T> clazz);
	
	public Long count(Class<T> clazz);
	
	public Session getSession();
}
