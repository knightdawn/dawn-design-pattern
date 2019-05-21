package knight.su.dawn.chain.filter_chain.filters;

import knight.su.dawn.chain.filter_chain.Filter;
import knight.su.dawn.chain.filter_chain.FilterChain;
import knight.su.dawn.chain.filter_chain.Request;
import knight.su.dawn.chain.filter_chain.Response;

/**
 *
 * Date: 2019年5月20日<br/>
 * 
 * @author sugengbin
 */
public class LogFilter implements Filter {

	@Override
	public void doFilter(Request req, Response resp, FilterChain chain) {
		log(req);
		chain.doFilter(req, resp);
		log(resp);
	}

	/**
	 * 
	 * @param t
	 */
	private void log(Object t) {
		System.out.println(t.toString());
	}
}
