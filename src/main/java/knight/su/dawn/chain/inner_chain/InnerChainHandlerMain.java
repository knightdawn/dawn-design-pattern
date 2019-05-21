package knight.su.dawn.chain.inner_chain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public class InnerChainHandlerMain<T> {

	List<InnerChainHandler<T>> handlers = new ArrayList<>();

	/**
	 * 
	 * @param handler
	 * @return
	 */
	public InnerChainHandlerMain<T> addHandler(InnerChainHandler<T> handler) {
		if (handlers.size() != 0) {
			InnerChainHandler<T> last = handlers.get(handlers.size() - 1);
			last.next(handler);
		}
		handlers.add(handler);
		return this;
	}

	public T action(HandleReq req) {
		// to validate handlers 
		return handlers.get(0).action(req);
	}
}
