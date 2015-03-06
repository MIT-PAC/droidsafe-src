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
import gov.nist.javax.sip.header.SIPHeaderNames;
import gov.nist.javax.sip.header.Supported;
import gov.nist.javax.sip.header.SupportedList;

import java.text.ParseException;





public class SupportedParser extends HeaderParser {

    /**
     * Creates a new instance of SupportedParser
     * @param supported the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.028 -0500", hash_original_method = "825F17E8D5A2A3E333D66101B84E14D2", hash_generated_method = "AD4FC447AE529D97C7B0E291B2C3206A")
    
public SupportedParser(String supported) {
        super(supported);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.031 -0500", hash_original_method = "6DF629AC3F3B8D2B11653ABB66FFD43C", hash_generated_method = "FE3A22B10F31194FD6592970762C61CD")
    
protected SupportedParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (Supported object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.034 -0500", hash_original_method = "0C976477F7A22AE527BAA6379E244E6F", hash_generated_method = "B0673D9789C64E640B95006E1104E706")
    
public SIPHeader parse() throws ParseException {
        SupportedList supportedList = new SupportedList();
        if (debug)
            dbg_enter("SupportedParser.parse");

        try {
            headerName(TokenTypes.SUPPORTED);

            while (lexer.lookAhead(0) != '\n') {
                this.lexer.SPorHT();
                Supported supported = new Supported();
                supported.setHeaderName(SIPHeaderNames.SUPPORTED);

                // Parsing the option tag
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                supported.setOptionTag(token.getTokenValue());
                this.lexer.SPorHT();

                supportedList.add(supported);

                while (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();

                    supported = new Supported();

                    // Parsing the option tag
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    supported.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();

                    supportedList.add(supported);
                }

            }
        } finally {
            if (debug)
                dbg_leave("SupportedParser.parse");
        }

        return supportedList;
    }

    
}

