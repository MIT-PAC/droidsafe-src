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
import gov.nist.javax.sip.header.ReferTo;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class ReferToParser extends AddressParametersParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.331 -0500", hash_original_method = "2053A13A6C8B0A7C36C65FB33978F20E", hash_generated_method = "216B8374DBF52CC8F104076303FEA7E1")
    
public static void main(String args[]) throws ParseException {
        String to[] =
            {   "Refer-To: <sip:dave@denver.example.org?" +
                    "Replaces=12345%40192.168.118.3%3Bto-tag%3D12345%3Bfrom-tag%3D5FFE-3994>\n",
                "Refer-To: <sip:+1-650-555-2222@ss1.wcom.com;user=phone>;tag=5617\n",
                "Refer-To: T. A. Watson <sip:watson@bell-telephone.com>\n",
                "Refer-To: LittleGuy <sip:UserB@there.com>\n",
                "Refer-To: sip:mranga@120.6.55.9\n",
                "Refer-To: sip:mranga@129.6.55.9 ; tag=696928473514.129.6.55.9\n" };

        for (int i = 0; i < to.length; i++) {
            ReferToParser tp = new ReferToParser(to[i]);
            ReferTo t = (ReferTo) tp.parse();
            System.out.println("encoded = " + t.encode());

        }
    }

    /**
     * Creates new ToParser
     * @param referTo String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.323 -0500", hash_original_method = "DF57B31FD2F05C7FE41E5F087EC0A031", hash_generated_method = "7DD2A6F62050298BE8BEB3B929920E23")
    
public ReferToParser(String referTo) {
        super(referTo);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.326 -0500", hash_original_method = "78341A496A4C46C460D57FED9263DC9D", hash_generated_method = "7F196ECC4AAD804F008EDA77606A9377")
    
protected ReferToParser(Lexer lexer) {
        super(lexer);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.328 -0500", hash_original_method = "3469BCE5DE818D1E33012B0295E9EC56", hash_generated_method = "57A42D89FA80A44525740E8A6DBBCBF7")
    
public SIPHeader parse() throws ParseException {

        headerName(TokenTypes.REFER_TO);
        ReferTo referTo = new ReferTo();
        super.parse(referTo);
        this.lexer.match('\n');
        return referTo;
    }

    
}

