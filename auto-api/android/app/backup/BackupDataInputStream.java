package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.InputStream;
import java.io.IOException;

public class BackupDataInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.767 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "FFE7EE17DFA37A68070A0F0495753B29")

    String key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.773 -0400", hash_original_field = "7E995300D17ABA58ED95A1629BB54EDB", hash_generated_field = "BE50627D89367B94B26C95254370D367")

    int dataSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.774 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "E3D8EC927026C22AB4F4A51B7D52DBD7")

    BackupDataInput mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.774 -0400", hash_original_field = "849448381B2D9DEAB538B2582CB9F38A", hash_generated_field = "741CFBB37C334A9DBBB5084AC407FBC5")

    byte[] mOneByte;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.789 -0400", hash_original_method = "C2C10C1477F29698CE48A2404B00FC26", hash_generated_method = "1A1C8E636B0AAC290AD1FB4EF8D4012F")
      BackupDataInputStream(BackupDataInput data) {
        mData = data;
        // ---------- Original Method ----------
        //mData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.797 -0400", hash_original_method = "F4751627195ADC12549C9A18CF48A412", hash_generated_method = "A07B6936CE988A32E201EE0D6EC17138")
    public int read() throws IOException {
        byte[] one;
        one = mOneByte;
        {
            one = mOneByte = new byte[1];
        } //End block
        mData.readEntityData(one, 0, 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87687406 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87687406;
        // ---------- Original Method ----------
        //byte[] one = mOneByte;
        //if (mOneByte == null) {
            //one = mOneByte = new byte[1];
        //}
        //mData.readEntityData(one, 0, 1);
        //return one[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.799 -0400", hash_original_method = "E5C8D10363AA6A5828998ABAFBD3DBB5", hash_generated_method = "B2D3B502443656AA925C16B2629DDCA6")
    public int read(byte[] b, int offset, int size) throws IOException {
        int var9D560C23C6FFC3A37C7626BDD7716519_1002377051 = (mData.readEntityData(b, offset, size));
        addTaint(b[0]);
        addTaint(offset);
        addTaint(size);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753669569 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753669569;
        // ---------- Original Method ----------
        //return mData.readEntityData(b, offset, size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.800 -0400", hash_original_method = "261A99F04C534DF9C91290D411F9A374", hash_generated_method = "72F3020D30E32EE1832AAB2EF173DB15")
    public int read(byte[] b) throws IOException {
        int var1A579DF139B251E5199B49BE031970F9_2145751078 = (mData.readEntityData(b, 0, b.length));
        addTaint(b[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_211498457 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_211498457;
        // ---------- Original Method ----------
        //return mData.readEntityData(b, 0, b.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.822 -0400", hash_original_method = "EC81A9ECDA808FF062BB2254D312B94E", hash_generated_method = "8B98736CCE845422847B8949CCD60E34")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_1027096966 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1027096966 = this.key;
        varB4EAC82CA7396A68D541C85D26508E83_1027096966.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1027096966;
        // ---------- Original Method ----------
        //return this.key;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.824 -0400", hash_original_method = "EB0F38C5E31652AF776348A02A47056B", hash_generated_method = "6157EF1F8DE3FFFDE32E31CA6F8DE077")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1010737755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1010737755;
        // ---------- Original Method ----------
        //return this.dataSize;
    }

    
}

