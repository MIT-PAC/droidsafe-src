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
/*
 * ContentTypeParser.java
 *
 * Created on February 26, 2002, 2:42 PM
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.ContentType;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class ContentTypeParser extends ParametersParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.354 -0500", hash_original_method = "AC2B50BA9F98FE0D35E93AB411532CED", hash_generated_method = "8853D48156FDF97CCE04CBAD97151AFA")
    
public ContentTypeParser(String contentType) {
        super(contentType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.357 -0500", hash_original_method = "9BAC92854D082DF9DDE50098E692CCEB", hash_generated_method = "4B830429CB4DA676244A8943495CA499")
    
protected ContentTypeParser(Lexer lexer) {
        super(lexer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.360 -0500", hash_original_method = "8AB392911FDE1F0164CFD7A5CB623621", hash_generated_method = "53101BC80A8F7CB589F7ED4DF56D64D5")
    
public SIPHeader parse() throws ParseException {

        ContentType contentType = new ContentType();
        if (debug)
            dbg_enter("ContentTypeParser.parse");

        try {
            this.headerName(TokenTypes.CONTENT_TYPE);

            // The type:
            lexer.match(TokenTypes.ID);
            Token type = lexer.getNextToken();
            this.lexer.SPorHT();
            contentType.setContentType(type.getTokenValue());

            // The sub-type:
            lexer.match('/');
            lexer.match(TokenTypes.ID);
            Token subType = lexer.getNextToken();
            this.lexer.SPorHT();
            contentType.setContentSubType(subType.getTokenValue());
            super.parse(contentType);
            this.lexer.match('\n');
        } finally {
            if (debug)
                dbg_leave("ContentTypeParser.parse");
        }
        return contentType;

    }

    
}

