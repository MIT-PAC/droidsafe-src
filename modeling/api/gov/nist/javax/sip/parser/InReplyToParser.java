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
import gov.nist.javax.sip.header.InReplyTo;
import gov.nist.javax.sip.header.InReplyToList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class InReplyToParser extends HeaderParser {

    /**
     * Creates a new instance of InReplyToParser
     * @param inReplyTo the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.687 -0500", hash_original_method = "7EE0A4AE96DC703284542932FE729FBB", hash_generated_method = "D9BAA364E4896897364EC470C55B144D")
    
public InReplyToParser(String inReplyTo) {
        super(inReplyTo);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.691 -0500", hash_original_method = "513EEBB38452DE199EDFA3069C858F5F", hash_generated_method = "0D8B268B46F9A92E6178751B56CF0C2D")
    
protected InReplyToParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (InReplyToList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.694 -0500", hash_original_method = "A68E0921F08E40A4FFD6BCC285B4B760", hash_generated_method = "8F8FF4F55B417D9FC34E9B3BBDC89DB8")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("InReplyToParser.parse");
        InReplyToList list = new InReplyToList();

        try {
            headerName(TokenTypes.IN_REPLY_TO);

            while (lexer.lookAhead(0) != '\n') {
                InReplyTo inReplyTo = new InReplyTo();
                inReplyTo.setHeaderName(SIPHeaderNames.IN_REPLY_TO);

                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                if (lexer.lookAhead(0) == '@') {
                    this.lexer.match('@');
                    this.lexer.match(TokenTypes.ID);
                    Token secToken = lexer.getNextToken();
                    inReplyTo.setCallId(
                        token.getTokenValue() + "@" + secToken.getTokenValue());
                } else {
                    inReplyTo.setCallId(token.getTokenValue());
                }

                this.lexer.SPorHT();

                list.add(inReplyTo);

                while (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();

                    inReplyTo = new InReplyTo();

                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    if (lexer.lookAhead(0) == '@') {
                        this.lexer.match('@');
                        this.lexer.match(TokenTypes.ID);
                        Token secToken = lexer.getNextToken();
                        inReplyTo.setCallId(
                            token.getTokenValue()
                                + "@"
                                + secToken.getTokenValue());
                    } else {
                        inReplyTo.setCallId(token.getTokenValue());
                    }

                    list.add(inReplyTo);
                }
            }

            return list;
        } finally {
            if (debug)
                dbg_leave("InReplyToParser.parse");
        }
    }

    
}

