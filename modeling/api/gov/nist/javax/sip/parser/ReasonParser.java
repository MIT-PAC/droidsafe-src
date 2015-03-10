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
import gov.nist.javax.sip.header.Reason;
import gov.nist.javax.sip.header.ReasonList;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class ReasonParser extends ParametersParser {

    /**
     * Creates a new instance of ReasonParser
     * @param reason the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.865 -0500", hash_original_method = "B94DA4BEBB849BE0C94AD11E29C73BAF", hash_generated_method = "E4CAE05F1742E6F4D9EE56AAEC4DAE35")
    
public ReasonParser(String reason) {
        super(reason);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.868 -0500", hash_original_method = "A4DE926778D9613A22D41E6650D2AD81", hash_generated_method = "609B66F71635733EEC2627426CF3D849")
    
protected ReasonParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (ReasonParserList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.871 -0500", hash_original_method = "C924C06E3DD994AE91BBC5A8A54B9FE3", hash_generated_method = "DD675B4DB80B01CA747A2586227C4AFA")
    
public SIPHeader parse() throws ParseException {
        ReasonList reasonList = new ReasonList();
        if (debug)
            dbg_enter("ReasonParser.parse");

        try {
            headerName(TokenTypes.REASON);
            this.lexer.SPorHT();
            while (lexer.lookAhead(0) != '\n') {
                Reason reason = new Reason();
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                String value = token.getTokenValue();

                reason.setProtocol(value);
                super.parse(reason);
                reasonList.add(reason);
                if (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } else
                    this.lexer.SPorHT();

            }
        } finally {
            if (debug)
                dbg_leave("ReasonParser.parse");
        }

        return reasonList;
    }

    
}

