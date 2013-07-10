package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.nio.charset.Charset;

public class UnsafeByteSequence {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.468 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "4E58ABB9D5068B90ACC1157BF07E4EBB")

    private byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.469 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.469 -0400", hash_original_method = "3B8A36370055AF819C3748255F1BDC68", hash_generated_method = "B480D5F65BA5A041317D50ECA353DED2")
    public  UnsafeByteSequence(int initialCapacity) {
        this.bytes = new byte[initialCapacity];
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.469 -0400", hash_original_method = "F417CE3385B772AADA134FBE4FF63C9E", hash_generated_method = "8F3C182DD0E18974912B75D064345B35")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428496409 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428496409;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.469 -0400", hash_original_method = "CD6FA0D10C84692422449C0C5D320E8A", hash_generated_method = "37A38F7B043D44D70AC23E12C0B9583A")
    public void rewind() {
        count = 0;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.470 -0400", hash_original_method = "5B2175FB0361CE80BA769109F54D5CFC", hash_generated_method = "77F4874FF6F7581318DE508B8A7960C6")
    public void write(byte[] buffer, int offset, int length) {
        {
            byte[] newBytes = new byte[(count + length) * 2];
            System.arraycopy(bytes, 0, newBytes, 0, count);
            bytes = newBytes;
        } 
        System.arraycopy(buffer, offset, bytes, count, length);
        count += length;
        addTaint(buffer[0]);
        addTaint(offset);
        
        
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.470 -0400", hash_original_method = "CCB897927F45B316C80C49A08CD4BEC5", hash_generated_method = "67E61AD5C6B54E4C39E9130283949683")
    public void write(int b) {
        {
            byte[] newBytes = new byte[count * 2];
            System.arraycopy(bytes, 0, newBytes, 0, count);
            bytes = newBytes;
        } 
        bytes[count++] = (byte) b;
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.470 -0400", hash_original_method = "6A961C2A026EF073EA4353A09C4F8B0B", hash_generated_method = "3DCDE29F2A8E05FFE56FCCF4859486A6")
    @FindBugsSuppressWarnings("EI_EXPOSE_REP")
    public byte[] toByteArray() {
        byte[] result = new byte[count];
        System.arraycopy(bytes, 0, result, 0, count);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_130937538 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_130937538;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.471 -0400", hash_original_method = "EBA6423CDD36F9469C412144E3270E61", hash_generated_method = "B6C7A2CF28ED7C11D0DC94B4F490C52F")
    public String toString(Charset cs) {
        String varB4EAC82CA7396A68D541C85D26508E83_1965831704 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1965831704 = new String(bytes, 0, count, cs);
        addTaint(cs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1965831704.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1965831704;
        
        
    }

    
}

