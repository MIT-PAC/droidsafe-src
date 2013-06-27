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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.195 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.195 -0400", hash_original_field = "E728D69D332AE7988C6FE7869D66573E", hash_generated_field = "AE66ADE591BF9A05EC0F956D394B783F")

    private DatagramSocket socket = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.195 -0400", hash_original_field = "01E982E0501B1B10CFBB661526A8D271", hash_generated_field = "6782D8EC356D5CE5C81488F7E6BAFADE")

    InetSocketAddress connectAddress = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.195 -0400", hash_original_field = "55FC25CF376E1B7BFFBC2D46F357C231", hash_generated_field = "B1420775EE6B172A515A5BC10BFFE633")

    private int localPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.195 -0400", hash_original_field = "0FEAA30127F5BBCD4CDACFBD8D171074", hash_generated_field = "B7AA47F0C5F11D3CAE3655ABEE0444C2")

    boolean connected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.195 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "F9AB7682F64A4F93F6F4A7A435A5AA53")

    boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.195 -0400", hash_original_field = "0EBBDB2C6AB02F595FD6B8EE0165CE90", hash_generated_field = "0BDEB8ABE1932E75D75EE50EF5D56058")

    private Object readLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.195 -0400", hash_original_field = "5A9206244ED4B85CC1847D97E427123C", hash_generated_field = "04E97E6709F6F21DAA184AB6BB309FED")

    private Object writeLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.195 -0400", hash_original_method = "672B5AA8860523DE8F538FC55262F72E", hash_generated_method = "B25DE8CADB1457CBF8DDC3C1D309A505")
    protected  DatagramChannelImpl(SelectorProvider selectorProvider) throws IOException {
        super(selectorProvider);
        fd = IoBridge.socket(false);
        addTaint(selectorProvider.getTaint());
        // ---------- Original Method ----------
        //fd = IoBridge.socket(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.196 -0400", hash_original_method = "33AAD00A4AE1DFC2263EB97BD11A58AF", hash_generated_method = "D50D9F375903B283F8E9E43BD5AB7E04")
    @SuppressWarnings("unused")
    private  DatagramChannelImpl() {
        super(SelectorProvider.provider());
        fd = new FileDescriptor();
        connectAddress = new InetSocketAddress(0);
        // ---------- Original Method ----------
        //fd = new FileDescriptor();
        //connectAddress = new InetSocketAddress(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.201 -0400", hash_original_method = "CB0BD0AB90ECCAF1B55A641E507A7D41", hash_generated_method = "20EA3CEF62E5DDACDFD78C337EF613B7")
    @Override
    synchronized public DatagramSocket socket() {
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_1374330936 = null; //Variable for return #1
        {
            socket = new DatagramSocketAdapter(new PlainDatagramSocketImpl(fd, localPort), this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1374330936 = socket;
        varB4EAC82CA7396A68D541C85D26508E83_1374330936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1374330936;
        // ---------- Original Method ----------
        //if (socket == null) {
            //socket = new DatagramSocketAdapter(new PlainDatagramSocketImpl(fd, localPort), this);
        //}
        //return socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.201 -0400", hash_original_method = "0E5E291FF84E111D5E99E4DCFA7BD180", hash_generated_method = "D51A9BEA3C5FDEB4328F5A9FD85DFC62")
     InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1532454812 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1532454812 = IoBridge.getSocketLocalAddress(fd);
        varB4EAC82CA7396A68D541C85D26508E83_1532454812.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1532454812;
        // ---------- Original Method ----------
        //return IoBridge.getSocketLocalAddress(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.219 -0400", hash_original_method = "FA10E9C7778335E6674967F36CF6493F", hash_generated_method = "B05E93572ABC08EB78F317264E9B2698")
    @Override
    synchronized public boolean isConnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1570307659 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1570307659;
        // ---------- Original Method ----------
        //return connected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.220 -0400", hash_original_method = "AF75F16707868C3AF8C2693CEE337F7E", hash_generated_method = "2B2D85CA23AE15C0247DAE57F6769F58")
    @Override
    synchronized public DatagramChannel connect(SocketAddress address) throws IOException {
        DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_958730439 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_958730439 = this;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_958730439.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_958730439;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.221 -0400", hash_original_method = "EF6170FA9655FF42105E76598600F7D4", hash_generated_method = "877CEC7CADB0053CE816A1615C8FF189")
    @Override
    synchronized public DatagramChannel disconnect() throws IOException {
        DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_1193016969 = null; //Variable for return #1
        DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_1127084062 = null; //Variable for return #2
        {
            boolean var131263B9D168DAF17510420A0B1D4997_1680663447 = (!isConnected() || !isOpen());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1193016969 = this;
            } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_1127084062 = this;
        DatagramChannel varA7E53CE21691AB073D9660D615818899_1645294777; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1645294777 = varB4EAC82CA7396A68D541C85D26508E83_1193016969;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1645294777 = varB4EAC82CA7396A68D541C85D26508E83_1127084062;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1645294777.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1645294777;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.239 -0400", hash_original_method = "0C3D128AF11DA9AEAEB5EC56CF1536D1", hash_generated_method = "08BB9553AFE67064050273430EC807AC")
    @Override
    public SocketAddress receive(ByteBuffer target) throws IOException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_2099474070 = null; //Variable for return #1
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1298310590 = null; //Variable for return #2
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_443299555 = null; //Variable for return #3
        target.checkWritable();
        checkOpen();
        {
            varB4EAC82CA7396A68D541C85D26508E83_2099474070 = null;
        } //End block
        SocketAddress retAddr;
        retAddr = null;
        try 
        {
            begin();
            {
                boolean loop;
                loop = isBlocking();
                {
                    boolean var60B6DA0786479A0C7489B57034E21AB9_122955413 = (!target.isDirect());
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
        {
            varB4EAC82CA7396A68D541C85D26508E83_1298310590 = null;
        } //End block
        finally 
        {
            end(retAddr != null);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_443299555 = retAddr;
        addTaint(target.getTaint());
        SocketAddress varA7E53CE21691AB073D9660D615818899_2101258653; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2101258653 = varB4EAC82CA7396A68D541C85D26508E83_2099474070;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2101258653 = varB4EAC82CA7396A68D541C85D26508E83_1298310590;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2101258653 = varB4EAC82CA7396A68D541C85D26508E83_443299555;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2101258653.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2101258653;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.251 -0400", hash_original_method = "A505D0369C23E2979AA10DE303251FF7", hash_generated_method = "2A92E1341A76ADB8B53E035915F15C4B")
    private SocketAddress receiveImpl(ByteBuffer target, boolean loop) throws IOException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_36041644 = null; //Variable for return #1
        SocketAddress retAddr;
        retAddr = null;
        DatagramPacket receivePacket;
        int oldposition;
        oldposition = target.position();
        int received;
        received = 0;
        {
            boolean var60296D7148D7CD6284B1FB4B0E82F5B5_2000961204 = (target.hasArray());
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
                boolean var826C3DC943C932AFF0D97ABCF8BC0FBC_1398174238 = (receivePacket != null && receivePacket.getAddress() != null);
                {
                    {
                        {
                            boolean var395A28C9488D0B3CF5AF8252A428D998_609638488 = (target.hasArray());
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
        varB4EAC82CA7396A68D541C85D26508E83_36041644 = retAddr;
        addTaint(target.getTaint());
        addTaint(loop);
        varB4EAC82CA7396A68D541C85D26508E83_36041644.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_36041644;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.253 -0400", hash_original_method = "3E37D8F586D5D9C430A73700118F801E", hash_generated_method = "387FE70A6EBBD9B4997C34DBCBFCFBC1")
    private SocketAddress receiveDirectImpl(ByteBuffer target, boolean loop) throws IOException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1789734440 = null; //Variable for return #1
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
                boolean var826C3DC943C932AFF0D97ABCF8BC0FBC_2100702835 = (receivePacket != null && receivePacket.getAddress() != null);
                {
                    {
                        target.position(oldposition + received);
                    } //End block
                    retAddr = receivePacket.getSocketAddress();
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1789734440 = retAddr;
        addTaint(target.getTaint());
        addTaint(loop);
        varB4EAC82CA7396A68D541C85D26508E83_1789734440.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1789734440;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.264 -0400", hash_original_method = "959B6E7D8D0C8B7E48B65559E90B586F", hash_generated_method = "5DB18AE2AC667FB371C4DD5191201A95")
    @Override
    public int send(ByteBuffer source, SocketAddress socketAddress) throws IOException {
        checkNotNull(source);
        checkOpen();
        InetSocketAddress isa;
        isa = (InetSocketAddress) socketAddress;
        {
            boolean var94908F4406976F47F480E81F35A6256E_1642369007 = (isa.getAddress() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varACCEE759C92B66C87294B3FE171A86ED_511232949 = (isConnected() && !connectAddress.equals(isa));
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
        addTaint(source.getTaint());
        addTaint(socketAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921489486 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921489486;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.265 -0400", hash_original_method = "76528871489F953D405DA27A93276CC2", hash_generated_method = "5C4F21230536C7D97969E90B73F06A86")
    @Override
    public int read(ByteBuffer target) throws IOException {
        target.checkWritable();
        checkOpenConnected();
        {
            boolean var20B3BDB73F0932F2A7B4D5F3626BD9B5_1847886459 = (!target.hasRemaining());
        } //End collapsed parenthetic
        int readCount;
        readCount = 0;
        {
            boolean varAD3610F4AB318B3E2F2E2CDF9A9A0813_543903649 = (target.isDirect() || target.hasArray());
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
        addTaint(target.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830532967 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830532967;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.266 -0400", hash_original_method = "73BDAA1D4D5FBBB4136E79D8CC3B2003", hash_generated_method = "9A7146DE2132420586C60669BE5C4330")
    @Override
    public long read(ByteBuffer[] targets, int offset, int length) throws IOException {
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
        addTaint(targets[0].getTaint());
        addTaint(offset);
        addTaint(length);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_288003965 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_288003965;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.294 -0400", hash_original_method = "FFB1F44E8E8861E1A9AE8DEADE3707A8", hash_generated_method = "55597DDA8A67BFA171C74C38F6B223F2")
    private int readImpl(ByteBuffer dst) throws IOException {
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
        addTaint(dst.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1938395346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1938395346;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.310 -0400", hash_original_method = "EACC5F2E46984D93B58057650609FEF7", hash_generated_method = "3422F230B966AD5EB44BC8029D8B9EC1")
    @Override
    public int write(ByteBuffer src) throws IOException {
        checkNotNull(src);
        checkOpenConnected();
        {
            boolean var78714B40A2AE0B69755CF30C747E39CB_2063621933 = (!src.hasRemaining());
        } //End collapsed parenthetic
        int writeCount;
        writeCount = writeImpl(src);
        {
            src.position(src.position() + writeCount);
        } //End block
        addTaint(src.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081402893 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081402893;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.312 -0400", hash_original_method = "92D26B18BB75EB8AD284E7DC348B13D6", hash_generated_method = "E46AED96C21F5046208C88FE08D49E8D")
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
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1321394269 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1321394269;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.313 -0400", hash_original_method = "C5D18F36066EF5A8A32922161E6847D8", hash_generated_method = "C231A74B665C84E54FAEE7EC79B676CC")
    private int writeImpl(ByteBuffer buf) throws IOException {
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
        addTaint(buf.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1987241805 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1987241805;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.313 -0400", hash_original_method = "CF8B9D693C24D7742692C737C034E989", hash_generated_method = "BD47B61484871CC8E9FE59D5B103C8D0")
    @Override
    protected synchronized void implCloseSelectableChannel() throws IOException {
        connected = false;
        {
            boolean varA09DB173CEF278ADC32C70770C281924_1621580718 = (socket != null && !socket.isClosed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.314 -0400", hash_original_method = "B277EC5F8A308E553B57A0D050976387", hash_generated_method = "04FD05B13404E52F53917B4916CFE2B7")
    @Override
    protected void implConfigureBlocking(boolean blocking) throws IOException {
        {
            Object var964C97B960BB46676C47DA572AAFDDC9_1973881947 = (blockingLock());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.314 -0400", hash_original_method = "CB491A74BF9C37F6ADAA84B27A2FC899", hash_generated_method = "8A688A03FD4770EFEF515E5BB35A518E")
    private void checkOpen() throws IOException {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1902000607 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedChannelException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.314 -0400", hash_original_method = "C4EAE028A2901AB3F43566E69E9E24D8", hash_generated_method = "A06667789EF34A57495B74D0877F7C7B")
    private void checkOpenConnected() throws IOException {
        checkOpen();
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_509659073 = (!isConnected());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.315 -0400", hash_original_method = "DE9BF6E7ACC5E7DCC990C5D950818BC0", hash_generated_method = "6F97918BBEC302691B46FE58BE69F4A6")
    private void checkNotNull(ByteBuffer source) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        addTaint(source.getTaint());
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.343 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "6DEF400BE2B8BDCF732E28808BEFF0FB")
    public FileDescriptor getFD() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_119032973 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_119032973 = fd;
        varB4EAC82CA7396A68D541C85D26508E83_119032973.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_119032973;
        // ---------- Original Method ----------
        //return fd;
    }

    
    private static class DatagramSocketAdapter extends DatagramSocket {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.343 -0400", hash_original_field = "32CC750E4B8FCA138B4D6BCBE118C5DB", hash_generated_field = "8F599A20342D355936B02DA735AA8136")

        private DatagramChannelImpl channelImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.343 -0400", hash_original_method = "69EFCB277ED141BA204F53D83B183F8E", hash_generated_method = "B4A6337155DD3892E1E5AF63E6CA3F7D")
          DatagramSocketAdapter(DatagramSocketImpl socketimpl,
                DatagramChannelImpl channelImpl) {
            super(socketimpl);
            this.channelImpl = channelImpl;
            addTaint(socketimpl.getTaint());
            // ---------- Original Method ----------
            //this.channelImpl = channelImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.344 -0400", hash_original_method = "272F2E718E0C10B582849935E6BE168A", hash_generated_method = "FFA5AD7F04DFEE403F46DEA1E021E652")
        @Override
        public DatagramChannel getChannel() {
            DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_1400825869 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1400825869 = channelImpl;
            varB4EAC82CA7396A68D541C85D26508E83_1400825869.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1400825869;
            // ---------- Original Method ----------
            //return channelImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.345 -0400", hash_original_method = "F11CC1C6B1751A820DF0839300E56C28", hash_generated_method = "0A960AA5BB5417F646D7C0EC5E4D6AFE")
        @Override
        public boolean isBound() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1108839310 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1108839310;
            // ---------- Original Method ----------
            //return channelImpl.isBound;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.360 -0400", hash_original_method = "EBC91F4CCE587021E0B931D77134C0EB", hash_generated_method = "F646ECD049C1F46770ED87D6CBFA2C64")
        @Override
        public boolean isConnected() {
            boolean var62CA8521E6AF586CA79D70D6CF667F20_1148824125 = (channelImpl.isConnected());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1413197667 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1413197667;
            // ---------- Original Method ----------
            //return channelImpl.isConnected();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.361 -0400", hash_original_method = "F2E78E937EC010AD3CD73E7409B0139F", hash_generated_method = "9B5640DCDF56A5F0192391773607928F")
        @Override
        public InetAddress getInetAddress() {
            InetAddress varB4EAC82CA7396A68D541C85D26508E83_1465001030 = null; //Variable for return #1
            InetAddress varB4EAC82CA7396A68D541C85D26508E83_1874172855 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_1465001030 = null;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1874172855 = channelImpl.connectAddress.getAddress();
            InetAddress varA7E53CE21691AB073D9660D615818899_1871682516; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1871682516 = varB4EAC82CA7396A68D541C85D26508E83_1465001030;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1871682516 = varB4EAC82CA7396A68D541C85D26508E83_1874172855;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1871682516.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1871682516;
            // ---------- Original Method ----------
            //if (channelImpl.connectAddress == null) {
                //return null;
            //}
            //return channelImpl.connectAddress.getAddress();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.361 -0400", hash_original_method = "2C69EB670D32F39C986C933D03BF3A1E", hash_generated_method = "F5BE292819E5AEB54C684D074DBF668B")
        @Override
        public InetAddress getLocalAddress() {
            InetAddress varB4EAC82CA7396A68D541C85D26508E83_2058678446 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2058678446 = channelImpl.getLocalAddress();
            varB4EAC82CA7396A68D541C85D26508E83_2058678446.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2058678446;
            // ---------- Original Method ----------
            //return channelImpl.getLocalAddress();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.372 -0400", hash_original_method = "4B98C51C8664AA9BAB8C98CDD2BAB4FB", hash_generated_method = "A5BEAB50C5B5B69D82035F43A3989B64")
        @Override
        public int getPort() {
            int varC574877425F272779C5F02E9439194EF_1102735841 = (channelImpl.connectAddress.getPort());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93148202 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93148202;
            // ---------- Original Method ----------
            //if (channelImpl.connectAddress == null) {
                //return -1;
            //}
            //return channelImpl.connectAddress.getPort();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.373 -0400", hash_original_method = "42FCE5AEF7C64B9A4F845E086D487D7D", hash_generated_method = "2273E7D6FB6971EF43F853DB8ECB6BF3")
        @Override
        public void bind(SocketAddress localAddr) throws SocketException {
            {
                boolean var4B0E49754C523761E0E44E87B0B6089A_597199911 = (channelImpl.isConnected());
                {
                    if (DroidSafeAndroidRuntime.control) throw new AlreadyConnectedException();
                } //End block
            } //End collapsed parenthetic
            super.bind(localAddr);
            channelImpl.isBound = true;
            addTaint(localAddr.getTaint());
            // ---------- Original Method ----------
            //if (channelImpl.isConnected()) {
                //throw new AlreadyConnectedException();
            //}
            //super.bind(localAddr);
            //channelImpl.isBound = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.385 -0400", hash_original_method = "714770E7AF180E6CA35843F3D6FA59F5", hash_generated_method = "9A1060106323635D6A80A7A49A21C8FE")
        @Override
        public void receive(DatagramPacket packet) throws IOException {
            {
                boolean varBAE8CEDA21BF2921535BF8B9F4D62736_1756446937 = (!channelImpl.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            super.receive(packet);
            addTaint(packet.getTaint());
            // ---------- Original Method ----------
            //if (!channelImpl.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //super.receive(packet);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.407 -0400", hash_original_method = "B8D9E7A66BAFFB4AAB90A90FE956BDD4", hash_generated_method = "1960AEDFD527276538E9AC6EE43EF40A")
        @Override
        public void send(DatagramPacket packet) throws IOException {
            {
                boolean varBAE8CEDA21BF2921535BF8B9F4D62736_1207861115 = (!channelImpl.isBlocking());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
                } //End block
            } //End collapsed parenthetic
            super.send(packet);
            addTaint(packet.getTaint());
            // ---------- Original Method ----------
            //if (!channelImpl.isBlocking()) {
                //throw new IllegalBlockingModeException();
            //}
            //super.send(packet);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.407 -0400", hash_original_method = "46B266D91BAFA027B87005DE54970890", hash_generated_method = "A66599DFBF8F3BF7C9812F873B131C8B")
        @Override
        public void close() {
            {
                {
                    boolean var732C27B9F7BFDC492915355DF0E33D1C_1999962502 = (channelImpl.isOpen());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.408 -0400", hash_original_method = "CD5228FAD6696C7AA890BA57AAC5031A", hash_generated_method = "4C622B878174EC52BA204C445BD3024B")
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

