package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PAssertedIdentity;
import gov.nist.javax.sip.header.ims.PAssertedIdentityList;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PAssertedIdentityParser extends AddressParametersParser implements TokenTypes {

    /**
     * Constructor
     * @param assertedIdentity -  message to parse to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.316 -0500", hash_original_method = "C02C6F9EBCA71551D8AF330F3F45B00C", hash_generated_method = "CA679919BC5CD4241CF65888D47DD19F")
    public PAssertedIdentityParser(String assertedIdentity) {
        super(assertedIdentity);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.317 -0500", hash_original_method = "EBF7927CE1D82A95913A99D5074781DB", hash_generated_method = "0446E9C19D94405F80ABC11CAAB1E212")
    protected PAssertedIdentityParser(Lexer lexer) {
        super(lexer);

    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.318 -0500", hash_original_method = "F1FB2D5EE9E961EE6E5DF8A2F520567C", hash_generated_method = "31419CB40B1D2D413322EF8FDC4D5DBE")
    public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("AssertedIdentityParser.parse");

        PAssertedIdentityList assertedIdList = new PAssertedIdentityList();

        try {

            headerName(TokenTypes.P_ASSERTED_IDENTITY);

            PAssertedIdentity pai = new PAssertedIdentity();
            pai.setHeaderName(SIPHeaderNamesIms.P_ASSERTED_IDENTITY);

            super.parse(pai);
            assertedIdList.add(pai);

            this.lexer.SPorHT();
            while (lexer.lookAhead(0) == ',')
            {
                this.lexer.match(',');
                this.lexer.SPorHT();

                pai = new PAssertedIdentity();
                super.parse(pai);
                assertedIdList.add(pai);

                this.lexer.SPorHT();
            }
            this.lexer.SPorHT();
            this.lexer.match('\n');

            return assertedIdList;

        }

        finally {
            if (debug)
                dbg_leave("AssertedIdentityParser.parse");
            }
    }

    
}

