package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.838 -0400", hash_original_method = "259D82B4FB0F930288D81B3FF39234D9", hash_generated_method = "62E82C69DA52DF4188E2B413B56E0050")
    public  ContactParser(String contact) {
        super(contact);
        addTaint(contact.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.838 -0400", hash_original_method = "9392FB11C199E27843D6B36D0194676C", hash_generated_method = "DAE8656B4427799C90FDB80B47901409")
    protected  ContactParser(Lexer lexer) {
        super(lexer);
        this.lexer = lexer;
        addTaint(lexer.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.839 -0400", hash_original_method = "BF729EDB4B0BCD2BE7D180520FE998E8", hash_generated_method = "C04FCA89C6856E61CC0C00BB760BBB50")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_340753400 = null; 
        headerName(TokenTypes.CONTACT);
        ContactList retval = new ContactList();
        {
            Contact contact = new Contact();
            {
                boolean varEE2545CD66997E09574EFE5DCBF7CEB1_230261532 = (lexer.lookAhead(0) == '*');
                {
                    final char next = lexer.lookAhead(1);
                    {
                        this.lexer.match('*');
                        contact.setWildCardFlag(true);
                    } 
                    {
                        super.parse(contact);
                    } 
                } 
                {
                    super.parse(contact);
                } 
            } 
            retval.add(contact);
            this.lexer.SPorHT();
            char la = lexer.lookAhead(0);
            {
                this.lexer.match(',');
                this.lexer.SPorHT();
            } 
            if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected char");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_340753400 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_340753400.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_340753400;
        
        
    }

    
}

