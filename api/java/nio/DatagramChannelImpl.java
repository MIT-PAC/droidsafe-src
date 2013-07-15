package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.136 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.137 -0400", hash_original_field = "E728D69D332AE7988C6FE7869D66573E", hash_generated_field = "AE66ADE591BF9A05EC0F956D394B783F")

    private DatagramSocket socket = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.137 -0400", hash_original_field = "01E982E0501B1B10CFBB661526A8D271", hash_generated_field = "6782D8EC356D5CE5C81488F7E6BAFADE")

    InetSocketAddress connectAddress = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.137 -0400", hash_original_field = "55FC25CF376E1B7BFFBC2D46F357C231", hash_generated_field = "B1420775EE6B172A515A5BC10BFFE633")

    private int localPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.137 -0400", hash_original_field = "0FEAA30127F5BBCD4CDACFBD8D171074", hash_generated_field = "B7AA47F0C5F11D3CAE3655ABEE0444C2")

    boolean connected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.137 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "F9AB7682F64A4F93F6F4A7A435A5AA53")

    boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.137 -0400", hash_original_field = "0EBBDB2C6AB02F595FD6B8EE0165CE90", hash_generated_field = "E06B9588EA49DFE66B571508521E184B")

    private final Object readLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.137 -0400", hash_original_field = "5A9206244ED4B85CC1847D97E427123C", hash_generated_field = "4EB051AF8374C9B2C038ADD375A89D80")

    private final Object writeLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.138 -0400", hash_original_method = "672B5AA8860523DE8F538FC55262F72E", hash_generated_method = "3BC79CCC7C896A9977D326F406CBA729")
    protected  DatagramChannelImpl(SelectorProvider selectorProvider) throws IOException {
        super(selectorProvider);
        addTaint(selectorProvider.getTaint());
        fd = IoBridge.socket(false);
        // ---------- Original Method ----------
        //fd = IoBridge.socket(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.138 -0400", hash_original_method = "33AAD00A4AE1DFC2263EB97BD11A58AF", hash_generated_method = "D50D9F375903B283F8E9E43BD5AB7E04")
    @SuppressWarnings("unused")
    private  DatagramChannelImpl() {
        super(SelectorProvider.provider());
        fd = new FileDescriptor();
        connectAddress = new InetSocketAddress(0);
        // ---------- Original Method ----------
        //fd = new FileDescriptor();
        //connectAddress = new InetSocketAddress(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.139 -0400", hash_original_method = "CB0BD0AB90ECCAF1B55A641E507A7D41", hash_generated_method = "FCC0D0D9C77CF90E56CE4CEE77283BBE")
    @Override
    synchronized public DatagramSocket socket() {
    if(socket == null)        
        {
            socket = new DatagramSocketAdapter(new PlainDatagramSocketImpl(fd, localPort), this);
        } //End block
DatagramSocket varA63412D4E099639C1BBCBDC8D705186B_854749785 =         socket;
        varA63412D4E099639C1BBCBDC8D705186B_854749785.addTaint(taint);
        return varA63412D4E099639C1BBCBDC8D705186B_854749785;
        // ---------- Original Method ----------
        //if (socket == null) {
            //socket = new DatagramSocketAdapter(new PlainDatagramSocketImpl(fd, localPort), this);
        //}
        //return socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.139 -0400", hash_original_method = "0E5E291FF84E111D5E99E4DCFA7BD180", hash_generated_method = "4EFF398477C99F26239586F2F8DE36D9")
     InetAddress getLocalAddress() {
InetAddress var5B04D0CA841642814A75D4CAB88C3763_883549744 =         IoBridge.getSocketLocalAddress(fd);
        var5B04D0CA841642814A75D4CAB88C3763_883549744.addTaint(taint);
        return var5B04D0CA841642814A75D4CAB88C3763_883549744;
        // ---------- Original Method ----------
        //return IoBridge.getSocketLocalAddress(fd);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.139 -0400", hash_original_method = "FA10E9C7778335E6674967F36CF6493F", hash_generated_method = "80078586872090A1328CC80A8B0373F9")
    @Override
    synchronized public boolean isConnected() {
        boolean var06AA6FA8BDC2078E7E1BD903E70C8F6A_456371437 = (connected);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1159349146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1159349146;
        // ---------- Original Method ----------
        //return connected;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.140 -0400", hash_original_method = "AF75F16707868C3AF8C2693CEE337F7E", hash_generated_method = "04592E1406D02F9341DC371731544B1F")
    @Override
    synchronized public DatagramChannel connect(SocketAddress address) throws IOException {
        addTaint(address.getTaint());
        checkOpen();
    if(connected)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_311031795 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_311031795.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_311031795;
        } //End block
        InetSocketAddress inetSocketAddress = SocketChannelImpl.validateAddress(address);
        try 
        {
            begin();
            IoBridge.connect(fd, inetSocketAddress.getAddress(), inetSocketAddress.getPort());
        } //End block
        catch (ConnectException e)
        {
        } //End block
        finally 
        {
            end(true);
        } //End block
        connectAddress = inetSocketAddress;
        connected = true;
        isBound = true;
DatagramChannel var72A74007B2BE62B849F475C7BDA4658B_1429110174 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1429110174.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1429110174;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.145 -0400", hash_original_method = "EF6170FA9655FF42105E76598600F7D4", hash_generated_method = "5B7476B3405936C36658EAC942B640CE")
    @Override
    synchronized public DatagramChannel disconnect() throws IOException {
    if(!isConnected() || !isOpen())        
        {
DatagramChannel var72A74007B2BE62B849F475C7BDA4658B_679498567 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_679498567.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_679498567;
        } //End block
        connected = false;
        connectAddress = null;
        try 
        {
            Libcore.os.connect(fd, InetAddress.UNSPECIFIED, 0);
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_798442666 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_798442666.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_798442666;
        } //End block
    if(socket != null)        
        {
            socket.disconnect();
        } //End block
DatagramChannel var72A74007B2BE62B849F475C7BDA4658B_459341098 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_459341098.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_459341098;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.146 -0400", hash_original_method = "0C3D128AF11DA9AEAEB5EC56CF1536D1", hash_generated_method = "9B29DAE6FA4B0BB4E6FF0A74534F1170")
    @Override
    public SocketAddress receive(ByteBuffer target) throws IOException {
        addTaint(target.getTaint());
        target.checkWritable();
        checkOpen();
    if(!isBound)        
        {
SocketAddress var540C13E9E156B687226421B24F2DF178_78314114 =             null;
            var540C13E9E156B687226421B24F2DF178_78314114.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_78314114;
        } //End block
        SocketAddress retAddr = null;
        try 
        {
            begin();
            synchronized
(readLock)            {
                boolean loop = isBlocking();
    if(!target.isDirect())                
                {
                    retAddr = receiveImpl(target, loop);
                } //End block
                else
                {
                    retAddr = receiveDirectImpl(target, loop);
                } //End block
            } //End block
        } //End block
        catch (InterruptedIOException e)
        {
SocketAddress var540C13E9E156B687226421B24F2DF178_1684298666 =             null;
            var540C13E9E156B687226421B24F2DF178_1684298666.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1684298666;
        } //End block
        finally 
        {
            end(retAddr != null);
        } //End block
SocketAddress var9631066F6275EB4A3DD498FCE757150E_990741156 =         retAddr;
        var9631066F6275EB4A3DD498FCE757150E_990741156.addTaint(taint);
        return var9631066F6275EB4A3DD498FCE757150E_990741156;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.148 -0400", hash_original_method = "A505D0369C23E2979AA10DE303251FF7", hash_generated_method = "0233F6DB901F6782ADA39A86A675646A")
    private SocketAddress receiveImpl(ByteBuffer target, boolean loop) throws IOException {
        addTaint(loop);
        addTaint(target.getTaint());
        SocketAddress retAddr = null;
        DatagramPacket receivePacket;
        int oldposition = target.position();
        int received = 0;
    if(target.hasArray())        
        {
            receivePacket = new DatagramPacket(target.array(), target.position() + target.arrayOffset(), target.remaining());
        } //End block
        else
        {
            receivePacket = new DatagramPacket(new byte[target.remaining()], target.remaining());
        } //End block
        do {
            {
                received = IoBridge.recvfrom(false, fd, receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength(), 0, receivePacket, isConnected());
    if(receivePacket != null && receivePacket.getAddress() != null)                
                {
    if(received > 0)                    
                    {
    if(target.hasArray())                        
                        {
                            target.position(oldposition + received);
                        } //End block
                        else
                        {
                            target.put(receivePacket.getData(), 0, received);
                        } //End block
                    } //End block
                    retAddr = receivePacket.getSocketAddress();
                    break;
                } //End block
            } //End block
} while (loop);
SocketAddress var9631066F6275EB4A3DD498FCE757150E_1997387505 =         retAddr;
        var9631066F6275EB4A3DD498FCE757150E_1997387505.addTaint(taint);
        return var9631066F6275EB4A3DD498FCE757150E_1997387505;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.149 -0400", hash_original_method = "3E37D8F586D5D9C430A73700118F801E", hash_generated_method = "4889610697142F53D3062248FBCBAEE1")
    private SocketAddress receiveDirectImpl(ByteBuffer target, boolean loop) throws IOException {
        addTaint(loop);
        addTaint(target.getTaint());
        SocketAddress retAddr = null;
        DatagramPacket receivePacket = new DatagramPacket(EmptyArray.BYTE, 0);
        int oldposition = target.position();
        int received = 0;
        do {
            {
                received = IoBridge.recvfrom(false, fd, target, 0, receivePacket, isConnected());
    if(receivePacket != null && receivePacket.getAddress() != null)                
                {
    if(received > 0)                    
                    {
                        target.position(oldposition + received);
                    } //End block
                    retAddr = receivePacket.getSocketAddress();
                    break;
                } //End block
            } //End block
} while (loop);
SocketAddress var9631066F6275EB4A3DD498FCE757150E_266088923 =         retAddr;
        var9631066F6275EB4A3DD498FCE757150E_266088923.addTaint(taint);
        return var9631066F6275EB4A3DD498FCE757150E_266088923;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.150 -0400", hash_original_method = "959B6E7D8D0C8B7E48B65559E90B586F", hash_generated_method = "B51AC31126D7A301CE9B526309F0E151")
    @Override
    public int send(ByteBuffer source, SocketAddress socketAddress) throws IOException {
        addTaint(socketAddress.getTaint());
        addTaint(source.getTaint());
        checkNotNull(source);
        checkOpen();
        InetSocketAddress isa = (InetSocketAddress) socketAddress;
    if(isa.getAddress() == null)        
        {
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_212407167 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_212407167.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_212407167;
        } //End block
    if(isConnected() && !connectAddress.equals(isa))        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_23414879 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_23414879.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_23414879;
        } //End block
        synchronized
(writeLock)        {
            int sendCount = 0;
            try 
            {
                begin();
                int oldPosition = source.position();
                sendCount = IoBridge.sendto(fd, source, 0, isa.getAddress(), isa.getPort());
    if(sendCount > 0)                
                {
                    source.position(oldPosition + sendCount);
                } //End block
            } //End block
            finally 
            {
                end(sendCount >= 0);
            } //End block
            int var3876D4D9CD9031311D3588F5FFDB6007_923493352 = (sendCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852360064 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852360064;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.151 -0400", hash_original_method = "76528871489F953D405DA27A93276CC2", hash_generated_method = "97E11C9BBE8A6386C3968A4057FDD476")
    @Override
    public int read(ByteBuffer target) throws IOException {
        addTaint(target.getTaint());
        target.checkWritable();
        checkOpenConnected();
    if(!target.hasRemaining())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_308112386 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869890976 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869890976;
        } //End block
        int readCount = 0;
    if(target.isDirect() || target.hasArray())        
        {
            readCount = readImpl(target);
    if(readCount > 0)            
            {
                target.position(target.position() + readCount);
            } //End block
        } //End block
        else
        {
            byte[] readArray = new byte[target.remaining()];
            ByteBuffer readBuffer = ByteBuffer.wrap(readArray);
            readCount = readImpl(readBuffer);
    if(readCount > 0)            
            {
                target.put(readArray, 0, readCount);
            } //End block
        } //End block
        int varADC9E8D761A52E26BEC5404508AFC000_2034679817 = (readCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2064157459 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2064157459;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.152 -0400", hash_original_method = "73BDAA1D4D5FBBB4136E79D8CC3B2003", hash_generated_method = "B56EDE1A7C6E82CCEC231D4A9A044940")
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
            long varCFCD208495D565EF66E7DFF9F98764DA_187785133 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1951107493 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1951107493;
        } //End block
        ByteBuffer readBuffer = ByteBuffer.allocate(totalCount);
        int readCount;
        readCount = readImpl(readBuffer);
        int left = readCount;
        int index = offset;
        byte[] readArray = readBuffer.array();
        while
(left > 0)        
        {
            int putLength = Math.min(targets[index].remaining(), left);
            targets[index].put(readArray, readCount - left, putLength);
            index++;
            left -= putLength;
        } //End block
        long varADC9E8D761A52E26BEC5404508AFC000_607608098 = (readCount);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1709575691 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1709575691;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.153 -0400", hash_original_method = "FFB1F44E8E8861E1A9AE8DEADE3707A8", hash_generated_method = "9E1EE8BCFC9E0D28CF8016EA5C9295ED")
    private int readImpl(ByteBuffer dst) throws IOException {
        addTaint(dst.getTaint());
        synchronized
(readLock)        {
            int readCount = 0;
            try 
            {
                begin();
                readCount = IoBridge.recvfrom(false, fd, dst, 0, null, isConnected());
            } //End block
            catch (InterruptedIOException e)
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1777409609 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244427943 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244427943;
            } //End block
            finally 
            {
                end(readCount > 0);
            } //End block
            int varADC9E8D761A52E26BEC5404508AFC000_1276068883 = (readCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_555327956 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_555327956;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.153 -0400", hash_original_method = "EACC5F2E46984D93B58057650609FEF7", hash_generated_method = "32AA7FFCAFA2263B9CA2E22E313A90E0")
    @Override
    public int write(ByteBuffer src) throws IOException {
        addTaint(src.getTaint());
        checkNotNull(src);
        checkOpenConnected();
    if(!src.hasRemaining())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1356055004 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138884557 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138884557;
        } //End block
        int writeCount = writeImpl(src);
    if(writeCount > 0)        
        {
            src.position(src.position() + writeCount);
        } //End block
        int var44A1965D931137262EA3A9400DCC2A67_1938809012 = (writeCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1805525442 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1805525442;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.154 -0400", hash_original_method = "92D26B18BB75EB8AD284E7DC348B13D6", hash_generated_method = "088F5F1F501C11A45FDE143BCCE5041E")
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
            long varCFCD208495D565EF66E7DFF9F98764DA_1725925475 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1616749870 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1616749870;
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
        long var9CC26FA09CE37BC95AFE01BC718836D1_192537455 = (written);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_806537735 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_806537735;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.155 -0400", hash_original_method = "C5D18F36066EF5A8A32922161E6847D8", hash_generated_method = "CBB20592DD51DB1C2844841787D06495")
    private int writeImpl(ByteBuffer buf) throws IOException {
        addTaint(buf.getTaint());
        synchronized
(writeLock)        {
            int result = 0;
            try 
            {
                begin();
                result = IoBridge.sendto(fd, buf, 0, null, 0);
            } //End block
            finally 
            {
                end(result > 0);
            } //End block
            int varB4A88417B3D0170D754C647C30B7216A_1507102301 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_429561788 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_429561788;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.155 -0400", hash_original_method = "CF8B9D693C24D7742692C737C034E989", hash_generated_method = "AA0F7EAABB67DB5CB4BF2A0F9DE76C1F")
    @Override
    protected synchronized void implCloseSelectableChannel() throws IOException {
        connected = false;
    if(socket != null && !socket.isClosed())        
        {
            socket.close();
        } //End block
        else
        {
            IoBridge.closeSocket(fd);
        } //End block
        // ---------- Original Method ----------
        //connected = false;
        //if (socket != null && !socket.isClosed()) {
            //socket.close();
        //} else {
            //IoBridge.closeSocket(fd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.156 -0400", hash_original_method = "B277EC5F8A308E553B57A0D050976387", hash_generated_method = "8A4048D7B505F1340F0DB31FC91FB3B2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.156 -0400", hash_original_method = "CB491A74BF9C37F6ADAA84B27A2FC899", hash_generated_method = "3F0B961982831786384FFFEB1D2DE533")
    private void checkOpen() throws IOException {
    if(!isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_1100432106 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_1100432106.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_1100432106;
        } //End block
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedChannelException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.156 -0400", hash_original_method = "C4EAE028A2901AB3F43566E69E9E24D8", hash_generated_method = "9F829249A3267A1951D4D8AC90A75E2B")
    private void checkOpenConnected() throws IOException {
        checkOpen();
    if(!isConnected())        
        {
            NotYetConnectedException var74CB2CB661C2A7775D3A554085300C50_1070856909 = new NotYetConnectedException();
            var74CB2CB661C2A7775D3A554085300C50_1070856909.addTaint(taint);
            throw var74CB2CB661C2A7775D3A554085300C50_1070856909;
        } //End block
        // ---------- Original Method ----------
        //checkOpen();
        //if (!isConnected()) {
            //throw new NotYetConnectedException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.157 -0400", hash_original_method = "DE9BF6E7ACC5E7DCC990C5D950818BC0", hash_generated_method = "2A08E72EB9ED7E8572D50FAA7743F237")
    private void checkNotNull(ByteBuffer source) {
        addTaint(source.getTaint());
    if(source == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_971254230 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_971254230.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_971254230;
        } //End block
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.157 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "751431FF78E204A988B8233B01C1D464")
    public FileDescriptor getFD() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_789325818 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_789325818.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_789325818;
        // ---------- Original Method ----------
        //return fd;
    }

    
    private static class DatagramSocketAdapter extends DatagramSocket {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.157 -0400", hash_original_field = "32CC750E4B8FCA138B4D6BCBE118C5DB", hash_generated_field = "8F599A20342D355936B02DA735AA8136")

        private DatagramChannelImpl channelImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.158 -0400", hash_original_method = "69EFCB277ED141BA204F53D83B183F8E", hash_generated_method = "3A598A74C3349DDD40B52394BB3A4E86")
          DatagramSocketAdapter(DatagramSocketImpl socketimpl,
                DatagramChannelImpl channelImpl) {
            super(socketimpl);
            addTaint(socketimpl.getTaint());
            this.channelImpl = channelImpl;
            // ---------- Original Method ----------
            //this.channelImpl = channelImpl;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.158 -0400", hash_original_method = "272F2E718E0C10B582849935E6BE168A", hash_generated_method = "4A1395A6481FF164FE2E396690360C03")
        @Override
        public DatagramChannel getChannel() {
DatagramChannel var11782E095BD1B72C89449FBEBF7A0AC8_607652507 =             channelImpl;
            var11782E095BD1B72C89449FBEBF7A0AC8_607652507.addTaint(taint);
            return var11782E095BD1B72C89449FBEBF7A0AC8_607652507;
            // ---------- Original Method ----------
            //return channelImpl;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.158 -0400", hash_original_method = "F11CC1C6B1751A820DF0839300E56C28", hash_generated_method = "0B4C44851415AE7FDCE8C90B3D8A752A")
        @Override
        public boolean isBound() {
            boolean var4CD2AC3855DA1D125443CED5137DEAA0_905572497 = (channelImpl.isBound);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_273717183 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_273717183;
            // ---------- Original Method ----------
            //return channelImpl.isBound;
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.159 -0400", hash_original_method = "EBC91F4CCE587021E0B931D77134C0EB", hash_generated_method = "31621842E4E3C355E551AF1A5657FD39")
        @Override
        public boolean isConnected() {
            boolean var5927211285318058C1B12CAF9806340C_162894300 = (channelImpl.isConnected());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2089607596 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2089607596;
            // ---------- Original Method ----------
            //return channelImpl.isConnected();
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.159 -0400", hash_original_method = "F2E78E937EC010AD3CD73E7409B0139F", hash_generated_method = "91A95243CB0A629E347845850508595A")
        @Override
        public InetAddress getInetAddress() {
    if(channelImpl.connectAddress == null)            
            {
InetAddress var540C13E9E156B687226421B24F2DF178_924088487 =                 null;
                var540C13E9E156B687226421B24F2DF178_924088487.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_924088487;
            } //End block
InetAddress varA060811330446BAC29319DDCF5678AA0_1101477935 =             channelImpl.connectAddress.getAddress();
            varA060811330446BAC29319DDCF5678AA0_1101477935.addTaint(taint);
            return varA060811330446BAC29319DDCF5678AA0_1101477935;
            // ---------- Original Method ----------
            //if (channelImpl.connectAddress == null) {
                //return null;
            //}
            //return channelImpl.connectAddress.getAddress();
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.159 -0400", hash_original_method = "2C69EB670D32F39C986C933D03BF3A1E", hash_generated_method = "89CE7B52616750150DC38F95CB7210BC")
        @Override
        public InetAddress getLocalAddress() {
InetAddress var1896EE36E5804FF576893458CF24D97A_1337812298 =             channelImpl.getLocalAddress();
            var1896EE36E5804FF576893458CF24D97A_1337812298.addTaint(taint);
            return var1896EE36E5804FF576893458CF24D97A_1337812298;
            // ---------- Original Method ----------
            //return channelImpl.getLocalAddress();
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.160 -0400", hash_original_method = "4B98C51C8664AA9BAB8C98CDD2BAB4FB", hash_generated_method = "92182C26AB81F74A272358D53E4EC37B")
        @Override
        public int getPort() {
    if(channelImpl.connectAddress == null)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1104292169 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_235645320 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_235645320;
            } //End block
            int var0D4AED51050E45051EBE53DE57883C30_1212208607 = (channelImpl.connectAddress.getPort());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742110019 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742110019;
            // ---------- Original Method ----------
            //if (channelImpl.connectAddress == null) {
                //return -1;
            //}
            //return channelImpl.connectAddress.getPort();
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.160 -0400", hash_original_method = "42FCE5AEF7C64B9A4F845E086D487D7D", hash_generated_method = "4651D1EE27B111BF553092E9F24D03A3")
        @Override
        public void bind(SocketAddress localAddr) throws SocketException {
            addTaint(localAddr.getTaint());
    if(channelImpl.isConnected())            
            {
                AlreadyConnectedException var476065E4395D997E6E7AB97A5FAAC77C_862831618 = new AlreadyConnectedException();
                var476065E4395D997E6E7AB97A5FAAC77C_862831618.addTaint(taint);
                throw var476065E4395D997E6E7AB97A5FAAC77C_862831618;
            } //End block
            super.bind(localAddr);
            channelImpl.isBound = true;
            // ---------- Original Method ----------
            //if (channelImpl.isConnected()) {
                //throw new AlreadyConnectedException();
            //}
            //super.bind(localAddr);
            //channelImpl.isBound = true;
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.161 -0400", hash_original_method = "714770E7AF180E6CA35843F3D6FA59F5", hash_generated_method = "96947CA56BAF9B1591535D1D01A261C2")
        @Override
        public void receive(DatagramPacket packet) throws IOException {
            addTaint(packet.getTaint());
    if(!channelImpl.isBlocking())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_135247897 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_135247897.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_135247897;
            } //End block
            super.receive(packet);
            // ---------- Original Method ----------
            //if (!channelImpl.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //super.receive(packet);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.161 -0400", hash_original_method = "B8D9E7A66BAFFB4AAB90A90FE956BDD4", hash_generated_method = "8A9AD1828B3F45CFB4E57F330C2527B6")
        @Override
        public void send(DatagramPacket packet) throws IOException {
            addTaint(packet.getTaint());
    if(!channelImpl.isBlocking())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_970616604 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_970616604.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_970616604;
            } //End block
            super.send(packet);
            // ---------- Original Method ----------
            //if (!channelImpl.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //super.send(packet);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.161 -0400", hash_original_method = "46B266D91BAFA027B87005DE54970890", hash_generated_method = "F9C32124A5A170571870B205BB17F41B")
        @Override
        public void close() {
            synchronized
(channelImpl)            {
    if(channelImpl.isOpen())                
                {
                    try 
                    {
                        channelImpl.close();
                    } //End block
                    catch (IOException e)
                    {
                    } //End block
                } //End block
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

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.162 -0400", hash_original_method = "CD5228FAD6696C7AA890BA57AAC5031A", hash_generated_method = "25A05919B12E6FB0CC8C4655346CB469")
        @Override
        public void disconnect() {
            try 
            {
                channelImpl.disconnect();
            } //End block
            catch (IOException e)
            {
            } //End block
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

