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
import gov.nist.core.Debug;
import gov.nist.core.LexerCore;
import gov.nist.core.ParserCore;
import gov.nist.core.Token;

import java.text.ParseException;

public abstract class Parser extends ParserCore implements TokenTypes {

    /**
     * Verifies that a given string matches the 'token' production in RFC3261
     *
     * @param token
     * @throws ParseException - if there are invalid characters
     *
     * @author JvB
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.169 -0500", hash_original_method = "5D57B7D8E86E542F53B3CEE7F8A3E576", hash_generated_method = "27B1A977D227EF1ED2F59B8A0BA001BA")
    
public static final void checkToken( String token ) throws ParseException {

        if (token == null || token.length()==0 ) {
            throw new ParseException("null or empty token", -1 );
        } else {
            // JvB: check that it is a valid token
            for ( int i=0; i<token.length(); ++i ) {
                if ( !LexerCore.isTokenChar( token.charAt(i) )) {
                    throw new ParseException( "Invalid character(s) in string (not allowed in 'token')", i );
                }
            }
        }
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.164 -0400", hash_original_method = "42CBDDB53A445ABDFB908116E235FAA0", hash_generated_method = "42CBDDB53A445ABDFB908116E235FAA0")
    public Parser ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.159 -0500", hash_original_method = "9ECF405713F3BDB595977394FAA46BC3", hash_generated_method = "74E8045DDF3B0B4D4E14DD9459189BF8")
    
protected ParseException createParseException(String exceptionString) {
        return new ParseException(
            lexer.getBuffer() + ":" + exceptionString,
            lexer.getPtr());
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.161 -0500", hash_original_method = "46F79D05E02F5C322F83A2BCE13C7B55", hash_generated_method = "0546A9D6EA2C9BFC49AE3B508DBA66A7")
    
protected Lexer getLexer() {
        return (Lexer) this.lexer;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.163 -0500", hash_original_method = "2745F417C183E90B52AF06D41C98230A", hash_generated_method = "75C20F86026E83C96214FCC10B09D203")
    
protected String sipVersion() throws ParseException {
        if (debug)
            dbg_enter("sipVersion");
        try {
            Token tok = lexer.match(SIP);
            if (!tok.getTokenValue().equalsIgnoreCase("SIP"))
                createParseException("Expecting SIP");
            lexer.match('/');
            tok = lexer.match(ID);
            if (!tok.getTokenValue().equals("2.0"))
                createParseException("Expecting SIP/2.0");

            return "SIP/2.0";
        } finally {
            if (debug)
                dbg_leave("sipVersion");
        }
    }

    /**
     * parses a method. Consumes if a valid method has been found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.166 -0500", hash_original_method = "DFEA7962E8FE3DE66D00681F9A6D11E3", hash_generated_method = "D4A582748A1256222F0353A380EFF1E4")
    
protected String method() throws ParseException {
        try {
            if (debug)
                dbg_enter("method");
            Token[] tokens = this.lexer.peekNextToken(1);
            Token token = (Token) tokens[0];
            if (token.getTokenType() == INVITE
                || token.getTokenType() == ACK
                || token.getTokenType() == OPTIONS
                || token.getTokenType() == BYE
                || token.getTokenType() == REGISTER
                || token.getTokenType() == CANCEL
                || token.getTokenType() == SUBSCRIBE
                || token.getTokenType() == NOTIFY
                || token.getTokenType() == PUBLISH
                || token.getTokenType() == MESSAGE
                || token.getTokenType() == ID) {
                lexer.consume();
                return token.getTokenValue();
            } else {
                throw createParseException("Invalid Method");
            }
        } finally {
            if (Debug.debug)
                dbg_leave("method");
        }
    }
    
}

