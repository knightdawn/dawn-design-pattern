package knight.su.dawn.visitor.demo.element;

import knight.su.dawn.visitor.demo.Element;
import knight.su.dawn.visitor.demo.Visitor;

/**
 *
 * Date: 2019年6月8日<br/>
 * 
 * @author sugengbin
 */
public class Task implements Element {

	private long taskId;
	private int piece;
	private float weight;
	private float price;
	
	public Task(long taskId, int piece, float weight, float price) {
		this.taskId = taskId;
		this.piece = piece;
		this.weight = weight;
		this.price = price;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.monitor(this);
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public int getPiece() {
		return piece;
	}

	public void setPiece(int piece) {
		this.piece = piece;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
