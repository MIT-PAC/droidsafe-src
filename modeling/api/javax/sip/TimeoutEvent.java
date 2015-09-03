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

public class TimeoutEvent extends TransactionTerminatedEvent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.637 -0500", hash_original_field = "3513BD64D28CAEA25298958AB8E34D09", hash_generated_field = "FE277A87B690B80ED89C5FD5CAD03096")

    private Timeout mTimeout;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.640 -0500", hash_original_method = "B54F2DD7A2EA500C648BF1D67EA727CB", hash_generated_method = "6A3EA3ABDA34B56D56D86E5CEF368768")
    
public TimeoutEvent(Object source, ServerTransaction serverTransaction,
            Timeout timeout) {
        super(source, serverTransaction);
        mTimeout = timeout;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.642 -0500", hash_original_method = "E3A1CE6AED4C8EB398A7A856D4DC19D6", hash_generated_method = "6AEB543175192AE6604EA2C2A2814799")
    
public TimeoutEvent(Object source, ClientTransaction clientTransaction,
            Timeout timeout) {
        super(source, clientTransaction);
        mTimeout = timeout;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.644 -0500", hash_original_method = "83172AE614FED36EC49043A629BB9E54", hash_generated_method = "AFABBC24942C7A9E67D1530EA356DA27")
    
public Timeout getTimeout() {
        return mTimeout;
    }
    
}

