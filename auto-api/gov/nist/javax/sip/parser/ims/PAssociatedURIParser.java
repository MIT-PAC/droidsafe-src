package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.core.Token;
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.header.ims.PAssociatedURI;
import gov.nist.javax.sip.header.ims.PAssociatedURIList;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;
import gov.nist.javax.sip.header.Allow;
import gov.nist.javax.sip.header.ErrorInfo;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.URLParser;
import gov.nist.javax.sip.parser.ParametersParser;
import gov.nist.javax.sip.parser.HeaderParser;

public class PAssociatedURIParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.756 -0400", hash_original_method = "0CDE275ECCBEF2889E9182D2465C2E20", hash_generated_method = "8D1F1299C018A1BD7FD81C6FA276D2A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAssociatedURIParser(String associatedURI) {
        super(associatedURI);
        dsTaint.addTaint(associatedURI);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.756 -0400", hash_original_method = "70EC41EF34A2E6E96E3702280780921E", hash_generated_method = "66A1D31E121EC0AC35F0D28CAAE0A8A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PAssociatedURIParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.756 -0400", hash_original_method = "DA45542244416E40599094AA9DB4C3E3", hash_generated_method = "EC6DD9792B09E1B44B6D63C473FF0B9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("PAssociatedURIParser.parse");
        PAssociatedURIList associatedURIList;
        associatedURIList = new PAssociatedURIList();
        try 
        {
            headerName(TokenTypes.P_ASSOCIATED_URI);
            PAssociatedURI associatedURI;
            associatedURI = new PAssociatedURI();
            associatedURI.setHeaderName(SIPHeaderNamesIms.P_ASSOCIATED_URI);
            super.parse(associatedURI);
            associatedURIList.add(associatedURI);
            this.lexer.SPorHT();
            {
                boolean var3D7F80AAA4BB4C7E5B5AFC820C1FE6A4_755247230 = (lexer.lookAhead(0) == ',');
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    associatedURI = new PAssociatedURI();
                    super.parse(associatedURI);
                    associatedURIList.add(associatedURI);
                    this.lexer.SPorHT();
                } //End block
            } //End collapsed parenthetic
            this.lexer.SPorHT();
            this.lexer.match('\n');
        } //End block
        finally 
        {
            dbg_leave("PAssociatedURIParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

