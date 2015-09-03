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
import gov.nist.core.NameValue;
import gov.nist.javax.sip.header.ParametersHeader;

import java.text.ParseException;





public abstract class ParametersParser extends HeaderParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.119 -0500", hash_original_method = "8DB209633D35B91A05910E58BFF524C0", hash_generated_method = "B4EA7A4D1C53C7F58B65509E918C9523")
    
protected ParametersParser(Lexer lexer) {
        super((Lexer) lexer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.122 -0500", hash_original_method = "1337D3E6D061A128A8E8534FBF59A488", hash_generated_method = "FE9D561B0681BC9D95D2F8D43C9B4368")
    
protected ParametersParser(String buffer) {
        super(buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.125 -0500", hash_original_method = "D7D1ED3794D3EF5845398404979DE69B", hash_generated_method = "CC715EC3C331B152762A1B190636D2C0")
    
protected void parse(ParametersHeader parametersHeader)
        throws ParseException {
        this.lexer.SPorHT();
        while (lexer.lookAhead(0) == ';') {
            this.lexer.consume(1);
            // eat white space
            this.lexer.SPorHT();
            NameValue nv = nameValue();
            parametersHeader.setParameter(nv);
            // eat white space
            this.lexer.SPorHT();
        }
    }



    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.128 -0500", hash_original_method = "F0B8EED12E7201B6D65F9EE76F7129AE", hash_generated_method = "B9F59CBD0CFF38B099A8D6A68132B4CC")
    
protected void parseNameValueList(ParametersHeader parametersHeader)
        throws ParseException{
        parametersHeader.removeParameters();
        while (true) {
                this.lexer.SPorHT();
            NameValue nv = nameValue();
            parametersHeader.setParameter(nv.getName(), (String) nv.getValueAsObject());
            // eat white space
            this.lexer.SPorHT();
            if (lexer.lookAhead(0) != ';')  break;
            else lexer.consume(1);
        }
    }

    
}

