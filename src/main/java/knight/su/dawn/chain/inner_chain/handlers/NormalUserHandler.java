package knight.su.dawn.chain.inner_chain.handlers;

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
public class NormalUserHandler extends InnerChainHandler<HandleResp> {

	@Override
	public HandleResp action(HandleReq req) {
		if ("1".equals(req.getUserType())) {
			return new HandleResp("normal user action");
		} else if (Objects.nonNull(nextHandler)) {
			return nextAction(req);
		} else {
			return new HandleResp("invalid user");
		}
	}

}
