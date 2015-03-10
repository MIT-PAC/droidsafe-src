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

public class DialogDoesNotExistException extends SipException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.918 -0500", hash_original_method = "9202A0FE59991A3B0A837B4E7082EB36", hash_generated_method = "4300171E25B35A316F2C7ECECA3F8A77")
    
public DialogDoesNotExistException(){
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.921 -0500", hash_original_method = "92D6A3CD46517681F25A7E8C2DA97A21", hash_generated_method = "9FA7D789FE450212B93BE0ABBD3325EA")
    
public DialogDoesNotExistException(String message) {
        super(message);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.923 -0500", hash_original_method = "3EDA84A1781F815A2C18879AE2F847E8", hash_generated_method = "F500D10C082C49BED33B22CBBF8F29CE")
    
public DialogDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
    
}

