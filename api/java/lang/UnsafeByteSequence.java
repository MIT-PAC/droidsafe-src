package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.charset.Charset;

public class UnsafeByteSequence {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.659 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "4E58ABB9D5068B90ACC1157BF07E4EBB")

    private byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.659 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.659 -0400", hash_original_method = "3B8A36370055AF819C3748255F1BDC68", hash_generated_method = "B480D5F65BA5A041317D50ECA353DED2")
    public  UnsafeByteSequence(int initialCapacity) {
        this.bytes = new byte[initialCapacity];
        // ---------- Original Method ----------
        //this.bytes = new byte[initialCapacity];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.660 -0400", hash_original_method = "F417CE3385B772AADA134FBE4FF63C9E", hash_generated_method = "1700F0BC7EDE0CCBFFC8A5AECA1CCB76")
    public int size() {
        int varE2942A04780E223B215EB8B663CF5353_1424891642 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_367186031 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_367186031;
        // ---------- Original Method ----------
        //return count;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.660 -0400", hash_original_method = "CD6FA0D10C84692422449C0C5D320E8A", hash_generated_method = "37A38F7B043D44D70AC23E12C0B9583A")
    public void rewind() {
        count = 0;
        // ---------- Original Method ----------
        //count = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.661 -0400", hash_original_method = "5B2175FB0361CE80BA769109F54D5CFC", hash_generated_method = "06D3F608A4A3FDA6E771AF9004841FFD")
    public void write(byte[] buffer, int offset, int length) {
        addTaint(offset);
        addTaint(buffer[0]);
        if(count + length >= bytes.length)        
        {
            byte[] newBytes = new byte[(count + length) * 2];
            System.arraycopy(bytes, 0, newBytes, 0, count);
            bytes = newBytes;
        } //End block
        System.arraycopy(buffer, offset, bytes, count, length);
        count += length;
        // ---------- Original Method ----------
        //if (count + length >= bytes.length) {
            //byte[] newBytes = new byte[(count + length) * 2];
            //System.arraycopy(bytes, 0, newBytes, 0, count);
            //bytes = newBytes;
        //}
        //System.arraycopy(buffer, offset, bytes, count, length);
        //count += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.661 -0400", hash_original_method = "CCB897927F45B316C80C49A08CD4BEC5", hash_generated_method = "1D2502F559198FAEF4B9356225ECC793")
    public void write(int b) {
        if(count == bytes.length)        
        {
            byte[] newBytes = new byte[count * 2];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.662 -0400", hash_original_method = "6A961C2A026EF073EA4353A09C4F8B0B", hash_generated_method = "66D62B7D4961DAD3120A7A066117615F")
    @FindBugsSuppressWarnings("EI_EXPOSE_REP")
    public byte[] toByteArray() {
        if(count == bytes.length)        
        {
            byte[] var4B3A6218BB3E3A7303E8A171A60FCF92_1560848971 = (bytes);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_542703518 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_542703518;
        } //End block
        byte[] result = new byte[count];
        System.arraycopy(bytes, 0, result, 0, count);
        byte[] varB4A88417B3D0170D754C647C30B7216A_2064839800 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1925546721 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1925546721;
        // ---------- Original Method ----------
        //if (count == bytes.length) {
            //return bytes;
        //}
        //byte[] result = new byte[count];
        //System.arraycopy(bytes, 0, result, 0, count);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.662 -0400", hash_original_method = "EBA6423CDD36F9469C412144E3270E61", hash_generated_method = "14D06EDDF519CE4AA811967532401315")
    public String toString(Charset cs) {
        addTaint(cs.getTaint());
String varA272CD35FAECEC96162B7ABE2A851E23_1638035113 =         new String(bytes, 0, count, cs);
        varA272CD35FAECEC96162B7ABE2A851E23_1638035113.addTaint(taint);
        return varA272CD35FAECEC96162B7ABE2A851E23_1638035113;
        // ---------- Original Method ----------
        //return new String(bytes, 0, count, cs);
    }

    
}

