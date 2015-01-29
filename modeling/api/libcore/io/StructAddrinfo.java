package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.InetAddress;

public final class StructAddrinfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.092 -0500", hash_original_field = "C5CF875A7E8CDDADF24D227ADCA80C16", hash_generated_field = "F6F5403BFC3EAEF861F1D3595C2A4026")

    public int ai_flags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.094 -0500", hash_original_field = "7EE9D8AA8B132576C7A1CB75BC5EE9AF", hash_generated_field = "D31B9A37ACAE9FE41176DF102CD2C24D")

    public int ai_family;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.097 -0500", hash_original_field = "83FDDA51E0F8C4A4BFC859721D72D811", hash_generated_field = "F4EA79979DE82C7FAF3284FE8C5835BE")

    public int ai_socktype;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.100 -0500", hash_original_field = "DCF909652365919D02314C07B3414A90", hash_generated_field = "F90515C1BD89DA49DC2F89F3BA3162F3")

    public int ai_protocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.102 -0500", hash_original_field = "10B5CCFC24EDAA62BC6D7E2D13F38394", hash_generated_field = "5118BF8BCFEEEFD96BD944A79197CD9A")

    // public int ai_addrlen;

    /** Address. */
    public InetAddress ai_addr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.105 -0500", hash_original_field = "43420D2169D3ACC8FB4E24BA9E993C48", hash_generated_field = "6EF687238B987003796672A6247F4462")

    // public String ai_canonname;

    /** Next element in linked list. */
    public StructAddrinfo ai_next;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.792 -0400", hash_original_method = "71E487CE9D5AA9D0D16EEAF9E114A622", hash_generated_method = "71E487CE9D5AA9D0D16EEAF9E114A622")
    public StructAddrinfo ()
    {
        //Synthesized constructor
    }

}

