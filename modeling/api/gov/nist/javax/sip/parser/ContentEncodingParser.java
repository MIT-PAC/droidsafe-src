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
import gov.nist.javax.sip.header.ContentEncoding;
import gov.nist.javax.sip.header.ContentEncodingList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class ContentEncodingParser extends HeaderParser {

    /**
     * Creates a new instance of ContentEncodingParser
     * @param contentEncoding the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.960 -0500", hash_original_method = "025E1AD213DC2532673CB1D1FC75B1CC", hash_generated_method = "AF9BD842838DEB26BE1BF73447B9C978")
    
public ContentEncodingParser(String contentEncoding) {
        super(contentEncoding);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.963 -0500", hash_original_method = "15007428AB3C93C7C47122E74B782E26", hash_generated_method = "4F38E4650F7DEAEE468A52EC2980675D")
    
protected ContentEncodingParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the ContentEncodingHeader String header
     * @return SIPHeader (ContentEncodingList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.966 -0500", hash_original_method = "8ACC6861A4ACA970AEBA8CCFE6984687", hash_generated_method = "7B1E5B53927553375DCF3987967EF71D")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("ContentEncodingParser.parse");
        ContentEncodingList list = new ContentEncodingList();

        try {
            headerName(TokenTypes.CONTENT_ENCODING);

            while (lexer.lookAhead(0) != '\n') {
                ContentEncoding cl = new ContentEncoding();
                cl.setHeaderName(SIPHeaderNames.CONTENT_ENCODING);

                this.lexer.SPorHT();
                this.lexer.match(TokenTypes.ID);

                Token token = lexer.getNextToken();
                cl.setEncoding(token.getTokenValue());

                this.lexer.SPorHT();
                list.add(cl);

                while (lexer.lookAhead(0) == ',') {
                    cl = new ContentEncoding();
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    this.lexer.match(TokenTypes.ID);
                    this.lexer.SPorHT();
                    token = lexer.getNextToken();
                    cl.setEncoding(token.getTokenValue());
                    this.lexer.SPorHT();
                    list.add(cl);
                }
            }

            return list;
        } catch (ParseException ex) {
            throw createParseException(ex.getMessage());
        } finally {
            if (debug)
                dbg_leave("ContentEncodingParser.parse");
        }
    }

    
}

