package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import org.apache.http.conn.routing.HttpRoute;






public class BasicPoolEntryRef extends WeakReference<BasicPoolEntry> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.926 -0500", hash_original_field = "8824947D446181E666F5CCE159788709", hash_generated_field = "81479629776815A054F50541D8F2C724")

    private  HttpRoute route;


    /**
     * Creates a new reference to a pool entry.
     *
     * @param entry   the pool entry, must not be <code>null</code>
     * @param queue   the reference queue, or <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.929 -0500", hash_original_method = "CD37A3591E91E9E69217B8444E13EA3F", hash_generated_method = "B2522EE3459C1FA0C920B6703052297C")
    
public BasicPoolEntryRef(BasicPoolEntry entry,
                             ReferenceQueue<Object> queue) {
        super(entry, queue);
        if (entry == null) {
            throw new IllegalArgumentException
                ("Pool entry must not be null.");
        }
        route = entry.getPlannedRoute();
    }


    /**
     * Obtain the planned route for the referenced entry.
     * The planned route is still available, even if the entry is gone.
     *
     * @return      the planned route
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.931 -0500", hash_original_method = "70D653A6C3CCC37B9D27B2DACB554C85", hash_generated_method = "CEDA45E567D55F23E75E6004A2646B42")
    
public final HttpRoute getRoute() {
        return this.route;
    }

    
}

