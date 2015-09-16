package pl.plask.team.yplanner.web.controllers.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.plask.team.yplanner.bc.bo.UserBO;
import pl.plask.team.yplanner.bc.dto.UserDTO;

@RestController
public class AdminUserController {
	
	private static final Integer DEFAULT_PAGE_SIZE = 10;
	
	private UserBO userBo;
	
	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public List<UserDTO> getAllUsers() {
		return userBo.getAllUsers();
	}
	
	@RequestMapping(value = "/admin/users/{pageNumber}", method = RequestMethod.GET)
	public List<UserDTO> getAllUsersByPage(@PathVariable String pageNumber) {
		return userBo.getAllUsersByPage(new PageRequest(Integer.valueOf(pageNumber), DEFAULT_PAGE_SIZE));
	}
	
	@RequestMapping(value = "/admin/new/user", method = RequestMethod.PUT)
	public String addUser(@RequestBody UserDTO user) {
		userBo.addUser(user);
		return "success";
	}
	
	@RequestMapping(value = "/admin/count/users", method = RequestMethod.GET)
	public long getTotalItems() {
		return userBo.countUsers();
	}

	public UserBO getUserBo() {
		return userBo;
	}

	@Autowired
	public void setUserBo(UserBO userBo) {
		this.userBo = userBo;
	}
}
