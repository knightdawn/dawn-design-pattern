package knight.su.dawn.chain.filter_chain;

/**
 *
 * Date: 2019年5月20日<br/>
 * 
 * @author sugengbin
 */
public interface Filter {
	
	/**
	 * 
	 * @param req
	 * @param resp
	 * @param chain
	 */
	void doFilter(Request req, Response resp, FilterChain chain);
}
