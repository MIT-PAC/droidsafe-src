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
import gov.nist.javax.sip.header.Route;
import gov.nist.javax.sip.header.RouteList;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class RouteParser extends AddressParametersParser {

    /**
     * Constructor
     * @param route message to parse to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.550 -0500", hash_original_method = "DFF32A898CEC13D94295FA47E9C2EAB3", hash_generated_method = "17AEE4635166A568E66ACB92B9E2737B")
    
public RouteParser(String route) {
        super(route);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.553 -0500", hash_original_method = "65EBCE19E35091936305B392D8A407A4", hash_generated_method = "98E9130EB13A843499A914C9155B8783")
    
protected RouteParser(Lexer lexer) {
        super(lexer);
    }

    /** parse the String message and generate the Route List Object
     * @return SIPHeader the Route List object
     * @throws SIPParseException if errors occur during the parsing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.556 -0500", hash_original_method = "E0D86A54342F3A96677BD3492DB07E61", hash_generated_method = "3BC2E46FCD45BBF5CB5F5ACFF64F945A")
    
public SIPHeader parse() throws ParseException {
        RouteList routeList = new RouteList();
        if (debug)
            dbg_enter("parse");

        try {
            this.lexer.match(TokenTypes.ROUTE);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            while (true) {
                Route route = new Route();
                super.parse(route);
                routeList.add(route);
                this.lexer.SPorHT();
                char la = lexer.lookAhead(0);
                if (la == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } else if (la == '\n')
                    break;
                else
                    throw createParseException("unexpected char");
            }
            return routeList;
        } finally {
            if (debug)
                dbg_leave("parse");
        }

    }

    
}

