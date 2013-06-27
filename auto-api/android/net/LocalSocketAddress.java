package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class LocalSocketAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.840 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.841 -0400", hash_original_field = "89801E9E98979062E84647433A8ED3E9", hash_generated_field = "8F55F62DFCC7A64A0BD865276D82A096")

    private Namespace namespace;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.842 -0400", hash_original_method = "ACE50F43918FAC0899CFC1784787037A", hash_generated_method = "FE1E334F7DF4398364F7B6F1ED51B831")
    public  LocalSocketAddress(String name, Namespace namespace) {
        this.name = name;
        this.namespace = namespace;
        // ---------- Original Method ----------
        //this.name = name;
        //this.namespace = namespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.842 -0400", hash_original_method = "66D42DD819FBC28DB7D788D131A117E8", hash_generated_method = "61E02D07874E00F6E285A0B31501C3C1")
    public  LocalSocketAddress(String name) {
        this(name,Namespace.ABSTRACT);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.843 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "6EEC511A72531B17594F8BB620E68D9E")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1883819074 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1883819074 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1883819074.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1883819074;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.844 -0400", hash_original_method = "F383712D804FA1C6C6A9CA72960DBCA2", hash_generated_method = "03FABC4466B97038D89837B75531BCDC")
    public Namespace getNamespace() {
        Namespace varB4EAC82CA7396A68D541C85D26508E83_842981057 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_842981057 = namespace;
        varB4EAC82CA7396A68D541C85D26508E83_842981057.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_842981057;
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

