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
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.WWWAuthenticate;

import java.text.ParseException;





public class WWWAuthenticateParser extends ChallengeParser {

    /**
     * Constructor
     * @param wwwAuthenticate -  message to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.087 -0500", hash_original_method = "6138AB6ABE323397A90992BBA6CE68F7", hash_generated_method = "5BBD20962E7C1C2DA74B21C3669D0241")
    
public WWWAuthenticateParser(String wwwAuthenticate) {
        super(wwwAuthenticate);
    }

    /**
     * Cosntructor
     * @param  lexer - lexer to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.090 -0500", hash_original_method = "3C6BB1F0E541627B3210DAEB9F57410E", hash_generated_method = "908EA339A139F1CAC5965C2F8904BBC7")
    
protected WWWAuthenticateParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (WWWAuthenticate object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.092 -0500", hash_original_method = "21D63394A7F5FCF103E716C1D0FF5141", hash_generated_method = "52DAF62CFA21540E7031C5AAEB1696DA")
    
public SIPHeader parse() throws ParseException {
        if (debug)
            dbg_enter("parse");
        try {
            headerName(TokenTypes.WWW_AUTHENTICATE);
            WWWAuthenticate wwwAuthenticate = new WWWAuthenticate();
            super.parse(wwwAuthenticate);
            return wwwAuthenticate;
        } finally {
            if (debug)
                dbg_leave("parse");
        }
    }

    
}

