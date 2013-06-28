package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class LocalSocketAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.227 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.227 -0400", hash_original_field = "89801E9E98979062E84647433A8ED3E9", hash_generated_field = "8F55F62DFCC7A64A0BD865276D82A096")

    private Namespace namespace;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.228 -0400", hash_original_method = "ACE50F43918FAC0899CFC1784787037A", hash_generated_method = "FE1E334F7DF4398364F7B6F1ED51B831")
    public  LocalSocketAddress(String name, Namespace namespace) {
        this.name = name;
        this.namespace = namespace;
        // ---------- Original Method ----------
        //this.name = name;
        //this.namespace = namespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.228 -0400", hash_original_method = "66D42DD819FBC28DB7D788D131A117E8", hash_generated_method = "61E02D07874E00F6E285A0B31501C3C1")
    public  LocalSocketAddress(String name) {
        this(name,Namespace.ABSTRACT);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.228 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "B4BBB0BA1485251A231704EAFEA2A6AC")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_56186881 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_56186881 = name;
        varB4EAC82CA7396A68D541C85D26508E83_56186881.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_56186881;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.229 -0400", hash_original_method = "F383712D804FA1C6C6A9CA72960DBCA2", hash_generated_method = "7835E71A860EE3AE47DC3DA7F073A2E2")
    public Namespace getNamespace() {
        Namespace varB4EAC82CA7396A68D541C85D26508E83_1758167743 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1758167743 = namespace;
        varB4EAC82CA7396A68D541C85D26508E83_1758167743.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1758167743;
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

