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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.917 -0400", hash_original_field = "B8AF13EA9C8FE890C9979A1FA8DBDE22", hash_generated_field = "E34C8060B8024F897E4DE2DDC540C297")

    private BasicPoolEntryRef reference;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.917 -0400", hash_original_method = "9CCB47DAF369299C60002AA9C328CEC6", hash_generated_method = "23DDE5D3D376F3B8A0FF723C07D06B55")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.919 -0400", hash_original_method = "833089AC155D5F0DD92B0C74A18F2763", hash_generated_method = "6B3303F408D021F883904E74D84296A7")
    protected final OperatedClientConnection getConnection() {
        OperatedClientConnection varB4EAC82CA7396A68D541C85D26508E83_746146512 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_746146512 = super.connection;
        varB4EAC82CA7396A68D541C85D26508E83_746146512.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_746146512;
        // ---------- Original Method ----------
        //return super.connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.923 -0400", hash_original_method = "F928965F3078B3981FAC8F2BBDABCB11", hash_generated_method = "259E85FD18B149484A9F37F753692957")
    protected final HttpRoute getPlannedRoute() {
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_922639129 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_922639129 = super.route;
        varB4EAC82CA7396A68D541C85D26508E83_922639129.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_922639129;
        // ---------- Original Method ----------
        //return super.route;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.924 -0400", hash_original_method = "A5F0662ECC443ACB4B44B4D02A3B5BBC", hash_generated_method = "CEEC1D94B641DE51867AE0A92F6FFEAB")
    protected final BasicPoolEntryRef getWeakRef() {
        BasicPoolEntryRef varB4EAC82CA7396A68D541C85D26508E83_752549896 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_752549896 = this.reference;
        varB4EAC82CA7396A68D541C85D26508E83_752549896.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_752549896;
        // ---------- Original Method ----------
        //return this.reference;
    }

    
}

