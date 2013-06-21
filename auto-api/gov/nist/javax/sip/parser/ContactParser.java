package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.address.SipUri;
import gov.nist.javax.sip.header.Contact;
import gov.nist.javax.sip.header.ContactList;
import gov.nist.javax.sip.header.SIPHeader;
import javax.sip.address.URI;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Iterator;

public class ContactParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.257 -0400", hash_original_method = "259D82B4FB0F930288D81B3FF39234D9", hash_generated_method = "6F1F663E585F7B5DE41C2F46B919E5FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContactParser(String contact) {
        super(contact);
        dsTaint.addTaint(contact);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.257 -0400", hash_original_method = "9392FB11C199E27843D6B36D0194676C", hash_generated_method = "282499AF7C1D664538020F7EEA6CE4EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ContactParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        this.lexer = lexer;
        // ---------- Original Method ----------
        //this.lexer = lexer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.257 -0400", hash_original_method = "BF729EDB4B0BCD2BE7D180520FE998E8", hash_generated_method = "4A91CFAAFB8B1957B02B3C5E382A02B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.CONTACT);
        ContactList retval;
        retval = new ContactList();
        {
            Contact contact;
            contact = new Contact();
            {
                boolean varEE2545CD66997E09574EFE5DCBF7CEB1_1258065448 = (lexer.lookAhead(0) == '*');
                {
                    char next;
                    next = lexer.lookAhead(1);
                    {
                        this.lexer.match('*');
                        contact.setWildCardFlag(true);
                    } //End block
                    {
                        super.parse(contact);
                    } //End block
                } //End block
                {
                    super.parse(contact);
                } //End block
            } //End collapsed parenthetic
            retval.add(contact);
            this.lexer.SPorHT();
            char la;
            la = lexer.lookAhead(0);
            {
                this.lexer.match(',');
                this.lexer.SPorHT();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected char");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

