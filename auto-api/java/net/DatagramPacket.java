package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class DatagramPacket {
    byte[] data;
    int length;
    int capacity;
    InetAddress address;
    int port = -1;
    int offset = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.758 -0400", hash_original_method = "28D366BE99A6BECEEC6B0BD286389E83", hash_generated_method = "213C7CFD14AB4CBF53B87B755BB39E75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramPacket(byte[] data, int length) {
        this(data, 0, length);
        dsTaint.addTaint(length);
        dsTaint.addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.759 -0400", hash_original_method = "4CE5C637B4B89EB1E9EB381D06DF8800", hash_generated_method = "4E7AA9727A447E7698AA77AC0DF82EE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramPacket(byte[] data, int offset, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(offset);
        setData(data, offset, length);
        // ---------- Original Method ----------
        //setData(data, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.759 -0400", hash_original_method = "E7BE9233E3C5340436266F1CA27D4E74", hash_generated_method = "34F342BF4ACA83D8DCC8D3F077675252")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramPacket(byte[] data, int offset, int length,
            InetAddress host, int aPort) {
        this(data, offset, length);
        dsTaint.addTaint(host.dsTaint);
        dsTaint.addTaint(length);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(aPort);
        setPort(aPort);
        // ---------- Original Method ----------
        //setPort(aPort);
        //address = host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.759 -0400", hash_original_method = "2604ABB8A21562C349D5EE8B9E092E22", hash_generated_method = "B114E110ABF50C0C48FB15008234F5D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramPacket(byte[] data, int length, InetAddress host, int port) {
        this(data, 0, length, host, port);
        dsTaint.addTaint(port);
        dsTaint.addTaint(host.dsTaint);
        dsTaint.addTaint(length);
        dsTaint.addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.759 -0400", hash_original_method = "5A348CBDEF8E4CCB182CB7D327F8975B", hash_generated_method = "B70E8A6AC9ABD2478C365E81E09883DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramPacket(byte[] data, int length, SocketAddress sockAddr) throws SocketException {
        this(data, 0, length);
        dsTaint.addTaint(length);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(sockAddr.dsTaint);
        setSocketAddress(sockAddr);
        // ---------- Original Method ----------
        //setSocketAddress(sockAddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.759 -0400", hash_original_method = "9EFE7F8CACFA39C8DFB2EE9B45B29DD7", hash_generated_method = "940EBCBCD23E80F31836048FCF4246DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramPacket(byte[] data, int offset, int length,
            SocketAddress sockAddr) throws SocketException {
        this(data, offset, length);
        dsTaint.addTaint(length);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(sockAddr.dsTaint);
        dsTaint.addTaint(offset);
        setSocketAddress(sockAddr);
        // ---------- Original Method ----------
        //setSocketAddress(sockAddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.759 -0400", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "8C80C3A4AE44C2272B726DBAE75657C3")
    @DSModeled(DSC.SAFE)
    public synchronized InetAddress getAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.759 -0400", hash_original_method = "B9E74D06348E60D6DDB9FA9E07D464F9", hash_generated_method = "C172B09F4F1930715D157498A083DD8F")
    @DSModeled(DSC.SAFE)
    public synchronized byte[] getData() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.760 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "C514386F405D8F59F1441503BEBE2D3B")
    @DSModeled(DSC.SAFE)
    public synchronized int getLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.760 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "E27921F6C1C4626BF7BB439075FBF74A")
    @DSModeled(DSC.SAFE)
    public synchronized int getOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.760 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "A8C2963BFDC493D144311DCFBA41B69F")
    @DSModeled(DSC.SAFE)
    public synchronized int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.760 -0400", hash_original_method = "C8080B968BD32815251343303FD7866E", hash_generated_method = "E9C5C36029B18E9924873388D0D7282A")
    @DSModeled(DSC.SAFE)
    public synchronized void setAddress(InetAddress addr) {
        dsTaint.addTaint(addr.dsTaint);
        // ---------- Original Method ----------
        //address = addr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.761 -0400", hash_original_method = "5E0274686A01B4FB96908A6A9486BA81", hash_generated_method = "276DD1EAFC05CA39B89601131C8DBED4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setData(byte[] data, int offset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(offset);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.761 -0400", hash_original_method = "90578DC03777F39E5EBE6643D9CBD4FE", hash_generated_method = "91E1B8AC76DEA9AD664CC58BA17C428C")
    @DSModeled(DSC.SAFE)
    public synchronized void setData(byte[] buf) {
        dsTaint.addTaint(buf[0]);
        length = buf.length;
        capacity = buf.length;
        offset = 0;
        // ---------- Original Method ----------
        //length = buf.length;
        //capacity = buf.length;
        //data = buf;
        //offset = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.761 -0400", hash_original_method = "59C864B14A0070866D297CD091E1F29D", hash_generated_method = "715B04C9317B232E11CEFB78539B81A6")
    @DSModeled(DSC.SAFE)
    synchronized int getCapacity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return capacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.761 -0400", hash_original_method = "A9C966E60C597F426105F63D3A989F4F", hash_generated_method = "1938A603D4417801BEFD8DC7D420847D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setLength(int length) {
        dsTaint.addTaint(length);
        setLengthOnly(length);
        // ---------- Original Method ----------
        //setLengthOnly(length);
        //this.capacity = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.761 -0400", hash_original_method = "78A3DBC65D2912D5EFEBEB58F048F8DC", hash_generated_method = "D53E6E9F28D721EC521EEB79D4DE388C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void setLengthOnly(int length) {
        dsTaint.addTaint(length);
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("length=" + length + ", offset=" + offset +
                    ", buffer size=" + data.length);
        } //End block
        // ---------- Original Method ----------
        //if (length < 0 || offset + length > data.length) {
            //throw new IndexOutOfBoundsException("length=" + length + ", offset=" + offset +
                    //", buffer size=" + data.length);
        //}
        //this.length = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.762 -0400", hash_original_method = "CC3AA0BB5DF3EE4831739014FCB197DF", hash_generated_method = "DBCC0CE1516E36AE862103E71DEDEF4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setPort(int aPort) {
        dsTaint.addTaint(aPort);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Port out of range: " + aPort);
        } //End block
        // ---------- Original Method ----------
        //if (aPort < 0 || aPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + aPort);
        //}
        //port = aPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.762 -0400", hash_original_method = "FA4C710C49AB0B200E625D4A04A47D21", hash_generated_method = "BE1CDCCD273689AF863AF8F5C5C711CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized SocketAddress getSocketAddress() {
        SocketAddress varF9278402F3F133AFA569E2A220FB358A_705452015 = (new InetSocketAddress(getAddress(), getPort()));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new InetSocketAddress(getAddress(), getPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.762 -0400", hash_original_method = "3EDF0F039E2E002F80626A052A7B5C38", hash_generated_method = "F4906047B1E39573BF2A98BD16BE487D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSocketAddress(SocketAddress sockAddr) {
        dsTaint.addTaint(sockAddr.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket address not an InetSocketAddress: " +
                    (sockAddr == null ? null : sockAddr.getClass()));
        } //End block
        InetSocketAddress inetAddr;
        inetAddr = (InetSocketAddress) sockAddr;
        {
            boolean varA3B9EEB1EB48BA97910D459B57127264_851407675 = (inetAddr.isUnresolved());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket address unresolved: " + sockAddr);
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

