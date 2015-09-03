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

import javax.sip.header.RequireHeader;

public class Require extends SIPHeader implements RequireHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.187 -0500", hash_original_field = "035E47373783FD457068A566C31190DF", hash_generated_field = "771FB76C670B9496D76C78920521C071")

    private static final long serialVersionUID = -3743425404884053281L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.191 -0500", hash_original_field = "C47D1E13159584343BDF40043CEB3AB4", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;

    /**
     * Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.194 -0500", hash_original_method = "7D717471F4A5D7EAD23BC013F4963192", hash_generated_method = "A0A2E0AF3EDD799961D1B9F4DCE6008E")
    
public Require() {
        super(REQUIRE);
    }

    /** constructor
     * @param s String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.198 -0500", hash_original_method = "BECC14DD123F4F96D2EA3BD4716F0CF2", hash_generated_method = "271423711C073B525642E25F47AAEB6B")
    
public Require(String s) {
        super(REQUIRE);
        optionTag = s;
    }

    /**
     * Encode in canonical form.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.202 -0500", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "3E11F84AAB428D962C364CC48C7D950E")
    
public String encodeBody() {
        return optionTag;
    }

    /**
     * Sets the option tag value to the new supplied <var>optionTag</var>
     * parameter.
     *
     * @param optionTag - the new string value of the option tag.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the optionTag value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.206 -0500", hash_original_method = "61D4CA895F679FC1977776F5CD42A467", hash_generated_method = "DCE95DD2A76FBD973F364ED1C2F9FB4F")
    
public void setOptionTag(String optionTag) throws ParseException {
        if (optionTag == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, Require, "
                    + "setOptionTag(), the optionTag parameter is null");
        this.optionTag = optionTag;
    }

    /**
     * Gets the option tag of this OptionTag class.
     *
     * @return the string that identifies the option tag value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.209 -0500", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "3633D701492785C9119138C7D9BDC157")
    
public String getOptionTag() {
        return optionTag;
    }
}

