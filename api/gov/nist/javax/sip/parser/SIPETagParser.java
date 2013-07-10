package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class SIPETagParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.534 -0400", hash_original_method = "25835348DC7AD8FF740039B9BA0B006A", hash_generated_method = "DABC58F2C7A881669DD1F6CF1A3EEE88")
    public  SIPETagParser(String etag) {
        super(etag);
        addTaint(etag.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.534 -0400", hash_original_method = "03B2B3729732C2927273E5D90D52F99B", hash_generated_method = "35AB74E80C2FDF719C633AF0774FB236")
    protected  SIPETagParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.534 -0400", hash_original_method = "2EFAB9CD472E8A9D51A90FC23F3B4B08", hash_generated_method = "F4436D9E7774F872856DBF05A5EFEF90")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1874569013 = null; 
        dbg_enter("SIPEtag.parse");
        SIPETag sipEtag = new SIPETag();
        try 
        {
            headerName(TokenTypes.SIP_ETAG);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            sipEtag.setETag(token.getTokenValue());
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_1874569013 = sipEtag;
        } 
        finally 
        {
            dbg_leave("SIPEtag.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1874569013.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1874569013;
        
        
            
        
        
            
            
            
            
            
            
            
            
        
            
                
        
    }

    
}

