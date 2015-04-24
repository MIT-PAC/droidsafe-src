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
import gov.nist.javax.sip.header.ims.Path;
import gov.nist.javax.sip.header.ims.PathList;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PathParser extends AddressParametersParser implements TokenTypes {

    /**
     * Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.156 -0500", hash_original_method = "7A079BF63C48031C1D75ACF959BDA24D", hash_generated_method = "E119292C8F5D62110AF1CE0ACF0B5286")
    
public PathParser(String path) {
        super(path);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.158 -0500", hash_original_method = "91CE1B5A663F1BD7DA26A8D59664C334", hash_generated_method = "CA70901F113022FD0A4D747653931086")
    
protected PathParser(Lexer lexer) {
        super(lexer);

    }




    /**
     * parse the String message and generate the RecordRoute List Object
     * @return SIPHeader the RecordRoute List object
     * @throws ParseException if errors occur during the parsing
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.161 -0500", hash_original_method = "F1314A453C93E830C24484946DC25942", hash_generated_method = "08FB4211899015991841F25F84138047")
    
public SIPHeader parse() throws ParseException {

        PathList pathList = new PathList();

        if (debug)
            dbg_enter("PathParser.parse");

        try {
            this.lexer.match(TokenTypes.PATH);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            while (true) {
                Path path = new Path();
                super.parse(path);
                pathList.add(path);
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
            return pathList;
        } finally {
            if (debug)
                dbg_leave("PathParser.parse");
        }

    }

    
}

