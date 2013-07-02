package gov.nist.javax.sip.parser.extensions;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.header.extensions.*;
import gov.nist.javax.sip.parser.*;

public class ReferredByParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.030 -0400", hash_original_method = "B42987DBDBA12D8A1BC8285C2A945786", hash_generated_method = "C9FBBE0DB0ED57749A664431F28AF13A")
    public  ReferredByParser(String referBy) {
        super(referBy);
        addTaint(referBy.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.030 -0400", hash_original_method = "CCD7CFF6FCA48FCEC6FB3D9B7402721E", hash_generated_method = "B489F8353291A605BC8CE38D58B2E5FF")
    protected  ReferredByParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.030 -0400", hash_original_method = "17616601F399F4EC4152D86BF5F11B96", hash_generated_method = "B3808804A640A51C318EBD36A2BE6768")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1668613540 = null; 
        headerName(TokenTypes.REFERREDBY_TO);
        ReferredBy referBy = new ReferredBy();
        super.parse(referBy);
        this.lexer.match('\n');
        varB4EAC82CA7396A68D541C85D26508E83_1668613540 = referBy;
        varB4EAC82CA7396A68D541C85D26508E83_1668613540.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1668613540;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void main(String args[]) throws ParseException {
        String to[] =
            {   "Referred-By: <sip:dave@denver.example.org?" +
                    "Replaces=12345%40192.168.118.3%3Bto-tag%3D12345%3Bfrom-tag%3D5FFE-3994>\n",
                "Referred-By: <sip:+1-650-555-2222@ss1.wcom.com;user=phone>;tag=5617\n",
                "Referred-By: T. A. Watson <sip:watson@bell-telephone.com>\n",
                "Referred-By: LittleGuy <sip:UserB@there.com>\n",
                "Referred-By: sip:mranga@120.6.55.9\n",
                "Referred-By: sip:mranga@129.6.55.9 ; tag=696928473514.129.6.55.9\n" };
        for (int i = 0; i < to.length; i++) {
            ReferredByParser tp = new ReferredByParser(to[i]);
            ReferredBy t = (ReferredBy) tp.parse();
            System.out.println("encoded = " + t.encode());
        }
    }

    
}

