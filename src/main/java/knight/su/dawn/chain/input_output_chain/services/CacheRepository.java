package knight.su.dawn.chain.input_output_chain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import knight.su.dawn.chain.input_output_chain.CacheEnum;
import knight.su.dawn.chain.input_output_chain.CacheStore;
import knight.su.dawn.chain.input_output_chain.IioChain;
import knight.su.dawn.chain.input_output_chain.LngLatDetail;
import knight.su.dawn.chain.input_output_chain.Tuple;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
@Component
@Order(1)
public class CacheRepository implements IioChain<String, LngLatDetail> {

	@Override
	public List<String> handle(List<String> input, Consumer<LngLatDetail> outputConsumer) {
		List<String> subInput = new ArrayList<>();
		try {
			System.out.println("CacheRepository enter...");
			if (CollectionUtils.isEmpty(input)) {
				System.out.println("CacheRepository input empty...");
				return new ArrayList<>();
			}
			CacheStore store = CacheEnum.CACHE.getInstance();
			for (String code : input) {
				Tuple<Float, Float> t = store.get(code);
				if (Objects.nonNull(t)) {
					outputConsumer.accept(new LngLatDetail(code, t._1, t._2));
				} else {
					subInput.add(code);
				}
			}
		} catch (Exception e) {
			System.out.println("CacheRepository error...");
		} finally {
			System.out.println("CacheRepository exit...");
		}
		return subInput;
	}

}
