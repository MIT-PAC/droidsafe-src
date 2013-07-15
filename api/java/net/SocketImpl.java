package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class SocketImpl implements SocketOptions {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.299 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "3EF85E4B8326DFDFB5F1248DB5848FBE")

    protected InetAddress address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.300 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    protected int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.300 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "22B1DDEE70BE0A6499271C452045F538")

    protected FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.300 -0400", hash_original_field = "F7439E9867FD6BB737D74ED95E5B79AC", hash_generated_field = "ACF030B7409F7B39EDB4C92454C3B34B")

    protected int localport;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.300 -0400", hash_original_method = "64E339C1199B48FCA9D5B6162E68A4EE", hash_generated_method = "64E339C1199B48FCA9D5B6162E68A4EE")
    public SocketImpl ()
    {
        //Synthesized constructor
    }


    protected abstract void accept(SocketImpl newSocket) throws IOException;

    
    protected abstract int available() throws IOException;

    
    protected abstract void bind(InetAddress address, int port) throws IOException;

    
    protected abstract void close() throws IOException;

    
    protected abstract void connect(String host, int port) throws IOException;

    
    protected abstract void connect(InetAddress address, int port)
            throws IOException;

    
    protected abstract void create(boolean isStreaming) throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.301 -0400", hash_original_method = "C1B4172ED9A628993584DE4384B8AF55", hash_generated_method = "B374A2801461696D3F20B6ED984ADEF3")
    protected FileDescriptor getFileDescriptor() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_431662247 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_431662247.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_431662247;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.302 -0400", hash_original_method = "D80DA3748C8C317EA54CA4C7D2D15552", hash_generated_method = "1C87421B2562248429FA247AD6992575")
    public FileDescriptor getFD$() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_25688054 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_25688054.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_25688054;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.302 -0400", hash_original_method = "9059089CB1C35AC3C53D636B58746A1E", hash_generated_method = "DBDD986C66D74486363469B4C4CF90BE")
    protected InetAddress getInetAddress() {
InetAddress var814577DDD37BAFB17E08CBEFDB411BAE_1895356213 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_1895356213.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_1895356213;
        // ---------- Original Method ----------
        //return address;
    }

    
    protected abstract InputStream getInputStream() throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.303 -0400", hash_original_method = "01F8313D57DE36AB40371D3553F872FB", hash_generated_method = "DCC4D08CCCC0D54A2383A37103230D8F")
    protected int getLocalPort() {
        int varF7439E9867FD6BB737D74ED95E5B79AC_1089432003 = (localport);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531443676 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531443676;
        // ---------- Original Method ----------
        //return localport;
    }

    
    protected abstract OutputStream getOutputStream() throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.303 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "E773B29B246BFF1D1D88FA0040BF9035")
    protected int getPort() {
        int var901555FB06E346CB065CEB9808DCFC25_1907523259 = (port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1780326907 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1780326907;
        // ---------- Original Method ----------
        //return port;
    }

    
    protected abstract void listen(int backlog) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.304 -0400", hash_original_method = "2E2A133215115434551D3BB5177B3CB7", hash_generated_method = "1D2B4B2F932118DD200B51741CA35935")
    @Override
    public String toString() {
String varB5AD21B00F743A0FBF2E8A6EC3D084B6_197176898 =         "Socket[address=" + getInetAddress() +
                ",port=" + port + ",localPort=" + getLocalPort() + "]";
        varB5AD21B00F743A0FBF2E8A6EC3D084B6_197176898.addTaint(taint);
        return varB5AD21B00F743A0FBF2E8A6EC3D084B6_197176898;
        // ---------- Original Method ----------
        //return "Socket[address=" + getInetAddress() +
                //",port=" + port + ",localPort=" + getLocalPort() + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.304 -0400", hash_original_method = "A81CC3909CCB8928C92493E5F4DBFE10", hash_generated_method = "1190F780C01570F5A81C6C72280BD319")
    protected void shutdownInput() throws IOException {
        IOException varE53E7021214DA260366C4F687CD5620E_1755224112 = new IOException("Method has not been implemented");
        varE53E7021214DA260366C4F687CD5620E_1755224112.addTaint(taint);
        throw varE53E7021214DA260366C4F687CD5620E_1755224112;
        // ---------- Original Method ----------
        //throw new IOException("Method has not been implemented");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.304 -0400", hash_original_method = "C4499DE00FFEC19A29C9ABDAA427CE4E", hash_generated_method = "1659F03B24B1572CDE6B427036763C29")
    protected void shutdownOutput() throws IOException {
        IOException varE53E7021214DA260366C4F687CD5620E_2096874758 = new IOException("Method has not been implemented");
        varE53E7021214DA260366C4F687CD5620E_2096874758.addTaint(taint);
        throw varE53E7021214DA260366C4F687CD5620E_2096874758;
        // ---------- Original Method ----------
        //throw new IOException("Method has not been implemented");
    }

    
    protected abstract void connect(SocketAddress remoteAddr, int timeout) throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.305 -0400", hash_original_method = "84442B2358C6BD30716C7D72481FD8C4", hash_generated_method = "808D4DADE0E289F13A6281DEBEF17503")
    protected boolean supportsUrgentData() {
        boolean var68934A3E9455FA72420237EB05902327_2001554333 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1514228410 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1514228410;
        // ---------- Original Method ----------
        //return false;
    }

    
    protected abstract void sendUrgentData(int value) throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.305 -0400", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "A2731386B114152B586B93B9733BC462")
    protected void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        addTaint(bandwidth);
        addTaint(latency);
        addTaint(connectionTime);
        // ---------- Original Method ----------
    }

    
}

