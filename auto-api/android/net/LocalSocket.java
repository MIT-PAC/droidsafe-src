package android.net;

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
import java.net.SocketOptions;

public class LocalSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.857 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "9FC425CCAE80D9162FEB6CEC3E95B3C0")

    private LocalSocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.857 -0400", hash_original_field = "6CA1A4DCD7F9826F0C1C2A5C8CCA5D2A", hash_generated_field = "40B4D44783DDD878FE14964CDFAD9280")

    private volatile boolean implCreated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.857 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "998A409B350B5C2296F10AA66491F7E9")

    private LocalSocketAddress localAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.857 -0400", hash_original_field = "8E4D35088206920061AAF7F347854388", hash_generated_field = "C0B93BC213B673FF2E47783C561E2823")

    private boolean isBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.857 -0400", hash_original_field = "8CADFAB0F66545464EF713B1AEC0C7DD", hash_generated_field = "214E866967BF7B324CDA44BDFA9EF130")

    private boolean isConnected;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.861 -0400", hash_original_method = "FEA4ACACBEC27CDC2E19A445360CDF2B", hash_generated_method = "70B55DA3AAA6C2CD7DEA7A429875B11D")
    public  LocalSocket() {
        this(new LocalSocketImpl());
        isBound = false;
        isConnected = false;
        // ---------- Original Method ----------
        //isBound = false;
        //isConnected = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.862 -0400", hash_original_method = "2CADB18C95425230AEE84C8462CF6B5E", hash_generated_method = "186D44CCDDD7EF995914847EFD0B84EF")
      LocalSocket(LocalSocketImpl impl) {
        this.impl = impl;
        this.isConnected = false;
        this.isBound = false;
        // ---------- Original Method ----------
        //this.impl = impl;
        //this.isConnected = false;
        //this.isBound = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.870 -0400", hash_original_method = "A3B0926C7F2CA904DDE9677BB08BC75D", hash_generated_method = "7AA3FB0F469DB4BF636D750DA74197EB")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_216962343 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_216962343 = super.toString() + " impl:" + impl;
        varB4EAC82CA7396A68D541C85D26508E83_216962343.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_216962343;
        // ---------- Original Method ----------
        //return super.toString() + " impl:" + impl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.871 -0400", hash_original_method = "49E5C1FBB8FADEED10B26703F569758C", hash_generated_method = "078DA6DB379F3CC6BA8B1AF3E60B38DD")
    private void implCreateIfNeeded() throws IOException {
        {
            {
                {
                    try 
                    {
                        impl.create(true);
                    } //End block
                    finally 
                    {
                        implCreated = true;
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!implCreated) {
            //synchronized (this) {
                //if (!implCreated) {
                    //try {
                        //impl.create(true);
                    //} finally {
                        //implCreated = true;
                    //}
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.872 -0400", hash_original_method = "FEC40F6E47E3058E55E0DA8C21B29091", hash_generated_method = "D052297D5C4F20EA390A72C89DE0FA54")
    public void connect(LocalSocketAddress endpoint) throws IOException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("already connected");
            } //End block
            implCreateIfNeeded();
            impl.connect(endpoint, 0);
            isConnected = true;
            isBound = true;
        } //End block
        addTaint(endpoint.getTaint());
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (isConnected) {
                //throw new IOException("already connected");
            //}
            //implCreateIfNeeded();
            //impl.connect(endpoint, 0);
            //isConnected = true;
            //isBound = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.887 -0400", hash_original_method = "FAE2FBB89E50156A8576EBEB5A91D0D2", hash_generated_method = "CDC9A15D7C297121E752740B4BD0A8A6")
    public void bind(LocalSocketAddress bindpoint) throws IOException {
        implCreateIfNeeded();
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("already bound");
            } //End block
            localAddress = bindpoint;
            impl.bind(localAddress);
            isBound = true;
        } //End block
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //synchronized (this) {
            //if (isBound) {
                //throw new IOException("already bound");
            //}
            //localAddress = bindpoint;
            //impl.bind(localAddress);
            //isBound = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.887 -0400", hash_original_method = "E608923787A6482FF0ABAB03074C01F6", hash_generated_method = "438D46E1C4857DD7A3A0A79D7378A07F")
    public LocalSocketAddress getLocalSocketAddress() {
        LocalSocketAddress varB4EAC82CA7396A68D541C85D26508E83_1707541858 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1707541858 = localAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1707541858.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1707541858;
        // ---------- Original Method ----------
        //return localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.896 -0400", hash_original_method = "DEA6C893F972103692387A11DBA05C46", hash_generated_method = "A1CEEA008244DF39768F0EE4B6D16D69")
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_914314002 = null; //Variable for return #1
        implCreateIfNeeded();
        varB4EAC82CA7396A68D541C85D26508E83_914314002 = impl.getInputStream();
        varB4EAC82CA7396A68D541C85D26508E83_914314002.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_914314002;
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //return impl.getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.897 -0400", hash_original_method = "7FCFFCB2ACC45D6472F8A8A9AE347E00", hash_generated_method = "5D23C31B4927C00D0FEBCB43092294DF")
    public OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1942696886 = null; //Variable for return #1
        implCreateIfNeeded();
        varB4EAC82CA7396A68D541C85D26508E83_1942696886 = impl.getOutputStream();
        varB4EAC82CA7396A68D541C85D26508E83_1942696886.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1942696886;
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //return impl.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.897 -0400", hash_original_method = "0886675D1825D54CCEFC14FCAD88ED18", hash_generated_method = "922BB7FA3F9DD3C5CB082AC311C41C37")
    public void close() throws IOException {
        implCreateIfNeeded();
        impl.close();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.898 -0400", hash_original_method = "BB45D33ED8970F46DE3174E9794A0506", hash_generated_method = "FEDE8279E077FC7C98C54C9FCAB33B14")
    public void shutdownInput() throws IOException {
        implCreateIfNeeded();
        impl.shutdownInput();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //impl.shutdownInput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.908 -0400", hash_original_method = "932CA0951C2BB2888D24DE8156E5EAB6", hash_generated_method = "6F2FC316C59107CB3BB2642F52208B8B")
    public void shutdownOutput() throws IOException {
        implCreateIfNeeded();
        impl.shutdownOutput();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //impl.shutdownOutput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.909 -0400", hash_original_method = "BF44A21BC401EF66CAA8945E3668C8DF", hash_generated_method = "B6C7B77590755D5BAA987015C979BFF5")
    public void setReceiveBufferSize(int size) throws IOException {
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        addTaint(size);
        // ---------- Original Method ----------
        //impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.909 -0400", hash_original_method = "AB50F13A01F63FCA35BB3E86415EBFEF", hash_generated_method = "E3E179FA40389AE42C0D534AC6CAE736")
    public int getReceiveBufferSize() throws IOException {
        int var879D57EDA18A262547327AC0C51A7315_726982507 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1722416999 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1722416999;
        // ---------- Original Method ----------
        //return ((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.910 -0400", hash_original_method = "4BF0B1F38FAF8905C2B3E64A190023C5", hash_generated_method = "BB2F05222CEA631F71B447AE8859F6F3")
    public void setSoTimeout(int n) throws IOException {
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(n));
        addTaint(n);
        // ---------- Original Method ----------
        //impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(n));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.910 -0400", hash_original_method = "669C21804ABD7497EBD82667408E0CF6", hash_generated_method = "1D80680ABAE77522FDC3FF9DA944CE3E")
    public int getSoTimeout() throws IOException {
        int var97D6E04E407212E66322CDB8618B167A_1048278865 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567868072 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567868072;
        // ---------- Original Method ----------
        //return ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.917 -0400", hash_original_method = "93F75C1311E324895F90364DB9A8A768", hash_generated_method = "4473A3F43F516786389A1FBEF2B99E01")
    public void setSendBufferSize(int n) throws IOException {
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(n));
        addTaint(n);
        // ---------- Original Method ----------
        //impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(n));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.917 -0400", hash_original_method = "68B16714CB779407E8A17B8680E487D9", hash_generated_method = "52C7F5C6DC54E3E1EF01AEA9A709E42A")
    public int getSendBufferSize() throws IOException {
        int var3BBCE4DA0E6FB31CEB590594F23B0AFE_1699683294 = (((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784557027 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784557027;
        // ---------- Original Method ----------
        //return ((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.928 -0400", hash_original_method = "F9B2122C93F2E3BBD4E1C8511037E48C", hash_generated_method = "C792F183FB2E709EF24CB3BBD46C7852")
    public LocalSocketAddress getRemoteSocketAddress() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.929 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "E0241BD952334EC887216A18A924057C")
    public synchronized boolean isConnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2141145552 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2141145552;
        // ---------- Original Method ----------
        //return isConnected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.930 -0400", hash_original_method = "5FD66514528CC1615B69519702A1D1B0", hash_generated_method = "55FEFD60AC9CB9AC3E09299AEB5324F1")
    public boolean isClosed() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_525579699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_525579699;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.937 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "6F17E7DF1FD678C2934F8F9EBA476C6C")
    public synchronized boolean isBound() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_755321199 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_755321199;
        // ---------- Original Method ----------
        //return isBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.941 -0400", hash_original_method = "569A2E85196AE41DB2C0A92E12B60282", hash_generated_method = "E57CC55F277CB876FA5CD0577D9BFE32")
    public boolean isOutputShutdown() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1637922652 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1637922652;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.942 -0400", hash_original_method = "0B31CF3D7E3CD09D712DD70672C78FD7", hash_generated_method = "EEE69637D93C7F821BA894FB4285FDD0")
    public boolean isInputShutdown() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_457627545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_457627545;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.942 -0400", hash_original_method = "9D1281B98C667F4CB7081490F8B4AA52", hash_generated_method = "6D1DE73FED28A1D62252BD325F499B95")
    public void connect(LocalSocketAddress endpoint, int timeout) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(endpoint.getTaint());
        addTaint(timeout);
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.944 -0400", hash_original_method = "27C53C8DB31C3FA2B713C3C2CC55D90F", hash_generated_method = "6256BBB729A64AB978C3C7BD2594719B")
    public void setFileDescriptorsForSend(FileDescriptor[] fds) {
        impl.setFileDescriptorsForSend(fds);
        addTaint(fds[0].getTaint());
        // ---------- Original Method ----------
        //impl.setFileDescriptorsForSend(fds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.945 -0400", hash_original_method = "447681287166469914CD051884431B5F", hash_generated_method = "BD5DD05506F2B1CA0A6F25777B08C7C0")
    public FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
        FileDescriptor[] varB4EAC82CA7396A68D541C85D26508E83_712557698 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_712557698 = impl.getAncillaryFileDescriptors();
        varB4EAC82CA7396A68D541C85D26508E83_712557698.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_712557698;
        // ---------- Original Method ----------
        //return impl.getAncillaryFileDescriptors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.945 -0400", hash_original_method = "4616CE50DFB82618FF8C3056DF06E72F", hash_generated_method = "2E5A21D98C812269DC58F10B93AB3B72")
    public Credentials getPeerCredentials() throws IOException {
        Credentials varB4EAC82CA7396A68D541C85D26508E83_1293560808 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1293560808 = impl.getPeerCredentials();
        varB4EAC82CA7396A68D541C85D26508E83_1293560808.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1293560808;
        // ---------- Original Method ----------
        //return impl.getPeerCredentials();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.975 -0400", hash_original_method = "48E5039C4FB2B8BAB81B3561EAA65E0E", hash_generated_method = "5A07DECB92676179B31CD3EB2606822F")
    public FileDescriptor getFileDescriptor() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1883861842 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1883861842 = impl.getFileDescriptor();
        varB4EAC82CA7396A68D541C85D26508E83_1883861842.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1883861842;
        // ---------- Original Method ----------
        //return impl.getFileDescriptor();
    }

    
}

