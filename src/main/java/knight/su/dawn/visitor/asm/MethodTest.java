package knight.su.dawn.visitor.asm;

/**
 *
 * Date: 2019年6月7日<br/>
 * 
 * @author sugengbin
 */
public class MethodTest {

	public static int printInt(int i) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
		System.out.println(i);
		return i;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			printInt(i);
		}
		System.out.println("Done");
	}

}
