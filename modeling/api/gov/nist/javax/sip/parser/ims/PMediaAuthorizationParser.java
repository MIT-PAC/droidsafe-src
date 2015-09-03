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
import gov.nist.javax.sip.header.ims.PMediaAuthorization;
import gov.nist.javax.sip.header.ims.PMediaAuthorizationList;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;
import gov.nist.javax.sip.parser.HeaderParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;



public class PMediaAuthorizationParser extends HeaderParser implements TokenTypes {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.116 -0500", hash_original_method = "FCF1A64239185FEE2932A543D4AD92F3", hash_generated_method = "7076EF27D1A806996BF96E20BCFDDDAB")
    
public PMediaAuthorizationParser(String mediaAuthorization)
    {
        super(mediaAuthorization);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.119 -0500", hash_original_method = "D716B8B267E7C915523592278E20949F", hash_generated_method = "9CB0257D27E600B178817B419E9D596A")
    
public PMediaAuthorizationParser(Lexer lexer)
    {
        super(lexer);

    }





    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.122 -0500", hash_original_method = "C50B4E6383FAF29D7342642FAF098C0C", hash_generated_method = "4C19F066CE139EC60B58D83360855BBF")
    
public SIPHeader parse() throws ParseException
    {
        PMediaAuthorizationList mediaAuthorizationList = new PMediaAuthorizationList();

        if (debug)
            dbg_enter("MediaAuthorizationParser.parse");


        try
        {
            headerName(TokenTypes.P_MEDIA_AUTHORIZATION);

            PMediaAuthorization mediaAuthorization = new PMediaAuthorization();
            mediaAuthorization.setHeaderName(SIPHeaderNamesIms.P_MEDIA_AUTHORIZATION);

            while (lexer.lookAhead(0) != '\n')
            {
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                try {
                    mediaAuthorization.setMediaAuthorizationToken(token.getTokenValue());
                } catch (InvalidArgumentException e) {
                    throw createParseException(e.getMessage());
                }
                mediaAuthorizationList.add(mediaAuthorization);

                this.lexer.SPorHT();
                if (lexer.lookAhead(0) == ',')
                {
                    this.lexer.match(',');
                    mediaAuthorization = new PMediaAuthorization();
                }
                this.lexer.SPorHT();
            }

            return mediaAuthorizationList;

        }
        finally
        {
            if (debug)
                dbg_leave("MediaAuthorizationParser.parse");
        }

    }

    
}

