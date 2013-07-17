package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.address.*;
import java.text.ParseException;

public class AddressParser extends Parser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.783 -0400", hash_original_method = "DDF0B6D19753B0F457279892E29569BE", hash_generated_method = "9CF4E18F46F9477751A9430799FE22E0")
    public  AddressParser(Lexer lexer) {
        addTaint(lexer.getTaint());
        this.lexer = lexer;
        this.lexer.selectLexer("charLexer");
        // ---------- Original Method ----------
        //this.lexer = lexer;
        //this.lexer.selectLexer("charLexer");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.783 -0400", hash_original_method = "8E6C25B6D8313F3B657F98EEF90351BF", hash_generated_method = "538555F0FD76922F7C0E34D896811AA5")
    public  AddressParser(String address) {
        addTaint(address.getTaint());
        this.lexer = new Lexer("charLexer", address);
        // ---------- Original Method ----------
        //this.lexer = new Lexer("charLexer", address);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.784 -0400", hash_original_method = "FFACB1FB21E7531199E63E4BDFD4B5B1", hash_generated_method = "3B9535151151F87ED173304732590D7B")
    protected AddressImpl nameAddr() throws ParseException {
        if(debug)        
        dbg_enter("nameAddr");
        try 
        {
            if(this.lexer.lookAhead(0) == '<')            
            {
                this.lexer.consume(1);
                this.lexer.selectLexer("sip_urlLexer");
                this.lexer.SPorHT();
                URLParser uriParser = new URLParser((Lexer) lexer);
                GenericURI uri = uriParser.uriReference( true );
                AddressImpl retval = new AddressImpl();
                retval.setAddressType(AddressImpl.NAME_ADDR);
                retval.setURI(uri);
                this.lexer.SPorHT();
                this.lexer.match('>');
AddressImpl varF9E19AD6135C970F387F77C6F3DE4477_1953754297 =                 retval;
                varF9E19AD6135C970F387F77C6F3DE4477_1953754297.addTaint(taint);
                return varF9E19AD6135C970F387F77C6F3DE4477_1953754297;
            } //End block
            else
            {
                AddressImpl addr = new AddressImpl();
                addr.setAddressType(AddressImpl.NAME_ADDR);
                String name = null;
                if(this.lexer.lookAhead(0) == '\"')                
                {
                    name = this.lexer.quotedString();
                    this.lexer.SPorHT();
                } //End block
                else
                name = this.lexer.getNextToken('<');
                addr.setDisplayName(name.trim());
                this.lexer.match('<');
                this.lexer.SPorHT();
                URLParser uriParser = new URLParser((Lexer) lexer);
                GenericURI uri = uriParser.uriReference( true );
                AddressImpl retval = new AddressImpl();
                addr.setAddressType(AddressImpl.NAME_ADDR);
                addr.setURI(uri);
                this.lexer.SPorHT();
                this.lexer.match('>');
AddressImpl var93F8352EAB50DBA73F526833D82E48F9_308186321 =                 addr;
                var93F8352EAB50DBA73F526833D82E48F9_308186321.addTaint(taint);
                return var93F8352EAB50DBA73F526833D82E48F9_308186321;
            } //End block
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("nameAddr");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.835 -0400", hash_original_method = "54D730AA0CABE4752468E1C28394616F", hash_generated_method = "A97FA07FE4B02A425BC9C62C6675A31F")
    public AddressImpl address( boolean inclParams ) throws ParseException {
        addTaint(inclParams);
        if(debug)        
        dbg_enter("address");
        AddressImpl retval = null;
        try 
        {
            int k = 0;
            while
(lexer.hasMoreChars())            
            {
                char la = lexer.lookAhead(k);
                if(la == '<'
                    || la == '\"'
                    || la == ':'
                    || la == '/')                
                break;
                else
                if(la == '\0')                
                {
                java.text.ParseException var4390C3D320844ED1F93A77298641D1E3_32426035 = createParseException("unexpected EOL");
                var4390C3D320844ED1F93A77298641D1E3_32426035.addTaint(taint);
                throw var4390C3D320844ED1F93A77298641D1E3_32426035;
                }
                else
                k++;
            } //End block
            char la = lexer.lookAhead(k);
            if(la == '<' || la == '\"')            
            {
                retval = nameAddr();
            } //End block
            else
            if(la == ':' || la == '/')            
            {
                retval = new AddressImpl();
                URLParser uriParser = new URLParser((Lexer) lexer);
                GenericURI uri = uriParser.uriReference( inclParams );
                retval.setAddressType(AddressImpl.ADDRESS_SPEC);
                retval.setURI(uri);
            } //End block
            else
            {
                java.text.ParseException var5F5CE0795A70A5AC40069B1ABF759F3E_2079730790 = createParseException("Bad address spec");
                var5F5CE0795A70A5AC40069B1ABF759F3E_2079730790.addTaint(taint);
                throw var5F5CE0795A70A5AC40069B1ABF759F3E_2079730790;
            } //End block
AddressImpl varF9E19AD6135C970F387F77C6F3DE4477_140574339 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_140574339.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_140574339;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("address");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

