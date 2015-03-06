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
import gov.nist.javax.sip.header.Accept;
import gov.nist.javax.sip.header.AcceptList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class AcceptParser extends ParametersParser {

    /**
     * Creates a new instance of Accept Parser
     * @param accept  the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.156 -0500", hash_original_method = "E50D6CA61897C534ECF6BFE2E6C66EEB", hash_generated_method = "15E1CF64B509FE04077205B29E000359")
    
public AcceptParser(String accept) {
        super(accept);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.159 -0500", hash_original_method = "B0740C746A8D55CA7E1BAB3B373D9F3B", hash_generated_method = "B80F6663D72F35BA386A8FB8BACBFD9E")
    
protected AcceptParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the Accept  String header
     * @return SIPHeader (AcceptList  object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.162 -0500", hash_original_method = "4B990F83EF66D5D2EAA453ED852E8DC7", hash_generated_method = "A8C6BC8103293C709C8E18829559112E")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("AcceptParser.parse");
        AcceptList list = new AcceptList();

        try {
            headerName(TokenTypes.ACCEPT);

            Accept accept = new Accept();
            accept.setHeaderName(SIPHeaderNames.ACCEPT);

            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            accept.setContentType(token.getTokenValue());
            this.lexer.match('/');
            this.lexer.match(TokenTypes.ID);
            token = lexer.getNextToken();
            accept.setContentSubType(token.getTokenValue());
            this.lexer.SPorHT();

            super.parse(accept);
            list.add(accept);

            while (lexer.lookAhead(0) == ',') {
                this.lexer.match(',');
                this.lexer.SPorHT();

                accept = new Accept();

                this.lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
                accept.setContentType(token.getTokenValue());
                this.lexer.match('/');
                this.lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
                accept.setContentSubType(token.getTokenValue());
                this.lexer.SPorHT();
                super.parse(accept);
                list.add(accept);

            }
            return list;
        } finally {
            if (debug)
                dbg_leave("AcceptParser.parse");
        }
    }

    
}

