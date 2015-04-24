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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package junit.runner;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class StandardTestSuiteLoader implements TestSuiteLoader {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.406 -0400", hash_original_method = "5793FEEF6F25BC48377D1976D0FE8F1B", hash_generated_method = "5793FEEF6F25BC48377D1976D0FE8F1B")
    public StandardTestSuiteLoader ()
    {
        //Synthesized constructor
    }
	/**
	 * Uses the system class loader to load the test class
	 */
	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.739 -0500", hash_original_method = "F2FF7EF8A0DC7477BB00BBE8F4736B84", hash_generated_method = "440B44A8B71FBB9C3D13EE01FB35EE56")
    
public Class load(String suiteClassName) throws ClassNotFoundException {
		return Class.forName(suiteClassName);
	}
	/**
	 * Uses the system class loader to load the test class
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.741 -0500", hash_original_method = "340959DA3DE1E05DD508233637BBAF32", hash_generated_method = "F686537538DE650CD91EB1BBEB370D7F")
    
public Class reload(Class aClass) throws ClassNotFoundException {
		return aClass;
	}
    
}

