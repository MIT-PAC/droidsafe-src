package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    /*
     * Shared by this class and DatagramChannelImpl, to do the address transfer
     * and check.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.617 -0500", hash_original_method = "905EF919F5C0AB3AE451CC42233B499A", hash_generated_method = "824D7474750B3E4A3EAD9FB616949EDA")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.529 -0500", hash_original_field = "4C63AAB85BDB737AE8E06BCD67447ACB", hash_generated_field = "C681A88E046FA43323BC16B2855934C2")

    private static final int SOCKET_STATUS_UNINITIALIZED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.531 -0500", hash_original_field = "87E041FCA6D87A911E90449D57D95BC8", hash_generated_field = "528B797B61169045F38323ED5AA4ADC9")

    private static final int SOCKET_STATUS_UNCONNECTED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.534 -0500", hash_original_field = "5C1A9299047985506D52BD3CE8A6C275", hash_generated_field = "7A7EF73F99E82F4A0F05F52DF78136A3")

    private static final int SOCKET_STATUS_PENDING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.536 -0500", hash_original_field = "772B6A69F82A7BFB24A4E2D3DEEB10A6", hash_generated_field = "C2F55AFC3D6E4976A560F2A180895BAB")

    private static final int SOCKET_STATUS_CONNECTED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.539 -0500", hash_original_field = "A981B73CCA47FF0CD751C33F02150CA3", hash_generated_field = "C1A214D8C71AC08214F82C6ABD1A3CFD")

    private static final int SOCKET_STATUS_CLOSED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.541 -0500", hash_original_field = "DC35B29CA7114A0CAB311A30B93CBE5F", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private  FileDescriptor fd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.543 -0500", hash_original_field = "95D393BBB81183F055CBC6185FF145FD", hash_generated_field = "99CA27ADD3E21B5E0B3E73B3D40E63C8")

    private SocketAdapter socket = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.546 -0500", hash_original_field = "6782D8EC356D5CE5C81488F7E6BAFADE", hash_generated_field = "33A55C1E7A49F26B03A955656EFC6766")

    private InetSocketAddress connectAddress = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.549 -0500", hash_original_field = "34544088F51F552C1D73815B7917D076", hash_generated_field = "DBBBD6A1106DBEC2B30B9A1EF113618A")

    private InetAddress localAddress = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.551 -0500", hash_original_field = "B2492D7ECB702A5F09554B8EDF522849", hash_generated_field = "B1420775EE6B172A515A5BC10BFFE633")

    private int localPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.553 -0500", hash_original_field = "4D406B93B4F3A4C72646DB5C8E5DF07C", hash_generated_field = "60CA0FDD070D9706A5FF0681764E3085")

    private int status = SOCKET_STATUS_UNINITIALIZED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.556 -0500", hash_original_field = "F9AB7682F64A4F93F6F4A7A435A5AA53", hash_generated_field = "A5CF5255096CFE4A8B3A025A6EBE0953")

    private volatile boolean isBound = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.559 -0500", hash_original_field = "250488CBE536209C574C50F3A29378C0", hash_generated_field = "E06B9588EA49DFE66B571508521E184B")

    private final Object readLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.562 -0500", hash_original_field = "4280965CC4B75048AF13050687F80AFE", hash_generated_field = "4EB051AF8374C9B2C038ADD375A89D80")

    private final Object writeLock = new Object();

    /*
     * Constructor for creating a connected socket channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.565 -0500", hash_original_method = "CAD27D317D6065C47064EE5BE7F99097", hash_generated_method = "5BD0D43EA9CCF65CE89A0CF458FC066F")
    
public SocketChannelImpl(SelectorProvider selectorProvider) throws IOException {
        this(selectorProvider, true);
    }

    /*
     * Constructor for creating an optionally connected socket channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.567 -0500", hash_original_method = "14271155322FDAFE1124C07CD8798E82", hash_generated_method = "D90EC96AA4E706F0DD5C73FEA7BC1013")
    
public SocketChannelImpl(SelectorProvider selectorProvider, boolean connect) throws IOException {
        super(selectorProvider);
        status = SOCKET_STATUS_UNCONNECTED;
        fd = (connect ? IoBridge.socket(true) : new FileDescriptor());
    }

    /*
     * Getting the internal Socket If we have not the socket, we create a new
     * one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.570 -0500", hash_original_method = "3F3C938694E8E43B39A86772053FE6F3", hash_generated_method = "0E47FA7F91808D54B6ECD725EFB01557")
    
@Override
    synchronized public Socket socket() {
        if (socket == null) {
            try {
                InetAddress addr = null;
                int port = 0;
                if (connectAddress != null) {
                    addr = connectAddress.getAddress();
                    port = connectAddress.getPort();
                }
                socket = new SocketAdapter(new PlainSocketImpl(fd, localPort, addr, port), this);
            } catch (SocketException e) {
                return null;
            }
        }
        return socket;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.573 -0500", hash_original_method = "E73B250252340190221059BC9BBB0CEA", hash_generated_method = "722A35EFE34DDEAD11FB7575F79FCC76")
    
@Override
    synchronized public boolean isConnected() {
        return status == SOCKET_STATUS_CONNECTED;
    }

    /*
     * Status setting used by other class.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.576 -0500", hash_original_method = "18A2FCE579B69612BF9446C66CFB3DF7", hash_generated_method = "983F65E380101960BB4C616A298EE30C")
    
synchronized void setConnected() {
        status = SOCKET_STATUS_CONNECTED;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.578 -0500", hash_original_method = "F9CE278FD490C297CB59C718AF3342C0", hash_generated_method = "F9CE278FD490C297CB59C718AF3342C0")
    
void setBound(boolean flag) {
        isBound = flag;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.580 -0500", hash_original_method = "69EAA9B42272F648401C29FF5A206BD4", hash_generated_method = "D3BD9DBBFED5023AFA7F9B5FA54C5293")
    
@Override
    synchronized public boolean isConnectionPending() {
        return status == SOCKET_STATUS_PENDING;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.584 -0500", hash_original_method = "06D5BE9697FA1F6A3605D3BCB50E04A0", hash_generated_method = "933C1AEF1AF9F7DB8391249F1EF00940")
    
@Override
    public boolean connect(SocketAddress socketAddress) throws IOException {
        // status must be open and unconnected
        checkUnconnected();

        // check the address
        InetSocketAddress inetSocketAddress = validateAddress(socketAddress);
        InetAddress normalAddr = inetSocketAddress.getAddress();
        int port = inetSocketAddress.getPort();

        // When connecting, map ANY address to localhost
        if (normalAddr.isAnyLocalAddress()) {
            normalAddr = InetAddress.getLocalHost();
        }

        boolean finished = false;
        try {
            if (isBlocking()) {
                begin();
            }
            finished = IoBridge.connect(fd, normalAddr, port);
            isBound = finished;
        } catch (IOException e) {
            if (e instanceof ConnectException && !isBlocking()) {
                status = SOCKET_STATUS_PENDING;
            } else {
                if (isOpen()) {
                    close();
                    finished = true;
                }
                throw e;
            }
        } finally {
            if (isBlocking()) {
                end(finished);
            }
        }

        initLocalAddressAndPort();
        connectAddress = inetSocketAddress;
        if (socket != null) {
            socket.socketImpl().initRemoteAddressAndPort(connectAddress.getAddress(),
                    connectAddress.getPort());
        }

        synchronized (this) {
            if (isBlocking()) {
                status = (finished ? SOCKET_STATUS_CONNECTED : SOCKET_STATUS_UNCONNECTED);
            } else {
                status = SOCKET_STATUS_PENDING;
            }
        }
        return finished;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.586 -0500", hash_original_method = "06F6825183E6F900AF6E00DC91481B34", hash_generated_method = "8B108F69CF01D12BB7350E96E777584C")
    
private void initLocalAddressAndPort() {
        SocketAddress sa;
        try {
            sa = Libcore.os.getsockname(fd);
        } catch (ErrnoException errnoException) {
            throw new AssertionError(errnoException);
        }
        InetSocketAddress isa = (InetSocketAddress) sa;
        localAddress = isa.getAddress();
        localPort = isa.getPort();
        if (socket != null) {
            socket.socketImpl().initLocalPort(localPort);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.589 -0500", hash_original_method = "240D4967AAA5DC479C6C557DB665D6D5", hash_generated_method = "ABF5955765183FD6F1F24C385B5969A2")
    
@Override
    public boolean finishConnect() throws IOException {
        synchronized (this) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            if (status == SOCKET_STATUS_CONNECTED) {
                return true;
            }
            if (status != SOCKET_STATUS_PENDING) {
                throw new NoConnectionPendingException();
            }
        }

        boolean finished = false;
        try {
            begin();
            InetAddress inetAddress = connectAddress.getAddress();
            int port = connectAddress.getPort();
            finished = IoBridge.isConnected(fd, inetAddress, port, 0, 0); // Return immediately.
            isBound = finished;
        } catch (ConnectException e) {
            if (isOpen()) {
                close();
                finished = true;
            }
            throw e;
        } finally {
            end(finished);
        }

        synchronized (this) {
            status = (finished ? SOCKET_STATUS_CONNECTED : status);
            isBound = finished;
        }
        return finished;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.592 -0500", hash_original_method = "1E64AA428CB659E98A86DB6C8DA80F4E", hash_generated_method = "1E64AA428CB659E98A86DB6C8DA80F4E")
    
void finishAccept() {
        initLocalAddressAndPort();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.594 -0500", hash_original_method = "FDE0A0D9A12F7110643554CD43F8D7B6", hash_generated_method = "29907415F13C00476026BBE5FF1B04D5")
    
@Override
    public int read(ByteBuffer dst) throws IOException {
        dst.checkWritable();
        checkOpenConnected();
        if (!dst.hasRemaining()) {
            return 0;
        }
        return readImpl(dst);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.597 -0500", hash_original_method = "CFA00AB281069164ECAB790C179DF3F9", hash_generated_method = "FE3857A82DD1EA3A1C4BEAA5C06E7F35")
    
@Override
    public long read(ByteBuffer[] targets, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(targets.length, offset, length);
        checkOpenConnected();
        int totalCount = FileChannelImpl.calculateTotalRemaining(targets, offset, length, true);
        if (totalCount == 0) {
            return 0;
        }
        byte[] readArray = new byte[totalCount];
        ByteBuffer readBuffer = ByteBuffer.wrap(readArray);
        int readCount;
        // read data to readBuffer, and then transfer data from readBuffer to targets.
        readCount = readImpl(readBuffer);
        readBuffer.flip();
        if (readCount > 0) {
            int left = readCount;
            int index = offset;
            // transfer data from readArray to targets
            while (left > 0) {
                int putLength = Math.min(targets[index].remaining(), left);
                targets[index].put(readArray, readCount - left, putLength);
                index++;
                left -= putLength;
            }
        }
        return readCount;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.601 -0500", hash_original_method = "59936954910C41239CB7D8967AB1C758", hash_generated_method = "76CD8F86262BEB523E42294916F125BF")
    
private int readImpl(ByteBuffer dst) throws IOException {
        synchronized (readLock) {
            int readCount = 0;
            try {
                if (isBlocking()) {
                    begin();
                }
                readCount = IoBridge.recvfrom(true, fd, dst, 0, null, false);
                if (readCount > 0) {
                    dst.position(dst.position() + readCount);
                }
            } finally {
                if (isBlocking()) {
                    end(readCount > 0);
                }
            }
            return readCount;
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.604 -0500", hash_original_method = "DCFA2CB99033209FD40A6F8FA617CF19", hash_generated_method = "BDCC9FD4CADB5B4F70B9ADBCC529354B")
    
@Override
    public int write(ByteBuffer src) throws IOException {
        if (src == null) {
            throw new NullPointerException();
        }
        checkOpenConnected();
        if (!src.hasRemaining()) {
            return 0;
        }
        return writeImpl(src);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.607 -0500", hash_original_method = "92D26B18BB75EB8AD284E7DC348B13D6", hash_generated_method = "857E6DC60E4C264C3B91D4A7844C4B63")
    
@Override
    public long write(ByteBuffer[] sources, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(sources.length, offset, length);
        checkOpenConnected();
        int count = FileChannelImpl.calculateTotalRemaining(sources, offset, length, false);
        if (count == 0) {
            return 0;
        }
        ByteBuffer writeBuf = ByteBuffer.allocate(count);
        for (int val = offset; val < length + offset; val++) {
            ByteBuffer source = sources[val];
            int oldPosition = source.position();
            writeBuf.put(source);
            source.position(oldPosition);
        }
        writeBuf.flip();
        int result = writeImpl(writeBuf);
        int val = offset;
        int written = result;
        while (result > 0) {
            ByteBuffer source = sources[val];
            int gap = Math.min(result, source.remaining());
            source.position(source.position() + gap);
            val++;
            result -= gap;
        }
        return written;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.609 -0500", hash_original_method = "9CA5CC5B2105A1C6A6351FB0E1EC75B2", hash_generated_method = "CD98B944B276E8543790B980B2B26E1E")
    
private int writeImpl(ByteBuffer src) throws IOException {
        synchronized (writeLock) {
            if (!src.hasRemaining()) {
                return 0;
            }
            int writeCount = 0;
            try {
                if (isBlocking()) {
                    begin();
                }
                writeCount = IoBridge.sendto(fd, src, 0, null, 0);
                if (writeCount > 0) {
                    src.position(src.position() + writeCount);
                }
            } finally {
                if (isBlocking()) {
                    end(writeCount >= 0);
                }
            }
            return writeCount;
        }
    }

    /*
     * Status check, open and "connected", when read and write.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.612 -0500", hash_original_method = "39D9BE1DFB590318884AF060F0654BAC", hash_generated_method = "D9F9AEF31613A1962FF1A4414AA3E378")
    
synchronized private void checkOpenConnected() throws ClosedChannelException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
        if (!isConnected()) {
            throw new NotYetConnectedException();
        }
    }
    
    private static class SocketAdapter extends Socket {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.631 -0500", hash_original_field = "6119781C5880D39B55FCA4668D676DC5", hash_generated_field = "BDD8BAEA23E522D57D04980987295CB9")

        private  SocketChannelImpl channel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.634 -0500", hash_original_field = "C92DD3B7F09F6096C227812F0F4031CF", hash_generated_field = "16CEE3972B12A3C5752670B7FF7939A7")

        private  PlainSocketImpl socketImpl;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.637 -0500", hash_original_method = "BE34C7E67ABAE2BC0D8C225897658728", hash_generated_method = "BE34C7E67ABAE2BC0D8C225897658728")
        
SocketAdapter(PlainSocketImpl socketImpl, SocketChannelImpl channel) throws SocketException {
            super(socketImpl);
            this.socketImpl = socketImpl;
            this.channel = channel;
            SocketUtils.setCreated(this);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.640 -0500", hash_original_method = "453300FCAD69AE8F91F62237BE21CFBA", hash_generated_method = "453300FCAD69AE8F91F62237BE21CFBA")
        
PlainSocketImpl socketImpl() {
            return socketImpl;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.643 -0500", hash_original_method = "379CE4067399395F02052517F4DCE995", hash_generated_method = "6A27C1E95BC16D7FF7CBB98FB1BD6E05")
        
@Override
        public SocketChannel getChannel() {
            return channel;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.645 -0500", hash_original_method = "CB881FA34C7D7FBE309BA2B3C38FD9DE", hash_generated_method = "EA4EF6AC1D705E6F008CC30C385634E3")
        
@Override
        public boolean isBound() {
            return channel.isBound;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.648 -0500", hash_original_method = "5CCF8EB454AE33E9E231A2BE45E2629E", hash_generated_method = "6E2404C4A4551201D7B180DBF03EBE40")
        
@Override
        public boolean isConnected() {
            return channel.isConnected();
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.651 -0500", hash_original_method = "B0018340FF02F226576061EFB596D2DE", hash_generated_method = "73ECBDB77D7E6EE5FEEFF702462CB2D8")
        
@Override
        public InetAddress getLocalAddress() {
            try {
                return channel.getLocalAddress();
            } catch (UnknownHostException e) {
                return null;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.653 -0500", hash_original_method = "63A88A8D435088D761BDD7938E4125E4", hash_generated_method = "032FE48625B5E3961EB8CF4DAE8F3242")
        
@Override
        public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
            if (!channel.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
            if (isConnected()) {
                throw new AlreadyConnectedException();
            }
            super.connect(remoteAddr, timeout);
            channel.initLocalAddressAndPort();
            if (super.isConnected()) {
                channel.setConnected();
                channel.isBound = super.isBound();
            }
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.656 -0500", hash_original_method = "B60964A84DDE0034E73C148BED7594EB", hash_generated_method = "56043DB998F837DADD13C1440F901E8D")
        
@Override
        public void bind(SocketAddress localAddr) throws IOException {
            if (channel.isConnected()) {
                throw new AlreadyConnectedException();
            }
            if (SocketChannelImpl.SOCKET_STATUS_PENDING == channel.status) {
                throw new ConnectionPendingException();
            }
            super.bind(localAddr);
            channel.initLocalAddressAndPort();
            channel.isBound = true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.659 -0500", hash_original_method = "D341E1E6C64813CEE43FACEF8CA53A78", hash_generated_method = "EA084D9A303C00C0378E9318DCAF6DAA")
        
@Override
        public void close() throws IOException {
            synchronized (channel) {
                if (channel.isOpen()) {
                    channel.close();
                } else {
                    super.close();
                }
                channel.status = SocketChannelImpl.SOCKET_STATUS_CLOSED;
            }
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.662 -0500", hash_original_method = "33C0B42780F1E273103B5BBAE79F7408", hash_generated_method = "F092860FCBE6F007E971FB6662A9E26E")
        
@Override
        public OutputStream getOutputStream() throws IOException {
            checkOpenAndConnected();
            if (isOutputShutdown()) {
                throw new SocketException("Socket output is shutdown");
            }
            return new SocketChannelOutputStream(channel);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.665 -0500", hash_original_method = "84598A158E9BC4BA9724B2EC04F9ADAB", hash_generated_method = "AA831EBE9B2E8B2D763E53B6D1EC4BC8")
        
@Override
        public InputStream getInputStream() throws IOException {
            checkOpenAndConnected();
            if (isInputShutdown()) {
                throw new SocketException("Socket input is shutdown");
            }
            return new SocketChannelInputStream(channel);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.668 -0500", hash_original_method = "6DFEABBD8C66364625150870CA176E5F", hash_generated_method = "91A50CA4C3E80098659C4128162B3B9D")
        
private void checkOpenAndConnected() throws SocketException {
            if (!channel.isOpen()) {
                throw new SocketException("Socket is closed");
            }
            if (!channel.isConnected()) {
                throw new SocketException("Socket is not connected");
            }
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.670 -0500", hash_original_method = "7907395A2BDEF0093C42980D22D2F1FF", hash_generated_method = "7EBFBEFAFB8F26F143BEF760FDE7A089")
        
@Override
        public FileDescriptor getFileDescriptor$() {
            return socketImpl.getFD$();
        }
        
    }
    
    private static class SocketChannelOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.676 -0500", hash_original_field = "5E901D9543237E36B714C4017BFBBD17", hash_generated_field = "E9077990D7B99E1545AE06215D5C5888")

        private  SocketChannel channel;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.678 -0500", hash_original_method = "EBB61A0ABCF2B47C9E2AA3F506A7D0F7", hash_generated_method = "96DAFF0561DF3B923165D10956794AC3")
        
public SocketChannelOutputStream(SocketChannel channel) {
            this.channel = channel;
        }

        /*
         * Closes this stream and channel.
         *
         * @exception IOException thrown if an error occurs during the close
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.682 -0500", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "08D78DA6E3C6A3468EB78586E2EA15E9")
        
@Override
        public void close() throws IOException {
            channel.close();
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.684 -0500", hash_original_method = "376EE3F97840D4205E91F242BC3F90AA", hash_generated_method = "B7F4008F4C032918D15D490AB4F3EE60")
        
@Override
        public void write(byte[] buffer, int offset, int byteCount) throws IOException {
            Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
            if (!channel.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
            channel.write(buf);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.688 -0500", hash_original_method = "F1C26F791F3FC6DB336B7A388343CAEE", hash_generated_method = "35B19194AC573BBA34EFEC906FAF146D")
        
@Override
        public void write(int oneByte) throws IOException {
            if (!channel.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
            ByteBuffer buffer = ByteBuffer.allocate(1);
            buffer.put(0, (byte) (oneByte & 0xFF));
            channel.write(buffer);
        }
        
    }
    
    private static class SocketChannelInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.693 -0500", hash_original_field = "5E901D9543237E36B714C4017BFBBD17", hash_generated_field = "E9077990D7B99E1545AE06215D5C5888")

        private  SocketChannel channel;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.696 -0500", hash_original_method = "6BC169A329FCC47D43DDDAAFDB17AB6A", hash_generated_method = "D6F532956C0DE6C15E3F975700B662B1")
        
public SocketChannelInputStream(SocketChannel channel) {
            this.channel = channel;
        }

        /*
         * Closes this stream and channel.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.699 -0500", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "08D78DA6E3C6A3468EB78586E2EA15E9")
        
@Override
        public void close() throws IOException {
            channel.close();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.701 -0500", hash_original_method = "9D425CB1AFA4E4568C9C3855468C26CA", hash_generated_method = "C1E725A6D7419E00B7727D54CA88D0EC")
        
@Override
        public int read() throws IOException {
            if (!channel.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
            ByteBuffer buf = ByteBuffer.allocate(1);
            int result = channel.read(buf);
            return (result == -1) ? result : (buf.get(0) & 0xff);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.704 -0500", hash_original_method = "EA379AE73CA210BAF79C2B35EBD964D5", hash_generated_method = "C67342CCA18244073E7D92377E55150E")
        
@Override
        public int read(byte[] buffer, int offset, int byteCount) throws IOException {
            Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
            if (!channel.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
            ByteBuffer buf = ByteBuffer.wrap(buffer, offset, byteCount);
            return channel.read(buf);
        }
        
    }

    /*
     * Status check, open and "unconnected", before connection.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.615 -0500", hash_original_method = "ACDFE21557429638E6BE7769521129CC", hash_generated_method = "4C488BAA938CF13CE92C0A03EC8EA9AF")
    
synchronized private void checkUnconnected() throws IOException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
        if (status == SOCKET_STATUS_CONNECTED) {
            throw new AlreadyConnectedException();
        }
        if (status == SOCKET_STATUS_PENDING) {
            throw new ConnectionPendingException();
        }
    }

    /*
     * Get local address.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.620 -0500", hash_original_method = "C580647FE4D156BB3A20DD6B3069A7D0", hash_generated_method = "73F0C9573BC5C9680B1EEB1DF5D743D4")
    
public InetAddress getLocalAddress() throws UnknownHostException {
        return isBound ? localAddress : Inet4Address.ANY;
    }

    /*
     * Do really closing action here.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.623 -0500", hash_original_method = "51888A8660147B395A4990C2BFAD98BE", hash_generated_method = "0E94F2F10F35BED733439CDE038C3E5C")
    
@Override
    protected synchronized void implCloseSelectableChannel() throws IOException {
        if (status != SOCKET_STATUS_CLOSED) {
            status = SOCKET_STATUS_CLOSED;
            if (socket != null && !socket.isClosed()) {
                socket.close();
            } else {
                IoBridge.closeSocket(fd);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.625 -0500", hash_original_method = "B277EC5F8A308E553B57A0D050976387", hash_generated_method = "AD0E006D8B4C7C0A8BB24009181EE575")
    
@Override protected void implConfigureBlocking(boolean blocking) throws IOException {
        synchronized (blockingLock()) {
            IoUtils.setBlocking(fd, blocking);
        }
    }

    /*
     * Get the fd.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.627 -0500", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "8F9C1BA6B62D105E8F557BE8D56765AF")
    
public FileDescriptor getFD() {
        return fd;
    }
}

