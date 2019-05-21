package knight.su.dawn.chain.external_chain.checks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import knight.su.dawn.chain.external_chain.ICheckHandler;
import knight.su.dawn.chain.external_chain.ReqDto;

/**
 * 
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
@Component
public class CheckVersion implements ICheckHandler<ReqDto> {

	static List<String> versionList = new ArrayList<String>();
	static {
		versionList.add("1.0");
		versionList.add("2.0");
		versionList.add("3.0");
		versionList.add("4.0");
	}

	@Override
	public boolean isOpen(ReqDto req) {
		return true;
	}

	@Override
	public boolean doCheck(ReqDto req) {
		boolean pass = false;
		try {
			String version = req.getVersion();
			pass = versionList.contains(version);
		} catch (Exception e) {
			// fix
		}
		return pass;
	}

}
