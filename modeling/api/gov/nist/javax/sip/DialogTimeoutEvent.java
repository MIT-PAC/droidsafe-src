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


package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.EventObject;

import javax.sip.Dialog;

public class DialogTimeoutEvent extends EventObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:51.872 -0500", hash_original_field = "4E60203B4DB539F45FE33C01A35E5E05", hash_generated_field = "4FAFB1344CC4F2D19A9E7C7572E679D4")

	private static final long serialVersionUID = -2514000059989311925L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:51.898 -0500", hash_original_field = "23DD3B55DF22010FE0353DE8753C52E7", hash_generated_field = "1B483DA67C4F6DE71E44B6CDA63B2927")

    private Dialog m_dialog = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:51.904 -0500", hash_original_field = "637AA7265FF42E70ACDDCD41CDDEB3E3", hash_generated_field = "6C57BA42DC64512F5471CFD9846CD8F5")
    
    private Reason m_reason = null;	    
	/**
     * Constructs a DialogTerminatedEvent to indicate a dialog
     * timeout.
     *
     * @param source - the source of TimeoutEvent. 
     * @param dialog - the dialog that timed out.
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:51.882 -0500", hash_original_method = "3B858FD9FEE5DA9FA545213DB80889DF", hash_generated_method = "658B99F54705E16774AE803B8F2B680D")
    
public DialogTimeoutEvent(Object source, Dialog dialog, Reason reason) {
         super(source);
         m_dialog = dialog;
         m_reason = reason;
      
    }

    /**
     * Gets the Dialog associated with the event. This 
     * enables application developers to access the dialog associated to this 
     * event. 
     * 
     * @return the dialog associated with the response event or null if there is no dialog.
     * @since v1.2
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:51.887 -0500", hash_original_method = "7F25FD43FBEFC286B46F28F64DA890F2", hash_generated_method = "461D59BAFB28542F8DB52DC490C14AF5")
    
public Dialog getDialog() {
        return m_dialog;
    }
    
    public enum Reason {AckNotReceived, AckNotSent,ReInviteTimeout}
    
    /**
     * The reason for the Dialog Timeout Event being delivered to the application.
     * 
     * @return the reason for the timeout event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:51.892 -0500", hash_original_method = "212BB72EC2D919554993B4E6C5F238C1", hash_generated_method = "BF8796C34D2ED383CBD14F352BBF8F5B")
    
public Reason getReason() {
    	return m_reason;
    }
}

