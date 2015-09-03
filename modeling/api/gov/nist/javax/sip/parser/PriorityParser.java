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
import gov.nist.javax.sip.header.Priority;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class PriorityParser extends HeaderParser {


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.758 -0500", hash_original_method = "51E7844EB1273E617B8B582DCB60EC10", hash_generated_method = "F5C833114C4CE4271AA879098931B4FF")
    
public static void main(String args[]) throws ParseException {
    String p[] = {
            "Priority: 8;a\n"
            };

    for (int i = 0; i < p.length; i++ ) {
        PriorityParser parser =
          new PriorityParser(p[i]);
        Priority prio= (Priority) parser.parse();
        System.out.println("encoded = " + prio.encode());
    }
    }

    /**
     * Creates a new instance of PriorityParser
     * @param priority the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.750 -0500", hash_original_method = "3761C7DAE2C27B7066194088DE84B020", hash_generated_method = "3601634849E64E856B23C314F6C2C339")
    
public PriorityParser(String priority) {
        super(priority);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.753 -0500", hash_original_method = "2FA6157C959FDD566822D2465D62D365", hash_generated_method = "36D4536737F1ED2F82CFD81E439399E1")
    
protected PriorityParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String header
     * @return SIPHeader (Priority object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.755 -0500", hash_original_method = "9ECC1E43903CC22F0322E70EF9078767", hash_generated_method = "9F820FD965DB8142D9F1DF748042CEC5")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("PriorityParser.parse");
        Priority priority = new Priority();
        try {
            headerName(TokenTypes.PRIORITY);

            priority.setHeaderName(SIPHeaderNames.PRIORITY);

            this.lexer.SPorHT();
            /*this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();

            priority.setPriority(token.getTokenValue());
            */
            // This is in violation of the RFC but
            // let us be generous in what we accept.
            priority.setPriority(this.lexer.ttokenSafe());

            this.lexer.SPorHT();
            this.lexer.match('\n');

            return priority;
        } finally {
            if (debug)
                dbg_leave("PriorityParser.parse");
        }
    }

    
}

