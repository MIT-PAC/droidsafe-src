package java.util.regex;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class PatternSyntaxException extends IllegalArgumentException {
    private String desc;
    private String pattern;
    private int index = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.667 -0400", hash_original_method = "89B9A833AE2CE5B13E9F312F3F36ED4B", hash_generated_method = "4DD4F232E2E6CA4CBE2945BB37612AB9")
    @DSModeled(DSC.SAFE)
    public PatternSyntaxException(String description, String pattern, int index) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(pattern);
        dsTaint.addTaint(description);
        // ---------- Original Method ----------
        //this.desc = description;
        //this.pattern = pattern;
        //this.index = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.667 -0400", hash_original_method = "7A292BCA91A2C0FA8C2558D08D8D09A0", hash_generated_method = "0A1374C076D0847FBB7AB3C2E8C9314C")
    @DSModeled(DSC.SAFE)
    public String getPattern() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.668 -0400", hash_original_method = "103F1174601A04B5B5C014BF3A77F551", hash_generated_method = "B6FE39FF286B149A96A336CEB1C82ECF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getMessage() {
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
        String var806458D832AB974D230FEE4CBBDBD390_344672146 = (sb.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.668 -0400", hash_original_method = "B876CD4C2F9B0449C0BFBE53447962F9", hash_generated_method = "F111C21F670D12971BC88002D60E58D3")
    @DSModeled(DSC.SAFE)
    public String getDescription() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return desc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.668 -0400", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "48B0F5CEF7537869A6C46DF0BD2A31DE")
    @DSModeled(DSC.SAFE)
    public int getIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return index;
    }

    
    private static final long serialVersionUID = -3864639126226059218L;
}

