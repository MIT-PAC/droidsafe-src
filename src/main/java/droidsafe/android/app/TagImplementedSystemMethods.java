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
