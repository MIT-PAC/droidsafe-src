package org.apache.http.conn.scheme;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class PlainSocketFactory implements SocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.948 -0400", hash_original_field = "FAF84B85401CDF826F3FA5277B6286C9", hash_generated_field = "81E302E459F079F5FBE4C1ED4F82BD8C")

    private HostNameResolver nameResolver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.949 -0400", hash_original_method = "0E5BF5873ABF9DF43E8A566F0715555C", hash_generated_method = "073C079607EBC9301C453AE9002AEF90")
    public  PlainSocketFactory(final HostNameResolver nameResolver) {
        super();
        this.nameResolver = nameResolver;
        // ---------- Original Method ----------
        //this.nameResolver = nameResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.949 -0400", hash_original_method = "CB0B0698D5F49CD73D676E27B7E3296D", hash_generated_method = "FDFEC9028F67BD2583D543616664390B")
    public  PlainSocketFactory() {
        this(null);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static PlainSocketFactory getSocketFactory() {
        return DEFAULT_FACTORY;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.949 -0400", hash_original_method = "A3A12F6A184479CE87309C0199F9FB19", hash_generated_method = "A843FEEB55E9879C23EA965205163C6F")
    public Socket createSocket() {
Socket var5C6AFEF94E279F279E58F2088BCAD974_512453075 =         new Socket();
        var5C6AFEF94E279F279E58F2088BCAD974_512453075.addTaint(taint);
        return var5C6AFEF94E279F279E58F2088BCAD974_512453075;
        // ---------- Original Method ----------
        //return new Socket();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.951 -0400", hash_original_method = "3F8F2095BF15D67174F7BEAF65F7911A", hash_generated_method = "BD37E622B3CD0AC3429A39F413E17125")
    public Socket connectSocket(Socket sock, String host, int port, 
                                InetAddress localAddress, int localPort,
                                HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(sock.getTaint());
        if(host == null)        
        {
            IllegalArgumentException var0834355F17AB1D6D8F9C33D9EE9B8ED6_1873067330 = new IllegalArgumentException("Target host may not be null.");
            var0834355F17AB1D6D8F9C33D9EE9B8ED6_1873067330.addTaint(taint);
            throw var0834355F17AB1D6D8F9C33D9EE9B8ED6_1873067330;
        } //End block
        if(params == null)        
        {
            IllegalArgumentException varB946B6A484C42AA7AF308B91324BA829_75780356 = new IllegalArgumentException("Parameters may not be null.");
            varB946B6A484C42AA7AF308B91324BA829_75780356.addTaint(taint);
            throw varB946B6A484C42AA7AF308B91324BA829_75780356;
        } //End block
        if(sock == null)        
        sock = createSocket();
        if((localAddress != null) || (localPort > 0))        
        {
            if(localPort < 0)            
            localPort = 0;
            InetSocketAddress isa = new InetSocketAddress(localAddress, localPort);
            sock.bind(isa);
        } //End block
        int timeout = HttpConnectionParams.getConnectionTimeout(params);
        InetSocketAddress remoteAddress;
        if(this.nameResolver != null)        
        {
            remoteAddress = new InetSocketAddress(this.nameResolver.resolve(host), port);
        } //End block
        else
        {
            remoteAddress = new InetSocketAddress(host, port);
        } //End block
        try 
        {
            sock.connect(remoteAddress, timeout);
        } //End block
        catch (SocketTimeoutException ex)
        {
            ConnectTimeoutException var9655AA76DA6C8530C04A0E35AF8CBBFE_965574947 = new ConnectTimeoutException("Connect to " + remoteAddress + " timed out");
            var9655AA76DA6C8530C04A0E35AF8CBBFE_965574947.addTaint(taint);
            throw var9655AA76DA6C8530C04A0E35AF8CBBFE_965574947;
        } //End block
Socket var947470A701CF490B15CD8DA4BCF73C48_987719783 =         sock;
        var947470A701CF490B15CD8DA4BCF73C48_987719783.addTaint(taint);
        return var947470A701CF490B15CD8DA4BCF73C48_987719783;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.952 -0400", hash_original_method = "7A2A4752679C8696C148A96F8F50755B", hash_generated_method = "E058D0B4E92D99A5E3AC3D74F292AFE6")
    public final boolean isSecure(Socket sock) throws IllegalArgumentException {
        addTaint(sock.getTaint());
        if(sock == null)        
        {
            IllegalArgumentException var908C00FEC12FB3D0085E3AFEF63E364D_2088334933 = new IllegalArgumentException("Socket may not be null.");
            var908C00FEC12FB3D0085E3AFEF63E364D_2088334933.addTaint(taint);
            throw var908C00FEC12FB3D0085E3AFEF63E364D_2088334933;
        } //End block
        if(sock.getClass() != Socket.class)        
        {
            IllegalArgumentException var745F34B2140DE0EF716D2801F4BA086F_359262754 = new IllegalArgumentException
                ("Socket not created by this factory.");
            var745F34B2140DE0EF716D2801F4BA086F_359262754.addTaint(taint);
            throw var745F34B2140DE0EF716D2801F4BA086F_359262754;
        } //End block
        if(sock.isClosed())        
        {
            IllegalArgumentException varE6A53A17C2E2D099F5EDA38E621B0B3B_90831333 = new IllegalArgumentException("Socket is closed.");
            varE6A53A17C2E2D099F5EDA38E621B0B3B_90831333.addTaint(taint);
            throw varE6A53A17C2E2D099F5EDA38E621B0B3B_90831333;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_998700118 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1510964990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1510964990;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.952 -0400", hash_original_method = "F7B998F5AE180E31090E44B8A03A92F7", hash_generated_method = "459BD7EC5F5CA22147142DA3F0F9FECF")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        boolean var78E9DE0F621EDF49A095572411B9271D_270418489 = ((obj == this));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_960961218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_960961218;
        // ---------- Original Method ----------
        //return (obj == this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.953 -0400", hash_original_method = "EE56C51BBF77F8839109E7F97EF2C650", hash_generated_method = "70F2B2D3A6AC6DE1C45930C691644ABD")
    @Override
    public int hashCode() {
        int var1D473F209976599464E66C30AF2045A7_629950204 = (PlainSocketFactory.class.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_465928958 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_465928958;
        // ---------- Original Method ----------
        //return PlainSocketFactory.class.hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.953 -0400", hash_original_field = "03F7B017E18EF6F6C216ADAE058300E4", hash_generated_field = "65C81C687C7F55312B3A7CFD6F6762B7")

    private static final PlainSocketFactory DEFAULT_FACTORY = new PlainSocketFactory();
}

