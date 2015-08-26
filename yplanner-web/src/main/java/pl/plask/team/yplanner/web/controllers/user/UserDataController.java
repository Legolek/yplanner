package pl.plask.team.yplanner.web.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.plask.team.yplanner.bc.bo.UserBO;
import pl.plask.team.yplanner.bc.dto.UserDTO;

@RestController
public class UserDataController {

	private UserBO userBo;
	
	@RequestMapping(value = "/userloggedin", method = RequestMethod.GET)
	public UserDTO getLoggedInUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDTO loggedUser = userBo.getUserByLogin(user.getUsername());
		return loggedUser;
	}

	public UserBO getUserBo() {
		return userBo;
	}

	@Autowired
	public void setUserBo(UserBO userBo) {
		this.userBo = userBo;
	}
}
