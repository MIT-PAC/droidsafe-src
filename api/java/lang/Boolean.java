package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public final class Boolean implements Serializable, Comparable<Boolean> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.544 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "B3AA526F1538BC4E4F647F454F4A2696")

    private boolean value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.544 -0400", hash_original_method = "16D96B4E7F901C7B1D5828A237ACCAC7", hash_generated_method = "92DDB70BC101508B3FB882C8FBF7B3A5")
    public  Boolean(String string) {
        this(parseBoolean(string));
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.545 -0400", hash_original_method = "AAA63288DF04453D39E07EAA91131D42", hash_generated_method = "61C13C2ADE094B1CD107EB04FB0A6541")
    public  Boolean(boolean value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.545 -0400", hash_original_method = "F26012F420AB2CB381204FD30DBE0B24", hash_generated_method = "D0BB54EF439CE941B84A532140EEB8C5")
    public boolean booleanValue() {
        boolean var2063C1608D6E0BAF80249C42E2BE5804_1561199585 = (value);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1178539578 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1178539578;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.546 -0400", hash_original_method = "28AC409B4210D4AB015BA8660C651D82", hash_generated_method = "9C2C9CE89D5109A940787636040E0C33")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        boolean varEC2D77BA51328D849639EC2E3A8EB150_559141195 = ((o == this) || ((o instanceof Boolean) && (((Boolean) o).value == value)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1858318431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1858318431;
        // ---------- Original Method ----------
        //return (o == this) || ((o instanceof Boolean) && (((Boolean) o).value == value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.547 -0400", hash_original_method = "5D5C1978E7EFC6390B8F7A214888BA1C", hash_generated_method = "60D6C310E642B261BA315BABA4933C65")
    public int compareTo(Boolean that) {
        addTaint(that.getTaint());
        int varFFE399C90F9F00EFBE7302AD24B072BF_1852341267 = (compare(value, that.value));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186463113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186463113;
        // ---------- Original Method ----------
        //return compare(value, that.value);
    }

    
        @DSModeled(DSC.SAFE)
    public static int compare(boolean lhs, boolean rhs) {
        return lhs == rhs ? 0 : lhs ? 1 : -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.548 -0400", hash_original_method = "EE015B9251F7CEAD272805E74A0AD6CD", hash_generated_method = "4A8599842AAB09EE7CB9EF824A1F2CE5")
    @Override
    public int hashCode() {
        int var121BE81DE6C5567E875F4167ABD28870_436245206 = (value ? 1231 : 1237);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709772624 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709772624;
        // ---------- Original Method ----------
        //return value ? 1231 : 1237;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.548 -0400", hash_original_method = "27F3E47E60B1213ECE72A0C1452319D1", hash_generated_method = "9441161316BDDD2A92D8A9AC64D99776")
    @Override
    public String toString() {
String varE1C269B12AA3B951D8A9B8058A1CED16_326537700 =         String.valueOf(value);
        varE1C269B12AA3B951D8A9B8058A1CED16_326537700.addTaint(taint);
        return varE1C269B12AA3B951D8A9B8058A1CED16_326537700;
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

    
        @DSModeled(DSC.SAFE)
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.550 -0400", hash_original_field = "7A18B2058F198302BF1CE6152BB0C441", hash_generated_field = "CFFD6448D529B230EC4B399C365C3ED6")

    private static final long serialVersionUID = -3665804199014368530L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.550 -0400", hash_original_field = "7A71BDE48B31E3DF5D5301124892E031", hash_generated_field = "E6915B30788347C5E17C14AFE97099AA")

    @SuppressWarnings("unchecked")
    public static final Class<Boolean> TYPE
             = (Class<Boolean>) boolean[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.550 -0400", hash_original_field = "E38D287FAEA95554BFD8C34BE64AB6F6", hash_generated_field = "0F6E439EBADB4A2E6EAE37AA10FD51E6")

    public static final Boolean TRUE = new Boolean(true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.550 -0400", hash_original_field = "FD331BC1517B881E92A5BCDF08D70458", hash_generated_field = "76A59335A5CE94CD1B1D73C9A4052176")

    public static final Boolean FALSE = new Boolean(false);
}

