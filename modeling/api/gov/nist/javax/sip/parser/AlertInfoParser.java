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
import gov.nist.javax.sip.header.AlertInfo;
import gov.nist.javax.sip.header.AlertInfoList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class AlertInfoParser extends ParametersParser {

    /**
     * Creates a new instance of AlertInfo Parser
     * @param alertInfo  the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.732 -0500", hash_original_method = "D981F7025F52BA8E1CEDC583E21B710C", hash_generated_method = "73D70348B5426E6EBABB75233918596A")
    
public AlertInfoParser(String alertInfo) {
        super(alertInfo);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.735 -0500", hash_original_method = "FBB9329DBFDB9634284D1CD105BFF940", hash_generated_method = "C79A8175C763825EB46434CC8CBFE342")
    
protected AlertInfoParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the AlertInfo  String header
     * @return SIPHeader (AlertInfoList  object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.738 -0500", hash_original_method = "01178CDB4B591AEEFEAB9C463FFB7ADD", hash_generated_method = "418D49F31C51CDC7D2171D64670F814D")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("AlertInfoParser.parse");
        AlertInfoList list = new AlertInfoList();

        try {
            headerName(TokenTypes.ALERT_INFO);

            while (lexer.lookAhead(0) != '\n') {
                AlertInfo alertInfo = new AlertInfo();
                alertInfo.setHeaderName(SIPHeaderNames.ALERT_INFO);
                URLParser urlParser;
                GenericURI uri;

                do {
	                this.lexer.SPorHT();
	                if (this.lexer.lookAhead(0) == '<') {
	                    this.lexer.match('<');
	                    urlParser = new URLParser((Lexer) this.lexer);
	                    uri = urlParser.uriReference( true );
	                    alertInfo.setAlertInfo(uri);
	                    this.lexer.match('>');
	                } else {
	                	/* This is non standard for Polycom support. 
	                	 * I know it is bad grammar but please do not remove. mranga 
	                	 */
	                	String alertInfoStr = this.lexer.byteStringNoSemicolon();
	                	alertInfo.setAlertInfo(alertInfoStr);
	                }
	                	
	                this.lexer.SPorHT();
	
	                super.parse(alertInfo);
	                list.add(alertInfo);
	                
	                if ( lexer.lookAhead(0) == ',' ) {
	                	this.lexer.match(',');
	                } else break;
                } while (true);
            }
            return list;
        } finally {
            if (debug)
                dbg_leave("AlertInfoParser.parse");
        }
    }

    
}

