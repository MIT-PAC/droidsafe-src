package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.harmony.security.utils.Array;

public class ExtensionValue {
    protected byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.675 -0400", hash_original_method = "92B36A954C74D787717A80E6E1DCF4CB", hash_generated_method = "646DDFB6B137A2CD94865A6E1E6AF5F3")
    @DSModeled(DSC.SAFE)
    public ExtensionValue() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.675 -0400", hash_original_method = "92F18F58E02D664C24F95F43BB13284A", hash_generated_method = "F38D1952B58FA246D5F2BCFA5356BD01")
    @DSModeled(DSC.SAFE)
    public ExtensionValue(byte[] encoding) {
        dsTaint.addTaint(encoding[0]);
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.675 -0400", hash_original_method = "377D44A9A27BF814250295098F20477B", hash_generated_method = "32A7264895A08782540757C8A7AE73E7")
    @DSModeled(DSC.SAFE)
    public byte[] getEncoded() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.676 -0400", hash_original_method = "EBD96CEB228F4E98BF0AC3D53A96C792", hash_generated_method = "BDFC034B85E4FDCD89E43B8DF5149D5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("Unparseable extension value:\n");
        {
            encoding = getEncoded();
        } //End block
        {
            sb.append("NULL\n");
        } //End block
        {
            sb.append(Array.toString(encoding, prefix));
        } //End block
        // ---------- Original Method ----------
        //sb.append(prefix).append("Unparseable extension value:\n");
        //if (encoding == null) {
            //encoding = getEncoded();
        //}
        //if (encoding == null) {
            //sb.append("NULL\n");
        //} else {
            //sb.append(Array.toString(encoding, prefix));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.676 -0400", hash_original_method = "6724193923CC6FF1B2BB2E93A0E55B86", hash_generated_method = "A233CD75FB50A86206C9415A18A8583F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb) {
        dsTaint.addTaint(sb.dsTaint);
        dumpValue(sb, "");
        // ---------- Original Method ----------
        //dumpValue(sb, "");
    }

    
}

