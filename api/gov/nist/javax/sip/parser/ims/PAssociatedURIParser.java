package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.878 -0400", hash_original_method = "0CDE275ECCBEF2889E9182D2465C2E20", hash_generated_method = "AAA76F953DE189B56CE0BA684D5A584B")
    public  PAssociatedURIParser(String associatedURI) {
        super(associatedURI);
        addTaint(associatedURI.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.879 -0400", hash_original_method = "70EC41EF34A2E6E96E3702280780921E", hash_generated_method = "88BF51253EB3690D123C074323173C5F")
    protected  PAssociatedURIParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.880 -0400", hash_original_method = "DA45542244416E40599094AA9DB4C3E3", hash_generated_method = "747FB3C3AD5E2589988550D1D9F990E9")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("PAssociatedURIParser.parse");
        PAssociatedURIList associatedURIList = new PAssociatedURIList();
        try 
        {
            headerName(TokenTypes.P_ASSOCIATED_URI);
            PAssociatedURI associatedURI = new PAssociatedURI();
            associatedURI.setHeaderName(SIPHeaderNamesIms.P_ASSOCIATED_URI);
            super.parse(associatedURI);
            associatedURIList.add(associatedURI);
            this.lexer.SPorHT();
            while
(lexer.lookAhead(0) == ',')            
            {
                this.lexer.match(',');
                this.lexer.SPorHT();
                associatedURI = new PAssociatedURI();
                super.parse(associatedURI);
                associatedURIList.add(associatedURI);
                this.lexer.SPorHT();
            } //End block
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader varDDC6C1063316592341175724BFC64CC4_685073802 =             associatedURIList;
            varDDC6C1063316592341175724BFC64CC4_685073802.addTaint(taint);
            return varDDC6C1063316592341175724BFC64CC4_685073802;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("PAssociatedURIParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

