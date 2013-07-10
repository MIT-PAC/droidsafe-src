package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.util.*;
import java.text.ParseException;

public class DateParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.922 -0400", hash_original_method = "12ABECDC99786B59BCBD31A7419E2B41", hash_generated_method = "31E9035441D49005C3879B8FD8D40DE2")
    public  DateParser(String date) {
        super(date);
        addTaint(date.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.922 -0400", hash_original_method = "00ADBDEF8E181F85BEA9DD7E552A7849", hash_generated_method = "3AA19BA386E9B78EC047238A34FE54CF")
    protected  DateParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.922 -0400", hash_original_method = "6D964EF3409A9BCD4AB46A00BDF7E85B", hash_generated_method = "2A283A78CBB73D4B27B5F2BAC179535F")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_895052512 = null; 
        dbg_enter("DateParser.parse");
        try 
        {
            headerName(TokenTypes.DATE);
            wkday();
            lexer.match(',');
            lexer.match(' ');
            Calendar cal = date();
            lexer.match(' ');
            time(cal);
            lexer.match(' ');
            String tzone = this.lexer.ttoken().toLowerCase();
            {
                boolean var5EA11BFD516A0207FC02AAB158A24C09_503557522 = (!"gmt".equals(tzone));
                if (DroidSafeAndroidRuntime.control) throw createParseException("Bad Time Zone " + tzone);
            } 
            this.lexer.match('\n');
            SIPDateHeader retval = new SIPDateHeader();
            retval.setDate(cal);
            varB4EAC82CA7396A68D541C85D26508E83_895052512 = retval;
        } 
        finally 
        {
            dbg_leave("DateParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_895052512.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_895052512;
        
        
            
        
            
            
            
            
            
            
            
            
            
            
                
            
            
            
            
        
            
                
        
    }

    
}

