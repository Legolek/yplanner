package pl.plask.team.yplanner.bc.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import pl.plask.team.yplanner.bc.model.ds.UserDS;

public class YPlannerUser extends User {

	private static final String YPLANNER_ROLE_USER = "ROLE_USER";
	private static final String YPLANNER_ROLE_ADMIN = "ROLE_ADMIN";

	/**
	 * 
	 */
	private static final long serialVersionUID = -9007273789970867464L;

	private YPlannerUser(String login, String password, Collection<? extends GrantedAuthority> authorities) {
		super(login, password, authorities);
	}

	public static YPlannerUser createFromDS(UserDS user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(YPLANNER_ROLE_USER));
		if (user.getAdmin().booleanValue()) {
			authorities.add(new SimpleGrantedAuthority(YPLANNER_ROLE_ADMIN));
		}
		return new YPlannerUser(user.getLogin(), user.getPassword(), authorities);
	}
}
