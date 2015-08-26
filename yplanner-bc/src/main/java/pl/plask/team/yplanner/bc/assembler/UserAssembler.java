package pl.plask.team.yplanner.bc.assembler;

import pl.plask.team.yplanner.bc.dto.UserDTO;
import pl.plask.team.yplanner.bc.model.ds.UserDS;

public interface UserAssembler {
	public UserDTO convertToDTO(UserDS user);
}
