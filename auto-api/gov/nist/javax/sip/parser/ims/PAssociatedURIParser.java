package gov.nist.javax.sip.parser.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.106 -0400", hash_original_method = "0CDE275ECCBEF2889E9182D2465C2E20", hash_generated_method = "AAA76F953DE189B56CE0BA684D5A584B")
    public  PAssociatedURIParser(String associatedURI) {
        super(associatedURI);
        addTaint(associatedURI.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.106 -0400", hash_original_method = "70EC41EF34A2E6E96E3702280780921E", hash_generated_method = "88BF51253EB3690D123C074323173C5F")
    protected  PAssociatedURIParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.106 -0400", hash_original_method = "DA45542244416E40599094AA9DB4C3E3", hash_generated_method = "73ECCF3F354DA69AA95A8D9FDB52CD6A")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1103661305 = null; 
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
            {
                boolean var3D7F80AAA4BB4C7E5B5AFC820C1FE6A4_765099945 = (lexer.lookAhead(0) == ',');
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    associatedURI = new PAssociatedURI();
                    super.parse(associatedURI);
                    associatedURIList.add(associatedURI);
                    this.lexer.SPorHT();
                } 
            } 
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_1103661305 = associatedURIList;
        } 
        finally 
        {
            dbg_leave("PAssociatedURIParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1103661305.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1103661305;
        
        
    }

    
}

