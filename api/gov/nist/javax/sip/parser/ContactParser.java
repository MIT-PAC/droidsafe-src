package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.javax.sip.header.Contact;
import gov.nist.javax.sip.header.ContactList;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ContactParser extends AddressParametersParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.998 -0400", hash_original_method = "259D82B4FB0F930288D81B3FF39234D9", hash_generated_method = "62E82C69DA52DF4188E2B413B56E0050")
    public  ContactParser(String contact) {
        super(contact);
        addTaint(contact.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.000 -0400", hash_original_method = "9392FB11C199E27843D6B36D0194676C", hash_generated_method = "8DED6447CE407CBF72C510D04FB98BF7")
    protected  ContactParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        this.lexer = lexer;
        // ---------- Original Method ----------
        //this.lexer = lexer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.029 -0400", hash_original_method = "BF729EDB4B0BCD2BE7D180520FE998E8", hash_generated_method = "5788053FED6764E185A19D4D98CBD189")
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
                } //End block
                else
                {
                    super.parse(contact);
                } //End block
            } //End block
            else
            {
                super.parse(contact);
            } //End block
            retval.add(contact);
            this.lexer.SPorHT();
            char la = lexer.lookAhead(0);
            if(la == ',')            
            {
                this.lexer.match(',');
                this.lexer.SPorHT();
            } //End block
            else
            if(la == '\n' || la == '\0')            
            break;
            else
            {
            java.text.ParseException var7805DD1445672D84C07E56FCC19D9765_1855768501 = createParseException("unexpected char");
            var7805DD1445672D84C07E56FCC19D9765_1855768501.addTaint(taint);
            throw var7805DD1445672D84C07E56FCC19D9765_1855768501;
            }
        } //End block
SIPHeader varF9E19AD6135C970F387F77C6F3DE4477_793656613 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_793656613.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_793656613;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

