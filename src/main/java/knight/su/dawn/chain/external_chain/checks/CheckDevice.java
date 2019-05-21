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
public class CheckDevice implements ICheckHandler<ReqDto> {

	static List<String> deviceList = new ArrayList<String>();
	static {
		deviceList.add("device1");
		deviceList.add("device2");
		deviceList.add("device3");
		deviceList.add("device4");
	}

	@Override
	public boolean isOpen(ReqDto req) {
		return true;
	}

	@Override
	public boolean doCheck(ReqDto req) {
		boolean pass = false;
		try {
			String device = req.getDevice();
			pass = deviceList.contains(device);
		} catch (Exception e) {
			// fix
		}
		return pass;
	}

}
