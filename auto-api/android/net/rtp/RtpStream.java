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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.301 -0400", hash_original_field = "AEC676A62769961F07AC33D7BA6C9B77", hash_generated_field = "82E160F333ECBB4C3723A32F659FDA5C")

    private InetAddress mLocalAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.302 -0400", hash_original_field = "8AA7B8C7AB1C5C520C43F0E33D5A33C0", hash_generated_field = "BAE743184ACBAA6741F9878C5CDE5973")

    private int mLocalPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.302 -0400", hash_original_field = "D774A49E336375969EA7C4F7614D9718", hash_generated_field = "CF6A95AED4B072ED0D692D0D05C9CA47")

    private InetAddress mRemoteAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.302 -0400", hash_original_field = "AEC2DEBB988798EDEBE724E13AC04FED", hash_generated_field = "A2AF795CC22BFE09F7BFD08F3E1E84C6")

    private int mRemotePort = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.302 -0400", hash_original_field = "6138C6824A13D1400A2A8723CFBDD347", hash_generated_field = "55D1610407B18FD2194387A7F965838E")

    private int mMode = MODE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.302 -0400", hash_original_field = "8AF77D45DED615EEBE14D961B1D7F7CE", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private int mNative;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.303 -0400", hash_original_method = "87C78188301D65B3202299E6E894F1D3", hash_generated_method = "0EBA38681CA047929975CD0AC8F8B93A")
      RtpStream(InetAddress address) throws SocketException {
        mLocalPort = create(address.getHostAddress());
        mLocalAddress = address;
        // ---------- Original Method ----------
        //mLocalPort = create(address.getHostAddress());
        //mLocalAddress = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.303 -0400", hash_original_method = "215B56CAD65C08D01C00FD356B52B803", hash_generated_method = "688B45CC41032303D6745738C1FAE5ED")
    private int create(String address) throws SocketException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125063525 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125063525;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.304 -0400", hash_original_method = "F28BFDFF195309DBD86E5144551EE7AD", hash_generated_method = "FDD5B6A02A76DB3676EB64978F2EB199")
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_842933648 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_842933648 = mLocalAddress;
        varB4EAC82CA7396A68D541C85D26508E83_842933648.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_842933648;
        // ---------- Original Method ----------
        //return mLocalAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.304 -0400", hash_original_method = "7C31E9E70AC59EA03FD32B04D9A6DCA9", hash_generated_method = "9014C5262335685F2354F0FF90B49604")
    public int getLocalPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058960971 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058960971;
        // ---------- Original Method ----------
        //return mLocalPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.325 -0400", hash_original_method = "DA9171B440EA3ADB706340063F8102C7", hash_generated_method = "2E3F704F9FA50A23BF9F59EFEA650338")
    public InetAddress getRemoteAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_304159471 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_304159471 = mRemoteAddress;
        varB4EAC82CA7396A68D541C85D26508E83_304159471.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_304159471;
        // ---------- Original Method ----------
        //return mRemoteAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.326 -0400", hash_original_method = "B0A2085CD61C2E0240384F40F555D7FA", hash_generated_method = "12729448E7D7C8BC458280E30FD00637")
    public int getRemotePort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284590086 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284590086;
        // ---------- Original Method ----------
        //return mRemotePort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.327 -0400", hash_original_method = "4ACBB08C3FA83B75B554974AB7F8953B", hash_generated_method = "FB2F55AD7F34DAB3B8C17A0171EDA9D3")
    public boolean isBusy() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_886552660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_886552660;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.328 -0400", hash_original_method = "46CDEAEE57FC46504BB8BB611AFCF88D", hash_generated_method = "F3A4EF150217CA645B84421962995332")
    public int getMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1068197576 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1068197576;
        // ---------- Original Method ----------
        //return mMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.345 -0400", hash_original_method = "343CDE7B48421898D79FEBC0BB9BBA38", hash_generated_method = "6D2E3A19E523CB327E32A0D7FF1C41D3")
    public void setMode(int mode) {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_946385265 = (isBusy());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.347 -0400", hash_original_method = "F6EBFCAAEA10AE181CE86DC5E6420909", hash_generated_method = "535FDEDC04916492C82F63D709C7E1C1")
    public void associate(InetAddress address, int port) {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_431377683 = (isBusy());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.348 -0400", hash_original_method = "CADBAA67E59C58F3A263DE6FDC241D82", hash_generated_method = "EE294E5A5C62211AB85DD6D25944FDA7")
    synchronized int dup() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502024673 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502024673;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.367 -0400", hash_original_method = "A307AB09C854328394617118B8488FB4", hash_generated_method = "7A3AC66D4FC51E12D72E71039B35C7A8")
    public void release() {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_763789382 = (isBusy());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.368 -0400", hash_original_method = "D50D7BA65C2BEB3EB436584B5735F108", hash_generated_method = "9DCF3C990963C60F39E50E126C7A13BB")
    private synchronized void close() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.369 -0400", hash_original_method = "2E21A04735F7B7DFBA8D51C21EAA3D5C", hash_generated_method = "1739E6BBD03654B983B913F30B6E5FDA")
    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
        // ---------- Original Method ----------
        //close();
        //super.finalize();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.370 -0400", hash_original_field = "E418210C7EF9D38349B407A10538481B", hash_generated_field = "3DEED3F3E236ECDEF49ABC73C5FEF55B")

    public static final int MODE_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.370 -0400", hash_original_field = "89160F7CCB068DE6FC244A87C2777D90", hash_generated_field = "5C78E1023A7A1CA7A0757CCCEAB06692")

    public static final int MODE_SEND_ONLY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.370 -0400", hash_original_field = "F833B4107ED8CF99E5D1B1962D178F0E", hash_generated_field = "251C5A7A5DC286AB55E869C7AB25D149")

    public static final int MODE_RECEIVE_ONLY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.371 -0400", hash_original_field = "8EEAD0F5D62556AB9EB4B1D05B84AF10", hash_generated_field = "4C0D482D5ED84DEE231DD5B361B3ABD0")

    private static int MODE_LAST = 2;
    static {
        System.loadLibrary("rtp_jni");
    }
    
}

