package droidsafe.eclipse.plugin.core.view.callgraph;

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

public class CallerGraph implements ICallGraph {
	
	static Map<IProject, Map<String, Map<String, Set<JsonElement>>>> projectCallerMap = new HashMap<IProject, Map<String, Map<String, Set<JsonElement>>>>();
    
    private SourceMethodNode fRoot;

	private String fDesription;
	
	private IProject fProject;

    public CallerGraph(IProject project, SourceMethodNode root, IMethod method) {
    	fProject = project;
    	fRoot = root;
    	fDesription = computeDescription(method);
    }
    
    private String computeDescription(IMethod method) {
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

	public SourceMethodNode getRoot() {
    	return fRoot;
    }
    
	public String getDescription() {
		return fDesription;
	}

    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	if (obj != null && obj instanceof CallerGraph) {
    		CallerGraph other = (CallerGraph) obj;
    		SourceMethodNode otherRoot = other.getRoot();
    		if (fRoot == null)
    			return otherRoot == null;
    		if (fRoot.equals(otherRoot))
    			return true;
    	}
    	return false;
    }
    
    public static Map<String, Map<String, Set<JsonElement>>> getCallerMap(IProject project) {
    	Map<String, Map<String, Set<JsonElement>>> callerMap = projectCallerMap.get(project);
    	if (callerMap == null) {
    		JsonElement callGraph = CallGraph.getProjectCallGraph(project);
    		if (callGraph != null) {
    			callerMap = new HashMap<String, Map<String, Set<JsonElement>>>();
    			computeCallerMap(callGraph, true, callerMap);
    		}
    	}
    	return callerMap;
    }

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

	public static SourceMethodNode findSourceMethodNodeWithCallers(Map<String, Map<String, Set<JsonElement>>> callerMap, IMethod method, String className, String srcClassName,
    		int srcLine) {
    	String methodName = method.getElementName();
    	String[] paramTypes = method.getParameterTypes();
    	for (String sig: callerMap.keySet()) {
			String methodName0 = Utils.signatureMethodName(sig);
			if (methodName0.equals(methodName)) {
				String className0 = Utils.signatureClass(sig);
				if (classNamesMatch(className0, className)) {
					String[] paramTypes0 = Utils.signatureParameterTypes(sig);
					if (typesMatch(paramTypes0, paramTypes)) {
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

	private static boolean classNamesMatch(String sootClassName, String eclipseClassName) {
		if (sootClassName.equals(eclipseClassName))
			return true;
		String strippedSootClassName = sootClassName.replaceAll("\\$\\d+", "\\$");
		return strippedSootClassName.equals(eclipseClassName);
	}

	private static boolean typesMatch(String[] sootParamTypes, String[] eclipseParamTypes) {
		if (sootParamTypes.length != eclipseParamTypes.length) {
			return false;
		}
		for (int i = 0; i < sootParamTypes.length; i++) {
			if (!typeMatch(sootParamTypes[i], eclipseParamTypes[i]))
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

	public Map<String, Map<String, Set<JsonElement>>> getCallerMap() {
		return getCallerMap(fProject);
	}

}
