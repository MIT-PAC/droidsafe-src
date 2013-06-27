package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.harmony.security.utils.Array;

public class ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.695 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "D780785EF370A874C4FD0A663CBEE653")

    protected byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.696 -0400", hash_original_method = "92B36A954C74D787717A80E6E1DCF4CB", hash_generated_method = "646DDFB6B137A2CD94865A6E1E6AF5F3")
    public  ExtensionValue() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.696 -0400", hash_original_method = "92F18F58E02D664C24F95F43BB13284A", hash_generated_method = "B5B41EEA3422EF95BC843761DA63367E")
    public  ExtensionValue(byte[] encoding) {
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.697 -0400", hash_original_method = "377D44A9A27BF814250295098F20477B", hash_generated_method = "F4CDD0097B85FD0A81923127A092DCF9")
    public byte[] getEncoded() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1243760787 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1243760787;
        // ---------- Original Method ----------
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.698 -0400", hash_original_method = "EBD96CEB228F4E98BF0AC3D53A96C792", hash_generated_method = "F5A2A57B118D09D221CE6431A484FEF5")
    public void dumpValue(StringBuilder sb, String prefix) {
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
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.702 -0400", hash_original_method = "6724193923CC6FF1B2BB2E93A0E55B86", hash_generated_method = "712BD81E1FC751B505F461B07ECDD3D6")
    public void dumpValue(StringBuilder sb) {
        dumpValue(sb, "");
        addTaint(sb.getTaint());
        // ---------- Original Method ----------
        //dumpValue(sb, "");
    }

    
}

