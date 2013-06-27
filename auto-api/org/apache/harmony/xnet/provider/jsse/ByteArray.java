package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

final class ByteArray {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.268 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "4E58ABB9D5068B90ACC1157BF07E4EBB")

    private byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.268 -0400", hash_original_field = "550D1CC054A1B23A411DDDA46FD64811", hash_generated_field = "38607001336EF9DE010EF92F750652A2")

    private int hashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.268 -0400", hash_original_method = "4AF9F563805F4ED44AAE8EE4F8A801D9", hash_generated_method = "86424FE701B8BE7F328DF822143425C6")
      ByteArray(byte[] bytes) {
        this.bytes = bytes;
        this.hashCode = Arrays.hashCode(bytes);
        // ---------- Original Method ----------
        //this.bytes = bytes;
        //this.hashCode = Arrays.hashCode(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.269 -0400", hash_original_method = "8BA9483852C95CF52834EFFEFBE67C86", hash_generated_method = "DE94065889F6FD4079F5B155D2D86F15")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838200655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838200655;
        // ---------- Original Method ----------
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.269 -0400", hash_original_method = "035A671466178159FCEA5052C8344F27", hash_generated_method = "640F24BA5BF1A53A4BFC4AAFD6DF8702")
    @Override
    public boolean equals(Object o) {
        ByteArray lhs;
        lhs = (ByteArray) o;
        boolean var5686DEF4CCFB20EAF24376106F488243_2059771989 = (Arrays.equals(bytes, lhs.bytes));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1963858691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1963858691;
        // ---------- Original Method ----------
        //if (!(o instanceof ByteArray)) {
            //return false;
        //}
        //ByteArray lhs = (ByteArray) o;
        //return Arrays.equals(bytes, lhs.bytes);
    }

    
}

