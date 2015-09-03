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
import gov.nist.javax.sip.address.GenericURI;

import java.text.ParseException;

public final class CallInfo extends ParametersHeader implements javax.sip.header.CallInfoHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.519 -0500", hash_original_field = "ED4DDD16B2A29876422E00CB4936E7AF", hash_generated_field = "2D62DF7E0A2A79C01356DE01B010437F")

    private static final long serialVersionUID = -8179246487696752928L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.527 -0500", hash_original_field = "6698CBE12F148EEFF557B63CC4CD3669", hash_generated_field = "CFBF7E2410210225F23571A6DEE68EDE")

    protected GenericURI info;

    /**
     * Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.531 -0500", hash_original_method = "E32B7E5F9D4A1980425339805E4FFC9A", hash_generated_method = "5B15A60622536973449DB72A7875F01A")
    
public CallInfo() {
        super(CALL_INFO);
    }

    /**
     * Return canonical representation.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.552 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "74B066602ECC20A74FD97E770D65E8BD")
    
public String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.577 -0500", hash_original_method = "A4CCBF948684EE8C510DCE8D73383A9B", hash_generated_method = "58FA69A25F5F0D895251B013B730D054")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        buffer.append(LESS_THAN);
        info.encode(buffer);
        buffer.append(GREATER_THAN);

        if (parameters != null && !parameters.isEmpty()) {
            buffer.append(SEMICOLON);
            parameters.encode(buffer);
        }

        return buffer;
    }

    /**
     * get the purpose field
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.584 -0500", hash_original_method = "5AE253F427E5A28ACB58F8121152C53D", hash_generated_method = "C9AF8286A3A66FEDDBCA27281DEBEFEA")
    
public String getPurpose() {
        return this.getParameter("purpose");
    }

    /**
     * get the URI field
     * @return URI
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.602 -0500", hash_original_method = "EF1B9495763809E09B57BAE8A2B95EE3", hash_generated_method = "08BCE0CA97E1FDEE68837D588A916CA6")
    
public javax.sip.address.URI getInfo() {
        return info;
    }

    /**
     * set the purpose field
     * @param purpose is the purpose field.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.615 -0500", hash_original_method = "02434F47BE675094B3D64F5516EB6DB6", hash_generated_method = "DA44A599564C6163C0B577B015D1679E")
    
public void setPurpose(String purpose) {
        if (purpose == null)
            throw new NullPointerException("null arg");
        try {
            this.setParameter("purpose", purpose);
        } catch (ParseException ex) {
        }
    }

    /**
     * set the URI field
     * @param info is the URI to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.620 -0500", hash_original_method = "5AA5786EA20C5BC42796F42D6FB1BBD6", hash_generated_method = "82FF90FEBD62D5DBE837F566BB0C9502")
    
public void setInfo(javax.sip.address.URI info) {
        this.info = (GenericURI) info;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.624 -0500", hash_original_method = "13BFA074DC19025B66849B6C15AC7B30", hash_generated_method = "EB36E89A4C736ABE4913A72866D4A39A")
    
public Object clone() {
        CallInfo retval = (CallInfo) super.clone();
        if (this.info != null)
            retval.info = (GenericURI) this.info.clone();
        return retval;
    }
}

