package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.ref.WeakReference;
import java.lang.ref.ReferenceQueue;
import org.apache.http.conn.routing.HttpRoute;

public class BasicPoolEntryRef extends WeakReference<BasicPoolEntry> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.003 -0400", hash_original_field = "9C46408A3BC655C68505C57A11D6C4EE", hash_generated_field = "81479629776815A054F50541D8F2C724")

    private HttpRoute route;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.003 -0400", hash_original_method = "CD37A3591E91E9E69217B8444E13EA3F", hash_generated_method = "24E0D8FE06645D3767946D918736A6CC")
    public  BasicPoolEntryRef(BasicPoolEntry entry,
                             ReferenceQueue<Object> queue) {
        super(entry, queue);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Pool entry must not be null.");
        } //End block
        route = entry.getPlannedRoute();
        addTaint(queue.getTaint());
        // ---------- Original Method ----------
        //if (entry == null) {
            //throw new IllegalArgumentException
                //("Pool entry must not be null.");
        //}
        //route = entry.getPlannedRoute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.004 -0400", hash_original_method = "70D653A6C3CCC37B9D27B2DACB554C85", hash_generated_method = "D3FCB4CC89C95871508197788BA9876A")
    public final HttpRoute getRoute() {
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_28575051 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_28575051 = this.route;
        varB4EAC82CA7396A68D541C85D26508E83_28575051.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_28575051;
        // ---------- Original Method ----------
        //return this.route;
    }

    
}

