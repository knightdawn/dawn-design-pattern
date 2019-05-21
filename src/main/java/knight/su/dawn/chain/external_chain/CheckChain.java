package knight.su.dawn.chain.external_chain;

import java.util.List;

/**
 * 
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public class CheckChain<Req> {

	private List<ICheckHandler<Req>> checkHandlers;

	public void setCheckHandlers(List<ICheckHandler<Req>> checkHandlers) {
		this.checkHandlers = checkHandlers;
	}

	/**
	 * 
	 * @param req
	 * @return
	 */
	public boolean check(Req req) {
		boolean isAllRight = false;
		for (ICheckHandler<Req> handler : checkHandlers) {
			if (handler.isOpen(req)) {
				isAllRight = handler.doCheck(req);
				if (!isAllRight) {
					break;
				}
			}
		}
		return isAllRight;
	}
}
