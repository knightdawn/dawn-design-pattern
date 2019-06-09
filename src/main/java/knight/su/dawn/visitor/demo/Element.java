package knight.su.dawn.visitor.demo;

/**
 *
 * Date: 2019年6月8日<br/>
 * 
 * @author sugengbin
 */
public interface Element {

	/**
	 * 
	 * @param visitor
	 */
	void accept(Visitor visitor);
}
