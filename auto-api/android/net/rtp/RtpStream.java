package android.net.rtp;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.SocketException;

public class RtpStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.537 -0400", hash_original_field = "AEC676A62769961F07AC33D7BA6C9B77", hash_generated_field = "82E160F333ECBB4C3723A32F659FDA5C")

    private InetAddress mLocalAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.537 -0400", hash_original_field = "8AA7B8C7AB1C5C520C43F0E33D5A33C0", hash_generated_field = "BAE743184ACBAA6741F9878C5CDE5973")

    private int mLocalPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.537 -0400", hash_original_field = "D774A49E336375969EA7C4F7614D9718", hash_generated_field = "CF6A95AED4B072ED0D692D0D05C9CA47")

    private InetAddress mRemoteAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.537 -0400", hash_original_field = "AEC2DEBB988798EDEBE724E13AC04FED", hash_generated_field = "A2AF795CC22BFE09F7BFD08F3E1E84C6")

    private int mRemotePort = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.537 -0400", hash_original_field = "6138C6824A13D1400A2A8723CFBDD347", hash_generated_field = "55D1610407B18FD2194387A7F965838E")

    private int mMode = MODE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.537 -0400", hash_original_field = "8AF77D45DED615EEBE14D961B1D7F7CE", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private int mNative;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.538 -0400", hash_original_method = "87C78188301D65B3202299E6E894F1D3", hash_generated_method = "0EBA38681CA047929975CD0AC8F8B93A")
      RtpStream(InetAddress address) throws SocketException {
        mLocalPort = create(address.getHostAddress());
        mLocalAddress = address;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.538 -0400", hash_original_method = "215B56CAD65C08D01C00FD356B52B803", hash_generated_method = "E2B824DECAE9792B5B9F795EF79D345A")
    private int create(String address) throws SocketException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162291491 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162291491;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.539 -0400", hash_original_method = "F28BFDFF195309DBD86E5144551EE7AD", hash_generated_method = "BD8C257E484D29AA6A55E3E75BB4F56B")
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_565946382 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_565946382 = mLocalAddress;
        varB4EAC82CA7396A68D541C85D26508E83_565946382.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_565946382;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.539 -0400", hash_original_method = "7C31E9E70AC59EA03FD32B04D9A6DCA9", hash_generated_method = "D0A7008695ABF8D003796EBC3089986A")
    public int getLocalPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325022697 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325022697;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.539 -0400", hash_original_method = "DA9171B440EA3ADB706340063F8102C7", hash_generated_method = "17A7034DC633F706CC18A37D3C2C7012")
    public InetAddress getRemoteAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_20712062 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_20712062 = mRemoteAddress;
        varB4EAC82CA7396A68D541C85D26508E83_20712062.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_20712062;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.540 -0400", hash_original_method = "B0A2085CD61C2E0240384F40F555D7FA", hash_generated_method = "2018B9FE43418556A58079A23C8EC3D3")
    public int getRemotePort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_713448295 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_713448295;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.540 -0400", hash_original_method = "4ACBB08C3FA83B75B554974AB7F8953B", hash_generated_method = "75B432915B2D0E23308C13EB719B04E3")
    public boolean isBusy() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_612941414 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_612941414;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.540 -0400", hash_original_method = "46CDEAEE57FC46504BB8BB611AFCF88D", hash_generated_method = "469E9C03203281CC827CEF5F850A28BF")
    public int getMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1570861956 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1570861956;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.541 -0400", hash_original_method = "343CDE7B48421898D79FEBC0BB9BBA38", hash_generated_method = "867758B4974A4E5B254C55C43D9A38F7")
    public void setMode(int mode) {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_930432275 = (isBusy());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Busy");
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid mode");
        } 
        mMode = mode;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.541 -0400", hash_original_method = "F6EBFCAAEA10AE181CE86DC5E6420909", hash_generated_method = "AC4025E98E7CAD67FAA2A571EACB3282")
    public void associate(InetAddress address, int port) {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_622817715 = (isBusy());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Busy");
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unsupported address");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid port");
        } 
        mRemoteAddress = address;
        mRemotePort = port;
        
        
            
        
        
                
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.542 -0400", hash_original_method = "CADBAA67E59C58F3A263DE6FDC241D82", hash_generated_method = "AAFCF1C0E948822C96AA34E0A83EBE76")
    synchronized int dup() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456487291 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456487291;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.542 -0400", hash_original_method = "A307AB09C854328394617118B8488FB4", hash_generated_method = "B041E7F793F8F10F8B0193CAE81CD4F2")
    public void release() {
        {
            boolean var6331CCDC5360782724F2E909851BBC53_1626939862 = (isBusy());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Busy");
            } 
        } 
        close();
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.542 -0400", hash_original_method = "D50D7BA65C2BEB3EB436584B5735F108", hash_generated_method = "9DCF3C990963C60F39E50E126C7A13BB")
    private synchronized void close() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.542 -0400", hash_original_method = "2E21A04735F7B7DFBA8D51C21EAA3D5C", hash_generated_method = "1739E6BBD03654B983B913F30B6E5FDA")
    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.543 -0400", hash_original_field = "E418210C7EF9D38349B407A10538481B", hash_generated_field = "3DEED3F3E236ECDEF49ABC73C5FEF55B")

    public static final int MODE_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.543 -0400", hash_original_field = "89160F7CCB068DE6FC244A87C2777D90", hash_generated_field = "5C78E1023A7A1CA7A0757CCCEAB06692")

    public static final int MODE_SEND_ONLY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.543 -0400", hash_original_field = "F833B4107ED8CF99E5D1B1962D178F0E", hash_generated_field = "251C5A7A5DC286AB55E869C7AB25D149")

    public static final int MODE_RECEIVE_ONLY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.543 -0400", hash_original_field = "8EEAD0F5D62556AB9EB4B1D05B84AF10", hash_generated_field = "FF9C72AD3D8D30E66745A8A195C5604C")

    private static final int MODE_LAST = 2;
    static {
        System.loadLibrary("rtp_jni");
    }
    
}

