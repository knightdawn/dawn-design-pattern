package knight.su.dawn.visitor.asm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 *
 * Date: 2019年6月7日<br/>
 * 
 * @author sugengbin
 */
public class AsmTest {

	/**
	 * <pre>
	 * step:
	 * 0、clean project 
	 * 1、run: java knight.su.dawn.visitor.asm.MethodTest
	 * 2、run: AsmTest
	 * 3、run: java knight.su.dawn.visitor.asm.MethodTest
	 * </pre>
	 * 
	 * <pre>
	 * ASM visitor
	 * ClassReader：它将字节数组或者class文件读入到内存当中，并形成内部表示的树结构
	 * 
	 * ClassVisitor：ClassReader对象构建好之后，需要调用这个类的accept方法，这个方法接收ClassVisitor类的实例作为参数。
	 * 框架在遍历树结构的不同节点时会调用ClassVisitor类上不同的visitor方法，遍历并调用ClassVisitor的算法骨架是由ClassReader确定的，
	 * 用户可以做的是提供自己的ClassVisitor类的实现，从而实现对字节码的修改。ClassVisitor上的一些访问会产生一些子过程，
	 * 比如visitMethod会产生MethodVisitor的调用，visitField会产生对FieldVisitor的调用，用户也可以对这些Visitor进行自己的实现，
	 * 从而达到对这些子节点上的字节码访问的修改
	 * 
	 *  ClassWriter：生成字节码的工具类，也是ClassVisitor接口的实现，它一般作为职责链上的最后一个节点被执行。
	 * 即其前面的ClassVisitor链条上的每一个visitor都是致力与对原始字节码做某一项修改，ClassWriter这个visitor的操作则是老实得把
	 * 每一个节点的字节码输出到指定的文件当中
	 * 
	 * ClassAdapter：它实现了ClassVisitor定义的所有接口，并接受一个ClassVisitor对象作为构建一个新的ClassAdapter实例的参数。
	 * 所以它的实现一般是职责链上的一个节点, 这里也实现了职责链模式
	 * 
	 * ASM的大体实现流程是这样的：ClassReader读取字节码，生成用于表示该字节码的内部表示的树；
	 * 组装一系列ClassVisitor的链条，这些visitor对应与visitor模式中的具体访问者类，一般都完成了字节码进行一项不同的字节码改写的操作，
	 * 而整个职责链则完成了对字节码的一系列不同的字节码修改工作；然后调用ClassReader的accept方法，传入ClassVisitor的对象，
	 * 也是一个职责链条，ClassReader使用这个链条上的每个Visitor对已加载进内存的字节码的树结构上的每个节点进行访问，在链条的末端，
	 * 调用ClassWriter这个visitor进行修改后的字节码的输出工作
	 * 
	 * </pre>
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ClassReader cr = new ClassReader(new FileInputStream(new File(
				"/Users/sugengbin/code/github/dawn/dawn-design-pattern/bin/knight/su/dawn/visitor/asm/MethodTest.class")));
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
		MyClassAdapter pi = new MyClassAdapter(Opcodes.ASM5, cw);

		cr.accept(pi, ClassReader.EXPAND_FRAMES);

		FileOutputStream fos = new FileOutputStream(new File(
				"/Users/sugengbin/code/github/dawn/dawn-design-pattern/bin/knight/su/dawn/visitor/asm/MethodTest.class"));
		fos.write(cw.toByteArray());
		fos.flush();
		fos.close();
	}
}
