package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PAssociatedURI;
import gov.nist.javax.sip.header.ims.PAssociatedURIList;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PAssociatedURIParser extends AddressParametersParser {


    /**
     * Constructor
     * @param associatedURI content to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.488 -0500", hash_original_method = "0CDE275ECCBEF2889E9182D2465C2E20", hash_generated_method = "D0C51406978AC83AFFC376A393F1BB06")
    
public PAssociatedURIParser(String associatedURI)
    {
        super(associatedURI);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.490 -0500", hash_original_method = "70EC41EF34A2E6E96E3702280780921E", hash_generated_method = "DB2AD2C5DDADD4A522DF0B6DC4D4C658")
    
protected PAssociatedURIParser(Lexer lexer)
    {
        super(lexer);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.493 -0500", hash_original_method = "DA45542244416E40599094AA9DB4C3E3", hash_generated_method = "16265A4F02ED17136076FB834F41A985")
    
public SIPHeader parse() throws ParseException
    {
        if (debug)
            dbg_enter("PAssociatedURIParser.parse");

        PAssociatedURIList associatedURIList = new PAssociatedURIList();

        try {

            headerName(TokenTypes.P_ASSOCIATED_URI);

            PAssociatedURI associatedURI = new PAssociatedURI();
            associatedURI.setHeaderName(SIPHeaderNamesIms.P_ASSOCIATED_URI);

            super.parse(associatedURI);
            associatedURIList.add(associatedURI);

            this.lexer.SPorHT();
            while (lexer.lookAhead(0) == ',')
            {
                this.lexer.match(',');
                this.lexer.SPorHT();

                associatedURI = new PAssociatedURI();
                super.parse(associatedURI);
                associatedURIList.add(associatedURI);

                this.lexer.SPorHT();
            }
            this.lexer.SPorHT();
            this.lexer.match('\n');

            return associatedURIList;




        } finally {
            if (debug)
                dbg_leave("PAssociatedURIParser.parse");
        }

    }

    
}

