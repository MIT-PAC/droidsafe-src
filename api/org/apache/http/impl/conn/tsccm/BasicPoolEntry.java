package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.ReferenceQueue;

import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.AbstractPoolEntry;






public class BasicPoolEntry extends AbstractPoolEntry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.913 -0500", hash_original_field = "E2AE6E9BDF0D1D36130AD506D608303E", hash_generated_field = "E34C8060B8024F897E4DE2DDC540C297")

    private  BasicPoolEntryRef reference;

    /**
     * Creates a new pool entry.
     *
     * @param op      the connection operator
     * @param route   the planned route for the connection
     * @param queue   the reference queue for tracking GC of this entry,
     *                or <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.914 -0500", hash_original_method = "9CCB47DAF369299C60002AA9C328CEC6", hash_generated_method = "69726288CF275F5FB44F90DC86D658A5")
    public BasicPoolEntry(ClientConnectionOperator op,
                          HttpRoute route,
                          ReferenceQueue<Object> queue) {
        super(op, route);
        if (route == null) {
            throw new IllegalArgumentException("HTTP route may not be null");
        }
        this.reference = new BasicPoolEntryRef(this, queue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.914 -0500", hash_original_method = "833089AC155D5F0DD92B0C74A18F2763", hash_generated_method = "6DBABF868B1BA6B5FD49B300E658EAE5")
    protected final OperatedClientConnection getConnection() {
        return super.connection;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.916 -0500", hash_original_method = "F928965F3078B3981FAC8F2BBDABCB11", hash_generated_method = "C2309A7A1D8F39717D367E98C52327E4")
    protected final HttpRoute getPlannedRoute() {
        return super.route;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.916 -0500", hash_original_method = "A5F0662ECC443ACB4B44B4D02A3B5BBC", hash_generated_method = "BAFA0E95FBDC82B5121042D0E44E757B")
    protected final BasicPoolEntryRef getWeakRef() {
        return this.reference;
    }

    
}

