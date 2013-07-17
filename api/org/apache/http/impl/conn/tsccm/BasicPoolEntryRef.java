package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.ref.WeakReference;
import java.lang.ref.ReferenceQueue;
import org.apache.http.conn.routing.HttpRoute;

public class BasicPoolEntryRef extends WeakReference<BasicPoolEntry> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.328 -0400", hash_original_field = "9C46408A3BC655C68505C57A11D6C4EE", hash_generated_field = "81479629776815A054F50541D8F2C724")

    private HttpRoute route;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.328 -0400", hash_original_method = "CD37A3591E91E9E69217B8444E13EA3F", hash_generated_method = "C59E7ECDF477C33250F1AFF3B8523B13")
    public  BasicPoolEntryRef(BasicPoolEntry entry,
                             ReferenceQueue<Object> queue) {
        super(entry, queue);
        addTaint(queue.getTaint());
        if(entry == null)        
        {
            IllegalArgumentException varD6302AFC160661DCD8E9B63B55D40A10_1680738692 = new IllegalArgumentException
                ("Pool entry must not be null.");
            varD6302AFC160661DCD8E9B63B55D40A10_1680738692.addTaint(taint);
            throw varD6302AFC160661DCD8E9B63B55D40A10_1680738692;
        } //End block
        route = entry.getPlannedRoute();
        // ---------- Original Method ----------
        //if (entry == null) {
            //throw new IllegalArgumentException
                //("Pool entry must not be null.");
        //}
        //route = entry.getPlannedRoute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.329 -0400", hash_original_method = "70D653A6C3CCC37B9D27B2DACB554C85", hash_generated_method = "222C2D58F0C8F791B053E8E8BE798AD9")
    public final HttpRoute getRoute() {
HttpRoute varB98EE6416538ED05061231EA0E9F2622_1500046608 =         this.route;
        varB98EE6416538ED05061231EA0E9F2622_1500046608.addTaint(taint);
        return varB98EE6416538ED05061231EA0E9F2622_1500046608;
        // ---------- Original Method ----------
        //return this.route;
    }

    
}

