package pl.plask.team.yplanner.bc.bo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.security.core.GrantedAuthority;

import pl.plask.team.yplanner.bc.dto.UserDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/yplanner-bc-beans.xml", "classpath:/yplanner-bc-test-ctx.xml" })
public class UserBOImplTest {

	private static final String EXISTING_LOGIN = "TestLogin1";
	private static final String NON_EXISTING_LOGIN = "TestLogin2";
	private static final String ADMIN_LOGIN = "TestFristName10";

	private UserBO userBo;

	@Test(expected = UsernameNotFoundException.class)
	public void testLoadUserByUsername() {
		UserDetails user = userBo.loadUserByUsername(EXISTING_LOGIN);
		Assert.assertNotNull(user);
		Assert.assertEquals(EXISTING_LOGIN, user.getUsername());
		Assert.assertNotNull(user.getAuthorities());
		Assert.assertEquals(1, user.getAuthorities().size());
		Assert.assertEquals("ROLE_USER", user.getAuthorities().iterator().next().getAuthority());

		user = userBo.loadUserByUsername(ADMIN_LOGIN);
		Assert.assertNotNull(user);
		Assert.assertEquals(ADMIN_LOGIN, user.getUsername());
		Assert.assertNotNull(user.getAuthorities());
		Assert.assertEquals(2, user.getAuthorities().size());
		Assert.assertTrue(user.getAuthorities().stream().map(GrantedAuthority::getAuthority).anyMatch(e -> e.equals("ROLE_ADMIN")));

		user = userBo.loadUserByUsername(NON_EXISTING_LOGIN);
	}

	@Test
	public void testGetUserByLogin() {
		UserDTO user = userBo.getUserByLogin(EXISTING_LOGIN);
		Assert.assertNotNull(user);
		Assert.assertEquals(EXISTING_LOGIN, user.getLogin());
		Assert.assertNotNull(user.getId());

		user = userBo.getUserByLogin(NON_EXISTING_LOGIN);
		Assert.assertNull(user.getId());
	}

	@Test
	public void testGetAllUsers() {
		List<UserDTO> users = userBo.getAllUsers();
		Assert.assertNotNull(users);
		Assert.assertEquals(6, users.size());
	}
	
	@Test
	public void testGetAllUsersByPage() {
		List<UserDTO> users = userBo.getAllUsersByPage(new PageRequest(0, 4));
		Assert.assertNotNull(users);
		Assert.assertEquals(4, users.size());
		
		users = userBo.getAllUsersByPage(new PageRequest(1, 4));
		Assert.assertNotNull(users);
		Assert.assertEquals(2, users.size());
		
		users = userBo.getAllUsersByPage(new PageRequest(0, 3));
		Assert.assertNotNull(users);
		Assert.assertEquals(3, users.size());
		
		users = userBo.getAllUsersByPage(new PageRequest(1, 3));
		Assert.assertNotNull(users);
		Assert.assertEquals(3, users.size());
		
		users = userBo.getAllUsersByPage(new PageRequest(0, 2));
		Assert.assertNotNull(users);
		Assert.assertEquals(2, users.size());
		
		users = userBo.getAllUsersByPage(new PageRequest(1, 2));
		Assert.assertNotNull(users);
		Assert.assertEquals(2, users.size());
	}
	
	@Test
	public void testCountUsers() {
		long count = userBo.countUsers();
		Assert.assertEquals(6, count);
	}

	public UserBO getUserBo() {
		return userBo;
	}

	@Autowired
	@Qualifier("userBo")
	public void setUserBo(UserBO userBo) {
		this.userBo = userBo;
	}

}
