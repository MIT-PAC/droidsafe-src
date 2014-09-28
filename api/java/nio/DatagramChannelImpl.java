package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.DatagramSocketImpl;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PlainDatagramSocketImpl;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.spi.SelectorProvider;
import java.util.Arrays;

import libcore.io.ErrnoException;
import libcore.io.IoBridge;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import libcore.util.EmptyArray;

class DatagramChannelImpl extends DatagramChannel implements FileDescriptorChannel {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.487 -0500", hash_original_field = "DC35B29CA7114A0CAB311A30B93CBE5F", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private  FileDescriptor fd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.489 -0500", hash_original_field = "36C845353777B86202A0431464FC2525", hash_generated_field = "AE66ADE591BF9A05EC0F956D394B783F")

    private DatagramSocket socket = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.492 -0500", hash_original_field = "6782D8EC356D5CE5C81488F7E6BAFADE", hash_generated_field = "6782D8EC356D5CE5C81488F7E6BAFADE")

    InetSocketAddress connectAddress = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.495 -0500", hash_original_field = "B2492D7ECB702A5F09554B8EDF522849", hash_generated_field = "B1420775EE6B172A515A5BC10BFFE633")

    private int localPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.497 -0500", hash_original_field = "B7AA47F0C5F11D3CAE3655ABEE0444C2", hash_generated_field = "B7AA47F0C5F11D3CAE3655ABEE0444C2")

    boolean connected = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.499 -0500", hash_original_field = "F9AB7682F64A4F93F6F4A7A435A5AA53", hash_generated_field = "F9AB7682F64A4F93F6F4A7A435A5AA53")

    boolean isBound = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.502 -0500", hash_original_field = "250488CBE536209C574C50F3A29378C0", hash_generated_field = "E06B9588EA49DFE66B571508521E184B")

    private final Object readLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.504 -0500", hash_original_field = "4280965CC4B75048AF13050687F80AFE", hash_generated_field = "4EB051AF8374C9B2C038ADD375A89D80")

    private final Object writeLock = new Object();

    /*
     * Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.506 -0500", hash_original_method = "672B5AA8860523DE8F538FC55262F72E", hash_generated_method = "7980BC790A3D69AFDAA2F4B12191295C")
    
protected DatagramChannelImpl(SelectorProvider selectorProvider) throws IOException {
        super(selectorProvider);
        fd = IoBridge.socket(false);
    }

    /*
     * for native call
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.509 -0500", hash_original_method = "33AAD00A4AE1DFC2263EB97BD11A58AF", hash_generated_method = "66099EB99642DA92B1A9B8C9C0D93F8A")
    
@SuppressWarnings("unused")
    private DatagramChannelImpl() {
        super(SelectorProvider.provider());
        fd = new FileDescriptor();
        connectAddress = new InetSocketAddress(0);
    }

    /*
     * Getting the internal DatagramSocket If we have not the socket, we create
     * a new one.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.513 -0500", hash_original_method = "CB0BD0AB90ECCAF1B55A641E507A7D41", hash_generated_method = "008FFEF970FAF743C315976DF03926BF")
    
@Override
    synchronized public DatagramSocket socket() {
        if (socket == null) {
            socket = new DatagramSocketAdapter(new PlainDatagramSocketImpl(fd, localPort), this);
        }
        return socket;
    }

    /**
     * Returns the local address to which the socket is bound.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.515 -0500", hash_original_method = "0E5E291FF84E111D5E99E4DCFA7BD180", hash_generated_method = "0E5E291FF84E111D5E99E4DCFA7BD180")
    
InetAddress getLocalAddress() {
        return IoBridge.getSocketLocalAddress(fd);
    }

    /**
     * @see java.nio.channels.DatagramChannel#isConnected()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.517 -0500", hash_original_method = "FA10E9C7778335E6674967F36CF6493F", hash_generated_method = "049663AF55390725F8185342D36AF4CC")
    
@Override
    synchronized public boolean isConnected() {
        return connected;
    }

    /**
     * @see java.nio.channels.DatagramChannel#connect(java.net.SocketAddress)
     */
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.520 -0500", hash_original_method = "AF75F16707868C3AF8C2693CEE337F7E", hash_generated_method = "0FA282A422E6669B4050AF433D888A56")
    
@Override
    synchronized public DatagramChannel connect(SocketAddress address) throws IOException {
        // must open
        checkOpen();
        // status must be un-connected.
        if (connected) {
            throw new IllegalStateException();
        }

        // check the address
        InetSocketAddress inetSocketAddress = SocketChannelImpl.validateAddress(address);
        try {
            begin();
            IoBridge.connect(fd, inetSocketAddress.getAddress(), inetSocketAddress.getPort());
        } catch (ConnectException e) {
            // ConnectException means connect fail, not exception
        } finally {
            end(true);
        }

        // set the connected address.
        connectAddress = inetSocketAddress;
        connected = true;
        isBound = true;
        return this;
    }

    /**
     * @see java.nio.channels.DatagramChannel#disconnect()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.523 -0500", hash_original_method = "EF6170FA9655FF42105E76598600F7D4", hash_generated_method = "668D708FED6E7C79DC4B468EC17FEDCB")
    
@Override
    synchronized public DatagramChannel disconnect() throws IOException {
        if (!isConnected() || !isOpen()) {
            return this;
        }
        connected = false;
        connectAddress = null;
        try {
            Libcore.os.connect(fd, InetAddress.UNSPECIFIED, 0);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
        if (socket != null) {
            socket.disconnect();
        }
        return this;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.526 -0500", hash_original_method = "0C3D128AF11DA9AEAEB5EC56CF1536D1", hash_generated_method = "47F4384BD26EFFE868A102FCCEBAEDC2")
    
@Override
    public SocketAddress receive(ByteBuffer target) throws IOException {
        target.checkWritable();
        checkOpen();

        if (!isBound) {
            return null;
        }

        SocketAddress retAddr = null;
        try {
            begin();

            // receive real data packet, (not peek)
            synchronized (readLock) {
                boolean loop = isBlocking();
                if (!target.isDirect()) {
                    retAddr = receiveImpl(target, loop);
                } else {
                    retAddr = receiveDirectImpl(target, loop);
                }
            }
        } catch (InterruptedIOException e) {
            // this line used in Linux
            return null;
        } finally {
            end(retAddr != null);
        }
        return retAddr;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.529 -0500", hash_original_method = "A505D0369C23E2979AA10DE303251FF7", hash_generated_method = "657A02EFF136ADF3C116DAD39DC506C1")
    
private SocketAddress receiveImpl(ByteBuffer target, boolean loop) throws IOException {
        SocketAddress retAddr = null;
        DatagramPacket receivePacket;
        int oldposition = target.position();
        int received = 0;
        // TODO: disallow mapped buffers and lose this conditional?
        if (target.hasArray()) {
            receivePacket = new DatagramPacket(target.array(), target.position() + target.arrayOffset(), target.remaining());
        } else {
            receivePacket = new DatagramPacket(new byte[target.remaining()], target.remaining());
        }
        do {
            received = IoBridge.recvfrom(false, fd, receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength(), 0, receivePacket, isConnected());
            if (receivePacket != null && receivePacket.getAddress() != null) {
                if (received > 0) {
                    if (target.hasArray()) {
                        target.position(oldposition + received);
                    } else {
                        // copy the data of received packet
                        target.put(receivePacket.getData(), 0, received);
                    }
                }
                retAddr = receivePacket.getSocketAddress();
                break;
            }
        } while (loop);
        return retAddr;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.532 -0500", hash_original_method = "3E37D8F586D5D9C430A73700118F801E", hash_generated_method = "86F09F5C9734AE60DC06F23377566DB7")
    
private SocketAddress receiveDirectImpl(ByteBuffer target, boolean loop) throws IOException {
        SocketAddress retAddr = null;
        DatagramPacket receivePacket = new DatagramPacket(EmptyArray.BYTE, 0);
        int oldposition = target.position();
        int received = 0;
        do {
            received = IoBridge.recvfrom(false, fd, target, 0, receivePacket, isConnected());
            if (receivePacket != null && receivePacket.getAddress() != null) {
                // copy the data of received packet
                if (received > 0) {
                    target.position(oldposition + received);
                }
                retAddr = receivePacket.getSocketAddress();
                break;
            }
        } while (loop);
        return retAddr;
    }

    @DSSpec(DSCat.INTERNET)
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.535 -0500", hash_original_method = "959B6E7D8D0C8B7E48B65559E90B586F", hash_generated_method = "0698714E8739C34F3F49DCE805AB41E7")
    
@Override
    public int send(ByteBuffer source, SocketAddress socketAddress) throws IOException {
        checkNotNull(source);
        checkOpen();

        InetSocketAddress isa = (InetSocketAddress) socketAddress;
        if (isa.getAddress() == null) {
            throw new IOException();
        }

        if (isConnected() && !connectAddress.equals(isa)) {
            throw new IllegalArgumentException();
        }

        synchronized (writeLock) {
            int sendCount = 0;
            try {
                begin();
                int oldPosition = source.position();
                sendCount = IoBridge.sendto(fd, source, 0, isa.getAddress(), isa.getPort());
                if (sendCount > 0) {
                    source.position(oldPosition + sendCount);
                }
            } finally {
                end(sendCount >= 0);
            }
            return sendCount;
        }
    }

    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.538 -0500", hash_original_method = "76528871489F953D405DA27A93276CC2", hash_generated_method = "8944BF1CAF80B301B6D671641BFA6636")
    
@Override
    public int read(ByteBuffer target) throws IOException {
        target.checkWritable();
        checkOpenConnected();

        if (!target.hasRemaining()) {
            return 0;
        }

        int readCount = 0;
        if (target.isDirect() || target.hasArray()) {
            readCount = readImpl(target);
            if (readCount > 0) {
                target.position(target.position() + readCount);
            }

        } else {
            byte[] readArray = new byte[target.remaining()];
            ByteBuffer readBuffer = ByteBuffer.wrap(readArray);
            readCount = readImpl(readBuffer);
            if (readCount > 0) {
                target.put(readArray, 0, readCount);
            }
        }
        return readCount;
    }

    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.541 -0500", hash_original_method = "73BDAA1D4D5FBBB4136E79D8CC3B2003", hash_generated_method = "999D1F138A042E2F5F7BCDD7EBB6FF60")
    
@Override
    public long read(ByteBuffer[] targets, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(targets.length, offset, length);

        // status must be open and connected
        checkOpenConnected();
        int totalCount = FileChannelImpl.calculateTotalRemaining(targets, offset, length, true);
        if (totalCount == 0) {
            return 0;
        }

        // read data to readBuffer, and then transfer data from readBuffer to
        // targets.
        ByteBuffer readBuffer = ByteBuffer.allocate(totalCount);
        int readCount;
        readCount = readImpl(readBuffer);
        int left = readCount;
        int index = offset;
        // transfer data from readBuffer to targets
        byte[] readArray = readBuffer.array();
        while (left > 0) {
            int putLength = Math.min(targets[index].remaining(), left);
            targets[index].put(readArray, readCount - left, putLength);
            index++;
            left -= putLength;
        }
        return readCount;
    }

    /*
     * read from channel, and store the result in the target.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.544 -0500", hash_original_method = "FFB1F44E8E8861E1A9AE8DEADE3707A8", hash_generated_method = "3D9E70BF60CF0C531C7F90F70BE1FF8F")
    
private int readImpl(ByteBuffer dst) throws IOException {
        synchronized (readLock) {
            int readCount = 0;
            try {
                begin();
                readCount = IoBridge.recvfrom(false, fd, dst, 0, null, isConnected());
            } catch (InterruptedIOException e) {
                // InterruptedIOException will be thrown when timeout.
                return 0;
            } finally {
                end(readCount > 0);
            }
            return readCount;
        }
    }

    @DSSpec(DSCat.INTERNET)
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.546 -0500", hash_original_method = "EACC5F2E46984D93B58057650609FEF7", hash_generated_method = "13B34C302794F051EED7C644F69CDFAD")
    
@Override public int write(ByteBuffer src) throws IOException {
        checkNotNull(src);
        checkOpenConnected();
        if (!src.hasRemaining()) {
            return 0;
        }

        int writeCount = writeImpl(src);
        if (writeCount > 0) {
            src.position(src.position() + writeCount);
        }
        return writeCount;
    }

    /**
     * @see java.nio.channels.DatagramChannel#write(java.nio.ByteBuffer[], int,
     *      int)
     */
    @DSSpec(DSCat.INTERNET)
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.549 -0500", hash_original_method = "92D26B18BB75EB8AD284E7DC348B13D6", hash_generated_method = "82ADAABDFF0443F748D9B6B5469FC3A9")
    
@Override
    public long write(ByteBuffer[] sources, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(sources.length, offset, length);

        // status must be open and connected
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.552 -0500", hash_original_method = "C5D18F36066EF5A8A32922161E6847D8", hash_generated_method = "6FEE4BB97CE71F5E7484F481A02EF38B")
    
private int writeImpl(ByteBuffer buf) throws IOException {
        synchronized (writeLock) {
            int result = 0;
            try {
                begin();
                result = IoBridge.sendto(fd, buf, 0, null, 0);
            } finally {
                end(result > 0);
            }
            return result;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.555 -0500", hash_original_method = "CF8B9D693C24D7742692C737C034E989", hash_generated_method = "EC419B5C82E3E8CE4284DD09CED7A3FD")
    
@Override protected synchronized void implCloseSelectableChannel() throws IOException {
        connected = false;
        if (socket != null && !socket.isClosed()) {
            socket.close();
        } else {
            IoBridge.closeSocket(fd);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.557 -0500", hash_original_method = "B277EC5F8A308E553B57A0D050976387", hash_generated_method = "AD0E006D8B4C7C0A8BB24009181EE575")
    
@Override protected void implConfigureBlocking(boolean blocking) throws IOException {
        synchronized (blockingLock()) {
            IoUtils.setBlocking(fd, blocking);
        }
    }

    /*
     * Status check, must be open.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.560 -0500", hash_original_method = "CB491A74BF9C37F6ADAA84B27A2FC899", hash_generated_method = "DD41ADAA14340068E190AE412CC67050")
    
private void checkOpen() throws IOException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
    }

    /*
     * Status check, must be open and connected, for read and write.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.562 -0500", hash_original_method = "C4EAE028A2901AB3F43566E69E9E24D8", hash_generated_method = "DD2BB7F26639B16CB62EC70C8AB97DA0")
    
private void checkOpenConnected() throws IOException {
        checkOpen();
        if (!isConnected()) {
            throw new NotYetConnectedException();
        }
    }

    /*
     * Buffer check, must not null
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.566 -0500", hash_original_method = "DE9BF6E7ACC5E7DCC990C5D950818BC0", hash_generated_method = "8D66BA020328633184DC4F66CA3C2381")
    
private void checkNotNull(ByteBuffer source) {
        if (source == null) {
            throw new NullPointerException();
        }
    }

    /*
     * Get the fd for internal use.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.568 -0500", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "8F9C1BA6B62D105E8F557BE8D56765AF")
    
public FileDescriptor getFD() {
        return fd;
    }
    
    private static class DatagramSocketAdapter extends DatagramSocket {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.571 -0500", hash_original_field = "289ABC182A2A17FC802CD4998E65E8FD", hash_generated_field = "8F599A20342D355936B02DA735AA8136")

        private DatagramChannelImpl channelImpl;

        /*
         * Constructor initialize the datagramSocketImpl and datagramChannelImpl
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.574 -0500", hash_original_method = "69EFCB277ED141BA204F53D83B183F8E", hash_generated_method = "69EFCB277ED141BA204F53D83B183F8E")
        
DatagramSocketAdapter(DatagramSocketImpl socketimpl,
                DatagramChannelImpl channelImpl) {
            super(socketimpl);
            this.channelImpl = channelImpl;
        }

        /*
         * Get the internal datagramChannelImpl
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.576 -0500", hash_original_method = "272F2E718E0C10B582849935E6BE168A", hash_generated_method = "31C0789BB33587652F910DE10BC9BD7A")
        
@Override
        public DatagramChannel getChannel() {
            return channelImpl;
        }

        /**
         * @see java.net.DatagramSocket#isBound()
         */
        @DSSafe(DSCat.NETWORKING)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.579 -0500", hash_original_method = "F11CC1C6B1751A820DF0839300E56C28", hash_generated_method = "C9EA9BB263A8AADCFFEACA24BE2CB395")
        
@Override
        public boolean isBound() {
            return channelImpl.isBound;
        }

        /**
         * @see java.net.DatagramSocket#isConnected()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.581 -0500", hash_original_method = "EBC91F4CCE587021E0B931D77134C0EB", hash_generated_method = "501D7DDCE5360E08CC360DEDEE1569F7")
        
@Override
        public boolean isConnected() {
            return channelImpl.isConnected();
        }

        /**
         * @see java.net.DatagramSocket#getInetAddress()
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.584 -0500", hash_original_method = "F2E78E937EC010AD3CD73E7409B0139F", hash_generated_method = "5A482560394A4E6B937ED0FE76489C8D")
        
@Override
        public InetAddress getInetAddress() {
            if (channelImpl.connectAddress == null) {
                return null;
            }
            return channelImpl.connectAddress.getAddress();
        }

        /**
         * @see java.net.DatagramSocket#getLocalAddress()
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.587 -0500", hash_original_method = "2C69EB670D32F39C986C933D03BF3A1E", hash_generated_method = "AC7E91C09BE523AD83D9353ACFE886DA")
        
@Override
        public InetAddress getLocalAddress() {
            return channelImpl.getLocalAddress();
        }

        /**
         * @see java.net.DatagramSocket#getPort()
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.590 -0500", hash_original_method = "4B98C51C8664AA9BAB8C98CDD2BAB4FB", hash_generated_method = "E9D457126D528101B6F5F871B2C5CC52")
        
@Override
        public int getPort() {
            if (channelImpl.connectAddress == null) {
                return -1;
            }
            return channelImpl.connectAddress.getPort();
        }

        /**
         * @see java.net.DatagramSocket#bind(java.net.SocketAddress)
         */
        @DSSpec(DSCat.IO)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.593 -0500", hash_original_method = "42FCE5AEF7C64B9A4F845E086D487D7D", hash_generated_method = "1BB3552A24D93864591CB46668AC3DCF")
        
@Override
        public void bind(SocketAddress localAddr) throws SocketException {
            if (channelImpl.isConnected()) {
                throw new AlreadyConnectedException();
            }
            super.bind(localAddr);
            channelImpl.isBound = true;
        }

        /**
         * @see java.net.DatagramSocket#receive(java.net.DatagramPacket)
         */
        @DSSource({DSSourceKind.NETWORK})
        @DSSpec(DSCat.IO)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.596 -0500", hash_original_method = "714770E7AF180E6CA35843F3D6FA59F5", hash_generated_method = "A21E62DEBFA510E7041675E3A1A26F43")
        
@Override
        public void receive(DatagramPacket packet) throws IOException {
            if (!channelImpl.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
            super.receive(packet);
        }

        /**
         * @see java.net.DatagramSocket#send(java.net.DatagramPacket)
         */
        @DSSpec(DSCat.IO)
        @DSSink({DSSinkKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.599 -0500", hash_original_method = "B8D9E7A66BAFFB4AAB90A90FE956BDD4", hash_generated_method = "172F7F7608E5B0C383F7277D8B5EDF7A")
        
@Override
        public void send(DatagramPacket packet) throws IOException {
            if (!channelImpl.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
            super.send(packet);
        }

        /**
         * @see java.net.DatagramSocket#close()
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.601 -0500", hash_original_method = "46B266D91BAFA027B87005DE54970890", hash_generated_method = "FFA65F4D6DEFB45734BAA4F560DDF3D7")
        
@Override
        public void close() {
            synchronized (channelImpl) {
                if (channelImpl.isOpen()) {
                    try {
                        channelImpl.close();
                    } catch (IOException e) {
                        // Ignore
                    }
                }
                super.close();
            }
        }

        /**
         * @see java.net.DatagramSocket#disconnect()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.604 -0500", hash_original_method = "CD5228FAD6696C7AA890BA57AAC5031A", hash_generated_method = "C2D1B477429D3D93A784D7BEF148B9DE")
        
@Override
        public void disconnect() {
            try {
                channelImpl.disconnect();
            } catch (IOException e) {
                // Ignore
            }
            super.disconnect();
        }
        
    }
    
}

