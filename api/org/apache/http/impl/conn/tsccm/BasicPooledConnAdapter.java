package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.conn.AbstractPoolEntry;
import org.apache.http.impl.conn.AbstractPooledConnAdapter;

public class BasicPooledConnAdapter extends AbstractPooledConnAdapter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.333 -0400", hash_original_method = "4CDC3279EB2015FFF1E8970655E8006E", hash_generated_method = "17C73BB7C6AD79FD1B77E9EFDEA8B4D8")
    protected  BasicPooledConnAdapter(ThreadSafeClientConnManager tsccm,
                               AbstractPoolEntry entry) {
        super(tsccm, entry);
        addTaint(entry.getTaint());
        addTaint(tsccm.getTaint());
        markReusable();
        // ---------- Original Method ----------
        //markReusable();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.333 -0400", hash_original_method = "278454090484FFAE87CB0693EDFEAA11", hash_generated_method = "1798350658ADBC98F4A550080E9B421C")
    @Override
    protected ClientConnectionManager getManager() {
ClientConnectionManager varC849884C774128D8E2E0020B5E0605B7_524594029 =         super.getManager();
        varC849884C774128D8E2E0020B5E0605B7_524594029.addTaint(taint);
        return varC849884C774128D8E2E0020B5E0605B7_524594029;
        // ---------- Original Method ----------
        //return super.getManager();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.333 -0400", hash_original_method = "4F37F2CEFFC0BA6EAEA2353029E03EE6", hash_generated_method = "EE9AD2D475EE2C9FFD0C144FF1407A62")
    protected AbstractPoolEntry getPoolEntry() {
AbstractPoolEntry var99526DA5D5FF228E32D6E1870AC16D2F_669667358 =         super.poolEntry;
        var99526DA5D5FF228E32D6E1870AC16D2F_669667358.addTaint(taint);
        return var99526DA5D5FF228E32D6E1870AC16D2F_669667358;
        // ---------- Original Method ----------
        //return super.poolEntry;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.334 -0400", hash_original_method = "E23AB51D98F88854411B8A5D5ACA9D05", hash_generated_method = "275E1AFD9F72E94BE3069F9522C08E46")
    @Override
    protected void detach() {
        super.detach();
        // ---------- Original Method ----------
        //super.detach();
    }

    
}

