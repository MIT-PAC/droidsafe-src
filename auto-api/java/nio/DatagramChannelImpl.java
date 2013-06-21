package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private FileDescriptor fd;
    private DatagramSocket socket = null;
    InetSocketAddress connectAddress = null;
    private int localPort;
    boolean connected = false;
    boolean isBound = false;
    private Object readLock = new Object();
    private Object writeLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.597 -0400", hash_original_method = "672B5AA8860523DE8F538FC55262F72E", hash_generated_method = "537F1A4AEC55003A8F86FACF623CDE5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected DatagramChannelImpl(SelectorProvider selectorProvider) throws IOException {
        super(selectorProvider);
        dsTaint.addTaint(selectorProvider.dsTaint);
        fd = IoBridge.socket(false);
        // ---------- Original Method ----------
        //fd = IoBridge.socket(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.597 -0400", hash_original_method = "33AAD00A4AE1DFC2263EB97BD11A58AF", hash_generated_method = "D50D9F375903B283F8E9E43BD5AB7E04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unused")
    private DatagramChannelImpl() {
        super(SelectorProvider.provider());
        fd = new FileDescriptor();
        connectAddress = new InetSocketAddress(0);
        // ---------- Original Method ----------
        //fd = new FileDescriptor();
        //connectAddress = new InetSocketAddress(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.598 -0400", hash_original_method = "CB0BD0AB90ECCAF1B55A641E507A7D41", hash_generated_method = "5CBB47BBC145AA8B6B4E9B127A3DBDAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    synchronized public DatagramSocket socket() {
        {
            socket = new DatagramSocketAdapter(new PlainDatagramSocketImpl(fd, localPort), this);
        } //End block
        return (DatagramSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (socket == null) {
            //socket = new DatagramSocketAdapter(new PlainDatagramSocketImpl(fd, localPort), this);
        //}
        //return socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.598 -0400", hash_original_method = "0E5E291FF84E111D5E99E4DCFA7BD180", hash_generated_method = "F695D8ED201F015695FC0EEBA25BBB72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     InetAddress getLocalAddress() {
        InetAddress var540A9FDEE04145BDE375376F63493F5B_1682780553 = (IoBridge.getSocketLocalAddress(fd));
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return IoBridge.getSocketLocalAddress(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.598 -0400", hash_original_method = "FA10E9C7778335E6674967F36CF6493F", hash_generated_method = "9F98B14BD6C79B29727D6327C2B8AA5F")
    @DSModeled(DSC.SAFE)
    @Override
    synchronized public boolean isConnected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return connected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.598 -0400", hash_original_method = "AF75F16707868C3AF8C2693CEE337F7E", hash_generated_method = "010465EADBA6A5DC5A778674053C4E05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    synchronized public DatagramChannel connect(SocketAddress address) throws IOException {
        dsTaint.addTaint(address.dsTaint);
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        InetSocketAddress inetSocketAddress;
        inetSocketAddress = SocketChannelImpl.validateAddress(address);
        try 
        {
            begin();
            IoBridge.connect(fd, inetSocketAddress.getAddress(), inetSocketAddress.getPort());
        } //End block
        catch (ConnectException e)
        { }
        finally 
        {
            end(true);
        } //End block
        connectAddress = inetSocketAddress;
        connected = true;
        isBound = true;
        return (DatagramChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkOpen();
        //if (connected) {
            //throw new IllegalStateException();
        //}
        //InetSocketAddress inetSocketAddress = SocketChannelImpl.validateAddress(address);
        //try {
            //begin();
            //IoBridge.connect(fd, inetSocketAddress.getAddress(), inetSocketAddress.getPort());
        //} catch (ConnectException e) {
        //} finally {
            //end(true);
        //}
        //connectAddress = inetSocketAddress;
        //connected = true;
        //isBound = true;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.599 -0400", hash_original_method = "EF6170FA9655FF42105E76598600F7D4", hash_generated_method = "6CB5FE524D9B0B221FC7C3B09E5A10D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    synchronized public DatagramChannel disconnect() throws IOException {
        {
            boolean var131263B9D168DAF17510420A0B1D4997_70438274 = (!isConnected() || !isOpen());
        } //End collapsed parenthetic
        connected = false;
        connectAddress = null;
        try 
        {
            Libcore.os.connect(fd, InetAddress.UNSPECIFIED, 0);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        {
            socket.disconnect();
        } //End block
        return (DatagramChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isConnected() || !isOpen()) {
            //return this;
        //}
        //connected = false;
        //connectAddress = null;
        //try {
            //Libcore.os.connect(fd, InetAddress.UNSPECIFIED, 0);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
        //if (socket != null) {
            //socket.disconnect();
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.599 -0400", hash_original_method = "0C3D128AF11DA9AEAEB5EC56CF1536D1", hash_generated_method = "81303BED903FFB8D0C4646764C808B04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SocketAddress receive(ByteBuffer target) throws IOException {
        dsTaint.addTaint(target.dsTaint);
        target.checkWritable();
        checkOpen();
        SocketAddress retAddr;
        retAddr = null;
        try 
        {
            begin();
            {
                boolean loop;
                loop = isBlocking();
                {
                    boolean var60B6DA0786479A0C7489B57034E21AB9_1055607971 = (!target.isDirect());
                    {
                        retAddr = receiveImpl(target, loop);
                    } //End block
                    {
                        retAddr = receiveDirectImpl(target, loop);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        catch (InterruptedIOException e)
        { }
        finally 
        {
            end(retAddr != null);
        } //End block
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //target.checkWritable();
        //checkOpen();
        //if (!isBound) {
            //return null;
        //}
        //SocketAddress retAddr = null;
        //try {
            //begin();
            //synchronized (readLock) {
                //boolean loop = isBlocking();
                //if (!target.isDirect()) {
                    //retAddr = receiveImpl(target, loop);
                //} else {
                    //retAddr = receiveDirectImpl(target, loop);
                //}
            //}
        //} catch (InterruptedIOException e) {
            //return null;
        //} finally {
            //end(retAddr != null);
        //}
        //return retAddr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.600 -0400", hash_original_method = "A505D0369C23E2979AA10DE303251FF7", hash_generated_method = "DE0F0EA5CE22FD38C21428A1F4863B07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SocketAddress receiveImpl(ByteBuffer target, boolean loop) throws IOException {
        dsTaint.addTaint(loop);
        dsTaint.addTaint(target.dsTaint);
        SocketAddress retAddr;
        retAddr = null;
        DatagramPacket receivePacket;
        int oldposition;
        oldposition = target.position();
        int received;
        received = 0;
        {
            boolean var60296D7148D7CD6284B1FB4B0E82F5B5_1933311702 = (target.hasArray());
            {
                receivePacket = new DatagramPacket(target.array(), target.position() + target.arrayOffset(), target.remaining());
            } //End block
            {
                receivePacket = new DatagramPacket(new byte[target.remaining()], target.remaining());
            } //End block
        } //End collapsed parenthetic
        {
            received = IoBridge.recvfrom(false, fd, receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength(), 0, receivePacket, isConnected());
            {
                boolean var826C3DC943C932AFF0D97ABCF8BC0FBC_2052811090 = (receivePacket != null && receivePacket.getAddress() != null);
                {
                    {
                        {
                            boolean var395A28C9488D0B3CF5AF8252A428D998_403162140 = (target.hasArray());
                            {
                                target.position(oldposition + received);
                            } //End block
                            {
                                target.put(receivePacket.getData(), 0, received);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    retAddr = receivePacket.getSocketAddress();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.601 -0400", hash_original_method = "3E37D8F586D5D9C430A73700118F801E", hash_generated_method = "42531672F1405130C58E0B6411709A09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SocketAddress receiveDirectImpl(ByteBuffer target, boolean loop) throws IOException {
        dsTaint.addTaint(loop);
        dsTaint.addTaint(target.dsTaint);
        SocketAddress retAddr;
        retAddr = null;
        DatagramPacket receivePacket;
        receivePacket = new DatagramPacket(EmptyArray.BYTE, 0);
        int oldposition;
        oldposition = target.position();
        int received;
        received = 0;
        {
            received = IoBridge.recvfrom(false, fd, target, 0, receivePacket, isConnected());
            {
                boolean var826C3DC943C932AFF0D97ABCF8BC0FBC_1760783331 = (receivePacket != null && receivePacket.getAddress() != null);
                {
                    {
                        target.position(oldposition + received);
                    } //End block
                    retAddr = receivePacket.getSocketAddress();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SocketAddress retAddr = null;
        //DatagramPacket receivePacket = new DatagramPacket(EmptyArray.BYTE, 0);
        //int oldposition = target.position();
        //int received = 0;
        //do {
            //received = IoBridge.recvfrom(false, fd, target, 0, receivePacket, isConnected());
            //if (receivePacket != null && receivePacket.getAddress() != null) {
                //if (received > 0) {
                    //target.position(oldposition + received);
                //}
                //retAddr = receivePacket.getSocketAddress();
                //break;
            //}
        //} while (loop);
        //return retAddr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.602 -0400", hash_original_method = "959B6E7D8D0C8B7E48B65559E90B586F", hash_generated_method = "764EC63AA14AC19757D9D7F64B2C6AD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int send(ByteBuffer source, SocketAddress socketAddress) throws IOException {
        dsTaint.addTaint(socketAddress.dsTaint);
        dsTaint.addTaint(source.dsTaint);
        checkNotNull(source);
        checkOpen();
        InetSocketAddress isa;
        isa = (InetSocketAddress) socketAddress;
        {
            boolean var94908F4406976F47F480E81F35A6256E_424592823 = (isa.getAddress() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varACCEE759C92B66C87294B3FE171A86ED_1218935170 = (isConnected() && !connectAddress.equals(isa));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            int sendCount;
            sendCount = 0;
            try 
            {
                begin();
                int oldPosition;
                oldPosition = source.position();
                sendCount = IoBridge.sendto(fd, source, 0, isa.getAddress(), isa.getPort());
                {
                    source.position(oldPosition + sendCount);
                } //End block
            } //End block
            finally 
            {
                end(sendCount >= 0);
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkNotNull(source);
        //checkOpen();
        //InetSocketAddress isa = (InetSocketAddress) socketAddress;
        //if (isa.getAddress() == null) {
            //throw new IOException();
        //}
        //if (isConnected() && !connectAddress.equals(isa)) {
            //throw new IllegalArgumentException();
        //}
        //synchronized (writeLock) {
            //int sendCount = 0;
            //try {
                //begin();
                //int oldPosition = source.position();
                //sendCount = IoBridge.sendto(fd, source, 0, isa.getAddress(), isa.getPort());
                //if (sendCount > 0) {
                    //source.position(oldPosition + sendCount);
                //}
            //} finally {
                //end(sendCount >= 0);
            //}
            //return sendCount;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.603 -0400", hash_original_method = "76528871489F953D405DA27A93276CC2", hash_generated_method = "5453147F3A3C06973DD43A6BD40EA0DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(ByteBuffer target) throws IOException {
        dsTaint.addTaint(target.dsTaint);
        target.checkWritable();
        checkOpenConnected();
        {
            boolean var20B3BDB73F0932F2A7B4D5F3626BD9B5_1348967525 = (!target.hasRemaining());
        } //End collapsed parenthetic
        int readCount;
        readCount = 0;
        {
            boolean varAD3610F4AB318B3E2F2E2CDF9A9A0813_395291634 = (target.isDirect() || target.hasArray());
            {
                readCount = readImpl(target);
                {
                    target.position(target.position() + readCount);
                } //End block
            } //End block
            {
                byte[] readArray;
                readArray = new byte[target.remaining()];
                ByteBuffer readBuffer;
                readBuffer = ByteBuffer.wrap(readArray);
                readCount = readImpl(readBuffer);
                {
                    target.put(readArray, 0, readCount);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //target.checkWritable();
        //checkOpenConnected();
        //if (!target.hasRemaining()) {
            //return 0;
        //}
        //int readCount = 0;
        //if (target.isDirect() || target.hasArray()) {
            //readCount = readImpl(target);
            //if (readCount > 0) {
                //target.position(target.position() + readCount);
            //}
        //} else {
            //byte[] readArray = new byte[target.remaining()];
            //ByteBuffer readBuffer = ByteBuffer.wrap(readArray);
            //readCount = readImpl(readBuffer);
            //if (readCount > 0) {
                //target.put(readArray, 0, readCount);
            //}
        //}
        //return readCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.604 -0400", hash_original_method = "73BDAA1D4D5FBBB4136E79D8CC3B2003", hash_generated_method = "888A64FF5827B41FFC1B36C77378911B")
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
        ByteBuffer readBuffer;
        readBuffer = ByteBuffer.allocate(totalCount);
        int readCount;
        readCount = readImpl(readBuffer);
        int left;
        left = readCount;
        int index;
        index = offset;
        byte[] readArray;
        readArray = readBuffer.array();
        {
            int putLength;
            putLength = Math.min(targets[index].remaining(), left);
            targets[index].put(readArray, readCount - left, putLength);
            left -= putLength;
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(targets.length, offset, length);
        //checkOpenConnected();
        //int totalCount = FileChannelImpl.calculateTotalRemaining(targets, offset, length, true);
        //if (totalCount == 0) {
            //return 0;
        //}
        //ByteBuffer readBuffer = ByteBuffer.allocate(totalCount);
        //int readCount;
        //readCount = readImpl(readBuffer);
        //int left = readCount;
        //int index = offset;
        //byte[] readArray = readBuffer.array();
        //while (left > 0) {
            //int putLength = Math.min(targets[index].remaining(), left);
            //targets[index].put(readArray, readCount - left, putLength);
            //index++;
            //left -= putLength;
        //}
        //return readCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.604 -0400", hash_original_method = "FFB1F44E8E8861E1A9AE8DEADE3707A8", hash_generated_method = "553EC600B1DC668F4D7310CEE6FF8574")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int readImpl(ByteBuffer dst) throws IOException {
        dsTaint.addTaint(dst.dsTaint);
        {
            int readCount;
            readCount = 0;
            try 
            {
                begin();
                readCount = IoBridge.recvfrom(false, fd, dst, 0, null, isConnected());
            } //End block
            catch (InterruptedIOException e)
            { }
            finally 
            {
                end(readCount > 0);
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (readLock) {
            //int readCount = 0;
            //try {
                //begin();
                //readCount = IoBridge.recvfrom(false, fd, dst, 0, null, isConnected());
            //} catch (InterruptedIOException e) {
                //return 0;
            //} finally {
                //end(readCount > 0);
            //}
            //return readCount;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.604 -0400", hash_original_method = "EACC5F2E46984D93B58057650609FEF7", hash_generated_method = "CE9A31400BCE9C8F73A5E0E4DEFE0862")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int write(ByteBuffer src) throws IOException {
        dsTaint.addTaint(src.dsTaint);
        checkNotNull(src);
        checkOpenConnected();
        {
            boolean var78714B40A2AE0B69755CF30C747E39CB_18165208 = (!src.hasRemaining());
        } //End collapsed parenthetic
        int writeCount;
        writeCount = writeImpl(src);
        {
            src.position(src.position() + writeCount);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkNotNull(src);
        //checkOpenConnected();
        //if (!src.hasRemaining()) {
            //return 0;
        //}
        //int writeCount = writeImpl(src);
        //if (writeCount > 0) {
            //src.position(src.position() + writeCount);
        //}
        //return writeCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.605 -0400", hash_original_method = "92D26B18BB75EB8AD284E7DC348B13D6", hash_generated_method = "C2E20F3FEED71965427FE674534B434D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.605 -0400", hash_original_method = "C5D18F36066EF5A8A32922161E6847D8", hash_generated_method = "BC4CC116EDA2124B9093977DB2D8C0A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int writeImpl(ByteBuffer buf) throws IOException {
        dsTaint.addTaint(buf.dsTaint);
        {
            int result;
            result = 0;
            try 
            {
                begin();
                result = IoBridge.sendto(fd, buf, 0, null, 0);
            } //End block
            finally 
            {
                end(result > 0);
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (writeLock) {
            //int result = 0;
            //try {
                //begin();
                //result = IoBridge.sendto(fd, buf, 0, null, 0);
            //} finally {
                //end(result > 0);
            //}
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.605 -0400", hash_original_method = "CF8B9D693C24D7742692C737C034E989", hash_generated_method = "8FBF5F32EC79193EFFD52174EB005F35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected synchronized void implCloseSelectableChannel() throws IOException {
        connected = false;
        {
            boolean varA09DB173CEF278ADC32C70770C281924_1620630415 = (socket != null && !socket.isClosed());
            {
                socket.close();
            } //End block
            {
                IoBridge.closeSocket(fd);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //connected = false;
        //if (socket != null && !socket.isClosed()) {
            //socket.close();
        //} else {
            //IoBridge.closeSocket(fd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.605 -0400", hash_original_method = "B277EC5F8A308E553B57A0D050976387", hash_generated_method = "95F37115ABBA73C350EB86DD4BF672CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void implConfigureBlocking(boolean blocking) throws IOException {
        dsTaint.addTaint(blocking);
        {
            Object var964C97B960BB46676C47DA572AAFDDC9_589892269 = (blockingLock());
            {
                IoUtils.setBlocking(fd, blocking);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //synchronized (blockingLock()) {
            //IoUtils.setBlocking(fd, blocking);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.606 -0400", hash_original_method = "CB491A74BF9C37F6ADAA84B27A2FC899", hash_generated_method = "122D61FEBECD438855D774FC6F439E56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkOpen() throws IOException {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_178027397 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedChannelException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.606 -0400", hash_original_method = "C4EAE028A2901AB3F43566E69E9E24D8", hash_generated_method = "479FE2212FEF8BEAC613E816FCA5E211")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkOpenConnected() throws IOException {
        checkOpen();
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_1919474317 = (!isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new NotYetConnectedException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //checkOpen();
        //if (!isConnected()) {
            //throw new NotYetConnectedException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.606 -0400", hash_original_method = "DE9BF6E7ACC5E7DCC990C5D950818BC0", hash_generated_method = "EA58114AE9281DF5B8D0297F3A741613")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkNotNull(ByteBuffer source) {
        dsTaint.addTaint(source.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.606 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "60A88A21D094E8421E3812E611B5557E")
    @DSModeled(DSC.SAFE)
    public FileDescriptor getFD() {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return fd;
    }

    
    private static class DatagramSocketAdapter extends DatagramSocket {
        private DatagramChannelImpl channelImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.606 -0400", hash_original_method = "69EFCB277ED141BA204F53D83B183F8E", hash_generated_method = "0EAA6ED193871A652FFB41FB1EBB7F39")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         DatagramSocketAdapter(DatagramSocketImpl socketimpl,
                DatagramChannelImpl channelImpl) {
            super(socketimpl);
            dsTaint.addTaint(channelImpl.dsTaint);
            dsTaint.addTaint(socketimpl.dsTaint);
            // ---------- Original Method ----------
            //this.channelImpl = channelImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.606 -0400", hash_original_method = "272F2E718E0C10B582849935E6BE168A", hash_generated_method = "00ECA43EF9F5E8E5C8B467F656E3D965")
        @DSModeled(DSC.SAFE)
        @Override
        public DatagramChannel getChannel() {
            return (DatagramChannel)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return channelImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.607 -0400", hash_original_method = "F11CC1C6B1751A820DF0839300E56C28", hash_generated_method = "F9604CA7FC2BFEB8A1CAA1ED15A821FF")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean isBound() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return channelImpl.isBound;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.607 -0400", hash_original_method = "EBC91F4CCE587021E0B931D77134C0EB", hash_generated_method = "EBE8A900D1019A89D2496A38ACFA963C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isConnected() {
            boolean var62CA8521E6AF586CA79D70D6CF667F20_1770242905 = (channelImpl.isConnected());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return channelImpl.isConnected();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.607 -0400", hash_original_method = "F2E78E937EC010AD3CD73E7409B0139F", hash_generated_method = "2EAF5896DDA92C310E410D58D7F64194")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public InetAddress getInetAddress() {
            InetAddress var485EC333F23E2193BE2146C4524A6510_1022377750 = (channelImpl.connectAddress.getAddress());
            return (InetAddress)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (channelImpl.connectAddress == null) {
                //return null;
            //}
            //return channelImpl.connectAddress.getAddress();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.607 -0400", hash_original_method = "2C69EB670D32F39C986C933D03BF3A1E", hash_generated_method = "CAB72CBB8F36250A467AF9EA5A48872F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public InetAddress getLocalAddress() {
            InetAddress varB9551517F341AB291F461AA6A44E626D_289174658 = (channelImpl.getLocalAddress());
            return (InetAddress)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return channelImpl.getLocalAddress();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.607 -0400", hash_original_method = "4B98C51C8664AA9BAB8C98CDD2BAB4FB", hash_generated_method = "0AB54193A69C0B1D0116CBF9625A7530")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int getPort() {
            int varC574877425F272779C5F02E9439194EF_1473624171 = (channelImpl.connectAddress.getPort());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (channelImpl.connectAddress == null) {
                //return -1;
            //}
            //return channelImpl.connectAddress.getPort();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.608 -0400", hash_original_method = "42FCE5AEF7C64B9A4F845E086D487D7D", hash_generated_method = "339F0BAC897A638A1C99265E668DACB7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void bind(SocketAddress localAddr) throws SocketException {
            dsTaint.addTaint(localAddr.dsTaint);
            {
                boolean var4B0E49754C523761E0E44E87B0B6089A_1111188246 = (channelImpl.isConnected());
                {
                    if (DroidSafeAndroidRuntime.control) throw new AlreadyConnectedException();
                } //End block
            } //End collapsed parenthetic
            super.bind(localAddr);
            channelImpl.isBound = true;
            // ---------- Original Method ----------
            //if (channelImpl.isConnected()) {
                //throw new AlreadyConnectedException();
            //}
            //super.bind(localAddr);
            //channelImpl.isBound = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.608 -0400", hash_original_method = "714770E7AF180E6CA35843F3D6FA59F5", hash_generated_method = "DC6E1E5E82713298BDEBC93C5D61BB0D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void receive(DatagramPacket packet) throws IOException {
            dsTaint.addTaint(packet.dsTaint);
            {
                boolean varBAE8CEDA21BF2921535BF8B9F4D62736_591481407 = (!channelImpl.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            super.receive(packet);
            // ---------- Original Method ----------
            //if (!channelImpl.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //super.receive(packet);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.608 -0400", hash_original_method = "B8D9E7A66BAFFB4AAB90A90FE956BDD4", hash_generated_method = "47A1602D9DD79C9439A6E244998C2043")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void send(DatagramPacket packet) throws IOException {
            dsTaint.addTaint(packet.dsTaint);
            {
                boolean varBAE8CEDA21BF2921535BF8B9F4D62736_1529026973 = (!channelImpl.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            super.send(packet);
            // ---------- Original Method ----------
            //if (!channelImpl.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //super.send(packet);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.608 -0400", hash_original_method = "46B266D91BAFA027B87005DE54970890", hash_generated_method = "F28BB3121A90C6A5E99C5BF70E8B4F7C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void close() {
            {
                {
                    boolean var732C27B9F7BFDC492915355DF0E33D1C_2105591177 = (channelImpl.isOpen());
                    {
                        try 
                        {
                            channelImpl.close();
                        } //End block
                        catch (IOException e)
                        { }
                    } //End block
                } //End collapsed parenthetic
                super.close();
            } //End block
            // ---------- Original Method ----------
            //synchronized (channelImpl) {
                //if (channelImpl.isOpen()) {
                    //try {
                        //channelImpl.close();
                    //} catch (IOException e) {
                    //}
                //}
                //super.close();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.608 -0400", hash_original_method = "CD5228FAD6696C7AA890BA57AAC5031A", hash_generated_method = "4C622B878174EC52BA204C445BD3024B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void disconnect() {
            try 
            {
                channelImpl.disconnect();
            } //End block
            catch (IOException e)
            { }
            super.disconnect();
            // ---------- Original Method ----------
            //try {
                //channelImpl.disconnect();
            //} catch (IOException e) {
            //}
            //super.disconnect();
        }

        
    }


    
}

