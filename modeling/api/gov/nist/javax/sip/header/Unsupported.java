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


package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

public class Unsupported extends SIPHeader implements javax.sip.header.UnsupportedHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.549 -0500", hash_original_field = "63FC33D91B036DDB5D1EE03493BC37C8", hash_generated_field = "E6F62805C9FB301CFBA40BB42552946D")

    private static final long serialVersionUID = -2479414149440236199L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.552 -0500", hash_original_field = "C47D1E13159584343BDF40043CEB3AB4", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;

    /** Default Constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.555 -0500", hash_original_method = "7F4BD1C3AF5762ECCF124F3A56ADDC67", hash_generated_method = "C7539E168CCF8644EA352FC2FA7CBB57")
    
public Unsupported() {
        super(NAME);
    }

    /** Constructor
     * @param ot String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.558 -0500", hash_original_method = "91BBA837F044D0A0A4874364E40F6125", hash_generated_method = "11CA3027313799B12E4ADD3BD57AD068")
    
public Unsupported(String ot) {
        super(NAME);
        optionTag = ot;
    }

    /**
     * Return a canonical value.
     * @return String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.561 -0500", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "3E11F84AAB428D962C364CC48C7D950E")
    
public String encodeBody() {
        return optionTag;
    }

    /** get the option tag field
     * @return option Tag field
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.564 -0500", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "3633D701492785C9119138C7D9BDC157")
    
public String getOptionTag() {
        return optionTag;
    }

    /**
     * Set the option member
     * @param o String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.567 -0500", hash_original_method = "3B18B091D01592A1C9601DEA63572A7E", hash_generated_method = "824D28BA3B3DCAF8F04AFCDD32A81971")
    
public void setOptionTag(String o) throws ParseException {
        if (o == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Unsupported, setOptionTag(), The option tag parameter is null");
        optionTag = o;
    }
}

