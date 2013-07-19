package java.net;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class DatagramPacket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.350 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "B330DF564CD90A5498A9E4F0AB344BB9")

    byte[] data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.350 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "136C4DD872F8065EECD33F6CD4E7556E")

    int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.350 -0400", hash_original_field = "7BD14A231864E618E1840C7E117E59C1", hash_generated_field = "0B1D26332B4020647655E70C20DE6D8D")

    int capacity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.350 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "FDCE7272CFC91A6374FBF7F54D5CC8E4")

    InetAddress address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.350 -0400", hash_original_field = "CAB9CCA4AFFBFB7ECB540E3002763641", hash_generated_field = "BAF684EECB20D799A434AFCF1B13F01D")

    int port = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.350 -0400", hash_original_field = "F13C8B3640CBC13657DAF750F9C8A763", hash_generated_field = "B57AAF7BF5F2E3B125D28448999D0D18")

    int offset = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.350 -0400", hash_original_method = "28D366BE99A6BECEEC6B0BD286389E83", hash_generated_method = "1D4F89C2A210E89F220E3AA25607888D")
    public  DatagramPacket(byte[] data, int length) {
        this(data, 0, length);
        addTaint(length);
        addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.351 -0400", hash_original_method = "4CE5C637B4B89EB1E9EB381D06DF8800", hash_generated_method = "6DEC39FA7ECCB73CB49F20AD0563847E")
    public  DatagramPacket(byte[] data, int offset, int length) {
        addTaint(length);
        addTaint(offset);
        addTaint(data[0]);
        setData(data, offset, length);
        // ---------- Original Method ----------
        //setData(data, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.351 -0400", hash_original_method = "E7BE9233E3C5340436266F1CA27D4E74", hash_generated_method = "144F3839CA37E210F56DBF5DCE5C30BE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.352 -0400", hash_original_method = "2604ABB8A21562C349D5EE8B9E092E22", hash_generated_method = "1CA5D6B1E35072492FD0DB6DF84B751F")
    public  DatagramPacket(byte[] data, int length, InetAddress host, int port) {
        this(data, 0, length, host, port);
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(length);
        addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.353 -0400", hash_original_method = "5A348CBDEF8E4CCB182CB7D327F8975B", hash_generated_method = "7CFE83C69DA3293C7B3E749B3CF2E461")
    public  DatagramPacket(byte[] data, int length, SocketAddress sockAddr) throws SocketException {
        this(data, 0, length);
        addTaint(sockAddr.getTaint());
        addTaint(length);
        addTaint(data[0]);
        setSocketAddress(sockAddr);
        // ---------- Original Method ----------
        //setSocketAddress(sockAddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.353 -0400", hash_original_method = "9EFE7F8CACFA39C8DFB2EE9B45B29DD7", hash_generated_method = "5A0A7C4FEF7F90E6A15AF68FC0BF49F4")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.353 -0400", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "162B355E839C6E5C4C6438C95AEFD421")
    public synchronized InetAddress getAddress() {
InetAddress var814577DDD37BAFB17E08CBEFDB411BAE_640955609 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_640955609.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_640955609;
        // ---------- Original Method ----------
        //return address;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.354 -0400", hash_original_method = "B9E74D06348E60D6DDB9FA9E07D464F9", hash_generated_method = "EF113468FE14F6E571C8A271E7A839FC")
    public synchronized byte[] getData() {
        byte[] var8D777F385D3DFEC8815D20F7496026DC_472714645 = (data);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1737867344 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1737867344;
        // ---------- Original Method ----------
        //return data;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.354 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "79A80F433378B2513E220473A59962E6")
    public synchronized int getLength() {
        int var2FA47F7C65FEC19CC163B195725E3844_1368374224 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_588337657 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_588337657;
        // ---------- Original Method ----------
        //return length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.354 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "5126F74D5E4FFEB87F67BB885237FBBA")
    public synchronized int getOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_422767767 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_252929262 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_252929262;
        // ---------- Original Method ----------
        //return offset;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.355 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "6A1D03AE0953600CB29D2D06F0F2D12B")
    public synchronized int getPort() {
        int var901555FB06E346CB065CEB9808DCFC25_2039109843 = (port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_18868611 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_18868611;
        // ---------- Original Method ----------
        //return port;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.355 -0400", hash_original_method = "C8080B968BD32815251343303FD7866E", hash_generated_method = "D8DF36BE09A5C0C183F7A65469BFBDCD")
    public synchronized void setAddress(InetAddress addr) {
        address = addr;
        // ---------- Original Method ----------
        //address = addr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.356 -0400", hash_original_method = "5E0274686A01B4FB96908A6A9486BA81", hash_generated_method = "548A06BE3E6BB656E93D3416950E7E61")
    public synchronized void setData(byte[] data, int offset, int byteCount) {
        if((offset | byteCount) < 0 || offset > data.length || byteCount > data.length - offset)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1194121310 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1194121310.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1194121310;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.357 -0400", hash_original_method = "90578DC03777F39E5EBE6643D9CBD4FE", hash_generated_method = "F1FEFC07A80B686715A77B87B4CF8AB9")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.357 -0400", hash_original_method = "59C864B14A0070866D297CD091E1F29D", hash_generated_method = "B4E9006B57AF424CEB9B56B88E70988F")
    synchronized int getCapacity() {
        int var7BD14A231864E618E1840C7E117E59C1_439158791 = (capacity);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_630046674 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_630046674;
        // ---------- Original Method ----------
        //return capacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.358 -0400", hash_original_method = "A9C966E60C597F426105F63D3A989F4F", hash_generated_method = "14769D57C2658A640AE49D4D8AEDD5C8")
    public synchronized void setLength(int length) {
        setLengthOnly(length);
        this.capacity = length;
        // ---------- Original Method ----------
        //setLengthOnly(length);
        //this.capacity = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.358 -0400", hash_original_method = "78A3DBC65D2912D5EFEBEB58F048F8DC", hash_generated_method = "47C281C9368B8A3717DA2A399026A713")
    synchronized void setLengthOnly(int length) {
        if(length < 0 || offset + length > data.length)        
        {
            IndexOutOfBoundsException var262F27E12A9C32D12DC57A578C38084E_1328824071 = new IndexOutOfBoundsException("length=" + length + ", offset=" + offset +
                    ", buffer size=" + data.length);
            var262F27E12A9C32D12DC57A578C38084E_1328824071.addTaint(taint);
            throw var262F27E12A9C32D12DC57A578C38084E_1328824071;
        } //End block
        this.length = length;
        // ---------- Original Method ----------
        //if (length < 0 || offset + length > data.length) {
            //throw new IndexOutOfBoundsException("length=" + length + ", offset=" + offset +
                    //", buffer size=" + data.length);
        //}
        //this.length = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.359 -0400", hash_original_method = "CC3AA0BB5DF3EE4831739014FCB197DF", hash_generated_method = "C9C8C97E8D3AD49B536EB16F1C2C6520")
    public synchronized void setPort(int aPort) {
        if(aPort < 0 || aPort > 65535)        
        {
            IllegalArgumentException varBD3B2D468FFD082696C46A032ABFAA1F_1392360921 = new IllegalArgumentException("Port out of range: " + aPort);
            varBD3B2D468FFD082696C46A032ABFAA1F_1392360921.addTaint(taint);
            throw varBD3B2D468FFD082696C46A032ABFAA1F_1392360921;
        } //End block
        port = aPort;
        // ---------- Original Method ----------
        //if (aPort < 0 || aPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + aPort);
        //}
        //port = aPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.359 -0400", hash_original_method = "FA4C710C49AB0B200E625D4A04A47D21", hash_generated_method = "3821068C6636ABB1D90E2179E6A841E7")
    public synchronized SocketAddress getSocketAddress() {
SocketAddress var3731533601FB8E22E4B6038576E63FE5_1934906231 =         new InetSocketAddress(getAddress(), getPort());
        var3731533601FB8E22E4B6038576E63FE5_1934906231.addTaint(taint);
        return var3731533601FB8E22E4B6038576E63FE5_1934906231;
        // ---------- Original Method ----------
        //return new InetSocketAddress(getAddress(), getPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.360 -0400", hash_original_method = "3EDF0F039E2E002F80626A052A7B5C38", hash_generated_method = "D5B5992624FDA97D5D4567B44D7B523D")
    public synchronized void setSocketAddress(SocketAddress sockAddr) {
        addTaint(sockAddr.getTaint());
        if(!(sockAddr instanceof InetSocketAddress))        
        {
            IllegalArgumentException var6557C2EA5B0CB00A26D2A66FC9689864_1899017744 = new IllegalArgumentException("Socket address not an InetSocketAddress: " +
                    (sockAddr == null ? null : sockAddr.getClass()));
            var6557C2EA5B0CB00A26D2A66FC9689864_1899017744.addTaint(taint);
            throw var6557C2EA5B0CB00A26D2A66FC9689864_1899017744;
        } //End block
        InetSocketAddress inetAddr = (InetSocketAddress) sockAddr;
        if(inetAddr.isUnresolved())        
        {
            IllegalArgumentException varAC5D37D883D53A7A168540FB6F85003B_1215788944 = new IllegalArgumentException("Socket address unresolved: " + sockAddr);
            varAC5D37D883D53A7A168540FB6F85003B_1215788944.addTaint(taint);
            throw varAC5D37D883D53A7A168540FB6F85003B_1215788944;
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

