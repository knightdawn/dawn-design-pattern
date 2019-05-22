package knight.su.dawn.chain.input_output_chain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import knight.su.dawn.chain.input_output_chain.IioChain;
import knight.su.dawn.chain.input_output_chain.LngLatDetail;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
@Component
@Order(2)
public class ServiceA implements IioChain<String, LngLatDetail> {

	@Override
	public List<String> handle(List<String> input, Consumer<LngLatDetail> outputConsumer) {
		try {
			System.out.println("ServiceA enter...");
			if (CollectionUtils.isEmpty(input)) {
				System.out.println("ServiceA input empty...");
				return new ArrayList<>();
			}
			List<LngLatDetail> details = getFromServiceA(input);
			for (LngLatDetail detail : details) {
				String code = detail.getCode();
				if (input.contains(code)) {
					input.remove(code);
				}
				outputConsumer.accept(detail);
				// to add cache
			}
		} catch (Exception e) {
			System.out.println("ServiceA error...");
		} finally {
			System.out.println("ServiceA exit...");
		}
		return input;
	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	private List<LngLatDetail> getFromServiceA(List<String> input) {
		List<LngLatDetail> details = new ArrayList<>();
		for (String code : input) {
			if ("e".equals(code)) {
				details.add(new LngLatDetail(code, 39.6855097600F, 93.0869140625F));
			}
		}
		return details;
	}

}
