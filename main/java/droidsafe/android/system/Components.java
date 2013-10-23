package droidsafe.android.system;

import java.util.LinkedList;
import java.util.List;

import droidsafe.android.app.Hierarchy;

import soot.SootClass;
import soot.Scene;

public class Components {
	public static String ACTIVITY_CLASS = "android.app.Activity";
	public static String SERVICE_CLASS = "android.app.Service";
	public static String CONTENTPROVIDER_CLASS = "android.content.ContentProvider";
	public static String BROADCASTRECEIVER_CLASS = "android.content.BroadcastReceiver";
	
	/** This array stores objects that are created by the android runtime, and passed into 
	 * event handlers of components 
	 */
	public static String[] RUNTIME_OBJECTS = {"android.os.Bundle"};
	
	public static List<String> CLASS_NAMES; 
	
	static {
		CLASS_NAMES = new LinkedList<String>();
		CLASS_NAMES.add(ACTIVITY_CLASS);
		CLASS_NAMES.add(SERVICE_CLASS);
		CLASS_NAMES.add(CONTENTPROVIDER_CLASS);
		CLASS_NAMES.add(BROADCASTRECEIVER_CLASS);
	}

	/** 
	 * Return a list of soot classes for the components of an android application. 
	 */
	public static List<SootClass> getComponentSootClasses() {
		LinkedList<SootClass> comps = new LinkedList<SootClass>();
		
		for (String c : CLASS_NAMES) {
			comps.add(Scene.v().getSootClass(c));
		}
		
		return comps;
	}
	
	/**
	 * Return true if the name is an application component class from the
	 * android api (direct class, not superclass or subclass).
	 */
	public static boolean isComponentClass(String name) {
		return CLASS_NAMES.contains(name);
	}
}
