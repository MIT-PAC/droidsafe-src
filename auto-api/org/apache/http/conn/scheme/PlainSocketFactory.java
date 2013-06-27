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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.408 -0400", hash_original_field = "FAF84B85401CDF826F3FA5277B6286C9", hash_generated_field = "81E302E459F079F5FBE4C1ED4F82BD8C")

    private HostNameResolver nameResolver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.409 -0400", hash_original_method = "0E5BF5873ABF9DF43E8A566F0715555C", hash_generated_method = "073C079607EBC9301C453AE9002AEF90")
    public  PlainSocketFactory(final HostNameResolver nameResolver) {
        super();
        this.nameResolver = nameResolver;
        // ---------- Original Method ----------
        //this.nameResolver = nameResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.409 -0400", hash_original_method = "CB0B0698D5F49CD73D676E27B7E3296D", hash_generated_method = "FDFEC9028F67BD2583D543616664390B")
    public  PlainSocketFactory() {
        this(null);
        // ---------- Original Method ----------
    }

    
        public static PlainSocketFactory getSocketFactory() {
        return DEFAULT_FACTORY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.411 -0400", hash_original_method = "A3A12F6A184479CE87309C0199F9FB19", hash_generated_method = "EAEEE807979F0AB5BF46379BFCF87A59")
    public Socket createSocket() {
        Socket varB4EAC82CA7396A68D541C85D26508E83_823444109 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_823444109 = new Socket();
        varB4EAC82CA7396A68D541C85D26508E83_823444109.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_823444109;
        // ---------- Original Method ----------
        //return new Socket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.412 -0400", hash_original_method = "3F8F2095BF15D67174F7BEAF65F7911A", hash_generated_method = "3553D1C4BD0C2E4778CC2118B1D4962D")
    public Socket connectSocket(Socket sock, String host, int port, 
                                InetAddress localAddress, int localPort,
                                HttpParams params) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1616207580 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Target host may not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parameters may not be null.");
        } //End block
        sock = createSocket();
        {
            localPort = 0;
            InetSocketAddress isa;
            isa = new InetSocketAddress(localAddress, localPort);
            sock.bind(isa);
        } //End block
        int timeout;
        timeout = HttpConnectionParams.getConnectionTimeout(params);
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
        varB4EAC82CA7396A68D541C85D26508E83_1616207580 = sock;
        addTaint(sock.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1616207580.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1616207580;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.412 -0400", hash_original_method = "7A2A4752679C8696C148A96F8F50755B", hash_generated_method = "5C5CEF3516B54D6C50230238D30827A6")
    public final boolean isSecure(Socket sock) throws IllegalArgumentException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket may not be null.");
        } //End block
        {
            boolean varDFE99C0BC7B60D5C11521C3F20423928_1351034912 = (sock.getClass() != Socket.class);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Socket not created by this factory.");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varEFCDCF8D21AE7A43F6220E08DD901C1F_607229002 = (sock.isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket is closed.");
            } //End block
        } //End collapsed parenthetic
        addTaint(sock.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_744163893 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_744163893;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.421 -0400", hash_original_method = "F7B998F5AE180E31090E44B8A03A92F7", hash_generated_method = "C2AD26823A782A461AB16624EB02B347")
    @Override
    public boolean equals(Object obj) {
        boolean varE8FAAD245790C3C0E6D93B5681886C49_923089837 = ((obj == this));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_708031608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_708031608;
        // ---------- Original Method ----------
        //return (obj == this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.421 -0400", hash_original_method = "EE56C51BBF77F8839109E7F97EF2C650", hash_generated_method = "ED0D81630598CC5B584166D422377314")
    @Override
    public int hashCode() {
        int varDC06475775C39622F4D2D279D1B4E581_1508167412 = (PlainSocketFactory.class.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081432423 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081432423;
        // ---------- Original Method ----------
        //return PlainSocketFactory.class.hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.421 -0400", hash_original_field = "03F7B017E18EF6F6C216ADAE058300E4", hash_generated_field = "7B60B32BF063AFAC64260A0D66332691")

    private static PlainSocketFactory DEFAULT_FACTORY = new PlainSocketFactory();
}

