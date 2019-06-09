package knight.su.dawn.visitor.demo.element;

import knight.su.dawn.visitor.demo.Element;
import knight.su.dawn.visitor.demo.Visitor;

/**
 *
 * Date: 2019年6月8日<br/>
 * 
 * @author sugengbin
 */
public class Order implements Element {

	private long orderId;
	private int piece;
	private float weight;
	private float price;
	private boolean overWeight; // 超重
	private boolean largePiece; // 件数过多
	private boolean abnormalAmounts; // 金额异常

	public Order(long orderId, int piece, float weight, float price) {
		this.orderId = orderId;
		this.piece = piece;
		this.weight = weight;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order:" + this.orderId +"#piece=" +
				this.piece + ",#weight=" + 
				this.weight + ",#price=" + 
				this.price + ",#overWeight=" + 
				this.overWeight + ",#largePiece=" + 
				this.largePiece + ",#abnormalAmounts=" + 
				this.abnormalAmounts;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.monitor(this);
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
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

	public boolean isOverWeight() {
		return overWeight;
	}

	public void setOverWeight(boolean overWeight) {
		this.overWeight = overWeight;
	}

	public boolean isLargePiece() {
		return largePiece;
	}

	public void setLargePiece(boolean largePiece) {
		this.largePiece = largePiece;
	}

	public boolean isAbnormalAmounts() {
		return abnormalAmounts;
	}

	public void setAbnormalAmounts(boolean abnormalAmounts) {
		this.abnormalAmounts = abnormalAmounts;
	}

}
