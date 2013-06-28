package org.apache.http.conn.scheme;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class PlainSocketFactory implements SocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.286 -0400", hash_original_field = "FAF84B85401CDF826F3FA5277B6286C9", hash_generated_field = "81E302E459F079F5FBE4C1ED4F82BD8C")

    private HostNameResolver nameResolver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.286 -0400", hash_original_method = "0E5BF5873ABF9DF43E8A566F0715555C", hash_generated_method = "073C079607EBC9301C453AE9002AEF90")
    public  PlainSocketFactory(final HostNameResolver nameResolver) {
        super();
        this.nameResolver = nameResolver;
        // ---------- Original Method ----------
        //this.nameResolver = nameResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.287 -0400", hash_original_method = "CB0B0698D5F49CD73D676E27B7E3296D", hash_generated_method = "FDFEC9028F67BD2583D543616664390B")
    public  PlainSocketFactory() {
        this(null);
        // ---------- Original Method ----------
    }

    
    public static PlainSocketFactory getSocketFactory() {
        return DEFAULT_FACTORY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.287 -0400", hash_original_method = "A3A12F6A184479CE87309C0199F9FB19", hash_generated_method = "44364DACE87855C3B461334F3402912B")
    public Socket createSocket() {
        Socket varB4EAC82CA7396A68D541C85D26508E83_2032126460 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2032126460 = new Socket();
        varB4EAC82CA7396A68D541C85D26508E83_2032126460.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2032126460;
        // ---------- Original Method ----------
        //return new Socket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.288 -0400", hash_original_method = "3F8F2095BF15D67174F7BEAF65F7911A", hash_generated_method = "86CC2DBEE8B000D2C7455659FE9C1832")
    public Socket connectSocket(Socket sock, String host, int port, 
                                InetAddress localAddress, int localPort,
                                HttpParams params) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1518543975 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Target host may not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parameters may not be null.");
        } //End block
        sock = createSocket();
        {
            localPort = 0;
            InetSocketAddress isa = new InetSocketAddress(localAddress, localPort);
            sock.bind(isa);
        } //End block
        int timeout = HttpConnectionParams.getConnectionTimeout(params);
        InetSocketAddress remoteAddress;
        {
            remoteAddress = new InetSocketAddress(this.nameResolver.resolve(host), port);
        } //End block
        {
            remoteAddress = new InetSocketAddress(host, port);
        } //End block
        try 
        {
            sock.connect(remoteAddress, timeout);
        } //End block
        catch (SocketTimeoutException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ConnectTimeoutException("Connect to " + remoteAddress + " timed out");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1518543975 = sock;
        addTaint(sock.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1518543975.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1518543975;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.289 -0400", hash_original_method = "7A2A4752679C8696C148A96F8F50755B", hash_generated_method = "F1AD423DED1920E5DB1520EBADCB7EC5")
    public final boolean isSecure(Socket sock) throws IllegalArgumentException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket may not be null.");
        } //End block
        {
            boolean varDFE99C0BC7B60D5C11521C3F20423928_446147946 = (sock.getClass() != Socket.class);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Socket not created by this factory.");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varEFCDCF8D21AE7A43F6220E08DD901C1F_920322796 = (sock.isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket is closed.");
            } //End block
        } //End collapsed parenthetic
        addTaint(sock.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_555656576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_555656576;
        // ---------- Original Method ----------
        //if (sock == null) {
            //throw new IllegalArgumentException("Socket may not be null.");
        //}
        //if (sock.getClass() != Socket.class) {
            //throw new IllegalArgumentException
                //("Socket not created by this factory.");
        //}
        //if (sock.isClosed()) {
            //throw new IllegalArgumentException("Socket is closed.");
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.290 -0400", hash_original_method = "F7B998F5AE180E31090E44B8A03A92F7", hash_generated_method = "1471D1FE60C6BAC98A8D9C5E6D74F4F5")
    @Override
    public boolean equals(Object obj) {
        boolean varE8FAAD245790C3C0E6D93B5681886C49_423056827 = ((obj == this));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1501910278 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1501910278;
        // ---------- Original Method ----------
        //return (obj == this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.293 -0400", hash_original_method = "EE56C51BBF77F8839109E7F97EF2C650", hash_generated_method = "5AF8BECD12866E000A3B4F12C3E13CFD")
    @Override
    public int hashCode() {
        int varDC06475775C39622F4D2D279D1B4E581_943426593 = (PlainSocketFactory.class.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371630990 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371630990;
        // ---------- Original Method ----------
        //return PlainSocketFactory.class.hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.294 -0400", hash_original_field = "03F7B017E18EF6F6C216ADAE058300E4", hash_generated_field = "65C81C687C7F55312B3A7CFD6F6762B7")

    private static final PlainSocketFactory DEFAULT_FACTORY = new PlainSocketFactory();
}

