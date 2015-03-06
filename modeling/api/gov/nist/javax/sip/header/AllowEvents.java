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

public final class AllowEvents extends SIPHeader implements javax.sip.header.AllowEventsHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.892 -0500", hash_original_field = "E0457E9B6122AB6EB61F0CA98E9F08B0", hash_generated_field = "AC25BA32AE0E1E6630D2239F784D525D")

    private static final long serialVersionUID = 617962431813193114L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.895 -0500", hash_original_field = "1BD057D2E2E93DC292EFB1B66D4C32FA", hash_generated_field = "8B4AE3944FE26E1E3D2F161694AF8E90")

    protected String eventType;

    /** default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.899 -0500", hash_original_method = "B300CC10915D88E488A895EA20EE2A09", hash_generated_method = "3F78B17A57F39E6EC2308911F306E996")
    
public AllowEvents() {
        super(ALLOW_EVENTS);
    }

    /** constructor
     * @param m String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.903 -0500", hash_original_method = "5D2656FB66C7C3040E5BEE12ACA7E341", hash_generated_method = "97E6D15C6AA0160E4B0A42BEC0188179")
    
public AllowEvents(String m) {
        super(ALLOW_EVENTS);
        eventType = m;
    }

    /**
     * Sets the eventType defined in this AllowEventsHeader.
     *
     * @param eventType - the String defining the method supported
     * in this AllowEventsHeader
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the Strings defining the eventType supported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.907 -0500", hash_original_method = "A10AD710FF1C0BA35C48E4F204BD5CD1", hash_generated_method = "993BB5F3478F63B8DB1FB881816A2F73")
    
public void setEventType(String eventType) throws ParseException {
        if (eventType == null)
            throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + "AllowEvents, setEventType(), the eventType parameter is null");
        this.eventType = eventType;
    }

    /**
     * Gets the eventType of the AllowEventsHeader.
     *
     * @return the String object identifing the eventTypes of AllowEventsHeader.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.910 -0500", hash_original_method = "801AF3F6658A2A453A4D4DA9830DAF46", hash_generated_method = "0EA18A09E98FC5671017BB747A3A08BC")
    
public String getEventType() {
        return eventType;
    }

    /** Return body encoded in canonical form.
        * @return body encoded as a string.
        */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.914 -0500", hash_original_method = "895FBB9B6BA00626F6F635DDC47F48B7", hash_generated_method = "5A04B31D95F8294D7A375311360DCE87")
    
protected String encodeBody() {
        return eventType;
    }
}

