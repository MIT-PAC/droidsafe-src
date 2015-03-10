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
import gov.nist.javax.sip.header.MinExpires;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class MinExpiresParser extends HeaderParser {

    /**
     * Creates a new instance of MinExpiresParser
     * @param minExpires the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.363 -0500", hash_original_method = "958EB85119CB55ADB0187595D23A4161", hash_generated_method = "E55476DDF68DBFC1439A8D56777E9891")
    
public MinExpiresParser(String minExpires) {
        super(minExpires);
    }

    /**
     * Cosntructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.366 -0500", hash_original_method = "C5E703E21CCA5CEB1F1840058DFBE664", hash_generated_method = "1ED21FC5F85A8561A6553F3965D7FD3A")
    
protected MinExpiresParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (MinExpiresParser)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.369 -0500", hash_original_method = "67C1C5FB3D4E718484F296CD0580B923", hash_generated_method = "E4FB769FEDC02FEA8A2364FC8AD6FAE5")
    
public SIPHeader parse() throws ParseException {
        if (debug)
            dbg_enter("MinExpiresParser.parse");
        MinExpires minExpires = new MinExpires();
        try {
            headerName(TokenTypes.MIN_EXPIRES);

            minExpires.setHeaderName(SIPHeaderNames.MIN_EXPIRES);

            String number = this.lexer.number();
            try {
                minExpires.setExpires(Integer.parseInt(number));
            } catch (InvalidArgumentException ex) {
                throw createParseException(ex.getMessage());
            }
            this.lexer.SPorHT();

            this.lexer.match('\n');

            return minExpires;
        } finally {
            if (debug)
                dbg_leave("MinExpiresParser.parse");
        }
    }

    
}

