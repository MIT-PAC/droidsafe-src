package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class SocketImpl implements SocketOptions {
    protected InetAddress address;
    protected int port;
    protected FileDescriptor fd;
    protected int localport;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.131 -0400", hash_original_method = "9464632CA9D9C95EF067E101A81D9C6D", hash_generated_method = "9464632CA9D9C95EF067E101A81D9C6D")
        public SocketImpl ()
    {
    }


    protected abstract void accept(SocketImpl newSocket) throws IOException;

    
    protected abstract int available() throws IOException;

    
    protected abstract void bind(InetAddress address, int port) throws IOException;

    
    protected abstract void close() throws IOException;

    
    protected abstract void connect(String host, int port) throws IOException;

    
    protected abstract void connect(InetAddress address, int port)
            throws IOException;

    
    protected abstract void create(boolean isStreaming) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.133 -0400", hash_original_method = "C1B4172ED9A628993584DE4384B8AF55", hash_generated_method = "EAD66F9260E01901E44F8BA8437BA9E5")
    @DSModeled(DSC.SAFE)
    protected FileDescriptor getFileDescriptor() {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.133 -0400", hash_original_method = "D80DA3748C8C317EA54CA4C7D2D15552", hash_generated_method = "E5B05F5A70A0675B2A33B08FB7DAFE19")
    @DSModeled(DSC.SAFE)
    public FileDescriptor getFD$() {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.133 -0400", hash_original_method = "9059089CB1C35AC3C53D636B58746A1E", hash_generated_method = "658DA3CDFC61C284AFADAE5574895A6F")
    @DSModeled(DSC.SAFE)
    protected InetAddress getInetAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address;
    }

    
    protected abstract InputStream getInputStream() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.133 -0400", hash_original_method = "01F8313D57DE36AB40371D3553F872FB", hash_generated_method = "9947B39BBFC7915C7BDE7B2372D91A4D")
    @DSModeled(DSC.SAFE)
    protected int getLocalPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return localport;
    }

    
    protected abstract OutputStream getOutputStream() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.133 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "1A29F82D57F7923CA55C6D0E80A15EC2")
    @DSModeled(DSC.SAFE)
    protected int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return port;
    }

    
    protected abstract void listen(int backlog) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.134 -0400", hash_original_method = "2E2A133215115434551D3BB5177B3CB7", hash_generated_method = "2D413382BFCF1F96CE8C8DC1C4B75204")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var02B7FCA7D9022E395F61F3D1E4D94B39_450074234 = ("Socket[address=" + getInetAddress() +
                ",port=" + port + ",localPort=" + getLocalPort() + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Socket[address=" + getInetAddress() +
                //",port=" + port + ",localPort=" + getLocalPort() + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.134 -0400", hash_original_method = "A81CC3909CCB8928C92493E5F4DBFE10", hash_generated_method = "E925D0506737B4FCC481BAFB05C06DE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void shutdownInput() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Method has not been implemented");
        // ---------- Original Method ----------
        //throw new IOException("Method has not been implemented");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.134 -0400", hash_original_method = "C4499DE00FFEC19A29C9ABDAA427CE4E", hash_generated_method = "80CD3DAEE0AF6832955738958B6D9929")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void shutdownOutput() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Method has not been implemented");
        // ---------- Original Method ----------
        //throw new IOException("Method has not been implemented");
    }

    
    protected abstract void connect(SocketAddress remoteAddr, int timeout) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.135 -0400", hash_original_method = "84442B2358C6BD30716C7D72481FD8C4", hash_generated_method = "FB3474151C904A3D2581D2FD62A54A93")
    @DSModeled(DSC.SAFE)
    protected boolean supportsUrgentData() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    protected abstract void sendUrgentData(int value) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.135 -0400", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "1DD58D2ABF733A8E2199A6D2CCE56415")
    @DSModeled(DSC.SAFE)
    protected void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        dsTaint.addTaint(latency);
        dsTaint.addTaint(connectionTime);
        dsTaint.addTaint(bandwidth);
        // ---------- Original Method ----------
    }

    
}

