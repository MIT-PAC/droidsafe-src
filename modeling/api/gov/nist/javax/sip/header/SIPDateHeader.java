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
import java.util.Calendar;

import javax.sip.header.DateHeader;

public class SIPDateHeader extends SIPHeader implements DateHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.181 -0500", hash_original_field = "867FE7EF03E7B156FD30B8EA4DEB76C9", hash_generated_field = "FB9F215913247CD3C2C1FF9CAC7EC54C")

    private static final long serialVersionUID = 1734186339037274664L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.184 -0500", hash_original_field = "2CE28348E0786C20FC808C04279A89BA", hash_generated_field = "E6B895F7293606CA8C9A3D5102653BE1")

    protected SIPDate date;

    /** Default constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.188 -0500", hash_original_method = "1EECE0587E859340DA3FB0354A4B8225", hash_generated_method = "F01F1BDF394072AAA4573EE5D427CA0C")
    
public SIPDateHeader() {
        super(DATE);
    }

    /** Encode the header into a String.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.191 -0500", hash_original_method = "C034912C24C8AA492A55E1DAB6749820", hash_generated_method = "5413705055B44539B10CEEEA8C0D255B")
    
public String encodeBody() {
        return date.encode();
    }

    /**
     * Set the date member
     * @param d SIPDate to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.194 -0500", hash_original_method = "6C9EAA9AEBF2DE9AF857C9766729F95B", hash_generated_method = "8E3BBEB13D970D6DC8A2C96A820C0EAF")
    
public void setDate(SIPDate d) {
        date = d;

    }

    /**
     * Sets date of DateHeader. The date is repesented by the Calendar object.
     *
     * @param dat the Calendar object date of this header.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.197 -0500", hash_original_method = "593883A7F1E198F7FABAA636FE37D3D4", hash_generated_method = "6A81C750B533B547AC7FCB58B010ACF5")
    
public void setDate(Calendar dat) {
        if (dat != null)
            date = new SIPDate(dat.getTime().getTime());
    }

    /**
     * Gets the date of DateHeader. The date is repesented by the Calender
     * object.
     *
     * @return the Calendar object representing the date of DateHeader
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.199 -0500", hash_original_method = "8348440FA7E2BF46CE5F14E959934430", hash_generated_method = "8D897808B9E217D79B1C7FE59F59028A")
    
public Calendar getDate() {
        if (date == null)
            return null;
        return date.getJavaCal();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.202 -0500", hash_original_method = "D8FA67BA672B59A2560C827929374032", hash_generated_method = "49BA62AC1844825032690DB7375DC638")
    
public Object clone() {
        SIPDateHeader retval = (SIPDateHeader) super.clone();
        if (this.date != null)
            retval.date = (SIPDate) this.date.clone();
        return retval;
    }
}

