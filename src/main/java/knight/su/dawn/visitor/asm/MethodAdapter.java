package knight.su.dawn.visitor.asm;

import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;

/**
 *
 * Date: 2019年6月7日<br/>
 * 
 * @author sugengbin
 */
public class MethodAdapter extends AdviceAdapter {

	private static final String ASPECT_INNER_NAME = Type.getInternalName(AspectUtil.class);
	private static final MethodTagMaintainer methodTagMaintainer = MethodTagMaintainer.getInstance();

	private int startTimeIdentifier;
	private int tag;

	public MethodAdapter(int access, String methodName, String desc, MethodVisitor mv) {
		super(ASM5, mv, access, methodName, desc);
		tag = methodTagMaintainer.addMethodTag(MethodTag.getGeneralInstance("", methodName, ""));
	}

	@Override
	protected void onMethodEnter() {
		mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "nanoTime", "()J", false);
		startTimeIdentifier = newLocal(Type.LONG_TYPE);
		mv.visitVarInsn(LSTORE, startTimeIdentifier);
	}

	@Override
	protected void onMethodExit(int opcode) {
		if ((IRETURN <= opcode && opcode <= RETURN) || opcode == ATHROW) {
			mv.visitVarInsn(LLOAD, startTimeIdentifier);
			mv.visitLdcInsn(tag);
			mv.visitMethodInsn(INVOKESTATIC, ASPECT_INNER_NAME, "record", "(JI)V", false);
		}
	}
}
