package droidsafe.android.app;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import droidsafe.android.system.API;
import droidsafe.android.system.AndroidComponents;
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
    /**
	 * Given a application class (either from src/ or lib/) return a set of all methods
	 * defined in the class, plus all methods defined in application superclasses.
	 * 
	 * This set will not include methods that are overriden by child classes
	 */
	public static Set<SootMethod> getAllInheritedAppMethodsIncluded(SootClass sc) {
	    LinkedHashSet<SootMethod> methods = new LinkedHashSet<SootMethod>();
	    Set<String> subSigs = new LinkedHashSet<String>();
	    
	    //this should stop at the first system class encountered (java.lang.object worst case)
	    while (sc != null && !API.v().isSystemClass(sc)) {
	        for (SootMethod m : sc.getMethods()) {
	            if (!m.isStatic() && subSigs.contains(m.getSubSignature())) 
	                continue;
	            
	            methods.add(m);
	            subSigs.add(m.getSubSignature());
	        }
	        
	        sc = sc.getSuperclass();
	    }
	    
	    return methods;
	}
	
	public static boolean inheritsFromAndroidComponent(AndroidComponents component, SootClass cn) {
	    if (cn.isInterface())
            return false;
        
        return Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(cn, 
            Components.getSootClassForComponent(component));
	}
		
	/** 
     * Returns true if cn is class android/app/Service or is a class
     * that inherits from android/app/Service
     */
    public static boolean inheritsFromAndroidService(final SootClass cn) {
        if (cn.isInterface())
            return false;
        
        return Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(cn, 
            Scene.v().getSootClass(Components.SERVICE_CLASS));
    }
	
	/** 
	 * Returns true if cn is class android/app/Activity or is a class
	 * that inherits from android/app/Activity
	 */
	public static boolean inheritsFromAndroidActivity(final SootClass cn) {
	    if (cn.isInterface())
            return false;
	    
		return Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(cn, 
		    Scene.v().getSootClass(Components.ACTIVITY_CLASS));
	}
	
	/** 
     * Returns true if cn is class android/content/BroadcastReceiver or is a class
     * that inherits from android/content/BroadcastReceiver
     */
    public static boolean inheritsFromAndroidBroadcastReceiver(final SootClass cn) {
        if (cn.isInterface())
            return false;
        
        return Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(cn, 
            Scene.v().getSootClass(Components.BROADCASTRECEIVER_CLASS));
    }
    
	
	/**
	 * Return true if this class inherits from an android component class.
	 */
	public static boolean isAndroidComponentClass(SootClass clz) {
	    if (clz.isInterface())
	        return false;
	    
		List<SootClass> supers = Scene.v().getActiveHierarchy().getSuperclassesOf(clz);
		
		for (SootClass sup : supers) {
			if (Components.CLASS_NAMES.contains(sup.getName()))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Return the closest parent of clz that is an android component
	 */
	public static SootClass getComponentParent(SootClass clz) {
	    if (clz.isInterface())
            return null;
	    
		List<SootClass> supers = Scene.v().getActiveHierarchy().getSuperclassesOf(clz);
		
		for (SootClass sup : supers) {
			if (Components.CLASS_NAMES.contains(sup.getName()))
				return sup;
		}
		
		return null;
	}
	
	/**
	 * Return the system method that is the closest in the inheritance chain 
	 * that this method overrides.  Null if this method does not override a system method.
	 */
	public static SootMethod closestOverridenSystemMethodNoInterfaces(SootMethod method) {
	    List<SootMethod> oMethods = SootUtils.getOverriddenMethodsFromSuperclasses(method);
	      	    
	    for (SootMethod parent : oMethods) {
	        if (API.v().isSystemMethod(parent))
	            return parent;
	    }
	    
	    return null;
	}
	
	/**
	 * Return set of all interface and classes implemented or inherited by 
	 * this class.
	 */
	public static Set<SootClass> systemParents(SootClass clz) {
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
	 * defined in the android.jar.  Note, this will return true if the class
	 * inherits from java.lang.Object.
	 */
	public static boolean inheritsFromAndroid(SootClass clz) {
		return systemParents(clz).size() > 0;
	}
	
	/**
	 * Return a list of all classes from the app (not libs) that inherit from
	 * an android api application component.
	 */
	public static List<SootClass> getAllAppComponents() {
		
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
	public static boolean isImplementedSystemMethod(SootMethod method) {
		return method.getTag(TagImplementedSystemMethods.SYSTEM_OVERRIDE_TAG) != null;
	}
}
