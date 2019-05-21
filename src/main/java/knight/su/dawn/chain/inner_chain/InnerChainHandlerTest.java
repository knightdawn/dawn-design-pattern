package knight.su.dawn.chain.inner_chain;

import knight.su.dawn.chain.inner_chain.handlers.BlacklistHandler;
import knight.su.dawn.chain.inner_chain.handlers.NormalUserHandler;
import knight.su.dawn.chain.inner_chain.handlers.VipUserHandler;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public class InnerChainHandlerTest {

	public static void main(String[] args) {
		// BlacklistHandler handler = new BlacklistHandler();
		// handler.next(new NormalUserHandler().next(new VipUserHandler()));
		// HandleResp resp = handler.action(new HandleReq("123", "1"));
		// System.out.println(resp);
		// resp = handler.action(new HandleReq("111", "1"));
		// System.out.println(resp);
		// resp = handler.action(new HandleReq("111", "2"));
		// System.out.println(resp);
		// resp = handler.action(new HandleReq("111", "3"));
		// System.out.println(resp);

		InnerChainHandlerMain<HandleResp> main = new InnerChainHandlerMain<>();
		// 隐藏next的细节
		main.addHandler(new BlacklistHandler())
		    .addHandler(new NormalUserHandler())
		    .addHandler(new VipUserHandler());
		HandleResp resp = main.action(new HandleReq("123", "1"));
		System.out.println(resp);
		resp = main.action(new HandleReq("111", "1"));
		System.out.println(resp);
		resp = main.action(new HandleReq("111", "2"));
		System.out.println(resp);
		resp = main.action(new HandleReq("111", "3"));
		System.out.println(resp);
	}
}
