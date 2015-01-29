package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.conn.AbstractPoolEntry;
import org.apache.http.impl.conn.AbstractPooledConnAdapter;

public class BasicPooledConnAdapter extends AbstractPooledConnAdapter {

    /**
     * Creates a new adapter.
     *
     * @param tsccm   the connection manager
     * @param entry   the pool entry for the connection being wrapped
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.692 -0500", hash_original_method = "4CDC3279EB2015FFF1E8970655E8006E", hash_generated_method = "E942CE3FCDFD5B8FC3A18A55AD7302D6")
    
protected BasicPooledConnAdapter(ThreadSafeClientConnManager tsccm,
                               AbstractPoolEntry entry) {
        super(tsccm, entry);
        markReusable();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.695 -0500", hash_original_method = "278454090484FFAE87CB0693EDFEAA11", hash_generated_method = "7BE0FC895E550BB5A0B6208CB68CD71D")
    
@Override
    protected ClientConnectionManager getManager() {
        // override needed only to make method visible in this package
        return super.getManager();
    }

    /**
     * Obtains the pool entry.
     *
     * @return  the pool entry, or <code>null</code> if detached
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.697 -0500", hash_original_method = "4F37F2CEFFC0BA6EAEA2353029E03EE6", hash_generated_method = "131C894029FFCDCBAFAF169DB22826D9")
    
protected AbstractPoolEntry getPoolEntry() {
        return super.poolEntry;
    }

    // non-javadoc, see base class
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.699 -0500", hash_original_method = "E23AB51D98F88854411B8A5D5ACA9D05", hash_generated_method = "E5A0A89C9C7CC29013B36BFA6AAB281F")
    
@Override
    protected void detach() {
        // override needed only to make method visible in this package
        super.detach();
    }
    
}

