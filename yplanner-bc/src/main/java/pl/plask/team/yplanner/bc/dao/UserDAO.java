package pl.plask.team.yplanner.bc.dao;

import java.util.Optional;

import pl.plask.team.yplanner.bc.model.ds.UserDS;

public interface UserDAO extends HibernateDAO<UserDS> {
	public Optional<UserDS> getUserByName(String name);
}
