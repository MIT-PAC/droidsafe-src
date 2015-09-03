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
import gov.nist.javax.sip.header.Require;
import gov.nist.javax.sip.header.RequireList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class RequireParser extends HeaderParser {

    /**
     * Creates a new instance of RequireParser
     * @param require the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.676 -0500", hash_original_method = "36FA164E6C8032C19B516E5C5C1FBE28", hash_generated_method = "242528C7812F1224C6616609509E0754")
    
public RequireParser(String require) {
        super(require);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.680 -0500", hash_original_method = "B3FB5559B13CB63E7EB6EFAD451D2F82", hash_generated_method = "B0DAB9385009FD70BEEA1185E52985AA")
    
protected RequireParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (RequireList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.683 -0500", hash_original_method = "3025739AB5329DC0A390687D4C2BFD5B", hash_generated_method = "13B71AEB548DF52975090635E15697F9")
    
public SIPHeader parse() throws ParseException {
        RequireList requireList = new RequireList();
        if (debug)
            dbg_enter("RequireParser.parse");

        try {
            headerName(TokenTypes.REQUIRE);

            while (lexer.lookAhead(0) != '\n') {
                Require r = new Require();
                r.setHeaderName(SIPHeaderNames.REQUIRE);

                // Parsing the option tag
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                r.setOptionTag(token.getTokenValue());
                this.lexer.SPorHT();

                requireList.add(r);

                while (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();

                    r = new Require();

                    // Parsing the option tag
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    r.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();

                    requireList.add(r);
                }

            }
        } finally {
            if (debug)
                dbg_leave("RequireParser.parse");
        }

        return requireList;
    }

    
}

