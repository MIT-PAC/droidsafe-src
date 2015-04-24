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
/****************************************************************************
 * PRODUCT OF PT INOVACAO - EST DEPARTMENT and Aveiro University (Portugal) *
 ****************************************************************************/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PCalledPartyID;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PCalledPartyIDParser extends AddressParametersParser {


    /**
     * Constructor
     * @param calledPartyID content to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.303 -0500", hash_original_method = "5A210D10F0DA09D81C9A40BA3A0E0BA0", hash_generated_method = "66A8FA36A0BE912E2ADBDD75A95B6D6E")
    
public PCalledPartyIDParser(String calledPartyID)
    {
        super(calledPartyID);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.306 -0500", hash_original_method = "A63723B4A16B3DEC36752AB85CAA4736", hash_generated_method = "22E86D98B90E722D62114E5933F00E10")
    
protected PCalledPartyIDParser(Lexer lexer)
    {
        super(lexer);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.309 -0500", hash_original_method = "C43CF84ED746DD134AB177C7FEFB3286", hash_generated_method = "4358D3325089A8632047E3720C843C52")
    
public SIPHeader parse() throws ParseException
    {

        if (debug)
            dbg_enter("PCalledPartyIDParser.parse");

        try {
            this.lexer.match(TokenTypes.P_CALLED_PARTY_ID);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();

            PCalledPartyID calledPartyID = new PCalledPartyID();
            super.parse(calledPartyID);

            return calledPartyID;

        } finally {
            if (debug)
                dbg_leave("PCalledPartyIDParser.parse");
        }

    }

    
}

