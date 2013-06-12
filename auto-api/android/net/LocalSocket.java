package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.172 -0400", hash_original_method = "FEA4ACACBEC27CDC2E19A445360CDF2B", hash_generated_method = "E7030EAC4756AAEB750471BF833F75DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LocalSocket() {
        this(new LocalSocketImpl());
        isBound = false;
        isConnected = false;
        // ---------- Original Method ----------
        //isBound = false;
        //isConnected = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.172 -0400", hash_original_method = "2CADB18C95425230AEE84C8462CF6B5E", hash_generated_method = "7824B6EF6D4DB4B638536EF4297B0EB3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.173 -0400", hash_original_method = "A3B0926C7F2CA904DDE9677BB08BC75D", hash_generated_method = "355FB23A5E2890369096603604DFE826")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var9AEAD66F032756B767C40E7FD0A885FD_738692114 = (super.toString() + " impl:" + impl);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.toString() + " impl:" + impl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.173 -0400", hash_original_method = "49E5C1FBB8FADEED10B26703F569758C", hash_generated_method = "40507F7C9D702C78233A8B6A783221D0")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.173 -0400", hash_original_method = "FEC40F6E47E3058E55E0DA8C21B29091", hash_generated_method = "69770B4C4EA30731D09B9BFA48BAA29E")
    @DSModeled(DSC.SAFE)
    public void connect(LocalSocketAddress endpoint) throws IOException {
        dsTaint.addTaint(endpoint.dsTaint);
        {
            {
                throw new IOException("already connected");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.173 -0400", hash_original_method = "FAE2FBB89E50156A8576EBEB5A91D0D2", hash_generated_method = "3C0EA13D7A50C46FCFD922604947F3CF")
    @DSModeled(DSC.SAFE)
    public void bind(LocalSocketAddress bindpoint) throws IOException {
        dsTaint.addTaint(bindpoint.dsTaint);
        implCreateIfNeeded();
        {
            {
                throw new IOException("already bound");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.173 -0400", hash_original_method = "E608923787A6482FF0ABAB03074C01F6", hash_generated_method = "295AAD31235F8E1D6C123196F3CC7C95")
    @DSModeled(DSC.SAFE)
    public LocalSocketAddress getLocalSocketAddress() {
        return (LocalSocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.173 -0400", hash_original_method = "DEA6C893F972103692387A11DBA05C46", hash_generated_method = "1446B9CED8660542CF9CEC897AE9EE32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStream getInputStream() throws IOException {
        implCreateIfNeeded();
        InputStream varF6270A204F6CBA0922B73BE390C94FA8_2063096578 = (impl.getInputStream());
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //return impl.getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.173 -0400", hash_original_method = "7FCFFCB2ACC45D6472F8A8A9AE347E00", hash_generated_method = "F703E88BFF9C4D6C64D758C33D44AB07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OutputStream getOutputStream() throws IOException {
        implCreateIfNeeded();
        OutputStream var3644B8EF59184DA0E1B22959A80C9115_1447734119 = (impl.getOutputStream());
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //return impl.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.173 -0400", hash_original_method = "0886675D1825D54CCEFC14FCAD88ED18", hash_generated_method = "87FC3E58436DF56D12D1F5DB49926335")
    @DSModeled(DSC.SAFE)
    public void close() throws IOException {
        implCreateIfNeeded();
        impl.close();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.174 -0400", hash_original_method = "BB45D33ED8970F46DE3174E9794A0506", hash_generated_method = "3FE2222FC68BC4A160CA2728F84C5B44")
    @DSModeled(DSC.SAFE)
    public void shutdownInput() throws IOException {
        implCreateIfNeeded();
        impl.shutdownInput();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //impl.shutdownInput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.174 -0400", hash_original_method = "932CA0951C2BB2888D24DE8156E5EAB6", hash_generated_method = "CA986E03A59ED2C555D395BE0A80BBC9")
    @DSModeled(DSC.SAFE)
    public void shutdownOutput() throws IOException {
        implCreateIfNeeded();
        impl.shutdownOutput();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //impl.shutdownOutput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.174 -0400", hash_original_method = "BF44A21BC401EF66CAA8945E3668C8DF", hash_generated_method = "BAEE7AA64FD82BA94A8008B8D34243C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReceiveBufferSize(int size) throws IOException {
        dsTaint.addTaint(size);
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        // ---------- Original Method ----------
        //impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.174 -0400", hash_original_method = "AB50F13A01F63FCA35BB3E86415EBFEF", hash_generated_method = "6D5A26151BD057D8AEECC9667E38D3FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getReceiveBufferSize() throws IOException {
        int var879D57EDA18A262547327AC0C51A7315_829667564 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.174 -0400", hash_original_method = "4BF0B1F38FAF8905C2B3E64A190023C5", hash_generated_method = "FFB601890804A1F6B6C6585D25507FB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSoTimeout(int n) throws IOException {
        dsTaint.addTaint(n);
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(n));
        // ---------- Original Method ----------
        //impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(n));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.174 -0400", hash_original_method = "669C21804ABD7497EBD82667408E0CF6", hash_generated_method = "4FF478D117FD759B6F18C1313B2A475F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSoTimeout() throws IOException {
        int var97D6E04E407212E66322CDB8618B167A_671788462 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.174 -0400", hash_original_method = "93F75C1311E324895F90364DB9A8A768", hash_generated_method = "FC319978647EF35CEC8A9B7BF1BDDAC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSendBufferSize(int n) throws IOException {
        dsTaint.addTaint(n);
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(n));
        // ---------- Original Method ----------
        //impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(n));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.174 -0400", hash_original_method = "68B16714CB779407E8A17B8680E487D9", hash_generated_method = "3333281643A747AB9F4A13D32562E056")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSendBufferSize() throws IOException {
        int var3BBCE4DA0E6FB31CEB590594F23B0AFE_1457600053 = (((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.174 -0400", hash_original_method = "F9B2122C93F2E3BBD4E1C8511037E48C", hash_generated_method = "4C1FD565C8EBB52C9EF77DC19F5D811B")
    @DSModeled(DSC.SAFE)
    public LocalSocketAddress getRemoteSocketAddress() {
        throw new UnsupportedOperationException();
        return (LocalSocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.175 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "7046B5DA8531C6F5FD4D14415204BE92")
    @DSModeled(DSC.SAFE)
    public synchronized boolean isConnected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isConnected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.175 -0400", hash_original_method = "5FD66514528CC1615B69519702A1D1B0", hash_generated_method = "ACCF9D855AC79BE5C404BBE95901E4E7")
    @DSModeled(DSC.SAFE)
    public boolean isClosed() {
        throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.175 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "713FF31061D35C0EBD8F8A14F5EE34FC")
    @DSModeled(DSC.SAFE)
    public synchronized boolean isBound() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.175 -0400", hash_original_method = "569A2E85196AE41DB2C0A92E12B60282", hash_generated_method = "34FFCAE604B5DBE5AFEAFC607AF5583F")
    @DSModeled(DSC.SAFE)
    public boolean isOutputShutdown() {
        throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.175 -0400", hash_original_method = "0B31CF3D7E3CD09D712DD70672C78FD7", hash_generated_method = "F664714EB662DAFD3B4BDC6FC4A7DC04")
    @DSModeled(DSC.SAFE)
    public boolean isInputShutdown() {
        throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.175 -0400", hash_original_method = "9D1281B98C667F4CB7081490F8B4AA52", hash_generated_method = "B3A08B3163174C38481CD568083CCB03")
    @DSModeled(DSC.SAFE)
    public void connect(LocalSocketAddress endpoint, int timeout) throws IOException {
        dsTaint.addTaint(endpoint.dsTaint);
        dsTaint.addTaint(timeout);
        throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.175 -0400", hash_original_method = "27C53C8DB31C3FA2B713C3C2CC55D90F", hash_generated_method = "569746194E10732F3A002DC9BACACA2D")
    @DSModeled(DSC.SAFE)
    public void setFileDescriptorsForSend(FileDescriptor[] fds) {
        dsTaint.addTaint(fds.dsTaint);
        impl.setFileDescriptorsForSend(fds);
        // ---------- Original Method ----------
        //impl.setFileDescriptorsForSend(fds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.175 -0400", hash_original_method = "447681287166469914CD051884431B5F", hash_generated_method = "6C95D8E151EBC41147FF514DDD27A2C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
        FileDescriptor[] var5F7CACC5722A5D6FE221372D78CAF0F4_1362966535 = (impl.getAncillaryFileDescriptors());
        return (FileDescriptor[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl.getAncillaryFileDescriptors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.175 -0400", hash_original_method = "4616CE50DFB82618FF8C3056DF06E72F", hash_generated_method = "E6EF5E504DB49FB8973D8EDE7146A6D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Credentials getPeerCredentials() throws IOException {
        Credentials varDBCF58324FDE4EE5ECC35280791960F6_1583708042 = (impl.getPeerCredentials());
        return (Credentials)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl.getPeerCredentials();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.175 -0400", hash_original_method = "48E5039C4FB2B8BAB81B3561EAA65E0E", hash_generated_method = "4F05D902F4AC8C8B75E300AD6427252C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor getFileDescriptor() {
        FileDescriptor var597D4329ABDF8C84D1288615FE8B9EEF_1217464997 = (impl.getFileDescriptor());
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl.getFileDescriptor();
    }

    
}


