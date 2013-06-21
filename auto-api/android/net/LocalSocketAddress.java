package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class LocalSocketAddress {
    private String name;
    private Namespace namespace;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.010 -0400", hash_original_method = "ACE50F43918FAC0899CFC1784787037A", hash_generated_method = "59C1A3DB07E8CC44F749383EA937A9B2")
    @DSModeled(DSC.SAFE)
    public LocalSocketAddress(String name, Namespace namespace) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(namespace.dsTaint);
        // ---------- Original Method ----------
        //this.name = name;
        //this.namespace = namespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.010 -0400", hash_original_method = "66D42DD819FBC28DB7D788D131A117E8", hash_generated_method = "27199BDAA56F55F3F6F6EB6E80E597CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LocalSocketAddress(String name) {
        this(name,Namespace.ABSTRACT);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.010 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "3573899E99121C9CFE87F9DDAEE36810")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.011 -0400", hash_original_method = "F383712D804FA1C6C6A9CA72960DBCA2", hash_generated_method = "4CA486DA6B997BF6502A5FDD8464AB48")
    @DSModeled(DSC.SAFE)
    public Namespace getNamespace() {
        return (Namespace)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return namespace;
    }

    
    public enum Namespace {
        ABSTRACT(0),
        RESERVED(1),
        FILESYSTEM(2);
        private int id;
        Namespace (int id) {
            this.id = id;
        }
         int getId() {
            return id;
        }
    }

    
}

