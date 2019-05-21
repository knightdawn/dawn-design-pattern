package knight.su.dawn.chain.part_chain;

import java.util.ArrayList;
import java.util.List;

import knight.su.dawn.chain.part_chain.partial.BlankToConvertAction;
import knight.su.dawn.chain.part_chain.partial.DateFormatAction;
import knight.su.dawn.chain.part_chain.partial.GlobalCityAction;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public class PartialActionTest {

	public static void main(String[] args) {
		PartialChain<PartialDto> chain = new PartialChain<>();
		chain.addActions(new BlankToConvertAction())
		     .addActions(new DateFormatAction())
			 .addActions(new GlobalCityAction());

		List<PartialDto> dtos = new ArrayList<>();
		dtos.add(new PartialDto("1", "12:12:1", ""));
		dtos.add(new PartialDto("2", "12:12:1", "abc"));
		dtos.add(new PartialDto("3", "12:3:1", ""));
		dtos.add(new PartialDto("4", "3:12:1", ""));

		chain.handle(dtos, new PartialContext("SZ", true, "NULL"));

		dtos.forEach(System.out::println);
		
		/**
		 * id:1,time:12:12:01,city:SZ,content:NULL
		   id:2,time:12:12:01,city:SZ,content:abc
		   id:3,time:12:03:01,city:SZ,content:NULL
           id:4,time:03:12:01,city:SZ,content:NULL
		 */
	}
}
