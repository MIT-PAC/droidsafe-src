package java.util.regex;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public class PatternSyntaxException extends IllegalArgumentException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.344 -0400", hash_original_field = "1DEE80C7D5AB2C1C90AA8D2F7DD47256", hash_generated_field = "869DADF19D0CEFB2D948CD463462BCA0")

    private String desc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.344 -0400", hash_original_field = "240BF022E685B0EE30AD9FE9E1FB5D5B", hash_generated_field = "8AE769BFE2CAD1B10C494CCD4D4D489A")

    private String pattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.344 -0400", hash_original_field = "F40516930DEF5AA3CE6AC04ABD9FDB40", hash_generated_field = "18384124910AA57648BA024F99B1F65B")

    private int index = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.345 -0400", hash_original_method = "89B9A833AE2CE5B13E9F312F3F36ED4B", hash_generated_method = "B95671C7B358D385696E60C8C86E6A70")
    public  PatternSyntaxException(String description, String pattern, int index) {
        this.desc = description;
        this.pattern = pattern;
        this.index = index;
        // ---------- Original Method ----------
        //this.desc = description;
        //this.pattern = pattern;
        //this.index = index;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.345 -0400", hash_original_method = "7A292BCA91A2C0FA8C2558D08D8D09A0", hash_generated_method = "C88A107D10B28CC4D58C0C7F1216FA70")
    public String getPattern() {
String var407D32260E541B695CF3FD3F7EFB76AB_27348833 =         pattern;
        var407D32260E541B695CF3FD3F7EFB76AB_27348833.addTaint(taint);
        return var407D32260E541B695CF3FD3F7EFB76AB_27348833;
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.345 -0400", hash_original_method = "103F1174601A04B5B5C014BF3A77F551", hash_generated_method = "405C13F65BDD975ADEC93E2D0542FC7C")
    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
    if(desc != null)        
        {
            sb.append(desc);
        } //End block
    if(index >= 0)        
        {
    if(desc != null)            
            {
                sb.append(' ');
            } //End block
            sb.append("near index ");
            sb.append(index);
            sb.append(':');
        } //End block
    if(pattern != null)        
        {
            sb.append('\n');
            sb.append(pattern);
    if(index >= 0)            
            {
                char[] spaces = new char[index];
                Arrays.fill(spaces, ' ');
                sb.append('\n');
                sb.append(spaces);
                sb.append('^');
            } //End block
        } //End block
String var2460B846747F8B22185AD8BE722266A5_1837597700 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1837597700.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1837597700;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.346 -0400", hash_original_method = "B876CD4C2F9B0449C0BFBE53447962F9", hash_generated_method = "C8D18C62C1C1319D35D25E1F10BE7636")
    public String getDescription() {
String varD03F909FD24236E480611D9D33E98808_631557678 =         desc;
        varD03F909FD24236E480611D9D33E98808_631557678.addTaint(taint);
        return varD03F909FD24236E480611D9D33E98808_631557678;
        // ---------- Original Method ----------
        //return desc;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.346 -0400", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "E6B672CD8BF650A3EB26A378E1DB546F")
    public int getIndex() {
        int var6A992D5529F459A44FEE58C733255E86_505076176 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711021609 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711021609;
        // ---------- Original Method ----------
        //return index;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.346 -0400", hash_original_field = "B81EE2A6787F9302E2BCEC35CFCE0402", hash_generated_field = "95718108CDA06A2DD9B75CB57E0279C5")

    private static final long serialVersionUID = -3864639126226059218L;
}

