package droidsafe.android.app;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.system.API;
import droidsafe.utils.SootUtils;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.tagkit.GenericAttribute;
import soot.tagkit.Tag;

public class TagImplementedSystemMethods {
	private final static Logger logger = LoggerFactory.getLogger(TagImplementedSystemMethods.class);
	
	public static final String SYSTEM_OVERRIDE_TAG = "droidsafe.system.override";
	
	public static void run() {
		
    	for (SootClass clazz : Scene.v().getApplicationClasses()) {
    		
    		Set<SootClass> systemParents = Hierarchy.systemParents(clazz);
    		
    		//do nothing if no system parents
    		if (systemParents.isEmpty())
    			continue;
    		
    		//now check which methods are overrides
    		for (SootMethod method : clazz.getMethods()) {
    				
    			if (!clazz.declaresMethod(method.getSubSignature()))
    				continue;
    			
    			if (isInheritedFrom(method, systemParents)) {
    				String attr = "true";
    				Tag tag = new GenericAttribute(SYSTEM_OVERRIDE_TAG, attr.getBytes());
    				method.addTag(tag);
    				logger.debug("Found implemented system method: {}", method.toString());
    			}
    		}
    	}
    }
	
    private static boolean isInheritedFrom(SootMethod method, Set<SootClass> systemParents) {
    	for (SootClass clz : systemParents) {
    		if (clz.declaresMethod(method.getSubSignature()))
    			return true;
    	}
    	    	
    	return false;
    }
}
