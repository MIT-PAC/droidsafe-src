package jarmethods;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public class MyClassNode extends ClassNode {

	public void processByteCodeClass() {
		final String classname = this.name.replace("/", ".");

        for (Object method_node_object : this.methods) {
            final MethodNode methodnode = (MethodNode)method_node_object;
            Output.output_method(classname, methodnode);
        }
	}
}
