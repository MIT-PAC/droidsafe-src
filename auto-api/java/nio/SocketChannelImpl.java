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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.513 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.514 -0400", hash_original_field = "E728D69D332AE7988C6FE7869D66573E", hash_generated_field = "99CA27ADD3E21B5E0B3E73B3D40E63C8")

    private SocketAdapter socket = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.514 -0400", hash_original_field = "01E982E0501B1B10CFBB661526A8D271", hash_generated_field = "33A55C1E7A49F26B03A955656EFC6766")

    private InetSocketAddress connectAddress = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.514 -0400", hash_original_field = "299B8F7D460321B85DDDB1F9B3BD6EC0", hash_generated_field = "DBBBD6A1106DBEC2B30B9A1EF113618A")

    private InetAddress localAddress = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.514 -0400", hash_original_field = "55FC25CF376E1B7BFFBC2D46F357C231", hash_generated_field = "B1420775EE6B172A515A5BC10BFFE633")

    private int localPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.514 -0400", hash_original_field = "FA7C2E9A18B37E6193498C5920F4EBB1", hash_generated_field = "60CA0FDD070D9706A5FF0681764E3085")

    private int status = SOCKET_STATUS_UNINITIALIZED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.514 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "A5CF5255096CFE4A8B3A025A6EBE0953")

    private volatile boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.514 -0400", hash_original_field = "0EBBDB2C6AB02F595FD6B8EE0165CE90", hash_generated_field = "E06B9588EA49DFE66B571508521E184B")

    private final Object readLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.514 -0400", hash_original_field = "5A9206244ED4B85CC1847D97E427123C", hash_generated_field = "4EB051AF8374C9B2C038ADD375A89D80")

    private final Object writeLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.514 -0400", hash_original_method = "CAD27D317D6065C47064EE5BE7F99097", hash_generated_method = "2378AFB80E6B30B428BEA86F4209CAE1")
    public  SocketChannelImpl(SelectorProvider selectorProvider) throws IOException {
        this(selectorProvider, true);
        addTaint(selectorProvider.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.515 -0400", hash_original_method = "14271155322FDAFE1124C07CD8798E82", hash_generated_method = "6960BB1A0E3C9E5603F8C84C78936F80")
    public  SocketChannelImpl(SelectorProvider selectorProvider, boolean connect) throws IOException {
        super(selectorProvider);
        status = SOCKET_STATUS_UNCONNECTED;
        fd = (connect ? IoBridge.socket(true) : new FileDescriptor());
        addTaint(selectorProvider.getTaint());
        // ---------- Original Method ----------
        //status = SOCKET_STATUS_UNCONNECTED;
        //fd = (connect ? IoBridge.socket(true) : new FileDescriptor());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.515 -0400", hash_original_method = "3F3C938694E8E43B39A86772053FE6F3", hash_generated_method = "3FD68AA550B8B6EA4E0C6364FAF5FD3B")
    @Override
    synchronized public Socket socket() {
        Socket varB4EAC82CA7396A68D541C85D26508E83_196692096 = null; //Variable for return #1
        Socket varB4EAC82CA7396A68D541C85D26508E83_1277908122 = null; //Variable for return #2
        {
            try 
            {
                InetAddress addr = null;
                int port = 0;
                {
                    addr = connectAddress.getAddress();
                    port = connectAddress.getPort();
                } //End block
                socket = new SocketAdapter(new PlainSocketImpl(fd, localPort, addr, port), this);
            } //End block
            catch (SocketException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_196692096 = null;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1277908122 = socket;
        Socket varA7E53CE21691AB073D9660D615818899_162673946; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_162673946 = varB4EAC82CA7396A68D541C85D26508E83_196692096;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_162673946 = varB4EAC82CA7396A68D541C85D26508E83_1277908122;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_162673946.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_162673946;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.516 -0400", hash_original_method = "E73B250252340190221059BC9BBB0CEA", hash_generated_method = "4D30B4A67A1031DEA6C5343A8CAF5B99")
    @Override
    synchronized public boolean isConnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1044208606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1044208606;
        // ---------- Original Method ----------
        //return status == SOCKET_STATUS_CONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.516 -0400", hash_original_method = "18A2FCE579B69612BF9446C66CFB3DF7", hash_generated_method = "5D3DA2D559AD2203AFF1C673C3E7CE27")
    synchronized void setConnected() {
        status = SOCKET_STATUS_CONNECTED;
        // ---------- Original Method ----------
        //status = SOCKET_STATUS_CONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.516 -0400", hash_original_method = "F9CE278FD490C297CB59C718AF3342C0", hash_generated_method = "2B429B88376943DA3612015A73DC81DF")
     void setBound(boolean flag) {
        isBound = flag;
        // ---------- Original Method ----------
        //isBound = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.517 -0400", hash_original_method = "69EAA9B42272F648401C29FF5A206BD4", hash_generated_method = "CBE1653029359D940352FFAD578CB3DC")
    @Override
    synchronized public boolean isConnectionPending() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_271274241 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_271274241;
        // ---------- Original Method ----------
        //return status == SOCKET_STATUS_PENDING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.519 -0400", hash_original_method = "06D5BE9697FA1F6A3605D3BCB50E04A0", hash_generated_method = "2A4CAFB3F57E251B425694424FC0C5B4")
    @Override
    public boolean connect(SocketAddress socketAddress) throws IOException {
        checkUnconnected();
        InetSocketAddress inetSocketAddress = validateAddress(socketAddress);
        InetAddress normalAddr = inetSocketAddress.getAddress();
        int port = inetSocketAddress.getPort();
        {
            boolean var9D48DC931E492377A49A99625D8702AF_516122684 = (normalAddr.isAnyLocalAddress());
            {
                normalAddr = InetAddress.getLocalHost();
            } //End block
        } //End collapsed parenthetic
        boolean finished = false;
        try 
        {
            {
                boolean var68B8B1E8730E5750DDC2DBC3D79531D6_1359301847 = (isBlocking());
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
                boolean varA4CEA94BC1DFD4F428C5D705C325D140_499845972 = (e instanceof ConnectException && !isBlocking());
                {
                    status = SOCKET_STATUS_PENDING;
                } //End block
                {
                    {
                        boolean var38DB1B8F084762ACC3DA3FC1E1C706D4_1855656962 = (isOpen());
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
                boolean var68B8B1E8730E5750DDC2DBC3D79531D6_567364990 = (isBlocking());
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
                boolean var68B8B1E8730E5750DDC2DBC3D79531D6_1037394257 = (isBlocking());
                {
                    status = (finished ? SOCKET_STATUS_CONNECTED : SOCKET_STATUS_UNCONNECTED);
                } //End block
                {
                    status = SOCKET_STATUS_PENDING;
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(socketAddress.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_19218462 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_19218462;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.519 -0400", hash_original_method = "06F6825183E6F900AF6E00DC91481B34", hash_generated_method = "9E9444C8E8C622F9938FAD8B7A8B35CF")
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
        InetSocketAddress isa = (InetSocketAddress) sa;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.520 -0400", hash_original_method = "240D4967AAA5DC479C6C557DB665D6D5", hash_generated_method = "28C628F29FB57691C82CD065A775F097")
    @Override
    public boolean finishConnect() throws IOException {
        {
            {
                boolean varC984E2D68DED4A73C5D827F4E91A6961_1078683508 = (!isOpen());
                {
                    if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
                } //End block
            } //End collapsed parenthetic
            {
                if (DroidSafeAndroidRuntime.control) throw new NoConnectionPendingException();
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
            {
                boolean var5A39A3129B438981221C0F68BD29C416_706792300 = (isOpen());
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2118561341 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2118561341;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.521 -0400", hash_original_method = "1E64AA428CB659E98A86DB6C8DA80F4E", hash_generated_method = "B8BF86CF41D77F2D4D8EDCA4E44845DF")
     void finishAccept() {
        initLocalAddressAndPort();
        // ---------- Original Method ----------
        //initLocalAddressAndPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.521 -0400", hash_original_method = "FDE0A0D9A12F7110643554CD43F8D7B6", hash_generated_method = "B38D9B4B40EC9BBE69722F4074803C93")
    @Override
    public int read(ByteBuffer dst) throws IOException {
        dst.checkWritable();
        checkOpenConnected();
        {
            boolean var6F90D44D152DE0B0B5D2B2B04737CEF4_1081990805 = (!dst.hasRemaining());
        } //End collapsed parenthetic
        int varB7CDC98136CC69D5238E9EEE037C76E7_2124614353 = (readImpl(dst));
        addTaint(dst.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1879326541 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1879326541;
        // ---------- Original Method ----------
        //dst.checkWritable();
        //checkOpenConnected();
        //if (!dst.hasRemaining()) {
            //return 0;
        //}
        //return readImpl(dst);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.521 -0400", hash_original_method = "CFA00AB281069164ECAB790C179DF3F9", hash_generated_method = "980BD0E454943A0C72B8778C0DF2D2FC")
    @Override
    public long read(ByteBuffer[] targets, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(targets.length, offset, length);
        checkOpenConnected();
        int totalCount = FileChannelImpl.calculateTotalRemaining(targets, offset, length, true);
        byte[] readArray = new byte[totalCount];
        ByteBuffer readBuffer = ByteBuffer.wrap(readArray);
        int readCount;
        readCount = readImpl(readBuffer);
        readBuffer.flip();
        {
            int left = readCount;
            int index = offset;
            {
                int putLength = Math.min(targets[index].remaining(), left);
                targets[index].put(readArray, readCount - left, putLength);
                left -= putLength;
            } //End block
        } //End block
        addTaint(targets[0].getTaint());
        addTaint(offset);
        addTaint(length);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_181438585 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_181438585;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.522 -0400", hash_original_method = "59936954910C41239CB7D8967AB1C758", hash_generated_method = "4E04C78FBFF66F61A2B81496F261985E")
    private int readImpl(ByteBuffer dst) throws IOException {
        {
            int readCount = 0;
            try 
            {
                {
                    boolean var623CDD0E0F4A60A403D4DD2515E8FCEF_2016115717 = (isBlocking());
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
                    boolean var623CDD0E0F4A60A403D4DD2515E8FCEF_196994542 = (isBlocking());
                    {
                        end(readCount > 0);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(dst.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1301896234 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1301896234;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.522 -0400", hash_original_method = "DCFA2CB99033209FD40A6F8FA617CF19", hash_generated_method = "26FFF6AC583104750650A22C6B8154CC")
    @Override
    public int write(ByteBuffer src) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        checkOpenConnected();
        {
            boolean var78714B40A2AE0B69755CF30C747E39CB_213679812 = (!src.hasRemaining());
        } //End collapsed parenthetic
        int varE3BFAA173F253FF6C667377BE4955DF1_1734106133 = (writeImpl(src));
        addTaint(src.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876562763 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876562763;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.523 -0400", hash_original_method = "92D26B18BB75EB8AD284E7DC348B13D6", hash_generated_method = "CD1133244D45841BBD31D4128883CCC8")
    @Override
    public long write(ByteBuffer[] sources, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(sources.length, offset, length);
        checkOpenConnected();
        int count = FileChannelImpl.calculateTotalRemaining(sources, offset, length, false);
        ByteBuffer writeBuf = ByteBuffer.allocate(count);
        {
            int val = offset;
            {
                ByteBuffer source = sources[val];
                int oldPosition = source.position();
                writeBuf.put(source);
                source.position(oldPosition);
            } //End block
        } //End collapsed parenthetic
        writeBuf.flip();
        int result = writeImpl(writeBuf);
        int val = offset;
        int written = result;
        {
            ByteBuffer source = sources[val];
            int gap = Math.min(result, source.remaining());
            source.position(source.position() + gap);
            result -= gap;
        } //End block
        addTaint(sources[0].getTaint());
        addTaint(offset);
        addTaint(length);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1424236911 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1424236911;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.523 -0400", hash_original_method = "9CA5CC5B2105A1C6A6351FB0E1EC75B2", hash_generated_method = "F6DD1DAF34AC41DA65442906BAD988AD")
    private int writeImpl(ByteBuffer src) throws IOException {
        {
            {
                boolean var1179A331310E0BE82A95CA682488BDB7_2083653775 = (!src.hasRemaining());
            } //End collapsed parenthetic
            int writeCount = 0;
            try 
            {
                {
                    boolean var623CDD0E0F4A60A403D4DD2515E8FCEF_762850263 = (isBlocking());
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
                    boolean var623CDD0E0F4A60A403D4DD2515E8FCEF_635420560 = (isBlocking());
                    {
                        end(writeCount >= 0);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(src.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_490129258 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_490129258;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.524 -0400", hash_original_method = "39D9BE1DFB590318884AF060F0654BAC", hash_generated_method = "F341A5CB84DAB13EF25DE506F9F361D1")
    synchronized private void checkOpenConnected() throws ClosedChannelException {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1088666884 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_839385351 = (!isConnected());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.524 -0400", hash_original_method = "ACDFE21557429638E6BE7769521129CC", hash_generated_method = "73C523677B5368F85E12ABE271745C26")
    synchronized private void checkUnconnected() throws IOException {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_393537390 = (!isOpen());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.525 -0400", hash_original_method = "C580647FE4D156BB3A20DD6B3069A7D0", hash_generated_method = "FFE8D88BA6F896401B2292C489E6A8A4")
    public InetAddress getLocalAddress() throws UnknownHostException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_863733222 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_863733222 = isBound ? localAddress : Inet4Address.ANY;
        varB4EAC82CA7396A68D541C85D26508E83_863733222.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_863733222;
        // ---------- Original Method ----------
        //return isBound ? localAddress : Inet4Address.ANY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.525 -0400", hash_original_method = "51888A8660147B395A4990C2BFAD98BE", hash_generated_method = "2BB8D2041332D543D48E661AD62D446C")
    @Override
    protected synchronized void implCloseSelectableChannel() throws IOException {
        {
            status = SOCKET_STATUS_CLOSED;
            {
                boolean var5F42E5264EA5F3174237C9C15FBBF8AB_124320124 = (socket != null && !socket.isClosed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.525 -0400", hash_original_method = "B277EC5F8A308E553B57A0D050976387", hash_generated_method = "A7E459BAAF99E39132847165F709EC23")
    @Override
    protected void implConfigureBlocking(boolean blocking) throws IOException {
        {
            Object var964C97B960BB46676C47DA572AAFDDC9_924405060 = (blockingLock());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.526 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "B6B2429633F8B2B8FBDE987E0E069814")
    public FileDescriptor getFD() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1242523496 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1242523496 = fd;
        varB4EAC82CA7396A68D541C85D26508E83_1242523496.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1242523496;
        // ---------- Original Method ----------
        //return fd;
    }

    
    private static class SocketAdapter extends Socket {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.526 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "BDD8BAEA23E522D57D04980987295CB9")

        private SocketChannelImpl channel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.526 -0400", hash_original_field = "31BE1E23DE379D748DAA84AEF8C5EA67", hash_generated_field = "16CEE3972B12A3C5752670B7FF7939A7")

        private PlainSocketImpl socketImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.526 -0400", hash_original_method = "BE34C7E67ABAE2BC0D8C225897658728", hash_generated_method = "A3034C3AF47E210F06DDBFBFB0017C2B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.527 -0400", hash_original_method = "453300FCAD69AE8F91F62237BE21CFBA", hash_generated_method = "49942AF280C75E411025ED7A3E67FA73")
         PlainSocketImpl socketImpl() {
            PlainSocketImpl varB4EAC82CA7396A68D541C85D26508E83_560334513 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_560334513 = socketImpl;
            varB4EAC82CA7396A68D541C85D26508E83_560334513.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_560334513;
            // ---------- Original Method ----------
            //return socketImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.527 -0400", hash_original_method = "379CE4067399395F02052517F4DCE995", hash_generated_method = "ACE22AFD9B50FDB8372109622EA772E3")
        @Override
        public SocketChannel getChannel() {
            SocketChannel varB4EAC82CA7396A68D541C85D26508E83_380711637 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_380711637 = channel;
            varB4EAC82CA7396A68D541C85D26508E83_380711637.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_380711637;
            // ---------- Original Method ----------
            //return channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.527 -0400", hash_original_method = "CB881FA34C7D7FBE309BA2B3C38FD9DE", hash_generated_method = "6069C14FD7A4DB5764B949D657E54F3F")
        @Override
        public boolean isBound() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1154305344 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1154305344;
            // ---------- Original Method ----------
            //return channel.isBound;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.527 -0400", hash_original_method = "5CCF8EB454AE33E9E231A2BE45E2629E", hash_generated_method = "13E01C9CB3018B7802FCB843CE45CA29")
        @Override
        public boolean isConnected() {
            boolean var4A0C2A19B307D930C6073296AB3A7245_401430018 = (channel.isConnected());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1224114043 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1224114043;
            // ---------- Original Method ----------
            //return channel.isConnected();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.528 -0400", hash_original_method = "B0018340FF02F226576061EFB596D2DE", hash_generated_method = "A652D0D3BDE7881710D7E9D95AB691CF")
        @Override
        public InetAddress getLocalAddress() {
            InetAddress varB4EAC82CA7396A68D541C85D26508E83_509204668 = null; //Variable for return #1
            InetAddress varB4EAC82CA7396A68D541C85D26508E83_119486376 = null; //Variable for return #2
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_509204668 = channel.getLocalAddress();
            } //End block
            catch (UnknownHostException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_119486376 = null;
            } //End block
            InetAddress varA7E53CE21691AB073D9660D615818899_677150736; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_677150736 = varB4EAC82CA7396A68D541C85D26508E83_509204668;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_677150736 = varB4EAC82CA7396A68D541C85D26508E83_119486376;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_677150736.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_677150736;
            // ---------- Original Method ----------
            //try {
                //return channel.getLocalAddress();
            //} catch (UnknownHostException e) {
                //return null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.529 -0400", hash_original_method = "63A88A8D435088D761BDD7938E4125E4", hash_generated_method = "54F708657002E05C110070A7BD7FE70F")
        @Override
        public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
            {
                boolean var31F20A963DD0F8C963A5583943EE8E0D_186514939 = (!channel.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            {
                boolean varFA36AC43277248F2D2361BC3C99BD36F_2084772648 = (isConnected());
                {
                    if (DroidSafeAndroidRuntime.control) throw new AlreadyConnectedException();
                } //End block
            } //End collapsed parenthetic
            super.connect(remoteAddr, timeout);
            channel.initLocalAddressAndPort();
            {
                boolean varC5A2DA1F71060520F3E811646A5DB87C_1802625221 = (super.isConnected());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.529 -0400", hash_original_method = "B60964A84DDE0034E73C148BED7594EB", hash_generated_method = "1CF4964C223AEACFE01D14D011896C77")
        @Override
        public void bind(SocketAddress localAddr) throws IOException {
            {
                boolean varF862C9231EB37437C458160DDDD0291B_889986743 = (channel.isConnected());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.530 -0400", hash_original_method = "D341E1E6C64813CEE43FACEF8CA53A78", hash_generated_method = "F6EBFB4D21297E743A7634FE934D95D1")
        @Override
        public void close() throws IOException {
            {
                {
                    boolean varE0F055A9C0DCD5EDAA870962779DF7DB_278261878 = (channel.isOpen());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.531 -0400", hash_original_method = "33C0B42780F1E273103B5BBAE79F7408", hash_generated_method = "7E694CC8F87A75F6719608171114DF70")
        @Override
        public OutputStream getOutputStream() throws IOException {
            OutputStream varB4EAC82CA7396A68D541C85D26508E83_1857241488 = null; //Variable for return #1
            checkOpenAndConnected();
            {
                boolean varEC9D653DD89FE0D5830DD498811BBAE2_1968180104 = (isOutputShutdown());
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket output is shutdown");
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1857241488 = new SocketChannelOutputStream(channel);
            varB4EAC82CA7396A68D541C85D26508E83_1857241488.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1857241488;
            // ---------- Original Method ----------
            //checkOpenAndConnected();
            //if (isOutputShutdown()) {
                //throw new SocketException("Socket output is shutdown");
            //}
            //return new SocketChannelOutputStream(channel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.531 -0400", hash_original_method = "84598A158E9BC4BA9724B2EC04F9ADAB", hash_generated_method = "7390B7A98270C1ADAB7A0C48924DC866")
        @Override
        public InputStream getInputStream() throws IOException {
            InputStream varB4EAC82CA7396A68D541C85D26508E83_1694555280 = null; //Variable for return #1
            checkOpenAndConnected();
            {
                boolean var32122513FDCE5AFB04D0B48DEB0414DC_1071172035 = (isInputShutdown());
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket input is shutdown");
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1694555280 = new SocketChannelInputStream(channel);
            varB4EAC82CA7396A68D541C85D26508E83_1694555280.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1694555280;
            // ---------- Original Method ----------
            //checkOpenAndConnected();
            //if (isInputShutdown()) {
                //throw new SocketException("Socket input is shutdown");
            //}
            //return new SocketChannelInputStream(channel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.532 -0400", hash_original_method = "6DFEABBD8C66364625150870CA176E5F", hash_generated_method = "0859DB5AC35D85E08A244A3BFF8B66BF")
        private void checkOpenAndConnected() throws SocketException {
            {
                boolean var87A07A56ACC984631C8D228EFAB4567A_616473670 = (!channel.isOpen());
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
                } //End block
            } //End collapsed parenthetic
            {
                boolean varADD5E1CD7EA6BFC14E28EF47A4C07DD3_1612098966 = (!channel.isConnected());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.532 -0400", hash_original_method = "7907395A2BDEF0093C42980D22D2F1FF", hash_generated_method = "2C872C5A1B9A0F50BB2E4712760DBD75")
        @Override
        public FileDescriptor getFileDescriptor$() {
            FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1121254955 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1121254955 = socketImpl.getFD$();
            varB4EAC82CA7396A68D541C85D26508E83_1121254955.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1121254955;
            // ---------- Original Method ----------
            //return socketImpl.getFD$();
        }

        
    }


    
    private static class SocketChannelOutputStream extends OutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.532 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "E9077990D7B99E1545AE06215D5C5888")

        private SocketChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.533 -0400", hash_original_method = "EBB61A0ABCF2B47C9E2AA3F506A7D0F7", hash_generated_method = "87F5FBA8759F42229F1FFA4E785B5FC9")
        public  SocketChannelOutputStream(SocketChannel channel) {
            this.channel = channel;
            // ---------- Original Method ----------
            //this.channel = channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.533 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "52F7C33AE9AC04D22BBF80B1439C0461")
        @Override
        public void close() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.533 -0400", hash_original_method = "376EE3F97840D4205E91F242BC3F90AA", hash_generated_method = "575EA4C10A2DA3412400D88446B14484")
        @Override
        public void write(byte[] buffer, int offset, int byteCount) throws IOException {
            Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
            {
                boolean var31F20A963DD0F8C963A5583943EE8E0D_432495900 = (!channel.isBlocking());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.534 -0400", hash_original_method = "F1C26F791F3FC6DB336B7A388343CAEE", hash_generated_method = "33CAF2448F2D152CA1C69FB72BD8F9EE")
        @Override
        public void write(int oneByte) throws IOException {
            {
                boolean var31F20A963DD0F8C963A5583943EE8E0D_187139636 = (!channel.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            ByteBuffer buffer = ByteBuffer.allocate(1);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.534 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "E9077990D7B99E1545AE06215D5C5888")

        private SocketChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.534 -0400", hash_original_method = "6BC169A329FCC47D43DDDAAFDB17AB6A", hash_generated_method = "8E092B2B7F6933899BF0ED405D943216")
        public  SocketChannelInputStream(SocketChannel channel) {
            this.channel = channel;
            // ---------- Original Method ----------
            //this.channel = channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.534 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "52F7C33AE9AC04D22BBF80B1439C0461")
        @Override
        public void close() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.535 -0400", hash_original_method = "9D425CB1AFA4E4568C9C3855468C26CA", hash_generated_method = "3B2FD6CC5BBA8D3CA09DFA90D0D8400E")
        @Override
        public int read() throws IOException {
            {
                boolean var31F20A963DD0F8C963A5583943EE8E0D_73973244 = (!channel.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            ByteBuffer buf = ByteBuffer.allocate(1);
            int result = channel.read(buf);
            {
                Object varACA6FF37247651D0824447DCED5A764C_400503576 = ((buf.get(0) & 0xff));
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1929801684 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1929801684;
            // ---------- Original Method ----------
            //if (!channel.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //ByteBuffer buf = ByteBuffer.allocate(1);
            //int result = channel.read(buf);
            //return (result == -1) ? result : (buf.get(0) & 0xff);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.535 -0400", hash_original_method = "EA379AE73CA210BAF79C2B35EBD964D5", hash_generated_method = "85A5C986E833091064A2BFCE7CC785C2")
        @Override
        public int read(byte[] buffer, int offset, int byteCount) throws IOException {
            Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            {
                boolean var31F20A963DD0F8C963A5583943EE8E0D_970892822 = (!channel.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
            int varF859A589DD061B7EE8856D3FB059BC75_1620835987 = (channel.read(buf));
            addTaint(buffer[0]);
            addTaint(offset);
            addTaint(byteCount);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371069710 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371069710;
            // ---------- Original Method ----------
            //Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            //if (!channel.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
            //return channel.read(buf);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.535 -0400", hash_original_field = "F7874D1ECFDF317B7B0B49E529318271", hash_generated_field = "C681A88E046FA43323BC16B2855934C2")

    private static final int SOCKET_STATUS_UNINITIALIZED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.535 -0400", hash_original_field = "E7869BFA26651C1A91DF76F29F4AC46C", hash_generated_field = "528B797B61169045F38323ED5AA4ADC9")

    private static final int SOCKET_STATUS_UNCONNECTED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.535 -0400", hash_original_field = "EDC041CF402AA3C46826C9E2AE49AE9E", hash_generated_field = "7A7EF73F99E82F4A0F05F52DF78136A3")

    private static final int SOCKET_STATUS_PENDING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.535 -0400", hash_original_field = "461AFCE1A5AEC5CF2C2D26AAE231795E", hash_generated_field = "C2F55AFC3D6E4976A560F2A180895BAB")

    private static final int SOCKET_STATUS_CONNECTED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.535 -0400", hash_original_field = "7E35E1AB365CC43A545D22B9D85FC951", hash_generated_field = "C1A214D8C71AC08214F82C6ABD1A3CFD")

    private static final int SOCKET_STATUS_CLOSED = 3;
}

