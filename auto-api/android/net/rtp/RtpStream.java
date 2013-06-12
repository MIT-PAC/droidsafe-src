package android.net.rtp;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.SocketException;

public class RtpStream {
    public static final int MODE_NORMAL = 0;
    public static final int MODE_SEND_ONLY = 1;
    public static final int MODE_RECEIVE_ONLY = 2;
    private static final int MODE_LAST = 2;
    private final InetAddress mLocalAddress;
    private final int mLocalPort;
    private InetAddress mRemoteAddress;
    private int mRemotePort = -1;
    private int mMode = MODE_NORMAL;
    private int mNative;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.289 -0400", hash_original_method = "87C78188301D65B3202299E6E894F1D3", hash_generated_method = "0B68E852D8A66325A50A75DE85F506B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     RtpStream(InetAddress address) throws SocketException {
        dsTaint.addTaint(address.dsTaint);
        mLocalPort = create(address.getHostAddress());
        // ---------- Original Method ----------
        //mLocalPort = create(address.getHostAddress());
        //mLocalAddress = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.289 -0400", hash_original_method = "215B56CAD65C08D01C00FD356B52B803", hash_generated_method = "BDD7A9B04A8631DFBA1EF43732640534")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int create(String address) throws SocketException {
        dsTaint.addTaint(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.289 -0400", hash_original_method = "F28BFDFF195309DBD86E5144551EE7AD", hash_generated_method = "2A7ABC15D0EE54FF73672598D39BAA07")
    @DSModeled(DSC.SAFE)
    public InetAddress getLocalAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLocalAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.289 -0400", hash_original_method = "7C31E9E70AC59EA03FD32B04D9A6DCA9", hash_generated_method = "A73204D272AED0FD011A934B99239B65")
    @DSModeled(DSC.SAFE)
    public int getLocalPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLocalPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.289 -0400", hash_original_method = "DA9171B440EA3ADB706340063F8102C7", hash_generated_method = "D1441B018CBCFF66951D52E39DF587EA")
    @DSModeled(DSC.SAFE)
    public InetAddress getRemoteAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRemoteAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.289 -0400", hash_original_method = "B0A2085CD61C2E0240384F40F555D7FA", hash_generated_method = "9DA4192216989651CEBA59670954E0B9")
    @DSModeled(DSC.SAFE)
    public int getRemotePort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRemotePort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.289 -0400", hash_original_method = "4ACBB08C3FA83B75B554974AB7F8953B", hash_generated_method = "CF6FABFF38CCC0D68116699C9D095F35")
    @DSModeled(DSC.SAFE)
    public boolean isBusy() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.290 -0400", hash_original_method = "46CDEAEE57FC46504BB8BB611AFCF88D", hash_generated_method = "CD5645CD4FC965CE17B38E67F6DA3C8D")
    @DSModeled(DSC.SAFE)
    public int getMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.290 -0400", hash_original_method = "343CDE7B48421898D79FEBC0BB9BBA38", hash_generated_method = "9B8B1687164A3F6A9921006FD127F973")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMode(int mode) {
        dsTaint.addTaint(mode);
        {
            boolean var6331CCDC5360782724F2E909851BBC53_621666520 = (isBusy());
            {
                throw new IllegalStateException("Busy");
            } //End block
        } //End collapsed parenthetic
        {
            throw new IllegalArgumentException("Invalid mode");
        } //End block
        // ---------- Original Method ----------
        //if (isBusy()) {
            //throw new IllegalStateException("Busy");
        //}
        //if (mode < 0 || mode > MODE_LAST) {
            //throw new IllegalArgumentException("Invalid mode");
        //}
        //mMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.290 -0400", hash_original_method = "F6EBFCAAEA10AE181CE86DC5E6420909", hash_generated_method = "71B418BB0D32AAD0A87BF0CD0429EF14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void associate(InetAddress address, int port) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        {
            boolean var6331CCDC5360782724F2E909851BBC53_733455746 = (isBusy());
            {
                throw new IllegalStateException("Busy");
            } //End block
        } //End collapsed parenthetic
        {
            throw new IllegalArgumentException("Unsupported address");
        } //End block
        {
            throw new IllegalArgumentException("Invalid port");
        } //End block
        // ---------- Original Method ----------
        //if (isBusy()) {
            //throw new IllegalStateException("Busy");
        //}
        //if (!(address instanceof Inet4Address && mLocalAddress instanceof Inet4Address) &&
                //!(address instanceof Inet6Address && mLocalAddress instanceof Inet6Address)) {
            //throw new IllegalArgumentException("Unsupported address");
        //}
        //if (port < 0 || port > 65535) {
            //throw new IllegalArgumentException("Invalid port");
        //}
        //mRemoteAddress = address;
        //mRemotePort = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.290 -0400", hash_original_method = "CADBAA67E59C58F3A263DE6FDC241D82", hash_generated_method = "F8D7B473034A3CCF9997801293E3E984")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized int dup() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.290 -0400", hash_original_method = "A307AB09C854328394617118B8488FB4", hash_generated_method = "E5987AC0483CC22C5EF3CCD0E58A1A62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void release() {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_1781876265 = (isBusy());
            {
                throw new IllegalStateException("Busy");
            } //End block
        } //End collapsed parenthetic
        close();
        // ---------- Original Method ----------
        //if (isBusy()) {
            //throw new IllegalStateException("Busy");
        //}
        //close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.290 -0400", hash_original_method = "D50D7BA65C2BEB3EB436584B5735F108", hash_generated_method = "D373D7DC2FEA4AAD1207C8C3C09FE32F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void close() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.290 -0400", hash_original_method = "2E21A04735F7B7DFBA8D51C21EAA3D5C", hash_generated_method = "640FA98E6CE6063601C34A885366E5FA")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
        // ---------- Original Method ----------
        //close();
        //super.finalize();
    }

    
    static {
        System.loadLibrary("rtp_jni");
    }
    
}


