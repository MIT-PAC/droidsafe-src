package gov.nist.javax.sip.parser.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.ims.PCalledPartyID;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import gov.nist.javax.sip.parser.AddressParametersParser;

public class PCalledPartyIDParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.110 -0400", hash_original_method = "5A210D10F0DA09D81C9A40BA3A0E0BA0", hash_generated_method = "BBD7965D346BF1D7806D7ABC42DEB4ED")
    public  PCalledPartyIDParser(String calledPartyID) {
        super(calledPartyID);
        addTaint(calledPartyID.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.110 -0400", hash_original_method = "A63723B4A16B3DEC36752AB85CAA4736", hash_generated_method = "1A433AD9ED26F8AC88F7689284675C35")
    protected  PCalledPartyIDParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.111 -0400", hash_original_method = "C43CF84ED746DD134AB177C7FEFB3286", hash_generated_method = "A9F772AB13892E30DEF2FEE8A12F14F0")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_66521183 = null; 
        dbg_enter("PCalledPartyIDParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.P_CALLED_PARTY_ID);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            PCalledPartyID calledPartyID = new PCalledPartyID();
            super.parse(calledPartyID);
            varB4EAC82CA7396A68D541C85D26508E83_66521183 = calledPartyID;
        } 
        finally 
        {
            dbg_leave("PCalledPartyIDParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_66521183.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_66521183;
        
        
            
        
            
            
            
            
            
            
            
        
            
                
        
    }

    
}

