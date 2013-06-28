package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.conn.AbstractPoolEntry;
import org.apache.http.impl.conn.AbstractPooledConnAdapter;

public class BasicPooledConnAdapter extends AbstractPooledConnAdapter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.668 -0400", hash_original_method = "4CDC3279EB2015FFF1E8970655E8006E", hash_generated_method = "CBFDC4A0FBA9B03D05008B0BA96518E8")
    protected  BasicPooledConnAdapter(ThreadSafeClientConnManager tsccm,
                               AbstractPoolEntry entry) {
        super(tsccm, entry);
        markReusable();
        addTaint(tsccm.getTaint());
        addTaint(entry.getTaint());
        // ---------- Original Method ----------
        //markReusable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.669 -0400", hash_original_method = "278454090484FFAE87CB0693EDFEAA11", hash_generated_method = "1D89E4DB299DA3CBB40F223DC72ED73C")
    @Override
    protected ClientConnectionManager getManager() {
        ClientConnectionManager varB4EAC82CA7396A68D541C85D26508E83_1393072871 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1393072871 = super.getManager();
        varB4EAC82CA7396A68D541C85D26508E83_1393072871.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1393072871;
        // ---------- Original Method ----------
        //return super.getManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.669 -0400", hash_original_method = "4F37F2CEFFC0BA6EAEA2353029E03EE6", hash_generated_method = "69B4AAFD047838E3EA775A8666198EA5")
    protected AbstractPoolEntry getPoolEntry() {
        AbstractPoolEntry varB4EAC82CA7396A68D541C85D26508E83_97731189 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_97731189 = super.poolEntry;
        varB4EAC82CA7396A68D541C85D26508E83_97731189.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_97731189;
        // ---------- Original Method ----------
        //return super.poolEntry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.669 -0400", hash_original_method = "E23AB51D98F88854411B8A5D5ACA9D05", hash_generated_method = "275E1AFD9F72E94BE3069F9522C08E46")
    @Override
    protected void detach() {
        super.detach();
        // ---------- Original Method ----------
        //super.detach();
    }

    
}

