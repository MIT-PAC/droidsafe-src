package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

final class ByteArray {
    private byte[] bytes;
    private int hashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.529 -0400", hash_original_method = "4AF9F563805F4ED44AAE8EE4F8A801D9", hash_generated_method = "3227C7A4EC154A3C8E47DCE00FA69E8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ByteArray(byte[] bytes) {
        dsTaint.addTaint(bytes[0]);
        this.hashCode = Arrays.hashCode(bytes);
        // ---------- Original Method ----------
        //this.bytes = bytes;
        //this.hashCode = Arrays.hashCode(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.529 -0400", hash_original_method = "8BA9483852C95CF52834EFFEFBE67C86", hash_generated_method = "5F1F09E40882931996C1FB5E81914E51")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.529 -0400", hash_original_method = "035A671466178159FCEA5052C8344F27", hash_generated_method = "4D0AFE9C6C7007ED7C51F98F0F84CA48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        ByteArray lhs;
        lhs = (ByteArray) o;
        boolean var5686DEF4CCFB20EAF24376106F488243_1425720302 = (Arrays.equals(bytes, lhs.bytes));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(o instanceof ByteArray)) {
            //return false;
        //}
        //ByteArray lhs = (ByteArray) o;
        //return Arrays.equals(bytes, lhs.bytes);
    }

    
}

