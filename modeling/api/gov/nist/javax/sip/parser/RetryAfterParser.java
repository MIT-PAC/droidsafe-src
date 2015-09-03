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
import gov.nist.javax.sip.header.RetryAfter;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class RetryAfterParser extends HeaderParser {

    /**
     * Creates a new instance of RetryAfterParser
     * @param retryAfter the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.653 -0500", hash_original_method = "72BD428D826DE1DC77C96CF7C6F2A06C", hash_generated_method = "1A2666F65622A32BE62EAD0D1C33774A")
    
public RetryAfterParser(String retryAfter) {
        super(retryAfter);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.656 -0500", hash_original_method = "E2C340AAC5E92DCEDAC2E3B0DF98081F", hash_generated_method = "A025D75719A415964E7BF7924231AB3D")
    
protected RetryAfterParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (RetryAfter object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.659 -0500", hash_original_method = "4F8238CAC8DB557039065AEC5DC20094", hash_generated_method = "28013C17768ECE56E0D132D11166A41B")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("RetryAfterParser.parse");

        RetryAfter retryAfter = new RetryAfter();
        try {
            headerName(TokenTypes.RETRY_AFTER);

            // mandatory delatseconds:
            String value = lexer.number();
            try {
                int ds = Integer.parseInt(value);
                retryAfter.setRetryAfter(ds);
            } catch (NumberFormatException ex) {
                throw createParseException(ex.getMessage());
            } catch (InvalidArgumentException ex) {
                throw createParseException(ex.getMessage());
            }

            this.lexer.SPorHT();
            if (lexer.lookAhead(0) == '(') {
                String comment = this.lexer.comment();
                retryAfter.setComment(comment);
            }
            this.lexer.SPorHT();

            while (lexer.lookAhead(0) == ';') {
                this.lexer.match(';');
                this.lexer.SPorHT();
                lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                value = token.getTokenValue();
                if (value.equalsIgnoreCase("duration")) {
                    this.lexer.match('=');
                    this.lexer.SPorHT();
                    value = lexer.number();
                    try {
                        int duration = Integer.parseInt(value);
                        retryAfter.setDuration(duration);
                    } catch (NumberFormatException ex) {
                        throw createParseException(ex.getMessage());
                    } catch (InvalidArgumentException ex) {
                        throw createParseException(ex.getMessage());
                    }
                } else {
                    this.lexer.SPorHT();
                    this.lexer.match('=');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    Token secondToken = lexer.getNextToken();
                    String secondValue = secondToken.getTokenValue();
                    retryAfter.setParameter(value, secondValue);
                }
                this.lexer.SPorHT();
            }
        } finally {
            if (debug)
                dbg_leave("RetryAfterParser.parse");
        }

        return retryAfter;
    }

    
}

