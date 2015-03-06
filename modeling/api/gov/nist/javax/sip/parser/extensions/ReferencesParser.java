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
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.parser.extensions;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.extensions.References;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.ParametersParser;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;





public class ReferencesParser extends ParametersParser {
    /**
     * Creates a new instance of ReferencesParser
     * @param references the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.779 -0500", hash_original_method = "25FD33E3054230667E9A8F92C1B17418", hash_generated_method = "4F53B863B4D61FA5B305775BC5B25700")
    
public ReferencesParser(String references) {
        super(references);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.783 -0500", hash_original_method = "CBAD07AA72F20B2B658D118EA3760591", hash_generated_method = "7DFE3E76B9365A4260A24EA0FDC3A7F5")
    
protected ReferencesParser(Lexer lexer) {
        super(lexer);
    }
    
    /**
     * parse the String message
     * @return SIPHeader (ReasonParserList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.785 -0500", hash_original_method = "9AD39421D9E40B39389DA2F4797EEA52", hash_generated_method = "C59DF26F3281D6CFC9A274DDA88BFD72")
    
public SIPHeader parse() throws ParseException {
       
        if (debug)
            dbg_enter("ReasonParser.parse");

        try {
            headerName(TokenTypes.REFERENCES);
            References references= new References();
            this.lexer.SPorHT();
               
            String callId = lexer.byteStringNoSemicolon();
           
            references.setCallId(callId);
            super.parse(references);
            return references;
       } finally {
            if (debug)
                dbg_leave("ReferencesParser.parse");
        }

      
    }

    
}

