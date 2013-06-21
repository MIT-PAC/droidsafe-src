package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.charset.Charset;

public class UnsafeByteSequence {
    private byte[] bytes;
    private int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.647 -0400", hash_original_method = "3B8A36370055AF819C3748255F1BDC68", hash_generated_method = "3FA72EB5D2519B8875C9A4854F9B72CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsafeByteSequence(int initialCapacity) {
        dsTaint.addTaint(initialCapacity);
        this.bytes = new byte[initialCapacity];
        // ---------- Original Method ----------
        //this.bytes = new byte[initialCapacity];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.648 -0400", hash_original_method = "F417CE3385B772AADA134FBE4FF63C9E", hash_generated_method = "BC27CC801EC67865C37F88F8E1360D7B")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.648 -0400", hash_original_method = "CD6FA0D10C84692422449C0C5D320E8A", hash_generated_method = "37A38F7B043D44D70AC23E12C0B9583A")
    @DSModeled(DSC.SAFE)
    public void rewind() {
        count = 0;
        // ---------- Original Method ----------
        //count = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.649 -0400", hash_original_method = "5B2175FB0361CE80BA769109F54D5CFC", hash_generated_method = "A321DD942802CE75B796E021EFCE4D18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(byte[] buffer, int offset, int length) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        {
            byte[] newBytes;
            newBytes = new byte[(count + length) * 2];
            System.arraycopy(bytes, 0, newBytes, 0, count);
            bytes = newBytes;
        } //End block
        System.arraycopy(buffer, offset, bytes, count, length);
        // ---------- Original Method ----------
        //if (count + length >= bytes.length) {
            //byte[] newBytes = new byte[(count + length) * 2];
            //System.arraycopy(bytes, 0, newBytes, 0, count);
            //bytes = newBytes;
        //}
        //System.arraycopy(buffer, offset, bytes, count, length);
        //count += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.649 -0400", hash_original_method = "CCB897927F45B316C80C49A08CD4BEC5", hash_generated_method = "E157A7B453D0D7923EC10F7E04018D16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(int b) {
        dsTaint.addTaint(b);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.650 -0400", hash_original_method = "6A961C2A026EF073EA4353A09C4F8B0B", hash_generated_method = "710F273482E153C4586E8D1C5FB77AF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @FindBugsSuppressWarnings("EI_EXPOSE_REP")
    public byte[] toByteArray() {
        byte[] result;
        result = new byte[count];
        System.arraycopy(bytes, 0, result, 0, count);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (count == bytes.length) {
            //return bytes;
        //}
        //byte[] result = new byte[count];
        //System.arraycopy(bytes, 0, result, 0, count);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.650 -0400", hash_original_method = "EBA6423CDD36F9469C412144E3270E61", hash_generated_method = "26FC13A20700E578CD3CE7C119ABE43E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString(Charset cs) {
        dsTaint.addTaint(cs.dsTaint);
        String var376935E83E16FEE751E38C67A5EAE7E4_348723742 = (new String(bytes, 0, count, cs));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return new String(bytes, 0, count, cs);
    }

    
}

