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
 * of the terms of this agreement.
 *
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.Contact;
import gov.nist.javax.sip.header.ContactList;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class ContactParser extends AddressParametersParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.172 -0500", hash_original_method = "259D82B4FB0F930288D81B3FF39234D9", hash_generated_method = "6C2338917ADBD9862616BB6F9F7CCFD0")
    
public ContactParser(String contact) {
        super(contact);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.175 -0500", hash_original_method = "9392FB11C199E27843D6B36D0194676C", hash_generated_method = "1A92A3DD89FBD6056B534A01EEB952EE")
    
protected ContactParser(Lexer lexer) {
        super(lexer);
        this.lexer = lexer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.178 -0500", hash_original_method = "BF729EDB4B0BCD2BE7D180520FE998E8", hash_generated_method = "1DFECB54643C6C64A61087679BA4EDFE")
    
public SIPHeader parse() throws ParseException {
        // past the header name and the colon.
        headerName(TokenTypes.CONTACT);
        ContactList retval = new ContactList();
        while (true) {
            Contact contact = new Contact();
            if (lexer.lookAhead(0) == '*') {
                final char next = lexer.lookAhead(1);
                if (next == ' ' || next == '\t' || next == '\r' || next == '\n') {
                    this.lexer.match('*');
                    contact.setWildCardFlag(true);
                } else {
                    super.parse(contact);
                }
            } else {
                super.parse(contact);
            }
            retval.add(contact);
            this.lexer.SPorHT();
            char la = lexer.lookAhead(0);
            if (la == ',') {
                this.lexer.match(',');
                this.lexer.SPorHT();
            } else if (la == '\n' || la == '\0')
                break;
            else
                throw createParseException("unexpected char");
        }
        return retval;
    }

    
}

