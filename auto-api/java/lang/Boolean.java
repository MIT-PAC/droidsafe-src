package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public final class Boolean implements Serializable, Comparable<Boolean> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.106 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "B3AA526F1538BC4E4F647F454F4A2696")

    private boolean value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.107 -0400", hash_original_method = "16D96B4E7F901C7B1D5828A237ACCAC7", hash_generated_method = "92DDB70BC101508B3FB882C8FBF7B3A5")
    public  Boolean(String string) {
        this(parseBoolean(string));
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.107 -0400", hash_original_method = "AAA63288DF04453D39E07EAA91131D42", hash_generated_method = "61C13C2ADE094B1CD107EB04FB0A6541")
    public  Boolean(boolean value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.107 -0400", hash_original_method = "F26012F420AB2CB381204FD30DBE0B24", hash_generated_method = "C9AD6D790A1A607E1D410C87062EDA9A")
    public boolean booleanValue() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1186507913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1186507913;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.108 -0400", hash_original_method = "28AC409B4210D4AB015BA8660C651D82", hash_generated_method = "3F808B13B5D5D416337AE7840B263AF7")
    @Override
    @FindBugsSuppressWarnings("RC_REF_COMPARISON_BAD_PRACTICE_BOOLEAN")
    public boolean equals(Object o) {
        boolean var99AC8650B2AAD1FA2D9056545ED3E8F7_379189136 = ((o == this) || ((o instanceof Boolean) && (((Boolean) o).value == value)));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1827267431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1827267431;
        // ---------- Original Method ----------
        //return (o == this) || ((o instanceof Boolean) && (((Boolean) o).value == value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.112 -0400", hash_original_method = "5D5C1978E7EFC6390B8F7A214888BA1C", hash_generated_method = "97F7E08F987820CE67B8F41ED9D0FED5")
    public int compareTo(Boolean that) {
        int varE94CEDDB519CA0CC1B17C757EDB60AE2_1264209028 = (compare(value, that.value));
        addTaint(that.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955248218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955248218;
        // ---------- Original Method ----------
        //return compare(value, that.value);
    }

    
        public static int compare(boolean lhs, boolean rhs) {
        return lhs == rhs ? 0 : lhs ? 1 : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.113 -0400", hash_original_method = "EE015B9251F7CEAD272805E74A0AD6CD", hash_generated_method = "61CBE42D93C63151CF92FE63E1E2E88A")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_786061191 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_786061191;
        // ---------- Original Method ----------
        //return value ? 1231 : 1237;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.113 -0400", hash_original_method = "27F3E47E60B1213ECE72A0C1452319D1", hash_generated_method = "BF0914A0EB279957445ACAEE74695F1D")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_491978937 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_491978937 = String.valueOf(value);
        varB4EAC82CA7396A68D541C85D26508E83_491978937.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_491978937;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.117 -0400", hash_original_field = "7A18B2058F198302BF1CE6152BB0C441", hash_generated_field = "9276C267E156C23897C89F309D7A571A")

    private static long serialVersionUID = -3665804199014368530L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.117 -0400", hash_original_field = "7A71BDE48B31E3DF5D5301124892E031", hash_generated_field = "E6915B30788347C5E17C14AFE97099AA")

    @SuppressWarnings("unchecked")
    public static final Class<Boolean> TYPE
             = (Class<Boolean>) boolean[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.117 -0400", hash_original_field = "E38D287FAEA95554BFD8C34BE64AB6F6", hash_generated_field = "0F6E439EBADB4A2E6EAE37AA10FD51E6")

    public static final Boolean TRUE = new Boolean(true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.117 -0400", hash_original_field = "FD331BC1517B881E92A5BCDF08D70458", hash_generated_field = "76A59335A5CE94CD1B1D73C9A4052176")

    public static final Boolean FALSE = new Boolean(false);
}

