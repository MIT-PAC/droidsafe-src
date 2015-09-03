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
import gov.nist.javax.sip.header.ContentLength;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class ContentLengthParser extends HeaderParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.319 -0500", hash_original_method = "2F7FB6593647B33547E0EB2E18989DF0", hash_generated_method = "9C4D9DFFC0D1C1A9DE2B069DC4A89968")
    
public ContentLengthParser(String contentLength) {
        super(contentLength);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.321 -0500", hash_original_method = "BB8498A5FB1634FA5C58AED3E6D59F31", hash_generated_method = "D98DAEFA9621F4E5A91CEA9558233A9C")
    
protected ContentLengthParser(Lexer lexer) {
        super(lexer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.324 -0500", hash_original_method = "E65999CBE5EA336AB02A5D9A8E9D84DC", hash_generated_method = "25E385F97A85801C0AE631B0027124C2")
    
public SIPHeader parse() throws ParseException {
        if (debug)
            dbg_enter("ContentLengthParser.enter");
        try {
            ContentLength contentLength = new ContentLength();
            headerName(TokenTypes.CONTENT_LENGTH);
            String number = this.lexer.number();
            contentLength.setContentLength(Integer.parseInt(number));
            this.lexer.SPorHT();
            this.lexer.match('\n');
            return contentLength;
        } catch (InvalidArgumentException ex) {
            throw createParseException(ex.getMessage());
        } catch (NumberFormatException ex) {
            throw createParseException(ex.getMessage());
        } finally {
            if (debug)
                dbg_leave("ContentLengthParser.leave");
        }
    }

    
}

