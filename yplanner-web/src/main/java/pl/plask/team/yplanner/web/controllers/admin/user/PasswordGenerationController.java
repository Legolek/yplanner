package pl.plask.team.yplanner.web.controllers.admin.user;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.plask.team.yplanner.web.model.dto.GeneratedPassword;

@RestController
public class PasswordGenerationController {

	private static final int CHARACTER_COUNT = 10;
	
	@RequestMapping(value = "/admin/genpassword", method = RequestMethod.GET)
	public GeneratedPassword generatePassword() {
		String randomAlphanumeric = RandomStringUtils.randomAlphanumeric(CHARACTER_COUNT);
		return new GeneratedPassword(randomAlphanumeric);
	}
}
