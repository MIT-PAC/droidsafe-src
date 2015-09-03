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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.Signature;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.view.indicator.Utils;

/**
 * Represents a caller hierarchy for a method in a Java source file. The root of
 * the caller hierarchy represents the original method. Each node in the caller
 * hierarchy is a SourceMethodNode representing a source method.
 * 
 * @author gilham
 *
 */
public class CallerHierarchy extends CallHierarchy {
	
	/** 
	 * A map from projects to callee signatures to caller signatures to sets of Json elements 
	 * representing method calls.
	 */
	static Map<IProject, Map<String, Map<String, Set<JsonElement>>>> projectCallerMap = new HashMap<IProject, Map<String, Map<String, Set<JsonElement>>>>();
    
    /** The root source method node of this caller hierarchy. */
    private SourceMethodNode fRoot;

    /**
     * Constructs a caller hierarchy.
     * 
     * @param project - the underlying project
     * @param root - the root method node
     * @param method - the root method
     */
    public CallerHierarchy(IProject project, SourceMethodNode root, IMethod method) {
    	fProject = project;
    	fRoot = root;
    	fDesription = computeDescription(method);
    }
    
    /**
     * Computes and returns a description string for this caller hierarchy.
     * 
     * @param method - the root method
     * @return the description string
     */
    String computeDescription(IMethod method) {
    	StringBuffer buf = new StringBuffer();
    		buf.append("Callers of ");
    	buf.append(method.getElementName());
    	buf.append("(");
    	boolean first = true;
    	for (String paramType: method.getParameterTypes()) {
    		if (first)
    			first = false;
    		else
    			buf.append(",");
    		buf.append(Signature.toString(paramType));
    	}
    	buf.append(")");
		return buf.toString();
	}

	/**
	 * Returns the root source method node of this caller hierarchy.
	 */
	public SourceMethodNode getRoot() {
    	return fRoot;
    }

	@Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	if (obj != null && obj instanceof CallerHierarchy) {
    		CallerHierarchy other = (CallerHierarchy) obj;
    		SourceMethodNode otherRoot = other.getRoot();
    		if (fRoot == null)
    			return otherRoot == null;
    		if (fRoot.equals(otherRoot))
    			return true;
    	}
    	return false;
    }
    
	/**
	 * Returns a map from callee signatures to caller signatures to sets of Json elements 
	 * representing method calls.
	 */
	public Map<String, Map<String, Set<JsonElement>>> getCallerMap() {
		return getCallerMap(fProject);
	}

	/**
	 * Given a project, returns a map from callee signatures to caller signatures to sets of method calls 
	 * for this project.
	 */
    public static Map<String, Map<String, Set<JsonElement>>> getCallerMap(IProject project) {
    	Map<String, Map<String, Set<JsonElement>>> callerMap = projectCallerMap.get(project);
    	if (callerMap == null) {
    		JsonElement callHierarchy = getProjectCalleeHierarchy(project);
    		if (callHierarchy != null) {
    			callerMap = new HashMap<String, Map<String, Set<JsonElement>>>();
    			computeCallerMap(callHierarchy, true, callerMap);
    		}
    	}
    	return callerMap;
    }

    /**
     * Processes a Json element (representing a caller in a source call graph) and its children
     * elements (representing the callees), adds the corresponding calls to the caller map and
     * do this recursively till the entire tree rooted at the Json element is processed.
     * 
     * @param jsonElt - a Json element representing a node in a source call graph
     * @param topLevel - true if this is a top level call
     * @param callerMap - a map from callee signatures to caller signatures to sets of method calls
     */
    static void computeCallerMap(JsonElement jsonElt, boolean topLevel, Map<String, Map<String, Set<JsonElement>>> callerMap) {
    	JsonArray childrenArray = Utils.getChildrenArray(jsonElt);
    	String sig = Utils.getFieldValueAsString(jsonElt, "signature");
    	if (childrenArray != null) {
    		for (int i = 0; i < childrenArray.size(); i++) {
    			JsonElement child = childrenArray.get(i);
    			if (child.isJsonObject() && !Utils.isEmptyJsonObject(child)) {
    				JsonObject childObj = child.getAsJsonObject();
    				String childSig = Utils.getFieldValueAsString(childObj, "signature");
    				if (!topLevel) {
    					Map<String, Set<JsonElement>> callers = callerMap.get(childSig);
    					if (callers == null) {
    						callers = new HashMap<String, Set<JsonElement>>();
    						callerMap.put(childSig, callers);
    					}
    					Set<JsonElement> calls = callers.get(sig);
    					if (calls == null) {
    						calls = new HashSet<JsonElement>();
    						callers.put(sig, calls);
    					}
    					calls.add(jsonElt);
    				}
    				computeCallerMap(childObj, false, callerMap);
    			} 
    		}
    	}
    }

	/**
	 * Searches the key set in the given callerMap (a map from callee signatures to caller 
	 * signatures to sets of method calls) for a source method node that matches to
	 * the given parameter values.
	 * 
	 * @param callerMap - a map from callee signatures to caller signatures to sets of method calls
	 * @param jdtMethod - an IMethod parsed by Eclipse JDT from a Java source file
	 * @param jdtClassName - the name of the enclosing class for the IMethod
	 * @param srcClassName - the class name corresponding to the java source file name
	 * @param srcLine - the line number in the Java source file
	 * @return the source method node
	 */
	public static SourceMethodNode findSourceMethodNodeWithCallers(Map<String, Map<String, Set<JsonElement>>> callerMap, 
			IMethod jdtMethod, String jdtClassName, String srcClassName,
    		int srcLine) {
    	String jdtMethodName = jdtMethod.getElementName();
    	String[] jdtParamTypes = jdtMethod.getParameterTypes();
    	for (String sig: callerMap.keySet()) {
			String sootMethodName = Utils.signatureMethodName(sig);
			if (sootMethodName.equals(jdtMethodName)) {
				String sootClassName = Utils.signatureClass(sig);
				if (classNamesMatch(sootClassName, jdtClassName)) {
					String[] sootParamTypes = Utils.signatureParameterTypes(sig);
					if (typesMatch(sootParamTypes, jdtParamTypes)) {
						SourceMethodNode methodNode = SourceMethodNode.get(sig);
						methodNode.sourceClass = srcClassName;
						methodNode.line = srcLine;
						return methodNode;
					}
				}
			}
    	}
    	return null;
    }

	/**
	 * Returns true if the given soot class name and the given eclipse class name refer to the same
	 * Java class.
	 */
	private static boolean classNamesMatch(String sootClassName, String jdtClassName) {
		if (sootClassName.equals(jdtClassName))
			return true;
		String strippedSootClassName = sootClassName.replaceAll("\\$\\d+", "\\$");
		return strippedSootClassName.equals(jdtClassName);
	}

}
