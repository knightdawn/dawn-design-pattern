package knight.su.dawn.visitor.asm;

/**
 *
 * Date: 2019年6月7日<br/>
 * 
 * @author sugengbin
 */
public class AspectUtil {

	public static void record(final long startNanos, final int tag) {
		try {
			long endNanos = System.nanoTime();
			int elapsedTime = (int) ((endNanos - startNanos) / 1000000);
//			MethodTag mt = MethodTagMaintainer.getInstance().getMethodTag(tag); 同一个进程下可以获取到方法名
			System.out.println("tag:" + tag + ", time-ms:" + elapsedTime);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
