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
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.address.GenericURI;

import java.text.ParseException;





public class AddressParser extends Parser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.562 -0500", hash_original_method = "DDF0B6D19753B0F457279892E29569BE", hash_generated_method = "438ED40881F1D015EA63BEE9986FED07")
    
public AddressParser(Lexer lexer) {
        this.lexer = lexer;
        this.lexer.selectLexer("charLexer");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.565 -0500", hash_original_method = "8E6C25B6D8313F3B657F98EEF90351BF", hash_generated_method = "E237B9B2DD37CCD3FF8ACD8455EFCC59")
    
public AddressParser(String address) {
        this.lexer = new Lexer("charLexer", address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.568 -0500", hash_original_method = "FFACB1FB21E7531199E63E4BDFD4B5B1", hash_generated_method = "9DE2C0DBF104708B50E4C9823F465F9F")
    
protected AddressImpl nameAddr() throws ParseException {
        if (debug)
            dbg_enter("nameAddr");
        try {
            if (this.lexer.lookAhead(0) == '<') {
                this.lexer.consume(1);
                this.lexer.selectLexer("sip_urlLexer");
                this.lexer.SPorHT();
                URLParser uriParser = new URLParser((Lexer) lexer);
                GenericURI uri = uriParser.uriReference( true );
                AddressImpl retval = new AddressImpl();
                retval.setAddressType(AddressImpl.NAME_ADDR);
                retval.setURI(uri);
                this.lexer.SPorHT();
                this.lexer.match('>');
                return retval;
            } else {
                AddressImpl addr = new AddressImpl();
                addr.setAddressType(AddressImpl.NAME_ADDR);
                String name = null;
                if (this.lexer.lookAhead(0) == '\"') {
                    name = this.lexer.quotedString();
                    this.lexer.SPorHT();
                } else
                    name = this.lexer.getNextToken('<');
                addr.setDisplayName(name.trim());
                this.lexer.match('<');
                this.lexer.SPorHT();
                URLParser uriParser = new URLParser((Lexer) lexer);
                GenericURI uri = uriParser.uriReference( true );
                AddressImpl retval = new AddressImpl();
                addr.setAddressType(AddressImpl.NAME_ADDR);
                addr.setURI(uri);
                this.lexer.SPorHT();
                this.lexer.match('>');
                return addr;
            }
        } finally {
            if (debug)
                dbg_leave("nameAddr");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.571 -0500", hash_original_method = "54D730AA0CABE4752468E1C28394616F", hash_generated_method = "EA4E294D1FF4943145F6E701E5452666")
    
public AddressImpl address( boolean inclParams ) throws ParseException {
        if (debug)
            dbg_enter("address");
        AddressImpl retval = null;
        try {
            int k = 0;
            while (lexer.hasMoreChars()) {
                char la = lexer.lookAhead(k);
                if (la == '<'
                    || la == '\"'
                    || la == ':'
                    || la == '/')
                    break;
                else if (la == '\0')
                    throw createParseException("unexpected EOL");
                else
                    k++;
            }
            char la = lexer.lookAhead(k);
            if (la == '<' || la == '\"') {
                retval = nameAddr();
            } else if (la == ':' || la == '/') {
                retval = new AddressImpl();
                URLParser uriParser = new URLParser((Lexer) lexer);
                GenericURI uri = uriParser.uriReference( inclParams );
                retval.setAddressType(AddressImpl.ADDRESS_SPEC);
                retval.setURI(uri);
            } else {
                throw createParseException("Bad address spec");
            }
            return retval;
        } finally {
            if (debug)
                dbg_leave("address");
        }

    }

    
}

