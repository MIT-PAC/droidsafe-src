package gov.nist.javax.sip.parser.extensions;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.header.extensions.*;
import gov.nist.javax.sip.parser.*;
import java.text.ParseException;

public class JoinParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.000 -0400", hash_original_method = "EF4712E80A9A6595AD0A1CEA8AD509AD", hash_generated_method = "EF8DC95B7DED73A2DB702514426B3451")
    public  JoinParser(String callID) {
        super(callID);
        addTaint(callID.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.000 -0400", hash_original_method = "C3C0BEC6FC6BFB3701BC82718709C143", hash_generated_method = "90BF5F94E161A6ABC76322A48650D9FD")
    protected  JoinParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.001 -0400", hash_original_method = "66B10ECC601C3201E5F156FEACCA3B45", hash_generated_method = "47E5A44773A5D5FCFB4AD23B75E2F54E")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_182543705 = null; 
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.JOIN_TO);
            Join join = new Join();
            this.lexer.SPorHT();
            String callId = lexer.byteStringNoSemicolon();
            this.lexer.SPorHT();
            super.parse(join);
            join.setCallId(callId);
            varB4EAC82CA7396A68D541C85D26508E83_182543705 = join;
        } 
        finally 
        {
            dbg_leave("parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_182543705.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_182543705;
        
        
            
        
            
            
            
            
            
            
            
            
        
            
                
        
    }

    
    @DSModeled(DSC.SPEC)
    public static void main(String args[]) throws ParseException {
        String to[] =
            {   "Join: 12345th5z8z\n",
                "Join: 12345th5z8z;to-tag=tozght6-45;from-tag=fromzght789-337-2\n",
            };
        for (int i = 0; i < to.length; i++) {
            JoinParser tp = new JoinParser(to[i]);
            Join t = (Join) tp.parse();
            System.out.println("Parsing => " + to[i]);
            System.out.print("encoded = " + t.encode() + "==> ");
            System.out.println("callId " + t.getCallId() + " from-tag=" + t.getFromTag()
                    + " to-tag=" + t.getToTag()) ;
        }
    }

    
}

