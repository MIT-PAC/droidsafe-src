package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.CollationKey;

public final class CollationKeyICU extends CollationKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.041 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "4E58ABB9D5068B90ACC1157BF07E4EBB")

    private byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.041 -0400", hash_original_field = "550D1CC054A1B23A411DDDA46FD64811", hash_generated_field = "38607001336EF9DE010EF92F750652A2")

    private int hashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.042 -0400", hash_original_method = "FDD367E7E47ED4793DE3731632868D96", hash_generated_method = "AC9813A07F0378DA2ED7280DFCA0EA9A")
      CollationKeyICU(String source, byte[] bytes) {
        super(source);
        this.bytes = bytes;
        addTaint(source.getTaint());
        // ---------- Original Method ----------
        //this.bytes = bytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.043 -0400", hash_original_method = "2BC5B1EAC391DF0E7068AFC895CE7148", hash_generated_method = "A880CA32588D0422DB0933BF9359C591")
    @Override
    public int compareTo(CollationKey other) {
        byte[] rhsBytes;
        {
            rhsBytes = ((CollationKeyICU) other).bytes;
        } //End block
        {
            rhsBytes = other.toByteArray();
        } //End block
        int count;
        count = Math.min(bytes.length, rhsBytes.length);
        {
            int i;
            i = 0;
            {
                int s;
                s = bytes[i] & 0xff;
                int t;
                t = rhsBytes[i] & 0xff;
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707656059 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707656059;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.051 -0400", hash_original_method = "02D4FA820C7658A0385D9CDD7EC5D935", hash_generated_method = "4C2DFB05BB2F5D4420B308BC92953B41")
    @Override
    public boolean equals(Object object) {
        {
            boolean var3F549205D4C262003697A031F89E5954_2113844951 = (object == this);
        } //End collapsed parenthetic
        boolean var19B270A380201703B8B8376341B1FDE1_1550955385 = (compareTo((CollationKey) object) == 0);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1131297713 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1131297713;
        // ---------- Original Method ----------
        //if (object == this) {
            //return true;
        //}
        //if (!(object instanceof CollationKey)) {
            //return false;
        //}
        //return compareTo((CollationKey) object) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.056 -0400", hash_original_method = "14EA39361109DCC90111D16D29CE0C8D", hash_generated_method = "ED5B13AAE15682D339D1D1AEDD70C871")
    @Override
    public int hashCode() {
        {
            {
                int len;
                len = bytes.length;
                int inc;
                inc = ((len - 32) / 32) + 1;
                {
                    int i;
                    i = 0;
                    {
                        hashCode = (hashCode * 37) + bytes[i];
                        i += inc;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                hashCode = 1;
            } //End block
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_353907194 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_353907194;
        // ---------- Original Method ----------
        //if (hashCode == 0) {
            //if (bytes != null && bytes.length != 0) {
                //int len = bytes.length;
                //int inc = ((len - 32) / 32) + 1;
                //for (int i = 0; i < len;) {
                    //hashCode = (hashCode * 37) + bytes[i];
                    //i += inc;
                //}
            //}
            //if (hashCode == 0) {
                //hashCode = 1;
            //}
        //}
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.061 -0400", hash_original_method = "6C3C6FF515A6D95256010638A5024205", hash_generated_method = "F82B6C64F37F7CEDA0F73BB5E21FE020")
    @Override
    public byte[] toByteArray() {
        byte[] varAEAFD0367658F481DD5C0B92821E5740_82829319 = (bytes.clone());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1524849758 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1524849758;
        // ---------- Original Method ----------
        //if (bytes == null || bytes.length == 0) {
            //return null;
        //}
        //return bytes.clone();
    }

    
}

