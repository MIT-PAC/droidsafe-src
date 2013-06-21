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
    private LocalSocketImpl impl;
    private volatile boolean implCreated;
    private LocalSocketAddress localAddress;
    private boolean isBound;
    private boolean isConnected;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.001 -0400", hash_original_method = "FEA4ACACBEC27CDC2E19A445360CDF2B", hash_generated_method = "70B55DA3AAA6C2CD7DEA7A429875B11D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LocalSocket() {
        this(new LocalSocketImpl());
        isBound = false;
        isConnected = false;
        // ---------- Original Method ----------
        //isBound = false;
        //isConnected = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.002 -0400", hash_original_method = "2CADB18C95425230AEE84C8462CF6B5E", hash_generated_method = "D64475BC6C551ED23324536FECB2EC0E")
    @DSModeled(DSC.SAFE)
     LocalSocket(LocalSocketImpl impl) {
        dsTaint.addTaint(impl.dsTaint);
        this.isConnected = false;
        this.isBound = false;
        // ---------- Original Method ----------
        //this.impl = impl;
        //this.isConnected = false;
        //this.isBound = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.002 -0400", hash_original_method = "A3B0926C7F2CA904DDE9677BB08BC75D", hash_generated_method = "2D1675F62E47DB967A211425940FBD8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var9AEAD66F032756B767C40E7FD0A885FD_2103114017 = (super.toString() + " impl:" + impl);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.toString() + " impl:" + impl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.002 -0400", hash_original_method = "49E5C1FBB8FADEED10B26703F569758C", hash_generated_method = "078DA6DB379F3CC6BA8B1AF3E60B38DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.003 -0400", hash_original_method = "FEC40F6E47E3058E55E0DA8C21B29091", hash_generated_method = "8A25B8F1644A4B16507223704F8435C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(LocalSocketAddress endpoint) throws IOException {
        dsTaint.addTaint(endpoint.dsTaint);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("already connected");
            } //End block
            implCreateIfNeeded();
            impl.connect(endpoint, 0);
            isConnected = true;
            isBound = true;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.003 -0400", hash_original_method = "FAE2FBB89E50156A8576EBEB5A91D0D2", hash_generated_method = "ACE8CFD6169BD7D716875894F0CDB7C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bind(LocalSocketAddress bindpoint) throws IOException {
        dsTaint.addTaint(bindpoint.dsTaint);
        implCreateIfNeeded();
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("already bound");
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.003 -0400", hash_original_method = "E608923787A6482FF0ABAB03074C01F6", hash_generated_method = "BE860574D1B1ABDB65C919B33068F998")
    @DSModeled(DSC.SAFE)
    public LocalSocketAddress getLocalSocketAddress() {
        return (LocalSocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.003 -0400", hash_original_method = "DEA6C893F972103692387A11DBA05C46", hash_generated_method = "4718D342C0B0E2A298BB0F9957D5F3B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStream getInputStream() throws IOException {
        implCreateIfNeeded();
        InputStream varF6270A204F6CBA0922B73BE390C94FA8_235853690 = (impl.getInputStream());
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //return impl.getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.004 -0400", hash_original_method = "7FCFFCB2ACC45D6472F8A8A9AE347E00", hash_generated_method = "014AA8D6986D664DBB60218B687C87DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OutputStream getOutputStream() throws IOException {
        implCreateIfNeeded();
        OutputStream var3644B8EF59184DA0E1B22959A80C9115_1366660890 = (impl.getOutputStream());
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //return impl.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.004 -0400", hash_original_method = "0886675D1825D54CCEFC14FCAD88ED18", hash_generated_method = "922BB7FA3F9DD3C5CB082AC311C41C37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() throws IOException {
        implCreateIfNeeded();
        impl.close();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.004 -0400", hash_original_method = "BB45D33ED8970F46DE3174E9794A0506", hash_generated_method = "FEDE8279E077FC7C98C54C9FCAB33B14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void shutdownInput() throws IOException {
        implCreateIfNeeded();
        impl.shutdownInput();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //impl.shutdownInput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.004 -0400", hash_original_method = "932CA0951C2BB2888D24DE8156E5EAB6", hash_generated_method = "6F2FC316C59107CB3BB2642F52208B8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void shutdownOutput() throws IOException {
        implCreateIfNeeded();
        impl.shutdownOutput();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //impl.shutdownOutput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.004 -0400", hash_original_method = "BF44A21BC401EF66CAA8945E3668C8DF", hash_generated_method = "AF4156F01FCFAA840EC784E7A0F557AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReceiveBufferSize(int size) throws IOException {
        dsTaint.addTaint(size);
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        // ---------- Original Method ----------
        //impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.005 -0400", hash_original_method = "AB50F13A01F63FCA35BB3E86415EBFEF", hash_generated_method = "1F53A09C7E9C2DCE8345236E4370B57E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getReceiveBufferSize() throws IOException {
        int var879D57EDA18A262547327AC0C51A7315_105662566 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.005 -0400", hash_original_method = "4BF0B1F38FAF8905C2B3E64A190023C5", hash_generated_method = "C63CD0D4D550402C58DD192EE34E581F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSoTimeout(int n) throws IOException {
        dsTaint.addTaint(n);
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(n));
        // ---------- Original Method ----------
        //impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(n));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.005 -0400", hash_original_method = "669C21804ABD7497EBD82667408E0CF6", hash_generated_method = "002FCB996CBB876C1C57C5B763CE59A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSoTimeout() throws IOException {
        int var97D6E04E407212E66322CDB8618B167A_1652612644 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.005 -0400", hash_original_method = "93F75C1311E324895F90364DB9A8A768", hash_generated_method = "48B460E81BCE4B4D5C56D298CA6085F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSendBufferSize(int n) throws IOException {
        dsTaint.addTaint(n);
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(n));
        // ---------- Original Method ----------
        //impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(n));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.006 -0400", hash_original_method = "68B16714CB779407E8A17B8680E487D9", hash_generated_method = "58DF02212AD7402EC6A2113DE9AB054F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSendBufferSize() throws IOException {
        int var3BBCE4DA0E6FB31CEB590594F23B0AFE_1950756721 = (((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.006 -0400", hash_original_method = "F9B2122C93F2E3BBD4E1C8511037E48C", hash_generated_method = "92AF98B9A546C497571D8852BF79E4FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LocalSocketAddress getRemoteSocketAddress() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (LocalSocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.006 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "D31AA0180863753285560E49BAE920AA")
    @DSModeled(DSC.SAFE)
    public synchronized boolean isConnected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isConnected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.006 -0400", hash_original_method = "5FD66514528CC1615B69519702A1D1B0", hash_generated_method = "E788B9819E1BC3D5DFFADD6B58754CBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isClosed() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.007 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "0777DFD9B6AD78515AAA36DFBA96BCEE")
    @DSModeled(DSC.SAFE)
    public synchronized boolean isBound() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.007 -0400", hash_original_method = "569A2E85196AE41DB2C0A92E12B60282", hash_generated_method = "1501B8F2DAB0182C1DBD18148A9FAB9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOutputShutdown() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.007 -0400", hash_original_method = "0B31CF3D7E3CD09D712DD70672C78FD7", hash_generated_method = "71540123B321E62485182F248BA1823A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInputShutdown() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.007 -0400", hash_original_method = "9D1281B98C667F4CB7081490F8B4AA52", hash_generated_method = "F34447BF84315E89DB0DEAF02CEB959B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(LocalSocketAddress endpoint, int timeout) throws IOException {
        dsTaint.addTaint(timeout);
        dsTaint.addTaint(endpoint.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.007 -0400", hash_original_method = "27C53C8DB31C3FA2B713C3C2CC55D90F", hash_generated_method = "9FA00562BAF05EC0EA6FED076356A315")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFileDescriptorsForSend(FileDescriptor[] fds) {
        dsTaint.addTaint(fds[0].dsTaint);
        impl.setFileDescriptorsForSend(fds);
        // ---------- Original Method ----------
        //impl.setFileDescriptorsForSend(fds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.008 -0400", hash_original_method = "447681287166469914CD051884431B5F", hash_generated_method = "9B57CAD913D3676E5EB9B84A98F268B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
        FileDescriptor[] var5F7CACC5722A5D6FE221372D78CAF0F4_605290081 = (impl.getAncillaryFileDescriptors());
        return (FileDescriptor[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl.getAncillaryFileDescriptors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.008 -0400", hash_original_method = "4616CE50DFB82618FF8C3056DF06E72F", hash_generated_method = "19008CE81C569685906AAE804B02AAA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Credentials getPeerCredentials() throws IOException {
        Credentials varDBCF58324FDE4EE5ECC35280791960F6_1824610208 = (impl.getPeerCredentials());
        return (Credentials)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl.getPeerCredentials();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.008 -0400", hash_original_method = "48E5039C4FB2B8BAB81B3561EAA65E0E", hash_generated_method = "6F9C69B24862FDFDF5465DD65D5FB3A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor getFileDescriptor() {
        FileDescriptor var597D4329ABDF8C84D1288615FE8B9EEF_2097802293 = (impl.getFileDescriptor());
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl.getFileDescriptor();
    }

    
}

