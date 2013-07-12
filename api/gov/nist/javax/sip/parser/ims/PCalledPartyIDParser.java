package gov.nist.javax.sip.parser.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.header.ims.PCalledPartyID;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import gov.nist.javax.sip.parser.AddressParametersParser;

public class PCalledPartyIDParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.057 -0400", hash_original_method = "5A210D10F0DA09D81C9A40BA3A0E0BA0", hash_generated_method = "BBD7965D346BF1D7806D7ABC42DEB4ED")
    public  PCalledPartyIDParser(String calledPartyID) {
        super(calledPartyID);
        addTaint(calledPartyID.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.058 -0400", hash_original_method = "A63723B4A16B3DEC36752AB85CAA4736", hash_generated_method = "1A433AD9ED26F8AC88F7689284675C35")
    protected  PCalledPartyIDParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.058 -0400", hash_original_method = "C43CF84ED746DD134AB177C7FEFB3286", hash_generated_method = "3067CED401318BFE95D305D7847F8F5B")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("PCalledPartyIDParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.P_CALLED_PARTY_ID);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            PCalledPartyID calledPartyID = new PCalledPartyID();
            super.parse(calledPartyID);
SIPHeader var7CED634B91969C8974B3C449C1A23580_247360569 =             calledPartyID;
            var7CED634B91969C8974B3C449C1A23580_247360569.addTaint(taint);
            return var7CED634B91969C8974B3C449C1A23580_247360569;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("PCalledPartyIDParser.parse");
        } 
        
        
            
        
            
            
            
            
            
            
            
        
            
                
        
    }

    
}

