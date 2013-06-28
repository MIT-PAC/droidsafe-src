package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PAssertedIdentity;
import gov.nist.javax.sip.header.ims.PAssertedIdentityList;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;
import gov.nist.javax.sip.parser.AddressParametersParser;

public class PAssertedIdentityParser extends AddressParametersParser implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.097 -0400", hash_original_method = "C02C6F9EBCA71551D8AF330F3F45B00C", hash_generated_method = "CAB075B76C2EEE3FDBCE822C4D4678EC")
    public  PAssertedIdentityParser(String assertedIdentity) {
        super(assertedIdentity);
        addTaint(assertedIdentity.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.097 -0400", hash_original_method = "EBF7927CE1D82A95913A99D5074781DB", hash_generated_method = "8FBB134D8A84A5466095E6E0DF4AFDC2")
    protected  PAssertedIdentityParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.099 -0400", hash_original_method = "F1FB2D5EE9E961EE6E5DF8A2F520567C", hash_generated_method = "24FD967E86B3628746332EB896B31CAA")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_179376980 = null; //Variable for return #1
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
            {
                boolean var3D7F80AAA4BB4C7E5B5AFC820C1FE6A4_648992408 = (lexer.lookAhead(0) == ',');
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    pai = new PAssertedIdentity();
                    super.parse(pai);
                    assertedIdList.add(pai);
                    this.lexer.SPorHT();
                } //End block
            } //End collapsed parenthetic
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_179376980 = assertedIdList;
        } //End block
        finally 
        {
            dbg_leave("AssertedIdentityParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_179376980.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_179376980;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

