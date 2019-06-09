package knight.su.dawn.visitor.demo.visitor;

import java.util.Objects;

import knight.su.dawn.visitor.demo.Visitor;
import knight.su.dawn.visitor.demo.element.Order;
import knight.su.dawn.visitor.demo.element.Task;

/**
 *
 * Date: 2019年6月8日<br/>
 * 
 * @author sugengbin
 */
public class WeightVisitor implements Visitor {

	@Override
	public void monitor(Order order) {
		if (Objects.isNull(order)) {
			return;
		}
		order.setOverWeight(order.getWeight() > 50);
	}

	@Override
	public void monitor(Task task) {
		if (Objects.nonNull(task) && task.getWeight() > 50) {
			System.out.println("taskId:" + task.getTaskId() + ": over weight:" + task.getWeight());
		}
	}

}
