package pl.plask.team.yplanner.bc.bo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/yplanner-bc-beans.xml", "classpath:/yplanner-bc-test-ctx.xml"})
public class UserBOImplTest {

	private static final String EXISTING_LOGIN = "TestLogin1";
	private static final String NON_EXISTING_LOGIN = "TestLogin2";
	
	private UserBO userBo;

	@Test(expected = UsernameNotFoundException.class)
	public void testLoadUserByUsername() {
		UserDetails user = userBo.loadUserByUsername(EXISTING_LOGIN);
		Assert.assertNotNull(user);
		Assert.assertEquals(EXISTING_LOGIN, user.getUsername());
		Assert.assertNotNull(user.getAuthorities());
		Assert.assertEquals(1, user.getAuthorities().size());
		Assert.assertEquals("ROLE_USER", user.getAuthorities().iterator().next().getAuthority());
		
		user = userBo.loadUserByUsername(NON_EXISTING_LOGIN);
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
