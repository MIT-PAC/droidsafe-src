package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;






public abstract class SocketImpl implements SocketOptions {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.521 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "3EF85E4B8326DFDFB5F1248DB5848FBE")

    protected InetAddress address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.521 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    protected int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.521 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "22B1DDEE70BE0A6499271C452045F538")

    protected FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.521 -0400", hash_original_field = "F7439E9867FD6BB737D74ED95E5B79AC", hash_generated_field = "ACF030B7409F7B39EDB4C92454C3B34B")

    protected int localport;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.521 -0400", hash_original_method = "64E339C1199B48FCA9D5B6162E68A4EE", hash_generated_method = "64E339C1199B48FCA9D5B6162E68A4EE")
    public SocketImpl ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    protected abstract void accept(SocketImpl newSocket) throws IOException;

    
    @DSModeled(DSC.SAFE)
    protected abstract int available() throws IOException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void bind(InetAddress address, int port) throws IOException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void close() throws IOException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void connect(String host, int port) throws IOException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void connect(InetAddress address, int port)
            throws IOException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void create(boolean isStreaming) throws IOException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.522 -0400", hash_original_method = "C1B4172ED9A628993584DE4384B8AF55", hash_generated_method = "977EB489CE8548226F119F7235B3012A")
    protected FileDescriptor getFileDescriptor() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_1096599185 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_1096599185.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_1096599185;
        // ---------- Original Method ----------
        //return fd;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.522 -0400", hash_original_method = "D80DA3748C8C317EA54CA4C7D2D15552", hash_generated_method = "AA650E142070ACBD0222F15F6F81164C")
    public FileDescriptor getFD$() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_1351894141 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_1351894141.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_1351894141;
        // ---------- Original Method ----------
        //return fd;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.522 -0400", hash_original_method = "9059089CB1C35AC3C53D636B58746A1E", hash_generated_method = "8F2C5C88B3F518E36F2DD721061DA2F8")
    protected InetAddress getInetAddress() {
InetAddress var814577DDD37BAFB17E08CBEFDB411BAE_234712589 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_234712589.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_234712589;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract InputStream getInputStream() throws IOException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.522 -0400", hash_original_method = "01F8313D57DE36AB40371D3553F872FB", hash_generated_method = "4C7D221DDCE4EBACEADCF2D1F8B56558")
    protected int getLocalPort() {
        int varF7439E9867FD6BB737D74ED95E5B79AC_1899782938 = (localport);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828988691 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828988691;
        // ---------- Original Method ----------
        //return localport;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract OutputStream getOutputStream() throws IOException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.522 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "786F3FA5C9E627ABA68B3BEE9542F518")
    protected int getPort() {
        int var901555FB06E346CB065CEB9808DCFC25_873490629 = (port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_775871691 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_775871691;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void listen(int backlog) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.522 -0400", hash_original_method = "2E2A133215115434551D3BB5177B3CB7", hash_generated_method = "B8621E300BE4F12EBE891E60D6F92C4E")
    @Override
    public String toString() {
String varB5AD21B00F743A0FBF2E8A6EC3D084B6_1511974577 =         "Socket[address=" + getInetAddress() +
                ",port=" + port + ",localPort=" + getLocalPort() + "]";
        varB5AD21B00F743A0FBF2E8A6EC3D084B6_1511974577.addTaint(taint);
        return varB5AD21B00F743A0FBF2E8A6EC3D084B6_1511974577;
        // ---------- Original Method ----------
        //return "Socket[address=" + getInetAddress() +
                //",port=" + port + ",localPort=" + getLocalPort() + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.523 -0400", hash_original_method = "A81CC3909CCB8928C92493E5F4DBFE10", hash_generated_method = "48755248E5DE9523802E5043E322D12B")
    protected void shutdownInput() throws IOException {
        IOException varE53E7021214DA260366C4F687CD5620E_1673728697 = new IOException("Method has not been implemented");
        varE53E7021214DA260366C4F687CD5620E_1673728697.addTaint(taint);
        throw varE53E7021214DA260366C4F687CD5620E_1673728697;
        // ---------- Original Method ----------
        //throw new IOException("Method has not been implemented");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.523 -0400", hash_original_method = "C4499DE00FFEC19A29C9ABDAA427CE4E", hash_generated_method = "AF899A55485CD0C234308B5775B061BA")
    protected void shutdownOutput() throws IOException {
        IOException varE53E7021214DA260366C4F687CD5620E_1829322703 = new IOException("Method has not been implemented");
        varE53E7021214DA260366C4F687CD5620E_1829322703.addTaint(taint);
        throw varE53E7021214DA260366C4F687CD5620E_1829322703;
        // ---------- Original Method ----------
        //throw new IOException("Method has not been implemented");
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void connect(SocketAddress remoteAddr, int timeout) throws IOException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.523 -0400", hash_original_method = "84442B2358C6BD30716C7D72481FD8C4", hash_generated_method = "9EED475FE6ECE0BCB74D3EF02CEFBF32")
    protected boolean supportsUrgentData() {
        boolean var68934A3E9455FA72420237EB05902327_1743078857 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_868359477 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_868359477;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void sendUrgentData(int value) throws IOException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.523 -0400", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "A2731386B114152B586B93B9733BC462")
    protected void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        addTaint(bandwidth);
        addTaint(latency);
        addTaint(connectionTime);
        // ---------- Original Method ----------
    }

    
}

