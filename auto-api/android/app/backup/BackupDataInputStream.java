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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.425 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "FFE7EE17DFA37A68070A0F0495753B29")

    String key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.425 -0400", hash_original_field = "7E995300D17ABA58ED95A1629BB54EDB", hash_generated_field = "BE50627D89367B94B26C95254370D367")

    int dataSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.425 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "E3D8EC927026C22AB4F4A51B7D52DBD7")

    BackupDataInput mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.425 -0400", hash_original_field = "849448381B2D9DEAB538B2582CB9F38A", hash_generated_field = "741CFBB37C334A9DBBB5084AC407FBC5")

    byte[] mOneByte;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.426 -0400", hash_original_method = "C2C10C1477F29698CE48A2404B00FC26", hash_generated_method = "1A1C8E636B0AAC290AD1FB4EF8D4012F")
      BackupDataInputStream(BackupDataInput data) {
        mData = data;
        // ---------- Original Method ----------
        //mData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.426 -0400", hash_original_method = "F4751627195ADC12549C9A18CF48A412", hash_generated_method = "FEEA895990B9F82464C85B0B51EEDC2B")
    public int read() throws IOException {
        byte[] one = mOneByte;
        {
            one = mOneByte = new byte[1];
        } //End block
        mData.readEntityData(one, 0, 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2091971741 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2091971741;
        // ---------- Original Method ----------
        //byte[] one = mOneByte;
        //if (mOneByte == null) {
            //one = mOneByte = new byte[1];
        //}
        //mData.readEntityData(one, 0, 1);
        //return one[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.427 -0400", hash_original_method = "E5C8D10363AA6A5828998ABAFBD3DBB5", hash_generated_method = "5A943C8CC3D13C30955B15E28DA085A8")
    public int read(byte[] b, int offset, int size) throws IOException {
        int var9D560C23C6FFC3A37C7626BDD7716519_932231870 = (mData.readEntityData(b, offset, size));
        addTaint(b[0]);
        addTaint(offset);
        addTaint(size);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189652716 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189652716;
        // ---------- Original Method ----------
        //return mData.readEntityData(b, offset, size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.428 -0400", hash_original_method = "261A99F04C534DF9C91290D411F9A374", hash_generated_method = "4B4B8AF9C8AC73A19166F76006354FBA")
    public int read(byte[] b) throws IOException {
        int var1A579DF139B251E5199B49BE031970F9_602327836 = (mData.readEntityData(b, 0, b.length));
        addTaint(b[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_357530609 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_357530609;
        // ---------- Original Method ----------
        //return mData.readEntityData(b, 0, b.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.429 -0400", hash_original_method = "EC81A9ECDA808FF062BB2254D312B94E", hash_generated_method = "4511DDE560CB42D7DE8E5780178B38EF")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_240899253 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_240899253 = this.key;
        varB4EAC82CA7396A68D541C85D26508E83_240899253.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_240899253;
        // ---------- Original Method ----------
        //return this.key;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.429 -0400", hash_original_method = "EB0F38C5E31652AF776348A02A47056B", hash_generated_method = "3A71FA3F9133AC9922B740A54AD46FAD")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791242875 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791242875;
        // ---------- Original Method ----------
        //return this.dataSize;
    }

    
}

