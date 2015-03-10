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
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;

import java.text.ParseException;





public class AddressParametersParser extends ParametersParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.782 -0500", hash_original_method = "C3BA12083B7F74793C4F2E2FB3C1DB43", hash_generated_method = "32C575E0B6268B101B0077F16A99F56C")
    
protected AddressParametersParser(Lexer lexer) {
        super(lexer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.785 -0500", hash_original_method = "D3B3C15A6507A072481DABC46CDC9E97", hash_generated_method = "529CAB5982D0D39B47DFD01EDBEDDBF6")
    
protected AddressParametersParser(String buffer) {
        super(buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.788 -0500", hash_original_method = "CAB6813880E3A34B3347219ABB88ECB8", hash_generated_method = "A2A5470D439F3076CF9501A7A3EF357C")
    
protected void parse(AddressParametersHeader addressParametersHeader)
        throws ParseException {
        dbg_enter("AddressParametersParser.parse");
        try {
            AddressParser addressParser = new AddressParser(this.getLexer());
            AddressImpl addr = addressParser.address(false);
            addressParametersHeader.setAddress(addr);
            lexer.SPorHT();
            char la = this.lexer.lookAhead(0);
            if ( this.lexer.hasMoreChars() &&
                 la != '\0' &&
                 la != '\n' &&
                 this.lexer.startsId()) {

                 super.parseNameValueList(addressParametersHeader);


            }  else super.parse(addressParametersHeader);

        } catch (ParseException ex) {
            throw ex;
        } finally {
            dbg_leave("AddressParametersParser.parse");
        }
    }

    
}

