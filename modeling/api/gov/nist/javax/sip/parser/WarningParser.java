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
import gov.nist.javax.sip.header.Warning;
import gov.nist.javax.sip.header.WarningList;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class WarningParser extends HeaderParser {

    /**
     * Constructor
     *
     * @param warning -
     *            Warning header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.505 -0500", hash_original_method = "38623B910ABA654EC8C258B1F2DD35A3", hash_generated_method = "ADAA2404AD9AFA3E4FCBF93E8A04CA7C")
    
public WarningParser(String warning) {
        super(warning);
    }

    /**
     * Cosntructor
     *
     * @param lexer -
     *            the lexer to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.508 -0500", hash_original_method = "AB9AC91F8631F4AA3239C3547D18BC09", hash_generated_method = "6BC4FFEC90365BF5E44CE071D60EC134")
    
protected WarningParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     *
     * @return SIPHeader (WarningList object)
     * @throws SIPParseException
     *             if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.513 -0500", hash_original_method = "5665BE3F4ECC43E3239D3F1D8B9B76A3", hash_generated_method = "426004DD56479AB68361A155302D98E9")
    
public SIPHeader parse() throws ParseException {
        WarningList warningList = new WarningList();
        if (debug)
            dbg_enter("WarningParser.parse");

        try {
            headerName(TokenTypes.WARNING);

            while (lexer.lookAhead(0) != '\n') {
                Warning warning = new Warning();
                warning.setHeaderName(SIPHeaderNames.WARNING);

                // Parsing the 3digits code
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                try {
                    int code = Integer.parseInt(token.getTokenValue());
                    warning.setCode(code);
                } catch (NumberFormatException ex) {
                    throw createParseException(ex.getMessage());
                } catch (InvalidArgumentException ex) {
                    throw createParseException(ex.getMessage());
                }
                this.lexer.SPorHT();

                // Parsing the agent
                this.lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
                // Bug reported by zvali@dev.java.net
                if (lexer.lookAhead(0) == ':') {
                    this.lexer.match(':');
                    this.lexer.match(TokenTypes.ID);
                    Token token2 = lexer.getNextToken();
                    warning.setAgent(token.getTokenValue() + ":"
                            + token2.getTokenValue());
                } else {
                    warning.setAgent(token.getTokenValue());
                }

                this.lexer.SPorHT();

                // Parsing the text
                String text = this.lexer.quotedString();
                warning.setText(text);
                this.lexer.SPorHT();

                warningList.add(warning);

                while (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();

                    warning = new Warning();

                    // Parsing the 3digits code
                    this.lexer.match(TokenTypes.ID);
                    Token tok = lexer.getNextToken();
                    try {
                        int code = Integer.parseInt(tok.getTokenValue());
                        warning.setCode(code);
                    } catch (NumberFormatException ex) {
                        throw createParseException(ex.getMessage());
                    } catch (InvalidArgumentException ex) {
                        throw createParseException(ex.getMessage());
                    }
                    this.lexer.SPorHT();

                    // Parsing the agent
                    this.lexer.match(TokenTypes.ID);
                    tok = lexer.getNextToken();

                    // Bug reported by zvali@dev.java.net

                    if (lexer.lookAhead(0) == ':') {
                        this.lexer.match(':');
                        this.lexer.match(TokenTypes.ID);
                        Token token2 = lexer.getNextToken();
                        warning.setAgent(tok.getTokenValue() + ":"
                                + token2.getTokenValue());
                    } else {
                        warning.setAgent(tok.getTokenValue());
                    }

                    this.lexer.SPorHT();

                    // Parsing the text
                    text = this.lexer.quotedString();
                    warning.setText(text);
                    this.lexer.SPorHT();

                    warningList.add(warning);
                }

            }
        } finally {
            if (debug)
                dbg_leave("WarningParser.parse");
        }

        return warningList;
    }

    
}

