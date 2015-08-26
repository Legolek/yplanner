package pl.plask.team.yplanner.bc.bo.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.plask.team.yplanner.bc.assembler.UserAssembler;
import pl.plask.team.yplanner.bc.bo.UserBO;
import pl.plask.team.yplanner.bc.dao.UserDAO;
import pl.plask.team.yplanner.bc.dto.UserDTO;
import pl.plask.team.yplanner.bc.model.ds.UserDS;

@Service("userBo")
public class UserBOImpl implements UserBO {

	private UserDAO userDao;
	private UserAssembler userAssembler;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		UserDS user = userDao.getUserByName(name);
		UserDetails userDetails = null;
		if (user != null) {
			userDetails = new User(user.getLogin(), user.getPassword(),
					Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
		} else {
			throw new UsernameNotFoundException("User with name: " + name + " not found");
		}
		return userDetails;
	}
	
	@Override
	public UserDTO getUserByLogin(String login) {
		UserDS user = userDao.getUserByName(login);
		return userAssembler.convertToDTO(user);
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	public UserAssembler getUserAssembler() {
		return userAssembler;
	}

	@Autowired
	public void setUserAssembler(UserAssembler userAssembler) {
		this.userAssembler = userAssembler;
	}

}
