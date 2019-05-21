package knight.su.dawn.chain.part_chain;

import java.util.List;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public interface IPartialAction<Req> {

	/**
	 * 
	 * @param reqs
	 * @param context
	 */
	void handle(List<Req> reqs, PartialContext context);

}
