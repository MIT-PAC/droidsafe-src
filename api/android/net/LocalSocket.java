package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketOptions;

public class LocalSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.535 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "9FC425CCAE80D9162FEB6CEC3E95B3C0")

    private LocalSocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.536 -0400", hash_original_field = "6CA1A4DCD7F9826F0C1C2A5C8CCA5D2A", hash_generated_field = "40B4D44783DDD878FE14964CDFAD9280")

    private volatile boolean implCreated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.536 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "998A409B350B5C2296F10AA66491F7E9")

    private LocalSocketAddress localAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.536 -0400", hash_original_field = "8E4D35088206920061AAF7F347854388", hash_generated_field = "C0B93BC213B673FF2E47783C561E2823")

    private boolean isBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.536 -0400", hash_original_field = "8CADFAB0F66545464EF713B1AEC0C7DD", hash_generated_field = "214E866967BF7B324CDA44BDFA9EF130")

    private boolean isConnected;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.536 -0400", hash_original_method = "FEA4ACACBEC27CDC2E19A445360CDF2B", hash_generated_method = "70B55DA3AAA6C2CD7DEA7A429875B11D")
    public  LocalSocket() {
        this(new LocalSocketImpl());
        isBound = false;
        isConnected = false;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.537 -0400", hash_original_method = "2CADB18C95425230AEE84C8462CF6B5E", hash_generated_method = "186D44CCDDD7EF995914847EFD0B84EF")
      LocalSocket(LocalSocketImpl impl) {
        this.impl = impl;
        this.isConnected = false;
        this.isBound = false;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.538 -0400", hash_original_method = "A3B0926C7F2CA904DDE9677BB08BC75D", hash_generated_method = "284150BFF37BD17C55BD9CD1BCE51353")
    @Override
    public String toString() {
String varB72CC91AEA19C7FA7F561237F68286D5_1793670505 =         super.toString() + " impl:" + impl;
        varB72CC91AEA19C7FA7F561237F68286D5_1793670505.addTaint(taint);
        return varB72CC91AEA19C7FA7F561237F68286D5_1793670505;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.539 -0400", hash_original_method = "49E5C1FBB8FADEED10B26703F569758C", hash_generated_method = "E97F390D5B90898224E50DEC51FEE172")
    private void implCreateIfNeeded() throws IOException {
    if(!implCreated)        
        {
            synchronized
(this)            {
    if(!implCreated)                
                {
                    try 
                    {
                        impl.create(true);
                    } 
                    finally 
                    {
                        implCreated = true;
                    } 
                } 
            } 
        } 
        
        
            
                
                    
                        
                    
                        
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.540 -0400", hash_original_method = "FEC40F6E47E3058E55E0DA8C21B29091", hash_generated_method = "BAFFB3225205003845AEEAAB9E0D6758")
    public void connect(LocalSocketAddress endpoint) throws IOException {
        addTaint(endpoint.getTaint());
        synchronized
(this)        {
    if(isConnected)            
            {
                IOException varAD6FEB2EAAB3E3E5352A4783E25F2C9C_291085662 = new IOException("already connected");
                varAD6FEB2EAAB3E3E5352A4783E25F2C9C_291085662.addTaint(taint);
                throw varAD6FEB2EAAB3E3E5352A4783E25F2C9C_291085662;
            } 
            implCreateIfNeeded();
            impl.connect(endpoint, 0);
            isConnected = true;
            isBound = true;
        } 
        
        
            
                
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.541 -0400", hash_original_method = "FAE2FBB89E50156A8576EBEB5A91D0D2", hash_generated_method = "F3A9085685C28C7E661076FE4A242886")
    public void bind(LocalSocketAddress bindpoint) throws IOException {
        implCreateIfNeeded();
        synchronized
(this)        {
    if(isBound)            
            {
                IOException var401930F119456FF1A65BA8C77BE2F312_1004324466 = new IOException("already bound");
                var401930F119456FF1A65BA8C77BE2F312_1004324466.addTaint(taint);
                throw var401930F119456FF1A65BA8C77BE2F312_1004324466;
            } 
            localAddress = bindpoint;
            impl.bind(localAddress);
            isBound = true;
        } 
        
        
        
            
                
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.542 -0400", hash_original_method = "E608923787A6482FF0ABAB03074C01F6", hash_generated_method = "FDDBB7B201E177729C27E5F20E535125")
    public LocalSocketAddress getLocalSocketAddress() {
LocalSocketAddress varAD2ECC3D59386A6CEBDBFE5B70B7F72A_1725295271 =         localAddress;
        varAD2ECC3D59386A6CEBDBFE5B70B7F72A_1725295271.addTaint(taint);
        return varAD2ECC3D59386A6CEBDBFE5B70B7F72A_1725295271;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.543 -0400", hash_original_method = "DEA6C893F972103692387A11DBA05C46", hash_generated_method = "7BAA8F3ED33F01606FBDE674A08077EB")
    public InputStream getInputStream() throws IOException {
        implCreateIfNeeded();
InputStream varA0C6C26B40703E7D9482EAE0B79E45D2_164679106 =         impl.getInputStream();
        varA0C6C26B40703E7D9482EAE0B79E45D2_164679106.addTaint(taint);
        return varA0C6C26B40703E7D9482EAE0B79E45D2_164679106;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.543 -0400", hash_original_method = "7FCFFCB2ACC45D6472F8A8A9AE347E00", hash_generated_method = "5073F3288393636E2623DBC9081EA339")
    public OutputStream getOutputStream() throws IOException {
        implCreateIfNeeded();
OutputStream var8CC2DA174DA31DFA9BB5041834194E8D_382074666 =         impl.getOutputStream();
        var8CC2DA174DA31DFA9BB5041834194E8D_382074666.addTaint(taint);
        return var8CC2DA174DA31DFA9BB5041834194E8D_382074666;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.544 -0400", hash_original_method = "0886675D1825D54CCEFC14FCAD88ED18", hash_generated_method = "922BB7FA3F9DD3C5CB082AC311C41C37")
    public void close() throws IOException {
        implCreateIfNeeded();
        impl.close();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.544 -0400", hash_original_method = "BB45D33ED8970F46DE3174E9794A0506", hash_generated_method = "FEDE8279E077FC7C98C54C9FCAB33B14")
    public void shutdownInput() throws IOException {
        implCreateIfNeeded();
        impl.shutdownInput();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.544 -0400", hash_original_method = "932CA0951C2BB2888D24DE8156E5EAB6", hash_generated_method = "6F2FC316C59107CB3BB2642F52208B8B")
    public void shutdownOutput() throws IOException {
        implCreateIfNeeded();
        impl.shutdownOutput();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.545 -0400", hash_original_method = "BF44A21BC401EF66CAA8945E3668C8DF", hash_generated_method = "48C38BD90D529DA17119BD0CB5304A15")
    public void setReceiveBufferSize(int size) throws IOException {
        addTaint(size);
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.545 -0400", hash_original_method = "AB50F13A01F63FCA35BB3E86415EBFEF", hash_generated_method = "A3E95C5622D1976C28D7E2F44C560AF3")
    public int getReceiveBufferSize() throws IOException {
        int varE81451D5C828E046B43EDC22DB07479E_1788741948 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1601647232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1601647232;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.545 -0400", hash_original_method = "4BF0B1F38FAF8905C2B3E64A190023C5", hash_generated_method = "343FFCC9F6DCC1EDBC6B9473355AA6F5")
    public void setSoTimeout(int n) throws IOException {
        addTaint(n);
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(n));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.546 -0400", hash_original_method = "669C21804ABD7497EBD82667408E0CF6", hash_generated_method = "32AFA0EDF4DE70308214F941B2B63BD8")
    public int getSoTimeout() throws IOException {
        int varD9ED706581E59D8A02AABC09446C91B3_1873645458 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_373266258 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_373266258;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.546 -0400", hash_original_method = "93F75C1311E324895F90364DB9A8A768", hash_generated_method = "F56B99BA21CF2F841EA66921526E21E1")
    public void setSendBufferSize(int n) throws IOException {
        addTaint(n);
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(n));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.546 -0400", hash_original_method = "68B16714CB779407E8A17B8680E487D9", hash_generated_method = "ECA08707D425DEBF1F78EDC6A125E606")
    public int getSendBufferSize() throws IOException {
        int var30D2E319E9C2929AD28B20E6E58446D9_77733339 = (((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_66824052 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_66824052;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.547 -0400", hash_original_method = "F9B2122C93F2E3BBD4E1C8511037E48C", hash_generated_method = "34776366DF946CA7BFBF6D8414918868")
    public LocalSocketAddress getRemoteSocketAddress() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1824209341 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1824209341.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1824209341;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.547 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "1B3531055F8ADC5D6FBE76FBFC2331BB")
    public synchronized boolean isConnected() {
        boolean var8CADFAB0F66545464EF713B1AEC0C7DD_2026983560 = (isConnected);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_431622379 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_431622379;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.547 -0400", hash_original_method = "5FD66514528CC1615B69519702A1D1B0", hash_generated_method = "31A4D5C6C7E905D08E622310984134E8")
    public boolean isClosed() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_433834149 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_433834149.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_433834149;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.547 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "14AA8CEBE195BF53ACBE23DC9889471F")
    public synchronized boolean isBound() {
        boolean var8E4D35088206920061AAF7F347854388_1147701814 = (isBound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_24711474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_24711474;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.548 -0400", hash_original_method = "569A2E85196AE41DB2C0A92E12B60282", hash_generated_method = "9287016C0A1083F9EDCCF9E8B467F911")
    public boolean isOutputShutdown() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1368337909 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1368337909.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1368337909;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.548 -0400", hash_original_method = "0B31CF3D7E3CD09D712DD70672C78FD7", hash_generated_method = "BD4DF5E0A55AEEB36A32B5B73195FB50")
    public boolean isInputShutdown() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1985889827 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1985889827.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1985889827;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.548 -0400", hash_original_method = "9D1281B98C667F4CB7081490F8B4AA52", hash_generated_method = "1C5CEE052DFE0992FFFF3727B0881B8C")
    public void connect(LocalSocketAddress endpoint, int timeout) throws IOException {
        addTaint(timeout);
        addTaint(endpoint.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_594594677 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_594594677.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_594594677;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.549 -0400", hash_original_method = "27C53C8DB31C3FA2B713C3C2CC55D90F", hash_generated_method = "F47152BF7E3EEB4820A7559571F96013")
    public void setFileDescriptorsForSend(FileDescriptor[] fds) {
        addTaint(fds[0].getTaint());
        impl.setFileDescriptorsForSend(fds);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.549 -0400", hash_original_method = "447681287166469914CD051884431B5F", hash_generated_method = "2041626C9C2C375CEAC9FC9D854681C7")
    public FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
FileDescriptor[] var39C3634A2A1EE5C474896187D63364C3_1521927711 =         impl.getAncillaryFileDescriptors();
        var39C3634A2A1EE5C474896187D63364C3_1521927711.addTaint(taint);
        return var39C3634A2A1EE5C474896187D63364C3_1521927711;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.549 -0400", hash_original_method = "4616CE50DFB82618FF8C3056DF06E72F", hash_generated_method = "BDC132C0B8CA334A7D2A104728D99DFA")
    public Credentials getPeerCredentials() throws IOException {
Credentials var6122CE1776E20B8EED790D65216238CF_1774459056 =         impl.getPeerCredentials();
        var6122CE1776E20B8EED790D65216238CF_1774459056.addTaint(taint);
        return var6122CE1776E20B8EED790D65216238CF_1774459056;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.550 -0400", hash_original_method = "48E5039C4FB2B8BAB81B3561EAA65E0E", hash_generated_method = "7E8C7EA3DA491DDC91E66F2C3E5ECF57")
    public FileDescriptor getFileDescriptor() {
FileDescriptor var05E29FE12AB06423EE2D8B05D08F76BE_2030520617 =         impl.getFileDescriptor();
        var05E29FE12AB06423EE2D8B05D08F76BE_2030520617.addTaint(taint);
        return var05E29FE12AB06423EE2D8B05D08F76BE_2030520617;
        
        
    }

    
}

