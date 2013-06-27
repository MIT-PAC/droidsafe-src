package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.charset.Charset;

public class UnsafeByteSequence {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.657 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "4E58ABB9D5068B90ACC1157BF07E4EBB")

    private byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.657 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.658 -0400", hash_original_method = "3B8A36370055AF819C3748255F1BDC68", hash_generated_method = "B480D5F65BA5A041317D50ECA353DED2")
    public  UnsafeByteSequence(int initialCapacity) {
        this.bytes = new byte[initialCapacity];
        // ---------- Original Method ----------
        //this.bytes = new byte[initialCapacity];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.658 -0400", hash_original_method = "F417CE3385B772AADA134FBE4FF63C9E", hash_generated_method = "0DCEA7D52FFEB432AF1865B19D0C7453")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2085053787 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2085053787;
        // ---------- Original Method ----------
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.658 -0400", hash_original_method = "CD6FA0D10C84692422449C0C5D320E8A", hash_generated_method = "37A38F7B043D44D70AC23E12C0B9583A")
    public void rewind() {
        count = 0;
        // ---------- Original Method ----------
        //count = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.698 -0400", hash_original_method = "5B2175FB0361CE80BA769109F54D5CFC", hash_generated_method = "8B557FC038947DB6021B2017CE6C2F38")
    public void write(byte[] buffer, int offset, int length) {
        {
            byte[] newBytes;
            newBytes = new byte[(count + length) * 2];
            System.arraycopy(bytes, 0, newBytes, 0, count);
            bytes = newBytes;
        } //End block
        System.arraycopy(buffer, offset, bytes, count, length);
        count += length;
        addTaint(buffer[0]);
        addTaint(offset);
        // ---------- Original Method ----------
        //if (count + length >= bytes.length) {
            //byte[] newBytes = new byte[(count + length) * 2];
            //System.arraycopy(bytes, 0, newBytes, 0, count);
            //bytes = newBytes;
        //}
        //System.arraycopy(buffer, offset, bytes, count, length);
        //count += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.699 -0400", hash_original_method = "CCB897927F45B316C80C49A08CD4BEC5", hash_generated_method = "50690343291ABCFDB28EA2860807E7FE")
    public void write(int b) {
        {
            byte[] newBytes;
            newBytes = new byte[count * 2];
            System.arraycopy(bytes, 0, newBytes, 0, count);
            bytes = newBytes;
        } //End block
        bytes[count++] = (byte) b;
        // ---------- Original Method ----------
        //if (count == bytes.length) {
            //byte[] newBytes = new byte[count * 2];
            //System.arraycopy(bytes, 0, newBytes, 0, count);
            //bytes = newBytes;
        //}
        //bytes[count++] = (byte) b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.700 -0400", hash_original_method = "6A961C2A026EF073EA4353A09C4F8B0B", hash_generated_method = "575561FDFA04A834A868DEEC67F2A28F")
    @FindBugsSuppressWarnings("EI_EXPOSE_REP")
    public byte[] toByteArray() {
        byte[] result;
        result = new byte[count];
        System.arraycopy(bytes, 0, result, 0, count);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_875502957 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_875502957;
        // ---------- Original Method ----------
        //if (count == bytes.length) {
            //return bytes;
        //}
        //byte[] result = new byte[count];
        //System.arraycopy(bytes, 0, result, 0, count);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.700 -0400", hash_original_method = "EBA6423CDD36F9469C412144E3270E61", hash_generated_method = "8D5925EB622F05B6ED2291D2A4330602")
    public String toString(Charset cs) {
        String varB4EAC82CA7396A68D541C85D26508E83_457479381 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_457479381 = new String(bytes, 0, count, cs);
        addTaint(cs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_457479381.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_457479381;
        // ---------- Original Method ----------
        //return new String(bytes, 0, count, cs);
    }

    
}

