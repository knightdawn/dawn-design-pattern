package knight.su.dawn.chain.filter_chain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Date: 2019年5月20日<br/>
 * 
 * @author sugengbin
 */
public class FilterChain {

	private List<Filter> filters = new ArrayList<Filter>();
	// filter index
	private int index = 0;

	public FilterChain addFilter(Filter f) {
		filters.add(f);
		return this;
	}

	public void doFilter(Request req, Response resp) {
		if (index == filters.size()) {
			return;
		}
		// current filter
		Filter f = filters.get(index);
		index++;
		f.doFilter(req, resp, this);
	}
}
