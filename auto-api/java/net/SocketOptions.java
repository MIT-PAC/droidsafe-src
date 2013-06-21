package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface SocketOptions {
    
    public static final int SO_LINGER = 128;

    
    public static final int SO_TIMEOUT = 4102;

    
    public static final int TCP_NODELAY = 1;

    
    public static final int IP_MULTICAST_IF = 16;

    
    public static final int SO_BINDADDR = 15;

    
    public static final int SO_REUSEADDR = 4;

    
    public static final int SO_SNDBUF = 4097;

    
    public static final int SO_RCVBUF = 4098;

    
    public static final int SO_KEEPALIVE = 8;

    
    public static final int IP_TOS = 3;

    
    public static final int IP_MULTICAST_LOOP = 18;

    
    public static final int SO_BROADCAST = 32;

    
    public static final int SO_OOBINLINE = 4099;

    
    public static final int IP_MULTICAST_IF2 = 31;

    
    public Object getOption(int optID) throws SocketException;

    
    public void setOption(int optID, Object val) throws SocketException;
}
