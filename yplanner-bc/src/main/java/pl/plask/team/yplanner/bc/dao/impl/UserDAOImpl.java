package pl.plask.team.yplanner.bc.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import pl.plask.team.yplanner.bc.dao.UserDAO;
import pl.plask.team.yplanner.bc.model.ds.UserDS;
import pl.plask.team.yplanner.bc.model.ds.helper.UserDSQueryBuilder;

@Repository
public class UserDAOImpl extends HibernateDAOImpl<UserDS>implements UserDAO {

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public Optional<UserDS> getUserByName(String name) {
		Query query = getSession().createQuery("from UserDS where login = :login");
		query.setString("login", name);
		return Optional.ofNullable((UserDS) query.uniqueResult());
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public List<UserDS> getAllUsersByPage(Pageable page) {
		SQLQuery query = getSession().createSQLQuery(UserDSQueryBuilder.buildPagedQuery(page));
		query.setInteger(UserDSQueryBuilder.PAGE_START_PARAM, page.getPageNumber() * page.getPageSize() + 1);
		query.setInteger(UserDSQueryBuilder.PAGE_END_PARAM,
				page.getPageNumber() * page.getPageSize() + page.getPageSize());
		query.addEntity(UserDS.class);
		return (List<UserDS>) query.list();
	}

}
