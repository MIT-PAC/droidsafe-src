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

public final class ContentDisposition extends ParametersHeader implements javax.sip.header.ContentDispositionHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.596 -0500", hash_original_field = "6D30F97CF92ABC307F883ACFB9E10475", hash_generated_field = "1A47D47195A65F4F581EF3E849861302")

    private static final long serialVersionUID = 835596496276127003L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.601 -0500", hash_original_field = "634864BA8712E046349E31B7209F4C6C", hash_generated_field = "3DCB42D88F9099A5D16D2C3D4422D6B7")

    protected String dispositionType;

    /**
     * Default constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.607 -0500", hash_original_method = "43E6E51171C31AE017D057FA4552D811", hash_generated_method = "68EEB813A55415DF9B5B717F2AD84B12")
    
public ContentDisposition() {
        super(NAME);
    }

    /**
     * Encode value of header into canonical string.
     * @return encoded value of header.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.612 -0500", hash_original_method = "A77142351A28E594907776BE9B73073E", hash_generated_method = "94BAD8C520FA4C9C42F084CD66C39C54")
    
public String encodeBody() {
        StringBuffer encoding = new StringBuffer(dispositionType);
        if (!this.parameters.isEmpty()) {
            encoding.append(SEMICOLON).append(parameters.encode());
        }
        return encoding.toString();
    }

    /**
     * Set the disposition type.
     * @param dispositionType type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.617 -0500", hash_original_method = "BC30AB325A2FD01EDD0A547607B8E8A1", hash_generated_method = "E8D67219D23C3B4BA31D64E4AA37DDD3")
    
public void setDispositionType(String dispositionType)
        throws ParseException {
        if (dispositionType == null)
            throw new NullPointerException(
                "JAIN-SIP Exception"
                    + ", ContentDisposition, setDispositionType(), the dispositionType parameter is null");
        this.dispositionType = dispositionType;
    }

    /**
     * Get the disposition type.
     * @return Disposition Type
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.622 -0500", hash_original_method = "D3ED1AFB699417969621FE1884F8C7FE", hash_generated_method = "A74AD48002A48C108D26F19F589610F9")
    
public String getDispositionType() {
        return this.dispositionType;
    }

    /**
     * Get the dispositionType field.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.626 -0500", hash_original_method = "0297698DA62A584BC408978A78677ED8", hash_generated_method = "D88B00DAB3631BE3634C337963FCDB38")
    
public String getHandling() {
        return this.getParameter("handling");
    }

    /** set the dispositionType field.
     * @param handling String to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.631 -0500", hash_original_method = "B6C4C36D7665EDCFABC9BF782D2AADE0", hash_generated_method = "72746B0C8E6F50381A740846901C041A")
    
public void setHandling(String handling) throws ParseException {
        if (handling == null)
            throw new NullPointerException(
                "JAIN-SIP Exception"
                    + ", ContentDisposition, setHandling(), the handling parameter is null");
        this.setParameter("handling", handling);
    }

    /**
     * Gets the interpretation of the message body or message body part of
     * this ContentDispositionHeader.
     *
     * @return interpretation of the message body or message body part
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.636 -0500", hash_original_method = "C2FDE3A2DBDC43C0B4279ABCAA53BEFB", hash_generated_method = "F2C27927045A66DB71E910B6DC8BF382")
    
public String getContentDisposition() {
        return this.encodeBody();
    }
}

