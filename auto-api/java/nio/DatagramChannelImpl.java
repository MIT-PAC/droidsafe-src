package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.031 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.031 -0400", hash_original_field = "E728D69D332AE7988C6FE7869D66573E", hash_generated_field = "AE66ADE591BF9A05EC0F956D394B783F")

    private DatagramSocket socket = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.031 -0400", hash_original_field = "01E982E0501B1B10CFBB661526A8D271", hash_generated_field = "6782D8EC356D5CE5C81488F7E6BAFADE")

    InetSocketAddress connectAddress = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.031 -0400", hash_original_field = "55FC25CF376E1B7BFFBC2D46F357C231", hash_generated_field = "B1420775EE6B172A515A5BC10BFFE633")

    private int localPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.031 -0400", hash_original_field = "0FEAA30127F5BBCD4CDACFBD8D171074", hash_generated_field = "B7AA47F0C5F11D3CAE3655ABEE0444C2")

    boolean connected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.031 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "F9AB7682F64A4F93F6F4A7A435A5AA53")

    boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.031 -0400", hash_original_field = "0EBBDB2C6AB02F595FD6B8EE0165CE90", hash_generated_field = "E06B9588EA49DFE66B571508521E184B")

    private final Object readLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.031 -0400", hash_original_field = "5A9206244ED4B85CC1847D97E427123C", hash_generated_field = "4EB051AF8374C9B2C038ADD375A89D80")

    private final Object writeLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.032 -0400", hash_original_method = "672B5AA8860523DE8F538FC55262F72E", hash_generated_method = "B25DE8CADB1457CBF8DDC3C1D309A505")
    protected  DatagramChannelImpl(SelectorProvider selectorProvider) throws IOException {
        super(selectorProvider);
        fd = IoBridge.socket(false);
        addTaint(selectorProvider.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.032 -0400", hash_original_method = "33AAD00A4AE1DFC2263EB97BD11A58AF", hash_generated_method = "D50D9F375903B283F8E9E43BD5AB7E04")
    @SuppressWarnings("unused")
    private  DatagramChannelImpl() {
        super(SelectorProvider.provider());
        fd = new FileDescriptor();
        connectAddress = new InetSocketAddress(0);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.033 -0400", hash_original_method = "CB0BD0AB90ECCAF1B55A641E507A7D41", hash_generated_method = "6CC1EA1DA7047F39F67921CE096631B9")
    @Override
    synchronized public DatagramSocket socket() {
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_497910754 = null; 
        {
            socket = new DatagramSocketAdapter(new PlainDatagramSocketImpl(fd, localPort), this);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_497910754 = socket;
        varB4EAC82CA7396A68D541C85D26508E83_497910754.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_497910754;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.033 -0400", hash_original_method = "0E5E291FF84E111D5E99E4DCFA7BD180", hash_generated_method = "9276B6B92218F43DCFE8A571566AE443")
     InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1332860540 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1332860540 = IoBridge.getSocketLocalAddress(fd);
        varB4EAC82CA7396A68D541C85D26508E83_1332860540.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1332860540;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.033 -0400", hash_original_method = "FA10E9C7778335E6674967F36CF6493F", hash_generated_method = "94E51C26E85BE019DA5BBC3F70B770B3")
    @Override
    synchronized public boolean isConnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1664088038 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1664088038;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.035 -0400", hash_original_method = "AF75F16707868C3AF8C2693CEE337F7E", hash_generated_method = "DC4BF4BE7759F17720F0AE4BE47CBEB0")
    @Override
    synchronized public DatagramChannel connect(SocketAddress address) throws IOException {
        DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_1570925233 = null; 
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        InetSocketAddress inetSocketAddress = SocketChannelImpl.validateAddress(address);
        try 
        {
            begin();
            IoBridge.connect(fd, inetSocketAddress.getAddress(), inetSocketAddress.getPort());
        } 
        catch (ConnectException e)
        { }
        finally 
        {
            end(true);
        } 
        connectAddress = inetSocketAddress;
        connected = true;
        isBound = true;
        varB4EAC82CA7396A68D541C85D26508E83_1570925233 = this;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1570925233.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1570925233;
        
        
        
            
        
        
        
            
            
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.036 -0400", hash_original_method = "EF6170FA9655FF42105E76598600F7D4", hash_generated_method = "1200709FC8B9E66A4EEC175DF6EA7312")
    @Override
    synchronized public DatagramChannel disconnect() throws IOException {
        DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_2101294419 = null; 
        DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_1568750555 = null; 
        {
            boolean var131263B9D168DAF17510420A0B1D4997_1580135966 = (!isConnected() || !isOpen());
            {
                varB4EAC82CA7396A68D541C85D26508E83_2101294419 = this;
            } 
        } 
        connected = false;
        connectAddress = null;
        try 
        {
            Libcore.os.connect(fd, InetAddress.UNSPECIFIED, 0);
        } 
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } 
        {
            socket.disconnect();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1568750555 = this;
        DatagramChannel varA7E53CE21691AB073D9660D615818899_788025555; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_788025555 = varB4EAC82CA7396A68D541C85D26508E83_2101294419;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_788025555 = varB4EAC82CA7396A68D541C85D26508E83_1568750555;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_788025555.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_788025555;
        
        
            
        
        
        
        
            
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.037 -0400", hash_original_method = "0C3D128AF11DA9AEAEB5EC56CF1536D1", hash_generated_method = "D02C13E2A2791DFC53080D354BE635A7")
    @Override
    public SocketAddress receive(ByteBuffer target) throws IOException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_651050176 = null; 
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_323869675 = null; 
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_2089634676 = null; 
        target.checkWritable();
        checkOpen();
        {
            varB4EAC82CA7396A68D541C85D26508E83_651050176 = null;
        } 
        SocketAddress retAddr = null;
        try 
        {
            begin();
            {
                boolean loop = isBlocking();
                {
                    boolean var60B6DA0786479A0C7489B57034E21AB9_585274015 = (!target.isDirect());
                    {
                        retAddr = receiveImpl(target, loop);
                    } 
                    {
                        retAddr = receiveDirectImpl(target, loop);
                    } 
                } 
            } 
        } 
        catch (InterruptedIOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_323869675 = null;
        } 
        finally 
        {
            end(retAddr != null);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2089634676 = retAddr;
        addTaint(target.getTaint());
        SocketAddress varA7E53CE21691AB073D9660D615818899_2014348094; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2014348094 = varB4EAC82CA7396A68D541C85D26508E83_651050176;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2014348094 = varB4EAC82CA7396A68D541C85D26508E83_323869675;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2014348094 = varB4EAC82CA7396A68D541C85D26508E83_2089634676;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2014348094.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2014348094;
        
        
        
        
            
        
        
        
            
            
                
                
                    
                
                    
                
            
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.038 -0400", hash_original_method = "A505D0369C23E2979AA10DE303251FF7", hash_generated_method = "988064EB4BBBE845C9C12ADAE578A60C")
    private SocketAddress receiveImpl(ByteBuffer target, boolean loop) throws IOException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1224510016 = null; 
        SocketAddress retAddr = null;
        DatagramPacket receivePacket;
        int oldposition = target.position();
        int received = 0;
        {
            boolean var60296D7148D7CD6284B1FB4B0E82F5B5_168565927 = (target.hasArray());
            {
                receivePacket = new DatagramPacket(target.array(), target.position() + target.arrayOffset(), target.remaining());
            } 
            {
                receivePacket = new DatagramPacket(new byte[target.remaining()], target.remaining());
            } 
        } 
        {
            received = IoBridge.recvfrom(false, fd, receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength(), 0, receivePacket, isConnected());
            {
                boolean var826C3DC943C932AFF0D97ABCF8BC0FBC_1259920427 = (receivePacket != null && receivePacket.getAddress() != null);
                {
                    {
                        {
                            boolean var395A28C9488D0B3CF5AF8252A428D998_2024950059 = (target.hasArray());
                            {
                                target.position(oldposition + received);
                            } 
                            {
                                target.put(receivePacket.getData(), 0, received);
                            } 
                        } 
                    } 
                    retAddr = receivePacket.getSocketAddress();
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1224510016 = retAddr;
        addTaint(target.getTaint());
        addTaint(loop);
        varB4EAC82CA7396A68D541C85D26508E83_1224510016.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1224510016;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.039 -0400", hash_original_method = "3E37D8F586D5D9C430A73700118F801E", hash_generated_method = "9BF1A00F6F55F5DC4428C9D91B9CED3B")
    private SocketAddress receiveDirectImpl(ByteBuffer target, boolean loop) throws IOException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_81808061 = null; 
        SocketAddress retAddr = null;
        DatagramPacket receivePacket = new DatagramPacket(EmptyArray.BYTE, 0);
        int oldposition = target.position();
        int received = 0;
        {
            received = IoBridge.recvfrom(false, fd, target, 0, receivePacket, isConnected());
            {
                boolean var826C3DC943C932AFF0D97ABCF8BC0FBC_1218167777 = (receivePacket != null && receivePacket.getAddress() != null);
                {
                    {
                        target.position(oldposition + received);
                    } 
                    retAddr = receivePacket.getSocketAddress();
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_81808061 = retAddr;
        addTaint(target.getTaint());
        addTaint(loop);
        varB4EAC82CA7396A68D541C85D26508E83_81808061.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_81808061;
        
        
        
        
        
        
            
            
                
                    
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.040 -0400", hash_original_method = "959B6E7D8D0C8B7E48B65559E90B586F", hash_generated_method = "98C8C7D4F0415FC6A9AE4A5FF72D6D53")
    @Override
    public int send(ByteBuffer source, SocketAddress socketAddress) throws IOException {
        checkNotNull(source);
        checkOpen();
        InetSocketAddress isa = (InetSocketAddress) socketAddress;
        {
            boolean var94908F4406976F47F480E81F35A6256E_368977892 = (isa.getAddress() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException();
            } 
        } 
        {
            boolean varACCEE759C92B66C87294B3FE171A86ED_1351707226 = (isConnected() && !connectAddress.equals(isa));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
        } 
        {
            int sendCount = 0;
            try 
            {
                begin();
                int oldPosition = source.position();
                sendCount = IoBridge.sendto(fd, source, 0, isa.getAddress(), isa.getPort());
                {
                    source.position(oldPosition + sendCount);
                } 
            } 
            finally 
            {
                end(sendCount >= 0);
            } 
        } 
        addTaint(source.getTaint());
        addTaint(socketAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_410106883 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_410106883;
        
        
        
        
        
            
        
        
            
        
        
            
            
                
                
                
                
                    
                
            
                
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.041 -0400", hash_original_method = "76528871489F953D405DA27A93276CC2", hash_generated_method = "766C2003C34AC0C85A5AFC6C5E27DC4E")
    @Override
    public int read(ByteBuffer target) throws IOException {
        target.checkWritable();
        checkOpenConnected();
        {
            boolean var20B3BDB73F0932F2A7B4D5F3626BD9B5_420341788 = (!target.hasRemaining());
        } 
        int readCount = 0;
        {
            boolean varAD3610F4AB318B3E2F2E2CDF9A9A0813_426452930 = (target.isDirect() || target.hasArray());
            {
                readCount = readImpl(target);
                {
                    target.position(target.position() + readCount);
                } 
            } 
            {
                byte[] readArray = new byte[target.remaining()];
                ByteBuffer readBuffer = ByteBuffer.wrap(readArray);
                readCount = readImpl(readBuffer);
                {
                    target.put(readArray, 0, readCount);
                } 
            } 
        } 
        addTaint(target.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_436694960 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_436694960;
        
        
        
        
            
        
        
        
            
            
                
            
        
            
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.041 -0400", hash_original_method = "73BDAA1D4D5FBBB4136E79D8CC3B2003", hash_generated_method = "FDEE5ADB776386103E93E0B880C24E89")
    @Override
    public long read(ByteBuffer[] targets, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(targets.length, offset, length);
        checkOpenConnected();
        int totalCount = FileChannelImpl.calculateTotalRemaining(targets, offset, length, true);
        ByteBuffer readBuffer = ByteBuffer.allocate(totalCount);
        int readCount;
        readCount = readImpl(readBuffer);
        int left = readCount;
        int index = offset;
        byte[] readArray = readBuffer.array();
        {
            int putLength = Math.min(targets[index].remaining(), left);
            targets[index].put(readArray, readCount - left, putLength);
            left -= putLength;
        } 
        addTaint(targets[0].getTaint());
        addTaint(offset);
        addTaint(length);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1076596937 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1076596937;
        
        
        
        
        
            
        
        
        
        
        
        
        
        
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.042 -0400", hash_original_method = "FFB1F44E8E8861E1A9AE8DEADE3707A8", hash_generated_method = "22741E1F10A529533C3D8FF0474B92C7")
    private int readImpl(ByteBuffer dst) throws IOException {
        {
            int readCount = 0;
            try 
            {
                begin();
                readCount = IoBridge.recvfrom(false, fd, dst, 0, null, isConnected());
            } 
            catch (InterruptedIOException e)
            { }
            finally 
            {
                end(readCount > 0);
            } 
        } 
        addTaint(dst.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1967833251 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1967833251;
        
        
            
            
                
                
            
                
            
                
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.042 -0400", hash_original_method = "EACC5F2E46984D93B58057650609FEF7", hash_generated_method = "43BCEC812F6D9056515935DA8A7EC803")
    @Override
    public int write(ByteBuffer src) throws IOException {
        checkNotNull(src);
        checkOpenConnected();
        {
            boolean var78714B40A2AE0B69755CF30C747E39CB_1886550658 = (!src.hasRemaining());
        } 
        int writeCount = writeImpl(src);
        {
            src.position(src.position() + writeCount);
        } 
        addTaint(src.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851176957 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851176957;
        
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.043 -0400", hash_original_method = "92D26B18BB75EB8AD284E7DC348B13D6", hash_generated_method = "EB32D2D446929B0A216AFD12568F2772")
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
            } 
        } 
        writeBuf.flip();
        int result = writeImpl(writeBuf);
        int val = offset;
        int written = result;
        {
            ByteBuffer source = sources[val];
            int gap = Math.min(result, source.remaining());
            source.position(source.position() + gap);
            result -= gap;
        } 
        addTaint(sources[0].getTaint());
        addTaint(offset);
        addTaint(length);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1892605437 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1892605437;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.043 -0400", hash_original_method = "C5D18F36066EF5A8A32922161E6847D8", hash_generated_method = "C13AD3AB8E53FD46983A08C7EEB54E5C")
    private int writeImpl(ByteBuffer buf) throws IOException {
        {
            int result = 0;
            try 
            {
                begin();
                result = IoBridge.sendto(fd, buf, 0, null, 0);
            } 
            finally 
            {
                end(result > 0);
            } 
        } 
        addTaint(buf.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_135696062 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_135696062;
        
        
            
            
                
                
            
                
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.044 -0400", hash_original_method = "CF8B9D693C24D7742692C737C034E989", hash_generated_method = "047305DCE64733F1BEB4BA7BE6DDBB9B")
    @Override
    protected synchronized void implCloseSelectableChannel() throws IOException {
        connected = false;
        {
            boolean varA09DB173CEF278ADC32C70770C281924_748602570 = (socket != null && !socket.isClosed());
            {
                socket.close();
            } 
            {
                IoBridge.closeSocket(fd);
            } 
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.044 -0400", hash_original_method = "B277EC5F8A308E553B57A0D050976387", hash_generated_method = "8B7C789DBA97663C2B37893D2B597A95")
    @Override
    protected void implConfigureBlocking(boolean blocking) throws IOException {
        {
            Object var964C97B960BB46676C47DA572AAFDDC9_123248782 = (blockingLock());
            {
                IoUtils.setBlocking(fd, blocking);
            } 
        } 
        addTaint(blocking);
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.045 -0400", hash_original_method = "CB491A74BF9C37F6ADAA84B27A2FC899", hash_generated_method = "812E36289055CBAA6B29670DCB1DFD28")
    private void checkOpen() throws IOException {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1282662406 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.045 -0400", hash_original_method = "C4EAE028A2901AB3F43566E69E9E24D8", hash_generated_method = "8CE4C2A763E3C19208826512B0D9678E")
    private void checkOpenConnected() throws IOException {
        checkOpen();
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_1000194903 = (!isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new NotYetConnectedException();
            } 
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.045 -0400", hash_original_method = "DE9BF6E7ACC5E7DCC990C5D950818BC0", hash_generated_method = "6F97918BBEC302691B46FE58BE69F4A6")
    private void checkNotNull(ByteBuffer source) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        addTaint(source.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.046 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "98539D5FCF59AB2FA4781E549E66D57D")
    public FileDescriptor getFD() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_381586323 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_381586323 = fd;
        varB4EAC82CA7396A68D541C85D26508E83_381586323.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_381586323;
        
        
    }

    
    private static class DatagramSocketAdapter extends DatagramSocket {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.046 -0400", hash_original_field = "32CC750E4B8FCA138B4D6BCBE118C5DB", hash_generated_field = "8F599A20342D355936B02DA735AA8136")

        private DatagramChannelImpl channelImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.046 -0400", hash_original_method = "69EFCB277ED141BA204F53D83B183F8E", hash_generated_method = "B4A6337155DD3892E1E5AF63E6CA3F7D")
          DatagramSocketAdapter(DatagramSocketImpl socketimpl,
                DatagramChannelImpl channelImpl) {
            super(socketimpl);
            this.channelImpl = channelImpl;
            addTaint(socketimpl.getTaint());
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.047 -0400", hash_original_method = "272F2E718E0C10B582849935E6BE168A", hash_generated_method = "F4C8FB7E1F6BD4CBE7AC5C8669DDD228")
        @Override
        public DatagramChannel getChannel() {
            DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_1035992839 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1035992839 = channelImpl;
            varB4EAC82CA7396A68D541C85D26508E83_1035992839.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1035992839;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.047 -0400", hash_original_method = "F11CC1C6B1751A820DF0839300E56C28", hash_generated_method = "75620AECAE92BCA01FC1A04A8557A31B")
        @Override
        public boolean isBound() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2112936932 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2112936932;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.047 -0400", hash_original_method = "EBC91F4CCE587021E0B931D77134C0EB", hash_generated_method = "BFF2B46E2539AE8C18C5BFEE96EEFC91")
        @Override
        public boolean isConnected() {
            boolean var62CA8521E6AF586CA79D70D6CF667F20_1790464579 = (channelImpl.isConnected());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_177002542 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_177002542;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.048 -0400", hash_original_method = "F2E78E937EC010AD3CD73E7409B0139F", hash_generated_method = "4E16A1B089FC585908DF168BE4EF3AEE")
        @Override
        public InetAddress getInetAddress() {
            InetAddress varB4EAC82CA7396A68D541C85D26508E83_1836533787 = null; 
            InetAddress varB4EAC82CA7396A68D541C85D26508E83_304858816 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1836533787 = null;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_304858816 = channelImpl.connectAddress.getAddress();
            InetAddress varA7E53CE21691AB073D9660D615818899_707174437; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_707174437 = varB4EAC82CA7396A68D541C85D26508E83_1836533787;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_707174437 = varB4EAC82CA7396A68D541C85D26508E83_304858816;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_707174437.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_707174437;
            
            
                
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.048 -0400", hash_original_method = "2C69EB670D32F39C986C933D03BF3A1E", hash_generated_method = "489D2C59AC444AE479F977C4B1D94644")
        @Override
        public InetAddress getLocalAddress() {
            InetAddress varB4EAC82CA7396A68D541C85D26508E83_1021442607 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1021442607 = channelImpl.getLocalAddress();
            varB4EAC82CA7396A68D541C85D26508E83_1021442607.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1021442607;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.049 -0400", hash_original_method = "4B98C51C8664AA9BAB8C98CDD2BAB4FB", hash_generated_method = "A4EBDE2173B178CBE8B247B2CB8AB456")
        @Override
        public int getPort() {
            int varC574877425F272779C5F02E9439194EF_210080843 = (channelImpl.connectAddress.getPort());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_929295604 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_929295604;
            
            
                
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.049 -0400", hash_original_method = "42FCE5AEF7C64B9A4F845E086D487D7D", hash_generated_method = "554ACCDE1F04ECCBE7A351F26FB64866")
        @Override
        public void bind(SocketAddress localAddr) throws SocketException {
            {
                boolean var4B0E49754C523761E0E44E87B0B6089A_870843823 = (channelImpl.isConnected());
                {
                    if (DroidSafeAndroidRuntime.control) throw new AlreadyConnectedException();
                } 
            } 
            super.bind(localAddr);
            channelImpl.isBound = true;
            addTaint(localAddr.getTaint());
            
            
                
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.049 -0400", hash_original_method = "714770E7AF180E6CA35843F3D6FA59F5", hash_generated_method = "7F2EFBB0A9EEA23FD57601FBE5F95DB9")
        @Override
        public void receive(DatagramPacket packet) throws IOException {
            {
                boolean varBAE8CEDA21BF2921535BF8B9F4D62736_1932263735 = (!channelImpl.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } 
            } 
            super.receive(packet);
            addTaint(packet.getTaint());
            
            
                
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.050 -0400", hash_original_method = "B8D9E7A66BAFFB4AAB90A90FE956BDD4", hash_generated_method = "5E3094B1DCE88B88008B268B2CAC58AE")
        @Override
        public void send(DatagramPacket packet) throws IOException {
            {
                boolean varBAE8CEDA21BF2921535BF8B9F4D62736_1522854891 = (!channelImpl.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } 
            } 
            super.send(packet);
            addTaint(packet.getTaint());
            
            
                
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.050 -0400", hash_original_method = "46B266D91BAFA027B87005DE54970890", hash_generated_method = "19C6663ACDAA52EC632C9402C55ECFFA")
        @Override
        public void close() {
            {
                {
                    boolean var732C27B9F7BFDC492915355DF0E33D1C_1337464765 = (channelImpl.isOpen());
                    {
                        try 
                        {
                            channelImpl.close();
                        } 
                        catch (IOException e)
                        { }
                    } 
                } 
                super.close();
            } 
            
            
                
                    
                        
                    
                    
                
                
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.051 -0400", hash_original_method = "CD5228FAD6696C7AA890BA57AAC5031A", hash_generated_method = "4C622B878174EC52BA204C445BD3024B")
        @Override
        public void disconnect() {
            try 
            {
                channelImpl.disconnect();
            } 
            catch (IOException e)
            { }
            super.disconnect();
            
            
                
            
            
            
        }

        
    }


    
}

