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
import gov.nist.javax.sip.header.ErrorInfo;
import gov.nist.javax.sip.header.ErrorInfoList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class ErrorInfoParser extends ParametersParser {

    /**
     * Creates a new instance of ErrorInfoParser
     * @param errorInfo the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.997 -0500", hash_original_method = "5AFF5330EA4A2771143BBB17EF4E79AC", hash_generated_method = "78E52953AC1E5604BF9C3F2A580E0082")
    
public ErrorInfoParser(String errorInfo) {
        super(errorInfo);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.000 -0500", hash_original_method = "8F205A65B870DAE08BD525603424E427", hash_generated_method = "AA9562D41C05A7B0A724CBC57A219E55")
    
protected ErrorInfoParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the ErrorInfo String header
     * @return SIPHeader (ErrorInfoList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.003 -0500", hash_original_method = "A1D86D832E01EE0ED40EBBDB518014BA", hash_generated_method = "A6F4EBCC052261AD4E1FC5AB5064FB3F")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("ErrorInfoParser.parse");
        ErrorInfoList list = new ErrorInfoList();

        try {
            headerName(TokenTypes.ERROR_INFO);

            while (lexer.lookAhead(0) != '\n') {
            	do {
	                ErrorInfo errorInfo = new ErrorInfo();
	                errorInfo.setHeaderName(SIPHeaderNames.ERROR_INFO);
	
	                this.lexer.SPorHT();
	                this.lexer.match('<');
	                URLParser urlParser = new URLParser((Lexer) this.lexer);
	                GenericURI uri = urlParser.uriReference( true );
	                errorInfo.setErrorInfo(uri);
	                this.lexer.match('>');
	                this.lexer.SPorHT();
	
	                super.parse(errorInfo);
	                list.add(errorInfo);
	                
	                if ( lexer.lookAhead(0) == ',' ) {
	                	this.lexer.match(',');
	                } else break;
            	} while (true);
            }

            return list;
        } finally {
            if (debug)
                dbg_leave("ErrorInfoParser.parse");
        }
    }

    
}

