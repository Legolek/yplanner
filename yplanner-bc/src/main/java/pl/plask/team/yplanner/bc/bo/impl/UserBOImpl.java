package pl.plask.team.yplanner.bc.bo.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.plask.team.yplanner.bc.assembler.UserAssembler;
import pl.plask.team.yplanner.bc.auth.YPlannerUser;
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
		Optional<UserDS> user = userDao.getUserByName(name);
		user.orElseThrow(() -> {
			throw new UsernameNotFoundException("User with name: " + name + " not found");
		});
		return user.map(YPlannerUser::createFromDS).get();
	}

	@Override
	public UserDTO getUserByLogin(String login) {
		Optional<UserDS> user = userDao.getUserByName(login);
		return user.map(userAssembler::convertToDTO).orElse(UserDTO.empty());
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<UserDS> users = userDao.getAll(UserDS.class);
		return users.stream().map(userAssembler::convertToDTO).collect(Collectors.toList());
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
