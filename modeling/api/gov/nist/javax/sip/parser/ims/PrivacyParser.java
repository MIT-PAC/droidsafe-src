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
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.Privacy;
import gov.nist.javax.sip.header.ims.PrivacyList;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;
import gov.nist.javax.sip.parser.HeaderParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PrivacyParser extends HeaderParser implements TokenTypes {


    /** Test program */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.844 -0500", hash_original_method = "F91DB731CF24DA9E3E2F5684453D2459", hash_generated_method = "3AB5FDE092DACA9A0F1C16F409861211")
    
public static void main(String args[]) throws ParseException
    {
        String rou[] = {

                "Privacy: none\n",
                "Privacy: none;id;user\n"
            };

        for (int i = 0; i < rou.length; i++ ) {
            PrivacyParser rp =
              new PrivacyParser(rou[i]);
            PrivacyList list = (PrivacyList) rp.parse();
            System.out.println("encoded = " +list.encode());
        }
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.836 -0500", hash_original_method = "1B46B2A155C790BA09FFD6B4EE4B1531", hash_generated_method = "E5D6672E8CB56B53A9E18D6EC9D94BB9")
    
public PrivacyParser(String privacyType) {

        super(privacyType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.839 -0500", hash_original_method = "4EC8E3CAF2B7BCDD5010285F1AA3D090", hash_generated_method = "DFEC70CFD3F07B0233C8601E873BA0C2")
    
protected PrivacyParser(Lexer lexer) {

        super(lexer);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.841 -0500", hash_original_method = "8BE7913EB9359A0AA04D67D7439E50B1", hash_generated_method = "8D3FCDE70624A88DB35C97E8715F8F66")
    
public SIPHeader parse() throws ParseException
    {
        if (debug)
            dbg_enter("PrivacyParser.parse");

        PrivacyList privacyList = new PrivacyList();

        try
        {
            this.headerName(TokenTypes.PRIVACY);

            while (lexer.lookAhead(0) != '\n') {
                this.lexer.SPorHT();

                Privacy privacy = new Privacy();
                privacy.setHeaderName(SIPHeaderNamesIms.PRIVACY);

                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                privacy.setPrivacy(token.getTokenValue());
                this.lexer.SPorHT();
                privacyList.add(privacy);

                // Parsing others option-tags
                while (lexer.lookAhead(0) == ';')
                {
                    this.lexer.match(';');
                    this.lexer.SPorHT();
                    privacy = new Privacy();
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    privacy.setPrivacy(token.getTokenValue());
                    this.lexer.SPorHT();

                    privacyList.add(privacy);
                }
            }

            return privacyList;

        }
        finally {
            if (debug)
                dbg_leave("PrivacyParser.parse");
        }

    }

    
}

