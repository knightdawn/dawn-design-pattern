package knight.su.dawn.chain.filter_chain.filters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class SpecialCharFilter implements Filter {

	@Override
	public void doFilter(Request req, Response resp, FilterChain chain) {
		System.out.println("do filter req special char");
		req.setReq(filter(req.getReq()));
		chain.doFilter(req, resp);
		System.out.println("do filter resp special char");
		resp.setResp(filter(resp.getResp()));
	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	private String filter(String input) {
		String regEx = "[`~!@#$%^&*()_\\-+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(input);
		input = m.replaceAll("").trim();
		return input;
	}
}
