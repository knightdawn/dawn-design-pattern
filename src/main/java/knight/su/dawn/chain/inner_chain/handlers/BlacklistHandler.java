package knight.su.dawn.chain.inner_chain.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import knight.su.dawn.chain.inner_chain.HandleReq;
import knight.su.dawn.chain.inner_chain.HandleResp;
import knight.su.dawn.chain.inner_chain.InnerChainHandler;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public class BlacklistHandler extends InnerChainHandler<HandleResp> {

	public static List<String> blacklist = new ArrayList<>();
	static {
		blacklist.add("123");
		blacklist.add("abc");
	}

	@Override
	public HandleResp action(HandleReq req) {
		if (blacklist.contains(req.getUser())) {
			return new HandleResp("blacklist reject");
		} else if (Objects.nonNull(nextHandler)) {
			return nextAction(req);
		} else {
			return new HandleResp("invalid user");
		}
	}

}
