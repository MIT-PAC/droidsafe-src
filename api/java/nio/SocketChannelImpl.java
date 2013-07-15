package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PlainSocketImpl;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketUtils;
import java.net.UnknownHostException;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.NoConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SocketChannel;
import java.nio.channels.UnresolvedAddressException;
import java.nio.channels.UnsupportedAddressTypeException;
import java.nio.channels.spi.SelectorProvider;
import java.util.Arrays;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import libcore.io.IoBridge;
import libcore.io.IoUtils;
import static libcore.io.OsConstants.*;

class SocketChannelImpl extends SocketChannel implements FileDescriptorChannel {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.409 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.409 -0400", hash_original_field = "E728D69D332AE7988C6FE7869D66573E", hash_generated_field = "99CA27ADD3E21B5E0B3E73B3D40E63C8")

    private SocketAdapter socket = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.409 -0400", hash_original_field = "01E982E0501B1B10CFBB661526A8D271", hash_generated_field = "33A55C1E7A49F26B03A955656EFC6766")

    private InetSocketAddress connectAddress = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.409 -0400", hash_original_field = "299B8F7D460321B85DDDB1F9B3BD6EC0", hash_generated_field = "DBBBD6A1106DBEC2B30B9A1EF113618A")

    private InetAddress localAddress = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.410 -0400", hash_original_field = "55FC25CF376E1B7BFFBC2D46F357C231", hash_generated_field = "B1420775EE6B172A515A5BC10BFFE633")

    private int localPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.410 -0400", hash_original_field = "FA7C2E9A18B37E6193498C5920F4EBB1", hash_generated_field = "60CA0FDD070D9706A5FF0681764E3085")

    private int status = SOCKET_STATUS_UNINITIALIZED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.410 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "A5CF5255096CFE4A8B3A025A6EBE0953")

    private volatile boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.410 -0400", hash_original_field = "0EBBDB2C6AB02F595FD6B8EE0165CE90", hash_generated_field = "E06B9588EA49DFE66B571508521E184B")

    private final Object readLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.410 -0400", hash_original_field = "5A9206244ED4B85CC1847D97E427123C", hash_generated_field = "4EB051AF8374C9B2C038ADD375A89D80")

    private final Object writeLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.410 -0400", hash_original_method = "CAD27D317D6065C47064EE5BE7F99097", hash_generated_method = "2378AFB80E6B30B428BEA86F4209CAE1")
    public  SocketChannelImpl(SelectorProvider selectorProvider) throws IOException {
        this(selectorProvider, true);
        addTaint(selectorProvider.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.411 -0400", hash_original_method = "14271155322FDAFE1124C07CD8798E82", hash_generated_method = "72B02481ECB3013CBAA8678C0FA5BD9C")
    public  SocketChannelImpl(SelectorProvider selectorProvider, boolean connect) throws IOException {
        super(selectorProvider);
        addTaint(selectorProvider.getTaint());
        status = SOCKET_STATUS_UNCONNECTED;
        fd = (connect ? IoBridge.socket(true) : new FileDescriptor());
        // ---------- Original Method ----------
        //status = SOCKET_STATUS_UNCONNECTED;
        //fd = (connect ? IoBridge.socket(true) : new FileDescriptor());
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.412 -0400", hash_original_method = "3F3C938694E8E43B39A86772053FE6F3", hash_generated_method = "4F2FD15BF173706DD36782932FF09369")
    @Override
    synchronized public Socket socket() {
    if(socket == null)        
        {
            try 
            {
                InetAddress addr = null;
                int port = 0;
    if(connectAddress != null)                
                {
                    addr = connectAddress.getAddress();
                    port = connectAddress.getPort();
                } //End block
                socket = new SocketAdapter(new PlainSocketImpl(fd, localPort, addr, port), this);
            } //End block
            catch (SocketException e)
            {
Socket var540C13E9E156B687226421B24F2DF178_1873039346 =                 null;
                var540C13E9E156B687226421B24F2DF178_1873039346.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1873039346;
            } //End block
        } //End block
Socket varA63412D4E099639C1BBCBDC8D705186B_1273147154 =         socket;
        varA63412D4E099639C1BBCBDC8D705186B_1273147154.addTaint(taint);
        return varA63412D4E099639C1BBCBDC8D705186B_1273147154;
        // ---------- Original Method ----------
        //if (socket == null) {
            //try {
                //InetAddress addr = null;
                //int port = 0;
                //if (connectAddress != null) {
                    //addr = connectAddress.getAddress();
                    //port = connectAddress.getPort();
                //}
                //socket = new SocketAdapter(new PlainSocketImpl(fd, localPort, addr, port), this);
            //} catch (SocketException e) {
                //return null;
            //}
        //}
        //return socket;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.412 -0400", hash_original_method = "E73B250252340190221059BC9BBB0CEA", hash_generated_method = "1738D6EDCB959F51B31A4B8A6EED2BBE")
    @Override
    synchronized public boolean isConnected() {
        boolean var06C976FCB761591872EBDEA89422147C_795713358 = (status == SOCKET_STATUS_CONNECTED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_736550367 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_736550367;
        // ---------- Original Method ----------
        //return status == SOCKET_STATUS_CONNECTED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.413 -0400", hash_original_method = "18A2FCE579B69612BF9446C66CFB3DF7", hash_generated_method = "5D3DA2D559AD2203AFF1C673C3E7CE27")
    synchronized void setConnected() {
        status = SOCKET_STATUS_CONNECTED;
        // ---------- Original Method ----------
        //status = SOCKET_STATUS_CONNECTED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.413 -0400", hash_original_method = "F9CE278FD490C297CB59C718AF3342C0", hash_generated_method = "2B429B88376943DA3612015A73DC81DF")
     void setBound(boolean flag) {
        isBound = flag;
        // ---------- Original Method ----------
        //isBound = flag;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.413 -0400", hash_original_method = "69EAA9B42272F648401C29FF5A206BD4", hash_generated_method = "A678D0A0DC5D3C940DA5A5B47A6AC630")
    @Override
    synchronized public boolean isConnectionPending() {
        boolean var3539312790B7819C5324C1EFDA326910_252278993 = (status == SOCKET_STATUS_PENDING);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1894032943 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1894032943;
        // ---------- Original Method ----------
        //return status == SOCKET_STATUS_PENDING;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.415 -0400", hash_original_method = "06D5BE9697FA1F6A3605D3BCB50E04A0", hash_generated_method = "E0C2320BEE150E368B6F6DF1573D8C0F")
    @Override
    public boolean connect(SocketAddress socketAddress) throws IOException {
        addTaint(socketAddress.getTaint());
        checkUnconnected();
        InetSocketAddress inetSocketAddress = validateAddress(socketAddress);
        InetAddress normalAddr = inetSocketAddress.getAddress();
        int port = inetSocketAddress.getPort();
    if(normalAddr.isAnyLocalAddress())        
        {
            normalAddr = InetAddress.getLocalHost();
        } //End block
        boolean finished = false;
        try 
        {
    if(isBlocking())            
            {
                begin();
            } //End block
            finished = IoBridge.connect(fd, normalAddr, port);
            isBound = finished;
        } //End block
        catch (IOException e)
        {
    if(e instanceof ConnectException && !isBlocking())            
            {
                status = SOCKET_STATUS_PENDING;
            } //End block
            else
            {
    if(isOpen())                
                {
                    close();
                    finished = true;
                } //End block
                e.addTaint(taint);
                throw e;
            } //End block
        } //End block
        finally 
        {
    if(isBlocking())            
            {
                end(finished);
            } //End block
        } //End block
        initLocalAddressAndPort();
        connectAddress = inetSocketAddress;
    if(socket != null)        
        {
            socket.socketImpl().initRemoteAddressAndPort(connectAddress.getAddress(),
                    connectAddress.getPort());
        } //End block
        synchronized
(this)        {
    if(isBlocking())            
            {
                status = (finished ? SOCKET_STATUS_CONNECTED : SOCKET_STATUS_UNCONNECTED);
            } //End block
            else
            {
                status = SOCKET_STATUS_PENDING;
            } //End block
        } //End block
        boolean varA5D7CEB2C59B8CEE46C2953FEC9ABC19_1599810506 = (finished);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1983173966 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1983173966;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.416 -0400", hash_original_method = "06F6825183E6F900AF6E00DC91481B34", hash_generated_method = "8C415D4F2CF9994327E18B1308DC47DB")
    private void initLocalAddressAndPort() {
        SocketAddress sa;
        try 
        {
            sa = Libcore.os.getsockname(fd);
        } //End block
        catch (ErrnoException errnoException)
        {
            AssertionError var8D75DBC63153835F7D08A31E99200A1F_1933790545 = new AssertionError(errnoException);
            var8D75DBC63153835F7D08A31E99200A1F_1933790545.addTaint(taint);
            throw var8D75DBC63153835F7D08A31E99200A1F_1933790545;
        } //End block
        InetSocketAddress isa = (InetSocketAddress) sa;
        localAddress = isa.getAddress();
        localPort = isa.getPort();
    if(socket != null)        
        {
            socket.socketImpl().initLocalPort(localPort);
        } //End block
        // ---------- Original Method ----------
        //SocketAddress sa;
        //try {
            //sa = Libcore.os.getsockname(fd);
        //} catch (ErrnoException errnoException) {
            //throw new AssertionError(errnoException);
        //}
        //InetSocketAddress isa = (InetSocketAddress) sa;
        //localAddress = isa.getAddress();
        //localPort = isa.getPort();
        //if (socket != null) {
            //socket.socketImpl().initLocalPort(localPort);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.417 -0400", hash_original_method = "240D4967AAA5DC479C6C557DB665D6D5", hash_generated_method = "6B3936446A256B973B1608010276D7F4")
    @Override
    public boolean finishConnect() throws IOException {
        synchronized
(this)        {
    if(!isOpen())            
            {
                ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_1106687879 = new ClosedChannelException();
                var553E3C0ED28F94CE76A7A8061DFFDCF3_1106687879.addTaint(taint);
                throw var553E3C0ED28F94CE76A7A8061DFFDCF3_1106687879;
            } //End block
    if(status == SOCKET_STATUS_CONNECTED)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_212898149 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_977849090 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_977849090;
            } //End block
    if(status != SOCKET_STATUS_PENDING)            
            {
                NoConnectionPendingException varEFFBA2EC873295B44D8D4343CAE0620D_1272064181 = new NoConnectionPendingException();
                varEFFBA2EC873295B44D8D4343CAE0620D_1272064181.addTaint(taint);
                throw varEFFBA2EC873295B44D8D4343CAE0620D_1272064181;
            } //End block
        } //End block
        boolean finished = false;
        try 
        {
            begin();
            InetAddress inetAddress = connectAddress.getAddress();
            int port = connectAddress.getPort();
            finished = IoBridge.isConnected(fd, inetAddress, port, 0, 0);
            isBound = finished;
        } //End block
        catch (ConnectException e)
        {
    if(isOpen())            
            {
                close();
                finished = true;
            } //End block
            e.addTaint(taint);
            throw e;
        } //End block
        finally 
        {
            end(finished);
        } //End block
        synchronized
(this)        {
            status = (finished ? SOCKET_STATUS_CONNECTED : status);
            isBound = finished;
        } //End block
        boolean varA5D7CEB2C59B8CEE46C2953FEC9ABC19_913265495 = (finished);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_905886109 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_905886109;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.417 -0400", hash_original_method = "1E64AA428CB659E98A86DB6C8DA80F4E", hash_generated_method = "B8BF86CF41D77F2D4D8EDCA4E44845DF")
     void finishAccept() {
        initLocalAddressAndPort();
        // ---------- Original Method ----------
        //initLocalAddressAndPort();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.418 -0400", hash_original_method = "FDE0A0D9A12F7110643554CD43F8D7B6", hash_generated_method = "16D1A26E62D823F2066F27A59829DCF7")
    @Override
    public int read(ByteBuffer dst) throws IOException {
        addTaint(dst.getTaint());
        dst.checkWritable();
        checkOpenConnected();
    if(!dst.hasRemaining())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1667023598 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107333378 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107333378;
        } //End block
        int var4DAC6F535D8C6B08C21EEF15DE32F811_20115902 = (readImpl(dst));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559964463 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559964463;
        // ---------- Original Method ----------
        //dst.checkWritable();
        //checkOpenConnected();
        //if (!dst.hasRemaining()) {
            //return 0;
        //}
        //return readImpl(dst);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.418 -0400", hash_original_method = "CFA00AB281069164ECAB790C179DF3F9", hash_generated_method = "1CACBF7ACFDB8FACBEB0ED460D9C4960")
    @Override
    public long read(ByteBuffer[] targets, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(targets[0].getTaint());
        Arrays.checkOffsetAndCount(targets.length, offset, length);
        checkOpenConnected();
        int totalCount = FileChannelImpl.calculateTotalRemaining(targets, offset, length, true);
    if(totalCount == 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_417258637 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1532196102 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1532196102;
        } //End block
        byte[] readArray = new byte[totalCount];
        ByteBuffer readBuffer = ByteBuffer.wrap(readArray);
        int readCount;
        readCount = readImpl(readBuffer);
        readBuffer.flip();
    if(readCount > 0)        
        {
            int left = readCount;
            int index = offset;
            while
(left > 0)            
            {
                int putLength = Math.min(targets[index].remaining(), left);
                targets[index].put(readArray, readCount - left, putLength);
                index++;
                left -= putLength;
            } //End block
        } //End block
        long varADC9E8D761A52E26BEC5404508AFC000_7286732 = (readCount);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_76486041 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_76486041;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.419 -0400", hash_original_method = "59936954910C41239CB7D8967AB1C758", hash_generated_method = "C7A46D390C5694ADA644C2159898340D")
    private int readImpl(ByteBuffer dst) throws IOException {
        addTaint(dst.getTaint());
        synchronized
(readLock)        {
            int readCount = 0;
            try 
            {
    if(isBlocking())                
                {
                    begin();
                } //End block
                readCount = IoBridge.recvfrom(true, fd, dst, 0, null, false);
    if(readCount > 0)                
                {
                    dst.position(dst.position() + readCount);
                } //End block
            } //End block
            finally 
            {
    if(isBlocking())                
                {
                    end(readCount > 0);
                } //End block
            } //End block
            int varADC9E8D761A52E26BEC5404508AFC000_1433878003 = (readCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762272712 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762272712;
        } //End block
        // ---------- Original Method ----------
        //synchronized (readLock) {
            //int readCount = 0;
            //try {
                //if (isBlocking()) {
                    //begin();
                //}
                //readCount = IoBridge.recvfrom(true, fd, dst, 0, null, false);
                //if (readCount > 0) {
                    //dst.position(dst.position() + readCount);
                //}
            //} finally {
                //if (isBlocking()) {
                    //end(readCount > 0);
                //}
            //}
            //return readCount;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.420 -0400", hash_original_method = "DCFA2CB99033209FD40A6F8FA617CF19", hash_generated_method = "7909168BA3A0EDEE6B716C6FCB885728")
    @Override
    public int write(ByteBuffer src) throws IOException {
        addTaint(src.getTaint());
    if(src == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1893444840 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1893444840.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1893444840;
        } //End block
        checkOpenConnected();
    if(!src.hasRemaining())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1935792819 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_782908165 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_782908165;
        } //End block
        int var8AA01C29838246F7BD8A85375A5F2DEA_2093478368 = (writeImpl(src));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727507615 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727507615;
        // ---------- Original Method ----------
        //if (src == null) {
            //throw new NullPointerException();
        //}
        //checkOpenConnected();
        //if (!src.hasRemaining()) {
            //return 0;
        //}
        //return writeImpl(src);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.421 -0400", hash_original_method = "92D26B18BB75EB8AD284E7DC348B13D6", hash_generated_method = "6F33C7E4D5B3F80A673AAA0C4ADA76DC")
    @Override
    public long write(ByteBuffer[] sources, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(sources[0].getTaint());
        Arrays.checkOffsetAndCount(sources.length, offset, length);
        checkOpenConnected();
        int count = FileChannelImpl.calculateTotalRemaining(sources, offset, length, false);
    if(count == 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1726755354 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_172389861 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_172389861;
        } //End block
        ByteBuffer writeBuf = ByteBuffer.allocate(count);
for(int val = offset;val < length + offset;val++)
        {
            ByteBuffer source = sources[val];
            int oldPosition = source.position();
            writeBuf.put(source);
            source.position(oldPosition);
        } //End block
        writeBuf.flip();
        int result = writeImpl(writeBuf);
        int val = offset;
        int written = result;
        while
(result > 0)        
        {
            ByteBuffer source = sources[val];
            int gap = Math.min(result, source.remaining());
            source.position(source.position() + gap);
            val++;
            result -= gap;
        } //End block
        long var9CC26FA09CE37BC95AFE01BC718836D1_1955494268 = (written);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1762793000 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1762793000;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.422 -0400", hash_original_method = "9CA5CC5B2105A1C6A6351FB0E1EC75B2", hash_generated_method = "4D66B8E581B97C95EBF0EF33A09FD09A")
    private int writeImpl(ByteBuffer src) throws IOException {
        addTaint(src.getTaint());
        synchronized
(writeLock)        {
    if(!src.hasRemaining())            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1403073638 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387737209 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387737209;
            } //End block
            int writeCount = 0;
            try 
            {
    if(isBlocking())                
                {
                    begin();
                } //End block
                writeCount = IoBridge.sendto(fd, src, 0, null, 0);
    if(writeCount > 0)                
                {
                    src.position(src.position() + writeCount);
                } //End block
            } //End block
            finally 
            {
    if(isBlocking())                
                {
                    end(writeCount >= 0);
                } //End block
            } //End block
            int var44A1965D931137262EA3A9400DCC2A67_237806120 = (writeCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627002549 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627002549;
        } //End block
        // ---------- Original Method ----------
        //synchronized (writeLock) {
            //if (!src.hasRemaining()) {
                //return 0;
            //}
            //int writeCount = 0;
            //try {
                //if (isBlocking()) {
                    //begin();
                //}
                //writeCount = IoBridge.sendto(fd, src, 0, null, 0);
                //if (writeCount > 0) {
                    //src.position(src.position() + writeCount);
                //}
            //} finally {
                //if (isBlocking()) {
                    //end(writeCount >= 0);
                //}
            //}
            //return writeCount;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.422 -0400", hash_original_method = "39D9BE1DFB590318884AF060F0654BAC", hash_generated_method = "0F6C73A9BA7FD0D01F82B9D32D481C9D")
    synchronized private void checkOpenConnected() throws ClosedChannelException {
    if(!isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_1406898044 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_1406898044.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_1406898044;
        } //End block
    if(!isConnected())        
        {
            NotYetConnectedException var74CB2CB661C2A7775D3A554085300C50_1951208986 = new NotYetConnectedException();
            var74CB2CB661C2A7775D3A554085300C50_1951208986.addTaint(taint);
            throw var74CB2CB661C2A7775D3A554085300C50_1951208986;
        } //End block
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedChannelException();
        //}
        //if (!isConnected()) {
            //throw new NotYetConnectedException();
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.423 -0400", hash_original_method = "ACDFE21557429638E6BE7769521129CC", hash_generated_method = "5E46C9DB2A94D3ADD34487B57BEDA866")
    synchronized private void checkUnconnected() throws IOException {
    if(!isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_620924346 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_620924346.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_620924346;
        } //End block
    if(status == SOCKET_STATUS_CONNECTED)        
        {
            AlreadyConnectedException var476065E4395D997E6E7AB97A5FAAC77C_515079988 = new AlreadyConnectedException();
            var476065E4395D997E6E7AB97A5FAAC77C_515079988.addTaint(taint);
            throw var476065E4395D997E6E7AB97A5FAAC77C_515079988;
        } //End block
    if(status == SOCKET_STATUS_PENDING)        
        {
            ConnectionPendingException varACB52C98E3A165B390A8E70B71AA710E_2007626028 = new ConnectionPendingException();
            varACB52C98E3A165B390A8E70B71AA710E_2007626028.addTaint(taint);
            throw varACB52C98E3A165B390A8E70B71AA710E_2007626028;
        } //End block
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedChannelException();
        //}
        //if (status == SOCKET_STATUS_CONNECTED) {
            //throw new AlreadyConnectedException();
        //}
        //if (status == SOCKET_STATUS_PENDING) {
            //throw new ConnectionPendingException();
        //}
    }

    
        @DSModeled(DSC.SPEC)
    static InetSocketAddress validateAddress(SocketAddress socketAddress) {
        if (socketAddress == null) {
            throw new IllegalArgumentException();
        }
        if (!(socketAddress instanceof InetSocketAddress)) {
            throw new UnsupportedAddressTypeException();
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        if (inetSocketAddress.isUnresolved()) {
            throw new UnresolvedAddressException();
        }
        return inetSocketAddress;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.426 -0400", hash_original_method = "C580647FE4D156BB3A20DD6B3069A7D0", hash_generated_method = "177F39B1D4872EAA3EC7EBD39EE2A924")
    public InetAddress getLocalAddress() throws UnknownHostException {
InetAddress var7916DE881ABD051FA54E219C60ADC277_1663243393 =         isBound ? localAddress : Inet4Address.ANY;
        var7916DE881ABD051FA54E219C60ADC277_1663243393.addTaint(taint);
        return var7916DE881ABD051FA54E219C60ADC277_1663243393;
        // ---------- Original Method ----------
        //return isBound ? localAddress : Inet4Address.ANY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.426 -0400", hash_original_method = "51888A8660147B395A4990C2BFAD98BE", hash_generated_method = "5D05870CF1A822112731287FDC2E0DC1")
    @Override
    protected synchronized void implCloseSelectableChannel() throws IOException {
    if(status != SOCKET_STATUS_CLOSED)        
        {
            status = SOCKET_STATUS_CLOSED;
    if(socket != null && !socket.isClosed())            
            {
                socket.close();
            } //End block
            else
            {
                IoBridge.closeSocket(fd);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (status != SOCKET_STATUS_CLOSED) {
            //status = SOCKET_STATUS_CLOSED;
            //if (socket != null && !socket.isClosed()) {
                //socket.close();
            //} else {
                //IoBridge.closeSocket(fd);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.426 -0400", hash_original_method = "B277EC5F8A308E553B57A0D050976387", hash_generated_method = "8A4048D7B505F1340F0DB31FC91FB3B2")
    @Override
    protected void implConfigureBlocking(boolean blocking) throws IOException {
        addTaint(blocking);
        synchronized
(blockingLock())        {
            IoUtils.setBlocking(fd, blocking);
        } //End block
        // ---------- Original Method ----------
        //synchronized (blockingLock()) {
            //IoUtils.setBlocking(fd, blocking);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.427 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "C2FADCED8A023B4395839D361486B74C")
    public FileDescriptor getFD() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_89321359 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_89321359.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_89321359;
        // ---------- Original Method ----------
        //return fd;
    }

    
    private static class SocketAdapter extends Socket {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.427 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "BDD8BAEA23E522D57D04980987295CB9")

        private SocketChannelImpl channel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.427 -0400", hash_original_field = "31BE1E23DE379D748DAA84AEF8C5EA67", hash_generated_field = "16CEE3972B12A3C5752670B7FF7939A7")

        private PlainSocketImpl socketImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.428 -0400", hash_original_method = "BE34C7E67ABAE2BC0D8C225897658728", hash_generated_method = "A3034C3AF47E210F06DDBFBFB0017C2B")
          SocketAdapter(PlainSocketImpl socketImpl, SocketChannelImpl channel) throws SocketException {
            super(socketImpl);
            this.socketImpl = socketImpl;
            this.channel = channel;
            SocketUtils.setCreated(this);
            // ---------- Original Method ----------
            //this.socketImpl = socketImpl;
            //this.channel = channel;
            //SocketUtils.setCreated(this);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.428 -0400", hash_original_method = "453300FCAD69AE8F91F62237BE21CFBA", hash_generated_method = "839D10E1E8170F7F5DCF677CCBAFB5A6")
         PlainSocketImpl socketImpl() {
PlainSocketImpl var3C3A80B89227BA64A6B8041F12016C7F_1473479613 =             socketImpl;
            var3C3A80B89227BA64A6B8041F12016C7F_1473479613.addTaint(taint);
            return var3C3A80B89227BA64A6B8041F12016C7F_1473479613;
            // ---------- Original Method ----------
            //return socketImpl;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.428 -0400", hash_original_method = "379CE4067399395F02052517F4DCE995", hash_generated_method = "B6AA1BA299AC1C02AB0C9AECB8B59F37")
        @Override
        public SocketChannel getChannel() {
SocketChannel var99BA3483FD74E36EACD435CEE6BD5D6F_901749925 =             channel;
            var99BA3483FD74E36EACD435CEE6BD5D6F_901749925.addTaint(taint);
            return var99BA3483FD74E36EACD435CEE6BD5D6F_901749925;
            // ---------- Original Method ----------
            //return channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.428 -0400", hash_original_method = "CB881FA34C7D7FBE309BA2B3C38FD9DE", hash_generated_method = "BAAD4D8406C426A732B5ACC8708135D4")
        @Override
        public boolean isBound() {
            boolean var3C991D89CBAD7396FD87F584EAC1C3BC_1059026888 = (channel.isBound);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1858026144 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1858026144;
            // ---------- Original Method ----------
            //return channel.isBound;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.428 -0400", hash_original_method = "5CCF8EB454AE33E9E231A2BE45E2629E", hash_generated_method = "4548558BA07CE631868FEC665CECE67B")
        @Override
        public boolean isConnected() {
            boolean var8CC75E4BE53866C63C2FDAFA80969695_2088220118 = (channel.isConnected());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_8801398 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_8801398;
            // ---------- Original Method ----------
            //return channel.isConnected();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.429 -0400", hash_original_method = "B0018340FF02F226576061EFB596D2DE", hash_generated_method = "9C3560AFE11823C258C79E2FC8E08395")
        @Override
        public InetAddress getLocalAddress() {
            try 
            {
InetAddress var6967915047D2E1192DA8894E905FDC2A_1847670275 =                 channel.getLocalAddress();
                var6967915047D2E1192DA8894E905FDC2A_1847670275.addTaint(taint);
                return var6967915047D2E1192DA8894E905FDC2A_1847670275;
            } //End block
            catch (UnknownHostException e)
            {
InetAddress var540C13E9E156B687226421B24F2DF178_1150203138 =                 null;
                var540C13E9E156B687226421B24F2DF178_1150203138.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1150203138;
            } //End block
            // ---------- Original Method ----------
            //try {
                //return channel.getLocalAddress();
            //} catch (UnknownHostException e) {
                //return null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.429 -0400", hash_original_method = "63A88A8D435088D761BDD7938E4125E4", hash_generated_method = "A2E82671446A5432E5A11C51437015AA")
        @Override
        public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
            addTaint(timeout);
            addTaint(remoteAddr.getTaint());
    if(!channel.isBlocking())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_828890473 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_828890473.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_828890473;
            } //End block
    if(isConnected())            
            {
                AlreadyConnectedException var476065E4395D997E6E7AB97A5FAAC77C_393547 = new AlreadyConnectedException();
                var476065E4395D997E6E7AB97A5FAAC77C_393547.addTaint(taint);
                throw var476065E4395D997E6E7AB97A5FAAC77C_393547;
            } //End block
            super.connect(remoteAddr, timeout);
            channel.initLocalAddressAndPort();
    if(super.isConnected())            
            {
                channel.setConnected();
                channel.isBound = super.isBound();
            } //End block
            // ---------- Original Method ----------
            //if (!channel.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //if (isConnected()) {
                //throw new AlreadyConnectedException();
            //}
            //super.connect(remoteAddr, timeout);
            //channel.initLocalAddressAndPort();
            //if (super.isConnected()) {
                //channel.setConnected();
                //channel.isBound = super.isBound();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.429 -0400", hash_original_method = "B60964A84DDE0034E73C148BED7594EB", hash_generated_method = "C4C4D4B1AAB9F12BBCAE973E968377EE")
        @Override
        public void bind(SocketAddress localAddr) throws IOException {
            addTaint(localAddr.getTaint());
    if(channel.isConnected())            
            {
                AlreadyConnectedException var476065E4395D997E6E7AB97A5FAAC77C_1752649412 = new AlreadyConnectedException();
                var476065E4395D997E6E7AB97A5FAAC77C_1752649412.addTaint(taint);
                throw var476065E4395D997E6E7AB97A5FAAC77C_1752649412;
            } //End block
    if(SocketChannelImpl.SOCKET_STATUS_PENDING == channel.status)            
            {
                ConnectionPendingException varACB52C98E3A165B390A8E70B71AA710E_820080810 = new ConnectionPendingException();
                varACB52C98E3A165B390A8E70B71AA710E_820080810.addTaint(taint);
                throw varACB52C98E3A165B390A8E70B71AA710E_820080810;
            } //End block
            super.bind(localAddr);
            channel.initLocalAddressAndPort();
            channel.isBound = true;
            // ---------- Original Method ----------
            //if (channel.isConnected()) {
                //throw new AlreadyConnectedException();
            //}
            //if (SocketChannelImpl.SOCKET_STATUS_PENDING == channel.status) {
                //throw new ConnectionPendingException();
            //}
            //super.bind(localAddr);
            //channel.initLocalAddressAndPort();
            //channel.isBound = true;
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.430 -0400", hash_original_method = "D341E1E6C64813CEE43FACEF8CA53A78", hash_generated_method = "4347B4C85E05C59F22F10FBF166304B0")
        @Override
        public void close() throws IOException {
            synchronized
(channel)            {
    if(channel.isOpen())                
                {
                    channel.close();
                } //End block
                else
                {
                    super.close();
                } //End block
                channel.status = SocketChannelImpl.SOCKET_STATUS_CLOSED;
            } //End block
            // ---------- Original Method ----------
            //synchronized (channel) {
                //if (channel.isOpen()) {
                    //channel.close();
                //} else {
                    //super.close();
                //}
                //channel.status = SocketChannelImpl.SOCKET_STATUS_CLOSED;
            //}
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.430 -0400", hash_original_method = "33C0B42780F1E273103B5BBAE79F7408", hash_generated_method = "CD4B073472FA8BDDF4E92383E290266A")
        @Override
        public OutputStream getOutputStream() throws IOException {
            checkOpenAndConnected();
    if(isOutputShutdown())            
            {
                SocketException varAEED29E2676080AAAF1B3CDFF0042316_1054352564 = new SocketException("Socket output is shutdown");
                varAEED29E2676080AAAF1B3CDFF0042316_1054352564.addTaint(taint);
                throw varAEED29E2676080AAAF1B3CDFF0042316_1054352564;
            } //End block
OutputStream var385144943979ABAF397D041725C7E189_1523978306 =             new SocketChannelOutputStream(channel);
            var385144943979ABAF397D041725C7E189_1523978306.addTaint(taint);
            return var385144943979ABAF397D041725C7E189_1523978306;
            // ---------- Original Method ----------
            //checkOpenAndConnected();
            //if (isOutputShutdown()) {
                //throw new SocketException("Socket output is shutdown");
            //}
            //return new SocketChannelOutputStream(channel);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.430 -0400", hash_original_method = "84598A158E9BC4BA9724B2EC04F9ADAB", hash_generated_method = "D1FE8DD88318A833CB439B068CB0D1FD")
        @Override
        public InputStream getInputStream() throws IOException {
            checkOpenAndConnected();
    if(isInputShutdown())            
            {
                SocketException var7F56FCFB5848FA2F7798A02081088E95_524396485 = new SocketException("Socket input is shutdown");
                var7F56FCFB5848FA2F7798A02081088E95_524396485.addTaint(taint);
                throw var7F56FCFB5848FA2F7798A02081088E95_524396485;
            } //End block
InputStream varBBCB65A129E4FF2F4EF7DA1CCF148B3D_788223445 =             new SocketChannelInputStream(channel);
            varBBCB65A129E4FF2F4EF7DA1CCF148B3D_788223445.addTaint(taint);
            return varBBCB65A129E4FF2F4EF7DA1CCF148B3D_788223445;
            // ---------- Original Method ----------
            //checkOpenAndConnected();
            //if (isInputShutdown()) {
                //throw new SocketException("Socket input is shutdown");
            //}
            //return new SocketChannelInputStream(channel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.430 -0400", hash_original_method = "6DFEABBD8C66364625150870CA176E5F", hash_generated_method = "DDB10C1B80D56F241723F706787BB9D3")
        private void checkOpenAndConnected() throws SocketException {
    if(!channel.isOpen())            
            {
                SocketException var5AD72407DD9337ABED4666C49A30EC41_349855593 = new SocketException("Socket is closed");
                var5AD72407DD9337ABED4666C49A30EC41_349855593.addTaint(taint);
                throw var5AD72407DD9337ABED4666C49A30EC41_349855593;
            } //End block
    if(!channel.isConnected())            
            {
                SocketException var56B6B46DDA80C85C37F76D6551ACB00C_625038736 = new SocketException("Socket is not connected");
                var56B6B46DDA80C85C37F76D6551ACB00C_625038736.addTaint(taint);
                throw var56B6B46DDA80C85C37F76D6551ACB00C_625038736;
            } //End block
            // ---------- Original Method ----------
            //if (!channel.isOpen()) {
                //throw new SocketException("Socket is closed");
            //}
            //if (!channel.isConnected()) {
                //throw new SocketException("Socket is not connected");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.431 -0400", hash_original_method = "7907395A2BDEF0093C42980D22D2F1FF", hash_generated_method = "500AC5E0F516DF8CEB62FA4A7983A709")
        @Override
        public FileDescriptor getFileDescriptor$() {
FileDescriptor var0DACFA040D27F7D032EACE256C40E7C8_1848543478 =             socketImpl.getFD$();
            var0DACFA040D27F7D032EACE256C40E7C8_1848543478.addTaint(taint);
            return var0DACFA040D27F7D032EACE256C40E7C8_1848543478;
            // ---------- Original Method ----------
            //return socketImpl.getFD$();
        }

        
    }


    
    private static class SocketChannelOutputStream extends OutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.431 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "E9077990D7B99E1545AE06215D5C5888")

        private SocketChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.431 -0400", hash_original_method = "EBB61A0ABCF2B47C9E2AA3F506A7D0F7", hash_generated_method = "87F5FBA8759F42229F1FFA4E785B5FC9")
        public  SocketChannelOutputStream(SocketChannel channel) {
            this.channel = channel;
            // ---------- Original Method ----------
            //this.channel = channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.431 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "52F7C33AE9AC04D22BBF80B1439C0461")
        @Override
        public void close() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.432 -0400", hash_original_method = "376EE3F97840D4205E91F242BC3F90AA", hash_generated_method = "20A78F93977F119F8B5D44DFCCB05637")
        @Override
        public void write(byte[] buffer, int offset, int byteCount) throws IOException {
            addTaint(byteCount);
            addTaint(offset);
            addTaint(buffer[0]);
            Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
    if(!channel.isBlocking())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_1654509948 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_1654509948.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_1654509948;
            } //End block
            channel.write(buf);
            // ---------- Original Method ----------
            //Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            //ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
            //if (!channel.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //channel.write(buf);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.432 -0400", hash_original_method = "F1C26F791F3FC6DB336B7A388343CAEE", hash_generated_method = "2576EC9A59F2BE02625B6248CBE729FA")
        @Override
        public void write(int oneByte) throws IOException {
            addTaint(oneByte);
    if(!channel.isBlocking())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_1233364059 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_1233364059.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_1233364059;
            } //End block
            ByteBuffer buffer = ByteBuffer.allocate(1);
            buffer.put(0, (byte) (oneByte & 0xFF));
            channel.write(buffer);
            // ---------- Original Method ----------
            //if (!channel.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //ByteBuffer buffer = ByteBuffer.allocate(1);
            //buffer.put(0, (byte) (oneByte & 0xFF));
            //channel.write(buffer);
        }

        
    }


    
    private static class SocketChannelInputStream extends InputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.432 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "E9077990D7B99E1545AE06215D5C5888")

        private SocketChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.432 -0400", hash_original_method = "6BC169A329FCC47D43DDDAAFDB17AB6A", hash_generated_method = "8E092B2B7F6933899BF0ED405D943216")
        public  SocketChannelInputStream(SocketChannel channel) {
            this.channel = channel;
            // ---------- Original Method ----------
            //this.channel = channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.432 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "52F7C33AE9AC04D22BBF80B1439C0461")
        @Override
        public void close() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.433 -0400", hash_original_method = "9D425CB1AFA4E4568C9C3855468C26CA", hash_generated_method = "3A87A35D9F3D1A49BBE83B43829E93FD")
        @Override
        public int read() throws IOException {
    if(!channel.isBlocking())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_1446564446 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_1446564446.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_1446564446;
            } //End block
            ByteBuffer buf = ByteBuffer.allocate(1);
            int result = channel.read(buf);
            int var1C767A03D604110625E958FA2E3DF1F5_647299368 = ((result == -1) ? result : (buf.get(0) & 0xff));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861566738 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861566738;
            // ---------- Original Method ----------
            //if (!channel.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //ByteBuffer buf = ByteBuffer.allocate(1);
            //int result = channel.read(buf);
            //return (result == -1) ? result : (buf.get(0) & 0xff);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.433 -0400", hash_original_method = "EA379AE73CA210BAF79C2B35EBD964D5", hash_generated_method = "1C82DEF27E61BD4C58C38389A4FF6721")
        @Override
        public int read(byte[] buffer, int offset, int byteCount) throws IOException {
            addTaint(byteCount);
            addTaint(offset);
            addTaint(buffer[0]);
            Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
    if(!channel.isBlocking())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_1945599974 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_1945599974.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_1945599974;
            } //End block
            ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
            int varACF968FE9006787EB655B878BB773697_2111565237 = (channel.read(buf));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1367772683 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1367772683;
            // ---------- Original Method ----------
            //Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            //if (!channel.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
            //return channel.read(buf);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.433 -0400", hash_original_field = "F7874D1ECFDF317B7B0B49E529318271", hash_generated_field = "C681A88E046FA43323BC16B2855934C2")

    private static final int SOCKET_STATUS_UNINITIALIZED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.433 -0400", hash_original_field = "E7869BFA26651C1A91DF76F29F4AC46C", hash_generated_field = "528B797B61169045F38323ED5AA4ADC9")

    private static final int SOCKET_STATUS_UNCONNECTED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.433 -0400", hash_original_field = "EDC041CF402AA3C46826C9E2AE49AE9E", hash_generated_field = "7A7EF73F99E82F4A0F05F52DF78136A3")

    private static final int SOCKET_STATUS_PENDING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.433 -0400", hash_original_field = "461AFCE1A5AEC5CF2C2D26AAE231795E", hash_generated_field = "C2F55AFC3D6E4976A560F2A180895BAB")

    private static final int SOCKET_STATUS_CONNECTED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.434 -0400", hash_original_field = "7E35E1AB365CC43A545D22B9D85FC951", hash_generated_field = "C1A214D8C71AC08214F82C6ABD1A3CFD")

    private static final int SOCKET_STATUS_CLOSED = 3;
}

