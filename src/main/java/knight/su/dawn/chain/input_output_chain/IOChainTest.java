package knight.su.dawn.chain.input_output_chain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * Date: 2019年5月22日<br/>
 * 
 * @author sugengbin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:*.xml")
public class IOChainTest {

	@Autowired
	private List<IioChain<String, LngLatDetail>> ioChains;

	@Test
	public void test() {
		List<String> input = new ArrayList<>();
		input.add("a");
		input.add("e");
		input.add("f");
		List<LngLatDetail> output = new ArrayList<>();
		for (IioChain<String, LngLatDetail> chain : ioChains) {
			input = chain.handle(input, output::add);
		}
		System.out.println("find null input:");
		input.forEach(System.out::println);
		System.out.println("output:");
		output.forEach(System.out::println);
	}
}
