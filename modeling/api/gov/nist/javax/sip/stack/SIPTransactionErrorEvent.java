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
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
* Conditions Of Use
*
* This software was developed by employees of the National Institute of
* Standards and Technology (NIST), an agency of the Federal Government.
* Pursuant to title 15 Untied States Code Section 105, works of NIST
* employees are not subject to copyright protection in the United States
* and are considered to be in the public domain.  As a result, a formal
* license is not needed to use the software.
*
* This software is provided by NIST as a service and is expressly
* provided "AS IS."  NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
* OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
* AND DATA ACCURACY.  NIST does not warrant or make any representations
* regarding the use of the software or the results thereof, including but
* not limited to the correctness, accuracy, reliability or usefulness of
* the software.
*
* Permission to use this software is contingent upon your acceptance
* of the terms of this agreement
*
* .
*
*/

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.EventObject;

public class SIPTransactionErrorEvent extends EventObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.491 -0500", hash_original_field = "FD1319701F9D8B3BF382F89AD1C3FFBE", hash_generated_field = "B2919CC93A0DDB9603DD498A1339A398")

    private static final long serialVersionUID = -2713188471978065031L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.495 -0500", hash_original_field = "3B246B0FE69C1F9FF7A41D322CD83D0D", hash_generated_field = "2268C740E02F829208E590448FE29A7C")

    public static final int TIMEOUT_ERROR = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.498 -0500", hash_original_field = "B4E0B56673B5399AA84687A35593A1A5", hash_generated_field = "4EC86D2082266147845EB0873FB756F7")

    public static final int TRANSPORT_ERROR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.500 -0500", hash_original_field = "61523AD84289E6AB4C5E64C9CC913BF6", hash_generated_field = "50927BA19A1A6CDE61F8F90E1139E7C4")

    public static final int TIMEOUT_RETRANSMIT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.503 -0500", hash_original_field = "81675DDDE65D7DC6276492A670BE8C2A", hash_generated_field = "CA6E243727AC764060BF1536B58E325A")

    private int errorID;

    /**
     * Creates a transaction error event.
     *
     * @param sourceTransaction Transaction which is raising the error.
     * @param transactionErrorID ID of the error that has ocurred.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.506 -0500", hash_original_method = "09AF95BC0271C57553075E85B6A27865", hash_generated_method = "09AF95BC0271C57553075E85B6A27865")
    
SIPTransactionErrorEvent(
        SIPTransaction sourceTransaction,
        int transactionErrorID) {

        super(sourceTransaction);
        errorID = transactionErrorID;

    }

    /**
     * Returns the ID of the error.
     *
     * @return Error ID.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.509 -0500", hash_original_method = "0519EBFB6DA70B425C38921D23DA7A64", hash_generated_method = "0BB790A9247F5D0375A01CAD9294AADA")
    
public int getErrorID() {
        return errorID;
    }
}

