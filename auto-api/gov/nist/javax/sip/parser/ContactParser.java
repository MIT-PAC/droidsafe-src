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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.617 -0400", hash_original_method = "259D82B4FB0F930288D81B3FF39234D9", hash_generated_method = "62E82C69DA52DF4188E2B413B56E0050")
    public  ContactParser(String contact) {
        super(contact);
        addTaint(contact.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.617 -0400", hash_original_method = "9392FB11C199E27843D6B36D0194676C", hash_generated_method = "DAE8656B4427799C90FDB80B47901409")
    protected  ContactParser(Lexer lexer) {
        super(lexer);
        this.lexer = lexer;
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
        //this.lexer = lexer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.632 -0400", hash_original_method = "BF729EDB4B0BCD2BE7D180520FE998E8", hash_generated_method = "0ACFA7550F1F5B6A68ADE41F1BF94847")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_491928360 = null; //Variable for return #1
        headerName(TokenTypes.CONTACT);
        ContactList retval;
        retval = new ContactList();
        {
            Contact contact;
            contact = new Contact();
            {
                boolean varEE2545CD66997E09574EFE5DCBF7CEB1_2048070413 = (lexer.lookAhead(0) == '*');
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
        varB4EAC82CA7396A68D541C85D26508E83_491928360 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_491928360.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_491928360;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

