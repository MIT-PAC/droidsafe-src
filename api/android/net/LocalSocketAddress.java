package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class LocalSocketAddress {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.418 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")


    private  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.419 -0500", hash_original_field = "97EEF6D093E8D4D72F6F6C736C241B6E", hash_generated_field = "8F55F62DFCC7A64A0BD865276D82A096")

    private  Namespace namespace;

    /**
     * Creates an instance with a given name.
     *
     * @param name non-null name
     * @param namespace namespace the name should be created in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.419 -0500", hash_original_method = "ACE50F43918FAC0899CFC1784787037A", hash_generated_method = "8C0AFF252F65474A11A5C25366700AE9")
    public LocalSocketAddress(String name, Namespace namespace) {
        this.name = name;
        this.namespace = namespace;
    }

    /**
     * Creates an instance with a given name in the {@link Namespace#ABSTRACT}
     * namespace
     *
     * @param name non-null name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.420 -0500", hash_original_method = "66D42DD819FBC28DB7D788D131A117E8", hash_generated_method = "9B80B691C4A2A542D633248CFD36020D")
    public LocalSocketAddress(String name) {
        this(name,Namespace.ABSTRACT);
    }

    /**
     * Retrieves the string name of this address
     * @return string name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.421 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    public String getName()
    {
        return name;
    }

    /**
     * Returns the namespace used by this address.
     *
     * @return non-null a namespace
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.422 -0500", hash_original_method = "F383712D804FA1C6C6A9CA72960DBCA2", hash_generated_method = "81D3BAF7554AD06232886A6E215FEBDC")
    public Namespace getNamespace() {
        return namespace;
    }

    
    public enum Namespace {
        ABSTRACT(0),
        RESERVED(1),
        FILESYSTEM(2);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.415 -0500", hash_original_field = "53E65FEF28E32C7EDCD1B07B4F5A0DE3", hash_generated_field = "D0FAB3735D60E909B66356CA0D9609D4")

        private int id;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.416 -0500", hash_original_method = "5B0BC8DECCEEA5A4B859D0AECE510289", hash_generated_method = "5B0BC8DECCEEA5A4B859D0AECE510289")
            Namespace (int id) {
            this.id = id;
        }

        /**
         * @return int constant shared with native code
         */
        /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.416 -0500", hash_original_method = "9E2F8CA3AB278410BC9A2501C7D5731F", hash_generated_method = "9E2F8CA3AB278410BC9A2501C7D5731F")
            int getId() {
            return id;
        }
    }

    
}

