package pl.plask.team.yplanner.bc.assembler.impl;

import org.springframework.stereotype.Component;

import pl.plask.team.yplanner.bc.assembler.UserAssembler;
import pl.plask.team.yplanner.bc.dto.UserDTO;
import pl.plask.team.yplanner.bc.model.ds.UserDS;
import pl.plask.team.yplanner.bc.model.ds.helper.YesNoEnum;

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
		u.setEmail(user.getEmail());
		return u;
	}
	
	public UserDS convertToDS(UserDTO user) {
		if (user == null) {
			return null;
		}
		UserDS u = new UserDS();
		u.setId(user.getId());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setLogin(user.getLogin());
		u.setAdmin(YesNoEnum.get(user.isAdmin()));
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		return u;
	}
}
