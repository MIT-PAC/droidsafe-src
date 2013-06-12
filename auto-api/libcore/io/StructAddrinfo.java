package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.net.InetAddress;

public final class StructAddrinfo {
    public int ai_flags;
    public int ai_family;
    public int ai_socktype;
    public int ai_protocol;
    public InetAddress ai_addr;
    public StructAddrinfo ai_next;
    
}


