package android.net;

// Droidsafe Imports
import droidsafe.annotations.*;





public class LocalSocketAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.238 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.238 -0400", hash_original_field = "89801E9E98979062E84647433A8ED3E9", hash_generated_field = "8F55F62DFCC7A64A0BD865276D82A096")

    private Namespace namespace;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.238 -0400", hash_original_method = "ACE50F43918FAC0899CFC1784787037A", hash_generated_method = "FE1E334F7DF4398364F7B6F1ED51B831")
    public  LocalSocketAddress(String name, Namespace namespace) {
        this.name = name;
        this.namespace = namespace;
        // ---------- Original Method ----------
        //this.name = name;
        //this.namespace = namespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.238 -0400", hash_original_method = "66D42DD819FBC28DB7D788D131A117E8", hash_generated_method = "61E02D07874E00F6E285A0B31501C3C1")
    public  LocalSocketAddress(String name) {
        this(name,Namespace.ABSTRACT);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.238 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "2D3C2BA67BE7CBA1DFAAB561847E59CE")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_2054829333 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_2054829333.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_2054829333;
        // ---------- Original Method ----------
        //return name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.238 -0400", hash_original_method = "F383712D804FA1C6C6A9CA72960DBCA2", hash_generated_method = "3911CA079AAB508FBD14E02D4CC1B54B")
    public Namespace getNamespace() {
Namespace varF28472CCCF41AB611991133D8001D83B_1341393879 =         namespace;
        varF28472CCCF41AB611991133D8001D83B_1341393879.addTaint(taint);
        return varF28472CCCF41AB611991133D8001D83B_1341393879;
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
         @DSModeled(DSC.SAFE)
        int getId() {
            return id;
        }
    }

    
}

