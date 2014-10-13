package droidsafe.eclipse.plugin.core.view.callgraph;

import java.io.File;
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

public class CallGraph {
	
    public static Map<IProject, JsonObject> callGraphMap = new HashMap<IProject, JsonObject>();

	static Map<JsonElement, Set<JsonElement>> callerMap = new HashMap<JsonElement, Set<JsonElement>>();
    
    private Set<JsonElement> fRoots;
    private boolean fCalleeBased;
    
    public CallGraph(Set<JsonElement> roots, boolean calleeBased) {
    	fRoots = roots;
    	fCalleeBased = calleeBased;
    }

    public Set<JsonElement> getRoots() {
    	return fRoots;
    }
    
    public boolean isCalleeBased() {
    	return fCalleeBased;
    }
    
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	if (obj != null && obj instanceof CallGraph) {
    		CallGraph other = (CallGraph) obj;
    		if (fCalleeBased == other.isCalleeBased()) {
    			Set<JsonElement> otherRoots = other.getRoots();
    			if (fRoots == null)
    				return otherRoots == null;
    			if (fRoots.equals(otherRoots))
    				return true;
    		}
    	}
    	return false;
    }

    public static JsonElement getProjectCallGraph() {
    	IProject project = DroidsafePluginUtilities.getSelectedProject();
    	if (project != null) {
    		JsonObject callGraph = callGraphMap.get(project);
    		if (callGraph == null) {
    			String fileName = DroidsafePluginUtilities.droidsafeOutputFile(project, SourceCallTree.FILE_NAME);
    			File file = new File(fileName);
    			if (file.exists()) {
    				callGraph = DroidsafePluginUtilities.parseIndicatorFile(file);
    				computeCallerMap(callGraph, true);
    				callGraphMap.put(project, callGraph);
    			}
    		}
    		return callGraph;
    	}
    	return null;
    }

    private static void computeCallerMap(JsonObject jsonObj, boolean topLevel) {
    	JsonArray childrenArray = Utils.getChildrenArray(jsonObj);
    	if (childrenArray != null) {
    		for (int i = 0; i < childrenArray.size(); i++) {
    			JsonElement child = childrenArray.get(i);
    			if (child.isJsonObject() && !Utils.isEmptyJsonObject(child)) {
    				JsonObject childObj = child.getAsJsonObject();
    				if (!topLevel) {
    					Set<JsonElement> callers = callerMap.get(childObj);
    					if (callers == null) {
    						callers = new HashSet<JsonElement>();
    						callerMap.put(childObj, callers);
    					}
    					callers.add(jsonObj);
    				}
    				computeCallerMap(childObj, false);
    			} 
    		}
    	}
    }

	public static Set<JsonElement> findMethodNodes(IMethod method, String className, String srcClassName,
    		int srcLine, boolean calleeBased) {
    	String methodName = method.getElementName();
    	String[] paramTypes = method.getParameterTypes();
    	JsonElement callGraph = getProjectCallGraph();
    	if (callGraph == null)
    		return null;
    	Set<JsonElement> result = new HashSet<JsonElement>();
    	findMethodNodes(callGraph, methodName, paramTypes, className, srcClassName, srcLine, result, calleeBased);
    	return result;
    }

    public static void findMethodNodes(JsonElement jsonElement, String methodName, String[] paramTypes, String className,
    		String srcClassName, int srcLine, Set<JsonElement> result, boolean calleeBased) {
    	JsonArray childrenArray = Utils.getChildrenArray(jsonElement);
    	if (childrenArray != null) {
    		for (int i = 0; i < childrenArray.size(); i++) {
    			JsonElement childElement = childrenArray.get(i);
    			if (!Utils.isEmptyJsonObject(childElement)) {
    				String srcClassName0 = Utils.getSourceClass(childElement);
    				int srcLine0 = Utils.getSourceLine(childElement);
    				if (srcClassName0 != null && srcLine0 > 0 && srcClassName0.equals(srcClassName) && 
    						(!calleeBased || srcLine0 == srcLine)) {
        				String sig = Utils.getFieldValueAsString(childElement, "signature");
        				if (sig != null) {
        					String methodName0 = Utils.signatureMethodName(sig);
        					if (methodName0.equals(methodName)) {
        						String className0 = Utils.signatureClass(sig);
        						if (className0.equals(className)) {
        							String[] paramTypes0 = Utils.signatureParameterTypes(sig);
        							if (typesMatch(paramTypes0, paramTypes))
        								result.add(childElement);
        						}
        					}
        				}
    				}
    				findMethodNodes(childElement, methodName, paramTypes, className, srcClassName, srcLine, result, calleeBased);
    			}
    		}
    	}
    }

	private static boolean typesMatch(String[] sootParamTypes, String[] paramTypes2) {
		if (sootParamTypes.length != paramTypes2.length) {
			return false;
		}
		for (int i = 0; i < sootParamTypes.length; i++) {
			if (!typeMatch(sootParamTypes[i], paramTypes2[i]))
				return false;
		}
		return true;
	}

	private static boolean typeMatch(String sootType, String eclipseType) {
		String type = Signature.toString(eclipseType);
		if (sootType.equals(type))
			return true;
		if (eclipseType.startsWith("Q") && droidsafe.utils.Utils.extractClassname(sootType).equals(type))
			return true;
		return false;
	}

}
