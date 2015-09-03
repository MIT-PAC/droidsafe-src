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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPETag;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;



public class SIPETagParser extends HeaderParser {

    /**
     * Creates a new instance of PriorityParser
     * @param etag the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.644 -0500", hash_original_method = "25835348DC7AD8FF740039B9BA0B006A", hash_generated_method = "7DBC871E34662A75C5F9C0C3FD8B8B0F")
    
public SIPETagParser(String etag) {
        super(etag);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.647 -0500", hash_original_method = "03B2B3729732C2927273E5D90D52F99B", hash_generated_method = "F182C661D1BD3FF2D55AC247ACC1D86B")
    
protected SIPETagParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String header
     * @return SIPHeader (Priority object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.650 -0500", hash_original_method = "2EFAB9CD472E8A9D51A90FC23F3B4B08", hash_generated_method = "2F99CF48367A1485398C659CC2355AF7")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("SIPEtag.parse");

        SIPETag sipEtag = new SIPETag();
        try {
            headerName(TokenTypes.SIP_ETAG);

            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();

            sipEtag.setETag(token.getTokenValue());

            this.lexer.SPorHT();
            this.lexer.match('\n');

            return sipEtag;
        } finally {
            if (debug)
                dbg_leave("SIPEtag.parse");
        }
    }

    
}

