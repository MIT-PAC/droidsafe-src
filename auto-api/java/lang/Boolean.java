package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public final class Boolean implements Serializable, Comparable<Boolean> {
    private boolean value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.434 -0400", hash_original_method = "16D96B4E7F901C7B1D5828A237ACCAC7", hash_generated_method = "7B0E8CDABE24DDB0A4CBAAEEE2BBF944")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Boolean(String string) {
        this(parseBoolean(string));
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.434 -0400", hash_original_method = "AAA63288DF04453D39E07EAA91131D42", hash_generated_method = "3E21FC1A0736EB72E684DF39BF2DCF43")
    @DSModeled(DSC.SAFE)
    public Boolean(boolean value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.434 -0400", hash_original_method = "F26012F420AB2CB381204FD30DBE0B24", hash_generated_method = "15E9F41284BECCD5125507FB41DFA2C3")
    @DSModeled(DSC.SAFE)
    public boolean booleanValue() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.434 -0400", hash_original_method = "28AC409B4210D4AB015BA8660C651D82", hash_generated_method = "115E4A6F1E570FB2B5C2D17CCC5B6395")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @FindBugsSuppressWarnings("RC_REF_COMPARISON_BAD_PRACTICE_BOOLEAN")
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        boolean var99AC8650B2AAD1FA2D9056545ED3E8F7_1977045397 = ((o == this) || ((o instanceof Boolean) && (((Boolean) o).value == value)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (o == this) || ((o instanceof Boolean) && (((Boolean) o).value == value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.434 -0400", hash_original_method = "5D5C1978E7EFC6390B8F7A214888BA1C", hash_generated_method = "1B70D4A1CA4B83CC1F6011C16CC58944")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Boolean that) {
        dsTaint.addTaint(that.dsTaint);
        int varE94CEDDB519CA0CC1B17C757EDB60AE2_2106883406 = (compare(value, that.value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return compare(value, that.value);
    }

    
        public static int compare(boolean lhs, boolean rhs) {
        return lhs == rhs ? 0 : lhs ? 1 : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.435 -0400", hash_original_method = "EE015B9251F7CEAD272805E74A0AD6CD", hash_generated_method = "4C058D882071DDE33A259983465FD38C")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value ? 1231 : 1237;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.435 -0400", hash_original_method = "27F3E47E60B1213ECE72A0C1452319D1", hash_generated_method = "63692E93650F4625EF85144CE47C70F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varE56CB71A0102261E1E6B2E712053A166_58031109 = (String.valueOf(value));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return String.valueOf(value);
    }

    
        public static boolean getBoolean(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }
        return (parseBoolean(System.getProperty(string)));
    }

    
        public static boolean parseBoolean(String s) {
        return "true".equalsIgnoreCase(s);
    }

    
        public static String toString(boolean value) {
        return String.valueOf(value);
    }

    
        public static Boolean valueOf(String string) {
        return parseBoolean(string) ? Boolean.TRUE : Boolean.FALSE;
    }

    
        public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    
    private static final long serialVersionUID = -3665804199014368530L;
    @SuppressWarnings("unchecked") public static final Class<Boolean> TYPE
             = (Class<Boolean>) boolean[].class.getComponentType();
    public static final Boolean TRUE = new Boolean(true);
    public static final Boolean FALSE = new Boolean(false);
}

