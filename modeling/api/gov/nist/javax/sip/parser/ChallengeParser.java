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
import gov.nist.core.NameValue;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.AuthenticationHeader;

import java.text.ParseException;





public abstract class ChallengeParser extends HeaderParser {

    /**
     * Constructor
     * @param String challenge  message to parse to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.599 -0500", hash_original_method = "0297ABBADD5BD655B8C4CB1A6717CB49", hash_generated_method = "839C6AD57343C084EB74731E43FFB334")
    
protected ChallengeParser(String challenge) {
        super(challenge);
    }

    /**
     * Constructor
     * @param String challenge  message to parse to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.602 -0500", hash_original_method = "FE6E9A1011CEBAC8DED6715FCD76DE94", hash_generated_method = "1A860CFBC41B90F5507D1EE6C3314F82")
    
protected ChallengeParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * Get the parameter of the challenge string
     * @return NameValue containing the parameter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.604 -0500", hash_original_method = "9DA7C681662806B106F4C258133C7994", hash_generated_method = "6546AA35598C4BC540E52130C96D42F4")
    
protected void parseParameter(AuthenticationHeader header)
        throws ParseException {

        if (debug)
            dbg_enter("parseParameter");
        try {
            NameValue nv = this.nameValue('=');
            header.setParameter(nv);
        } finally {
            if (debug)
                dbg_leave("parseParameter");
        }

    }

    /**
     * parser the String message.
     * @param header - header structure to fill in.
     * @throws ParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.607 -0500", hash_original_method = "B311542306ECD32A0F10ABE0BAAE80D2", hash_generated_method = "C756A705C3626349AFC522FCA146EF5D")
    
public void parse(AuthenticationHeader header) throws ParseException {

        // the Scheme:
        this.lexer.SPorHT();
        lexer.match(TokenTypes.ID);
        Token type = lexer.getNextToken();
        this.lexer.SPorHT();
        header.setScheme(type.getTokenValue());

        // The parameters:
        try {
            while (lexer.lookAhead(0) != '\n') {
                this.parseParameter(header);
                this.lexer.SPorHT();
                char la = lexer.lookAhead(0);
                if (la == '\n' || la == '\0')
                    break;
                this.lexer.match(',');
                this.lexer.SPorHT();
            }
        } catch (ParseException ex) {
            throw ex;
        }
    }

    
}

