package knight.su.dawn.visitor.asm;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * Created by LinShunkang on 2018/5/20
 */
public class MethodTagMaintainer {

	public static final int MAX_NUM = 1024 * 128;

	private final AtomicInteger index = new AtomicInteger(0);

	private final AtomicReferenceArray<MethodTag> methodTagArr = new AtomicReferenceArray<>(MAX_NUM);

	private final ConcurrentHashMap<Integer, MethodTag> methodTagMap = new ConcurrentHashMap<>(1024);

	private final ConcurrentHashMap<Method, Integer> methodMap = new ConcurrentHashMap<>(1024);

	private static final MethodTagMaintainer instance = new MethodTagMaintainer();

	private MethodTagMaintainer() {
		// empty
	}

	public static MethodTagMaintainer getInstance() {
		return instance;
	}

	public int addMethodTag(MethodTag methodTag) {
		int methodId = index.getAndIncrement();
		if (methodId > MAX_NUM) {
			return -1;
		}

		// methodTagArr.set(methodId, methodTag);
		System.out.println("add :" + methodTag);
		methodTagMap.put(methodId, methodTag);
		return methodId;
	}

	public int addMethodTag(Method method) {
		Integer tagId = methodMap.get(method);
		if (tagId != null) {
			return tagId;
		}

		synchronized (this) {
			tagId = methodMap.get(method);
			if (tagId != null) {
				return tagId;
			}

			tagId = addMethodTag(createMethodTag(method));
		}

		if (tagId < 0) {
			return tagId;
		}

		methodMap.putIfAbsent(method, tagId);
		return tagId;
	}

	private static MethodTag createMethodTag(Method method) {
		return MethodTag.getDynamicProxyInstance(method.getDeclaringClass().getSimpleName(), method.getName(), "");
	}

	public MethodTag getMethodTag(int methodId) {
		if (methodId >= 0 && methodId < MAX_NUM) {
			// return methodTagArr.get(methodId);
			System.out.println("methodId:" + methodId);
			return methodTagMap.get(methodId);
		}
		return null;
	}

	public int getMethodTagCount() {
		return index.get();
	}
}
