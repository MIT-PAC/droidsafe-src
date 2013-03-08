package droidsafe.android.app;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import droidsafe.android.system.API;
import droidsafe.android.system.Components;
import droidsafe.utils.SootUtils;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;


/**
 * Class to house all helpers and queries on the class hierarchy of the application.
 * Built on top of soot.hierarchy. 
 * 
 * @author mgordon
 *
 */
public class Hierarchy {
	
	private static Hierarchy v;
	private List<SootClass> appComponents;
	private Set<SootClass> activities;
	
	/**
	 * Return the singleton hierarchy object for this application.
	 */
	public static Hierarchy v() {
		if (v == null) {
			v = new Hierarchy();
		}
		
		return v;
	}
	
	protected Hierarchy() {	
		activities = new LinkedHashSet<SootClass>();
		
		//loop over all code and find calls for with any tracked as received or arg
		for (SootClass clazz : Scene.v().getApplicationClasses()) {
			if (clazz.isInterface() || clazz.getName().equals(Harness.HARNESS_CLASS_NAME))
				continue;

			//don't add entry points into the system classes...
			if (API.v().isSystemClass(clazz))
				continue;
			
			if (inheritsFromAndroidActivity(clazz))
				activities.add(clazz);
		}
	}
		

	// Returns true if cn is class android/app/Activity or is a class
	// that inherits from android/app/Activity
	public boolean inheritsFromAndroidActivity(final SootClass cn) {
		return Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(cn, Scene.v().getSootClass(Components.ACTIVITY_CLASS));
	}
	
	/**
	 * Return true if this class inherits from an android component class.
	 */
	public boolean isAndroidComponentClass(SootClass clz) {
		List<SootClass> supers = Scene.v().getActiveHierarchy().getSuperclassesOf(clz);
		
		for (SootClass sup : supers) {
			if (Components.CLASS_NAMES.contains(sup.getName()))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Return set of all interface and classes implemented or inherited by 
	 * this class.
	 */
	public Set<SootClass> systemParents(SootClass clz) {
		Set<SootClass> supers = SootUtils.getParents(clz);
		LinkedHashSet<SootClass> systemSupers = new LinkedHashSet<SootClass>();
		
		for (SootClass sup : supers) {
			if (API.v().isSystemClass(sup))
				systemSupers.add(sup);
		}
		
		return systemSupers;
	}
	
	/**
	 * Returns true if this class extends or implements from a class / interface
	 * defined in the android.jar.
	 */
	public boolean inheritsFromAndroid(SootClass clz) {
		return systemParents(clz).size() > 0;
	}
	
	/**
	 * Return a list of all classes from the app (not libs) that inherit from
	 * an android api application component.
	 */
	public List<SootClass> getAllAppComponents() {
		//cache calculation
		if (appComponents != null)
			return appComponents;
		
		List<SootClass> comps = new LinkedList<SootClass>();
		
		for (String cn : Project.v().getSrcClasses()) {
			SootClass clz = soot.Scene.v().getSootClass(cn);
			if (clz.isInterface())
				continue;
			
			if (isAndroidComponentClass(clz)) 
				comps.add(clz);
		}
		
		return comps;
	}

	/** 
	 * Examime the droidsafe.system.override tag on the method to see
	 * if it overrides or implements a system method.
	 */
	public boolean isImplementedSystemMethod(SootMethod method) {
		return method.getTag(TagImplementedSystemMethods.SYSTEM_OVERRIDE_TAG) != null;
	}
	
	/**
	 * Given a soot method ref (a reference to a method that may not exist in the class
	 * but should be in a superclass), can the method ref be resolved to the tgtMeth.	
	 */
	public boolean canResolveTo(SootMethodRef mr, SootMethod tgtMeth) {
		SootMethod called = mr.resolve();
		Set<SootClass> tgtParents = SootUtils.getParents(tgtMeth.getDeclaringClass());
		
		//if the class of the method ref is not the class of the concrete method class
		//if if the class of the method ref is not a subclass of the concrete method class
		//it can never resolve to
		if (!tgtMeth.getDeclaringClass().equals(called.getDeclaringClass()) &&
				!tgtParents.contains(called.getDeclaringClass()))
			return false;
		
		SootMethod possibleMethod = Scene.v().getActiveHierarchy().resolveConcreteDispatch(tgtMeth.getDeclaringClass(), called);
		return possibleMethod == tgtMeth;
	}
}
