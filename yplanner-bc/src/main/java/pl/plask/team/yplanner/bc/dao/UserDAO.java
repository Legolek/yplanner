package pl.plask.team.yplanner.bc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import pl.plask.team.yplanner.bc.model.ds.UserDS;

public interface UserDAO extends HibernateDAO<UserDS> {
	public Optional<UserDS> getUserByName(String name);
	
	public List<UserDS> getAllUsersByPage(Pageable page);
}
