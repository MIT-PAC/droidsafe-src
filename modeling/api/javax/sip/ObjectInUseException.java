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


package javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ObjectInUseException extends SipException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.096 -0500", hash_original_method = "1506D26AE793C20A85DE50298F844249", hash_generated_method = "420F0878B0CCCF67289A1046CEC3D8A3")
    
public ObjectInUseException() {
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.099 -0500", hash_original_method = "DD9CAB8B2E3E5148E8AE5B5B0A2DE7DC", hash_generated_method = "0F5AC5D101D129D6FE280C813ECB90BE")
    
public ObjectInUseException(String message) {
        super(message);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.102 -0500", hash_original_method = "A64ABB3B61ED7345FBF78ED9BA9ABC4F", hash_generated_method = "9EE2717E4C7E0CD94137B5C4ECB02B22")
    
public ObjectInUseException(String message, Throwable cause) {
        super(message, cause);
    }
    
}

