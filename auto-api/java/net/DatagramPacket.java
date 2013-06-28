package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class DatagramPacket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.062 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "B330DF564CD90A5498A9E4F0AB344BB9")

    byte[] data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.062 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "136C4DD872F8065EECD33F6CD4E7556E")

    int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.062 -0400", hash_original_field = "7BD14A231864E618E1840C7E117E59C1", hash_generated_field = "0B1D26332B4020647655E70C20DE6D8D")

    int capacity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.062 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "FDCE7272CFC91A6374FBF7F54D5CC8E4")

    InetAddress address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.062 -0400", hash_original_field = "CAB9CCA4AFFBFB7ECB540E3002763641", hash_generated_field = "BAF684EECB20D799A434AFCF1B13F01D")

    int port = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.062 -0400", hash_original_field = "F13C8B3640CBC13657DAF750F9C8A763", hash_generated_field = "B57AAF7BF5F2E3B125D28448999D0D18")

    int offset = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.063 -0400", hash_original_method = "28D366BE99A6BECEEC6B0BD286389E83", hash_generated_method = "680D3316C97050B00B93729F461B0014")
    public  DatagramPacket(byte[] data, int length) {
        this(data, 0, length);
        addTaint(data[0]);
        addTaint(length);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.063 -0400", hash_original_method = "4CE5C637B4B89EB1E9EB381D06DF8800", hash_generated_method = "1A71A75508258016263AF96C2C5880E8")
    public  DatagramPacket(byte[] data, int offset, int length) {
        setData(data, offset, length);
        addTaint(data[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //setData(data, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.063 -0400", hash_original_method = "E7BE9233E3C5340436266F1CA27D4E74", hash_generated_method = "25F7E90D8666AC624F1DEB759C9E9A68")
    public  DatagramPacket(byte[] data, int offset, int length,
            InetAddress host, int aPort) {
        this(data, offset, length);
        setPort(aPort);
        address = host;
        addTaint(data[0]);
        addTaint(offset);
        addTaint(length);
        addTaint(aPort);
        // ---------- Original Method ----------
        //setPort(aPort);
        //address = host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.064 -0400", hash_original_method = "2604ABB8A21562C349D5EE8B9E092E22", hash_generated_method = "3B069BFCC241478492247D215F88E948")
    public  DatagramPacket(byte[] data, int length, InetAddress host, int port) {
        this(data, 0, length, host, port);
        addTaint(data[0]);
        addTaint(length);
        addTaint(host.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.064 -0400", hash_original_method = "5A348CBDEF8E4CCB182CB7D327F8975B", hash_generated_method = "6FA888666E3ED5B03186DA2BC5CF6B64")
    public  DatagramPacket(byte[] data, int length, SocketAddress sockAddr) throws SocketException {
        this(data, 0, length);
        setSocketAddress(sockAddr);
        addTaint(data[0]);
        addTaint(length);
        addTaint(sockAddr.getTaint());
        // ---------- Original Method ----------
        //setSocketAddress(sockAddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.064 -0400", hash_original_method = "9EFE7F8CACFA39C8DFB2EE9B45B29DD7", hash_generated_method = "2DA87B20476F81110A27ABE3DF29EEF5")
    public  DatagramPacket(byte[] data, int offset, int length,
            SocketAddress sockAddr) throws SocketException {
        this(data, offset, length);
        setSocketAddress(sockAddr);
        addTaint(data[0]);
        addTaint(offset);
        addTaint(length);
        addTaint(sockAddr.getTaint());
        // ---------- Original Method ----------
        //setSocketAddress(sockAddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.065 -0400", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "9B1055BD2C32B22A0FBB1E74D6723790")
    public synchronized InetAddress getAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_479657345 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_479657345 = address;
        varB4EAC82CA7396A68D541C85D26508E83_479657345.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_479657345;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.066 -0400", hash_original_method = "B9E74D06348E60D6DDB9FA9E07D464F9", hash_generated_method = "3A181AA994FD36056C3380CC11E49625")
    public synchronized byte[] getData() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2106106450 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2106106450;
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.067 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "8B5A11FDE3F5DFA17ADC31D0AF83DD3E")
    public synchronized int getLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1246254601 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1246254601;
        // ---------- Original Method ----------
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.068 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "AC2E9696B0D7A37936415A74D8533E58")
    public synchronized int getOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947219239 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947219239;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.068 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "2B138488205F5D62DF061F9365F2473A")
    public synchronized int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765328963 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765328963;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.069 -0400", hash_original_method = "C8080B968BD32815251343303FD7866E", hash_generated_method = "D8DF36BE09A5C0C183F7A65469BFBDCD")
    public synchronized void setAddress(InetAddress addr) {
        address = addr;
        // ---------- Original Method ----------
        //address = addr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.070 -0400", hash_original_method = "5E0274686A01B4FB96908A6A9486BA81", hash_generated_method = "3DFFA060655BF0A4DF0AE324511A5CC2")
    public synchronized void setData(byte[] data, int offset, int byteCount) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        this.data = data;
        this.offset = offset;
        this.length = byteCount;
        this.capacity = byteCount;
        // ---------- Original Method ----------
        //if ((offset | byteCount) < 0 || offset > data.length || byteCount > data.length - offset) {
            //throw new IllegalArgumentException();
        //}
        //this.data = data;
        //this.offset = offset;
        //this.length = byteCount;
        //this.capacity = byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.071 -0400", hash_original_method = "90578DC03777F39E5EBE6643D9CBD4FE", hash_generated_method = "F1FEFC07A80B686715A77B87B4CF8AB9")
    public synchronized void setData(byte[] buf) {
        length = buf.length;
        capacity = buf.length;
        data = buf;
        offset = 0;
        // ---------- Original Method ----------
        //length = buf.length;
        //capacity = buf.length;
        //data = buf;
        //offset = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.071 -0400", hash_original_method = "59C864B14A0070866D297CD091E1F29D", hash_generated_method = "F027F96F5EDC076DF97DA7E55E236AE1")
    synchronized int getCapacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679010460 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679010460;
        // ---------- Original Method ----------
        //return capacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.072 -0400", hash_original_method = "A9C966E60C597F426105F63D3A989F4F", hash_generated_method = "14769D57C2658A640AE49D4D8AEDD5C8")
    public synchronized void setLength(int length) {
        setLengthOnly(length);
        this.capacity = length;
        // ---------- Original Method ----------
        //setLengthOnly(length);
        //this.capacity = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.072 -0400", hash_original_method = "78A3DBC65D2912D5EFEBEB58F048F8DC", hash_generated_method = "82FB4E00862D0049700F5F62DBF823B8")
    synchronized void setLengthOnly(int length) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("length=" + length + ", offset=" + offset +
                    ", buffer size=" + data.length);
        } //End block
        this.length = length;
        // ---------- Original Method ----------
        //if (length < 0 || offset + length > data.length) {
            //throw new IndexOutOfBoundsException("length=" + length + ", offset=" + offset +
                    //", buffer size=" + data.length);
        //}
        //this.length = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.073 -0400", hash_original_method = "CC3AA0BB5DF3EE4831739014FCB197DF", hash_generated_method = "B3D8D9FEC4E07B4DEE6E67158EC79946")
    public synchronized void setPort(int aPort) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Port out of range: " + aPort);
        } //End block
        port = aPort;
        // ---------- Original Method ----------
        //if (aPort < 0 || aPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + aPort);
        //}
        //port = aPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.074 -0400", hash_original_method = "FA4C710C49AB0B200E625D4A04A47D21", hash_generated_method = "276FAE6C64E2E08F79DA68FEF0FEF89A")
    public synchronized SocketAddress getSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_957110569 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_957110569 = new InetSocketAddress(getAddress(), getPort());
        varB4EAC82CA7396A68D541C85D26508E83_957110569.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_957110569;
        // ---------- Original Method ----------
        //return new InetSocketAddress(getAddress(), getPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.074 -0400", hash_original_method = "3EDF0F039E2E002F80626A052A7B5C38", hash_generated_method = "0D6BBEA9C543A244061D88E8BDB26CC5")
    public synchronized void setSocketAddress(SocketAddress sockAddr) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket address not an InetSocketAddress: " +
                    (sockAddr == null ? null : sockAddr.getClass()));
        } //End block
        InetSocketAddress inetAddr = (InetSocketAddress) sockAddr;
        {
            boolean varA3B9EEB1EB48BA97910D459B57127264_654249866 = (inetAddr.isUnresolved());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket address unresolved: " + sockAddr);
            } //End block
        } //End collapsed parenthetic
        port = inetAddr.getPort();
        address = inetAddr.getAddress();
        addTaint(sockAddr.getTaint());
        // ---------- Original Method ----------
        //if (!(sockAddr instanceof InetSocketAddress)) {
            //throw new IllegalArgumentException("Socket address not an InetSocketAddress: " +
                    //(sockAddr == null ? null : sockAddr.getClass()));
        //}
        //InetSocketAddress inetAddr = (InetSocketAddress) sockAddr;
        //if (inetAddr.isUnresolved()) {
            //throw new IllegalArgumentException("Socket address unresolved: " + sockAddr);
        //}
        //port = inetAddr.getPort();
        //address = inetAddr.getAddress();
    }

    
}

