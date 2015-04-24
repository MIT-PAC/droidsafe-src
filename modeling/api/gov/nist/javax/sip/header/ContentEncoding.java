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

public class ContentEncoding extends SIPHeader implements javax.sip.header.ContentEncodingHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.650 -0500", hash_original_field = "7C03D5110AD07BA3A5BDC24C12533FBC", hash_generated_field = "A6105BB7D9606B15FED8D5EA58524006")

    private static final long serialVersionUID = 2034230276579558857L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.652 -0500", hash_original_field = "CEA29DCF66C639EAD8E96ECC619BF901", hash_generated_field = "28D90C4A539A5E5930C5B1B3C4D77F57")

    protected String contentEncoding;

    /**
     * Default constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.656 -0500", hash_original_method = "AF3A83AEFF326F1AB1D055130F5C4343", hash_generated_method = "09CFAB9F360924133F778652D1D0B4E0")
    
public ContentEncoding() {
        super(CONTENT_ENCODING);
    }

    /**
     * Constructor.
     * @param enc String to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.659 -0500", hash_original_method = "4F763B16EA587AFDD37717E0DDC46D04", hash_generated_method = "DDA3A120F8FE7C363BB05513A1923AAF")
    
public ContentEncoding(String enc) {
        super(CONTENT_ENCODING);
        contentEncoding = enc;
    }

    /**
     * Canonical encoding of body of the header.
     * @return  encoded body of the header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.661 -0500", hash_original_method = "762501862EB015269BBC405DBBAC5194", hash_generated_method = "35FF15333BFC2F82D2301F5965AF8264")
    
public String encodeBody() {
        return contentEncoding;
    }

    /**
     * Get the ContentEncoding field.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.664 -0500", hash_original_method = "13F27076508F7754A69639743C7567EC", hash_generated_method = "BA6542BA89565E59728F6E58B857CC11")
    
public String getEncoding() {
        return contentEncoding;
    }

    /**
     * Set the ConentEncoding field.
     * @param encoding String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.668 -0500", hash_original_method = "250F948E1BF6921E6DE1D81CBA749729", hash_generated_method = "991B89D57D56C0543FDE0E0545CB63A5")
    
public void setEncoding(String encoding) throws ParseException {
        if (encoding == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, " + " encoding is null");
        contentEncoding = encoding;
    }
}

