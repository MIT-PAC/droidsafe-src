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

import java.io.File;
import java.util.Collection;
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

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.indicator.Utils;
import droidsafe.reports.SourceCallTree;

/**
 * Represents a callee hierarchy for a method call in a Java source file. The roots 
 * of the call hierarchy represent the call targets of the original method call. Each
 * node in the hierarchy is a JsonElement representing a method. 
 * 
 * @author gilham
 *
 */
public class CalleeHierarchy extends CallHierarchy {
	
    /** the root Json elements representing the call targets of the original method call. */
    private Collection<JsonElement> fRoots;

    /**
     * Constructs a callee hierarchy for a method call in a Java Source file.
     * 
     * @param project - the project that contains the Java source file
     * @param callTargets - the root Jaon elements representing the call targets of the method call
     * @param method - the method in the method call
     */
    public CalleeHierarchy(IProject project, Collection<JsonElement> callTargets, IMethod method) {
    	fProject = project;
    	fRoots = callTargets;
    	fDesription = computeDescription(method);
    }

    /**
     * Computes and returns a description string for this callee hierarchy.
     * 
     * @param method - the method in the original method call
     * @return the description string
     */
    String computeDescription(IMethod method) {
    	StringBuffer buf = new StringBuffer();
    	buf.append("Callees of ");
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
	 * Returns the root Json elements representing the call targets of the original method call.
	 */
	public Collection<JsonElement> getRoots() {
    	return fRoots;
    }
    
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj != null && obj instanceof CalleeHierarchy) {
			CalleeHierarchy other = (CalleeHierarchy) obj;
			Collection<JsonElement> otherRoots = other.getRoots();
			if (fRoots == null)
				return otherRoots == null;
			if (fRoots.equals(otherRoots))
				return true;
		}
		return false;
	}

	/**
	 * Searches the project callee hierarchy for a method call that matches the given parameter values.
	 * Returns the call targets for the method call.
	 * 
	 * @param projectCalleeHierarchy - a Json object representing the callee hierarchy from the project's entry points
	 * @param jdtMethod - an IMethod parsed by Eclipse JDT from a Java source file
	 * @param jdtClassName - the name of the enclosing class for the IMethod
	 * @param srcClassName - the class name corresponding to the java source file name
	 * @param srcLine - the line number in the Java source file
	 * @return the method call targets
	 */
	public static Collection<JsonElement> findCallTargets(JsonElement projectCalleeHierarchy, IMethod jdtMethod, String jdtClassName, String srcClassName,
    		int srcLine) {
    	if (projectCalleeHierarchy == null)
    		return null;
    	String jdtMethodName = jdtMethod.getElementName();
    	String[] paramTypes = jdtMethod.getParameterTypes();
    	Map<String, JsonElement> callTargetsMap = new HashMap<String, JsonElement>();
    	findCallTargets(projectCalleeHierarchy, jdtMethodName, paramTypes, jdtClassName, srcClassName, srcLine, callTargetsMap);
    	return callTargetsMap.values();
    }

	/**
	 * Given a Json object representing a sub-tree in the project callee hierarchy, searches the 
	 * tree for method calls that matches the given parameter values.
	 * Updates the callTargetsMap with call targets for each found method call.
	 * 
	 * @param jsonElement - a Json object representing a sub-tree in the project callee hierarchy
	 * @param jdtMethodName - the name of a method parsed by Eclipse JDT from a Java source file
	 * @param jdtParamTypeStrings - the parameter type strings parsed by Eclipse JDT from a Java source file 
	 * @param jdtClassName - the name of the enclosing class for the method
	 * @param srcClassName - the class name corresponding to the java source file name
	 * @param srcLine - the line number in the Java source file
	 * @param callTargetsMap - a map from method call ids to call targets
	 */
	public static void findCallTargets(JsonElement jsonElement, String jdtMethodName, String[] jdtParamTypeStrings,
			String jdtClassName, String srcClassName, int srcLine, Map<String, JsonElement> callTargetsMap) {
    	JsonArray childrenArray = Utils.getChildrenArray(jsonElement);
    	if (childrenArray != null) {
    		for (int i = 0; i < childrenArray.size(); i++) {
    			JsonElement childElement = childrenArray.get(i);
    			if (!Utils.isEmptyJsonObject(childElement)) {
    				String srcClassName0 = Utils.getSourceClass(childElement);
    				int srcLine0 = Utils.getSourceLine(childElement);
    				if (srcClassName0 != null && srcLine0 > 0 && srcClassName0.equals(srcClassName) && 
    						srcLine0 == srcLine) {
    					String sig = Utils.getFieldValueAsString(childElement, "source-signature");
        				if (sig == null)
        					sig = Utils.getFieldValueAsString(childElement, "signature");
        				if (sig != null) {
        					String sootMethodName = Utils.signatureMethodName(sig);
        					if (sootMethodName.equals(jdtMethodName)) {
        						String sootClassName = Utils.signatureClass(sig);
        						if (sootClassName.equals(jdtClassName)) {
        							String[] sootParamTypes = Utils.signatureParameterTypes(sig);
        							if (typesMatch(sootParamTypes, jdtParamTypeStrings)) {
        								String key = sig + " " + jdtClassName + " " + srcLine;
        								JsonElement target = callTargetsMap.get(key);
        								if (target == null) {
        									callTargetsMap.put(key, childElement);
        								}
        							}
        						}
        					}
        				}
    				}
    				findCallTargets(childElement, jdtMethodName, jdtParamTypeStrings, jdtClassName, srcClassName, srcLine, callTargetsMap);
    			}
    		}
    	}
    }

}
