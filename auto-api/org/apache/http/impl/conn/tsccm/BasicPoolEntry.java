package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.ref.ReferenceQueue;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.AbstractPoolEntry;

public class BasicPoolEntry extends AbstractPoolEntry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.657 -0400", hash_original_field = "B8AF13EA9C8FE890C9979A1FA8DBDE22", hash_generated_field = "E34C8060B8024F897E4DE2DDC540C297")

    private BasicPoolEntryRef reference;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.657 -0400", hash_original_method = "9CCB47DAF369299C60002AA9C328CEC6", hash_generated_method = "23DDE5D3D376F3B8A0FF723C07D06B55")
    public  BasicPoolEntry(ClientConnectionOperator op,
                          HttpRoute route,
                          ReferenceQueue<Object> queue) {
        super(op, route);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP route may not be null");
        } //End block
        this.reference = new BasicPoolEntryRef(this, queue);
        addTaint(op.getTaint());
        addTaint(route.getTaint());
        // ---------- Original Method ----------
        //if (route == null) {
            //throw new IllegalArgumentException("HTTP route may not be null");
        //}
        //this.reference = new BasicPoolEntryRef(this, queue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.657 -0400", hash_original_method = "833089AC155D5F0DD92B0C74A18F2763", hash_generated_method = "6556411A6F8E2EF0844D555E9F6A16FC")
    protected final OperatedClientConnection getConnection() {
        OperatedClientConnection varB4EAC82CA7396A68D541C85D26508E83_1174526571 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1174526571 = super.connection;
        varB4EAC82CA7396A68D541C85D26508E83_1174526571.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1174526571;
        // ---------- Original Method ----------
        //return super.connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.658 -0400", hash_original_method = "F928965F3078B3981FAC8F2BBDABCB11", hash_generated_method = "61F076276D5D4AAFFE21D52F158E9845")
    protected final HttpRoute getPlannedRoute() {
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_992276023 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_992276023 = super.route;
        varB4EAC82CA7396A68D541C85D26508E83_992276023.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_992276023;
        // ---------- Original Method ----------
        //return super.route;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.658 -0400", hash_original_method = "A5F0662ECC443ACB4B44B4D02A3B5BBC", hash_generated_method = "BAAF89CD3F146AD7656BE9978DE3D1C5")
    protected final BasicPoolEntryRef getWeakRef() {
        BasicPoolEntryRef varB4EAC82CA7396A68D541C85D26508E83_2079441992 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2079441992 = this.reference;
        varB4EAC82CA7396A68D541C85D26508E83_2079441992.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2079441992;
        // ---------- Original Method ----------
        //return this.reference;
    }

    
}

