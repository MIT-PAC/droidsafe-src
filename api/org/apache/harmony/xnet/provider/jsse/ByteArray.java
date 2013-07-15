package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

final class ByteArray {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.053 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "4E58ABB9D5068B90ACC1157BF07E4EBB")

    private byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.053 -0400", hash_original_field = "550D1CC054A1B23A411DDDA46FD64811", hash_generated_field = "38607001336EF9DE010EF92F750652A2")

    private int hashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.053 -0400", hash_original_method = "4AF9F563805F4ED44AAE8EE4F8A801D9", hash_generated_method = "86424FE701B8BE7F328DF822143425C6")
      ByteArray(byte[] bytes) {
        this.bytes = bytes;
        this.hashCode = Arrays.hashCode(bytes);
        // ---------- Original Method ----------
        //this.bytes = bytes;
        //this.hashCode = Arrays.hashCode(bytes);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.054 -0400", hash_original_method = "8BA9483852C95CF52834EFFEFBE67C86", hash_generated_method = "430EF9B03C35F9178F8797C221807D6F")
    @Override
    public int hashCode() {
        int var550D1CC054A1B23A411DDDA46FD64811_207682733 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_86870110 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_86870110;
        // ---------- Original Method ----------
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.054 -0400", hash_original_method = "035A671466178159FCEA5052C8344F27", hash_generated_method = "46E7C92158D3685A641271DA98D5716D")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(!(o instanceof ByteArray))        
        {
            boolean var68934A3E9455FA72420237EB05902327_779122487 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_474095164 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_474095164;
        } //End block
        ByteArray lhs = (ByteArray) o;
        boolean varC42C0B8A6C0E3F37AE1E1C08C2B94CE9_1759214599 = (Arrays.equals(bytes, lhs.bytes));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_244615613 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_244615613;
        // ---------- Original Method ----------
        //if (!(o instanceof ByteArray)) {
            //return false;
        //}
        //ByteArray lhs = (ByteArray) o;
        //return Arrays.equals(bytes, lhs.bytes);
    }

    
}

