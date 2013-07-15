package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.ref.WeakReference;
import java.lang.ref.ReferenceQueue;
import org.apache.http.conn.routing.HttpRoute;

public class BasicPoolEntryRef extends WeakReference<BasicPoolEntry> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.004 -0400", hash_original_field = "9C46408A3BC655C68505C57A11D6C4EE", hash_generated_field = "81479629776815A054F50541D8F2C724")

    private HttpRoute route;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.004 -0400", hash_original_method = "CD37A3591E91E9E69217B8444E13EA3F", hash_generated_method = "9717DEE59BF0FB335FE011512A8D10E1")
    public  BasicPoolEntryRef(BasicPoolEntry entry,
                             ReferenceQueue<Object> queue) {
        super(entry, queue);
        addTaint(queue.getTaint());
    if(entry == null)        
        {
            IllegalArgumentException varD6302AFC160661DCD8E9B63B55D40A10_1991837704 = new IllegalArgumentException
                ("Pool entry must not be null.");
            varD6302AFC160661DCD8E9B63B55D40A10_1991837704.addTaint(taint);
            throw varD6302AFC160661DCD8E9B63B55D40A10_1991837704;
        } //End block
        route = entry.getPlannedRoute();
        // ---------- Original Method ----------
        //if (entry == null) {
            //throw new IllegalArgumentException
                //("Pool entry must not be null.");
        //}
        //route = entry.getPlannedRoute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.004 -0400", hash_original_method = "70D653A6C3CCC37B9D27B2DACB554C85", hash_generated_method = "BD50EF875662C3677D26C00B5B4646D6")
    public final HttpRoute getRoute() {
HttpRoute varB98EE6416538ED05061231EA0E9F2622_2020790081 =         this.route;
        varB98EE6416538ED05061231EA0E9F2622_2020790081.addTaint(taint);
        return varB98EE6416538ED05061231EA0E9F2622_2020790081;
        // ---------- Original Method ----------
        //return this.route;
    }

    
}

