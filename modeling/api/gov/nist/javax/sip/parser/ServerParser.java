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
import gov.nist.javax.sip.header.Server;

import java.text.ParseException;





public class ServerParser extends HeaderParser {

    /**
     * Creates a new instance of ServerParser
     * @param server the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.413 -0500", hash_original_method = "34ED7286D2A920D6CAAB19B69F1E2272", hash_generated_method = "A3A9DCA8F9A15F41B8A594761AC6AC9B")
    
public ServerParser(String server) {
        super(server);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.416 -0500", hash_original_method = "D6FF2C5B569C35FFD38E06BDFF6C27A4", hash_generated_method = "534724306C9EF4ABB5A0DE79B21507A8")
    
protected ServerParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String server
     * @return SIPHeader (Server object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.419 -0500", hash_original_method = "F7C094FE7E8356B9E6B34E820636D434", hash_generated_method = "127D5A8E6D4BFFA2632A9B26A95B3888")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("ServerParser.parse");
        Server server = new Server();
        try {
            headerName(TokenTypes.SERVER);
            if (this.lexer.lookAhead(0) == '\n')
                throw createParseException("empty header");

            //  mandatory token: product[/product-version] | (comment)
            while (this.lexer.lookAhead(0) != '\n'
                && this.lexer.lookAhead(0) != '\0') {
                if (this.lexer.lookAhead(0) == '(') {
                    String comment = this.lexer.comment();
                    server.addProductToken('(' + comment + ')');
                } else {
                    String tok;
                    int marker = 0;
                    try {
                        marker = this.lexer.markInputPosition();
                        tok = this.lexer.getString('/');

                        if (tok.charAt(tok.length() - 1) == '\n')
                            tok = tok.trim();
                        server.addProductToken(tok);
                    } catch (ParseException ex) {
                        this.lexer.rewindInputPosition(marker);
                        tok = this.lexer.getRest().trim();
                        server.addProductToken(tok);
                        break;
                    }
                }
            }

        } finally {
            if (debug)
                dbg_leave("ServerParser.parse");
        }

        return server;
    }

    
}

