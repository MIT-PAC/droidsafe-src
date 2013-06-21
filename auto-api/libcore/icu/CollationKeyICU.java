package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.CollationKey;

public final class CollationKeyICU extends CollationKey {
    private byte[] bytes;
    private int hashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.461 -0400", hash_original_method = "FDD367E7E47ED4793DE3731632868D96", hash_generated_method = "8C794FBF4E6D01A14A724491421DF22D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CollationKeyICU(String source, byte[] bytes) {
        super(source);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(source);
        // ---------- Original Method ----------
        //this.bytes = bytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.461 -0400", hash_original_method = "2BC5B1EAC391DF0E7068AFC895CE7148", hash_generated_method = "85BF41FF54E336F7802A19D5C2CB770E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int compareTo(CollationKey other) {
        dsTaint.addTaint(other.dsTaint);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.461 -0400", hash_original_method = "02D4FA820C7658A0385D9CDD7EC5D935", hash_generated_method = "9E4E4381D07253ED7CAFABFA2E59E7B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            boolean var3F549205D4C262003697A031F89E5954_1448748208 = (object == this);
        } //End collapsed parenthetic
        boolean var19B270A380201703B8B8376341B1FDE1_700021740 = (compareTo((CollationKey) object) == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (object == this) {
            //return true;
        //}
        //if (!(object instanceof CollationKey)) {
            //return false;
        //}
        //return compareTo((CollationKey) object) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.462 -0400", hash_original_method = "14EA39361109DCC90111D16D29CE0C8D", hash_generated_method = "963F4BFE5C25E84A95CC4544959DFAFF")
    @DSModeled(DSC.SAFE)
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.462 -0400", hash_original_method = "6C3C6FF515A6D95256010638A5024205", hash_generated_method = "E8FECCB04F1B96D360ABDCC8AB84BD7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] toByteArray() {
        byte[] varAEAFD0367658F481DD5C0B92821E5740_1346037104 = (bytes.clone());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (bytes == null || bytes.length == 0) {
            //return null;
        //}
        //return bytes.clone();
    }

    
}

