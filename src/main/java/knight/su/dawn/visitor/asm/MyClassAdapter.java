package knight.su.dawn.visitor.asm;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

/** 
 *
 * Date:     2019年6月7日<br/> 
 * @author   sugengbin 
 */
public class MyClassAdapter extends ClassVisitor {
 
	public MyClassAdapter(int api, ClassVisitor paramClassVisitor) {
		super(api, paramClassVisitor);
	}

	@Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access,  name,  desc,  signature,  exceptions);
        if (mv == null) {
            return null;
        }
        mv = new MethodAdapter(Opcodes.ASM5, name, desc, mv);
        return mv;
    }
}
