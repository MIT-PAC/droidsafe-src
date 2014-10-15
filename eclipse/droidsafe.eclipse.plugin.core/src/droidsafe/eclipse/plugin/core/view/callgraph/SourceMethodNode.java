package droidsafe.eclipse.plugin.core.view.callgraph;

import java.util.HashMap;
import java.util.Map;

public class SourceMethodNode {
	
	String signature;
	String sourceClass;
	int line;
	
	static Map<String, SourceMethodNode> nodeMap = new HashMap<String, SourceMethodNode>();
	
	private SourceMethodNode(String signature) {
		this.signature = signature;
	}
	
	public String getSourceClass() {
		return sourceClass;
	}
	
	public int getLine() {
		return line;
	}
	
	static SourceMethodNode get(String signature) {
		SourceMethodNode node = nodeMap.get(signature);
		if (node == null) {
			node = new SourceMethodNode(signature);
			nodeMap.put(signature, node);
		}
		return node;
	}

}
