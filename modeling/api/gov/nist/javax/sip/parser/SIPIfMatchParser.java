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
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPIfMatch;

import java.text.ParseException;





public class SIPIfMatchParser extends HeaderParser {

    /**
     * Creates a new instance of PriorityParser
     * @param etag the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.612 -0500", hash_original_method = "58C73D632C90677B10301C6C3F2EA3A6", hash_generated_method = "33A3C006471E5CE5D2E5DA6D0C127D49")
    
public SIPIfMatchParser(String etag) {
        super(etag);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.615 -0500", hash_original_method = "EF4950625B84E18FA318F1BE4AE7C3DD", hash_generated_method = "C23C4D068E2F2026CBFF1A942527A131")
    
protected SIPIfMatchParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String header
     * @return SIPHeader (Priority object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.617 -0500", hash_original_method = "3E32D858B03BB295FC48CF43F0845DFE", hash_generated_method = "C25431E8B75315810AEF2908E807AD89")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("SIPIfMatch.parse");

        SIPIfMatch sipIfMatch = new SIPIfMatch();
        try {
            headerName(TokenTypes.SIP_IF_MATCH);

            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();

            sipIfMatch.setETag(token.getTokenValue());

            this.lexer.SPorHT();
            this.lexer.match('\n');

            return sipIfMatch;
        } finally {
            if (debug)
                dbg_leave("SIPIfMatch.parse");
        }
    }

    
}

