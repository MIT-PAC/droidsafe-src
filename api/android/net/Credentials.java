package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class Credentials {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.940 -0500", hash_original_field = "3D9A6B8E69012AA56F160CA7CCE3CF4F", hash_generated_field = "DBFF83134AA84403D6020EBC0053D7A1")

    private  int pid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.942 -0500", hash_original_field = "12FA9B6FF5DE3157A8BC781F3445534B", hash_generated_field = "4BAD495D6F9082D5BF8F64A6BBA7B8D1")

    private  int uid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.944 -0500", hash_original_field = "348B89EEBBB5FD5838C41F12F0D7CCCB", hash_generated_field = "8B22ADD2CDC200DB70C94C9AD2F2F61A")

    private  int gid;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.947 -0500", hash_original_method = "0D22AAF944E180A41FC070C17248D99F", hash_generated_method = "69DACC8200E4B2DF396379E2167384AB")
    
public Credentials (int pid, int uid, int gid) {
        this.pid = pid;
        this.uid = uid;
        this.gid = gid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.949 -0500", hash_original_method = "78D1E6D4CA2C23604540BE821B70C9C5", hash_generated_method = "980667DF96582A274AEAA8FAA1B2584F")
    
public int getPid() {
        return pid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.951 -0500", hash_original_method = "0C7AA9282DA1BA7425530FB39ADDE6D7", hash_generated_method = "93770B61D624C62663149A1B94B28294")
    
public int getUid() {
        return uid;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.953 -0500", hash_original_method = "62E574E9D4A38B83D3EBF8EDA61883B3", hash_generated_method = "800ACB6005B58D1D72218E54439FFDA6")
    
public int getGid() {
        return gid;
    }

    
}

