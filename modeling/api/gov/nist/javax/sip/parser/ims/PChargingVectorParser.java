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
import gov.nist.javax.sip.header.ims.PChargingVector;
import gov.nist.javax.sip.header.ims.ParameterNamesIms;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.ParametersParser;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PChargingVectorParser extends ParametersParser implements TokenTypes {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.261 -0500", hash_original_method = "A4A88DE0006B5603CC0F71572978ABEB", hash_generated_method = "96732BBFCC82750F5383FA3F864C4181")
    
public PChargingVectorParser(String chargingVector) {

        super(chargingVector);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.264 -0500", hash_original_method = "73E61A8E6B9D3F4F5811815C202485DB", hash_generated_method = "3A6F5ECA4043411C8051DE3F3C15D307")
    
protected PChargingVectorParser(Lexer lexer) {

        super(lexer);

    }



    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.267 -0500", hash_original_method = "4152406B40F94995C7A2549F5DE1C3E9", hash_generated_method = "11FFE0ABB2A8145D720507108B9B7673")
    
public SIPHeader parse() throws ParseException {


        if (debug)
            dbg_enter("parse");
        try {
            headerName(TokenTypes.P_VECTOR_CHARGING);
            PChargingVector chargingVector = new PChargingVector();

            try {
                while (lexer.lookAhead(0) != '\n') {
                    this.parseParameter(chargingVector);
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


            super.parse(chargingVector);
            if ( chargingVector.getParameter(ParameterNamesIms.ICID_VALUE) == null )
                throw new ParseException("Missing a required Parameter : " + ParameterNamesIms.ICID_VALUE, 0);
            return chargingVector;
        } finally {
            if (debug)
                dbg_leave("parse");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.270 -0500", hash_original_method = "E5BADA3ECE6E53AAFFF871A13AE56E77", hash_generated_method = "E3B6AA992A01B7A0B76051AD76C8A80D")
    
protected void parseParameter(PChargingVector chargingVector) throws ParseException {

        if (debug)
            dbg_enter("parseParameter");
        try {
            NameValue nv = this.nameValue('=');
            chargingVector.setParameter(nv);
        } finally {
            if (debug)
                dbg_leave("parseParameter");
        }



    }

    
}

