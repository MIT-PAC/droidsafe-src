package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class DatagramPacket {
    byte[] data;
    int length;
    int capacity;
    InetAddress address;
    int port = -1;
    int offset = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "28D366BE99A6BECEEC6B0BD286389E83", hash_generated_method = "F975EA26C4029189770F06CDEA2BBECB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramPacket(byte[] data, int length) {
        this(data, 0, length);
        dsTaint.addTaint(data);
        dsTaint.addTaint(length);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "4CE5C637B4B89EB1E9EB381D06DF8800", hash_generated_method = "37D969DA995BEC633A2D435B0253DA60")
    @DSModeled(DSC.SAFE)
    public DatagramPacket(byte[] data, int offset, int length) {
        dsTaint.addTaint(data);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        setData(data, offset, length);
        // ---------- Original Method ----------
        //setData(data, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "E7BE9233E3C5340436266F1CA27D4E74", hash_generated_method = "49C00F01DF10E2E118F81371FF438474")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramPacket(byte[] data, int offset, int length,
            InetAddress host, int aPort) {
        this(data, offset, length);
        dsTaint.addTaint(host.dsTaint);
        dsTaint.addTaint(data);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(aPort);
        setPort(aPort);
        // ---------- Original Method ----------
        //setPort(aPort);
        //address = host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "2604ABB8A21562C349D5EE8B9E092E22", hash_generated_method = "728F9F69B2D1F34E16CE8C78EF10F91B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramPacket(byte[] data, int length, InetAddress host, int port) {
        this(data, 0, length, host, port);
        dsTaint.addTaint(port);
        dsTaint.addTaint(host.dsTaint);
        dsTaint.addTaint(data);
        dsTaint.addTaint(length);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "5A348CBDEF8E4CCB182CB7D327F8975B", hash_generated_method = "54BB6EF4A818A230816969CA8720B717")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramPacket(byte[] data, int length, SocketAddress sockAddr) throws SocketException {
        this(data, 0, length);
        dsTaint.addTaint(data);
        dsTaint.addTaint(length);
        dsTaint.addTaint(sockAddr.dsTaint);
        setSocketAddress(sockAddr);
        // ---------- Original Method ----------
        //setSocketAddress(sockAddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "9EFE7F8CACFA39C8DFB2EE9B45B29DD7", hash_generated_method = "758F5DBECDE54A7B5AAF5C3889478BA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramPacket(byte[] data, int offset, int length,
            SocketAddress sockAddr) throws SocketException {
        this(data, offset, length);
        dsTaint.addTaint(data);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(sockAddr.dsTaint);
        setSocketAddress(sockAddr);
        // ---------- Original Method ----------
        //setSocketAddress(sockAddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "CD9F8B5917B21628452C42F8F2B53BBA")
    @DSModeled(DSC.SAFE)
    public synchronized InetAddress getAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "B9E74D06348E60D6DDB9FA9E07D464F9", hash_generated_method = "EE3FFB2A4BFEC03CFCE0891B8E74E5CB")
    @DSModeled(DSC.SAFE)
    public synchronized byte[] getData() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "45D5A71E999F20034B1D39D1DBEBEA58")
    @DSModeled(DSC.SAFE)
    public synchronized int getLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "2F3AA40DF4904EDAB931862C88ED938B")
    @DSModeled(DSC.SAFE)
    public synchronized int getOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "0931E6DAB5A650B8935AC7376A6F2A4B")
    @DSModeled(DSC.SAFE)
    public synchronized int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "C8080B968BD32815251343303FD7866E", hash_generated_method = "2C66557D6E22909781A90692ACB980EE")
    @DSModeled(DSC.SAFE)
    public synchronized void setAddress(InetAddress addr) {
        dsTaint.addTaint(addr.dsTaint);
        // ---------- Original Method ----------
        //address = addr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "5E0274686A01B4FB96908A6A9486BA81", hash_generated_method = "D41A3DA5CED13F502538D6879FE3C24B")
    @DSModeled(DSC.SAFE)
    public synchronized void setData(byte[] data, int offset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(data);
        dsTaint.addTaint(offset);
        {
            throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if ((offset | byteCount) < 0 || offset > data.length || byteCount > data.length - offset) {
            //throw new IllegalArgumentException();
        //}
        //this.data = data;
        //this.offset = offset;
        //this.length = byteCount;
        //this.capacity = byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "90578DC03777F39E5EBE6643D9CBD4FE", hash_generated_method = "85D1096BC89E62ED6CD4EFC33B61DE70")
    @DSModeled(DSC.SAFE)
    public synchronized void setData(byte[] buf) {
        dsTaint.addTaint(buf);
        length = buf.length;
        capacity = buf.length;
        offset = 0;
        // ---------- Original Method ----------
        //length = buf.length;
        //capacity = buf.length;
        //data = buf;
        //offset = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "59C864B14A0070866D297CD091E1F29D", hash_generated_method = "93A3A556D93142092B20B24B799922BA")
    @DSModeled(DSC.SAFE)
    synchronized int getCapacity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return capacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.181 -0400", hash_original_method = "A9C966E60C597F426105F63D3A989F4F", hash_generated_method = "89FE13F8DC6876D5F14240C354ACBBB0")
    @DSModeled(DSC.SAFE)
    public synchronized void setLength(int length) {
        dsTaint.addTaint(length);
        setLengthOnly(length);
        // ---------- Original Method ----------
        //setLengthOnly(length);
        //this.capacity = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.182 -0400", hash_original_method = "78A3DBC65D2912D5EFEBEB58F048F8DC", hash_generated_method = "F06EBE7A4C016ADC3DDCFF3DC56DC207")
    @DSModeled(DSC.SAFE)
    synchronized void setLengthOnly(int length) {
        dsTaint.addTaint(length);
        {
            throw new IndexOutOfBoundsException("length=" + length + ", offset=" + offset +
                    ", buffer size=" + data.length);
        } //End block
        // ---------- Original Method ----------
        //if (length < 0 || offset + length > data.length) {
            //throw new IndexOutOfBoundsException("length=" + length + ", offset=" + offset +
                    //", buffer size=" + data.length);
        //}
        //this.length = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.182 -0400", hash_original_method = "CC3AA0BB5DF3EE4831739014FCB197DF", hash_generated_method = "7F3BA97C248CEC1DFB13806790C6B103")
    @DSModeled(DSC.SAFE)
    public synchronized void setPort(int aPort) {
        dsTaint.addTaint(aPort);
        {
            throw new IllegalArgumentException("Port out of range: " + aPort);
        } //End block
        // ---------- Original Method ----------
        //if (aPort < 0 || aPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + aPort);
        //}
        //port = aPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.182 -0400", hash_original_method = "FA4C710C49AB0B200E625D4A04A47D21", hash_generated_method = "2D37A9DE70D842C767989ED5DDC2B8E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized SocketAddress getSocketAddress() {
        SocketAddress varF9278402F3F133AFA569E2A220FB358A_884298250 = (new InetSocketAddress(getAddress(), getPort()));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new InetSocketAddress(getAddress(), getPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.182 -0400", hash_original_method = "3EDF0F039E2E002F80626A052A7B5C38", hash_generated_method = "999D0B5333D9C05F301869CF7B081DDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSocketAddress(SocketAddress sockAddr) {
        dsTaint.addTaint(sockAddr.dsTaint);
        if(DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException("Socket address not an InetSocketAddress: " +
                    (sockAddr == null ? null : sockAddr.getClass()));
        } //End block
        InetSocketAddress inetAddr;
        inetAddr = (InetSocketAddress) sockAddr;
        {
            boolean varA3B9EEB1EB48BA97910D459B57127264_2108477297 = (inetAddr.isUnresolved());
            if(DroidSafeAndroidRuntime.control) {
                throw new IllegalArgumentException("Socket address unresolved: " + sockAddr);
            } //End block
        } //End collapsed parenthetic
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


