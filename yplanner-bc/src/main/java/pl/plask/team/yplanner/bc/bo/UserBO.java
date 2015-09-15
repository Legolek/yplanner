package pl.plask.team.yplanner.bc.bo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import pl.plask.team.yplanner.bc.dto.UserDTO;

public interface UserBO extends UserDetailsService {
	public UserDTO getUserByLogin(String login);
	
	public List<UserDTO> getAllUsers();
	
	public List<UserDTO> getAllUsersByPage(Pageable page);
	
	public Long countUsers();
}
