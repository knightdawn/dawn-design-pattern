package knight.su.dawn.chain.input_output_chain;

import java.util.List;
import java.util.function.Consumer;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public interface IioChain<Input, Output> {

	/**
	 * 
	 * @param input
	 * @param outputConsumer
	 * @return subInput
	 */
	List<Input> handle(List<Input> input, Consumer<Output> outputConsumer);
}
