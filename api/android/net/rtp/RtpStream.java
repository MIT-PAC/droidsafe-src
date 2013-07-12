package android.net.rtp;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.SocketException;

public class RtpStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.883 -0400", hash_original_field = "AEC676A62769961F07AC33D7BA6C9B77", hash_generated_field = "82E160F333ECBB4C3723A32F659FDA5C")

    private InetAddress mLocalAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.884 -0400", hash_original_field = "8AA7B8C7AB1C5C520C43F0E33D5A33C0", hash_generated_field = "BAE743184ACBAA6741F9878C5CDE5973")

    private int mLocalPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.884 -0400", hash_original_field = "D774A49E336375969EA7C4F7614D9718", hash_generated_field = "CF6A95AED4B072ED0D692D0D05C9CA47")

    private InetAddress mRemoteAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.884 -0400", hash_original_field = "AEC2DEBB988798EDEBE724E13AC04FED", hash_generated_field = "A2AF795CC22BFE09F7BFD08F3E1E84C6")

    private int mRemotePort = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.884 -0400", hash_original_field = "6138C6824A13D1400A2A8723CFBDD347", hash_generated_field = "55D1610407B18FD2194387A7F965838E")

    private int mMode = MODE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.884 -0400", hash_original_field = "8AF77D45DED615EEBE14D961B1D7F7CE", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private int mNative;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.884 -0400", hash_original_method = "87C78188301D65B3202299E6E894F1D3", hash_generated_method = "0EBA38681CA047929975CD0AC8F8B93A")
      RtpStream(InetAddress address) throws SocketException {
        mLocalPort = create(address.getHostAddress());
        mLocalAddress = address;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.885 -0400", hash_original_method = "215B56CAD65C08D01C00FD356B52B803", hash_generated_method = "EDA68830C7B726A3E6D47BEC3460045D")
    private int create(String address) throws SocketException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_135081246 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_135081246;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.885 -0400", hash_original_method = "F28BFDFF195309DBD86E5144551EE7AD", hash_generated_method = "C5BF0614B30C3C9F7D86C44E81748C38")
    public InetAddress getLocalAddress() {
InetAddress var0DE78938B7096FC280D64DC6179FFCE7_1175069340 =         mLocalAddress;
        var0DE78938B7096FC280D64DC6179FFCE7_1175069340.addTaint(taint);
        return var0DE78938B7096FC280D64DC6179FFCE7_1175069340;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.885 -0400", hash_original_method = "7C31E9E70AC59EA03FD32B04D9A6DCA9", hash_generated_method = "CED3A865CB22D6D006BE5134208E625E")
    public int getLocalPort() {
        int var8AA7B8C7AB1C5C520C43F0E33D5A33C0_1330235902 = (mLocalPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1363047728 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1363047728;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.886 -0400", hash_original_method = "DA9171B440EA3ADB706340063F8102C7", hash_generated_method = "2BA542FEF0C6088678762F45B5FEDC27")
    public InetAddress getRemoteAddress() {
InetAddress var8198FF43BDFDB16D148611CAF8ACB717_614500500 =         mRemoteAddress;
        var8198FF43BDFDB16D148611CAF8ACB717_614500500.addTaint(taint);
        return var8198FF43BDFDB16D148611CAF8ACB717_614500500;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.886 -0400", hash_original_method = "B0A2085CD61C2E0240384F40F555D7FA", hash_generated_method = "C8822C95D7D1AF7E014BA801FF7F0365")
    public int getRemotePort() {
        int var9DDD4EB2DEE1BD50DC1F09A91A5CAC33_1655343265 = (mRemotePort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_483747887 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_483747887;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.886 -0400", hash_original_method = "4ACBB08C3FA83B75B554974AB7F8953B", hash_generated_method = "F87B67ECCCA395F742D9B29550EF8BBC")
    public boolean isBusy() {
        boolean var68934A3E9455FA72420237EB05902327_681374162 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1864949089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1864949089;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.886 -0400", hash_original_method = "46CDEAEE57FC46504BB8BB611AFCF88D", hash_generated_method = "013C2762F80BD827E96093AC44126497")
    public int getMode() {
        int varC5AB706852158521E9D44BF62A49B1C9_34961738 = (mMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613311204 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613311204;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.887 -0400", hash_original_method = "343CDE7B48421898D79FEBC0BB9BBA38", hash_generated_method = "DDF4F9A3AB8AD4843C29FB220A5560F5")
    public void setMode(int mode) {
    if(isBusy())        
        {
            IllegalStateException varEB02D49C7F66BF6343EB56DDF1963715_1618118415 = new IllegalStateException("Busy");
            varEB02D49C7F66BF6343EB56DDF1963715_1618118415.addTaint(taint);
            throw varEB02D49C7F66BF6343EB56DDF1963715_1618118415;
        } 
    if(mode < 0 || mode > MODE_LAST)        
        {
            IllegalArgumentException varAED0A43B1A76B4B03E1EFA392603C665_683986756 = new IllegalArgumentException("Invalid mode");
            varAED0A43B1A76B4B03E1EFA392603C665_683986756.addTaint(taint);
            throw varAED0A43B1A76B4B03E1EFA392603C665_683986756;
        } 
        mMode = mode;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.888 -0400", hash_original_method = "F6EBFCAAEA10AE181CE86DC5E6420909", hash_generated_method = "B0A237B78705FE58831AEBA43EFCCE7D")
    public void associate(InetAddress address, int port) {
    if(isBusy())        
        {
            IllegalStateException varEB02D49C7F66BF6343EB56DDF1963715_396038920 = new IllegalStateException("Busy");
            varEB02D49C7F66BF6343EB56DDF1963715_396038920.addTaint(taint);
            throw varEB02D49C7F66BF6343EB56DDF1963715_396038920;
        } 
    if(!(address instanceof Inet4Address && mLocalAddress instanceof Inet4Address) &&
                !(address instanceof Inet6Address && mLocalAddress instanceof Inet6Address))        
        {
            IllegalArgumentException var7F7C1549CB312419D87D92DA30AF590C_1970958999 = new IllegalArgumentException("Unsupported address");
            var7F7C1549CB312419D87D92DA30AF590C_1970958999.addTaint(taint);
            throw var7F7C1549CB312419D87D92DA30AF590C_1970958999;
        } 
    if(port < 0 || port > 65535)        
        {
            IllegalArgumentException var9073C749711388E37E25A77B53FC1D1F_1595463330 = new IllegalArgumentException("Invalid port");
            var9073C749711388E37E25A77B53FC1D1F_1595463330.addTaint(taint);
            throw var9073C749711388E37E25A77B53FC1D1F_1595463330;
        } 
        mRemoteAddress = address;
        mRemotePort = port;
        
        
            
        
        
                
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.888 -0400", hash_original_method = "CADBAA67E59C58F3A263DE6FDC241D82", hash_generated_method = "D7F878855543CA01BD0FBE5B4E1112B5")
    synchronized int dup() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180993453 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180993453;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.888 -0400", hash_original_method = "A307AB09C854328394617118B8488FB4", hash_generated_method = "67B6ABB269A90242EA4453ECC628CDD6")
    public void release() {
    if(isBusy())        
        {
            IllegalStateException varEB02D49C7F66BF6343EB56DDF1963715_2022071711 = new IllegalStateException("Busy");
            varEB02D49C7F66BF6343EB56DDF1963715_2022071711.addTaint(taint);
            throw varEB02D49C7F66BF6343EB56DDF1963715_2022071711;
        } 
        close();
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.889 -0400", hash_original_method = "D50D7BA65C2BEB3EB436584B5735F108", hash_generated_method = "9DCF3C990963C60F39E50E126C7A13BB")
    private synchronized void close() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.889 -0400", hash_original_method = "2E21A04735F7B7DFBA8D51C21EAA3D5C", hash_generated_method = "1739E6BBD03654B983B913F30B6E5FDA")
    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.889 -0400", hash_original_field = "E418210C7EF9D38349B407A10538481B", hash_generated_field = "3DEED3F3E236ECDEF49ABC73C5FEF55B")

    public static final int MODE_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.889 -0400", hash_original_field = "89160F7CCB068DE6FC244A87C2777D90", hash_generated_field = "5C78E1023A7A1CA7A0757CCCEAB06692")

    public static final int MODE_SEND_ONLY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.889 -0400", hash_original_field = "F833B4107ED8CF99E5D1B1962D178F0E", hash_generated_field = "251C5A7A5DC286AB55E869C7AB25D149")

    public static final int MODE_RECEIVE_ONLY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.889 -0400", hash_original_field = "8EEAD0F5D62556AB9EB4B1D05B84AF10", hash_generated_field = "FF9C72AD3D8D30E66745A8A195C5604C")

    private static final int MODE_LAST = 2;
    static {
        System.loadLibrary("rtp_jni");
    }
    
}

