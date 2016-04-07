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

package droidsafe.utils;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Hierarchy;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

/**
 * This class encapsulates a list of soot methods for checking containment.  It
 * packages some useful helper functions to search for containment strictly or with
 * inheritance and polymorphism / virtual calls.
 * 
 * @author mgordon
 *
 */
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
	
	/**
	 * Strict contains
	 */
	public boolean contains(SootMethod method) {
		return methods.contains(method);
	}
	
	/**
	 * Remove method from list.
	 */
	public void removeMethod(SootMethod method) {
		methods.remove(method);
	}
	
	/**
	 * Strict contains
	 */
	public boolean contains(String signature) {
		if (!Scene.v().containsMethod(signature))
			return false;
		return methods.contains(Scene.v().getMethod(signature));
	}
	
	/**
	 * Search for polymorphic containment based on inheritance of
	 * receiver and arguments.
	 */
	public boolean containsPoly(String signature) {
		SootMethod method = 
				SootUtils.resolveMethod(Scene.v().getSootClass(SootUtils.grabClass(signature)), signature);
		return containsPoly(method);
	}
	
	/**
	 * Search for polymorphic containment based on inheritance of
	 * receiver and arguments.
	 */
	public boolean containsPoly(SootMethod method) {
		return getMethod(method) != null;
	}
	
	/** 
	 * Given a signature return the closest method that can be matched in this 
	 * method list given polymorphism.
	 */
	public SootMethod getMethod(String signature) {
		SootMethod method =
				SootUtils.resolveMethod(Scene.v().getSootClass(SootUtils.grabClass(signature)), signature);
		return getMethod(method);
	}
	
	/** 
	 * Given a signature return the closest method that can be matched in this 
	 * method list given polymorphism.
	 */
	public SootMethod getMethod(SootMethod method) {
		//logger.debug("Calling getMethod() with {}", method);
		//return the method if the direct method exists
		if (methods.contains(method)) 
			return method;
		
		//now check polymorphic calls if the method is not directly in the list
		
		SootClass clazz = method.getDeclaringClass();
		
		if (clazz == null) {
			logger.error("Cannot get declaring class for method {}", method);
			droidsafe.main.Main.exit(1);
		}

		List<SootMethod> possibleMethods = SootUtils.findPossibleInheritedMethods(clazz, method.getName(), 
				method.getReturnType().toString(), method.getParameterCount());

		for (SootMethod possible : possibleMethods) {
		    if (!this.contains(possible))
		        continue;
		    
			boolean allTrue = true;
			for (int i = 0; i < method.getParameterCount(); i++) {	
				boolean subType = SootUtils.isSubTypeOfIncluding(method.getParameterType(i), possible.getParameterType(i));
				if (!subType) {
					allTrue = false;
					break;
				}

			}
			if (allTrue) {
				//if we get here, method name, return type, and args all match
				//and it is in this list
				return possible;
			}

		}
		return null;
	}

	/** Given a method, find the method in this sootmethod list that is the closest 
	 * parent of the method.  Give prefence to class inheritance over interfaces 
	 * definitions.
	 */
	public SootMethod getClosestOverriddenMethod(SootMethod child) {
		SootClass clz = child.getDeclaringClass();
		Hierarchy hierarchy = Scene.v().getActiveHierarchy();
    	    	
    	List<SootClass> classes = new LinkedList<SootClass>();
    	
    	classes.addAll(hierarchy.getSuperclassesOf(clz));
    	
    	classes.addAll(SootUtils.getSuperInterfacesOf(clz));
    	    	
    	for (SootClass parent : classes) {
    		for (SootMethod method : parent.getMethods()) {
    			if (this.contains(method) &&
    					method.getSubSignature().equals(child.getSubSignature()))
    				return method;
    		}
    	}
    	
    	return null;
	}
	
	/**
	 * Add all methods from the jar file. Note this does not add them to 
	 * soot's scene
	 */
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
