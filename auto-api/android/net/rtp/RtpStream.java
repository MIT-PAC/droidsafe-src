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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.110 -0400", hash_original_field = "AEC676A62769961F07AC33D7BA6C9B77", hash_generated_field = "82E160F333ECBB4C3723A32F659FDA5C")

    private InetAddress mLocalAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.119 -0400", hash_original_field = "8AA7B8C7AB1C5C520C43F0E33D5A33C0", hash_generated_field = "BAE743184ACBAA6741F9878C5CDE5973")

    private int mLocalPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.120 -0400", hash_original_field = "D774A49E336375969EA7C4F7614D9718", hash_generated_field = "CF6A95AED4B072ED0D692D0D05C9CA47")

    private InetAddress mRemoteAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.120 -0400", hash_original_field = "AEC2DEBB988798EDEBE724E13AC04FED", hash_generated_field = "A2AF795CC22BFE09F7BFD08F3E1E84C6")

    private int mRemotePort = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.120 -0400", hash_original_field = "6138C6824A13D1400A2A8723CFBDD347", hash_generated_field = "55D1610407B18FD2194387A7F965838E")

    private int mMode = MODE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.120 -0400", hash_original_field = "8AF77D45DED615EEBE14D961B1D7F7CE", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private int mNative;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.122 -0400", hash_original_method = "87C78188301D65B3202299E6E894F1D3", hash_generated_method = "0EBA38681CA047929975CD0AC8F8B93A")
      RtpStream(InetAddress address) throws SocketException {
        mLocalPort = create(address.getHostAddress());
        mLocalAddress = address;
        // ---------- Original Method ----------
        //mLocalPort = create(address.getHostAddress());
        //mLocalAddress = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.122 -0400", hash_original_method = "215B56CAD65C08D01C00FD356B52B803", hash_generated_method = "7EE2BE671238B751A5B959857835C770")
    private int create(String address) throws SocketException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2010335035 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2010335035;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.122 -0400", hash_original_method = "F28BFDFF195309DBD86E5144551EE7AD", hash_generated_method = "BFC2FB070E1CE186D7E4E414F7C1F255")
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1049459694 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1049459694 = mLocalAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1049459694.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1049459694;
        // ---------- Original Method ----------
        //return mLocalAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.123 -0400", hash_original_method = "7C31E9E70AC59EA03FD32B04D9A6DCA9", hash_generated_method = "651A454559D2EBB40D5752D47535982C")
    public int getLocalPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_388498783 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_388498783;
        // ---------- Original Method ----------
        //return mLocalPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.144 -0400", hash_original_method = "DA9171B440EA3ADB706340063F8102C7", hash_generated_method = "775A5770CB6A84FDAB72B9402EC8C76B")
    public InetAddress getRemoteAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1192902580 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1192902580 = mRemoteAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1192902580.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1192902580;
        // ---------- Original Method ----------
        //return mRemoteAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.149 -0400", hash_original_method = "B0A2085CD61C2E0240384F40F555D7FA", hash_generated_method = "C307D9A9C4629D6F6E838DBD709B53AB")
    public int getRemotePort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261019669 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261019669;
        // ---------- Original Method ----------
        //return mRemotePort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.153 -0400", hash_original_method = "4ACBB08C3FA83B75B554974AB7F8953B", hash_generated_method = "F2BE2189AF0ECC3717B66D13136B364E")
    public boolean isBusy() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_504657225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_504657225;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.153 -0400", hash_original_method = "46CDEAEE57FC46504BB8BB611AFCF88D", hash_generated_method = "8DC853A453DAF37FCF3CC486E3B2CF8E")
    public int getMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1476194706 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1476194706;
        // ---------- Original Method ----------
        //return mMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.155 -0400", hash_original_method = "343CDE7B48421898D79FEBC0BB9BBA38", hash_generated_method = "41382558389DBF5380778D2B9F43F096")
    public void setMode(int mode) {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_212756035 = (isBusy());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Busy");
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid mode");
        } //End block
        mMode = mode;
        // ---------- Original Method ----------
        //if (isBusy()) {
            //throw new IllegalStateException("Busy");
        //}
        //if (mode < 0 || mode > MODE_LAST) {
            //throw new IllegalArgumentException("Invalid mode");
        //}
        //mMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.156 -0400", hash_original_method = "F6EBFCAAEA10AE181CE86DC5E6420909", hash_generated_method = "F045B95926350010CF16B5B5A0BEC2F0")
    public void associate(InetAddress address, int port) {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_1483511321 = (isBusy());
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
        mRemoteAddress = address;
        mRemotePort = port;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.172 -0400", hash_original_method = "CADBAA67E59C58F3A263DE6FDC241D82", hash_generated_method = "9980D9472B7F8BCF26A7F25C3F5D1D67")
    synchronized int dup() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1228928906 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1228928906;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.172 -0400", hash_original_method = "A307AB09C854328394617118B8488FB4", hash_generated_method = "6FAD99B936A934FA5C814F77CFD76286")
    public void release() {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_1552045288 = (isBusy());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.173 -0400", hash_original_method = "D50D7BA65C2BEB3EB436584B5735F108", hash_generated_method = "9DCF3C990963C60F39E50E126C7A13BB")
    private synchronized void close() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.173 -0400", hash_original_method = "2E21A04735F7B7DFBA8D51C21EAA3D5C", hash_generated_method = "1739E6BBD03654B983B913F30B6E5FDA")
    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
        // ---------- Original Method ----------
        //close();
        //super.finalize();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.173 -0400", hash_original_field = "E418210C7EF9D38349B407A10538481B", hash_generated_field = "3DEED3F3E236ECDEF49ABC73C5FEF55B")

    public static final int MODE_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.182 -0400", hash_original_field = "89160F7CCB068DE6FC244A87C2777D90", hash_generated_field = "5C78E1023A7A1CA7A0757CCCEAB06692")

    public static final int MODE_SEND_ONLY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.182 -0400", hash_original_field = "F833B4107ED8CF99E5D1B1962D178F0E", hash_generated_field = "251C5A7A5DC286AB55E869C7AB25D149")

    public static final int MODE_RECEIVE_ONLY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.182 -0400", hash_original_field = "8EEAD0F5D62556AB9EB4B1D05B84AF10", hash_generated_field = "4C0D482D5ED84DEE231DD5B361B3ABD0")

    private static int MODE_LAST = 2;
    static {
        System.loadLibrary("rtp_jni");
    }
    
}

