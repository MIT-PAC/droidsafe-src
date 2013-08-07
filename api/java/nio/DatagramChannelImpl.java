package java.nio;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.461 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.461 -0400", hash_original_field = "E728D69D332AE7988C6FE7869D66573E", hash_generated_field = "AE66ADE591BF9A05EC0F956D394B783F")

    private DatagramSocket socket = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.461 -0400", hash_original_field = "01E982E0501B1B10CFBB661526A8D271", hash_generated_field = "6782D8EC356D5CE5C81488F7E6BAFADE")

    InetSocketAddress connectAddress = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.461 -0400", hash_original_field = "55FC25CF376E1B7BFFBC2D46F357C231", hash_generated_field = "B1420775EE6B172A515A5BC10BFFE633")

    private int localPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.461 -0400", hash_original_field = "0FEAA30127F5BBCD4CDACFBD8D171074", hash_generated_field = "B7AA47F0C5F11D3CAE3655ABEE0444C2")

    boolean connected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.461 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "F9AB7682F64A4F93F6F4A7A435A5AA53")

    boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.461 -0400", hash_original_field = "0EBBDB2C6AB02F595FD6B8EE0165CE90", hash_generated_field = "E06B9588EA49DFE66B571508521E184B")

    private final Object readLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.461 -0400", hash_original_field = "5A9206244ED4B85CC1847D97E427123C", hash_generated_field = "4EB051AF8374C9B2C038ADD375A89D80")

    private final Object writeLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.462 -0400", hash_original_method = "672B5AA8860523DE8F538FC55262F72E", hash_generated_method = "3BC79CCC7C896A9977D326F406CBA729")
    protected  DatagramChannelImpl(SelectorProvider selectorProvider) throws IOException {
        super(selectorProvider);
        addTaint(selectorProvider.getTaint());
        fd = IoBridge.socket(false);
        // ---------- Original Method ----------
        //fd = IoBridge.socket(false);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.463 -0400", hash_original_method = "33AAD00A4AE1DFC2263EB97BD11A58AF", hash_generated_method = "D50D9F375903B283F8E9E43BD5AB7E04")
    @SuppressWarnings("unused")
    private  DatagramChannelImpl() {
        super(SelectorProvider.provider());
        fd = new FileDescriptor();
        connectAddress = new InetSocketAddress(0);
        // ---------- Original Method ----------
        //fd = new FileDescriptor();
        //connectAddress = new InetSocketAddress(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.464 -0400", hash_original_method = "CB0BD0AB90ECCAF1B55A641E507A7D41", hash_generated_method = "06C4438E74E6F22019FBC847AF95B8F3")
    @Override
    synchronized public DatagramSocket socket() {
        if(socket == null)        
        {
            socket = new DatagramSocketAdapter(new PlainDatagramSocketImpl(fd, localPort), this);
        } //End block
DatagramSocket varA63412D4E099639C1BBCBDC8D705186B_623816303 =         socket;
        varA63412D4E099639C1BBCBDC8D705186B_623816303.addTaint(taint);
        return varA63412D4E099639C1BBCBDC8D705186B_623816303;
        // ---------- Original Method ----------
        //if (socket == null) {
            //socket = new DatagramSocketAdapter(new PlainDatagramSocketImpl(fd, localPort), this);
        //}
        //return socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.465 -0400", hash_original_method = "0E5E291FF84E111D5E99E4DCFA7BD180", hash_generated_method = "02ED8EBD81F43DFE3A97235DCBE2B585")
     InetAddress getLocalAddress() {
InetAddress var5B04D0CA841642814A75D4CAB88C3763_2084201163 =         IoBridge.getSocketLocalAddress(fd);
        var5B04D0CA841642814A75D4CAB88C3763_2084201163.addTaint(taint);
        return var5B04D0CA841642814A75D4CAB88C3763_2084201163;
        // ---------- Original Method ----------
        //return IoBridge.getSocketLocalAddress(fd);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.465 -0400", hash_original_method = "FA10E9C7778335E6674967F36CF6493F", hash_generated_method = "A3C4006E8BEEEDD663708824AFC791D9")
    @Override
    synchronized public boolean isConnected() {
        boolean var06AA6FA8BDC2078E7E1BD903E70C8F6A_750343520 = (connected);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_93314794 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_93314794;
        // ---------- Original Method ----------
        //return connected;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.467 -0400", hash_original_method = "AF75F16707868C3AF8C2693CEE337F7E", hash_generated_method = "22A0BAF5CE03598BB71A17C606D0DCB7")
    @Override
    synchronized public DatagramChannel connect(SocketAddress address) throws IOException {
        addTaint(address.getTaint());
        checkOpen();
        if(connected)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_111163788 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_111163788.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_111163788;
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
DatagramChannel var72A74007B2BE62B849F475C7BDA4658B_773829352 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_773829352.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_773829352;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.476 -0400", hash_original_method = "EF6170FA9655FF42105E76598600F7D4", hash_generated_method = "D933D0D98D7A6FDF042C3FC82F820F50")
    @Override
    synchronized public DatagramChannel disconnect() throws IOException {
        if(!isConnected() || !isOpen())        
        {
DatagramChannel var72A74007B2BE62B849F475C7BDA4658B_1088038864 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1088038864.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1088038864;
        } //End block
        connected = false;
        connectAddress = null;
        try 
        {
            Libcore.os.connect(fd, InetAddress.UNSPECIFIED, 0);
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_2004601641 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_2004601641.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_2004601641;
        } //End block
        if(socket != null)        
        {
            socket.disconnect();
        } //End block
DatagramChannel var72A74007B2BE62B849F475C7BDA4658B_1803568394 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1803568394.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1803568394;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.477 -0400", hash_original_method = "0C3D128AF11DA9AEAEB5EC56CF1536D1", hash_generated_method = "B7A04909CACE063AEB3CB50FAA9FAAA2")
    @Override
    public SocketAddress receive(ByteBuffer target) throws IOException {
        addTaint(target.getTaint());
        target.checkWritable();
        checkOpen();
        if(!isBound)        
        {
SocketAddress var540C13E9E156B687226421B24F2DF178_111495771 =             null;
            var540C13E9E156B687226421B24F2DF178_111495771.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_111495771;
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
SocketAddress var540C13E9E156B687226421B24F2DF178_1846718435 =             null;
            var540C13E9E156B687226421B24F2DF178_1846718435.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1846718435;
        } //End block
        finally 
        {
            end(retAddr != null);
        } //End block
SocketAddress var9631066F6275EB4A3DD498FCE757150E_1305559721 =         retAddr;
        var9631066F6275EB4A3DD498FCE757150E_1305559721.addTaint(taint);
        return var9631066F6275EB4A3DD498FCE757150E_1305559721;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.479 -0400", hash_original_method = "A505D0369C23E2979AA10DE303251FF7", hash_generated_method = "8DD90A8663311CFC0EE142F47B9E958F")
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
SocketAddress var9631066F6275EB4A3DD498FCE757150E_1274258168 =         retAddr;
        var9631066F6275EB4A3DD498FCE757150E_1274258168.addTaint(taint);
        return var9631066F6275EB4A3DD498FCE757150E_1274258168;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.480 -0400", hash_original_method = "3E37D8F586D5D9C430A73700118F801E", hash_generated_method = "603F0066673686EDA89849CB8209AEB1")
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
SocketAddress var9631066F6275EB4A3DD498FCE757150E_2089467396 =         retAddr;
        var9631066F6275EB4A3DD498FCE757150E_2089467396.addTaint(taint);
        return var9631066F6275EB4A3DD498FCE757150E_2089467396;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.481 -0400", hash_original_method = "959B6E7D8D0C8B7E48B65559E90B586F", hash_generated_method = "BE31BA4CDB899D3EB0E46D624C30259E")
    @Override
    public int send(ByteBuffer source, SocketAddress socketAddress) throws IOException {
        addTaint(socketAddress.getTaint());
        addTaint(source.getTaint());
        checkNotNull(source);
        checkOpen();
        InetSocketAddress isa = (InetSocketAddress) socketAddress;
        if(isa.getAddress() == null)        
        {
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_811097041 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_811097041.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_811097041;
        } //End block
        if(isConnected() && !connectAddress.equals(isa))        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1517988318 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1517988318.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1517988318;
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
            int var3876D4D9CD9031311D3588F5FFDB6007_1178095632 = (sendCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_970068512 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_970068512;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.482 -0400", hash_original_method = "76528871489F953D405DA27A93276CC2", hash_generated_method = "A776E1BBFF831DDF93977D90A5485816")
    @Override
    public int read(ByteBuffer target) throws IOException {
        addTaint(target.getTaint());
        target.checkWritable();
        checkOpenConnected();
        if(!target.hasRemaining())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1528311301 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854044078 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854044078;
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
        int varADC9E8D761A52E26BEC5404508AFC000_2096530983 = (readCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1605106939 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1605106939;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.483 -0400", hash_original_method = "73BDAA1D4D5FBBB4136E79D8CC3B2003", hash_generated_method = "8FB7E7964B0582701EA47CCFDD26A93B")
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
            long varCFCD208495D565EF66E7DFF9F98764DA_1830260974 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1600161398 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1600161398;
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
        long varADC9E8D761A52E26BEC5404508AFC000_881789575 = (readCount);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_485306021 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_485306021;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.484 -0400", hash_original_method = "FFB1F44E8E8861E1A9AE8DEADE3707A8", hash_generated_method = "98071A25AE4C9506D7D15C4674E667D0")
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
                int varCFCD208495D565EF66E7DFF9F98764DA_1326236151 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168928959 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168928959;
            } //End block
            finally 
            {
                end(readCount > 0);
            } //End block
            int varADC9E8D761A52E26BEC5404508AFC000_896631219 = (readCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_820320539 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_820320539;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.485 -0400", hash_original_method = "EACC5F2E46984D93B58057650609FEF7", hash_generated_method = "02CB1E14CB0230A3A3D79F3BE2710221")
    @Override
    public int write(ByteBuffer src) throws IOException {
        addTaint(src.getTaint());
        checkNotNull(src);
        checkOpenConnected();
        if(!src.hasRemaining())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1575612886 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1010662101 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1010662101;
        } //End block
        int writeCount = writeImpl(src);
        if(writeCount > 0)        
        {
            src.position(src.position() + writeCount);
        } //End block
        int var44A1965D931137262EA3A9400DCC2A67_840438580 = (writeCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_10478601 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_10478601;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.486 -0400", hash_original_method = "92D26B18BB75EB8AD284E7DC348B13D6", hash_generated_method = "D9F318D3E880C9460E872A87914F8E65")
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
            long varCFCD208495D565EF66E7DFF9F98764DA_462480865 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1508272155 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1508272155;
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
        long var9CC26FA09CE37BC95AFE01BC718836D1_69087709 = (written);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1051130481 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1051130481;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.488 -0400", hash_original_method = "C5D18F36066EF5A8A32922161E6847D8", hash_generated_method = "F57EBCBB071DF6466D47D4B8047905EF")
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
            int varB4A88417B3D0170D754C647C30B7216A_652426599 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_138611179 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_138611179;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.489 -0400", hash_original_method = "CF8B9D693C24D7742692C737C034E989", hash_generated_method = "AA0F7EAABB67DB5CB4BF2A0F9DE76C1F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.489 -0400", hash_original_method = "B277EC5F8A308E553B57A0D050976387", hash_generated_method = "8A4048D7B505F1340F0DB31FC91FB3B2")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.490 -0400", hash_original_method = "CB491A74BF9C37F6ADAA84B27A2FC899", hash_generated_method = "81FA07E716BAA0C4E15E8959DA2CCF64")
    private void checkOpen() throws IOException {
        if(!isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_1418427634 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_1418427634.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_1418427634;
        } //End block
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedChannelException();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.490 -0400", hash_original_method = "C4EAE028A2901AB3F43566E69E9E24D8", hash_generated_method = "44E1EECFBCCCE5CBA5B5226C0507ADD8")
    private void checkOpenConnected() throws IOException {
        checkOpen();
        if(!isConnected())        
        {
            NotYetConnectedException var74CB2CB661C2A7775D3A554085300C50_1205720094 = new NotYetConnectedException();
            var74CB2CB661C2A7775D3A554085300C50_1205720094.addTaint(taint);
            throw var74CB2CB661C2A7775D3A554085300C50_1205720094;
        } //End block
        // ---------- Original Method ----------
        //checkOpen();
        //if (!isConnected()) {
            //throw new NotYetConnectedException();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.490 -0400", hash_original_method = "DE9BF6E7ACC5E7DCC990C5D950818BC0", hash_generated_method = "3275B77A66DB6B5047E5783E7B1A3C87")
    private void checkNotNull(ByteBuffer source) {
        addTaint(source.getTaint());
        if(source == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1209457331 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1209457331.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1209457331;
        } //End block
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.491 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "507BCD56374B44F5036B6327C8A66F9D")
    public FileDescriptor getFD() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_793207823 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_793207823.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_793207823;
        // ---------- Original Method ----------
        //return fd;
    }

    
    private static class DatagramSocketAdapter extends DatagramSocket {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.491 -0400", hash_original_field = "32CC750E4B8FCA138B4D6BCBE118C5DB", hash_generated_field = "8F599A20342D355936B02DA735AA8136")

        private DatagramChannelImpl channelImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.492 -0400", hash_original_method = "69EFCB277ED141BA204F53D83B183F8E", hash_generated_method = "3A598A74C3349DDD40B52394BB3A4E86")
          DatagramSocketAdapter(DatagramSocketImpl socketimpl,
                DatagramChannelImpl channelImpl) {
            super(socketimpl);
            addTaint(socketimpl.getTaint());
            this.channelImpl = channelImpl;
            // ---------- Original Method ----------
            //this.channelImpl = channelImpl;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.492 -0400", hash_original_method = "272F2E718E0C10B582849935E6BE168A", hash_generated_method = "091080560649EDF6A6BBC4D602CE92E5")
        @Override
        public DatagramChannel getChannel() {
DatagramChannel var11782E095BD1B72C89449FBEBF7A0AC8_2066147071 =             channelImpl;
            var11782E095BD1B72C89449FBEBF7A0AC8_2066147071.addTaint(taint);
            return var11782E095BD1B72C89449FBEBF7A0AC8_2066147071;
            // ---------- Original Method ----------
            //return channelImpl;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.492 -0400", hash_original_method = "F11CC1C6B1751A820DF0839300E56C28", hash_generated_method = "E0AC87B5B138C9B78C77E735C24FEFAB")
        @Override
        public boolean isBound() {
            boolean var4CD2AC3855DA1D125443CED5137DEAA0_472586323 = (channelImpl.isBound);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1331921069 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1331921069;
            // ---------- Original Method ----------
            //return channelImpl.isBound;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.492 -0400", hash_original_method = "EBC91F4CCE587021E0B931D77134C0EB", hash_generated_method = "3F00B6FBE1EC0652AB5A88F0E7897CEE")
        @Override
        public boolean isConnected() {
            boolean var5927211285318058C1B12CAF9806340C_2047210619 = (channelImpl.isConnected());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_703304658 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_703304658;
            // ---------- Original Method ----------
            //return channelImpl.isConnected();
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.492 -0400", hash_original_method = "F2E78E937EC010AD3CD73E7409B0139F", hash_generated_method = "51A7994A9CB895CA9BBDB8FA00E5C104")
        @Override
        public InetAddress getInetAddress() {
            if(channelImpl.connectAddress == null)            
            {
InetAddress var540C13E9E156B687226421B24F2DF178_324362524 =                 null;
                var540C13E9E156B687226421B24F2DF178_324362524.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_324362524;
            } //End block
InetAddress varA060811330446BAC29319DDCF5678AA0_1366258551 =             channelImpl.connectAddress.getAddress();
            varA060811330446BAC29319DDCF5678AA0_1366258551.addTaint(taint);
            return varA060811330446BAC29319DDCF5678AA0_1366258551;
            // ---------- Original Method ----------
            //if (channelImpl.connectAddress == null) {
                //return null;
            //}
            //return channelImpl.connectAddress.getAddress();
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.493 -0400", hash_original_method = "2C69EB670D32F39C986C933D03BF3A1E", hash_generated_method = "04CD1C4A0F6EE87349D494D9FE139DCF")
        @Override
        public InetAddress getLocalAddress() {
InetAddress var1896EE36E5804FF576893458CF24D97A_822402675 =             channelImpl.getLocalAddress();
            var1896EE36E5804FF576893458CF24D97A_822402675.addTaint(taint);
            return var1896EE36E5804FF576893458CF24D97A_822402675;
            // ---------- Original Method ----------
            //return channelImpl.getLocalAddress();
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.493 -0400", hash_original_method = "4B98C51C8664AA9BAB8C98CDD2BAB4FB", hash_generated_method = "3913A87C2C35B7BD0D483C49F33DB60A")
        @Override
        public int getPort() {
            if(channelImpl.connectAddress == null)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_586263707 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282947955 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282947955;
            } //End block
            int var0D4AED51050E45051EBE53DE57883C30_1488631039 = (channelImpl.connectAddress.getPort());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1290993770 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1290993770;
            // ---------- Original Method ----------
            //if (channelImpl.connectAddress == null) {
                //return -1;
            //}
            //return channelImpl.connectAddress.getPort();
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.493 -0400", hash_original_method = "42FCE5AEF7C64B9A4F845E086D487D7D", hash_generated_method = "C9D645E78D4796C61965E791909918F4")
        @Override
        public void bind(SocketAddress localAddr) throws SocketException {
            addTaint(localAddr.getTaint());
            if(channelImpl.isConnected())            
            {
                AlreadyConnectedException var476065E4395D997E6E7AB97A5FAAC77C_864982637 = new AlreadyConnectedException();
                var476065E4395D997E6E7AB97A5FAAC77C_864982637.addTaint(taint);
                throw var476065E4395D997E6E7AB97A5FAAC77C_864982637;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.493 -0400", hash_original_method = "714770E7AF180E6CA35843F3D6FA59F5", hash_generated_method = "9BDF953991ADE4461E331E80E4D615E9")
        @Override
        public void receive(DatagramPacket packet) throws IOException {
            addTaint(packet.getTaint());
            if(!channelImpl.isBlocking())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_1637448104 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_1637448104.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_1637448104;
            } //End block
            super.receive(packet);
            // ---------- Original Method ----------
            //if (!channelImpl.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //super.receive(packet);
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.494 -0400", hash_original_method = "B8D9E7A66BAFFB4AAB90A90FE956BDD4", hash_generated_method = "4159516E74B2B5FCF4F464CB0020D14D")
        @Override
        public void send(DatagramPacket packet) throws IOException {
            addTaint(packet.getTaint());
            if(!channelImpl.isBlocking())            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_6716101 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_6716101.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_6716101;
            } //End block
            super.send(packet);
            // ---------- Original Method ----------
            //if (!channelImpl.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //super.send(packet);
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.494 -0400", hash_original_method = "46B266D91BAFA027B87005DE54970890", hash_generated_method = "F9C32124A5A170571870B205BB17F41B")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.494 -0400", hash_original_method = "CD5228FAD6696C7AA890BA57AAC5031A", hash_generated_method = "25A05919B12E6FB0CC8C4655346CB469")
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

