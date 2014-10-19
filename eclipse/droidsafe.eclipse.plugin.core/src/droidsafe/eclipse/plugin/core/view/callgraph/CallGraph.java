package droidsafe.eclipse.plugin.core.view.callgraph;

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

public class CallGraph implements ICallGraph {
	
    public static Map<IProject, JsonObject> projectCallGraphMap = new HashMap<IProject, JsonObject>();

    private Collection<JsonElement> fRoots;

	private String fDesription;

	private IProject fProject;

    public CallGraph(IProject project, Collection<JsonElement> targets, IMethod method) {
    	fProject = project;
    	fRoots = targets;
    	fDesription = computeDescription(method);
    }

    private String computeDescription(IMethod method) {
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

	public Collection<JsonElement> getRoots() {
    	return fRoots;
    }
    
	public String getDescription() {
		return fDesription;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj != null && obj instanceof CallGraph) {
			CallGraph other = (CallGraph) obj;
			Collection<JsonElement> otherRoots = other.getRoots();
			if (fRoots == null)
				return otherRoots == null;
			if (fRoots.equals(otherRoots))
				return true;
		}
		return false;
	}

    public static JsonElement getProjectCallGraph(IProject project) {
    	if (project != null) {
    		JsonObject callGraph = projectCallGraphMap.get(project);
    		if (callGraph == null) {
    			String fileName = DroidsafePluginUtilities.droidsafeOutputFile(project, SourceCallTree.FILE_NAME);
    			File file = new File(fileName);
    			if (file.exists()) {
    				callGraph = DroidsafePluginUtilities.parseIndicatorFile(file);
    				projectCallGraphMap.put(project, callGraph);
    			}
    		}
    		return callGraph;
    	}
    	return null;
    }

	public static Collection<JsonElement> findCallTargets(JsonElement projectCallGraph, IMethod method, String className, String srcClassName,
    		int srcLine) {
    	if (projectCallGraph == null)
    		return null;
    	String methodName = method.getElementName();
    	String[] paramTypes = method.getParameterTypes();
    	Map<String, JsonElement> targetMap = new HashMap<String, JsonElement>();
    	findCallTargets(projectCallGraph, methodName, paramTypes, className, srcClassName, srcLine, targetMap);
    	return targetMap.values();
    }

	public static void findCallTargets(JsonElement jsonElement, String methodName, String[] paramTypes, String className,
    		String srcClassName, int srcLine, Map<String, JsonElement> targetMap) {
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
        					String methodName0 = Utils.signatureMethodName(sig);
        					if (methodName0.equals(methodName)) {
        						String className0 = Utils.signatureClass(sig);
        						if (className0.equals(className)) {
        							String[] paramTypes0 = Utils.signatureParameterTypes(sig);
        							if (typesMatch(paramTypes0, paramTypes)) {
        								String key = sig + " " + className + " " + srcLine;
        								JsonElement target = targetMap.get(key);
        								if (target == null) {
        									targetMap.put(key, childElement);
        								}
        							}
        						}
        					}
        				}
    				}
    				findCallTargets(childElement, methodName, paramTypes, className, srcClassName, srcLine, targetMap);
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

	@Override
	public IProject getProject() {
		return fProject;
	}

}
