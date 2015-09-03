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
/************************************************************************************************
 * PRODUCT OF PT INOVACAO - EST DEPARTMENT and Telecommunications Institute (Aveiro, Portugal)  *
 ************************************************************************************************/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.NameValue;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PAccessNetworkInfo;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;
import gov.nist.javax.sip.parser.HeaderParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PAccessNetworkInfoParser extends HeaderParser implements TokenTypes {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.340 -0500", hash_original_method = "6DB4AD794C60B8862A83AFB0C9C82A92", hash_generated_method = "960DD40D8B0EFCA08D0C8B036F4B827B")
    
public PAccessNetworkInfoParser(String accessNetwork) {

        super(accessNetwork);

    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.343 -0500", hash_original_method = "3B0D9C588403AF5495F889BAEC6E0FEE", hash_generated_method = "FDC0497ADED185D8FDAB60A275375039")
    
protected PAccessNetworkInfoParser(Lexer lexer) {
        super(lexer);

    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.346 -0500", hash_original_method = "0BB1DE6FBD7AB2CBAE3BF43510D39D52", hash_generated_method = "DDF76B56C03A40D5E75E3774146FF54D")
    
public SIPHeader parse() throws ParseException
    {

        if (debug)
            dbg_enter("AccessNetworkInfoParser.parse");
        try {
            headerName(TokenTypes.P_ACCESS_NETWORK_INFO);
            PAccessNetworkInfo accessNetworkInfo = new PAccessNetworkInfo();
            accessNetworkInfo.setHeaderName(SIPHeaderNamesIms.P_ACCESS_NETWORK_INFO);

            this.lexer.SPorHT();
            lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            accessNetworkInfo.setAccessType(token.getTokenValue());

            this.lexer.SPorHT();
            while (lexer.lookAhead(0) == ';') {
                this.lexer.match(';');
                this.lexer.SPorHT();

                NameValue nv = super.nameValue('=');
                accessNetworkInfo.setParameter(nv);
                this.lexer.SPorHT();
            }
            this.lexer.SPorHT();
            this.lexer.match('\n');


            return accessNetworkInfo;
        } finally {
            if (debug)
                dbg_leave("AccessNetworkInfoParser.parse");
        }

    }

    
}

