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
import gov.nist.javax.sip.header.ContentDisposition;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class ContentDispositionParser extends ParametersParser {

    /**
     * Creates a new instance of ContentDispositionParser
     * @param contentDisposition the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.284 -0500", hash_original_method = "04008A13B0A5E88C87B63AAF08ED822A", hash_generated_method = "1F99FB9C48EE9EEFAE67593C4664A6F1")
    
public ContentDispositionParser(String contentDisposition) {
        super(contentDisposition);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.288 -0500", hash_original_method = "7D9894E3DD1592FE62F944EB2803724D", hash_generated_method = "AD65E80CA37E68032C8E9C98D5A3DE29")
    
protected ContentDispositionParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the ContentDispositionHeader String header
     * @return SIPHeader (ContentDispositionList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.290 -0500", hash_original_method = "C25B69CBC1412EAEFB170FBF9B530EF5", hash_generated_method = "AD0F03654918E48BE3984210F2815FEB")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("ContentDispositionParser.parse");

        try {
            headerName(TokenTypes.CONTENT_DISPOSITION);

            ContentDisposition cd = new ContentDisposition();
            cd.setHeaderName(SIPHeaderNames.CONTENT_DISPOSITION);

            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);

            Token token = lexer.getNextToken();
            cd.setDispositionType(token.getTokenValue());
            this.lexer.SPorHT();
            super.parse(cd);

            this.lexer.SPorHT();
            this.lexer.match('\n');

            return cd;
        } catch (ParseException ex) {
            throw createParseException(ex.getMessage());
        } finally {
            if (debug)
                dbg_leave("ContentDispositionParser.parse");
        }
    }

    
}

