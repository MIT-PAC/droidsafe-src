package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.967 -0400", hash_original_method = "259D82B4FB0F930288D81B3FF39234D9", hash_generated_method = "62E82C69DA52DF4188E2B413B56E0050")
    public  ContactParser(String contact) {
        super(contact);
        addTaint(contact.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.967 -0400", hash_original_method = "9392FB11C199E27843D6B36D0194676C", hash_generated_method = "8DED6447CE407CBF72C510D04FB98BF7")
    protected  ContactParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        this.lexer = lexer;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.993 -0400", hash_original_method = "BF729EDB4B0BCD2BE7D180520FE998E8", hash_generated_method = "744BFA2FB489C8A25B861F4527EB88D5")
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.CONTACT);
        ContactList retval = new ContactList();
        while
(true)        
        {
            Contact contact = new Contact();
    if(lexer.lookAhead(0) == '*')            
            {
                final char next = lexer.lookAhead(1);
    if(next == ' ' || next == '\t' || next == '\r' || next == '\n')                
                {
                    this.lexer.match('*');
                    contact.setWildCardFlag(true);
                } 
                else
                {
                    super.parse(contact);
                } 
            } 
            else
            {
                super.parse(contact);
            } 
            retval.add(contact);
            this.lexer.SPorHT();
            char la = lexer.lookAhead(0);
    if(la == ',')            
            {
                this.lexer.match(',');
                this.lexer.SPorHT();
            } 
            else
    if(la == '\n' || la == '\0')            
            break;
            else
            {
            java.text.ParseException var7805DD1445672D84C07E56FCC19D9765_438708580 = createParseException("unexpected char");
            var7805DD1445672D84C07E56FCC19D9765_438708580.addTaint(taint);
            throw var7805DD1445672D84C07E56FCC19D9765_438708580;
            }
        } 
SIPHeader varF9E19AD6135C970F387F77C6F3DE4477_818844199 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_818844199.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_818844199;
        
        
    }

    
}

