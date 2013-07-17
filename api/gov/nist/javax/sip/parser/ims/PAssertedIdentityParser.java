package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PAssertedIdentity;
import gov.nist.javax.sip.header.ims.PAssertedIdentityList;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;
import gov.nist.javax.sip.parser.AddressParametersParser;

public class PAssertedIdentityParser extends AddressParametersParser implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.866 -0400", hash_original_method = "C02C6F9EBCA71551D8AF330F3F45B00C", hash_generated_method = "CAB075B76C2EEE3FDBCE822C4D4678EC")
    public  PAssertedIdentityParser(String assertedIdentity) {
        super(assertedIdentity);
        addTaint(assertedIdentity.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.866 -0400", hash_original_method = "EBF7927CE1D82A95913A99D5074781DB", hash_generated_method = "8FBB134D8A84A5466095E6E0DF4AFDC2")
    protected  PAssertedIdentityParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.867 -0400", hash_original_method = "F1FB2D5EE9E961EE6E5DF8A2F520567C", hash_generated_method = "6B01C5F756ACECC53826F7DB00401214")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("AssertedIdentityParser.parse");
        PAssertedIdentityList assertedIdList = new PAssertedIdentityList();
        try 
        {
            headerName(TokenTypes.P_ASSERTED_IDENTITY);
            PAssertedIdentity pai = new PAssertedIdentity();
            pai.setHeaderName(SIPHeaderNamesIms.P_ASSERTED_IDENTITY);
            super.parse(pai);
            assertedIdList.add(pai);
            this.lexer.SPorHT();
            while
(lexer.lookAhead(0) == ',')            
            {
                this.lexer.match(',');
                this.lexer.SPorHT();
                pai = new PAssertedIdentity();
                super.parse(pai);
                assertedIdList.add(pai);
                this.lexer.SPorHT();
            } //End block
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader varA71E01B4BE13127DBE4088ADB6E3CDAB_3774202 =             assertedIdList;
            varA71E01B4BE13127DBE4088ADB6E3CDAB_3774202.addTaint(taint);
            return varA71E01B4BE13127DBE4088ADB6E3CDAB_3774202;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("AssertedIdentityParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

