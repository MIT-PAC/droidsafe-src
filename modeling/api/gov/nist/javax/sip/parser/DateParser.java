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
import gov.nist.javax.sip.header.SIPDateHeader;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;
import java.util.Calendar;





public class DateParser extends HeaderParser {

    /**
     * Constructor
     * @param date message to parse to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.153 -0500", hash_original_method = "12ABECDC99786B59BCBD31A7419E2B41", hash_generated_method = "ECCFDAF9B606FB989CE4A5FB21DBB820")
    
public DateParser(String date) {
        super(date);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.155 -0500", hash_original_method = "00ADBDEF8E181F85BEA9DD7E552A7849", hash_generated_method = "AC46BE51628B2FCF6492970FB346582D")
    
protected DateParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * Parse method.
     * @throws ParseException
     * @return  the parsed Date header/
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.158 -0500", hash_original_method = "6D964EF3409A9BCD4AB46A00BDF7E85B", hash_generated_method = "07439D077D477A511AA7AA5CDCA06833")
    
public SIPHeader parse() throws ParseException {
        if (debug)
            dbg_enter("DateParser.parse");
        try {
            headerName(TokenTypes.DATE);
            wkday();
            lexer.match(',');
            lexer.match(' ');
            Calendar cal = date();
            lexer.match(' ');
            time(cal);
            lexer.match(' ');
            String tzone = this.lexer.ttoken().toLowerCase();
            if (!"gmt".equals(tzone))
                throw createParseException("Bad Time Zone " + tzone);
            this.lexer.match('\n');
            SIPDateHeader retval = new SIPDateHeader();
            retval.setDate(cal);
            return retval;
        } finally {
            if (debug)
                dbg_leave("DateParser.parse");

        }

    }

    
}

