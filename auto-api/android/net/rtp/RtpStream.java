package android.net.rtp;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.SocketException;

public class RtpStream {
    private InetAddress mLocalAddress;
    private int mLocalPort;
    private InetAddress mRemoteAddress;
    private int mRemotePort = -1;
    private int mMode = MODE_NORMAL;
    private int mNative;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.143 -0400", hash_original_method = "87C78188301D65B3202299E6E894F1D3", hash_generated_method = "B0A09F230682FD17F932C96116A5ADBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     RtpStream(InetAddress address) throws SocketException {
        dsTaint.addTaint(address.dsTaint);
        mLocalPort = create(address.getHostAddress());
        // ---------- Original Method ----------
        //mLocalPort = create(address.getHostAddress());
        //mLocalAddress = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.143 -0400", hash_original_method = "215B56CAD65C08D01C00FD356B52B803", hash_generated_method = "B4D7534360A7E4BC84A075C60859E25A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int create(String address) throws SocketException {
        dsTaint.addTaint(address);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.143 -0400", hash_original_method = "F28BFDFF195309DBD86E5144551EE7AD", hash_generated_method = "8FAB154493BF56FCCD34BD5BD457DC12")
    @DSModeled(DSC.SAFE)
    public InetAddress getLocalAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLocalAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.144 -0400", hash_original_method = "7C31E9E70AC59EA03FD32B04D9A6DCA9", hash_generated_method = "D225A2784A0A3F92C6EB3613779A9760")
    @DSModeled(DSC.SAFE)
    public int getLocalPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLocalPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.144 -0400", hash_original_method = "DA9171B440EA3ADB706340063F8102C7", hash_generated_method = "C6B8DB6609EA499B78469D0CB96E9DB2")
    @DSModeled(DSC.SAFE)
    public InetAddress getRemoteAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRemoteAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.144 -0400", hash_original_method = "B0A2085CD61C2E0240384F40F555D7FA", hash_generated_method = "4265015F10BB0D0CD02C3F4F71B64453")
    @DSModeled(DSC.SAFE)
    public int getRemotePort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRemotePort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.144 -0400", hash_original_method = "4ACBB08C3FA83B75B554974AB7F8953B", hash_generated_method = "5E661F8C6E5D0CCF97B2EA62D33879A3")
    @DSModeled(DSC.SAFE)
    public boolean isBusy() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.145 -0400", hash_original_method = "46CDEAEE57FC46504BB8BB611AFCF88D", hash_generated_method = "1B0905CC702C46C8C3A70BD6A436C7FD")
    @DSModeled(DSC.SAFE)
    public int getMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.145 -0400", hash_original_method = "343CDE7B48421898D79FEBC0BB9BBA38", hash_generated_method = "76C299B099B64992041B5DEE7E9803AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMode(int mode) {
        dsTaint.addTaint(mode);
        {
            boolean var6331CCDC5360782724F2E909851BBC53_208966847 = (isBusy());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Busy");
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid mode");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.145 -0400", hash_original_method = "F6EBFCAAEA10AE181CE86DC5E6420909", hash_generated_method = "C7D096770817BC55D3AE545A456D0DFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void associate(InetAddress address, int port) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        {
            boolean var6331CCDC5360782724F2E909851BBC53_733193791 = (isBusy());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Busy");
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unsupported address");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid port");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.146 -0400", hash_original_method = "CADBAA67E59C58F3A263DE6FDC241D82", hash_generated_method = "B6B77D612BEE423233AFA2964B627D35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized int dup() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.146 -0400", hash_original_method = "A307AB09C854328394617118B8488FB4", hash_generated_method = "2665155B3A5B96D46D3035F79F297ADC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void release() {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_628702123 = (isBusy());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Busy");
            } //End block
        } //End collapsed parenthetic
        close();
        // ---------- Original Method ----------
        //if (isBusy()) {
            //throw new IllegalStateException("Busy");
        //}
        //close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.146 -0400", hash_original_method = "D50D7BA65C2BEB3EB436584B5735F108", hash_generated_method = "9DCF3C990963C60F39E50E126C7A13BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void close() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.146 -0400", hash_original_method = "2E21A04735F7B7DFBA8D51C21EAA3D5C", hash_generated_method = "1739E6BBD03654B983B913F30B6E5FDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
        // ---------- Original Method ----------
        //close();
        //super.finalize();
    }

    
    public static final int MODE_NORMAL = 0;
    public static final int MODE_SEND_ONLY = 1;
    public static final int MODE_RECEIVE_ONLY = 2;
    private static final int MODE_LAST = 2;
    static {
        System.loadLibrary("rtp_jni");
    }
    
}

