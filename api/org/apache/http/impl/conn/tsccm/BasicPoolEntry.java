package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.ref.ReferenceQueue;

import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.AbstractPoolEntry;






public class BasicPoolEntry extends AbstractPoolEntry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.317 -0400", hash_original_field = "B8AF13EA9C8FE890C9979A1FA8DBDE22", hash_generated_field = "E34C8060B8024F897E4DE2DDC540C297")

    private BasicPoolEntryRef reference;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.318 -0400", hash_original_method = "9CCB47DAF369299C60002AA9C328CEC6", hash_generated_method = "9BBF9EA52E762ED81E1C10784C4E98BD")
    public  BasicPoolEntry(ClientConnectionOperator op,
                          HttpRoute route,
                          ReferenceQueue<Object> queue) {
        super(op, route);
        addTaint(route.getTaint());
        addTaint(op.getTaint());
        if(route == null)        
        {
            IllegalArgumentException varFD744275F02EFC64909CB4CC194944E5_1253588891 = new IllegalArgumentException("HTTP route may not be null");
            varFD744275F02EFC64909CB4CC194944E5_1253588891.addTaint(taint);
            throw varFD744275F02EFC64909CB4CC194944E5_1253588891;
        } //End block
        this.reference = new BasicPoolEntryRef(this, queue);
        // ---------- Original Method ----------
        //if (route == null) {
            //throw new IllegalArgumentException("HTTP route may not be null");
        //}
        //this.reference = new BasicPoolEntryRef(this, queue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.319 -0400", hash_original_method = "833089AC155D5F0DD92B0C74A18F2763", hash_generated_method = "AB66B5291C6C7BD851189997D069BA50")
    protected final OperatedClientConnection getConnection() {
OperatedClientConnection var5BFA9F3364143AB41D8297B301DBEBFA_956021652 =         super.connection;
        var5BFA9F3364143AB41D8297B301DBEBFA_956021652.addTaint(taint);
        return var5BFA9F3364143AB41D8297B301DBEBFA_956021652;
        // ---------- Original Method ----------
        //return super.connection;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.319 -0400", hash_original_method = "F928965F3078B3981FAC8F2BBDABCB11", hash_generated_method = "D14FED9B8A5AE184FD4873D0263CD73E")
    protected final HttpRoute getPlannedRoute() {
HttpRoute varC5F10401C07B57E7F878A1A1BA05EB57_1654771705 =         super.route;
        varC5F10401C07B57E7F878A1A1BA05EB57_1654771705.addTaint(taint);
        return varC5F10401C07B57E7F878A1A1BA05EB57_1654771705;
        // ---------- Original Method ----------
        //return super.route;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.320 -0400", hash_original_method = "A5F0662ECC443ACB4B44B4D02A3B5BBC", hash_generated_method = "5C91004207B98C1314A2FF08C35B4621")
    protected final BasicPoolEntryRef getWeakRef() {
BasicPoolEntryRef var29BAF2A5D8FE5ED926C67F1F68BB834A_1142818898 =         this.reference;
        var29BAF2A5D8FE5ED926C67F1F68BB834A_1142818898.addTaint(taint);
        return var29BAF2A5D8FE5ED926C67F1F68BB834A_1142818898;
        // ---------- Original Method ----------
        //return this.reference;
    }

    
}

