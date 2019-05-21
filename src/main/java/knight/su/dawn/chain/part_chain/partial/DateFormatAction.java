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
public class DateFormatAction implements IPartialAction<PartialDto> {

	@Override
	public void handle(List<PartialDto> reqs, PartialContext context) {
		for (PartialDto dto : reqs) {
			dto.setTime(formatHmsColon(dto.getTime(), context.isTrim()));
		}
	}

	/**
	 * h:m:s -> hh:mm:ss
	 * @param input
	 * @param trim
	 * @return
	 */
	public static String formatHmsColon(String input, boolean trim) {
		if (input == null) {
			return input;
		}
		if (trim) {
			input = input.trim();
		}
		int len = input.length();
		if ((len != 5) && (len != 6) && (len != 7)) {
			return input;
		}
		String[] s = input.split(":");
		int size = s.length;
		if (size != 3) {
			return input;
		}
		String result = "";
		int s0len = s[0].length();
		if (s0len == 2) {
			result = result + s[0];
		} else if (s0len == 1) {
			result = result + "0" + s[0];
		} else {
			return input;
		}
		result = result + ":";
		int s1len = s[1].length();
		if (s1len == 2) {
			result = result + s[1];
		} else if (s1len == 1) {
			result = result + "0" + s[1];
		} else {
			return input;
		}
		result = result + ":";
		int s2len = s[2].length();
		if (s2len == 2) {
			result = result + s[2];
		} else if (s2len == 1) {
			result = result + "0" + s[2];
		} else {
			return input;
		}
		return result;
	}
}
