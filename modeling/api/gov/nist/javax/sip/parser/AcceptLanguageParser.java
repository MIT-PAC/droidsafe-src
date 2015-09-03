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
/*
 * AcceptLanguageParser.java
 *
 * Created on June 10, 2002, 3:31 PM
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.AcceptLanguage;
import gov.nist.javax.sip.header.AcceptLanguageList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class AcceptLanguageParser extends HeaderParser {

    /**
     * Constructor
     * @param acceptLanguage AcceptLanguage message to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.480 -0500", hash_original_method = "4ECD6586A5A6ED08B6159E7C6D7079C1", hash_generated_method = "EE8103F532F2D46D3610970D092C3ECB")
    
public AcceptLanguageParser(String acceptLanguage) {
        super(acceptLanguage);
    }

    /**
     * Constructor
     * @param lexer Lexer to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.483 -0500", hash_original_method = "8738AF37C5C1AC35B7D6DAA26504D715", hash_generated_method = "D6E006301BCD32DC14D27238F2F9D49E")
    
protected AcceptLanguageParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (AcceptLanguage object)
     * @throws ParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.487 -0500", hash_original_method = "FB0497E5D9550DB51E743204446EFE6C", hash_generated_method = "E71308111C5DA8DA3F027CA04BAFE3A4")
    
public SIPHeader parse() throws ParseException {
        AcceptLanguageList acceptLanguageList = new AcceptLanguageList();
        if (debug)
            dbg_enter("AcceptLanguageParser.parse");

        try {
            headerName(TokenTypes.ACCEPT_LANGUAGE);

            while (lexer.lookAhead(0) != '\n') {
                AcceptLanguage acceptLanguage = new AcceptLanguage();
                acceptLanguage.setHeaderName(SIPHeaderNames.ACCEPT_LANGUAGE);
                if (lexer.lookAhead(0) != ';') {
                    // Content-Coding:
                    lexer.match(TokenTypes.ID);
                    Token value = lexer.getNextToken();
                    acceptLanguage.setLanguageRange(value.getTokenValue());
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
                        float fl = Float.parseFloat(value.getTokenValue());
                        acceptLanguage.setQValue(fl);
                    } catch (NumberFormatException ex) {
                        throw createParseException(ex.getMessage());
                    } catch (InvalidArgumentException ex) {
                        throw createParseException(ex.getMessage());
                    }
                    this.lexer.SPorHT();
                }

                acceptLanguageList.add(acceptLanguage);
                if (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } else
                    this.lexer.SPorHT();

            }
        } finally {
            if (debug)
                dbg_leave("AcceptLanguageParser.parse");
        }

        return acceptLanguageList;
    }

    
}

