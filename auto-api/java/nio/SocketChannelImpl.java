package java.nio;

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.474 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.474 -0400", hash_original_field = "E728D69D332AE7988C6FE7869D66573E", hash_generated_field = "99CA27ADD3E21B5E0B3E73B3D40E63C8")

    private SocketAdapter socket = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.474 -0400", hash_original_field = "01E982E0501B1B10CFBB661526A8D271", hash_generated_field = "33A55C1E7A49F26B03A955656EFC6766")

    private InetSocketAddress connectAddress = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.474 -0400", hash_original_field = "299B8F7D460321B85DDDB1F9B3BD6EC0", hash_generated_field = "DBBBD6A1106DBEC2B30B9A1EF113618A")

    private InetAddress localAddress = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.474 -0400", hash_original_field = "55FC25CF376E1B7BFFBC2D46F357C231", hash_generated_field = "B1420775EE6B172A515A5BC10BFFE633")

    private int localPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.474 -0400", hash_original_field = "FA7C2E9A18B37E6193498C5920F4EBB1", hash_generated_field = "60CA0FDD070D9706A5FF0681764E3085")

    private int status = SOCKET_STATUS_UNINITIALIZED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.474 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "A5CF5255096CFE4A8B3A025A6EBE0953")

    private volatile boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.474 -0400", hash_original_field = "0EBBDB2C6AB02F595FD6B8EE0165CE90", hash_generated_field = "0BDEB8ABE1932E75D75EE50EF5D56058")

    private Object readLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.474 -0400", hash_original_field = "5A9206244ED4B85CC1847D97E427123C", hash_generated_field = "04E97E6709F6F21DAA184AB6BB309FED")

    private Object writeLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.474 -0400", hash_original_method = "CAD27D317D6065C47064EE5BE7F99097", hash_generated_method = "2378AFB80E6B30B428BEA86F4209CAE1")
    public  SocketChannelImpl(SelectorProvider selectorProvider) throws IOException {
        this(selectorProvider, true);
        addTaint(selectorProvider.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.487 -0400", hash_original_method = "14271155322FDAFE1124C07CD8798E82", hash_generated_method = "6960BB1A0E3C9E5603F8C84C78936F80")
    public  SocketChannelImpl(SelectorProvider selectorProvider, boolean connect) throws IOException {
        super(selectorProvider);
        status = SOCKET_STATUS_UNCONNECTED;
        fd = (connect ? IoBridge.socket(true) : new FileDescriptor());
        addTaint(selectorProvider.getTaint());
        // ---------- Original Method ----------
        //status = SOCKET_STATUS_UNCONNECTED;
        //fd = (connect ? IoBridge.socket(true) : new FileDescriptor());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.488 -0400", hash_original_method = "3F3C938694E8E43B39A86772053FE6F3", hash_generated_method = "B83DEE6B91668556E5061092B692FEAF")
    @Override
    synchronized public Socket socket() {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1483093329 = null; //Variable for return #1
        Socket varB4EAC82CA7396A68D541C85D26508E83_821975703 = null; //Variable for return #2
        {
            try 
            {
                InetAddress addr;
                addr = null;
                int port;
                port = 0;
                {
                    addr = connectAddress.getAddress();
                    port = connectAddress.getPort();
                } //End block
                socket = new SocketAdapter(new PlainSocketImpl(fd, localPort, addr, port), this);
            } //End block
            catch (SocketException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1483093329 = null;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_821975703 = socket;
        Socket varA7E53CE21691AB073D9660D615818899_1167204708; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1167204708 = varB4EAC82CA7396A68D541C85D26508E83_1483093329;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1167204708 = varB4EAC82CA7396A68D541C85D26508E83_821975703;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1167204708.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1167204708;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.488 -0400", hash_original_method = "E73B250252340190221059BC9BBB0CEA", hash_generated_method = "1067FBD522B2DDB5F6A0DE7BCA10BED6")
    @Override
    synchronized public boolean isConnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_271369442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_271369442;
        // ---------- Original Method ----------
        //return status == SOCKET_STATUS_CONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.489 -0400", hash_original_method = "18A2FCE579B69612BF9446C66CFB3DF7", hash_generated_method = "5D3DA2D559AD2203AFF1C673C3E7CE27")
    synchronized void setConnected() {
        status = SOCKET_STATUS_CONNECTED;
        // ---------- Original Method ----------
        //status = SOCKET_STATUS_CONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.489 -0400", hash_original_method = "F9CE278FD490C297CB59C718AF3342C0", hash_generated_method = "2B429B88376943DA3612015A73DC81DF")
     void setBound(boolean flag) {
        isBound = flag;
        // ---------- Original Method ----------
        //isBound = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.489 -0400", hash_original_method = "69EAA9B42272F648401C29FF5A206BD4", hash_generated_method = "DDA2617236816DD43C04DDA64ACA9A2C")
    @Override
    synchronized public boolean isConnectionPending() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_513313256 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_513313256;
        // ---------- Original Method ----------
        //return status == SOCKET_STATUS_PENDING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.491 -0400", hash_original_method = "06D5BE9697FA1F6A3605D3BCB50E04A0", hash_generated_method = "FFA27676F191ED8693939C4858103EFF")
    @Override
    public boolean connect(SocketAddress socketAddress) throws IOException {
        checkUnconnected();
        InetSocketAddress inetSocketAddress;
        inetSocketAddress = validateAddress(socketAddress);
        InetAddress normalAddr;
        normalAddr = inetSocketAddress.getAddress();
        int port;
        port = inetSocketAddress.getPort();
        {
            boolean var9D48DC931E492377A49A99625D8702AF_610235206 = (normalAddr.isAnyLocalAddress());
            {
                normalAddr = InetAddress.getLocalHost();
            } //End block
        } //End collapsed parenthetic
        boolean finished;
        finished = false;
        try 
        {
            {
                boolean var68B8B1E8730E5750DDC2DBC3D79531D6_198473609 = (isBlocking());
                {
                    begin();
                } //End block
            } //End collapsed parenthetic
            finished = IoBridge.connect(fd, normalAddr, port);
            isBound = finished;
        } //End block
        catch (IOException e)
        {
            {
                boolean varA4CEA94BC1DFD4F428C5D705C325D140_1060808157 = (e instanceof ConnectException && !isBlocking());
                {
                    status = SOCKET_STATUS_PENDING;
                } //End block
                {
                    {
                        boolean var38DB1B8F084762ACC3DA3FC1E1C706D4_1659891800 = (isOpen());
                        {
                            close();
                            finished = true;
                        } //End block
                    } //End collapsed parenthetic
                    if (DroidSafeAndroidRuntime.control) throw e;
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            {
                boolean var68B8B1E8730E5750DDC2DBC3D79531D6_1744325643 = (isBlocking());
                {
                    end(finished);
                } //End block
            } //End collapsed parenthetic
        } //End block
        initLocalAddressAndPort();
        connectAddress = inetSocketAddress;
        {
            socket.socketImpl().initRemoteAddressAndPort(connectAddress.getAddress(),
                    connectAddress.getPort());
        } //End block
        {
            {
                boolean var68B8B1E8730E5750DDC2DBC3D79531D6_1904067464 = (isBlocking());
                {
                    status = (finished ? SOCKET_STATUS_CONNECTED : SOCKET_STATUS_UNCONNECTED);
                } //End block
                {
                    status = SOCKET_STATUS_PENDING;
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(socketAddress.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1525940229 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1525940229;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.492 -0400", hash_original_method = "06F6825183E6F900AF6E00DC91481B34", hash_generated_method = "BDC9BA56CF471B22CD0B7A1ABE077229")
    private void initLocalAddressAndPort() {
        SocketAddress sa;
        try 
        {
            sa = Libcore.os.getsockname(fd);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(errnoException);
        } //End block
        InetSocketAddress isa;
        isa = (InetSocketAddress) sa;
        localAddress = isa.getAddress();
        localPort = isa.getPort();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.517 -0400", hash_original_method = "240D4967AAA5DC479C6C557DB665D6D5", hash_generated_method = "45EBA9151736FB5664578489E58C5C15")
    @Override
    public boolean finishConnect() throws IOException {
        {
            {
                boolean varC984E2D68DED4A73C5D827F4E91A6961_2038037861 = (!isOpen());
                {
                    if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
                } //End block
            } //End collapsed parenthetic
            {
                if (DroidSafeAndroidRuntime.control) throw new NoConnectionPendingException();
            } //End block
        } //End block
        boolean finished;
        finished = false;
        try 
        {
            begin();
            InetAddress inetAddress;
            inetAddress = connectAddress.getAddress();
            int port;
            port = connectAddress.getPort();
            finished = IoBridge.isConnected(fd, inetAddress, port, 0, 0);
            isBound = finished;
        } //End block
        catch (ConnectException e)
        {
            {
                boolean var5A39A3129B438981221C0F68BD29C416_1684067335 = (isOpen());
                {
                    close();
                    finished = true;
                } //End block
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        finally 
        {
            end(finished);
        } //End block
        {
            status = (finished ? SOCKET_STATUS_CONNECTED : status);
            isBound = finished;
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_899568724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_899568724;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.518 -0400", hash_original_method = "1E64AA428CB659E98A86DB6C8DA80F4E", hash_generated_method = "B8BF86CF41D77F2D4D8EDCA4E44845DF")
     void finishAccept() {
        initLocalAddressAndPort();
        // ---------- Original Method ----------
        //initLocalAddressAndPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.518 -0400", hash_original_method = "FDE0A0D9A12F7110643554CD43F8D7B6", hash_generated_method = "54C6720461D252B010667B595C1452BF")
    @Override
    public int read(ByteBuffer dst) throws IOException {
        dst.checkWritable();
        checkOpenConnected();
        {
            boolean var6F90D44D152DE0B0B5D2B2B04737CEF4_175846562 = (!dst.hasRemaining());
        } //End collapsed parenthetic
        int varB7CDC98136CC69D5238E9EEE037C76E7_1975647232 = (readImpl(dst));
        addTaint(dst.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885287125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885287125;
        // ---------- Original Method ----------
        //dst.checkWritable();
        //checkOpenConnected();
        //if (!dst.hasRemaining()) {
            //return 0;
        //}
        //return readImpl(dst);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.519 -0400", hash_original_method = "CFA00AB281069164ECAB790C179DF3F9", hash_generated_method = "30C05872A34D559A033F7B35EEDA5576")
    @Override
    public long read(ByteBuffer[] targets, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(targets.length, offset, length);
        checkOpenConnected();
        int totalCount;
        totalCount = FileChannelImpl.calculateTotalRemaining(targets, offset, length, true);
        byte[] readArray;
        readArray = new byte[totalCount];
        ByteBuffer readBuffer;
        readBuffer = ByteBuffer.wrap(readArray);
        int readCount;
        readCount = readImpl(readBuffer);
        readBuffer.flip();
        {
            int left;
            left = readCount;
            int index;
            index = offset;
            {
                int putLength;
                putLength = Math.min(targets[index].remaining(), left);
                targets[index].put(readArray, readCount - left, putLength);
                left -= putLength;
            } //End block
        } //End block
        addTaint(targets[0].getTaint());
        addTaint(offset);
        addTaint(length);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_280197021 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_280197021;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.526 -0400", hash_original_method = "59936954910C41239CB7D8967AB1C758", hash_generated_method = "386E6C0B62B0FDA878A436E8AB5117A1")
    private int readImpl(ByteBuffer dst) throws IOException {
        {
            int readCount;
            readCount = 0;
            try 
            {
                {
                    boolean var623CDD0E0F4A60A403D4DD2515E8FCEF_30995989 = (isBlocking());
                    {
                        begin();
                    } //End block
                } //End collapsed parenthetic
                readCount = IoBridge.recvfrom(true, fd, dst, 0, null, false);
                {
                    dst.position(dst.position() + readCount);
                } //End block
            } //End block
            finally 
            {
                {
                    boolean var623CDD0E0F4A60A403D4DD2515E8FCEF_1650753716 = (isBlocking());
                    {
                        end(readCount > 0);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(dst.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861745211 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861745211;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.527 -0400", hash_original_method = "DCFA2CB99033209FD40A6F8FA617CF19", hash_generated_method = "A188DE8477B4646E91D2B9642989B9E7")
    @Override
    public int write(ByteBuffer src) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        checkOpenConnected();
        {
            boolean var78714B40A2AE0B69755CF30C747E39CB_1617935845 = (!src.hasRemaining());
        } //End collapsed parenthetic
        int varE3BFAA173F253FF6C667377BE4955DF1_1422502025 = (writeImpl(src));
        addTaint(src.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120038843 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120038843;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.538 -0400", hash_original_method = "92D26B18BB75EB8AD284E7DC348B13D6", hash_generated_method = "A34F2C9E1A863700D91764BC69F7196E")
    @Override
    public long write(ByteBuffer[] sources, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(sources.length, offset, length);
        checkOpenConnected();
        int count;
        count = FileChannelImpl.calculateTotalRemaining(sources, offset, length, false);
        ByteBuffer writeBuf;
        writeBuf = ByteBuffer.allocate(count);
        {
            int val;
            val = offset;
            {
                ByteBuffer source;
                source = sources[val];
                int oldPosition;
                oldPosition = source.position();
                writeBuf.put(source);
                source.position(oldPosition);
            } //End block
        } //End collapsed parenthetic
        writeBuf.flip();
        int result;
        result = writeImpl(writeBuf);
        int val;
        val = offset;
        int written;
        written = result;
        {
            ByteBuffer source;
            source = sources[val];
            int gap;
            gap = Math.min(result, source.remaining());
            source.position(source.position() + gap);
            result -= gap;
        } //End block
        addTaint(sources[0].getTaint());
        addTaint(offset);
        addTaint(length);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_800721347 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_800721347;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.547 -0400", hash_original_method = "9CA5CC5B2105A1C6A6351FB0E1EC75B2", hash_generated_method = "97486AABC215EEC3C6E4D8A4BF035FCE")
    private int writeImpl(ByteBuffer src) throws IOException {
        {
            {
                boolean var1179A331310E0BE82A95CA682488BDB7_231755665 = (!src.hasRemaining());
            } //End collapsed parenthetic
            int writeCount;
            writeCount = 0;
            try 
            {
                {
                    boolean var623CDD0E0F4A60A403D4DD2515E8FCEF_533853977 = (isBlocking());
                    {
                        begin();
                    } //End block
                } //End collapsed parenthetic
                writeCount = IoBridge.sendto(fd, src, 0, null, 0);
                {
                    src.position(src.position() + writeCount);
                } //End block
            } //End block
            finally 
            {
                {
                    boolean var623CDD0E0F4A60A403D4DD2515E8FCEF_1293155478 = (isBlocking());
                    {
                        end(writeCount >= 0);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(src.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6010451 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6010451;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.548 -0400", hash_original_method = "39D9BE1DFB590318884AF060F0654BAC", hash_generated_method = "4F1BEA0195B8A99F2BB6C6E67023338D")
    synchronized private void checkOpenConnected() throws ClosedChannelException {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_732672272 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_220878086 = (!isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new NotYetConnectedException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedChannelException();
        //}
        //if (!isConnected()) {
            //throw new NotYetConnectedException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.559 -0400", hash_original_method = "ACDFE21557429638E6BE7769521129CC", hash_generated_method = "62D4351CBA036E9C860492067CD9DDB4")
    synchronized private void checkUnconnected() throws IOException {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_861417041 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new AlreadyConnectedException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ConnectionPendingException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.560 -0400", hash_original_method = "C580647FE4D156BB3A20DD6B3069A7D0", hash_generated_method = "F432A1CA5F177240F2C540586A5F5FA0")
    public InetAddress getLocalAddress() throws UnknownHostException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_110550095 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_110550095 = isBound ? localAddress : Inet4Address.ANY;
        varB4EAC82CA7396A68D541C85D26508E83_110550095.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_110550095;
        // ---------- Original Method ----------
        //return isBound ? localAddress : Inet4Address.ANY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.570 -0400", hash_original_method = "51888A8660147B395A4990C2BFAD98BE", hash_generated_method = "D5FF3E87436FCEDBA635DFC93634D3AC")
    @Override
    protected synchronized void implCloseSelectableChannel() throws IOException {
        {
            status = SOCKET_STATUS_CLOSED;
            {
                boolean var5F42E5264EA5F3174237C9C15FBBF8AB_955891528 = (socket != null && !socket.isClosed());
                {
                    socket.close();
                } //End block
                {
                    IoBridge.closeSocket(fd);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.570 -0400", hash_original_method = "B277EC5F8A308E553B57A0D050976387", hash_generated_method = "1386B180F2EB476C4C1A8414B34D61F9")
    @Override
    protected void implConfigureBlocking(boolean blocking) throws IOException {
        {
            Object var964C97B960BB46676C47DA572AAFDDC9_1342726430 = (blockingLock());
            {
                IoUtils.setBlocking(fd, blocking);
            } //End block
        } //End collapsed parenthetic
        addTaint(blocking);
        // ---------- Original Method ----------
        //synchronized (blockingLock()) {
            //IoUtils.setBlocking(fd, blocking);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.571 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "68A494109179B75380A24F6A0DA77CBC")
    public FileDescriptor getFD() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1955399028 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1955399028 = fd;
        varB4EAC82CA7396A68D541C85D26508E83_1955399028.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1955399028;
        // ---------- Original Method ----------
        //return fd;
    }

    
    private static class SocketAdapter extends Socket {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.571 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "BDD8BAEA23E522D57D04980987295CB9")

        private SocketChannelImpl channel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.571 -0400", hash_original_field = "31BE1E23DE379D748DAA84AEF8C5EA67", hash_generated_field = "16CEE3972B12A3C5752670B7FF7939A7")

        private PlainSocketImpl socketImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.590 -0400", hash_original_method = "BE34C7E67ABAE2BC0D8C225897658728", hash_generated_method = "A3034C3AF47E210F06DDBFBFB0017C2B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.591 -0400", hash_original_method = "453300FCAD69AE8F91F62237BE21CFBA", hash_generated_method = "65923369F354CF5ED2085A1BEB395521")
         PlainSocketImpl socketImpl() {
            PlainSocketImpl varB4EAC82CA7396A68D541C85D26508E83_1223096972 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1223096972 = socketImpl;
            varB4EAC82CA7396A68D541C85D26508E83_1223096972.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1223096972;
            // ---------- Original Method ----------
            //return socketImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.591 -0400", hash_original_method = "379CE4067399395F02052517F4DCE995", hash_generated_method = "9BDDA515CC1DE50B076048AD067F31E1")
        @Override
        public SocketChannel getChannel() {
            SocketChannel varB4EAC82CA7396A68D541C85D26508E83_1315999854 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1315999854 = channel;
            varB4EAC82CA7396A68D541C85D26508E83_1315999854.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1315999854;
            // ---------- Original Method ----------
            //return channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.591 -0400", hash_original_method = "CB881FA34C7D7FBE309BA2B3C38FD9DE", hash_generated_method = "B4B08AC124DAF46AFA80F95B930C5D72")
        @Override
        public boolean isBound() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1109862414 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1109862414;
            // ---------- Original Method ----------
            //return channel.isBound;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.594 -0400", hash_original_method = "5CCF8EB454AE33E9E231A2BE45E2629E", hash_generated_method = "F5A5151731E69257E0F0DB4A17F29F28")
        @Override
        public boolean isConnected() {
            boolean var4A0C2A19B307D930C6073296AB3A7245_1069884228 = (channel.isConnected());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144216446 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144216446;
            // ---------- Original Method ----------
            //return channel.isConnected();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.601 -0400", hash_original_method = "B0018340FF02F226576061EFB596D2DE", hash_generated_method = "23F57197002F4719C29A80BA6FA66179")
        @Override
        public InetAddress getLocalAddress() {
            InetAddress varB4EAC82CA7396A68D541C85D26508E83_1713697331 = null; //Variable for return #1
            InetAddress varB4EAC82CA7396A68D541C85D26508E83_2049179854 = null; //Variable for return #2
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1713697331 = channel.getLocalAddress();
            } //End block
            catch (UnknownHostException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_2049179854 = null;
            } //End block
            InetAddress varA7E53CE21691AB073D9660D615818899_991949938; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_991949938 = varB4EAC82CA7396A68D541C85D26508E83_1713697331;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_991949938 = varB4EAC82CA7396A68D541C85D26508E83_2049179854;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_991949938.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_991949938;
            // ---------- Original Method ----------
            //try {
                //return channel.getLocalAddress();
            //} catch (UnknownHostException e) {
                //return null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.602 -0400", hash_original_method = "63A88A8D435088D761BDD7938E4125E4", hash_generated_method = "5DF90440F8983DF92A8996E72D4684EE")
        @Override
        public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
            {
                boolean var31F20A963DD0F8C963A5583943EE8E0D_1328979718 = (!channel.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            {
                boolean varFA36AC43277248F2D2361BC3C99BD36F_1591710041 = (isConnected());
                {
                    if (DroidSafeAndroidRuntime.control) throw new AlreadyConnectedException();
                } //End block
            } //End collapsed parenthetic
            super.connect(remoteAddr, timeout);
            channel.initLocalAddressAndPort();
            {
                boolean varC5A2DA1F71060520F3E811646A5DB87C_1732121429 = (super.isConnected());
                {
                    channel.setConnected();
                    channel.isBound = super.isBound();
                } //End block
            } //End collapsed parenthetic
            addTaint(remoteAddr.getTaint());
            addTaint(timeout);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.602 -0400", hash_original_method = "B60964A84DDE0034E73C148BED7594EB", hash_generated_method = "D9CC5FCCA29C4BF207F81633A632CAB6")
        @Override
        public void bind(SocketAddress localAddr) throws IOException {
            {
                boolean varF862C9231EB37437C458160DDDD0291B_314498552 = (channel.isConnected());
                {
                    if (DroidSafeAndroidRuntime.control) throw new AlreadyConnectedException();
                } //End block
            } //End collapsed parenthetic
            {
                if (DroidSafeAndroidRuntime.control) throw new ConnectionPendingException();
            } //End block
            super.bind(localAddr);
            channel.initLocalAddressAndPort();
            channel.isBound = true;
            addTaint(localAddr.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.603 -0400", hash_original_method = "D341E1E6C64813CEE43FACEF8CA53A78", hash_generated_method = "C980DC675D66BC9DDB2232F1CD105963")
        @Override
        public void close() throws IOException {
            {
                {
                    boolean varE0F055A9C0DCD5EDAA870962779DF7DB_1289428960 = (channel.isOpen());
                    {
                        channel.close();
                    } //End block
                    {
                        super.close();
                    } //End block
                } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.604 -0400", hash_original_method = "33C0B42780F1E273103B5BBAE79F7408", hash_generated_method = "61CB846432750294CB4C4DD2CFAA34D6")
        @Override
        public OutputStream getOutputStream() throws IOException {
            OutputStream varB4EAC82CA7396A68D541C85D26508E83_1146961734 = null; //Variable for return #1
            checkOpenAndConnected();
            {
                boolean varEC9D653DD89FE0D5830DD498811BBAE2_962607056 = (isOutputShutdown());
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket output is shutdown");
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1146961734 = new SocketChannelOutputStream(channel);
            varB4EAC82CA7396A68D541C85D26508E83_1146961734.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1146961734;
            // ---------- Original Method ----------
            //checkOpenAndConnected();
            //if (isOutputShutdown()) {
                //throw new SocketException("Socket output is shutdown");
            //}
            //return new SocketChannelOutputStream(channel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.620 -0400", hash_original_method = "84598A158E9BC4BA9724B2EC04F9ADAB", hash_generated_method = "835A8A586AFB2CD134FAA76740A00D72")
        @Override
        public InputStream getInputStream() throws IOException {
            InputStream varB4EAC82CA7396A68D541C85D26508E83_2016910816 = null; //Variable for return #1
            checkOpenAndConnected();
            {
                boolean var32122513FDCE5AFB04D0B48DEB0414DC_685366119 = (isInputShutdown());
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket input is shutdown");
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_2016910816 = new SocketChannelInputStream(channel);
            varB4EAC82CA7396A68D541C85D26508E83_2016910816.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2016910816;
            // ---------- Original Method ----------
            //checkOpenAndConnected();
            //if (isInputShutdown()) {
                //throw new SocketException("Socket input is shutdown");
            //}
            //return new SocketChannelInputStream(channel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.625 -0400", hash_original_method = "6DFEABBD8C66364625150870CA176E5F", hash_generated_method = "26356263BE1EAC7E3A0A85018100F60A")
        private void checkOpenAndConnected() throws SocketException {
            {
                boolean var87A07A56ACC984631C8D228EFAB4567A_1325124032 = (!channel.isOpen());
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
                } //End block
            } //End collapsed parenthetic
            {
                boolean varADD5E1CD7EA6BFC14E28EF47A4C07DD3_388374288 = (!channel.isConnected());
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is not connected");
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (!channel.isOpen()) {
                //throw new SocketException("Socket is closed");
            //}
            //if (!channel.isConnected()) {
                //throw new SocketException("Socket is not connected");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.627 -0400", hash_original_method = "7907395A2BDEF0093C42980D22D2F1FF", hash_generated_method = "6F864C88A2281E693D8C3F9E1133FB81")
        @Override
        public FileDescriptor getFileDescriptor$() {
            FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_2107683532 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2107683532 = socketImpl.getFD$();
            varB4EAC82CA7396A68D541C85D26508E83_2107683532.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2107683532;
            // ---------- Original Method ----------
            //return socketImpl.getFD$();
        }

        
    }


    
    private static class SocketChannelOutputStream extends OutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.628 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "E9077990D7B99E1545AE06215D5C5888")

        private SocketChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.628 -0400", hash_original_method = "EBB61A0ABCF2B47C9E2AA3F506A7D0F7", hash_generated_method = "87F5FBA8759F42229F1FFA4E785B5FC9")
        public  SocketChannelOutputStream(SocketChannel channel) {
            this.channel = channel;
            // ---------- Original Method ----------
            //this.channel = channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.628 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "52F7C33AE9AC04D22BBF80B1439C0461")
        @Override
        public void close() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.629 -0400", hash_original_method = "376EE3F97840D4205E91F242BC3F90AA", hash_generated_method = "3C8A2F6CE87909116972CD4412580951")
        @Override
        public void write(byte[] buffer, int offset, int byteCount) throws IOException {
            Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            ByteBuffer buf;
            buf = ByteBuffer.wrap(buffer, offset, byteCount);
            {
                boolean var31F20A963DD0F8C963A5583943EE8E0D_238291878 = (!channel.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            channel.write(buf);
            addTaint(buffer[0]);
            addTaint(offset);
            addTaint(byteCount);
            // ---------- Original Method ----------
            //Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            //ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
            //if (!channel.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //channel.write(buf);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.629 -0400", hash_original_method = "F1C26F791F3FC6DB336B7A388343CAEE", hash_generated_method = "545BD09E39D47A02282C22260F6227E6")
        @Override
        public void write(int oneByte) throws IOException {
            {
                boolean var31F20A963DD0F8C963A5583943EE8E0D_827830254 = (!channel.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            ByteBuffer buffer;
            buffer = ByteBuffer.allocate(1);
            buffer.put(0, (byte) (oneByte & 0xFF));
            channel.write(buffer);
            addTaint(oneByte);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.714 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "E9077990D7B99E1545AE06215D5C5888")

        private SocketChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.715 -0400", hash_original_method = "6BC169A329FCC47D43DDDAAFDB17AB6A", hash_generated_method = "8E092B2B7F6933899BF0ED405D943216")
        public  SocketChannelInputStream(SocketChannel channel) {
            this.channel = channel;
            // ---------- Original Method ----------
            //this.channel = channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.715 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "52F7C33AE9AC04D22BBF80B1439C0461")
        @Override
        public void close() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.716 -0400", hash_original_method = "9D425CB1AFA4E4568C9C3855468C26CA", hash_generated_method = "7E458B00366C50A4F59EDAA0D9A5E62B")
        @Override
        public int read() throws IOException {
            {
                boolean var31F20A963DD0F8C963A5583943EE8E0D_118268058 = (!channel.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            ByteBuffer buf;
            buf = ByteBuffer.allocate(1);
            int result;
            result = channel.read(buf);
            {
                Object varACA6FF37247651D0824447DCED5A764C_662798759 = ((buf.get(0) & 0xff));
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1926018 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1926018;
            // ---------- Original Method ----------
            //if (!channel.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //ByteBuffer buf = ByteBuffer.allocate(1);
            //int result = channel.read(buf);
            //return (result == -1) ? result : (buf.get(0) & 0xff);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.716 -0400", hash_original_method = "EA379AE73CA210BAF79C2B35EBD964D5", hash_generated_method = "CA2023704959B344B27D39F2878F14AE")
        @Override
        public int read(byte[] buffer, int offset, int byteCount) throws IOException {
            Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            {
                boolean var31F20A963DD0F8C963A5583943EE8E0D_463389569 = (!channel.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            ByteBuffer buf;
            buf = ByteBuffer.wrap(buffer, offset, byteCount);
            int varF859A589DD061B7EE8856D3FB059BC75_1493863628 = (channel.read(buf));
            addTaint(buffer[0]);
            addTaint(offset);
            addTaint(byteCount);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_810839254 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_810839254;
            // ---------- Original Method ----------
            //Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            //if (!channel.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
            //return channel.read(buf);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.716 -0400", hash_original_field = "F7874D1ECFDF317B7B0B49E529318271", hash_generated_field = "8583EF77B833F6A4B997746A2C9F46A3")

    private static int SOCKET_STATUS_UNINITIALIZED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.716 -0400", hash_original_field = "E7869BFA26651C1A91DF76F29F4AC46C", hash_generated_field = "19F115734FBA8F21EE88E2B73B815DA4")

    private static int SOCKET_STATUS_UNCONNECTED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.719 -0400", hash_original_field = "EDC041CF402AA3C46826C9E2AE49AE9E", hash_generated_field = "D133A7E6AB8B0329425B56B92EE996E0")

    private static int SOCKET_STATUS_PENDING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.719 -0400", hash_original_field = "461AFCE1A5AEC5CF2C2D26AAE231795E", hash_generated_field = "51DABCBDA3E769D67E6CC74381643113")

    private static int SOCKET_STATUS_CONNECTED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.719 -0400", hash_original_field = "7E35E1AB365CC43A545D22B9D85FC951", hash_generated_field = "171DE2D4D08E85BB8B63C8D853635049")

    private static int SOCKET_STATUS_CLOSED = 3;
}

