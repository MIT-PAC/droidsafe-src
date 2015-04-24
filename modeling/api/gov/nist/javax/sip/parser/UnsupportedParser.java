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
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;
import gov.nist.javax.sip.header.Unsupported;
import gov.nist.javax.sip.header.UnsupportedList;

import java.text.ParseException;





public class UnsupportedParser extends HeaderParser {

    /**
     * Creates a new instance of UnsupportedParser
     * @param unsupported - Unsupported header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.073 -0500", hash_original_method = "A2BE521086BBB92362B9FD64733842A2", hash_generated_method = "E688882E7340371BF6866E83AC6F0F8F")
    
public UnsupportedParser(String unsupported) {
        super(unsupported);
    }

    /**
     * Constructor
     * @param lexer - the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.075 -0500", hash_original_method = "FB5DFA63EA36D3A5606EA09CE2E82C0B", hash_generated_method = "D3C73A618EC92CB9B987DFFBAE0EA997")
    
protected UnsupportedParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (Unsupported object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.078 -0500", hash_original_method = "9F68B71E39A8D368C1910EB63F18B506", hash_generated_method = "EC23550E2D5DC2CBAD5A8C6F680A40F1")
    
public SIPHeader parse() throws ParseException {
        UnsupportedList unsupportedList = new UnsupportedList();
        if (debug)
            dbg_enter("UnsupportedParser.parse");

        try {
            headerName(TokenTypes.UNSUPPORTED);

            while (lexer.lookAhead(0) != '\n') {
                this.lexer.SPorHT();
                Unsupported unsupported = new Unsupported();
                unsupported.setHeaderName(SIPHeaderNames.UNSUPPORTED);

                // Parsing the option tag
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                unsupported.setOptionTag(token.getTokenValue());
                this.lexer.SPorHT();

                unsupportedList.add(unsupported);

                while (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();

                    unsupported = new Unsupported();

                    // Parsing the option tag
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    unsupported.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();

                    unsupportedList.add(unsupported);
                }

            }
        } finally {
            if (debug)
                dbg_leave("UnsupportedParser.parse");
        }

        return unsupportedList;
    }

    
}

