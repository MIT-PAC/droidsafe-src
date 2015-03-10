/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

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
