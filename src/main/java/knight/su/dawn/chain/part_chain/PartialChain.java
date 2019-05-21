package knight.su.dawn.chain.part_chain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public class PartialChain<Req> implements IPartialAction<Req> {

	private List<IPartialAction<Req>> actions = new ArrayList<>();

	public PartialChain<Req> addActions(IPartialAction<Req> action) {
		actions.add(action);
		return this;
	}

	@Override
	public void handle(List<Req> reqs, PartialContext context) {
		for (IPartialAction<Req> action : actions) {
			action.handle(reqs, context);
		}
	}

}
