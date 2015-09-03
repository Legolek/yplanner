package pl.plask.team.yplanner.web.controllers.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.plask.team.yplanner.bc.bo.UserBO;
import pl.plask.team.yplanner.bc.dto.UserDTO;

@RestController
public class AdminUserController {
	
	private UserBO userBo;
	
	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public List<UserDTO> getAllUsers() {
		return userBo.getAllUsers();
	}

	public UserBO getUserBo() {
		return userBo;
	}

	@Autowired
	public void setUserBo(UserBO userBo) {
		this.userBo = userBo;
	}
}
