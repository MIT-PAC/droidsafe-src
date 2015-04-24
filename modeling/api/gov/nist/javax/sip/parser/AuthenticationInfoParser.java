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
import gov.nist.javax.sip.header.AuthenticationInfo;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class AuthenticationInfoParser extends ParametersParser {

    /**
     * Creates a new instance of AuthenticationInfoParser
     * @param authenticationInfo the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.071 -0500", hash_original_method = "F28ABF8CFF04CC1C57BCD4E014C95C2B", hash_generated_method = "C52781DE68D0E8381AD445FB0A42C99D")
    
public AuthenticationInfoParser(String authenticationInfo) {
        super(authenticationInfo);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.074 -0500", hash_original_method = "49A5BC0E10B199942A909086CCB53299", hash_generated_method = "24775B47F28F9DCC02BCDE0F1B7F22EF")
    
protected AuthenticationInfoParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the AuthenticationInfo String header
     * @return SIPHeader (AuthenticationInfoList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.077 -0500", hash_original_method = "2DCD0228D3AB6B3B6D80756266EB3403", hash_generated_method = "BE18C1C14CF0932D529700151D21C78F")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("AuthenticationInfoParser.parse");

        try {
            headerName(TokenTypes.AUTHENTICATION_INFO);

            AuthenticationInfo authenticationInfo = new AuthenticationInfo();
            authenticationInfo.setHeaderName(
                SIPHeaderNames.AUTHENTICATION_INFO);

            this.lexer.SPorHT();

            NameValue nv = super.nameValue();
            authenticationInfo.setParameter(nv);
            this.lexer.SPorHT();
            while (lexer.lookAhead(0) == ',') {
                this.lexer.match(',');
                this.lexer.SPorHT();

                nv = super.nameValue();
                authenticationInfo.setParameter(nv);
                this.lexer.SPorHT();
            }
            this.lexer.SPorHT();
            //this.lexer.match('\n');

            return authenticationInfo;
        } finally {
            if (debug)
                dbg_leave("AuthenticationInfoParser.parse");
        }
    }

    
}

