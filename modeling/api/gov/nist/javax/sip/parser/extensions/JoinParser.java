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
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.parser.extensions;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.extensions.Join;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.ParametersParser;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;





public class JoinParser extends ParametersParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.739 -0500", hash_original_method = "5B969B355337FA1F212D31D5CF92C127", hash_generated_method = "70BC1B3E2C4EAED3F625297CB867B2BF")
    
public static void main(String args[]) throws ParseException {
        String to[] =
            {   "Join: 12345th5z8z\n",
                "Join: 12345th5z8z;to-tag=tozght6-45;from-tag=fromzght789-337-2\n",
            };

        for (int i = 0; i < to.length; i++) {
            JoinParser tp = new JoinParser(to[i]);
            Join t = (Join) tp.parse();
            System.out.println("Parsing => " + to[i]);
            System.out.print("encoded = " + t.encode() + "==> ");
            System.out.println("callId " + t.getCallId() + " from-tag=" + t.getFromTag()
                    + " to-tag=" + t.getToTag()) ;

        }
    }

    /**
     * Creates new CallIDParser
     * @param callID message to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.731 -0500", hash_original_method = "EF4712E80A9A6595AD0A1CEA8AD509AD", hash_generated_method = "86CEEDE71FFD7D8241C3FB62BCD64C0C")
    
public JoinParser(String callID) {
        super(callID);
    }

    /**
     * Constructor
     * @param lexer Lexer to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.734 -0500", hash_original_method = "C3C0BEC6FC6BFB3701BC82718709C143", hash_generated_method = "8BA3D7B60FAC74C6F644CB3534F1B42E")
    
protected JoinParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (CallID object)
     * @throws ParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.737 -0500", hash_original_method = "66B10ECC601C3201E5F156FEACCA3B45", hash_generated_method = "DB91D5D8E3B28E068975F092C74FBBF7")
    
public SIPHeader parse() throws ParseException {
        if (debug)
            dbg_enter("parse");
        try {
            headerName(TokenTypes.JOIN_TO);

            Join join = new Join();
            this.lexer.SPorHT();
            String callId = lexer.byteStringNoSemicolon();
            this.lexer.SPorHT();
            super.parse(join);
            join.setCallId(callId);
            return join;
        } finally {
            if (debug)
                dbg_leave("parse");
        }
    }

    
}

