package android.net;

// Droidsafe Imports
import droidsafe.annotations.*;





public class Credentials {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.426 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "DBFF83134AA84403D6020EBC0053D7A1")

    private int pid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.426 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "4BAD495D6F9082D5BF8F64A6BBA7B8D1")

    private int uid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.426 -0400", hash_original_field = "2D53A8FB7ABF5BE7F4A3CF4B565CC75C", hash_generated_field = "8B22ADD2CDC200DB70C94C9AD2F2F61A")

    private int gid;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.427 -0400", hash_original_method = "0D22AAF944E180A41FC070C17248D99F", hash_generated_method = "B2DDACFDE3E01D30298695087ED681AB")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.428 -0400", hash_original_method = "78D1E6D4CA2C23604540BE821B70C9C5", hash_generated_method = "8127C3853EFE5E3ADB6EA01B7EF182E5")
    public int getPid() {
        int var0DB3209E1ADC6D67BE435A81BAF9A66E_392472053 = (pid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202411062 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202411062;
        // ---------- Original Method ----------
        //return pid;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.429 -0400", hash_original_method = "0C7AA9282DA1BA7425530FB39ADDE6D7", hash_generated_method = "B7DED989C8144E93EBFFC2D41984E1CF")
    public int getUid() {
        int var9871D3A2C554B27151CACF1422EEC048_547462831 = (uid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307496765 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307496765;
        // ---------- Original Method ----------
        //return uid;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.430 -0400", hash_original_method = "62E574E9D4A38B83D3EBF8EDA61883B3", hash_generated_method = "8F30AEEDE9013529E2AE4505ED1D99AE")
    public int getGid() {
        int var2D53A8FB7ABF5BE7F4A3CF4B565CC75C_1158811563 = (gid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1910207007 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1910207007;
        // ---------- Original Method ----------
        //return gid;
    }

    
}

