package pl.plask.team.yplanner.bc.assembler.impl;

import org.springframework.stereotype.Component;

import pl.plask.team.yplanner.bc.assembler.UserAssembler;
import pl.plask.team.yplanner.bc.dto.UserDTO;
import pl.plask.team.yplanner.bc.model.ds.UserDS;

@Component
public class UserAssemblerImpl implements UserAssembler {
	@Override
	public UserDTO convertToDTO(UserDS user) {
		if (user == null) {
			return null;
		}
		UserDTO u = new UserDTO();
		u.setId(user.getId());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setLogin(user.getLogin());
		u.setAdmin(user.getAdmin() != null ? user.getAdmin().booleanValue() : false);
		return u;
	}
}
