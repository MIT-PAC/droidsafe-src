package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.harmony.security.utils.Array;






public class ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.175 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "D780785EF370A874C4FD0A663CBEE653")

    protected byte[] encoding;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.175 -0400", hash_original_method = "92B36A954C74D787717A80E6E1DCF4CB", hash_generated_method = "646DDFB6B137A2CD94865A6E1E6AF5F3")
    public  ExtensionValue() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.176 -0400", hash_original_method = "92F18F58E02D664C24F95F43BB13284A", hash_generated_method = "B5B41EEA3422EF95BC843761DA63367E")
    public  ExtensionValue(byte[] encoding) {
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.176 -0400", hash_original_method = "377D44A9A27BF814250295098F20477B", hash_generated_method = "A3C862C508AAB74A36F41456A1C5D85B")
    public byte[] getEncoded() {
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1031797422 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_740080261 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_740080261;
        // ---------- Original Method ----------
        //return encoding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.177 -0400", hash_original_method = "EBD96CEB228F4E98BF0AC3D53A96C792", hash_generated_method = "ED8BA5E6ED92519FA6C0C16EA29DBEF4")
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append("Unparseable extension value:\n");
        if(encoding == null)        
        {
            encoding = getEncoded();
        } //End block
        if(encoding == null)        
        {
            sb.append("NULL\n");
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.177 -0400", hash_original_method = "6724193923CC6FF1B2BB2E93A0E55B86", hash_generated_method = "BA883F714988E28D95E3137D99B7876F")
    public void dumpValue(StringBuilder sb) {
        addTaint(sb.getTaint());
        dumpValue(sb, "");
        // ---------- Original Method ----------
        //dumpValue(sb, "");
    }

    
}

