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
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.Subject;

import java.text.ParseException;





public class SubjectParser extends HeaderParser {

    /**
     * Creates a new instance of SubjectParser
     * @param subject the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.523 -0500", hash_original_method = "9E40B472DD9B461ACD98BE83100C34CB", hash_generated_method = "6CE253272E113F090E23F22A83149CD1")
    
public SubjectParser(String subject) {
        super(subject);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.525 -0500", hash_original_method = "105C510EC26F8BC32BFFFC46FA511F27", hash_generated_method = "70AF6E45538F134B3DE5717DF9E91913")
    
protected SubjectParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (Subject object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.528 -0500", hash_original_method = "F2D8E65DBCC7717EF7411B874638ABFB", hash_generated_method = "9A93F1DB537FA91FD6F040A691AADCE3")
    
public SIPHeader parse() throws ParseException {
        Subject subject = new Subject();
        if (debug)
            dbg_enter("SubjectParser.parse");

        try {
            headerName(TokenTypes.SUBJECT);

            this.lexer.SPorHT();

            String s = this.lexer.getRest();
            subject.setSubject(s.trim());

        } finally {
            if (debug)
                dbg_leave("SubjectParser.parse");
        }

        return subject;
    }

    
}

