package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.InetAddress;

public final class StructAddrinfo {
    public int ai_flags;
    public int ai_family;
    public int ai_socktype;
    public int ai_protocol;
    public InetAddress ai_addr;
    public StructAddrinfo ai_next;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.017 -0400", hash_original_method = "0661454BF6203BADAD210EDA22C7017E", hash_generated_method = "0661454BF6203BADAD210EDA22C7017E")
        public StructAddrinfo ()
    {
    }


}

