package knight.su.dawn.chain.part_chain.partial;

import java.util.List;

import knight.su.dawn.chain.part_chain.IPartialAction;
import knight.su.dawn.chain.part_chain.PartialContext;
import knight.su.dawn.chain.part_chain.PartialDto;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public class GlobalCityAction implements IPartialAction<PartialDto> {

	@Override
	public void handle(List<PartialDto> reqs, PartialContext context) {
		for (PartialDto dto : reqs) {
			dto.setCity(context.getGlobalCity());
		}
	}

}
