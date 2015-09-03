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

public final class Allow extends SIPHeader implements javax.sip.header.AllowHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.309 -0500", hash_original_field = "403105A958860DB5616FD28C593F6288", hash_generated_field = "85C85A2237A84342C80D2A96596481BF")

    private static final long serialVersionUID = -3105079479020693930L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.313 -0500", hash_original_field = "842C170402669AC7A74293BBBFD3BC5D", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;

    /** default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.315 -0500", hash_original_method = "473413697039914FAE978B5460F14DD9", hash_generated_method = "7144F05B316388D4FB02D674281EA11A")
    
public Allow() {
        super(ALLOW);
    }

    /** constructor
     * @param m String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.319 -0500", hash_original_method = "07DC0232E600446B62A81ACF6B5528CD", hash_generated_method = "44564E201CD2D38AEACEA7E1490034D9")
    
public Allow(String m) {
        super(ALLOW);
        method = m;
    }

    /** get the method field
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.322 -0500", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "BC38B478E0AED2517A3460750CABA307")
    
public String getMethod() {
        return method;
    }

    /**
     * Set the method member
     * @param method method to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.325 -0500", hash_original_method = "78C1F544F0B2D71B62F1C06FF7335973", hash_generated_method = "2023EF4B56C823A949F968423E41B129")
    
public void setMethod(String method) throws ParseException {
        if (method == null)
            throw new NullPointerException(
                "JAIN-SIP Exception"
                    + ", Allow, setMethod(), the method parameter is null.");
        this.method = method;
    }

    /** Return body encoded in canonical form.
     * @return body encoded as a string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.328 -0500", hash_original_method = "48A673DBBFEBFCB1D74A4ACDDDC3C6AB", hash_generated_method = "BF486431FF0AE34E20C9943AA080AC10")
    
protected String encodeBody() {
        return method;
    }
}

