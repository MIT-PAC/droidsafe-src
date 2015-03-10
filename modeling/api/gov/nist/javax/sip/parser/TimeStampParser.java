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
import gov.nist.javax.sip.header.SIPHeaderNames;
import gov.nist.javax.sip.header.TimeStamp;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class TimeStampParser extends HeaderParser {

    /**
     * Creates a new instance of TimeStampParser
     * @param timeStamp the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.074 -0500", hash_original_method = "11301E3D259A26B05B62DD42A72B1913", hash_generated_method = "D1724525721DB5F537A5B61C1E9561A4")
    
public TimeStampParser(String timeStamp) {
        super(timeStamp);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.077 -0500", hash_original_method = "ABAA3B4AC330CE8F23110008CB442301", hash_generated_method = "E93F98310B569E946D308E3FD924F807")
    
protected TimeStampParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (TimeStamp object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.081 -0500", hash_original_method = "2B179D27AA0FC8FCF5481D4095B4030E", hash_generated_method = "814C1C407F98A217222553107A0898F8")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("TimeStampParser.parse");
        TimeStamp timeStamp = new TimeStamp();
        try {
            headerName(TokenTypes.TIMESTAMP);

            timeStamp.setHeaderName(SIPHeaderNames.TIMESTAMP);

            this.lexer.SPorHT();
            String firstNumber = this.lexer.number();

            try {

                if (lexer.lookAhead(0) == '.') {
                    this.lexer.match('.');
                    String secondNumber = this.lexer.number();

                    String s = firstNumber + "." + secondNumber;
                    float ts = Float.parseFloat(s);
                    timeStamp.setTimeStamp(ts);
                } else {
                    long ts = Long.parseLong(firstNumber);
                    timeStamp.setTime(ts);
                }


            } catch (NumberFormatException ex) {
                throw createParseException(ex.getMessage());
            } catch (InvalidArgumentException ex) {
                throw createParseException(ex.getMessage());
            }

            this.lexer.SPorHT();
            if (lexer.lookAhead(0) != '\n') {
                firstNumber = this.lexer.number();

                try {

                    if (lexer.lookAhead(0) == '.') {
                        this.lexer.match('.');
                        String secondNumber = this.lexer.number();

                        String s = firstNumber + "." + secondNumber;
                        float ts = Float.parseFloat(s);
                        timeStamp.setDelay(ts);
                    } else {
                        int ts = Integer.parseInt(firstNumber);
                        timeStamp.setDelay(ts);
                    }


                } catch (NumberFormatException ex) {
                    throw createParseException(ex.getMessage());
                } catch (InvalidArgumentException ex) {
                    throw createParseException(ex.getMessage());
                }
            }

        } finally {
            if (debug)
                dbg_leave("TimeStampParser.parse");
        }

        return timeStamp;
    }

    
}

