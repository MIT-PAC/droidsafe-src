package java.net;

// Droidsafe Imports
import static libcore.io.OsConstants.AF_INET;

import java.io.ObjectStreamException;
import java.nio.ByteOrder;

import libcore.io.Memory;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class Inet4Address extends InetAddress {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.523 -0400", hash_original_method = "456618C96C185AE7EE8C57F26D0D0668", hash_generated_method = "B3BA681148AA3724D8AFB0122BA5E92A")
      Inet4Address(byte[] ipaddress, String hostName) {
        super(AF_INET, ipaddress, hostName);
        addTaint(hostName.getTaint());
        addTaint(ipaddress[0]);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.523 -0400", hash_original_method = "0C1A3E77D90A82A5EF8B4836AA337609", hash_generated_method = "D834A65E054CFEA92FCF3C50494F9F26")
    @Override
    public boolean isAnyLocalAddress() {
        boolean var52C1A337FC8B967DCD01195658115356_1742228990 = (ipaddress[0] == 0 && ipaddress[1] == 0 && ipaddress[2] == 0 && ipaddress[3] == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222060315 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_222060315;
        // ---------- Original Method ----------
        //return ipaddress[0] == 0 && ipaddress[1] == 0 && ipaddress[2] == 0 && ipaddress[3] == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.524 -0400", hash_original_method = "38D1AA1924F9F7EC1F4EB08BE7254781", hash_generated_method = "50F640C41E05B9904A5EDD22CD3FB9ED")
    @Override
    public boolean isLinkLocalAddress() {
        boolean varBA67D5EE3AF3A95E1783C21A313CB3DE_370320703 = (((ipaddress[0] & 0xff) == 169) && ((ipaddress[1] & 0xff) == 254));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_252023395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_252023395;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 169) && ((ipaddress[1] & 0xff) == 254);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.524 -0400", hash_original_method = "FB35E1A46B66244783B8471385CB1A76", hash_generated_method = "82BE32D10873AAAFB98C11356C3ACDDF")
    @Override
    public boolean isLoopbackAddress() {
        boolean varD99212983F1BABED2A9AD540FBA2EE3B_166552587 = (((ipaddress[0] & 0xff) == 127));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_366593890 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_366593890;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 127);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.524 -0400", hash_original_method = "7EC53D5BF716DEFD994FB15A461002F1", hash_generated_method = "3D8A6247C9818B32B49482F6602B165B")
    @Override
    public boolean isMCGlobal() {
        if(!isMulticastAddress())        
        {
            boolean var68934A3E9455FA72420237EB05902327_220773684 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167222311 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167222311;
        } //End block
        int address = Memory.peekInt(ipaddress, 0, ByteOrder.BIG_ENDIAN);
        if(address >>> 8 < 0xE00001)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1607951969 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1951915445 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1951915445;
        } //End block
        if(address >>> 24 > 0xEE)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1894576976 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1695033705 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1695033705;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_777395609 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_13122365 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_13122365;
        // ---------- Original Method ----------
        //if (!isMulticastAddress()) {
            //return false;
        //}
        //int address = Memory.peekInt(ipaddress, 0, ByteOrder.BIG_ENDIAN);
        //if (address >>> 8 < 0xE00001) {
            //return false;
        //}
        //if (address >>> 24 > 0xEE) {
            //return false;
        //}
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.525 -0400", hash_original_method = "CB22C78468AA446CA5A943070CD230A8", hash_generated_method = "016AF6D3AD961375B86F8B50055D0CBD")
    @Override
    public boolean isMCLinkLocal() {
        boolean varC551ACD2D5F448AE48052168445549FE_858751002 = (((ipaddress[0] & 0xff) == 224) && (ipaddress[1] == 0) && (ipaddress[2] == 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1799356854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1799356854;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 224) && (ipaddress[1] == 0) && (ipaddress[2] == 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.525 -0400", hash_original_method = "B0B42DF39D7CC893DB97C3031173A44B", hash_generated_method = "2D99ABEE08EBEE1E15947BDC2B84A292")
    @Override
    public boolean isMCNodeLocal() {
        boolean var68934A3E9455FA72420237EB05902327_1129598605 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1901059786 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1901059786;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.525 -0400", hash_original_method = "77DF4C339990FEF620E26E135CB9F40A", hash_generated_method = "131D3AFAFA08D65652A6D44219FFAB9D")
    @Override
    public boolean isMCOrgLocal() {
        boolean var2C2E088C25B6EEF70E1BF2B77957523D_1986291506 = (((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xfc) == 192));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1617143846 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1617143846;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xfc) == 192);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.526 -0400", hash_original_method = "9C14EBCA764FFF67AE16B4B98A6FB7C0", hash_generated_method = "FFFBC7EE66C5AA914688FE8843F08D64")
    @Override
    public boolean isMCSiteLocal() {
        boolean varF69C7A3854A2CA3FC4EAA8D9398F3590_2092346395 = (((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xff) == 255));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_44874012 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_44874012;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xff) == 255);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.526 -0400", hash_original_method = "D19738A63A8D007E2A9921EAE82BC6DA", hash_generated_method = "9AD8D76C87C3BFC596C0590EF3BB32F6")
    @Override
    public boolean isMulticastAddress() {
        boolean var4AAADDC718073915A705EF5C7AB0D173_285817457 = ((ipaddress[0] & 0xf0) == 224);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1498203814 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1498203814;
        // ---------- Original Method ----------
        //return (ipaddress[0] & 0xf0) == 224;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.527 -0400", hash_original_method = "ACDDA2FDB8C312E800968083D2342A94", hash_generated_method = "A2991196A1D91F05AFD0D19268A2F4CA")
    @Override
    public boolean isSiteLocalAddress() {
        if((ipaddress[0] & 0xff) == 10)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_67567091 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835084866 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_835084866;
        } //End block
        else
        if(((ipaddress[0] & 0xff) == 172) && ((ipaddress[1] & 0xf0) == 16))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_809593347 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_646956690 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_646956690;
        } //End block
        else
        if(((ipaddress[0] & 0xff) == 192) && ((ipaddress[1] & 0xff) == 168))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1732990669 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_494976125 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_494976125;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2025579605 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2063845478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2063845478;
        // ---------- Original Method ----------
        //if ((ipaddress[0] & 0xff) == 10) { 
            //return true;
        //} else if (((ipaddress[0] & 0xff) == 172) && ((ipaddress[1] & 0xf0) == 16)) { 
            //return true;
        //} else if (((ipaddress[0] & 0xff) == 192) && ((ipaddress[1] & 0xff) == 168)) { 
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.527 -0400", hash_original_method = "ED281EE0C7A186E413EE6AFE3B25FC7C", hash_generated_method = "E9A65F76B911A169A67869803953F912")
    private Object writeReplace() throws ObjectStreamException {
Object var018746D7CDD66E0C0F2B4CEA8F394772_1661696511 =         new Inet4Address(ipaddress, hostName);
        var018746D7CDD66E0C0F2B4CEA8F394772_1661696511.addTaint(taint);
        return var018746D7CDD66E0C0F2B4CEA8F394772_1661696511;
        // ---------- Original Method ----------
        //return new Inet4Address(ipaddress, hostName);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.528 -0400", hash_original_field = "6457221FED36AEA41AF6CB769203E35C", hash_generated_field = "D810DA6D1E5ECCA9B74B4757EAD39B08")

    private static final long serialVersionUID = 3286316764910316507L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.528 -0400", hash_original_field = "969124CBC112D36BF12EBF9F1807602A", hash_generated_field = "103A110B2CE2D2209A59D9B725C4482E")

    public static final InetAddress ANY =
            new Inet4Address(new byte[] { 0, 0, 0, 0 }, null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.528 -0400", hash_original_field = "6DF036A21540C43C3AA8C8CAC8126ED2", hash_generated_field = "BB6AED12F12CCF22F97AD9D972AF3194")

    public static final InetAddress ALL =
            new Inet4Address(new byte[] { (byte) 255, (byte) 255,
                                          (byte) 255, (byte) 255 }, null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.528 -0400", hash_original_field = "F28195100E02F94F61B5D92FE6326A4E", hash_generated_field = "3E1BF0CBCF49A9687059940E3F5B88B0")

    public static final InetAddress LOOPBACK =
            new Inet4Address(new byte[] { 127, 0, 0, 1 }, "localhost");
}

