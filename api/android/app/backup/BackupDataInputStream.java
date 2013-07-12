package android.app.backup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.io.IOException;

public class BackupDataInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.037 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "FFE7EE17DFA37A68070A0F0495753B29")

    String key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.037 -0400", hash_original_field = "7E995300D17ABA58ED95A1629BB54EDB", hash_generated_field = "BE50627D89367B94B26C95254370D367")

    int dataSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.037 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "E3D8EC927026C22AB4F4A51B7D52DBD7")

    BackupDataInput mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.038 -0400", hash_original_field = "849448381B2D9DEAB538B2582CB9F38A", hash_generated_field = "741CFBB37C334A9DBBB5084AC407FBC5")

    byte[] mOneByte;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.038 -0400", hash_original_method = "C2C10C1477F29698CE48A2404B00FC26", hash_generated_method = "1A1C8E636B0AAC290AD1FB4EF8D4012F")
      BackupDataInputStream(BackupDataInput data) {
        mData = data;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.039 -0400", hash_original_method = "F4751627195ADC12549C9A18CF48A412", hash_generated_method = "7C64B5716D1E438FE155B8C368BC9080")
    public int read() throws IOException {
        byte[] one = mOneByte;
    if(mOneByte == null)        
        {
            one = mOneByte = new byte[1];
        } 
        mData.readEntityData(one, 0, 1);
        int var1335A6A147E72748A94A562241E2B830_18498472 = (one[0]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1279797055 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1279797055;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.039 -0400", hash_original_method = "E5C8D10363AA6A5828998ABAFBD3DBB5", hash_generated_method = "DE753F1EF4C94B73B819F62B74A82F8B")
    public int read(byte[] b, int offset, int size) throws IOException {
        addTaint(size);
        addTaint(offset);
        addTaint(b[0]);
        int varCFA6060A76803DC123ADE59BD476DC18_1231697731 = (mData.readEntityData(b, offset, size));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798785511 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798785511;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.040 -0400", hash_original_method = "261A99F04C534DF9C91290D411F9A374", hash_generated_method = "98D763875E27D377C69F759E60621643")
    public int read(byte[] b) throws IOException {
        addTaint(b[0]);
        int var3312356BCC0ECCE1EF01D9DB2F5A3AF2_6227155 = (mData.readEntityData(b, 0, b.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501444499 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501444499;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.040 -0400", hash_original_method = "EC81A9ECDA808FF062BB2254D312B94E", hash_generated_method = "74217C922407E513BB1AEA98FECECFF6")
    public String getKey() {
String var28438ADFC1608AABD649C75D36B519BF_1862158378 =         this.key;
        var28438ADFC1608AABD649C75D36B519BF_1862158378.addTaint(taint);
        return var28438ADFC1608AABD649C75D36B519BF_1862158378;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.041 -0400", hash_original_method = "EB0F38C5E31652AF776348A02A47056B", hash_generated_method = "0518D50AF76EE14CB722EA2574E7528B")
    public int size() {
        int var67E937702FA3D6D983419880FAA287DA_52557341 = (this.dataSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530312220 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530312220;
        
        
    }

    
}

