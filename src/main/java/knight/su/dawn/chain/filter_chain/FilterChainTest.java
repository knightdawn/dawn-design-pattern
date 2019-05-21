package knight.su.dawn.chain.filter_chain;

import knight.su.dawn.chain.filter_chain.filters.LogFilter;
import knight.su.dawn.chain.filter_chain.filters.SpecialCharFilter;

/**
 *
 * Date: 2019年5月20日<br/>
 * 
 * @author sugengbin
 */
public class FilterChainTest {

	public static void main(String[] args) {
		FilterChain chain = new FilterChain();
		chain.addFilter(new LogFilter())
			 .addFilter(new SpecialCharFilter())
			 .addFilter(new LogFilter());
		Request req = new Request();
		req.setReq("!@#$%^&*()123^^&&&&234234");
		Response resp = new Response();
		resp.setResp("~))(())()()(_+_+_+12345678#90");
		chain.doFilter(req, resp);
		
//		req:!@#$%^&*()123^^&&&&234234
//		do filter req special char
//		req:123234234
//		resp:~))(())()()(_+_+_+12345678#90
//		do filter resp special char
//		resp:1234567890

	}
}
