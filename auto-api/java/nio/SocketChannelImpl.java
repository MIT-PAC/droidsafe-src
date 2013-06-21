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
    private FileDescriptor fd;
    private SocketAdapter socket = null;
    private InetSocketAddress connectAddress = null;
    private InetAddress localAddress = null;
    private int localPort;
    private int status = SOCKET_STATUS_UNINITIALIZED;
    private volatile boolean isBound = false;
    private Object readLock = new Object();
    private Object writeLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.061 -0400", hash_original_method = "CAD27D317D6065C47064EE5BE7F99097", hash_generated_method = "658F5D653EF6F6A5AC73A7DD7C2ECC58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketChannelImpl(SelectorProvider selectorProvider) throws IOException {
        this(selectorProvider, true);
        dsTaint.addTaint(selectorProvider.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.062 -0400", hash_original_method = "14271155322FDAFE1124C07CD8798E82", hash_generated_method = "5F53667A54FFBE6EAE97C70D65C8CABB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketChannelImpl(SelectorProvider selectorProvider, boolean connect) throws IOException {
        super(selectorProvider);
        dsTaint.addTaint(selectorProvider.dsTaint);
        dsTaint.addTaint(connect);
        status = SOCKET_STATUS_UNCONNECTED;
        fd = (connect ? IoBridge.socket(true) : new FileDescriptor());
        // ---------- Original Method ----------
        //status = SOCKET_STATUS_UNCONNECTED;
        //fd = (connect ? IoBridge.socket(true) : new FileDescriptor());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.063 -0400", hash_original_method = "3F3C938694E8E43B39A86772053FE6F3", hash_generated_method = "12811C02AE6AD711D4F84D6E7086CA77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    synchronized public Socket socket() {
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
            { }
        } //End block
        return (Socket)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.064 -0400", hash_original_method = "E73B250252340190221059BC9BBB0CEA", hash_generated_method = "9806CC38C0605300A7F2AFB549DD4360")
    @DSModeled(DSC.SAFE)
    @Override
    synchronized public boolean isConnected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return status == SOCKET_STATUS_CONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.064 -0400", hash_original_method = "18A2FCE579B69612BF9446C66CFB3DF7", hash_generated_method = "5D3DA2D559AD2203AFF1C673C3E7CE27")
    @DSModeled(DSC.SAFE)
    synchronized void setConnected() {
        status = SOCKET_STATUS_CONNECTED;
        // ---------- Original Method ----------
        //status = SOCKET_STATUS_CONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.064 -0400", hash_original_method = "F9CE278FD490C297CB59C718AF3342C0", hash_generated_method = "3D3F3D332BEAF072BF4E0AF3BF1C9BE5")
    @DSModeled(DSC.SAFE)
     void setBound(boolean flag) {
        dsTaint.addTaint(flag);
        // ---------- Original Method ----------
        //isBound = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.065 -0400", hash_original_method = "69EAA9B42272F648401C29FF5A206BD4", hash_generated_method = "D96E2B8E0958BD84C9A42179E427BFAB")
    @DSModeled(DSC.SAFE)
    @Override
    synchronized public boolean isConnectionPending() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return status == SOCKET_STATUS_PENDING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.065 -0400", hash_original_method = "06D5BE9697FA1F6A3605D3BCB50E04A0", hash_generated_method = "146199379B9B4621D462310D69F832EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean connect(SocketAddress socketAddress) throws IOException {
        dsTaint.addTaint(socketAddress.dsTaint);
        checkUnconnected();
        InetSocketAddress inetSocketAddress;
        inetSocketAddress = validateAddress(socketAddress);
        InetAddress normalAddr;
        normalAddr = inetSocketAddress.getAddress();
        int port;
        port = inetSocketAddress.getPort();
        {
            boolean var9D48DC931E492377A49A99625D8702AF_1193149422 = (normalAddr.isAnyLocalAddress());
            {
                normalAddr = InetAddress.getLocalHost();
            } //End block
        } //End collapsed parenthetic
        boolean finished;
        finished = false;
        try 
        {
            {
                boolean var68B8B1E8730E5750DDC2DBC3D79531D6_1800906629 = (isBlocking());
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
                boolean varA4CEA94BC1DFD4F428C5D705C325D140_1371088150 = (e instanceof ConnectException && !isBlocking());
                {
                    status = SOCKET_STATUS_PENDING;
                } //End block
                {
                    {
                        boolean var38DB1B8F084762ACC3DA3FC1E1C706D4_1926325979 = (isOpen());
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
                boolean var68B8B1E8730E5750DDC2DBC3D79531D6_346146902 = (isBlocking());
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
                boolean var68B8B1E8730E5750DDC2DBC3D79531D6_69375538 = (isBlocking());
                {
                    status = (finished ? SOCKET_STATUS_CONNECTED : SOCKET_STATUS_UNCONNECTED);
                } //End block
                {
                    status = SOCKET_STATUS_PENDING;
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.065 -0400", hash_original_method = "06F6825183E6F900AF6E00DC91481B34", hash_generated_method = "BDC9BA56CF471B22CD0B7A1ABE077229")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.066 -0400", hash_original_method = "240D4967AAA5DC479C6C557DB665D6D5", hash_generated_method = "1DB256316EA69ECB8571A7C95DE4CC53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean finishConnect() throws IOException {
        {
            {
                boolean varC984E2D68DED4A73C5D827F4E91A6961_808085379 = (!isOpen());
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
                boolean var5A39A3129B438981221C0F68BD29C416_1391266337 = (isOpen());
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.066 -0400", hash_original_method = "1E64AA428CB659E98A86DB6C8DA80F4E", hash_generated_method = "B8BF86CF41D77F2D4D8EDCA4E44845DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void finishAccept() {
        initLocalAddressAndPort();
        // ---------- Original Method ----------
        //initLocalAddressAndPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.066 -0400", hash_original_method = "FDE0A0D9A12F7110643554CD43F8D7B6", hash_generated_method = "5D6927C77D3CB91994DDBDB6F9E4E9BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(ByteBuffer dst) throws IOException {
        dsTaint.addTaint(dst.dsTaint);
        dst.checkWritable();
        checkOpenConnected();
        {
            boolean var6F90D44D152DE0B0B5D2B2B04737CEF4_958983206 = (!dst.hasRemaining());
        } //End collapsed parenthetic
        int varB7CDC98136CC69D5238E9EEE037C76E7_1857938951 = (readImpl(dst));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //dst.checkWritable();
        //checkOpenConnected();
        //if (!dst.hasRemaining()) {
            //return 0;
        //}
        //return readImpl(dst);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.067 -0400", hash_original_method = "CFA00AB281069164ECAB790C179DF3F9", hash_generated_method = "543138FC1A5BF7D64573AD6B77E4B485")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long read(ByteBuffer[] targets, int offset, int length) throws IOException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(targets[0].dsTaint);
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
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.067 -0400", hash_original_method = "59936954910C41239CB7D8967AB1C758", hash_generated_method = "72EDA77D706FC33FB4B1EDD8994ECC1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int readImpl(ByteBuffer dst) throws IOException {
        dsTaint.addTaint(dst.dsTaint);
        {
            int readCount;
            readCount = 0;
            try 
            {
                {
                    boolean var623CDD0E0F4A60A403D4DD2515E8FCEF_2010224485 = (isBlocking());
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
                    boolean var623CDD0E0F4A60A403D4DD2515E8FCEF_206915228 = (isBlocking());
                    {
                        end(readCount > 0);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.067 -0400", hash_original_method = "DCFA2CB99033209FD40A6F8FA617CF19", hash_generated_method = "54572D084560575B4026E080A7C567B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int write(ByteBuffer src) throws IOException {
        dsTaint.addTaint(src.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        checkOpenConnected();
        {
            boolean var78714B40A2AE0B69755CF30C747E39CB_176037089 = (!src.hasRemaining());
        } //End collapsed parenthetic
        int varE3BFAA173F253FF6C667377BE4955DF1_1191468330 = (writeImpl(src));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.067 -0400", hash_original_method = "92D26B18BB75EB8AD284E7DC348B13D6", hash_generated_method = "C2E20F3FEED71965427FE674534B434D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long write(ByteBuffer[] sources, int offset, int length) throws IOException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(sources[0].dsTaint);
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
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.068 -0400", hash_original_method = "9CA5CC5B2105A1C6A6351FB0E1EC75B2", hash_generated_method = "4B42F5B768FD192F5E507438E8A1BDFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int writeImpl(ByteBuffer src) throws IOException {
        dsTaint.addTaint(src.dsTaint);
        {
            {
                boolean var1179A331310E0BE82A95CA682488BDB7_1746064253 = (!src.hasRemaining());
            } //End collapsed parenthetic
            int writeCount;
            writeCount = 0;
            try 
            {
                {
                    boolean var623CDD0E0F4A60A403D4DD2515E8FCEF_304832110 = (isBlocking());
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
                    boolean var623CDD0E0F4A60A403D4DD2515E8FCEF_106956972 = (isBlocking());
                    {
                        end(writeCount >= 0);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.068 -0400", hash_original_method = "39D9BE1DFB590318884AF060F0654BAC", hash_generated_method = "E45DA1CC8899DAB2B906CD2DC7169FF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized private void checkOpenConnected() throws ClosedChannelException {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1911475846 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_1705130335 = (!isConnected());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.068 -0400", hash_original_method = "ACDFE21557429638E6BE7769521129CC", hash_generated_method = "6EB07D0BEFC269FF5738CEA1A05326B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized private void checkUnconnected() throws IOException {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_697835087 = (!isOpen());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.069 -0400", hash_original_method = "C580647FE4D156BB3A20DD6B3069A7D0", hash_generated_method = "FD72FE04CA8AF9784CBFB64F0103E7AA")
    @DSModeled(DSC.SAFE)
    public InetAddress getLocalAddress() throws UnknownHostException {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return isBound ? localAddress : Inet4Address.ANY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.069 -0400", hash_original_method = "51888A8660147B395A4990C2BFAD98BE", hash_generated_method = "BECB9BD78639B47F31BFD6F8854EA1D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected synchronized void implCloseSelectableChannel() throws IOException {
        {
            status = SOCKET_STATUS_CLOSED;
            {
                boolean var5F42E5264EA5F3174237C9C15FBBF8AB_1545275359 = (socket != null && !socket.isClosed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.069 -0400", hash_original_method = "B277EC5F8A308E553B57A0D050976387", hash_generated_method = "A65B4CB1DF4EB510E278A53A73C527DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void implConfigureBlocking(boolean blocking) throws IOException {
        dsTaint.addTaint(blocking);
        {
            Object var964C97B960BB46676C47DA572AAFDDC9_1574494231 = (blockingLock());
            {
                IoUtils.setBlocking(fd, blocking);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //synchronized (blockingLock()) {
            //IoUtils.setBlocking(fd, blocking);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.069 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "60A88A21D094E8421E3812E611B5557E")
    @DSModeled(DSC.SAFE)
    public FileDescriptor getFD() {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return fd;
    }

    
    private static class SocketAdapter extends Socket {
        private SocketChannelImpl channel;
        private PlainSocketImpl socketImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.069 -0400", hash_original_method = "BE34C7E67ABAE2BC0D8C225897658728", hash_generated_method = "B9ABD2BC2B353837D1D5A9F136E933E0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SocketAdapter(PlainSocketImpl socketImpl, SocketChannelImpl channel) throws SocketException {
            super(socketImpl);
            dsTaint.addTaint(socketImpl.dsTaint);
            dsTaint.addTaint(channel.dsTaint);
            SocketUtils.setCreated(this);
            // ---------- Original Method ----------
            //this.socketImpl = socketImpl;
            //this.channel = channel;
            //SocketUtils.setCreated(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.070 -0400", hash_original_method = "453300FCAD69AE8F91F62237BE21CFBA", hash_generated_method = "C864AC9705CBAB6479072A5259C031EF")
        @DSModeled(DSC.SAFE)
         PlainSocketImpl socketImpl() {
            return (PlainSocketImpl)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return socketImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.070 -0400", hash_original_method = "379CE4067399395F02052517F4DCE995", hash_generated_method = "667E64171FAB6FDFF986181C696CD961")
        @DSModeled(DSC.SAFE)
        @Override
        public SocketChannel getChannel() {
            return (SocketChannel)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.070 -0400", hash_original_method = "CB881FA34C7D7FBE309BA2B3C38FD9DE", hash_generated_method = "330ECF66C42367EADFCB013A75AD42F9")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean isBound() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return channel.isBound;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.070 -0400", hash_original_method = "5CCF8EB454AE33E9E231A2BE45E2629E", hash_generated_method = "3447E54AE89B87247AC73658B99BC266")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isConnected() {
            boolean var4A0C2A19B307D930C6073296AB3A7245_1182135933 = (channel.isConnected());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return channel.isConnected();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.070 -0400", hash_original_method = "B0018340FF02F226576061EFB596D2DE", hash_generated_method = "F3B2DA3FD9F7CC2D1D93E14A6EFEFAD9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public InetAddress getLocalAddress() {
            try 
            {
                InetAddress var0A8D1EFE9EC9D4D8C8787B5D90F54E12_572606233 = (channel.getLocalAddress());
            } //End block
            catch (UnknownHostException e)
            { }
            return (InetAddress)dsTaint.getTaint();
            // ---------- Original Method ----------
            //try {
                //return channel.getLocalAddress();
            //} catch (UnknownHostException e) {
                //return null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.071 -0400", hash_original_method = "63A88A8D435088D761BDD7938E4125E4", hash_generated_method = "DFEB903C777AFDAEF352AEFD8E27F011")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
            dsTaint.addTaint(timeout);
            dsTaint.addTaint(remoteAddr.dsTaint);
            {
                boolean var31F20A963DD0F8C963A5583943EE8E0D_1670170997 = (!channel.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            {
                boolean varFA36AC43277248F2D2361BC3C99BD36F_184977113 = (isConnected());
                {
                    if (DroidSafeAndroidRuntime.control) throw new AlreadyConnectedException();
                } //End block
            } //End collapsed parenthetic
            super.connect(remoteAddr, timeout);
            channel.initLocalAddressAndPort();
            {
                boolean varC5A2DA1F71060520F3E811646A5DB87C_1312334485 = (super.isConnected());
                {
                    channel.setConnected();
                    channel.isBound = super.isBound();
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.071 -0400", hash_original_method = "B60964A84DDE0034E73C148BED7594EB", hash_generated_method = "1A53EBB4A30FAAFFCF704A9075C65283")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void bind(SocketAddress localAddr) throws IOException {
            dsTaint.addTaint(localAddr.dsTaint);
            {
                boolean varF862C9231EB37437C458160DDDD0291B_444574380 = (channel.isConnected());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.071 -0400", hash_original_method = "D341E1E6C64813CEE43FACEF8CA53A78", hash_generated_method = "DBDEA1F3B29BD7C5B58840D9816BD462")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void close() throws IOException {
            {
                {
                    boolean varE0F055A9C0DCD5EDAA870962779DF7DB_1615592440 = (channel.isOpen());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.071 -0400", hash_original_method = "33C0B42780F1E273103B5BBAE79F7408", hash_generated_method = "80EDD1AF07AD09703180D0A1256A1A48")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public OutputStream getOutputStream() throws IOException {
            checkOpenAndConnected();
            {
                boolean varEC9D653DD89FE0D5830DD498811BBAE2_312646697 = (isOutputShutdown());
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket output is shutdown");
                } //End block
            } //End collapsed parenthetic
            OutputStream varD1723BA6B7C3410620686ACA8BD0A85E_647869077 = (new SocketChannelOutputStream(channel));
            return (OutputStream)dsTaint.getTaint();
            // ---------- Original Method ----------
            //checkOpenAndConnected();
            //if (isOutputShutdown()) {
                //throw new SocketException("Socket output is shutdown");
            //}
            //return new SocketChannelOutputStream(channel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.071 -0400", hash_original_method = "84598A158E9BC4BA9724B2EC04F9ADAB", hash_generated_method = "1FDF4C6009C18411B353BB83CCCC9263")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public InputStream getInputStream() throws IOException {
            checkOpenAndConnected();
            {
                boolean var32122513FDCE5AFB04D0B48DEB0414DC_865131687 = (isInputShutdown());
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket input is shutdown");
                } //End block
            } //End collapsed parenthetic
            InputStream varC13DAFC9CD204400B365C04BA4ADE35D_589374898 = (new SocketChannelInputStream(channel));
            return (InputStream)dsTaint.getTaint();
            // ---------- Original Method ----------
            //checkOpenAndConnected();
            //if (isInputShutdown()) {
                //throw new SocketException("Socket input is shutdown");
            //}
            //return new SocketChannelInputStream(channel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.072 -0400", hash_original_method = "6DFEABBD8C66364625150870CA176E5F", hash_generated_method = "AB6260995AD223AB2799CCCCDA891AB5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void checkOpenAndConnected() throws SocketException {
            {
                boolean var87A07A56ACC984631C8D228EFAB4567A_797450592 = (!channel.isOpen());
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
                } //End block
            } //End collapsed parenthetic
            {
                boolean varADD5E1CD7EA6BFC14E28EF47A4C07DD3_216544184 = (!channel.isConnected());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.072 -0400", hash_original_method = "7907395A2BDEF0093C42980D22D2F1FF", hash_generated_method = "FE16F527A8A2672E5699EC03A8E1E5EE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public FileDescriptor getFileDescriptor$() {
            FileDescriptor var54082A4AE3C3C239D2A5F21C5CD163DF_2136193391 = (socketImpl.getFD$());
            return (FileDescriptor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return socketImpl.getFD$();
        }

        
    }


    
    private static class SocketChannelOutputStream extends OutputStream {
        private SocketChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.072 -0400", hash_original_method = "EBB61A0ABCF2B47C9E2AA3F506A7D0F7", hash_generated_method = "2301D581C94488CE89A153B3CB42873C")
        @DSModeled(DSC.SAFE)
        public SocketChannelOutputStream(SocketChannel channel) {
            dsTaint.addTaint(channel.dsTaint);
            // ---------- Original Method ----------
            //this.channel = channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.072 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "52F7C33AE9AC04D22BBF80B1439C0461")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void close() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.072 -0400", hash_original_method = "376EE3F97840D4205E91F242BC3F90AA", hash_generated_method = "2E66F3DC07B19D6ED69B53FB4225691B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void write(byte[] buffer, int offset, int byteCount) throws IOException {
            dsTaint.addTaint(buffer[0]);
            dsTaint.addTaint(byteCount);
            dsTaint.addTaint(offset);
            Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            ByteBuffer buf;
            buf = ByteBuffer.wrap(buffer, offset, byteCount);
            {
                boolean var31F20A963DD0F8C963A5583943EE8E0D_731087528 = (!channel.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            channel.write(buf);
            // ---------- Original Method ----------
            //Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            //ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
            //if (!channel.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //channel.write(buf);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.073 -0400", hash_original_method = "F1C26F791F3FC6DB336B7A388343CAEE", hash_generated_method = "419E032B5AB833123945B99D62D70FB0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void write(int oneByte) throws IOException {
            dsTaint.addTaint(oneByte);
            {
                boolean var31F20A963DD0F8C963A5583943EE8E0D_177389515 = (!channel.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            ByteBuffer buffer;
            buffer = ByteBuffer.allocate(1);
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
        private SocketChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.073 -0400", hash_original_method = "6BC169A329FCC47D43DDDAAFDB17AB6A", hash_generated_method = "C3312CD65029F4BA1ABE17738308D025")
        @DSModeled(DSC.SAFE)
        public SocketChannelInputStream(SocketChannel channel) {
            dsTaint.addTaint(channel.dsTaint);
            // ---------- Original Method ----------
            //this.channel = channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.073 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "52F7C33AE9AC04D22BBF80B1439C0461")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void close() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.073 -0400", hash_original_method = "9D425CB1AFA4E4568C9C3855468C26CA", hash_generated_method = "3A10F060BA186081E647B3FF37895972")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read() throws IOException {
            {
                boolean var31F20A963DD0F8C963A5583943EE8E0D_989744994 = (!channel.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            ByteBuffer buf;
            buf = ByteBuffer.allocate(1);
            int result;
            result = channel.read(buf);
            {
                Object varACA6FF37247651D0824447DCED5A764C_690912174 = ((buf.get(0) & 0xff));
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (!channel.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //ByteBuffer buf = ByteBuffer.allocate(1);
            //int result = channel.read(buf);
            //return (result == -1) ? result : (buf.get(0) & 0xff);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.074 -0400", hash_original_method = "EA379AE73CA210BAF79C2B35EBD964D5", hash_generated_method = "F9277002A18639BA06106EC68D16ED3C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read(byte[] buffer, int offset, int byteCount) throws IOException {
            dsTaint.addTaint(buffer[0]);
            dsTaint.addTaint(byteCount);
            dsTaint.addTaint(offset);
            Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            {
                boolean var31F20A963DD0F8C963A5583943EE8E0D_1686951969 = (!channel.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            ByteBuffer buf;
            buf = ByteBuffer.wrap(buffer, offset, byteCount);
            int varF859A589DD061B7EE8856D3FB059BC75_1612266038 = (channel.read(buf));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            //if (!channel.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
            //return channel.read(buf);
        }

        
    }


    
    private static final int SOCKET_STATUS_UNINITIALIZED = -1;
    private static final int SOCKET_STATUS_UNCONNECTED = 0;
    private static final int SOCKET_STATUS_PENDING = 1;
    private static final int SOCKET_STATUS_CONNECTED = 2;
    private static final int SOCKET_STATUS_CLOSED = 3;
}

