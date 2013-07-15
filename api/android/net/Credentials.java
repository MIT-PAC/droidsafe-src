package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class Credentials {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.908 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "DBFF83134AA84403D6020EBC0053D7A1")

    private int pid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.908 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "4BAD495D6F9082D5BF8F64A6BBA7B8D1")

    private int uid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.908 -0400", hash_original_field = "2D53A8FB7ABF5BE7F4A3CF4B565CC75C", hash_generated_field = "8B22ADD2CDC200DB70C94C9AD2F2F61A")

    private int gid;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.908 -0400", hash_original_method = "0D22AAF944E180A41FC070C17248D99F", hash_generated_method = "B2DDACFDE3E01D30298695087ED681AB")
    public  Credentials(int pid, int uid, int gid) {
        this.pid = pid;
        this.uid = uid;
        this.gid = gid;
        // ---------- Original Method ----------
        //this.pid = pid;
        //this.uid = uid;
        //this.gid = gid;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.909 -0400", hash_original_method = "78D1E6D4CA2C23604540BE821B70C9C5", hash_generated_method = "7E9483A42855E89B1380C3003274EEF8")
    public int getPid() {
        int var0DB3209E1ADC6D67BE435A81BAF9A66E_1333773916 = (pid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786963474 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786963474;
        // ---------- Original Method ----------
        //return pid;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.909 -0400", hash_original_method = "0C7AA9282DA1BA7425530FB39ADDE6D7", hash_generated_method = "69F8C565B182F3FFE2E614E4CD9C6462")
    public int getUid() {
        int var9871D3A2C554B27151CACF1422EEC048_506138482 = (uid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318953554 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318953554;
        // ---------- Original Method ----------
        //return uid;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.909 -0400", hash_original_method = "62E574E9D4A38B83D3EBF8EDA61883B3", hash_generated_method = "6CD69D530F07C404F7750222280B0E78")
    public int getGid() {
        int var2D53A8FB7ABF5BE7F4A3CF4B565CC75C_1022083321 = (gid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1419676789 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1419676789;
        // ---------- Original Method ----------
        //return gid;
    }

    
}

