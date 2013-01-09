package droidsafe.utils;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.speclang.ArgumentValue;
import droidsafe.speclang.Method;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;

public class SootMethodList implements Iterable<SootMethod>{
	private final static Logger logger = LoggerFactory.getLogger(SootMethodList.class);
	
	private LinkedHashSet<SootMethod> methods;
	
	public SootMethodList() {
		methods = new LinkedHashSet<SootMethod>();
	}

	public void addMethod(String signature) {
		addMethod(Scene.v().getMethod(signature));
	}
	
	public void addMethod(SootMethod method) {
		methods.add(method);
	}
	
	public boolean contains(SootMethod method) {
		return methods.contains(method);
	}
	
	public boolean contains(String signature) {
		if (!Scene.v().containsMethod(signature))
			return false;
		return methods.contains(Scene.v().getMethod(signature));
	}
	
	public boolean containsPoly(String signature) {
		SootMethod method = SootUtils.resolveMethod(signature);
		return containsPoly(method);
	}
	
	public boolean containsPoly(SootMethod method) {
		return getMethod(method) != null;
	}
	
	public SootMethod getMethod(String signature) {
		SootMethod method = SootUtils.resolveMethod(signature);
		return getMethod(method);
	}
	
	public SootMethod getMethod(SootMethod method) {
		//return the method if the direct method exists
		if (methods.contains(method)) 
			return method;
		
		//now check polymorphic calls if the method is not directly in the list
		
		SootClass clazz = method.getDeclaringClass();
		
		if (clazz == null) {
			Utils.ERROR_AND_EXIT(logger,"Cannot get declaring class for method {}", method);
		}

		List<SootMethod> possibleMethods = SootUtils.findPossibleInheritedMethods(clazz, method.getName(), 
				method.getReturnType().toString(), method.getParameterCount());

		for (SootMethod possible : possibleMethods) {
			boolean allTrue = true;
			for (int i = 0; i < method.getParameterCount(); i++) {	
				boolean subType = SootUtils.isSubTypeOf(method.getParameterType(i), possible.getParameterType(i));
				if (!subType) {
					allTrue = false;
					break;
				}

			}
			if (allTrue && this.contains(possible)) {
				//if we get here, method name, return type, and args all match
				//and it is in this list
				return possible;
			}

		}
		return null;
	}

	public void addAllMethods(JarFile jarFile) {
		List<String> classes = Utils.getClassesFromJar(jarFile);
		
		for (String clz : classes) {
			for (SootMethod meth : Scene.v().getSootClass(clz).getMethods()) {
				this.addMethod(meth);
			}
		}
	}
	
	public Iterator<SootMethod> iterator() {
		return methods.iterator();
	}
}
