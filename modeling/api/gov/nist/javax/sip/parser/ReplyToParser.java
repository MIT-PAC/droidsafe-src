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
import gov.nist.javax.sip.header.ReplyTo;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class ReplyToParser extends AddressParametersParser {

    /**
     * Creates a new instance of ReplyToParser
     * @param replyTo the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.448 -0500", hash_original_method = "9C582C13750EA226F05F84BEF0F6DC1F", hash_generated_method = "B88DE28F9B47FE06D3B19C7105D84DBE")
    
public ReplyToParser(String replyTo) {
        super(replyTo);
    }

    /**
     * Cosntructor
     * param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.451 -0500", hash_original_method = "967233BE7821B2A8956B876F99751025", hash_generated_method = "1A1CFEB064023FAEA3BDDED8D5C52AA2")
    
protected ReplyToParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message and generate the ReplyTo List Object
     * @return SIPHeader the ReplyTo List object
     * @throws SIPParseException if errors occur during the parsing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.453 -0500", hash_original_method = "92CC6877DF7B50AD61B75778CFB22735", hash_generated_method = "44EAD4A20182A38DB6FCBEBB6380CA34")
    
public SIPHeader parse() throws ParseException {
        ReplyTo replyTo = new ReplyTo();
        if (debug)
            dbg_enter("ReplyTo.parse");

        try {
            headerName(TokenTypes.REPLY_TO);

            replyTo.setHeaderName(SIPHeaderNames.REPLY_TO);

            super.parse(replyTo);

            return replyTo;
        } finally {
            if (debug)
                dbg_leave("ReplyTo.parse");
        }

    }

    
}

