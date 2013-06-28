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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.209 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "9FC425CCAE80D9162FEB6CEC3E95B3C0")

    private LocalSocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.209 -0400", hash_original_field = "6CA1A4DCD7F9826F0C1C2A5C8CCA5D2A", hash_generated_field = "40B4D44783DDD878FE14964CDFAD9280")

    private volatile boolean implCreated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.209 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "998A409B350B5C2296F10AA66491F7E9")

    private LocalSocketAddress localAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.209 -0400", hash_original_field = "8E4D35088206920061AAF7F347854388", hash_generated_field = "C0B93BC213B673FF2E47783C561E2823")

    private boolean isBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.209 -0400", hash_original_field = "8CADFAB0F66545464EF713B1AEC0C7DD", hash_generated_field = "214E866967BF7B324CDA44BDFA9EF130")

    private boolean isConnected;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.209 -0400", hash_original_method = "FEA4ACACBEC27CDC2E19A445360CDF2B", hash_generated_method = "70B55DA3AAA6C2CD7DEA7A429875B11D")
    public  LocalSocket() {
        this(new LocalSocketImpl());
        isBound = false;
        isConnected = false;
        // ---------- Original Method ----------
        //isBound = false;
        //isConnected = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.209 -0400", hash_original_method = "2CADB18C95425230AEE84C8462CF6B5E", hash_generated_method = "186D44CCDDD7EF995914847EFD0B84EF")
      LocalSocket(LocalSocketImpl impl) {
        this.impl = impl;
        this.isConnected = false;
        this.isBound = false;
        // ---------- Original Method ----------
        //this.impl = impl;
        //this.isConnected = false;
        //this.isBound = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.210 -0400", hash_original_method = "A3B0926C7F2CA904DDE9677BB08BC75D", hash_generated_method = "FDF35A32E15C71D37D189A141DD4DAA2")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1114476721 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1114476721 = super.toString() + " impl:" + impl;
        varB4EAC82CA7396A68D541C85D26508E83_1114476721.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1114476721;
        // ---------- Original Method ----------
        //return super.toString() + " impl:" + impl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.210 -0400", hash_original_method = "49E5C1FBB8FADEED10B26703F569758C", hash_generated_method = "078DA6DB379F3CC6BA8B1AF3E60B38DD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.211 -0400", hash_original_method = "FEC40F6E47E3058E55E0DA8C21B29091", hash_generated_method = "D052297D5C4F20EA390A72C89DE0FA54")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.211 -0400", hash_original_method = "FAE2FBB89E50156A8576EBEB5A91D0D2", hash_generated_method = "CDC9A15D7C297121E752740B4BD0A8A6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.212 -0400", hash_original_method = "E608923787A6482FF0ABAB03074C01F6", hash_generated_method = "EADD4E6F4BDE8B7AB6DBA310ADC03B89")
    public LocalSocketAddress getLocalSocketAddress() {
        LocalSocketAddress varB4EAC82CA7396A68D541C85D26508E83_1897809491 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1897809491 = localAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1897809491.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1897809491;
        // ---------- Original Method ----------
        //return localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.213 -0400", hash_original_method = "DEA6C893F972103692387A11DBA05C46", hash_generated_method = "A85E811639C349CFCBE9C346FA2C9DDD")
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_90970196 = null; //Variable for return #1
        implCreateIfNeeded();
        varB4EAC82CA7396A68D541C85D26508E83_90970196 = impl.getInputStream();
        varB4EAC82CA7396A68D541C85D26508E83_90970196.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_90970196;
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //return impl.getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.213 -0400", hash_original_method = "7FCFFCB2ACC45D6472F8A8A9AE347E00", hash_generated_method = "436A000D3ADE18C33AB1873F231ACF3C")
    public OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1114748584 = null; //Variable for return #1
        implCreateIfNeeded();
        varB4EAC82CA7396A68D541C85D26508E83_1114748584 = impl.getOutputStream();
        varB4EAC82CA7396A68D541C85D26508E83_1114748584.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1114748584;
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //return impl.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.213 -0400", hash_original_method = "0886675D1825D54CCEFC14FCAD88ED18", hash_generated_method = "922BB7FA3F9DD3C5CB082AC311C41C37")
    public void close() throws IOException {
        implCreateIfNeeded();
        impl.close();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.214 -0400", hash_original_method = "BB45D33ED8970F46DE3174E9794A0506", hash_generated_method = "FEDE8279E077FC7C98C54C9FCAB33B14")
    public void shutdownInput() throws IOException {
        implCreateIfNeeded();
        impl.shutdownInput();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //impl.shutdownInput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.214 -0400", hash_original_method = "932CA0951C2BB2888D24DE8156E5EAB6", hash_generated_method = "6F2FC316C59107CB3BB2642F52208B8B")
    public void shutdownOutput() throws IOException {
        implCreateIfNeeded();
        impl.shutdownOutput();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //impl.shutdownOutput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.214 -0400", hash_original_method = "BF44A21BC401EF66CAA8945E3668C8DF", hash_generated_method = "B6C7B77590755D5BAA987015C979BFF5")
    public void setReceiveBufferSize(int size) throws IOException {
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        addTaint(size);
        // ---------- Original Method ----------
        //impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.214 -0400", hash_original_method = "AB50F13A01F63FCA35BB3E86415EBFEF", hash_generated_method = "11C75C8A3D99FF10D32F3E6B77DEBD1D")
    public int getReceiveBufferSize() throws IOException {
        int var879D57EDA18A262547327AC0C51A7315_1715704229 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_426577186 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_426577186;
        // ---------- Original Method ----------
        //return ((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.215 -0400", hash_original_method = "4BF0B1F38FAF8905C2B3E64A190023C5", hash_generated_method = "BB2F05222CEA631F71B447AE8859F6F3")
    public void setSoTimeout(int n) throws IOException {
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(n));
        addTaint(n);
        // ---------- Original Method ----------
        //impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(n));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.215 -0400", hash_original_method = "669C21804ABD7497EBD82667408E0CF6", hash_generated_method = "28333E141E592492F530F0C71F88E1FD")
    public int getSoTimeout() throws IOException {
        int var97D6E04E407212E66322CDB8618B167A_1188760548 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728492348 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728492348;
        // ---------- Original Method ----------
        //return ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.215 -0400", hash_original_method = "93F75C1311E324895F90364DB9A8A768", hash_generated_method = "4473A3F43F516786389A1FBEF2B99E01")
    public void setSendBufferSize(int n) throws IOException {
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(n));
        addTaint(n);
        // ---------- Original Method ----------
        //impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(n));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.216 -0400", hash_original_method = "68B16714CB779407E8A17B8680E487D9", hash_generated_method = "85CBA4C1717DB3733436C879AEA96128")
    public int getSendBufferSize() throws IOException {
        int var3BBCE4DA0E6FB31CEB590594F23B0AFE_86011161 = (((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2139521330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2139521330;
        // ---------- Original Method ----------
        //return ((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.216 -0400", hash_original_method = "F9B2122C93F2E3BBD4E1C8511037E48C", hash_generated_method = "C792F183FB2E709EF24CB3BBD46C7852")
    public LocalSocketAddress getRemoteSocketAddress() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.216 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "E886AA4C63FB7579580D1E432AC34033")
    public synchronized boolean isConnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1247944973 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1247944973;
        // ---------- Original Method ----------
        //return isConnected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.217 -0400", hash_original_method = "5FD66514528CC1615B69519702A1D1B0", hash_generated_method = "BB1E88177028B9391405337DED1CD639")
    public boolean isClosed() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1664871465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1664871465;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.218 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "3A48729D58213FCF5080FFBD552BDAE0")
    public synchronized boolean isBound() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_273484646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_273484646;
        // ---------- Original Method ----------
        //return isBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.219 -0400", hash_original_method = "569A2E85196AE41DB2C0A92E12B60282", hash_generated_method = "EF77FAC513295B293C5ECFFBFDE535E6")
    public boolean isOutputShutdown() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1582924110 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1582924110;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.219 -0400", hash_original_method = "0B31CF3D7E3CD09D712DD70672C78FD7", hash_generated_method = "6C7DCD9B9F3C641699BD31326066DE3F")
    public boolean isInputShutdown() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682599443 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_682599443;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.220 -0400", hash_original_method = "9D1281B98C667F4CB7081490F8B4AA52", hash_generated_method = "6D1DE73FED28A1D62252BD325F499B95")
    public void connect(LocalSocketAddress endpoint, int timeout) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(endpoint.getTaint());
        addTaint(timeout);
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.220 -0400", hash_original_method = "27C53C8DB31C3FA2B713C3C2CC55D90F", hash_generated_method = "6256BBB729A64AB978C3C7BD2594719B")
    public void setFileDescriptorsForSend(FileDescriptor[] fds) {
        impl.setFileDescriptorsForSend(fds);
        addTaint(fds[0].getTaint());
        // ---------- Original Method ----------
        //impl.setFileDescriptorsForSend(fds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.221 -0400", hash_original_method = "447681287166469914CD051884431B5F", hash_generated_method = "CD321039DDC537BA14DEE8B559D4B3CF")
    public FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
        FileDescriptor[] varB4EAC82CA7396A68D541C85D26508E83_1305630529 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1305630529 = impl.getAncillaryFileDescriptors();
        varB4EAC82CA7396A68D541C85D26508E83_1305630529.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1305630529;
        // ---------- Original Method ----------
        //return impl.getAncillaryFileDescriptors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.221 -0400", hash_original_method = "4616CE50DFB82618FF8C3056DF06E72F", hash_generated_method = "79B7B4153AA98E3F0527DAB4770B14D5")
    public Credentials getPeerCredentials() throws IOException {
        Credentials varB4EAC82CA7396A68D541C85D26508E83_483504245 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_483504245 = impl.getPeerCredentials();
        varB4EAC82CA7396A68D541C85D26508E83_483504245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_483504245;
        // ---------- Original Method ----------
        //return impl.getPeerCredentials();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.221 -0400", hash_original_method = "48E5039C4FB2B8BAB81B3561EAA65E0E", hash_generated_method = "570C5E7B45432C62A14944CCA184352B")
    public FileDescriptor getFileDescriptor() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_834678971 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_834678971 = impl.getFileDescriptor();
        varB4EAC82CA7396A68D541C85D26508E83_834678971.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_834678971;
        // ---------- Original Method ----------
        //return impl.getFileDescriptor();
    }

    
}

