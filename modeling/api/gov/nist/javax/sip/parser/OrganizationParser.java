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
import gov.nist.javax.sip.header.Organization;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class OrganizationParser extends HeaderParser {

    /**
     * Creates a new instance of OrganizationParser
     * @param organization the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.791 -0500", hash_original_method = "549F69CADB3AF439FF99C26DCF97EF61", hash_generated_method = "CEBA3986A95DFF69F8177CC349644074")
    
public OrganizationParser(String organization) {
        super(organization);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.794 -0500", hash_original_method = "5407EA6CAC142FB29C8ECABB6BAE3B2C", hash_generated_method = "412D840A9277F29A5C06FD88841372AC")
    
protected OrganizationParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String header
     * @return SIPHeader (Organization object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.796 -0500", hash_original_method = "FCDFEF7484AB928FBE1CF6D95D3DCFBA", hash_generated_method = "1CE88D580E15AA2C14FFEEDCCCA71471")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("OrganizationParser.parse");
        Organization organization = new Organization();
        try {
            headerName(TokenTypes.ORGANIZATION);

            organization.setHeaderName(SIPHeaderNames.ORGANIZATION);

            this.lexer.SPorHT();
            String value = this.lexer.getRest();

            organization.setOrganization(value.trim());

            return organization;
        } finally {
            if (debug)
                dbg_leave("OrganizationParser.parse");
        }
    }

    
}

