package org.apache.http.impl.conn.tsccm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.conn.AbstractPoolEntry;
import org.apache.http.impl.conn.AbstractPooledConnAdapter;

public class BasicPooledConnAdapter extends AbstractPooledConnAdapter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.009 -0400", hash_original_method = "4CDC3279EB2015FFF1E8970655E8006E", hash_generated_method = "17C73BB7C6AD79FD1B77E9EFDEA8B4D8")
    protected  BasicPooledConnAdapter(ThreadSafeClientConnManager tsccm,
                               AbstractPoolEntry entry) {
        super(tsccm, entry);
        addTaint(entry.getTaint());
        addTaint(tsccm.getTaint());
        markReusable();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.010 -0400", hash_original_method = "278454090484FFAE87CB0693EDFEAA11", hash_generated_method = "BC29CC3F7A7C1C61ACE949F4D89CB49D")
    @Override
    protected ClientConnectionManager getManager() {
ClientConnectionManager varC849884C774128D8E2E0020B5E0605B7_694035498 =         super.getManager();
        varC849884C774128D8E2E0020B5E0605B7_694035498.addTaint(taint);
        return varC849884C774128D8E2E0020B5E0605B7_694035498;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.010 -0400", hash_original_method = "4F37F2CEFFC0BA6EAEA2353029E03EE6", hash_generated_method = "1B6E7AC896F1A707674043F077B07CC3")
    protected AbstractPoolEntry getPoolEntry() {
AbstractPoolEntry var99526DA5D5FF228E32D6E1870AC16D2F_2073577277 =         super.poolEntry;
        var99526DA5D5FF228E32D6E1870AC16D2F_2073577277.addTaint(taint);
        return var99526DA5D5FF228E32D6E1870AC16D2F_2073577277;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.011 -0400", hash_original_method = "E23AB51D98F88854411B8A5D5ACA9D05", hash_generated_method = "275E1AFD9F72E94BE3069F9522C08E46")
    @Override
    protected void detach() {
        super.detach();
        
        
    }

    
}

