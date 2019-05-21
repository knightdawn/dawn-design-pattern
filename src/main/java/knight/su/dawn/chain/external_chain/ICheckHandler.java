package knight.su.dawn.chain.external_chain;

/**
 * 
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public interface ICheckHandler<Req> {

	/**
	 * handler的开关
	 * 
	 * @param req
	 * @return
	 */
	boolean isOpen(Req req);

	/**
	 * 条件检查
	 * 
	 * @param req
	 * @return
	 */
	boolean doCheck(Req req);
}
