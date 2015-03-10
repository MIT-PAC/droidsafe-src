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

public class PeerUnavailableException extends SipException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.822 -0500", hash_original_method = "4D3350AD44AB8F981C91A400EAA4427E", hash_generated_method = "1054D7F641E48E384D5F51487B728315")
    
public PeerUnavailableException() {
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.825 -0500", hash_original_method = "66401C22E3DAC6E7A91EB96EDEE6E4D8", hash_generated_method = "66897796ABB7467826282CCE68B49545")
    
public PeerUnavailableException(String message) {
        super(message);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.828 -0500", hash_original_method = "41F06EC1DF16A2C31AA3137EDABFA9B1", hash_generated_method = "CF53BD8F4C9FCEE9C250B14A6CDFB0ED")
    
public PeerUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
    
}

