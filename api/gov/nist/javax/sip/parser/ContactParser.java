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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.819 -0500", hash_original_method = "259D82B4FB0F930288D81B3FF39234D9", hash_generated_method = "6C2338917ADBD9862616BB6F9F7CCFD0")
    public ContactParser(String contact) {
        super(contact);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.820 -0500", hash_original_method = "9392FB11C199E27843D6B36D0194676C", hash_generated_method = "1A92A3DD89FBD6056B534A01EEB952EE")
    protected ContactParser(Lexer lexer) {
        super(lexer);
        this.lexer = lexer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.822 -0500", hash_original_method = "BF729EDB4B0BCD2BE7D180520FE998E8", hash_generated_method = "1DFECB54643C6C64A61087679BA4EDFE")
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

