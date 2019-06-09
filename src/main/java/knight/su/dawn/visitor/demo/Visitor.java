package knight.su.dawn.visitor.demo;

import knight.su.dawn.visitor.demo.element.Order;
import knight.su.dawn.visitor.demo.element.Task;

/**
 *
 * Date: 2019年6月8日<br/>
 * 
 * @author sugengbin
 */
public interface Visitor {

	/**
	 * 
	 * @param order
	 */
	void monitor(Order order);

	/**
	 * 
	 * @param task
	 */
	void monitor(Task task);
}
