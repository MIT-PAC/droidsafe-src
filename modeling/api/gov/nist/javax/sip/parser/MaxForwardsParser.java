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
import gov.nist.javax.sip.header.MaxForwards;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class MaxForwardsParser extends HeaderParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.032 -0500", hash_original_method = "005E89A999CEFE80041E010521110160", hash_generated_method = "B4643508ECA01382DB745682F05E9AA2")
    
public MaxForwardsParser(String contentLength) {
        super(contentLength);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.035 -0500", hash_original_method = "387C44575196A6CA2DFD9A3719D601C5", hash_generated_method = "653CCD9A1865A2D7CDD60869F61687C8")
    
protected MaxForwardsParser(Lexer lexer) {
        super(lexer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.038 -0500", hash_original_method = "1EF61729E616CF3DAFF49967F4EF386E", hash_generated_method = "AAEF54DC69F49C6F1283A4394E153EF2")
    
public SIPHeader parse() throws ParseException {
        if (debug)
            dbg_enter("MaxForwardsParser.enter");
        try {
            MaxForwards contentLength = new MaxForwards();
            headerName(TokenTypes.MAX_FORWARDS);
            String number = this.lexer.number();
            contentLength.setMaxForwards(Integer.parseInt(number));
            this.lexer.SPorHT();
            this.lexer.match('\n');
            return contentLength;
        } catch (InvalidArgumentException ex) {
            throw createParseException(ex.getMessage());
        } catch (NumberFormatException ex) {
            throw createParseException(ex.getMessage());
        } finally {
            if (debug)
                dbg_leave("MaxForwardsParser.leave");
        }
    }

    
}

