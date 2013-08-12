package android.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketOptions;






public class LocalSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.209 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "9FC425CCAE80D9162FEB6CEC3E95B3C0")

    private LocalSocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.209 -0400", hash_original_field = "6CA1A4DCD7F9826F0C1C2A5C8CCA5D2A", hash_generated_field = "40B4D44783DDD878FE14964CDFAD9280")

    private volatile boolean implCreated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.209 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "998A409B350B5C2296F10AA66491F7E9")

    private LocalSocketAddress localAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.209 -0400", hash_original_field = "8E4D35088206920061AAF7F347854388", hash_generated_field = "C0B93BC213B673FF2E47783C561E2823")

    private boolean isBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.209 -0400", hash_original_field = "8CADFAB0F66545464EF713B1AEC0C7DD", hash_generated_field = "214E866967BF7B324CDA44BDFA9EF130")

    private boolean isConnected;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.210 -0400", hash_original_method = "FEA4ACACBEC27CDC2E19A445360CDF2B", hash_generated_method = "70B55DA3AAA6C2CD7DEA7A429875B11D")
    public  LocalSocket() {
        this(new LocalSocketImpl());
        isBound = false;
        isConnected = false;
        // ---------- Original Method ----------
        //isBound = false;
        //isConnected = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.230 -0400", hash_original_method = "2CADB18C95425230AEE84C8462CF6B5E", hash_generated_method = "186D44CCDDD7EF995914847EFD0B84EF")
      LocalSocket(LocalSocketImpl impl) {
        this.impl = impl;
        this.isConnected = false;
        this.isBound = false;
        // ---------- Original Method ----------
        //this.impl = impl;
        //this.isConnected = false;
        //this.isBound = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.231 -0400", hash_original_method = "A3B0926C7F2CA904DDE9677BB08BC75D", hash_generated_method = "42E999EB23DA7A01B6B222FB340824F6")
    @Override
    public String toString() {
String varB72CC91AEA19C7FA7F561237F68286D5_955232733 =         super.toString() + " impl:" + impl;
        varB72CC91AEA19C7FA7F561237F68286D5_955232733.addTaint(taint);
        return varB72CC91AEA19C7FA7F561237F68286D5_955232733;
        // ---------- Original Method ----------
        //return super.toString() + " impl:" + impl;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.231 -0400", hash_original_method = "49E5C1FBB8FADEED10B26703F569758C", hash_generated_method = "E97F390D5B90898224E50DEC51FEE172")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.231 -0400", hash_original_method = "FEC40F6E47E3058E55E0DA8C21B29091", hash_generated_method = "23EBFA095832747E9F8A67CE02C6DA77")
    public void connect(LocalSocketAddress endpoint) throws IOException {
        addTaint(endpoint.getTaint());
        synchronized
(this)        {
            if(isConnected)            
            {
                IOException varAD6FEB2EAAB3E3E5352A4783E25F2C9C_2082548741 = new IOException("already connected");
                varAD6FEB2EAAB3E3E5352A4783E25F2C9C_2082548741.addTaint(taint);
                throw varAD6FEB2EAAB3E3E5352A4783E25F2C9C_2082548741;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.231 -0400", hash_original_method = "FAE2FBB89E50156A8576EBEB5A91D0D2", hash_generated_method = "881544B9DC97A8E7915711FF5D2E622D")
    public void bind(LocalSocketAddress bindpoint) throws IOException {
        implCreateIfNeeded();
        synchronized
(this)        {
            if(isBound)            
            {
                IOException var401930F119456FF1A65BA8C77BE2F312_1532591231 = new IOException("already bound");
                var401930F119456FF1A65BA8C77BE2F312_1532591231.addTaint(taint);
                throw var401930F119456FF1A65BA8C77BE2F312_1532591231;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.232 -0400", hash_original_method = "E608923787A6482FF0ABAB03074C01F6", hash_generated_method = "78A0A4D78E8F767BACA1EF075929FE93")
    public LocalSocketAddress getLocalSocketAddress() {
LocalSocketAddress varAD2ECC3D59386A6CEBDBFE5B70B7F72A_2015261535 =         localAddress;
        varAD2ECC3D59386A6CEBDBFE5B70B7F72A_2015261535.addTaint(taint);
        return varAD2ECC3D59386A6CEBDBFE5B70B7F72A_2015261535;
        // ---------- Original Method ----------
        //return localAddress;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.232 -0400", hash_original_method = "DEA6C893F972103692387A11DBA05C46", hash_generated_method = "533C4C8E1C1894394E518692A378F60A")
    public InputStream getInputStream() throws IOException {
        implCreateIfNeeded();
InputStream varA0C6C26B40703E7D9482EAE0B79E45D2_790956824 =         impl.getInputStream();
        varA0C6C26B40703E7D9482EAE0B79E45D2_790956824.addTaint(taint);
        return varA0C6C26B40703E7D9482EAE0B79E45D2_790956824;
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //return impl.getInputStream();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.232 -0400", hash_original_method = "7FCFFCB2ACC45D6472F8A8A9AE347E00", hash_generated_method = "9FA979783E36CCAD07962C03DBE4F0C5")
    public OutputStream getOutputStream() throws IOException {
        implCreateIfNeeded();
OutputStream var8CC2DA174DA31DFA9BB5041834194E8D_1391704260 =         impl.getOutputStream();
        var8CC2DA174DA31DFA9BB5041834194E8D_1391704260.addTaint(taint);
        return var8CC2DA174DA31DFA9BB5041834194E8D_1391704260;
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //return impl.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.232 -0400", hash_original_method = "0886675D1825D54CCEFC14FCAD88ED18", hash_generated_method = "922BB7FA3F9DD3C5CB082AC311C41C37")
    public void close() throws IOException {
        implCreateIfNeeded();
        impl.close();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.232 -0400", hash_original_method = "BB45D33ED8970F46DE3174E9794A0506", hash_generated_method = "FEDE8279E077FC7C98C54C9FCAB33B14")
    public void shutdownInput() throws IOException {
        implCreateIfNeeded();
        impl.shutdownInput();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //impl.shutdownInput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.232 -0400", hash_original_method = "932CA0951C2BB2888D24DE8156E5EAB6", hash_generated_method = "6F2FC316C59107CB3BB2642F52208B8B")
    public void shutdownOutput() throws IOException {
        implCreateIfNeeded();
        impl.shutdownOutput();
        // ---------- Original Method ----------
        //implCreateIfNeeded();
        //impl.shutdownOutput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.233 -0400", hash_original_method = "BF44A21BC401EF66CAA8945E3668C8DF", hash_generated_method = "48C38BD90D529DA17119BD0CB5304A15")
    public void setReceiveBufferSize(int size) throws IOException {
        addTaint(size);
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        // ---------- Original Method ----------
        //impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.233 -0400", hash_original_method = "AB50F13A01F63FCA35BB3E86415EBFEF", hash_generated_method = "7FDAFD2013E096F6B2A284B1C067C277")
    public int getReceiveBufferSize() throws IOException {
        int varE81451D5C828E046B43EDC22DB07479E_2058520622 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231037835 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231037835;
        // ---------- Original Method ----------
        //return ((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.233 -0400", hash_original_method = "4BF0B1F38FAF8905C2B3E64A190023C5", hash_generated_method = "343FFCC9F6DCC1EDBC6B9473355AA6F5")
    public void setSoTimeout(int n) throws IOException {
        addTaint(n);
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(n));
        // ---------- Original Method ----------
        //impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(n));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.233 -0400", hash_original_method = "669C21804ABD7497EBD82667408E0CF6", hash_generated_method = "6A8B069F5CCBD60E317EEBBFE1967E89")
    public int getSoTimeout() throws IOException {
        int varD9ED706581E59D8A02AABC09446C91B3_2000896599 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124159880 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124159880;
        // ---------- Original Method ----------
        //return ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.233 -0400", hash_original_method = "93F75C1311E324895F90364DB9A8A768", hash_generated_method = "F56B99BA21CF2F841EA66921526E21E1")
    public void setSendBufferSize(int n) throws IOException {
        addTaint(n);
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(n));
        // ---------- Original Method ----------
        //impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(n));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.233 -0400", hash_original_method = "68B16714CB779407E8A17B8680E487D9", hash_generated_method = "FC2282D5337A2B12D88FE0AAB4F3B630")
    public int getSendBufferSize() throws IOException {
        int var30D2E319E9C2929AD28B20E6E58446D9_1008331177 = (((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1030085651 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1030085651;
        // ---------- Original Method ----------
        //return ((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.234 -0400", hash_original_method = "F9B2122C93F2E3BBD4E1C8511037E48C", hash_generated_method = "7519905917A1BA4F65E5C436836F38CD")
    public LocalSocketAddress getRemoteSocketAddress() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1313443856 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1313443856.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1313443856;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.234 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "AECBADD1E1BF58EFF2A90DAF64318724")
    public synchronized boolean isConnected() {
        boolean var8CADFAB0F66545464EF713B1AEC0C7DD_618169849 = (isConnected);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1576646091 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1576646091;
        // ---------- Original Method ----------
        //return isConnected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.234 -0400", hash_original_method = "5FD66514528CC1615B69519702A1D1B0", hash_generated_method = "82A10E5025C8E85E6790331559FE2011")
    public boolean isClosed() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1877175915 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1877175915.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1877175915;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.234 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "A1C545ABC916256D7BD1B924891A6711")
    public synchronized boolean isBound() {
        boolean var8E4D35088206920061AAF7F347854388_39727388 = (isBound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_773797599 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_773797599;
        // ---------- Original Method ----------
        //return isBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.234 -0400", hash_original_method = "569A2E85196AE41DB2C0A92E12B60282", hash_generated_method = "9B2AA7B7D1C028BC7D905CC21D6FC078")
    public boolean isOutputShutdown() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1691991038 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1691991038.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1691991038;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.234 -0400", hash_original_method = "0B31CF3D7E3CD09D712DD70672C78FD7", hash_generated_method = "4C317F05F27CEB668252BC0BE2146727")
    public boolean isInputShutdown() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_480149816 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_480149816.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_480149816;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.234 -0400", hash_original_method = "9D1281B98C667F4CB7081490F8B4AA52", hash_generated_method = "23FA487BEDF759D9E5B1FA8888AB85E5")
    public void connect(LocalSocketAddress endpoint, int timeout) throws IOException {
        addTaint(timeout);
        addTaint(endpoint.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1305946518 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1305946518.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1305946518;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.235 -0400", hash_original_method = "27C53C8DB31C3FA2B713C3C2CC55D90F", hash_generated_method = "F47152BF7E3EEB4820A7559571F96013")
    public void setFileDescriptorsForSend(FileDescriptor[] fds) {
        addTaint(fds[0].getTaint());
        impl.setFileDescriptorsForSend(fds);
        // ---------- Original Method ----------
        //impl.setFileDescriptorsForSend(fds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.235 -0400", hash_original_method = "447681287166469914CD051884431B5F", hash_generated_method = "4C8372F82EDAF3CEBEEA62FCEBD5EF20")
    public FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
FileDescriptor[] var39C3634A2A1EE5C474896187D63364C3_188449977 =         impl.getAncillaryFileDescriptors();
        var39C3634A2A1EE5C474896187D63364C3_188449977.addTaint(taint);
        return var39C3634A2A1EE5C474896187D63364C3_188449977;
        // ---------- Original Method ----------
        //return impl.getAncillaryFileDescriptors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.235 -0400", hash_original_method = "4616CE50DFB82618FF8C3056DF06E72F", hash_generated_method = "404F913C74C012A408C6EA7B7FA19869")
    public Credentials getPeerCredentials() throws IOException {
Credentials var6122CE1776E20B8EED790D65216238CF_265091749 =         impl.getPeerCredentials();
        var6122CE1776E20B8EED790D65216238CF_265091749.addTaint(taint);
        return var6122CE1776E20B8EED790D65216238CF_265091749;
        // ---------- Original Method ----------
        //return impl.getPeerCredentials();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.235 -0400", hash_original_method = "48E5039C4FB2B8BAB81B3561EAA65E0E", hash_generated_method = "6D2481C1499334E32C45DF1061C408F6")
    public FileDescriptor getFileDescriptor() {
FileDescriptor var05E29FE12AB06423EE2D8B05D08F76BE_1556571872 =         impl.getFileDescriptor();
        var05E29FE12AB06423EE2D8B05D08F76BE_1556571872.addTaint(taint);
        return var05E29FE12AB06423EE2D8B05D08F76BE_1556571872;
        // ---------- Original Method ----------
        //return impl.getFileDescriptor();
    }

    
}

