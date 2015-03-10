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
import gov.nist.javax.sip.header.ProxyAuthorization;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class ProxyAuthorizationParser extends ChallengeParser {

    /**
     * Constructor
     * @param proxyAuthorization --  header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.116 -0500", hash_original_method = "CDA3ED04E7711730A0C66D18484FDB95", hash_generated_method = "DBB0443BF016DCA27D5FE6F58FF8AC8F")
    
public ProxyAuthorizationParser(String proxyAuthorization) {
        super(proxyAuthorization);
    }

    /**
     * Cosntructor
     * @param Lexer lexer to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.119 -0500", hash_original_method = "0B87CA7A37542B21EADB20D98FA713C9", hash_generated_method = "DC30F8CF0A7C6AE65C54D088EB0BE26A")
    
protected ProxyAuthorizationParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (ProxyAuthenticate object)
     * @throws ParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.122 -0500", hash_original_method = "757B0B5247A462A428C431641FB2F7EC", hash_generated_method = "01D5C22C4DBCD3465D3B96462517B329")
    
public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.PROXY_AUTHORIZATION);
        ProxyAuthorization proxyAuth = new ProxyAuthorization();
        super.parse(proxyAuth);
        return proxyAuth;
    }

    
}

