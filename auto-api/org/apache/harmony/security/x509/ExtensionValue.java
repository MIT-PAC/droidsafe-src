package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.harmony.security.utils.Array;

public class ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.903 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "D780785EF370A874C4FD0A663CBEE653")

    protected byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.903 -0400", hash_original_method = "92B36A954C74D787717A80E6E1DCF4CB", hash_generated_method = "646DDFB6B137A2CD94865A6E1E6AF5F3")
    public  ExtensionValue() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.903 -0400", hash_original_method = "92F18F58E02D664C24F95F43BB13284A", hash_generated_method = "B5B41EEA3422EF95BC843761DA63367E")
    public  ExtensionValue(byte[] encoding) {
        this.encoding = encoding;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.903 -0400", hash_original_method = "377D44A9A27BF814250295098F20477B", hash_generated_method = "93C1E511DB7CAE83574A7835D8A9453C")
    public byte[] getEncoded() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_53490865 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_53490865;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.904 -0400", hash_original_method = "EBD96CEB228F4E98BF0AC3D53A96C792", hash_generated_method = "F5A2A57B118D09D221CE6431A484FEF5")
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Unparseable extension value:\n");
        {
            encoding = getEncoded();
        } 
        {
            sb.append("NULL\n");
        } 
        {
            sb.append(Array.toString(encoding, prefix));
        } 
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.904 -0400", hash_original_method = "6724193923CC6FF1B2BB2E93A0E55B86", hash_generated_method = "712BD81E1FC751B505F461B07ECDD3D6")
    public void dumpValue(StringBuilder sb) {
        dumpValue(sb, "");
        addTaint(sb.getTaint());
        
        
    }

    
}

