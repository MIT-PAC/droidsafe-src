package java.util.regex;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class PatternSyntaxException extends IllegalArgumentException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.513 -0400", hash_original_field = "1DEE80C7D5AB2C1C90AA8D2F7DD47256", hash_generated_field = "869DADF19D0CEFB2D948CD463462BCA0")

    private String desc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.513 -0400", hash_original_field = "240BF022E685B0EE30AD9FE9E1FB5D5B", hash_generated_field = "8AE769BFE2CAD1B10C494CCD4D4D489A")

    private String pattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.513 -0400", hash_original_field = "F40516930DEF5AA3CE6AC04ABD9FDB40", hash_generated_field = "18384124910AA57648BA024F99B1F65B")

    private int index = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.514 -0400", hash_original_method = "89B9A833AE2CE5B13E9F312F3F36ED4B", hash_generated_method = "B95671C7B358D385696E60C8C86E6A70")
    public  PatternSyntaxException(String description, String pattern, int index) {
        this.desc = description;
        this.pattern = pattern;
        this.index = index;
        // ---------- Original Method ----------
        //this.desc = description;
        //this.pattern = pattern;
        //this.index = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.514 -0400", hash_original_method = "7A292BCA91A2C0FA8C2558D08D8D09A0", hash_generated_method = "B6238FA7F5D1FE7CF0760B7DD7C85417")
    public String getPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_645988921 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_645988921 = pattern;
        varB4EAC82CA7396A68D541C85D26508E83_645988921.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_645988921;
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.516 -0400", hash_original_method = "103F1174601A04B5B5C014BF3A77F551", hash_generated_method = "2AD0E86C3F25476054B126328EAD6758")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1834219520 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder();
        {
            sb.append(desc);
        } //End block
        {
            {
                sb.append(' ');
            } //End block
            sb.append("near index ");
            sb.append(index);
            sb.append(':');
        } //End block
        {
            sb.append('\n');
            sb.append(pattern);
            {
                char[] spaces;
                spaces = new char[index];
                Arrays.fill(spaces, ' ');
                sb.append('\n');
                sb.append(spaces);
                sb.append('^');
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1834219520 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1834219520.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1834219520;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //if (desc != null) {
            //sb.append(desc);
        //}
        //if (index >= 0) {
            //if (desc != null) {
                //sb.append(' ');
            //}
            //sb.append("near index ");
            //sb.append(index);
            //sb.append(':');
        //}
        //if (pattern != null) {
            //sb.append('\n');
            //sb.append(pattern);
            //if (index >= 0) {
                //char[] spaces = new char[index];
                //Arrays.fill(spaces, ' ');
                //sb.append('\n');
                //sb.append(spaces);
                //sb.append('^');
            //}
        //}
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.516 -0400", hash_original_method = "B876CD4C2F9B0449C0BFBE53447962F9", hash_generated_method = "811A788B6A407164CCA486ACB59AE74D")
    public String getDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_579367132 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_579367132 = desc;
        varB4EAC82CA7396A68D541C85D26508E83_579367132.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_579367132;
        // ---------- Original Method ----------
        //return desc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.517 -0400", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "ADE19D16D768274FE1E294BD8EDA9562")
    public int getIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422574951 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422574951;
        // ---------- Original Method ----------
        //return index;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.517 -0400", hash_original_field = "B81EE2A6787F9302E2BCEC35CFCE0402", hash_generated_field = "7D612E5E8A54254A1D122DD7D6BC1D45")

    private static long serialVersionUID = -3864639126226059218L;
}

