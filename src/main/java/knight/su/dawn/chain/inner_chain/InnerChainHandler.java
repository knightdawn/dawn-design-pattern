package knight.su.dawn.chain.inner_chain;

/**
 *
 * Date: 2019年5月20日<br/>
 * 
 * @author sugengbin
 */
public abstract class InnerChainHandler<T> {

	protected InnerChainHandler<T> nextHandler;

	/**
	 * 
	 * @param nextHandler
	 * @return
	 */
	public InnerChainHandler<T> next(InnerChainHandler<T> nextHandler) {
		this.nextHandler = nextHandler;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public T nextAction(HandleReq req) {
		return this.nextHandler.action(req);
	}

	/**
	 * 
	 * @return
	 */
	public abstract T action(HandleReq req);
}
