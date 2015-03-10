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
import gov.nist.javax.sip.header.MimeVersion;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class MimeVersionParser extends HeaderParser {

    /**
     * Creates a new instance of MimeVersionParser
     * @param mimeVersion the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.553 -0500", hash_original_method = "25EDC565C62A5EB92B68AF9D2AE96AEA", hash_generated_method = "51200390BBF441DEE63E131BE870C15B")
    
public MimeVersionParser(String mimeVersion) {
        super(mimeVersion);
    }

    /**
     * Cosntructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.556 -0500", hash_original_method = "931DCFE817B53A973ED5D85AA9B55841", hash_generated_method = "2503BB1D1913D5F776009D687E3F6086")
    
protected MimeVersionParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (MimeVersion object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.559 -0500", hash_original_method = "5451311C0FC76A3AF05558D3E031ACC9", hash_generated_method = "FE186EAE434EB3A5D7066811DBEC7D9B")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("MimeVersionParser.parse");
        MimeVersion mimeVersion = new MimeVersion();
        try {
            headerName(TokenTypes.MIME_VERSION);

            mimeVersion.setHeaderName(SIPHeaderNames.MIME_VERSION);

            try {
                String majorVersion = this.lexer.number();
                mimeVersion.setMajorVersion(Integer.parseInt(majorVersion));
                this.lexer.match('.');
                String minorVersion = this.lexer.number();
                mimeVersion.setMinorVersion(Integer.parseInt(minorVersion));

            } catch (InvalidArgumentException ex) {
                throw createParseException(ex.getMessage());
            }
            this.lexer.SPorHT();

            this.lexer.match('\n');

            return mimeVersion;
        } finally {
            if (debug)
                dbg_leave("MimeVersionParser.parse");
        }
    }

    
}

