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
/*******************************************
 * PRODUCT OF PT INOVACAO - EST DEPARTMENT *
 *******************************************/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PAssertedIdentity;
import gov.nist.javax.sip.header.ims.PAssertedIdentityList;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PAssertedIdentityParser extends AddressParametersParser implements TokenTypes {

    /**
     * Constructor
     * @param assertedIdentity -  message to parse to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.074 -0500", hash_original_method = "C02C6F9EBCA71551D8AF330F3F45B00C", hash_generated_method = "CA679919BC5CD4241CF65888D47DD19F")
    
public PAssertedIdentityParser(String assertedIdentity) {
        super(assertedIdentity);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.076 -0500", hash_original_method = "EBF7927CE1D82A95913A99D5074781DB", hash_generated_method = "0446E9C19D94405F80ABC11CAAB1E212")
    
protected PAssertedIdentityParser(Lexer lexer) {
        super(lexer);

    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.084 -0500", hash_original_method = "F1FB2D5EE9E961EE6E5DF8A2F520567C", hash_generated_method = "31419CB40B1D2D413322EF8FDC4D5DBE")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("AssertedIdentityParser.parse");

        PAssertedIdentityList assertedIdList = new PAssertedIdentityList();

        try {

            headerName(TokenTypes.P_ASSERTED_IDENTITY);

            PAssertedIdentity pai = new PAssertedIdentity();
            pai.setHeaderName(SIPHeaderNamesIms.P_ASSERTED_IDENTITY);

            super.parse(pai);
            assertedIdList.add(pai);

            this.lexer.SPorHT();
            while (lexer.lookAhead(0) == ',')
            {
                this.lexer.match(',');
                this.lexer.SPorHT();

                pai = new PAssertedIdentity();
                super.parse(pai);
                assertedIdList.add(pai);

                this.lexer.SPorHT();
            }
            this.lexer.SPorHT();
            this.lexer.match('\n');

            return assertedIdList;

        }

        finally {
            if (debug)
                dbg_leave("AssertedIdentityParser.parse");
            }
    }

    
}

