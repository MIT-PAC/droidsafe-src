package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;
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
import libcore.io.IoBridge;
import libcore.io.IoUtils;
import libcore.io.Libcore;





class SocketChannelImpl extends SocketChannel implements FileDescriptorChannel {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.092 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.092 -0400", hash_original_field = "E728D69D332AE7988C6FE7869D66573E", hash_generated_field = "99CA27ADD3E21B5E0B3E73B3D40E63C8")

    private SocketAdapter socket = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.092 -0400", hash_original_field = "01E982E0501B1B10CFBB661526A8D271", hash_generated_field = "33A55C1E7A49F26B03A955656EFC6766")

    private InetSocketAddress connectAddress = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.092 -0400", hash_original_field = "299B8F7D460321B85DDDB1F9B3BD6EC0", hash_generated_field = "DBBBD6A1106DBEC2B30B9A1EF113618A")

    private InetAddress localAddress = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.092 -0400", hash_original_field = "55FC25CF376E1B7BFFBC2D46F357C231", hash_generated_field = "B1420775EE6B172A515A5BC10BFFE633")

    private int localPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.092 -0400", hash_original_field = "FA7C2E9A18B37E6193498C5920F4EBB1", hash_generated_field = "60CA0FDD070D9706A5FF0681764E3085")

    private int status = SOCKET_STATUS_UNINITIALIZED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.092 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "A5CF5255096CFE4A8B3A025A6EBE0953")

    private volatile boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.092 -0400", hash_original_field = "0EBBDB2C6AB02F595FD6B8EE0165CE90", hash_generated_field = "E06B9588EA49DFE66B571508521E184B")

    private final Object readLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.092 -0400", hash_original_field = "5A9206244ED4B85CC1847D97E427123C", hash_generated_field = "4EB051AF8374C9B2C038ADD375A89D80")

    private final Object writeLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.092 -0400", hash_original_method = "CAD27D317D6065C47064EE5BE7F99097", hash_generated_method = "2378AFB80E6B30B428BEA86F4209CAE1")
    public  SocketChannelImpl(SelectorProvider selectorProvider) throws IOException {
        this(selectorProvider, true);
        addTaint(selectorProvider.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.093 -0400", hash_original_method = "14271155322FDAFE1124C07CD8798E82", hash_generated_method = "72B02481ECB3013CBAA8678C0FA5BD9C")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.093 -0400", hash_original_method = "3F3C938694E8E43B39A86772053FE6F3", hash_generated_method = "E477BFEAB0AF837A380FA0817D6D93C1")
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
Socket var540C13E9E156B687226421B24F2DF178_1531186041 =                 null;
                var540C13E9E156B687226421B24F2DF178_1531186041.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1531186041;
            } //End block
        } //End block
Socket varA63412D4E099639C1BBCBDC8D705186B_1491654690 =         socket;
        varA63412D4E099639C1BBCBDC8D705186B_1491654690.addTaint(taint);
        return varA63412D4E099639C1BBCBDC8D705186B_1491654690;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.093 -0400", hash_original_method = "E73B250252340190221059BC9BBB0CEA", hash_generated_method = "9990F558DD5A3D80C640DA4801E7E274")
    @Override
    synchronized public boolean isConnected() {
        boolean var06C976FCB761591872EBDEA89422147C_78588367 = (status == SOCKET_STATUS_CONNECTED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_343492573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_343492573;
        // ---------- Original Method ----------
        //return status == SOCKET_STATUS_CONNECTED;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.093 -0400", hash_original_method = "18A2FCE579B69612BF9446C66CFB3DF7", hash_generated_method = "5D3DA2D559AD2203AFF1C673C3E7CE27")
    synchronized void setConnected() {
        status = SOCKET_STATUS_CONNECTED;
        // ---------- Original Method ----------
        //status = SOCKET_STATUS_CONNECTED;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.093 -0400", hash_original_method = "F9CE278FD490C297CB59C718AF3342C0", hash_generated_method = "2B429B88376943DA3612015A73DC81DF")
     void setBound(boolean flag) {
        isBound = flag;
        // ---------- Original Method ----------
        //isBound = flag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.093 -0400", hash_original_method = "69EAA9B42272F648401C29FF5A206BD4", hash_generated_method = "7D7051008CBFA78A55FED320FC3A2D4C")
    @Override
    synchronized public boolean isConnectionPending() {
        boolean var3539312790B7819C5324C1EFDA326910_814139101 = (status == SOCKET_STATUS_PENDING);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2057237909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2057237909;
        // ---------- Original Method ----------
        //return status == SOCKET_STATUS_PENDING;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.095 -0400", hash_original_method = "06D5BE9697FA1F6A3605D3BCB50E04A0", hash_generated_method = "855238DC6EDD9AAFBD2A8D2518A9BD12")
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
        boolean varA5D7CEB2C59B8CEE46C2953FEC9ABC19_569009358 = (finished);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_482253669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_482253669;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.095 -0400", hash_original_method = "06F6825183E6F900AF6E00DC91481B34", hash_generated_method = "798E9CBDA64576795935DCA6E0C99870")
    private void initLocalAddressAndPort() {
        SocketAddress sa;
        try 
        {
            sa = Libcore.os.getsockname(fd);
        } //End block
        catch (ErrnoException errnoException)
        {
            AssertionError var8D75DBC63153835F7D08A31E99200A1F_1152947418 = new AssertionError(errnoException);
            var8D75DBC63153835F7D08A31E99200A1F_1152947418.addTaint(taint);
            throw var8D75DBC63153835F7D08A31E99200A1F_1152947418;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.096 -0400", hash_original_method = "240D4967AAA5DC479C6C557DB665D6D5", hash_generated_method = "82D8B7BC805CFA0A2D65EF86CB966E15")
    @Override
    public boolean finishConnect() throws IOException {
        synchronized
(this)        {
            if(!isOpen())            
            {
                ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_1580293686 = new ClosedChannelException();
                var553E3C0ED28F94CE76A7A8061DFFDCF3_1580293686.addTaint(taint);
                throw var553E3C0ED28F94CE76A7A8061DFFDCF3_1580293686;
            } //End block
            if(status == SOCKET_STATUS_CONNECTED)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_159498336 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_577783723 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_577783723;
            } //End block
            if(status != SOCKET_STATUS_PENDING)            
            {
                NoConnectionPendingException varEFFBA2EC873295B44D8D4343CAE0620D_1481543347 = new NoConnectionPendingException();
                varEFFBA2EC873295B44D8D4343CAE0620D_1481543347.addTaint(taint);
                throw varEFFBA2EC873295B44D8D4343CAE0620D_1481543347;
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
        boolean varA5D7CEB2C59B8CEE46C2953FEC9ABC19_415384371 = (finished);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1532155723 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1532155723;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.096 -0400", hash_original_method = "1E64AA428CB659E98A86DB6C8DA80F4E", hash_generated_method = "B8BF86CF41D77F2D4D8EDCA4E44845DF")
     void finishAccept() {
        initLocalAddressAndPort();
        // ---------- Original Method ----------
        //initLocalAddressAndPort();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.096 -0400", hash_original_method = "FDE0A0D9A12F7110643554CD43F8D7B6", hash_generated_method = "E60D599E7A919AB0B6E2C4872AC1B642")
    @Override
    public int read(ByteBuffer dst) throws IOException {
        addTaint(dst.getTaint());
        dst.checkWritable();
        checkOpenConnected();
        if(!dst.hasRemaining())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1097585487 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1360875302 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1360875302;
        } //End block
        int var4DAC6F535D8C6B08C21EEF15DE32F811_1506671174 = (readImpl(dst));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1515056731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1515056731;
        // ---------- Original Method ----------
        //dst.checkWritable();
        //checkOpenConnected();
        //if (!dst.hasRemaining()) {
            //return 0;
        //}
        //return readImpl(dst);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.097 -0400", hash_original_method = "CFA00AB281069164ECAB790C179DF3F9", hash_generated_method = "9E96295019A68E69A2A579FC684FDAF1")
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
            long varCFCD208495D565EF66E7DFF9F98764DA_1228097112 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1781335180 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1781335180;
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
        long varADC9E8D761A52E26BEC5404508AFC000_1102171104 = (readCount);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_997198229 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_997198229;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.098 -0400", hash_original_method = "59936954910C41239CB7D8967AB1C758", hash_generated_method = "F3A0FF9FC7232FF48557175BF6A05D34")
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
            int varADC9E8D761A52E26BEC5404508AFC000_1005941230 = (readCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1190782255 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1190782255;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.098 -0400", hash_original_method = "DCFA2CB99033209FD40A6F8FA617CF19", hash_generated_method = "C8868D7BF7DBA6A4D0BA1A100EB70858")
    @Override
    public int write(ByteBuffer src) throws IOException {
        addTaint(src.getTaint());
        if(src == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1038083215 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1038083215.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1038083215;
        } //End block
        checkOpenConnected();
        if(!src.hasRemaining())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1116881597 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912984665 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912984665;
        } //End block
        int var8AA01C29838246F7BD8A85375A5F2DEA_1681475729 = (writeImpl(src));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965155449 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965155449;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.099 -0400", hash_original_method = "92D26B18BB75EB8AD284E7DC348B13D6", hash_generated_method = "AF0F531DBF3450C2782D8F23135833C8")
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
            long varCFCD208495D565EF66E7DFF9F98764DA_383729101 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1237473647 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1237473647;
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
        long var9CC26FA09CE37BC95AFE01BC718836D1_896826381 = (written);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_688101974 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_688101974;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.099 -0400", hash_original_method = "9CA5CC5B2105A1C6A6351FB0E1EC75B2", hash_generated_method = "C865654EA217137A31EC1F1A16E4E960")
    private int writeImpl(ByteBuffer src) throws IOException {
        addTaint(src.getTaint());
        synchronized
(writeLock)        {
            if(!src.hasRemaining())            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1800954020 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_526977394 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_526977394;
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
            int var44A1965D931137262EA3A9400DCC2A67_971492592 = (writeCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422948674 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422948674;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.100 -0400", hash_original_method = "39D9BE1DFB590318884AF060F0654BAC", hash_generated_method = "6F0CD0012402F9D22E69279C04568367")
    synchronized private void checkOpenConnected() throws ClosedChannelException {
        if(!isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_164859956 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_164859956.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_164859956;
        } //End block
        if(!isConnected())        
        {
            NotYetConnectedException var74CB2CB661C2A7775D3A554085300C50_801818666 = new NotYetConnectedException();
            var74CB2CB661C2A7775D3A554085300C50_801818666.addTaint(taint);
            throw var74CB2CB661C2A7775D3A554085300C50_801818666;
        } //End block
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedChannelException();
        //}
        //if (!isConnected()) {
            //throw new NotYetConnectedException();
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.100 -0400", hash_original_method = "ACDFE21557429638E6BE7769521129CC", hash_generated_method = "5B73F410ABA4B11CBD4BE969BF440BF0")
    synchronized private void checkUnconnected() throws IOException {
        if(!isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_464248732 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_464248732.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_464248732;
        } //End block
        if(status == SOCKET_STATUS_CONNECTED)        
        {
            AlreadyConnectedException var476065E4395D997E6E7AB97A5FAAC77C_2013678164 = new AlreadyConnectedException();
            var476065E4395D997E6E7AB97A5FAAC77C_2013678164.addTaint(taint);
            throw var476065E4395D997E6E7AB97A5FAAC77C_2013678164;
        } //End block
        if(status == SOCKET_STATUS_PENDING)        
        {
            ConnectionPendingException varACB52C98E3A165B390A8E70B71AA710E_1888129874 = new ConnectionPendingException();
            varACB52C98E3A165B390A8E70B71AA710E_1888129874.addTaint(taint);
            throw varACB52C98E3A165B390A8E70B71AA710E_1888129874;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.100 -0400", hash_original_method = "C580647FE4D156BB3A20DD6B3069A7D0", hash_generated_method = "CA20A304477B27D656E7AE5BCF657005")
    public InetAddress getLocalAddress() throws UnknownHostException {
InetAddress var7916DE881ABD051FA54E219C60ADC277_454068108 =         isBound ? localAddress : Inet4Address.ANY;
        var7916DE881ABD051FA54E219C60ADC277_454068108.addTaint(taint);
        return var7916DE881ABD051FA54E219C60ADC277_454068108;
        // ---------- Original Method ----------
        //return isBound ? localAddress : Inet4Address.ANY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.100 -0400", hash_original_method = "51888A8660147B395A4990C2BFAD98BE", hash_generated_method = "5D05870CF1A822112731287FDC2E0DC1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.101 -0400", hash_original_method = "B277EC5F8A308E553B57A0D050976387", hash_generated_method = "8A4048D7B505F1340F0DB31FC91FB3B2")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.101 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "E56607146365794D2DD5338C1E042572")
    public FileDescriptor getFD() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_1197749383 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_1197749383.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_1197749383;
        // ---------- Original Method ----------
        //return fd;
    }

    
    private static class SocketAdapter extends Socket {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.101 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "BDD8BAEA23E522D57D04980987295CB9")

        private SocketChannelImpl channel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.101 -0400", hash_original_field = "31BE1E23DE379D748DAA84AEF8C5EA67", hash_generated_field = "16CEE3972B12A3C5752670B7FF7939A7")

        private PlainSocketImpl socketImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.101 -0400", hash_original_method = "BE34C7E67ABAE2BC0D8C225897658728", hash_generated_method = "A3034C3AF47E210F06DDBFBFB0017C2B")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.101 -0400", hash_original_method = "453300FCAD69AE8F91F62237BE21CFBA", hash_generated_method = "AA7CABC2C0C59FCFDDF899A59BA1D3F7")
         PlainSocketImpl socketImpl() {
PlainSocketImpl var3C3A80B89227BA64A6B8041F12016C7F_1004060199 =             socketImpl;
            var3C3A80B89227BA64A6B8041F12016C7F_1004060199.addTaint(taint);
            return var3C3A80B89227BA64A6B8041F12016C7F_1004060199;
            // ---------- Original Method ----------
            //return socketImpl;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.101 -0400", hash_original_method = "379CE4067399395F02052517F4DCE995", hash_generated_method = "0205E222E511146780F4DD7F9946488F")
        @Override
        public SocketChannel getChannel() {
SocketChannel var99BA3483FD74E36EACD435CEE6BD5D6F_248470887 =             channel;
            var99BA3483FD74E36EACD435CEE6BD5D6F_248470887.addTaint(taint);
            return var99BA3483FD74E36EACD435CEE6BD5D6F_248470887;
            // ---------- Original Method ----------
            //return channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.101 -0400", hash_original_method = "CB881FA34C7D7FBE309BA2B3C38FD9DE", hash_generated_method = "C63F20ED238E0B9EABC21680F3E5036B")
        @Override
        public boolean isBound() {
            boolean var3C991D89CBAD7396FD87F584EAC1C3BC_1703450185 = (channel.isBound);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1489567135 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1489567135;
            // ---------- Original Method ----------
            //return channel.isBound;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.101 -0400", hash_original_method = "5CCF8EB454AE33E9E231A2BE45E2629E", hash_generated_method = "4547C03547DD4759797F4DA243005E46")
        @Override
        public boolean isConnected() {
            boolean var8CC75E4BE53866C63C2FDAFA80969695_2045604261 = (channel.isConnected());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_806441021 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_806441021;
            // ---------- Original Method ----------
            //return channel.isConnected();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.101 -0400", hash_original_method = "B0018340FF02F226576061EFB596D2DE", hash_generated_method = "62F9D0525B6A08BE05B465E0F4ED4924")
        @Override
        public InetAddress getLocalAddress() {
            try 
            {
InetAddress var6967915047D2E1192DA8894E905FDC2A_914274480 =                 channel.getLocalAddress();
                var6967915047D2E1192DA8894E905FDC2A_914274480.addTaint(taint);
                return var6967915047D2E1192DA8894E905FDC2A_914274480;
            } //End block
            catch (UnknownHostException e)
            {
InetAddress var540C13E9E156B687226421B24F2DF178_1720816298 =                 null;
                var540C13E9E156B687226421B24F2DF178_1720816298.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1720816298;
            } //End block
            // ---------- Original Method ----------
            //try {
                //return channel.getLocalAddress();
            //} catch (UnknownHostException e) {
                //return null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.102 -0400", hash_original_method = "63A88A8D435088D761BDD7938E4125E4", hash_generated_method = "6B1E10C1718EBB385FD7367B474DF339")
        @Override
        public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
            addTaint(timeout);
            addTaint(remoteAddr.getTaint());
            if(!channel.isBlocking())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_1922480629 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_1922480629.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_1922480629;
            } //End block
            if(isConnected())            
            {
                AlreadyConnectedException var476065E4395D997E6E7AB97A5FAAC77C_735143607 = new AlreadyConnectedException();
                var476065E4395D997E6E7AB97A5FAAC77C_735143607.addTaint(taint);
                throw var476065E4395D997E6E7AB97A5FAAC77C_735143607;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.102 -0400", hash_original_method = "B60964A84DDE0034E73C148BED7594EB", hash_generated_method = "B49630C5181CE729B5FC536F7F194C9A")
        @Override
        public void bind(SocketAddress localAddr) throws IOException {
            addTaint(localAddr.getTaint());
            if(channel.isConnected())            
            {
                AlreadyConnectedException var476065E4395D997E6E7AB97A5FAAC77C_240644713 = new AlreadyConnectedException();
                var476065E4395D997E6E7AB97A5FAAC77C_240644713.addTaint(taint);
                throw var476065E4395D997E6E7AB97A5FAAC77C_240644713;
            } //End block
            if(SocketChannelImpl.SOCKET_STATUS_PENDING == channel.status)            
            {
                ConnectionPendingException varACB52C98E3A165B390A8E70B71AA710E_24935929 = new ConnectionPendingException();
                varACB52C98E3A165B390A8E70B71AA710E_24935929.addTaint(taint);
                throw varACB52C98E3A165B390A8E70B71AA710E_24935929;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.102 -0400", hash_original_method = "D341E1E6C64813CEE43FACEF8CA53A78", hash_generated_method = "4347B4C85E05C59F22F10FBF166304B0")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.102 -0400", hash_original_method = "33C0B42780F1E273103B5BBAE79F7408", hash_generated_method = "C31C621CD9AA94076A189321016C3622")
        @Override
        public OutputStream getOutputStream() throws IOException {
            checkOpenAndConnected();
            if(isOutputShutdown())            
            {
                SocketException varAEED29E2676080AAAF1B3CDFF0042316_1559245533 = new SocketException("Socket output is shutdown");
                varAEED29E2676080AAAF1B3CDFF0042316_1559245533.addTaint(taint);
                throw varAEED29E2676080AAAF1B3CDFF0042316_1559245533;
            } //End block
OutputStream var385144943979ABAF397D041725C7E189_279299291 =             new SocketChannelOutputStream(channel);
            var385144943979ABAF397D041725C7E189_279299291.addTaint(taint);
            return var385144943979ABAF397D041725C7E189_279299291;
            // ---------- Original Method ----------
            //checkOpenAndConnected();
            //if (isOutputShutdown()) {
                //throw new SocketException("Socket output is shutdown");
            //}
            //return new SocketChannelOutputStream(channel);
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.102 -0400", hash_original_method = "84598A158E9BC4BA9724B2EC04F9ADAB", hash_generated_method = "2C9A5A08085716D9DF1582234312DAA1")
        @Override
        public InputStream getInputStream() throws IOException {
            checkOpenAndConnected();
            if(isInputShutdown())            
            {
                SocketException var7F56FCFB5848FA2F7798A02081088E95_106434587 = new SocketException("Socket input is shutdown");
                var7F56FCFB5848FA2F7798A02081088E95_106434587.addTaint(taint);
                throw var7F56FCFB5848FA2F7798A02081088E95_106434587;
            } //End block
InputStream varBBCB65A129E4FF2F4EF7DA1CCF148B3D_1407690018 =             new SocketChannelInputStream(channel);
            varBBCB65A129E4FF2F4EF7DA1CCF148B3D_1407690018.addTaint(taint);
            return varBBCB65A129E4FF2F4EF7DA1CCF148B3D_1407690018;
            // ---------- Original Method ----------
            //checkOpenAndConnected();
            //if (isInputShutdown()) {
                //throw new SocketException("Socket input is shutdown");
            //}
            //return new SocketChannelInputStream(channel);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.103 -0400", hash_original_method = "6DFEABBD8C66364625150870CA176E5F", hash_generated_method = "CEF0DE8FBD2C7C2FD01862DDF9467264")
        private void checkOpenAndConnected() throws SocketException {
            if(!channel.isOpen())            
            {
                SocketException var5AD72407DD9337ABED4666C49A30EC41_770902814 = new SocketException("Socket is closed");
                var5AD72407DD9337ABED4666C49A30EC41_770902814.addTaint(taint);
                throw var5AD72407DD9337ABED4666C49A30EC41_770902814;
            } //End block
            if(!channel.isConnected())            
            {
                SocketException var56B6B46DDA80C85C37F76D6551ACB00C_2127445373 = new SocketException("Socket is not connected");
                var56B6B46DDA80C85C37F76D6551ACB00C_2127445373.addTaint(taint);
                throw var56B6B46DDA80C85C37F76D6551ACB00C_2127445373;
            } //End block
            // ---------- Original Method ----------
            //if (!channel.isOpen()) {
                //throw new SocketException("Socket is closed");
            //}
            //if (!channel.isConnected()) {
                //throw new SocketException("Socket is not connected");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.103 -0400", hash_original_method = "7907395A2BDEF0093C42980D22D2F1FF", hash_generated_method = "99ECF1E64CEF4C88B2BC5F5FEE18EA69")
        @Override
        public FileDescriptor getFileDescriptor$() {
FileDescriptor var0DACFA040D27F7D032EACE256C40E7C8_2056291803 =             socketImpl.getFD$();
            var0DACFA040D27F7D032EACE256C40E7C8_2056291803.addTaint(taint);
            return var0DACFA040D27F7D032EACE256C40E7C8_2056291803;
            // ---------- Original Method ----------
            //return socketImpl.getFD$();
        }

        
    }


    
    private static class SocketChannelOutputStream extends OutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.103 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "E9077990D7B99E1545AE06215D5C5888")

        private SocketChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.103 -0400", hash_original_method = "EBB61A0ABCF2B47C9E2AA3F506A7D0F7", hash_generated_method = "87F5FBA8759F42229F1FFA4E785B5FC9")
        public  SocketChannelOutputStream(SocketChannel channel) {
            this.channel = channel;
            // ---------- Original Method ----------
            //this.channel = channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.103 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "52F7C33AE9AC04D22BBF80B1439C0461")
        @Override
        public void close() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.103 -0400", hash_original_method = "376EE3F97840D4205E91F242BC3F90AA", hash_generated_method = "9B8BA1A5E4D264BCCDA09C5F2967F68D")
        @Override
        public void write(byte[] buffer, int offset, int byteCount) throws IOException {
            addTaint(byteCount);
            addTaint(offset);
            addTaint(buffer[0]);
            Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
            if(!channel.isBlocking())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_1566841508 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_1566841508.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_1566841508;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.103 -0400", hash_original_method = "F1C26F791F3FC6DB336B7A388343CAEE", hash_generated_method = "8A8A0628B44D20C50E2A61395D15CF60")
        @Override
        public void write(int oneByte) throws IOException {
            addTaint(oneByte);
            if(!channel.isBlocking())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_1604677221 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_1604677221.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_1604677221;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.104 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "E9077990D7B99E1545AE06215D5C5888")

        private SocketChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.104 -0400", hash_original_method = "6BC169A329FCC47D43DDDAAFDB17AB6A", hash_generated_method = "8E092B2B7F6933899BF0ED405D943216")
        public  SocketChannelInputStream(SocketChannel channel) {
            this.channel = channel;
            // ---------- Original Method ----------
            //this.channel = channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.104 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "52F7C33AE9AC04D22BBF80B1439C0461")
        @Override
        public void close() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.104 -0400", hash_original_method = "9D425CB1AFA4E4568C9C3855468C26CA", hash_generated_method = "A365197E7D9441EA56C09B92588A23F3")
        @Override
        public int read() throws IOException {
            if(!channel.isBlocking())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_427215002 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_427215002.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_427215002;
            } //End block
            ByteBuffer buf = ByteBuffer.allocate(1);
            int result = channel.read(buf);
            int var1C767A03D604110625E958FA2E3DF1F5_670239694 = ((result == -1) ? result : (buf.get(0) & 0xff));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_319150913 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_319150913;
            // ---------- Original Method ----------
            //if (!channel.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //ByteBuffer buf = ByteBuffer.allocate(1);
            //int result = channel.read(buf);
            //return (result == -1) ? result : (buf.get(0) & 0xff);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.104 -0400", hash_original_method = "EA379AE73CA210BAF79C2B35EBD964D5", hash_generated_method = "14F05EA806D9F42BC48858CB3C0E4896")
        @Override
        public int read(byte[] buffer, int offset, int byteCount) throws IOException {
            addTaint(byteCount);
            addTaint(offset);
            addTaint(buffer[0]);
            Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            if(!channel.isBlocking())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_2028230086 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_2028230086.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_2028230086;
            } //End block
            ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
            int varACF968FE9006787EB655B878BB773697_365535337 = (channel.read(buf));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121351876 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121351876;
            // ---------- Original Method ----------
            //Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            //if (!channel.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
            //return channel.read(buf);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.104 -0400", hash_original_field = "F7874D1ECFDF317B7B0B49E529318271", hash_generated_field = "C681A88E046FA43323BC16B2855934C2")

    private static final int SOCKET_STATUS_UNINITIALIZED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.104 -0400", hash_original_field = "E7869BFA26651C1A91DF76F29F4AC46C", hash_generated_field = "528B797B61169045F38323ED5AA4ADC9")

    private static final int SOCKET_STATUS_UNCONNECTED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.104 -0400", hash_original_field = "EDC041CF402AA3C46826C9E2AE49AE9E", hash_generated_field = "7A7EF73F99E82F4A0F05F52DF78136A3")

    private static final int SOCKET_STATUS_PENDING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.104 -0400", hash_original_field = "461AFCE1A5AEC5CF2C2D26AAE231795E", hash_generated_field = "C2F55AFC3D6E4976A560F2A180895BAB")

    private static final int SOCKET_STATUS_CONNECTED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.105 -0400", hash_original_field = "7E35E1AB365CC43A545D22B9D85FC951", hash_generated_field = "C1A214D8C71AC08214F82C6ABD1A3CFD")

    private static final int SOCKET_STATUS_CLOSED = 3;
}

