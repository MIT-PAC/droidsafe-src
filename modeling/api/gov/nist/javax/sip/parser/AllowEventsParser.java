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
import gov.nist.javax.sip.header.AllowEvents;
import gov.nist.javax.sip.header.AllowEventsList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class AllowEventsParser extends HeaderParser {

    /**
     * Creates a new instance of AllowEventsParser
     * @param allowEvents the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.110 -0500", hash_original_method = "B8B57389921DBA1CC2428437DFD404AC", hash_generated_method = "BA87E322AB32D77DC767F35C91B4FDB3")
    
public AllowEventsParser(String allowEvents) {
        super(allowEvents);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.113 -0500", hash_original_method = "53ECD40448666EF39463E8A30244C2E7", hash_generated_method = "958CE1F57150E5C71320DD5AEA3202BC")
    
protected AllowEventsParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the AllowEvents String header
     * @return SIPHeader (AllowEventsList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.117 -0500", hash_original_method = "457BF63FCB5F5743303EA5CCFBD04779", hash_generated_method = "3C6470CF292E197FFE72DA0E47EA6081")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("AllowEventsParser.parse");
        AllowEventsList list = new AllowEventsList();

        try {
            headerName(TokenTypes.ALLOW_EVENTS);

            AllowEvents allowEvents = new AllowEvents();
            allowEvents.setHeaderName(SIPHeaderNames.ALLOW_EVENTS);

            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            allowEvents.setEventType(token.getTokenValue());

            list.add(allowEvents);
            this.lexer.SPorHT();
            while (lexer.lookAhead(0) == ',') {
                this.lexer.match(',');
                this.lexer.SPorHT();

                allowEvents = new AllowEvents();
                this.lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
                allowEvents.setEventType(token.getTokenValue());

                list.add(allowEvents);
                this.lexer.SPorHT();
            }
            this.lexer.SPorHT();
            this.lexer.match('\n');

            return list;
        } finally {
            if (debug)
                dbg_leave("AllowEventsParser.parse");
        }
    }

    
}

