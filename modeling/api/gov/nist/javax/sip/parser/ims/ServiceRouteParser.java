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
 * PRODUCT OF PT INOVAO - EST DEPARTMENT *
 *******************************************/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.ServiceRoute;
import gov.nist.javax.sip.header.ims.ServiceRouteList;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class ServiceRouteParser extends AddressParametersParser {

    /**
     * Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.378 -0500", hash_original_method = "C37E1CF835BF2C15063590E48C1460DA", hash_generated_method = "91A3AC21788F4F2D74D630BBAC81C226")
    
public ServiceRouteParser(String serviceRoute) {
        super(serviceRoute);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.381 -0500", hash_original_method = "2EF38FE2F98AC9040691FDDD49315448", hash_generated_method = "F725CBBE4C5294C57AEDE6D3999AC866")
    
protected ServiceRouteParser(Lexer lexer) {
        super(lexer);

    }




    /**
     * parse the String message and generate the RecordRoute List Object
     * @return SIPHeader the RecordRoute List object
     * @throws ParseException if errors occur during the parsing
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.384 -0500", hash_original_method = "8017C6E265731C6E1BE6E337AC0EFE2E", hash_generated_method = "4B7330DFC58E357A5D1DD143C737CB5A")
    
public SIPHeader parse() throws ParseException {
        ServiceRouteList serviceRouteList = new ServiceRouteList();

        if (debug)
            dbg_enter("ServiceRouteParser.parse");

        try {
            this.lexer.match(TokenTypes.SERVICE_ROUTE);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            while (true) {
                ServiceRoute serviceRoute = new ServiceRoute();
                super.parse(serviceRoute);
                serviceRouteList.add(serviceRoute);
                this.lexer.SPorHT();
                if (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } else if (lexer.lookAhead(0) == '\n')
                    break;
                else
                    throw createParseException("unexpected char");
            }
            return serviceRouteList;
        } finally {
            if (debug)
                dbg_leave("ServiceRouteParser.parse");
        }

    }

    
}

