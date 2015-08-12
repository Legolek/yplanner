package pl.plask.team.yplanner.bc.dao.impl;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import pl.plask.team.yplanner.bc.dao.UserDAO;
import pl.plask.team.yplanner.bc.model.ds.UserDS;

@Repository
public class UserDAOImpl extends HibernateDAOImpl<UserDS> implements UserDAO {

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public UserDS getUserByName(String name) {
		Query query = getSession().createQuery("from UserDS where login = :login");
		query.setString("login", name);
		return (UserDS) query.uniqueResult();
	}

}
