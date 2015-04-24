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

import javax.sip.header.SubjectHeader;

public class Subject extends SIPHeader implements SubjectHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.549 -0500", hash_original_field = "94F423F3F6978A186151BAB9F3081E9D", hash_generated_field = "5A108BF1E2A98855AB05AF0A50CEDCDE")

    private static final long serialVersionUID = -6479220126758862528L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.551 -0500", hash_original_field = "05CF6DC5327609584327D4E74FDB9847", hash_generated_field = "FCF19B41C65ED3C233A6175A0183A3FB")

    protected String subject;

    /** Default Constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.554 -0500", hash_original_method = "D63809B6DE8F5F47E85D84EB99E1AE5D", hash_generated_method = "15598A1FA38378CE2423367C317B39C1")
    
public Subject() {
        super(SUBJECT);
    }

    /**
     * Generate the canonical form.
     * @return String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.557 -0500", hash_original_method = "3C6B7893125DF6EE8816C7C8DB5CA48D", hash_generated_method = "A1685D2E0097A430B598469A18E15C02")
    
public String encodeBody() {
        if (subject != null) {
            return subject;
        } else {
            return "";
        }
    }

    /**
     * Sets the subject value of the SubjectHeader to the supplied string
     * subject value.
     *
     * @param subject - the new subject value of this header
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the subject value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.560 -0500", hash_original_method = "6F21748266641C905516C66889D7570C", hash_generated_method = "FE4249006EE752EF49B6DA890BC8F9B0")
    
public void setSubject(String subject) throws ParseException {
        if (subject == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Subject, setSubject(), the subject parameter is null");
        this.subject = subject;
    }

    /**
     * Gets the subject value of SubjectHeader
     *
     * @return subject of SubjectHeader
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.564 -0500", hash_original_method = "8EBD535E211A75BE78AF45361DF5913D", hash_generated_method = "8FE22A6343735A7D9BA6760DEE36A03C")
    
public String getSubject() {
        return subject;
    }
}

