package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import java.io.Serializable;

public final class Boolean implements Serializable, Comparable<Boolean> {
    private static final long serialVersionUID = -3665804199014368530L;
    private final boolean value;
    @SuppressWarnings("unchecked")
    public static final Class<Boolean> TYPE
             = (Class<Boolean>) boolean[].class.getComponentType();
    public static final Boolean TRUE = new Boolean(true);
    public static final Boolean FALSE = new Boolean(false);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.834 -0400", hash_original_method = "16D96B4E7F901C7B1D5828A237ACCAC7", hash_generated_method = "6544835D07ED1B736F955D811514C704")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Boolean(String string) {
        this(parseBoolean(string));
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.836 -0400", hash_original_method = "AAA63288DF04453D39E07EAA91131D42", hash_generated_method = "55F9A5CE2F0CCE5DBD6D37B565B77E32")
    @DSModeled(DSC.SAFE)
    public Boolean(boolean value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.838 -0400", hash_original_method = "F26012F420AB2CB381204FD30DBE0B24", hash_generated_method = "67C2E83F70A61B73D9FE962AAE904C22")
    @DSModeled(DSC.SAFE)
    public boolean booleanValue() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.840 -0400", hash_original_method = "28AC409B4210D4AB015BA8660C651D82", hash_generated_method = "811FAD60050C21D60BE9D9661E5AFA83")
    @DSModeled(DSC.SAFE)
    @Override
    @FindBugsSuppressWarnings("RC_REF_COMPARISON_BAD_PRACTICE_BOOLEAN")
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (o == this) || ((o instanceof Boolean) && (((Boolean) o).value == value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.842 -0400", hash_original_method = "5D5C1978E7EFC6390B8F7A214888BA1C", hash_generated_method = "E087F2BB8D58C812C6BE14027BD60B71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Boolean that) {
        dsTaint.addTaint(that.dsTaint);
        int varE94CEDDB519CA0CC1B17C757EDB60AE2_1569687079 = (compare(value, that.value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return compare(value, that.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.844 -0400", hash_original_method = "B3A70AF2DF8E93CED801D9C24A07FA78", hash_generated_method = "52DBC9C2C80935547BDAD01A5C55773E")
    public static int compare(boolean lhs, boolean rhs) {
        return lhs == rhs ? 0 : lhs ? 1 : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.845 -0400", hash_original_method = "EE015B9251F7CEAD272805E74A0AD6CD", hash_generated_method = "1AA3D5BBB88717A553CEE912921E7B0B")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value ? 1231 : 1237;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.847 -0400", hash_original_method = "27F3E47E60B1213ECE72A0C1452319D1", hash_generated_method = "8ED708F5E78A31C5F2A7D5D04E27AF71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varE56CB71A0102261E1E6B2E712053A166_696757973 = (String.valueOf(value));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return String.valueOf(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.849 -0400", hash_original_method = "E88CDE1BFD10E217DE82EEF79E0E2CED", hash_generated_method = "ADCC75F930DEC79F7EEB42F15EEABB2B")
    public static boolean getBoolean(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }
        return (parseBoolean(System.getProperty(string)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.856 -0400", hash_original_method = "BD83C9A3C7856D0FAE5D6BC0CCD859FA", hash_generated_method = "35EF410EA41D39A8C101C5B251B58242")
    public static boolean parseBoolean(String s) {
        return "true".equalsIgnoreCase(s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.864 -0400", hash_original_method = "D9199A85D0846E817E80F47C2D9F0FC6", hash_generated_method = "922BC111CD5564A1BFC8994725FA9DD1")
    public static String toString(boolean value) {
        return String.valueOf(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.869 -0400", hash_original_method = "D7304055711653AFAB319201D507D88D", hash_generated_method = "5D2F5BB17E0BBABB512766F7522CD9F0")
    public static Boolean valueOf(String string) {
        return parseBoolean(string) ? Boolean.TRUE : Boolean.FALSE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.873 -0400", hash_original_method = "1F020F11EF22A99E6E7AE33CA4E6AFB6", hash_generated_method = "E53A913A6561FDE56D487E4A382C5544")
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    
}


