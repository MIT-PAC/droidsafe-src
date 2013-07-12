package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.ref.ReferenceQueue;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.AbstractPoolEntry;

public class BasicPoolEntry extends AbstractPoolEntry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.997 -0400", hash_original_field = "B8AF13EA9C8FE890C9979A1FA8DBDE22", hash_generated_field = "E34C8060B8024F897E4DE2DDC540C297")

    private BasicPoolEntryRef reference;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.998 -0400", hash_original_method = "9CCB47DAF369299C60002AA9C328CEC6", hash_generated_method = "6A43729BE10D205118296AF7C733BC1B")
    public  BasicPoolEntry(ClientConnectionOperator op,
                          HttpRoute route,
                          ReferenceQueue<Object> queue) {
        super(op, route);
        addTaint(route.getTaint());
        addTaint(op.getTaint());
    if(route == null)        
        {
            IllegalArgumentException varFD744275F02EFC64909CB4CC194944E5_148899958 = new IllegalArgumentException("HTTP route may not be null");
            varFD744275F02EFC64909CB4CC194944E5_148899958.addTaint(taint);
            throw varFD744275F02EFC64909CB4CC194944E5_148899958;
        } //End block
        this.reference = new BasicPoolEntryRef(this, queue);
        // ---------- Original Method ----------
        //if (route == null) {
            //throw new IllegalArgumentException("HTTP route may not be null");
        //}
        //this.reference = new BasicPoolEntryRef(this, queue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.998 -0400", hash_original_method = "833089AC155D5F0DD92B0C74A18F2763", hash_generated_method = "4A534C4153A561A98B2765EC0978FB8C")
    protected final OperatedClientConnection getConnection() {
OperatedClientConnection var5BFA9F3364143AB41D8297B301DBEBFA_826042886 =         super.connection;
        var5BFA9F3364143AB41D8297B301DBEBFA_826042886.addTaint(taint);
        return var5BFA9F3364143AB41D8297B301DBEBFA_826042886;
        // ---------- Original Method ----------
        //return super.connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.998 -0400", hash_original_method = "F928965F3078B3981FAC8F2BBDABCB11", hash_generated_method = "30EDDF54242C9CEF6A4E3A78E9695FEB")
    protected final HttpRoute getPlannedRoute() {
HttpRoute varC5F10401C07B57E7F878A1A1BA05EB57_2102075438 =         super.route;
        varC5F10401C07B57E7F878A1A1BA05EB57_2102075438.addTaint(taint);
        return varC5F10401C07B57E7F878A1A1BA05EB57_2102075438;
        // ---------- Original Method ----------
        //return super.route;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.998 -0400", hash_original_method = "A5F0662ECC443ACB4B44B4D02A3B5BBC", hash_generated_method = "942D8A66C69D1DBC97CC799CD5193C26")
    protected final BasicPoolEntryRef getWeakRef() {
BasicPoolEntryRef var29BAF2A5D8FE5ED926C67F1F68BB834A_247399253 =         this.reference;
        var29BAF2A5D8FE5ED926C67F1F68BB834A_247399253.addTaint(taint);
        return var29BAF2A5D8FE5ED926C67F1F68BB834A_247399253;
        // ---------- Original Method ----------
        //return this.reference;
    }

    
}

