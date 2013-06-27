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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.934 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "3EF85E4B8326DFDFB5F1248DB5848FBE")

    protected InetAddress address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.934 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    protected int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.934 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "22B1DDEE70BE0A6499271C452045F538")

    protected FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.934 -0400", hash_original_field = "F7439E9867FD6BB737D74ED95E5B79AC", hash_generated_field = "ACF030B7409F7B39EDB4C92454C3B34B")

    protected int localport;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.934 -0400", hash_original_method = "64E339C1199B48FCA9D5B6162E68A4EE", hash_generated_method = "64E339C1199B48FCA9D5B6162E68A4EE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.962 -0400", hash_original_method = "C1B4172ED9A628993584DE4384B8AF55", hash_generated_method = "14211BCDC9063B2DE0DC6C8A0B89FC2A")
    protected FileDescriptor getFileDescriptor() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1899312823 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1899312823 = fd;
        varB4EAC82CA7396A68D541C85D26508E83_1899312823.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1899312823;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.962 -0400", hash_original_method = "D80DA3748C8C317EA54CA4C7D2D15552", hash_generated_method = "B1DCF03715D1B2C5A309C6D802891C32")
    public FileDescriptor getFD$() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_715612515 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_715612515 = fd;
        varB4EAC82CA7396A68D541C85D26508E83_715612515.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_715612515;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.963 -0400", hash_original_method = "9059089CB1C35AC3C53D636B58746A1E", hash_generated_method = "6F4712508A2AD08FBBADDC1EB09AC9A6")
    protected InetAddress getInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1906142061 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1906142061 = address;
        varB4EAC82CA7396A68D541C85D26508E83_1906142061.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1906142061;
        // ---------- Original Method ----------
        //return address;
    }

    
    protected abstract InputStream getInputStream() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.963 -0400", hash_original_method = "01F8313D57DE36AB40371D3553F872FB", hash_generated_method = "0DEE131168A90FB7C6DD069FAEB18216")
    protected int getLocalPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1441830775 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1441830775;
        // ---------- Original Method ----------
        //return localport;
    }

    
    protected abstract OutputStream getOutputStream() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.964 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "F1D54C0385BE9AF206A3C50FB510A564")
    protected int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_840366693 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_840366693;
        // ---------- Original Method ----------
        //return port;
    }

    
    protected abstract void listen(int backlog) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.965 -0400", hash_original_method = "2E2A133215115434551D3BB5177B3CB7", hash_generated_method = "FC4460B80FA3149CCDA7D09260DDA4D7")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_557193788 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_557193788 = "Socket[address=" + getInetAddress() +
                ",port=" + port + ",localPort=" + getLocalPort() + "]";
        varB4EAC82CA7396A68D541C85D26508E83_557193788.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_557193788;
        // ---------- Original Method ----------
        //return "Socket[address=" + getInetAddress() +
                //",port=" + port + ",localPort=" + getLocalPort() + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.977 -0400", hash_original_method = "A81CC3909CCB8928C92493E5F4DBFE10", hash_generated_method = "E925D0506737B4FCC481BAFB05C06DE4")
    protected void shutdownInput() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Method has not been implemented");
        // ---------- Original Method ----------
        //throw new IOException("Method has not been implemented");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.983 -0400", hash_original_method = "C4499DE00FFEC19A29C9ABDAA427CE4E", hash_generated_method = "80CD3DAEE0AF6832955738958B6D9929")
    protected void shutdownOutput() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Method has not been implemented");
        // ---------- Original Method ----------
        //throw new IOException("Method has not been implemented");
    }

    
    protected abstract void connect(SocketAddress remoteAddr, int timeout) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.984 -0400", hash_original_method = "84442B2358C6BD30716C7D72481FD8C4", hash_generated_method = "74E23A5346A9CEE20089F7257CF3D492")
    protected boolean supportsUrgentData() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2055213671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2055213671;
        // ---------- Original Method ----------
        //return false;
    }

    
    protected abstract void sendUrgentData(int value) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.985 -0400", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "DE3FBC58BBCD34A45E35EAE18C0F93DA")
    protected void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        addTaint(connectionTime);
        addTaint(latency);
        addTaint(bandwidth);
        // ---------- Original Method ----------
    }

    
}

