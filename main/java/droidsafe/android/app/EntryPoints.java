package droidsafe.android.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.resources.Resources;
import droidsafe.android.system.API;
import droidsafe.utils.SootUtils;

import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

import droidsafe.android.app.resources.AndroidManifest.Activity;

/**
 * Calculate the entry points of the android application we are analyzing.
 * Must be called after soot has been configured.
 * 
 * This finds all entry points in only in components, and does not
 * take into account if the entry point is modeled or not.  That is for other
 * classes to decide.
 * 
 * @author mgordon
 *
 */
public class EntryPoints {
	private final static Logger logger = LoggerFactory.getLogger(EntryPoints.class);
	
	private Set<SootMethod> appEntryPoints;
	
	private boolean calculated = false; 
	
	private static EntryPoints V;
	
	private EntryPoints() {
		appEntryPoints = new LinkedHashSet<SootMethod>();
	}
	
	/**
	 * Return all entry points in component classes without respect to if they are modeled.
	 */
	public Set<SootMethod> getAppEntryPoints() {
		return appEntryPoints;
	}
	
	
	public boolean isEntryPoint(SootMethod m) {
		return appEntryPoints.contains(m);
	}

	/**
	 * Return the singleton entry point object for the app
	 */
	public static EntryPoints v() {
		if (V == null) {
			V = new EntryPoints();
		}
		
		return V;
	}
	
	public boolean isCalculated() {
		return calculated;
	}
	
	 /**
     * Find all entry points into the application code.
     * 
     * Entry points are defined as methods that override API methods (methods defined in the 
     * android api). 
     *    
     */
    public void calculate() {
    	calculated = true;
    	this.appEntryPoints = new LinkedHashSet<SootMethod>();
    	for (SootClass clazz : Scene.v().getApplicationClasses()) {
    		if (clazz.isInterface() || clazz.getName().equals(Harness.HARNESS_CLASS_NAME))
    			continue;
    		
    		//don't add entry points into the system classes...
    		if (API.v().isSystemClass(clazz))
    			continue;
    		
    		//only add entry points for android component classes
    		//other entry points will be handled by searching for allocations 
    		//of classes that inherit from an api class / interface.
    		if (!Hierarchy.v().isAndroidComponentClass(clazz))
    			continue;
    		/*
    		if (!Resources.v().getManifest().getComponents().contains(clazz)) {
    			logger.info("Class for component found, but it is not in manifest, so ignoring: {}", clazz.toString());
    			continue;
    		}*/
    		
    		//Messages.log("Checking class for missing modeling: " + clazz.getName());
    			    	
    		//now check which methods are overrides
    		for (SootMethod method : clazz.getMethods()) {
    			//Messages.log("    Checking for method: " + method.getSignature());
    			if (!clazz.declaresMethod(method.getSubSignature()))
    				continue;
 
    			
    			if (Hierarchy.v().isImplementedSystemMethod(method)) {
    				appEntryPoints.add(method);
    				logger.info("Found entry point as implemented system method: {}", method.toString());
    			} 
    		}
    	}
    	
    	for (SootMethod method : Resources.v().getAllHandlers()) {
    		appEntryPoints.add(method);
    		logger.info("Found entry point as xml onclick: {}", method.toString());
    	}
    	
    	appEntryPoints = Collections.unmodifiableSet(appEntryPoints);
    }
    
}
