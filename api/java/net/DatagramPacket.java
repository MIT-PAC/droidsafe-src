package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class DatagramPacket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.510 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "B330DF564CD90A5498A9E4F0AB344BB9")

    byte[] data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.510 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "136C4DD872F8065EECD33F6CD4E7556E")

    int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.510 -0400", hash_original_field = "7BD14A231864E618E1840C7E117E59C1", hash_generated_field = "0B1D26332B4020647655E70C20DE6D8D")

    int capacity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.511 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "FDCE7272CFC91A6374FBF7F54D5CC8E4")

    InetAddress address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.511 -0400", hash_original_field = "CAB9CCA4AFFBFB7ECB540E3002763641", hash_generated_field = "BAF684EECB20D799A434AFCF1B13F01D")

    int port = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.511 -0400", hash_original_field = "F13C8B3640CBC13657DAF750F9C8A763", hash_generated_field = "B57AAF7BF5F2E3B125D28448999D0D18")

    int offset = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.511 -0400", hash_original_method = "28D366BE99A6BECEEC6B0BD286389E83", hash_generated_method = "1D4F89C2A210E89F220E3AA25607888D")
    public  DatagramPacket(byte[] data, int length) {
        this(data, 0, length);
        addTaint(length);
        addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.512 -0400", hash_original_method = "4CE5C637B4B89EB1E9EB381D06DF8800", hash_generated_method = "6DEC39FA7ECCB73CB49F20AD0563847E")
    public  DatagramPacket(byte[] data, int offset, int length) {
        addTaint(length);
        addTaint(offset);
        addTaint(data[0]);
        setData(data, offset, length);
        // ---------- Original Method ----------
        //setData(data, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.512 -0400", hash_original_method = "E7BE9233E3C5340436266F1CA27D4E74", hash_generated_method = "144F3839CA37E210F56DBF5DCE5C30BE")
    public  DatagramPacket(byte[] data, int offset, int length,
            InetAddress host, int aPort) {
        this(data, offset, length);
        addTaint(aPort);
        addTaint(length);
        addTaint(offset);
        addTaint(data[0]);
        setPort(aPort);
        address = host;
        // ---------- Original Method ----------
        //setPort(aPort);
        //address = host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.513 -0400", hash_original_method = "2604ABB8A21562C349D5EE8B9E092E22", hash_generated_method = "1CA5D6B1E35072492FD0DB6DF84B751F")
    public  DatagramPacket(byte[] data, int length, InetAddress host, int port) {
        this(data, 0, length, host, port);
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(length);
        addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.513 -0400", hash_original_method = "5A348CBDEF8E4CCB182CB7D327F8975B", hash_generated_method = "7CFE83C69DA3293C7B3E749B3CF2E461")
    public  DatagramPacket(byte[] data, int length, SocketAddress sockAddr) throws SocketException {
        this(data, 0, length);
        addTaint(sockAddr.getTaint());
        addTaint(length);
        addTaint(data[0]);
        setSocketAddress(sockAddr);
        // ---------- Original Method ----------
        //setSocketAddress(sockAddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.514 -0400", hash_original_method = "9EFE7F8CACFA39C8DFB2EE9B45B29DD7", hash_generated_method = "5A0A7C4FEF7F90E6A15AF68FC0BF49F4")
    public  DatagramPacket(byte[] data, int offset, int length,
            SocketAddress sockAddr) throws SocketException {
        this(data, offset, length);
        addTaint(sockAddr.getTaint());
        addTaint(length);
        addTaint(offset);
        addTaint(data[0]);
        setSocketAddress(sockAddr);
        // ---------- Original Method ----------
        //setSocketAddress(sockAddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.514 -0400", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "202F84321EA165D345F9205E8AF747AC")
    public synchronized InetAddress getAddress() {
InetAddress var814577DDD37BAFB17E08CBEFDB411BAE_750542648 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_750542648.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_750542648;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.515 -0400", hash_original_method = "B9E74D06348E60D6DDB9FA9E07D464F9", hash_generated_method = "3320AEC7F42ADE4E379A849942B34452")
    public synchronized byte[] getData() {
        byte[] var8D777F385D3DFEC8815D20F7496026DC_1301930227 = (data);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1124904119 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1124904119;
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.515 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "410842D78D65BB116562653640C4B06D")
    public synchronized int getLength() {
        int var2FA47F7C65FEC19CC163B195725E3844_832958853 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594585513 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594585513;
        // ---------- Original Method ----------
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.516 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "AA72BCD11BB5A774DA9ECDBC76B20446")
    public synchronized int getOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_1801315639 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_771290092 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_771290092;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.516 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "EADBAF92ED4576C142D3C29408E35E3A")
    public synchronized int getPort() {
        int var901555FB06E346CB065CEB9808DCFC25_1512787092 = (port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_214308098 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_214308098;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.517 -0400", hash_original_method = "C8080B968BD32815251343303FD7866E", hash_generated_method = "D8DF36BE09A5C0C183F7A65469BFBDCD")
    public synchronized void setAddress(InetAddress addr) {
        address = addr;
        // ---------- Original Method ----------
        //address = addr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.518 -0400", hash_original_method = "5E0274686A01B4FB96908A6A9486BA81", hash_generated_method = "990A24090F2C61A1D26552E64273235B")
    public synchronized void setData(byte[] data, int offset, int byteCount) {
    if((offset | byteCount) < 0 || offset > data.length || byteCount > data.length - offset)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_25946464 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_25946464.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_25946464;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.519 -0400", hash_original_method = "90578DC03777F39E5EBE6643D9CBD4FE", hash_generated_method = "F1FEFC07A80B686715A77B87B4CF8AB9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.520 -0400", hash_original_method = "59C864B14A0070866D297CD091E1F29D", hash_generated_method = "B08F1460AC9CE86D3366EFCAF33FE7D7")
    synchronized int getCapacity() {
        int var7BD14A231864E618E1840C7E117E59C1_205682587 = (capacity);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833088091 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833088091;
        // ---------- Original Method ----------
        //return capacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.520 -0400", hash_original_method = "A9C966E60C597F426105F63D3A989F4F", hash_generated_method = "14769D57C2658A640AE49D4D8AEDD5C8")
    public synchronized void setLength(int length) {
        setLengthOnly(length);
        this.capacity = length;
        // ---------- Original Method ----------
        //setLengthOnly(length);
        //this.capacity = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.521 -0400", hash_original_method = "78A3DBC65D2912D5EFEBEB58F048F8DC", hash_generated_method = "683E247E8782711AEA73BFBD6957ABF6")
    synchronized void setLengthOnly(int length) {
    if(length < 0 || offset + length > data.length)        
        {
            IndexOutOfBoundsException var262F27E12A9C32D12DC57A578C38084E_275469921 = new IndexOutOfBoundsException("length=" + length + ", offset=" + offset +
                    ", buffer size=" + data.length);
            var262F27E12A9C32D12DC57A578C38084E_275469921.addTaint(taint);
            throw var262F27E12A9C32D12DC57A578C38084E_275469921;
        } //End block
        this.length = length;
        // ---------- Original Method ----------
        //if (length < 0 || offset + length > data.length) {
            //throw new IndexOutOfBoundsException("length=" + length + ", offset=" + offset +
                    //", buffer size=" + data.length);
        //}
        //this.length = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.521 -0400", hash_original_method = "CC3AA0BB5DF3EE4831739014FCB197DF", hash_generated_method = "CDDABBB15974CC2CF9271FDB4A6607D0")
    public synchronized void setPort(int aPort) {
    if(aPort < 0 || aPort > 65535)        
        {
            IllegalArgumentException varBD3B2D468FFD082696C46A032ABFAA1F_322591847 = new IllegalArgumentException("Port out of range: " + aPort);
            varBD3B2D468FFD082696C46A032ABFAA1F_322591847.addTaint(taint);
            throw varBD3B2D468FFD082696C46A032ABFAA1F_322591847;
        } //End block
        port = aPort;
        // ---------- Original Method ----------
        //if (aPort < 0 || aPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + aPort);
        //}
        //port = aPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.522 -0400", hash_original_method = "FA4C710C49AB0B200E625D4A04A47D21", hash_generated_method = "AE84CC8230C0927DC010C8A57E49D463")
    public synchronized SocketAddress getSocketAddress() {
SocketAddress var3731533601FB8E22E4B6038576E63FE5_2064687791 =         new InetSocketAddress(getAddress(), getPort());
        var3731533601FB8E22E4B6038576E63FE5_2064687791.addTaint(taint);
        return var3731533601FB8E22E4B6038576E63FE5_2064687791;
        // ---------- Original Method ----------
        //return new InetSocketAddress(getAddress(), getPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.522 -0400", hash_original_method = "3EDF0F039E2E002F80626A052A7B5C38", hash_generated_method = "DC2338E562E1A9CB9322F96864973F46")
    public synchronized void setSocketAddress(SocketAddress sockAddr) {
        addTaint(sockAddr.getTaint());
    if(!(sockAddr instanceof InetSocketAddress))        
        {
            IllegalArgumentException var6557C2EA5B0CB00A26D2A66FC9689864_1170290516 = new IllegalArgumentException("Socket address not an InetSocketAddress: " +
                    (sockAddr == null ? null : sockAddr.getClass()));
            var6557C2EA5B0CB00A26D2A66FC9689864_1170290516.addTaint(taint);
            throw var6557C2EA5B0CB00A26D2A66FC9689864_1170290516;
        } //End block
        InetSocketAddress inetAddr = (InetSocketAddress) sockAddr;
    if(inetAddr.isUnresolved())        
        {
            IllegalArgumentException varAC5D37D883D53A7A168540FB6F85003B_1004216910 = new IllegalArgumentException("Socket address unresolved: " + sockAddr);
            varAC5D37D883D53A7A168540FB6F85003B_1004216910.addTaint(taint);
            throw varAC5D37D883D53A7A168540FB6F85003B_1004216910;
        } //End block
        port = inetAddr.getPort();
        address = inetAddr.getAddress();
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

