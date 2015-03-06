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
import gov.nist.javax.sip.header.AcceptEncoding;
import gov.nist.javax.sip.header.AcceptEncodingList;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class AcceptEncodingParser extends HeaderParser {

    /**
     * Constructor
     * @param acceptEncoding message to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.005 -0500", hash_original_method = "865E86FA800E1D68F0770AD3080D258F", hash_generated_method = "F694C56F96A8F33310106F0BD29162EF")
    
public AcceptEncodingParser(String acceptEncoding) {
        super(acceptEncoding);
    }

    /**
     * Constructor
     * @param lexer Lexer to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.009 -0500", hash_original_method = "2A31652D0F06752F063CE4D7769684DB", hash_generated_method = "AD8AA37F18D7B3D7A069F41BA3415EFB")
    
protected AcceptEncodingParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (AcceptEncoding object)
     * @throws ParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.012 -0500", hash_original_method = "A9DB3F83816CED00173237937952E9D8", hash_generated_method = "F79B5A2E07ACD55A548C33C3CE214E10")
    
public SIPHeader parse() throws ParseException {
        AcceptEncodingList acceptEncodingList = new AcceptEncodingList();
        if (debug)
            dbg_enter("AcceptEncodingParser.parse");

        try {
            headerName(TokenTypes.ACCEPT_ENCODING);
            // empty body is fine for this header.
            if (lexer.lookAhead(0) == '\n') {
                AcceptEncoding acceptEncoding = new AcceptEncoding();
                acceptEncodingList.add(acceptEncoding);
            } else {
                while (lexer.lookAhead(0) != '\n') {
                    AcceptEncoding acceptEncoding = new AcceptEncoding();
                    if (lexer.lookAhead(0) != ';') {
                        // Content-Coding:
                        lexer.match(TokenTypes.ID);
                        Token value = lexer.getNextToken();
                        acceptEncoding.setEncoding(value.getTokenValue());
                    }

                    while (lexer.lookAhead(0) == ';') {
                        this.lexer.match(';');
                        this.lexer.SPorHT();
                        this.lexer.match('q');
                        this.lexer.SPorHT();
                        this.lexer.match('=');
                        this.lexer.SPorHT();
                        lexer.match(TokenTypes.ID);
                        Token value = lexer.getNextToken();
                        try {
                            float qv = Float.parseFloat(value.getTokenValue());
                            acceptEncoding.setQValue(qv);
                        } catch (NumberFormatException ex) {
                            throw createParseException(ex.getMessage());
                        } catch (InvalidArgumentException ex) {
                            throw createParseException(ex.getMessage());
                        }
                        this.lexer.SPorHT();
                    }

                    acceptEncodingList.add(acceptEncoding);
                    if (lexer.lookAhead(0) == ',') {
                        this.lexer.match(',');
                        this.lexer.SPorHT();
                    }

                }
            }
            return acceptEncodingList;
        } finally {
            if (debug)
                dbg_leave("AcceptEncodingParser.parse");
        }
    }

    
}

