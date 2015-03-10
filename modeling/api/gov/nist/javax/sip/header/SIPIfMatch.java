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
* of the terms of this agreement.
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

import javax.sip.header.ExtensionHeader;
import javax.sip.header.SIPIfMatchHeader;

public class SIPIfMatch extends SIPHeader implements SIPIfMatchHeader, ExtensionHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.115 -0500", hash_original_field = "01C58A657CD7064840F94919FF9DC30E", hash_generated_field = "F99AB9EB7E164B071039EF12AA230274")

    private static final long serialVersionUID = 3833745477828359730L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.122 -0500", hash_original_field = "566D98D00C97736CCE321D1406FB280A", hash_generated_field = "885FC2B59F698305A2C8A7BD5CC3FE18")

    protected String entityTag;

    /** Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.162 -0500", hash_original_method = "BAD2DC814CD45D5939615C62F83835FA", hash_generated_method = "EEDADED6A8326FC09068A059D953851F")
    
public SIPIfMatch() {
        super(NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.169 -0500", hash_original_method = "3D0893288CE2D1B79B07387D603E62DB", hash_generated_method = "C0BDB5AA2809534663FC38814EFF0F83")
    
public SIPIfMatch(String etag) throws ParseException {
        this();
        this.setETag( etag );
    }

    /**
     * Encode into canonical form.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.177 -0500", hash_original_method = "D71FCA65B3027CF0021F4CC3EAA91DA7", hash_generated_method = "50B6C7716102FD45B7927F775F089DAE")
    
public String encodeBody() {
        return entityTag;
    }

    /**
     * get the priority value.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.184 -0500", hash_original_method = "3D6890113704CA3A689BE5D16088DA64", hash_generated_method = "2E0243F57B8C17B52D83C43235A21586")
    
public String getETag() {
        return entityTag;
    }

    /**
     * Set the priority member
     * @param etag -- the entity tag to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.193 -0500", hash_original_method = "FF09F62ACDB51364A1C119FC09E0694A", hash_generated_method = "3D3F920A9172C4843B9FDACA83701EB1")
    
public void setETag(String etag) throws ParseException {
        if (etag == null)
            throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + "SIP-If-Match, setETag(), the etag parameter is null");
        this.entityTag = etag;
    }

    /**
     * For v 1.1 backwards compatibility.
     * @see javax.sip.header.ExtensionHeader#setValue(java.lang.String)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.199 -0500", hash_original_method = "7CA3A2804F10C6CA29833F9AB88CD018", hash_generated_method = "D4C128CCE03C008F8438DF743A00115A")
    
public void setValue(String value) throws ParseException {
        this.setETag(value);

    }
}

