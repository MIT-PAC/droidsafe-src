package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class OrganizationParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.100 -0400", hash_original_method = "549F69CADB3AF439FF99C26DCF97EF61", hash_generated_method = "6170B9428B77266BA6E655AF7ACBDA03")
    public  OrganizationParser(String organization) {
        super(organization);
        addTaint(organization.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.100 -0400", hash_original_method = "5407EA6CAC142FB29C8ECABB6BAE3B2C", hash_generated_method = "30C64867BC39878E46F7846B11CA9D04")
    protected  OrganizationParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.100 -0400", hash_original_method = "FCDFEF7484AB928FBE1CF6D95D3DCFBA", hash_generated_method = "2F413528002133A095D8F051F5514CDE")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_2091239093 = null; 
        dbg_enter("OrganizationParser.parse");
        Organization organization = new Organization();
        try 
        {
            headerName(TokenTypes.ORGANIZATION);
            organization.setHeaderName(SIPHeaderNames.ORGANIZATION);
            this.lexer.SPorHT();
            String value = this.lexer.getRest();
            organization.setOrganization(value.trim());
            varB4EAC82CA7396A68D541C85D26508E83_2091239093 = organization;
        } 
        finally 
        {
            dbg_leave("OrganizationParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2091239093.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2091239093;
        
        
            
        
        
            
            
            
            
            
            
        
            
                
        
    }

    
}

