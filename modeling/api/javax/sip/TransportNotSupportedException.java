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

public class TransportNotSupportedException extends SipException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.761 -0500", hash_original_method = "A9536702FA2FD929BCAA03BE02DE378D", hash_generated_method = "7B224F618513903ECD4F1ED7AABB6A7F")
    
public TransportNotSupportedException() {
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.763 -0500", hash_original_method = "72633799E19427EF47046C691F2C9C95", hash_generated_method = "98599B80F6FD7A0E3B18DEC1EC7E3B69")
    
public TransportNotSupportedException(String message) {
        super(message);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.766 -0500", hash_original_method = "F97CF6294699591851DD663A9DDDF701", hash_generated_method = "3A72B74E55FBD7F7DE87DD58948EA4D4")
    
public TransportNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }
    
}

