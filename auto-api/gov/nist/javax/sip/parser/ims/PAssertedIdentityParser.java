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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.753 -0400", hash_original_method = "C02C6F9EBCA71551D8AF330F3F45B00C", hash_generated_method = "55E351415263B2A81F96FC81DE83CC7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAssertedIdentityParser(String assertedIdentity) {
        super(assertedIdentity);
        dsTaint.addTaint(assertedIdentity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.753 -0400", hash_original_method = "EBF7927CE1D82A95913A99D5074781DB", hash_generated_method = "D0C230B83D5C0B8680BEE1CFA3AEC2C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PAssertedIdentityParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.754 -0400", hash_original_method = "F1FB2D5EE9E961EE6E5DF8A2F520567C", hash_generated_method = "BCF2C6D708478E3A9586F5D88749B8A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("AssertedIdentityParser.parse");
        PAssertedIdentityList assertedIdList;
        assertedIdList = new PAssertedIdentityList();
        try 
        {
            headerName(TokenTypes.P_ASSERTED_IDENTITY);
            PAssertedIdentity pai;
            pai = new PAssertedIdentity();
            pai.setHeaderName(SIPHeaderNamesIms.P_ASSERTED_IDENTITY);
            super.parse(pai);
            assertedIdList.add(pai);
            this.lexer.SPorHT();
            {
                boolean var3D7F80AAA4BB4C7E5B5AFC820C1FE6A4_1677293644 = (lexer.lookAhead(0) == ',');
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
        } //End block
        finally 
        {
            dbg_leave("AssertedIdentityParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

