package java.util.regex;

// Droidsafe Imports
import java.util.Arrays;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class PatternSyntaxException extends IllegalArgumentException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.452 -0400", hash_original_field = "1DEE80C7D5AB2C1C90AA8D2F7DD47256", hash_generated_field = "869DADF19D0CEFB2D948CD463462BCA0")

    private String desc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.453 -0400", hash_original_field = "240BF022E685B0EE30AD9FE9E1FB5D5B", hash_generated_field = "8AE769BFE2CAD1B10C494CCD4D4D489A")

    private String pattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.453 -0400", hash_original_field = "F40516930DEF5AA3CE6AC04ABD9FDB40", hash_generated_field = "18384124910AA57648BA024F99B1F65B")

    private int index = -1;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.453 -0400", hash_original_method = "89B9A833AE2CE5B13E9F312F3F36ED4B", hash_generated_method = "B95671C7B358D385696E60C8C86E6A70")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.454 -0400", hash_original_method = "7A292BCA91A2C0FA8C2558D08D8D09A0", hash_generated_method = "9FDD2E58B1DD5B8A0F91C6751E688330")
    public String getPattern() {
String var407D32260E541B695CF3FD3F7EFB76AB_2075284591 =         pattern;
        var407D32260E541B695CF3FD3F7EFB76AB_2075284591.addTaint(taint);
        return var407D32260E541B695CF3FD3F7EFB76AB_2075284591;
        // ---------- Original Method ----------
        //return pattern;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.454 -0400", hash_original_method = "103F1174601A04B5B5C014BF3A77F551", hash_generated_method = "998FDC4A90D3AC9D00BAEA2E4C60AA28")
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
String var2460B846747F8B22185AD8BE722266A5_162707801 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_162707801.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_162707801;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.455 -0400", hash_original_method = "B876CD4C2F9B0449C0BFBE53447962F9", hash_generated_method = "01E22514192F2F3AC3F76E9D31C865EF")
    public String getDescription() {
String varD03F909FD24236E480611D9D33E98808_1372175557 =         desc;
        varD03F909FD24236E480611D9D33E98808_1372175557.addTaint(taint);
        return varD03F909FD24236E480611D9D33E98808_1372175557;
        // ---------- Original Method ----------
        //return desc;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.455 -0400", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "7B22F0D942B3CA110CEB915CB5DC9A30")
    public int getIndex() {
        int var6A992D5529F459A44FEE58C733255E86_212254265 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_894083446 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_894083446;
        // ---------- Original Method ----------
        //return index;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.455 -0400", hash_original_field = "B81EE2A6787F9302E2BCEC35CFCE0402", hash_generated_field = "95718108CDA06A2DD9B75CB57E0279C5")

    private static final long serialVersionUID = -3864639126226059218L;
}

