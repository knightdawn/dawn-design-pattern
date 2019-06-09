package knight.su.dawn.visitor.demo;

import java.util.ArrayList;
import java.util.List;

import knight.su.dawn.visitor.demo.element.Order;
import knight.su.dawn.visitor.demo.element.Task;
import knight.su.dawn.visitor.demo.visitor.PieceVisitor;
import knight.su.dawn.visitor.demo.visitor.PriceVisitor;
import knight.su.dawn.visitor.demo.visitor.WeightVisitor;

/**
 *
 * Date: 2019年6月8日<br/>
 * 
 * @author sugengbin
 */
public class VisitorTest {

	public static void main(String[] args) {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1, 2, 6.1f, 20f));
		orders.add(new Order(2, 20, 60.1f, 51f));
		orders.add(new Order(3, 25, 65.1f, 3f));
		orders.add(new Order(4, 35, 100.1f, 6f));
		orders.add(new Order(5, 55, 120.1f, 9f));

		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(11, 1, 1.1f, 10.1f));
		tasks.add(new Task(12, 10, 10.1f, 48.1f));
		tasks.add(new Task(13, 21, 11.1f, 40.1f));
		tasks.add(new Task(14, 31, 12.1f, 50.1f));
		tasks.add(new Task(15, 41, 13.1f, 15.1f));
		tasks.add(new Task(16, 51, 105.1f, 100.1f));

		List<Visitor> visitors = new ArrayList<>();
		visitors.add(new PieceVisitor());
		visitors.add(new PriceVisitor());
		visitors.add(new WeightVisitor());
		for (Order order : orders) {
			for (Visitor visitor : visitors) {
				order.accept(visitor);
			}
			System.out.println(order);
		}

		for (Task task : tasks) {
			for (Visitor visitor : visitors) {
				task.accept(visitor);
			}
		}
	}
}
