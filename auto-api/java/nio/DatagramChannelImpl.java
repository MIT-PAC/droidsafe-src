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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.218 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.219 -0400", hash_original_field = "E728D69D332AE7988C6FE7869D66573E", hash_generated_field = "AE66ADE591BF9A05EC0F956D394B783F")

    private DatagramSocket socket = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.219 -0400", hash_original_field = "01E982E0501B1B10CFBB661526A8D271", hash_generated_field = "6782D8EC356D5CE5C81488F7E6BAFADE")

    InetSocketAddress connectAddress = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.219 -0400", hash_original_field = "55FC25CF376E1B7BFFBC2D46F357C231", hash_generated_field = "B1420775EE6B172A515A5BC10BFFE633")

    private int localPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.219 -0400", hash_original_field = "0FEAA30127F5BBCD4CDACFBD8D171074", hash_generated_field = "B7AA47F0C5F11D3CAE3655ABEE0444C2")

    boolean connected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.219 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "F9AB7682F64A4F93F6F4A7A435A5AA53")

    boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.219 -0400", hash_original_field = "0EBBDB2C6AB02F595FD6B8EE0165CE90", hash_generated_field = "0BDEB8ABE1932E75D75EE50EF5D56058")

    private Object readLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.219 -0400", hash_original_field = "5A9206244ED4B85CC1847D97E427123C", hash_generated_field = "04E97E6709F6F21DAA184AB6BB309FED")

    private Object writeLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.226 -0400", hash_original_method = "672B5AA8860523DE8F538FC55262F72E", hash_generated_method = "B25DE8CADB1457CBF8DDC3C1D309A505")
    protected  DatagramChannelImpl(SelectorProvider selectorProvider) throws IOException {
        super(selectorProvider);
        fd = IoBridge.socket(false);
        addTaint(selectorProvider.getTaint());
        // ---------- Original Method ----------
        //fd = IoBridge.socket(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.240 -0400", hash_original_method = "33AAD00A4AE1DFC2263EB97BD11A58AF", hash_generated_method = "D50D9F375903B283F8E9E43BD5AB7E04")
    @SuppressWarnings("unused")
    private  DatagramChannelImpl() {
        super(SelectorProvider.provider());
        fd = new FileDescriptor();
        connectAddress = new InetSocketAddress(0);
        // ---------- Original Method ----------
        //fd = new FileDescriptor();
        //connectAddress = new InetSocketAddress(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.249 -0400", hash_original_method = "CB0BD0AB90ECCAF1B55A641E507A7D41", hash_generated_method = "5F45F3DCD40B29B9253508F4DE511854")
    @Override
    synchronized public DatagramSocket socket() {
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_431575026 = null; //Variable for return #1
        {
            socket = new DatagramSocketAdapter(new PlainDatagramSocketImpl(fd, localPort), this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_431575026 = socket;
        varB4EAC82CA7396A68D541C85D26508E83_431575026.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_431575026;
        // ---------- Original Method ----------
        //if (socket == null) {
            //socket = new DatagramSocketAdapter(new PlainDatagramSocketImpl(fd, localPort), this);
        //}
        //return socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.252 -0400", hash_original_method = "0E5E291FF84E111D5E99E4DCFA7BD180", hash_generated_method = "DB7DDB6CB4ADFE25044E3DDA222D3182")
     InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_601172626 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_601172626 = IoBridge.getSocketLocalAddress(fd);
        varB4EAC82CA7396A68D541C85D26508E83_601172626.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_601172626;
        // ---------- Original Method ----------
        //return IoBridge.getSocketLocalAddress(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.252 -0400", hash_original_method = "FA10E9C7778335E6674967F36CF6493F", hash_generated_method = "A583CC816A1E8D60397FAA61D2C0612E")
    @Override
    synchronized public boolean isConnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_873248651 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_873248651;
        // ---------- Original Method ----------
        //return connected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.253 -0400", hash_original_method = "AF75F16707868C3AF8C2693CEE337F7E", hash_generated_method = "5E96C0361B26E1C1B9AD11CD4A149B3B")
    @Override
    synchronized public DatagramChannel connect(SocketAddress address) throws IOException {
        DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_881625924 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_881625924 = this;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_881625924.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_881625924;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.255 -0400", hash_original_method = "EF6170FA9655FF42105E76598600F7D4", hash_generated_method = "CC39039B032FF8C63FC37E49AE3CC715")
    @Override
    synchronized public DatagramChannel disconnect() throws IOException {
        DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_1579819105 = null; //Variable for return #1
        DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_2075305896 = null; //Variable for return #2
        {
            boolean var131263B9D168DAF17510420A0B1D4997_1983653235 = (!isConnected() || !isOpen());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1579819105 = this;
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
        varB4EAC82CA7396A68D541C85D26508E83_2075305896 = this;
        DatagramChannel varA7E53CE21691AB073D9660D615818899_1001707945; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1001707945 = varB4EAC82CA7396A68D541C85D26508E83_1579819105;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1001707945 = varB4EAC82CA7396A68D541C85D26508E83_2075305896;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1001707945.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1001707945;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.256 -0400", hash_original_method = "0C3D128AF11DA9AEAEB5EC56CF1536D1", hash_generated_method = "4AFBAB7832498FBE11AA260C3AFC74A0")
    @Override
    public SocketAddress receive(ByteBuffer target) throws IOException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_141133986 = null; //Variable for return #1
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_837777007 = null; //Variable for return #2
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1241021345 = null; //Variable for return #3
        target.checkWritable();
        checkOpen();
        {
            varB4EAC82CA7396A68D541C85D26508E83_141133986 = null;
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
                    boolean var60B6DA0786479A0C7489B57034E21AB9_631179540 = (!target.isDirect());
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
            varB4EAC82CA7396A68D541C85D26508E83_837777007 = null;
        } //End block
        finally 
        {
            end(retAddr != null);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1241021345 = retAddr;
        addTaint(target.getTaint());
        SocketAddress varA7E53CE21691AB073D9660D615818899_249852737; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_249852737 = varB4EAC82CA7396A68D541C85D26508E83_141133986;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_249852737 = varB4EAC82CA7396A68D541C85D26508E83_837777007;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_249852737 = varB4EAC82CA7396A68D541C85D26508E83_1241021345;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_249852737.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_249852737;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.273 -0400", hash_original_method = "A505D0369C23E2979AA10DE303251FF7", hash_generated_method = "63C0CF320D2A5D52B503D9455BD135C9")
    private SocketAddress receiveImpl(ByteBuffer target, boolean loop) throws IOException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_776641367 = null; //Variable for return #1
        SocketAddress retAddr;
        retAddr = null;
        DatagramPacket receivePacket;
        int oldposition;
        oldposition = target.position();
        int received;
        received = 0;
        {
            boolean var60296D7148D7CD6284B1FB4B0E82F5B5_87329396 = (target.hasArray());
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
                boolean var826C3DC943C932AFF0D97ABCF8BC0FBC_1892529038 = (receivePacket != null && receivePacket.getAddress() != null);
                {
                    {
                        {
                            boolean var395A28C9488D0B3CF5AF8252A428D998_200704299 = (target.hasArray());
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
        varB4EAC82CA7396A68D541C85D26508E83_776641367 = retAddr;
        addTaint(target.getTaint());
        addTaint(loop);
        varB4EAC82CA7396A68D541C85D26508E83_776641367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_776641367;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.274 -0400", hash_original_method = "3E37D8F586D5D9C430A73700118F801E", hash_generated_method = "F7117F67FBBFA11E42DEB9FC0A6C9E5E")
    private SocketAddress receiveDirectImpl(ByteBuffer target, boolean loop) throws IOException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_733504965 = null; //Variable for return #1
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
                boolean var826C3DC943C932AFF0D97ABCF8BC0FBC_587785499 = (receivePacket != null && receivePacket.getAddress() != null);
                {
                    {
                        target.position(oldposition + received);
                    } //End block
                    retAddr = receivePacket.getSocketAddress();
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_733504965 = retAddr;
        addTaint(target.getTaint());
        addTaint(loop);
        varB4EAC82CA7396A68D541C85D26508E83_733504965.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_733504965;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.275 -0400", hash_original_method = "959B6E7D8D0C8B7E48B65559E90B586F", hash_generated_method = "DACF9FA9BBBF62E1F6701483F8D381DD")
    @Override
    public int send(ByteBuffer source, SocketAddress socketAddress) throws IOException {
        checkNotNull(source);
        checkOpen();
        InetSocketAddress isa;
        isa = (InetSocketAddress) socketAddress;
        {
            boolean var94908F4406976F47F480E81F35A6256E_2147202623 = (isa.getAddress() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varACCEE759C92B66C87294B3FE171A86ED_879185070 = (isConnected() && !connectAddress.equals(isa));
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093192824 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093192824;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.280 -0400", hash_original_method = "76528871489F953D405DA27A93276CC2", hash_generated_method = "F0F96B652A69E77B0B6FFCFCD9EC38A2")
    @Override
    public int read(ByteBuffer target) throws IOException {
        target.checkWritable();
        checkOpenConnected();
        {
            boolean var20B3BDB73F0932F2A7B4D5F3626BD9B5_189992316 = (!target.hasRemaining());
        } //End collapsed parenthetic
        int readCount;
        readCount = 0;
        {
            boolean varAD3610F4AB318B3E2F2E2CDF9A9A0813_897252548 = (target.isDirect() || target.hasArray());
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1075205702 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1075205702;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.281 -0400", hash_original_method = "73BDAA1D4D5FBBB4136E79D8CC3B2003", hash_generated_method = "B7680D6DF5E8F6A804C57F1E4E12ECFB")
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
        long var0F5264038205EDFB1AC05FBB0E8C5E94_164200023 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_164200023;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.292 -0400", hash_original_method = "FFB1F44E8E8861E1A9AE8DEADE3707A8", hash_generated_method = "EA0339E89CE3577DF98ABDFBC53C81EE")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1944585971 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1944585971;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.300 -0400", hash_original_method = "EACC5F2E46984D93B58057650609FEF7", hash_generated_method = "4DC25271307E3E399B3178356309732D")
    @Override
    public int write(ByteBuffer src) throws IOException {
        checkNotNull(src);
        checkOpenConnected();
        {
            boolean var78714B40A2AE0B69755CF30C747E39CB_803938345 = (!src.hasRemaining());
        } //End collapsed parenthetic
        int writeCount;
        writeCount = writeImpl(src);
        {
            src.position(src.position() + writeCount);
        } //End block
        addTaint(src.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1296792769 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1296792769;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.300 -0400", hash_original_method = "92D26B18BB75EB8AD284E7DC348B13D6", hash_generated_method = "DA8A9DED86388B54404F6A1738EE9D2E")
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
        long var0F5264038205EDFB1AC05FBB0E8C5E94_196336460 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_196336460;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.301 -0400", hash_original_method = "C5D18F36066EF5A8A32922161E6847D8", hash_generated_method = "0026F47934F45B5C2D676BC3C8A2718F")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406792265 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406792265;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.301 -0400", hash_original_method = "CF8B9D693C24D7742692C737C034E989", hash_generated_method = "7D6C746CE258C1DE1A344771C4B2BE1A")
    @Override
    protected synchronized void implCloseSelectableChannel() throws IOException {
        connected = false;
        {
            boolean varA09DB173CEF278ADC32C70770C281924_1855824913 = (socket != null && !socket.isClosed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.302 -0400", hash_original_method = "B277EC5F8A308E553B57A0D050976387", hash_generated_method = "775F2E2C98F45D9BC9565538C03832B0")
    @Override
    protected void implConfigureBlocking(boolean blocking) throws IOException {
        {
            Object var964C97B960BB46676C47DA572AAFDDC9_366321714 = (blockingLock());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.302 -0400", hash_original_method = "CB491A74BF9C37F6ADAA84B27A2FC899", hash_generated_method = "4944664EA1F1F1162CA6542984929811")
    private void checkOpen() throws IOException {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1809174907 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedChannelException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.303 -0400", hash_original_method = "C4EAE028A2901AB3F43566E69E9E24D8", hash_generated_method = "2C007F41211E4B37A83C57E37C9D1A3F")
    private void checkOpenConnected() throws IOException {
        checkOpen();
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_676286581 = (!isConnected());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.303 -0400", hash_original_method = "DE9BF6E7ACC5E7DCC990C5D950818BC0", hash_generated_method = "6F97918BBEC302691B46FE58BE69F4A6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.307 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "5DE4673CFF4148691E689F2F53D8EB5F")
    public FileDescriptor getFD() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_347364760 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_347364760 = fd;
        varB4EAC82CA7396A68D541C85D26508E83_347364760.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_347364760;
        // ---------- Original Method ----------
        //return fd;
    }

    
    private static class DatagramSocketAdapter extends DatagramSocket {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.307 -0400", hash_original_field = "32CC750E4B8FCA138B4D6BCBE118C5DB", hash_generated_field = "8F599A20342D355936B02DA735AA8136")

        private DatagramChannelImpl channelImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.307 -0400", hash_original_method = "69EFCB277ED141BA204F53D83B183F8E", hash_generated_method = "B4A6337155DD3892E1E5AF63E6CA3F7D")
          DatagramSocketAdapter(DatagramSocketImpl socketimpl,
                DatagramChannelImpl channelImpl) {
            super(socketimpl);
            this.channelImpl = channelImpl;
            addTaint(socketimpl.getTaint());
            // ---------- Original Method ----------
            //this.channelImpl = channelImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.311 -0400", hash_original_method = "272F2E718E0C10B582849935E6BE168A", hash_generated_method = "12A972C7E9EAE33D927D2DB020CC4992")
        @Override
        public DatagramChannel getChannel() {
            DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_1728757352 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1728757352 = channelImpl;
            varB4EAC82CA7396A68D541C85D26508E83_1728757352.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1728757352;
            // ---------- Original Method ----------
            //return channelImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.312 -0400", hash_original_method = "F11CC1C6B1751A820DF0839300E56C28", hash_generated_method = "D75C909829BED0C3E39241E95CFAAAB4")
        @Override
        public boolean isBound() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1852111455 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1852111455;
            // ---------- Original Method ----------
            //return channelImpl.isBound;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.313 -0400", hash_original_method = "EBC91F4CCE587021E0B931D77134C0EB", hash_generated_method = "8396B34E41BF852AE515BA3C049076D2")
        @Override
        public boolean isConnected() {
            boolean var62CA8521E6AF586CA79D70D6CF667F20_1897812054 = (channelImpl.isConnected());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1279177623 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1279177623;
            // ---------- Original Method ----------
            //return channelImpl.isConnected();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.321 -0400", hash_original_method = "F2E78E937EC010AD3CD73E7409B0139F", hash_generated_method = "8BFA57AF67073C3E6A6B1AED5C51DEA7")
        @Override
        public InetAddress getInetAddress() {
            InetAddress varB4EAC82CA7396A68D541C85D26508E83_257906375 = null; //Variable for return #1
            InetAddress varB4EAC82CA7396A68D541C85D26508E83_2060524492 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_257906375 = null;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_2060524492 = channelImpl.connectAddress.getAddress();
            InetAddress varA7E53CE21691AB073D9660D615818899_127000289; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_127000289 = varB4EAC82CA7396A68D541C85D26508E83_257906375;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_127000289 = varB4EAC82CA7396A68D541C85D26508E83_2060524492;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_127000289.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_127000289;
            // ---------- Original Method ----------
            //if (channelImpl.connectAddress == null) {
                //return null;
            //}
            //return channelImpl.connectAddress.getAddress();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.331 -0400", hash_original_method = "2C69EB670D32F39C986C933D03BF3A1E", hash_generated_method = "8EED440F77C0401514544C986E937F9A")
        @Override
        public InetAddress getLocalAddress() {
            InetAddress varB4EAC82CA7396A68D541C85D26508E83_1786832880 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1786832880 = channelImpl.getLocalAddress();
            varB4EAC82CA7396A68D541C85D26508E83_1786832880.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1786832880;
            // ---------- Original Method ----------
            //return channelImpl.getLocalAddress();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.332 -0400", hash_original_method = "4B98C51C8664AA9BAB8C98CDD2BAB4FB", hash_generated_method = "5FB8E1F293818BA8BA6CF0554D724FBA")
        @Override
        public int getPort() {
            int varC574877425F272779C5F02E9439194EF_459584795 = (channelImpl.connectAddress.getPort());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_120145979 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_120145979;
            // ---------- Original Method ----------
            //if (channelImpl.connectAddress == null) {
                //return -1;
            //}
            //return channelImpl.connectAddress.getPort();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.332 -0400", hash_original_method = "42FCE5AEF7C64B9A4F845E086D487D7D", hash_generated_method = "B651409CBB0250A1204FE8699C6A1AD5")
        @Override
        public void bind(SocketAddress localAddr) throws SocketException {
            {
                boolean var4B0E49754C523761E0E44E87B0B6089A_342426704 = (channelImpl.isConnected());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.333 -0400", hash_original_method = "714770E7AF180E6CA35843F3D6FA59F5", hash_generated_method = "B7C0CA859D9B15FC98A51CB88A04F508")
        @Override
        public void receive(DatagramPacket packet) throws IOException {
            {
                boolean varBAE8CEDA21BF2921535BF8B9F4D62736_1605269628 = (!channelImpl.isBlocking());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.347 -0400", hash_original_method = "B8D9E7A66BAFFB4AAB90A90FE956BDD4", hash_generated_method = "3E51857F8A85585FF201069B917D4FCD")
        @Override
        public void send(DatagramPacket packet) throws IOException {
            {
                boolean varBAE8CEDA21BF2921535BF8B9F4D62736_1966989151 = (!channelImpl.isBlocking());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.348 -0400", hash_original_method = "46B266D91BAFA027B87005DE54970890", hash_generated_method = "A65320701E29CDA50BF1E763D842D63D")
        @Override
        public void close() {
            {
                {
                    boolean var732C27B9F7BFDC492915355DF0E33D1C_307407641 = (channelImpl.isOpen());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.349 -0400", hash_original_method = "CD5228FAD6696C7AA890BA57AAC5031A", hash_generated_method = "4C622B878174EC52BA204C445BD3024B")
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

