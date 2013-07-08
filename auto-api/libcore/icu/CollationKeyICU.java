package libcore.icu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.CollationKey;

public final class CollationKeyICU extends CollationKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.140 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "4E58ABB9D5068B90ACC1157BF07E4EBB")

    private byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.140 -0400", hash_original_field = "550D1CC054A1B23A411DDDA46FD64811", hash_generated_field = "38607001336EF9DE010EF92F750652A2")

    private int hashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.140 -0400", hash_original_method = "FDD367E7E47ED4793DE3731632868D96", hash_generated_method = "AC9813A07F0378DA2ED7280DFCA0EA9A")
      CollationKeyICU(String source, byte[] bytes) {
        super(source);
        this.bytes = bytes;
        addTaint(source.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.141 -0400", hash_original_method = "2BC5B1EAC391DF0E7068AFC895CE7148", hash_generated_method = "8A667E8076512B0DD367ED5038821753")
    @Override
    public int compareTo(CollationKey other) {
        byte[] rhsBytes;
        {
            rhsBytes = ((CollationKeyICU) other).bytes;
        } 
        {
            rhsBytes = other.toByteArray();
        } 
        int count = Math.min(bytes.length, rhsBytes.length);
        {
            int i = 0;
            {
                int s = bytes[i] & 0xff;
                int t = rhsBytes[i] & 0xff;
            } 
        } 
        addTaint(other.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_597174272 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_597174272;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.142 -0400", hash_original_method = "02D4FA820C7658A0385D9CDD7EC5D935", hash_generated_method = "C8E6AAE2D94D1FD567DC104060B63AF0")
    @Override
    public boolean equals(Object object) {
        {
            boolean var3F549205D4C262003697A031F89E5954_1035002140 = (object == this);
        } 
        boolean var19B270A380201703B8B8376341B1FDE1_1558402049 = (compareTo((CollationKey) object) == 0);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1533047817 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1533047817;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.143 -0400", hash_original_method = "14EA39361109DCC90111D16D29CE0C8D", hash_generated_method = "A09F5F3C66E7CC5DFE79A3982C7146D2")
    @Override
    public int hashCode() {
        {
            {
                int len = bytes.length;
                int inc = ((len - 32) / 32) + 1;
                {
                    int i = 0;
                    {
                        hashCode = (hashCode * 37) + bytes[i];
                        i += inc;
                    } 
                } 
            } 
            {
                hashCode = 1;
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261911089 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261911089;
        
        
            
                
                
                
                    
                    
                
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.144 -0400", hash_original_method = "6C3C6FF515A6D95256010638A5024205", hash_generated_method = "2AF78FAD095FA1D7E6AD47ACFEFA7975")
    @Override
    public byte[] toByteArray() {
        byte[] varAEAFD0367658F481DD5C0B92821E5740_1651312438 = (bytes.clone());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1342518814 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1342518814;
        
        
            
        
        
    }

    
}

