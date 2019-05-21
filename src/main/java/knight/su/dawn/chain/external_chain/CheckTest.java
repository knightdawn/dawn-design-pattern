package knight.su.dawn.chain.external_chain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:*.xml")
public class CheckTest {

	private @Autowired @Qualifier("checkChain") CheckChain<ReqDto> checkChain;

	@Test
	public void testCheck() {
		ReqDto req = new ReqDto().setDevice("device1").setUser("user1").setVersion("1.0");
		Assert.assertTrue(checkChain.check(req));
		req.setDevice("device5");
		Assert.assertFalse(checkChain.check(req));
		req.setDevice("device1").setUser("user5");
		Assert.assertFalse(checkChain.check(req));
		req.setVersion("5.0");
		Assert.assertFalse(checkChain.check(req));
		req.setVersion("2.0").setUser("user2");
		Assert.assertTrue(checkChain.check(req));
	}
}
