package java.util.regex;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Arrays;

public class PatternSyntaxException extends IllegalArgumentException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.653 -0400", hash_original_field = "1DEE80C7D5AB2C1C90AA8D2F7DD47256", hash_generated_field = "869DADF19D0CEFB2D948CD463462BCA0")

    private String desc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.653 -0400", hash_original_field = "240BF022E685B0EE30AD9FE9E1FB5D5B", hash_generated_field = "8AE769BFE2CAD1B10C494CCD4D4D489A")

    private String pattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.653 -0400", hash_original_field = "F40516930DEF5AA3CE6AC04ABD9FDB40", hash_generated_field = "18384124910AA57648BA024F99B1F65B")

    private int index = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.653 -0400", hash_original_method = "89B9A833AE2CE5B13E9F312F3F36ED4B", hash_generated_method = "B95671C7B358D385696E60C8C86E6A70")
    public  PatternSyntaxException(String description, String pattern, int index) {
        this.desc = description;
        this.pattern = pattern;
        this.index = index;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.654 -0400", hash_original_method = "7A292BCA91A2C0FA8C2558D08D8D09A0", hash_generated_method = "CDB17C3980499A9C3F82A5278743DAA5")
    public String getPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_1075641747 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1075641747 = pattern;
        varB4EAC82CA7396A68D541C85D26508E83_1075641747.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1075641747;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.655 -0400", hash_original_method = "103F1174601A04B5B5C014BF3A77F551", hash_generated_method = "923A10C7C4555587EB1832CE6C974488")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_970660982 = null; 
        StringBuilder sb = new StringBuilder();
        {
            sb.append(desc);
        } 
        {
            {
                sb.append(' ');
            } 
            sb.append("near index ");
            sb.append(index);
            sb.append(':');
        } 
        {
            sb.append('\n');
            sb.append(pattern);
            {
                char[] spaces = new char[index];
                Arrays.fill(spaces, ' ');
                sb.append('\n');
                sb.append(spaces);
                sb.append('^');
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_970660982 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_970660982.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_970660982;
        
        
        
            
        
        
            
                
            
            
            
            
        
        
            
            
            
                
                
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.657 -0400", hash_original_method = "B876CD4C2F9B0449C0BFBE53447962F9", hash_generated_method = "F3FEA594CD19CE9D467ED689F8653F54")
    public String getDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_524255940 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_524255940 = desc;
        varB4EAC82CA7396A68D541C85D26508E83_524255940.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_524255940;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.658 -0400", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "88F7632F06FCF0F36E39152AD82C8A2B")
    public int getIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995668320 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995668320;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.658 -0400", hash_original_field = "B81EE2A6787F9302E2BCEC35CFCE0402", hash_generated_field = "95718108CDA06A2DD9B75CB57E0279C5")

    private static final long serialVersionUID = -3864639126226059218L;
}

