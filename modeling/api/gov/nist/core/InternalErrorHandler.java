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
/*******************************************************************************
* Product of NIST/ITL Advanced Networking Technologies Division (ANTD).        *
*******************************************************************************/

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class InternalErrorHandler {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.407 -0500", hash_original_method = "7A81082C7995C3F4388AC0936F2411E4", hash_generated_method = "5B16CCB15F07EA81FF5DF93B47D20CC8")
    
public static void handleException(Exception ex) throws RuntimeException {
        System.err.println ("Unexpected internal error FIXME!! "  + ex.getMessage());
        ex.printStackTrace();
        throw new RuntimeException("Unexpected internal error FIXME!! "  + ex.getMessage(), ex);

    }
    /**
    * Handle an unexpected exception.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.410 -0500", hash_original_method = "8167B7C0F4F8028B3286DA65D9D2BA29", hash_generated_method = "505288AEE852E44A29BF5EB99C5BB468")
    
public static void handleException(Exception ex, StackLogger stackLogger) {
        System.err.println ("Unexpected internal error FIXME!! "  + ex.getMessage());
        stackLogger.logError("UNEXPECTED INTERNAL ERROR FIXME " +  ex.getMessage());
        ex.printStackTrace();
        stackLogger.logException(ex);
        throw new RuntimeException("Unexpected internal error FIXME!! "  + ex.getMessage(), ex);

    }
    /**
    * Handle an unexpected condition (and print the error code).
    */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.413 -0500", hash_original_method = "4AB3E5449D99DD32AC91751756F3538E", hash_generated_method = "E9497FD0935A8BACBD1519C33DF11025")
    
public static void handleException(String emsg) {
        new Exception().printStackTrace();
        System.err.println("Unexepcted INTERNAL ERROR FIXME!!");
        System.err.println(emsg);
        throw new RuntimeException(emsg);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.415 -0500", hash_original_method = "BB4ED67FC0CEB44F01338AE5E0576421", hash_generated_method = "C92605E4784E7DF7D67C53D8364E869F")
    
public static void handleException(String emsg, StackLogger stackLogger) {
        stackLogger.logStackTrace();
        stackLogger.logError("Unexepcted INTERNAL ERROR FIXME!!");
        stackLogger.logFatalError(emsg);
        throw new RuntimeException(emsg);

    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.407 -0400", hash_original_method = "CDCB3F88E1EC7C264BA47051910F3667", hash_generated_method = "CDCB3F88E1EC7C264BA47051910F3667")
    public InternalErrorHandler ()
    {
        //Synthesized constructor
    }
    
}

