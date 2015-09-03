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
import gov.nist.core.NameValue;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PChargingFunctionAddresses;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.ParametersParser;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PChargingFunctionAddressesParser extends ParametersParser implements TokenTypes {






    /** Test program */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.213 -0500", hash_original_method = "C775BDC9F3E1BDD0956086FF7A6B9FE1", hash_generated_method = "77A4000D5E4B0EB1242736CCFCFCDD77")
    
public static void main(String args[]) throws ParseException {
        String r[] = {
                "P-Charging-Function-Addresses: ccf=\"test str\"; ecf=token\n",
                "P-Charging-Function-Addresses: ccf=192.1.1.1; ccf=192.1.1.2; ecf=192.1.1.3; ecf=192.1.1.4\n",
                "P-Charging-Function-Addresses: ccf=[5555::b99:c88:d77:e66]; ccf=[5555::a55:b44:c33:d22]; " +
                     "ecf=[5555::1ff:2ee:3dd:4cc]; ecf=[5555::6aa:7bb:8cc:9dd]\n"

                };


        for (int i = 0; i < r.length; i++ )
        {

            PChargingFunctionAddressesParser parser =
              new PChargingFunctionAddressesParser(r[i]);

            System.out.println("original = " + r[i]);

            PChargingFunctionAddresses chargAddr= (PChargingFunctionAddresses) parser.parse();
            System.out.println("encoded = " + chargAddr.encode());
        }


    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.202 -0500", hash_original_method = "E6802C10162BF9ECF1CA7A726DBBAC6F", hash_generated_method = "39BE0B93FA1F650B6852076B33964BA3")
    
public PChargingFunctionAddressesParser(String charging) {

        super(charging);


    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.205 -0500", hash_original_method = "D9D24A0C312DDEF7581D0ED53212D170", hash_generated_method = "7534ED3F210ADC1A2EF5F18D04A2468D")
    
protected PChargingFunctionAddressesParser(Lexer lexer) {
        super(lexer);

    }



    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.208 -0500", hash_original_method = "5C436260248E496F94134402F46D8C6D", hash_generated_method = "E205AA126AFD9CEA60126F5192010F00")
    
public SIPHeader parse() throws ParseException {


        if (debug)
            dbg_enter("parse");
        try {
            headerName(TokenTypes.P_CHARGING_FUNCTION_ADDRESSES);
            PChargingFunctionAddresses chargingFunctionAddresses = new PChargingFunctionAddresses();

            try {
                while (lexer.lookAhead(0) != '\n') {

                    this.parseParameter(chargingFunctionAddresses);
                    this.lexer.SPorHT();
                    char la = lexer.lookAhead(0);
                    if (la == '\n' || la == '\0')
                        break;

                    this.lexer.match(';');
                    this.lexer.SPorHT();
                }
            } catch (ParseException ex) {
                throw ex;
            }


            super.parse(chargingFunctionAddresses);
            return chargingFunctionAddresses;
        } finally {
            if (debug)
                dbg_leave("parse");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.210 -0500", hash_original_method = "E7DC882A60F6AF0A0416E9B2C1439960", hash_generated_method = "4F78F7C88D53E8B6F534612AC883B078")
    
protected void parseParameter(PChargingFunctionAddresses chargingFunctionAddresses) throws ParseException {

        if (debug)
            dbg_enter("parseParameter");
        try {

            NameValue nv = this.nameValue('=');
             
            //chargingFunctionAddresses.setParameter(nv);
            chargingFunctionAddresses.setMultiParameter(nv);

        } finally {
            if (debug)
                dbg_leave("parseParameter");
        }



    }

    
}

