package knight.su.dawn.chain.external_chain.checks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import knight.su.dawn.chain.external_chain.ICheckHandler;
import knight.su.dawn.chain.external_chain.ReqDto;

/**
 * 
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
@Component
public class CheckUser implements ICheckHandler<ReqDto> {

	static List<String> userList = new ArrayList<String>();
	static {
		userList.add("user1");
		userList.add("user2");
		userList.add("user3");
		userList.add("user4");
	}

	@Override
	public boolean isOpen(ReqDto req) {
		return true;
	}

	@Override
	public boolean doCheck(ReqDto req) {
		boolean pass = false;
		try {
			String user = req.getUser();
			pass = userList.contains(user);
		} catch (Exception e) {
			// fix
		}
		return pass;
	}

}
