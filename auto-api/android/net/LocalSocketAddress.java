package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class LocalSocketAddress {
    private final String name;
    private final Namespace namespace;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.177 -0400", hash_original_method = "ACE50F43918FAC0899CFC1784787037A", hash_generated_method = "A68A950AC5BC77BF8E8BD5AD6430334E")
    @DSModeled(DSC.SAFE)
    public LocalSocketAddress(String name, Namespace namespace) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(namespace.dsTaint);
        // ---------- Original Method ----------
        //this.name = name;
        //this.namespace = namespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.177 -0400", hash_original_method = "66D42DD819FBC28DB7D788D131A117E8", hash_generated_method = "F9761568C3B2538563A7FB9C163D6988")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LocalSocketAddress(String name) {
        this(name,Namespace.ABSTRACT);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.177 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "F47755EA38582EE7C3877DD72123E9B0")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.177 -0400", hash_original_method = "F383712D804FA1C6C6A9CA72960DBCA2", hash_generated_method = "DE867311A2C7BCD577DF921D1D5D96D2")
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


