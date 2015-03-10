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
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.header.RequestLine;

import java.text.ParseException;





public class RequestLineParser extends Parser {

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.469 -0500", hash_original_method = "81D449396CA92A7AD8E004264E406593", hash_generated_method = "DBBA46FA2C859B3EF3FBE0D60D8B4D68")
    
public static void main(String args[]) throws ParseException {
            String requestLines[] = {
                "REGISTER sip:192.168.0.68 SIP/2.0\n",
                "REGISTER sip:company.com SIP/2.0\n",
                "INVITE sip:3660@166.35.231.140 SIP/2.0\n",
                "INVITE sip:user@company.com SIP/2.0\n",
                "REGISTER sip:[2001::1]:5060;transport=tcp SIP/2.0\n", // Added by Daniel J. Martinez Manzano <dani@dif.um.es>
                "REGISTER sip:[2002:800:700:600:30:4:6:1]:5060;transport=udp SIP/2.0\n", // Added by Daniel J. Martinez Manzano <dani@dif.um.es>
                "REGISTER sip:[3ffe:800:700::30:4:6:1]:5060;transport=tls SIP/2.0\n", // Added by Daniel J. Martinez Manzano <dani@dif.um.es>
                "REGISTER sip:[2001:720:1710:0:201:29ff:fe21:f403]:5060;transport=udp SIP/2.0\n",
                "OPTIONS sip:135.180.130.133 SIP/2.0\n" };
            for (int i = 0; i < requestLines.length; i++ ) {
                RequestLineParser rlp =
                  new RequestLineParser(requestLines[i]);
                RequestLine rl = rlp.parse();
                System.out.println("encoded = " + rl.encode());
            }

        }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.461 -0500", hash_original_method = "9E54F2AF74A618ACEB8F17B65C16A48F", hash_generated_method = "2EF319665DA089D9F7AB53A9E02C67CA")
    
public RequestLineParser(String requestLine) {
        this.lexer = new Lexer("method_keywordLexer", requestLine);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.463 -0500", hash_original_method = "A6666834E60C7B51DE2E6BABDAF9B193", hash_generated_method = "D233B63A45EDFB95DFD732BE908C3EB5")
    
public RequestLineParser(Lexer lexer) {
        this.lexer = lexer;
        this.lexer.selectLexer("method_keywordLexer");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.466 -0500", hash_original_method = "3F5CD164E270AAF338C0D4B97DF78E19", hash_generated_method = "B3DA0F50F698C533CAC7A4174C2C4620")
    
public RequestLine parse() throws ParseException {
        if (debug)
            dbg_enter("parse");
        try {
            RequestLine retval = new RequestLine();
            String m = method();
            lexer.SPorHT();
            retval.setMethod(m);
            this.lexer.selectLexer("sip_urlLexer");
            URLParser urlParser = new URLParser(this.getLexer());
            GenericURI url = urlParser.uriReference(true);
            lexer.SPorHT();
            retval.setUri(url);
            this.lexer.selectLexer("request_lineLexer");
            String v = sipVersion();
            retval.setSipVersion(v);
            lexer.SPorHT();
            lexer.match('\n');
            return retval;
        } finally {
            if (debug)
                dbg_leave("parse");
        }
    }

    
}

