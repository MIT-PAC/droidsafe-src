package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class Credentials {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.598 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "DBFF83134AA84403D6020EBC0053D7A1")

    private int pid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.598 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "4BAD495D6F9082D5BF8F64A6BBA7B8D1")

    private int uid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.598 -0400", hash_original_field = "2D53A8FB7ABF5BE7F4A3CF4B565CC75C", hash_generated_field = "8B22ADD2CDC200DB70C94C9AD2F2F61A")

    private int gid;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.599 -0400", hash_original_method = "0D22AAF944E180A41FC070C17248D99F", hash_generated_method = "B2DDACFDE3E01D30298695087ED681AB")
    public  Credentials(int pid, int uid, int gid) {
        this.pid = pid;
        this.uid = uid;
        this.gid = gid;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.599 -0400", hash_original_method = "78D1E6D4CA2C23604540BE821B70C9C5", hash_generated_method = "A878C0D92ACA6E8C286C323AD0799FEE")
    public int getPid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1324850176 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1324850176;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.600 -0400", hash_original_method = "0C7AA9282DA1BA7425530FB39ADDE6D7", hash_generated_method = "BCDDA956E27C588CF602AAEFD5FE5342")
    public int getUid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_633335102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_633335102;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.600 -0400", hash_original_method = "62E574E9D4A38B83D3EBF8EDA61883B3", hash_generated_method = "9110C73A57DB48DBA48C212E7F52AE90")
    public int getGid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_816119329 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_816119329;
        
        
    }

    
}

