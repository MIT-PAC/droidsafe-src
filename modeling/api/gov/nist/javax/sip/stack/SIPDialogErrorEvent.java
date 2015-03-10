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


package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.EventObject;

public class SIPDialogErrorEvent extends EventObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.670 -0500", hash_original_field = "5D413763718A72D7F502FD51B23437D7", hash_generated_field = "1114A70B449A938175EAD82492CF8BE8")

    public static final int DIALOG_ACK_NOT_RECEIVED_TIMEOUT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.673 -0500", hash_original_field = "EBD4A7848673AC467B661EDC226D128E", hash_generated_field = "A8906351F5DF1D3C4CD5261710E4A09F")

    public static final int DIALOG_ACK_NOT_SENT_TIMEOUT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.677 -0500", hash_original_field = "998A6AD13ABA787A247FD5A630799AB8", hash_generated_field = "7B2972FA2C4C6425C27AD10065E88AB6")

    public static final int DIALOG_REINVITE_TIMEOUT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.679 -0500", hash_original_field = "81675DDDE65D7DC6276492A670BE8C2A", hash_generated_field = "CA6E243727AC764060BF1536B58E325A")

    private int errorID;

    /**
     * Creates a dialog error event.
     *
     * @param sourceDialog Dialog which is raising the error.
     * @param dialogErrorID ID of the error that has ocurred.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.683 -0500", hash_original_method = "63B6C69AA01911B678EB33AE8A4167CE", hash_generated_method = "63B6C69AA01911B678EB33AE8A4167CE")
    
SIPDialogErrorEvent(
        SIPDialog sourceDialog,
        int dialogErrorID) {

        super(sourceDialog);
        errorID = dialogErrorID;

    }

    /**
     * Returns the ID of the error.
     *
     * @return Error ID.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.685 -0500", hash_original_method = "0519EBFB6DA70B425C38921D23DA7A64", hash_generated_method = "0BB790A9247F5D0375A01CAD9294AADA")
    
public int getErrorID() {
        return errorID;
    }
}

