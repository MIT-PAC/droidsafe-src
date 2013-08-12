package android.app.backup;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;






public class BackupDataInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.182 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "FFE7EE17DFA37A68070A0F0495753B29")

    String key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.182 -0400", hash_original_field = "7E995300D17ABA58ED95A1629BB54EDB", hash_generated_field = "BE50627D89367B94B26C95254370D367")

    int dataSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.182 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "E3D8EC927026C22AB4F4A51B7D52DBD7")

    BackupDataInput mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.182 -0400", hash_original_field = "849448381B2D9DEAB538B2582CB9F38A", hash_generated_field = "741CFBB37C334A9DBBB5084AC407FBC5")

    byte[] mOneByte;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.183 -0400", hash_original_method = "C2C10C1477F29698CE48A2404B00FC26", hash_generated_method = "1A1C8E636B0AAC290AD1FB4EF8D4012F")
      BackupDataInputStream(BackupDataInput data) {
        mData = data;
        // ---------- Original Method ----------
        //mData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.184 -0400", hash_original_method = "F4751627195ADC12549C9A18CF48A412", hash_generated_method = "AF5E7823B0AF49DEF7D2454266EA9D87")
    public int read() throws IOException {
        byte[] one = mOneByte;
        if(mOneByte == null)        
        {
            one = mOneByte = new byte[1];
        } //End block
        mData.readEntityData(one, 0, 1);
        int var1335A6A147E72748A94A562241E2B830_905208820 = (one[0]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364946702 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364946702;
        // ---------- Original Method ----------
        //byte[] one = mOneByte;
        //if (mOneByte == null) {
            //one = mOneByte = new byte[1];
        //}
        //mData.readEntityData(one, 0, 1);
        //return one[0];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.185 -0400", hash_original_method = "E5C8D10363AA6A5828998ABAFBD3DBB5", hash_generated_method = "C39EBE02867AC715DB758FE4D901FBEF")
    public int read(byte[] b, int offset, int size) throws IOException {
        addTaint(size);
        addTaint(offset);
        addTaint(b[0]);
        int varCFA6060A76803DC123ADE59BD476DC18_526228350 = (mData.readEntityData(b, offset, size));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707362171 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707362171;
        // ---------- Original Method ----------
        //return mData.readEntityData(b, offset, size);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.186 -0400", hash_original_method = "261A99F04C534DF9C91290D411F9A374", hash_generated_method = "372FFCECFF989E1EEE1834322CB4A3B9")
    public int read(byte[] b) throws IOException {
        addTaint(b[0]);
        int var3312356BCC0ECCE1EF01D9DB2F5A3AF2_1036846614 = (mData.readEntityData(b, 0, b.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1515736154 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1515736154;
        // ---------- Original Method ----------
        //return mData.readEntityData(b, 0, b.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.186 -0400", hash_original_method = "EC81A9ECDA808FF062BB2254D312B94E", hash_generated_method = "410F5F264554A3B31A1E0D645E550756")
    public String getKey() {
String var28438ADFC1608AABD649C75D36B519BF_1902143915 =         this.key;
        var28438ADFC1608AABD649C75D36B519BF_1902143915.addTaint(taint);
        return var28438ADFC1608AABD649C75D36B519BF_1902143915;
        // ---------- Original Method ----------
        //return this.key;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.187 -0400", hash_original_method = "EB0F38C5E31652AF776348A02A47056B", hash_generated_method = "197A4D899874F5EE3569922E139EAA55")
    public int size() {
        int var67E937702FA3D6D983419880FAA287DA_696174639 = (this.dataSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337570726 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337570726;
        // ---------- Original Method ----------
        //return this.dataSize;
    }

    
}

