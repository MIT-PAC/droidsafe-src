package droidsafe.eclipse.plugin.core.view.callhierarchy;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a source method in a source caller hierarchy.
 * 
 * @author gilham
 *
 */
public class SourceMethodNode {

	/** The signature of the source method. */
	String signature;
	
	/** The class name corresponding to the Java source file containing the source method declaration. */
	String sourceClass;
	
	/** The line number of the source method declaration */
	int line;
	
	/** A map from method signatures to the corresponding source method nodes */
	static Map<String, SourceMethodNode> nodeMap = new HashMap<String, SourceMethodNode>();
	
	/**
	 * Constructs a SourceMethodNode with the given signature.
	 */
	private SourceMethodNode(String signature) {
		this.signature = signature;
	}
	
	/**
	 * Returns the signature of the source method.
	 */
	public String getSignature() {
		return signature;
	}
	
	/**
	 * Returns the class name corresponding to the Java source file for the source method.
	 */
	public String getSourceClass() {
		return sourceClass;
	}
	
	/**
	 * Returns the line number of the source method declaration.
	 */
	public int getLine() {
		return line;
	}
	
	/**
	 * Given a method signature, returns the source method node with the signature.
	 */
	static SourceMethodNode get(String signature) {
		SourceMethodNode node = nodeMap.get(signature);
		if (node == null) {
			node = new SourceMethodNode(signature);
			nodeMap.put(signature, node);
		}
		return node;
	}

}
