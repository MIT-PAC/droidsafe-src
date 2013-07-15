package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ObjectStreamException;
import java.nio.ByteOrder;
import libcore.io.Memory;
import static libcore.io.OsConstants.*;

public final class Inet4Address extends InetAddress {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.662 -0400", hash_original_method = "456618C96C185AE7EE8C57F26D0D0668", hash_generated_method = "B3BA681148AA3724D8AFB0122BA5E92A")
      Inet4Address(byte[] ipaddress, String hostName) {
        super(AF_INET, ipaddress, hostName);
        addTaint(hostName.getTaint());
        addTaint(ipaddress[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.663 -0400", hash_original_method = "0C1A3E77D90A82A5EF8B4836AA337609", hash_generated_method = "81563D6251EB5BCF3E88509258868657")
    @Override
    public boolean isAnyLocalAddress() {
        boolean var52C1A337FC8B967DCD01195658115356_122485189 = (ipaddress[0] == 0 && ipaddress[1] == 0 && ipaddress[2] == 0 && ipaddress[3] == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1886980466 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1886980466;
        // ---------- Original Method ----------
        //return ipaddress[0] == 0 && ipaddress[1] == 0 && ipaddress[2] == 0 && ipaddress[3] == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.663 -0400", hash_original_method = "38D1AA1924F9F7EC1F4EB08BE7254781", hash_generated_method = "3E7FEFEA4AAE7A21611763DEC1CDF748")
    @Override
    public boolean isLinkLocalAddress() {
        boolean varBA67D5EE3AF3A95E1783C21A313CB3DE_1206533602 = (((ipaddress[0] & 0xff) == 169) && ((ipaddress[1] & 0xff) == 254));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224401571 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_224401571;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 169) && ((ipaddress[1] & 0xff) == 254);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.664 -0400", hash_original_method = "FB35E1A46B66244783B8471385CB1A76", hash_generated_method = "E19BB135994475C21F55B3DD534ADE82")
    @Override
    public boolean isLoopbackAddress() {
        boolean varD99212983F1BABED2A9AD540FBA2EE3B_1753253842 = (((ipaddress[0] & 0xff) == 127));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_900339010 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_900339010;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 127);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.664 -0400", hash_original_method = "7EC53D5BF716DEFD994FB15A461002F1", hash_generated_method = "760243A566620DEEDABD3C5FBA6085E8")
    @Override
    public boolean isMCGlobal() {
    if(!isMulticastAddress())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1783559916 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1648151088 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1648151088;
        } //End block
        int address = Memory.peekInt(ipaddress, 0, ByteOrder.BIG_ENDIAN);
    if(address >>> 8 < 0xE00001)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1074177577 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1673928222 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1673928222;
        } //End block
    if(address >>> 24 > 0xEE)        
        {
            boolean var68934A3E9455FA72420237EB05902327_187742466 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1611671982 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1611671982;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1415239586 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1729381515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1729381515;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.665 -0400", hash_original_method = "CB22C78468AA446CA5A943070CD230A8", hash_generated_method = "9A50F794249AF30F0EE89F7828EC5959")
    @Override
    public boolean isMCLinkLocal() {
        boolean varC551ACD2D5F448AE48052168445549FE_1653262645 = (((ipaddress[0] & 0xff) == 224) && (ipaddress[1] == 0) && (ipaddress[2] == 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1381565789 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1381565789;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 224) && (ipaddress[1] == 0) && (ipaddress[2] == 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.665 -0400", hash_original_method = "B0B42DF39D7CC893DB97C3031173A44B", hash_generated_method = "0E81B2E0895101C8ABD1D0EB6016723D")
    @Override
    public boolean isMCNodeLocal() {
        boolean var68934A3E9455FA72420237EB05902327_347838758 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167053913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167053913;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.665 -0400", hash_original_method = "77DF4C339990FEF620E26E135CB9F40A", hash_generated_method = "90CA54877C7B2FA4633552EB79106733")
    @Override
    public boolean isMCOrgLocal() {
        boolean var2C2E088C25B6EEF70E1BF2B77957523D_1558325292 = (((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xfc) == 192));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1123814122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1123814122;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xfc) == 192);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.666 -0400", hash_original_method = "9C14EBCA764FFF67AE16B4B98A6FB7C0", hash_generated_method = "0BB5976742C5C15D42590210ECE030CA")
    @Override
    public boolean isMCSiteLocal() {
        boolean varF69C7A3854A2CA3FC4EAA8D9398F3590_1755302442 = (((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xff) == 255));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1690492718 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1690492718;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xff) == 255);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.666 -0400", hash_original_method = "D19738A63A8D007E2A9921EAE82BC6DA", hash_generated_method = "D7E59BA3D555000BD2D65D72661AEE31")
    @Override
    public boolean isMulticastAddress() {
        boolean var4AAADDC718073915A705EF5C7AB0D173_253449712 = ((ipaddress[0] & 0xf0) == 224);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1151651406 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1151651406;
        // ---------- Original Method ----------
        //return (ipaddress[0] & 0xf0) == 224;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.667 -0400", hash_original_method = "ACDDA2FDB8C312E800968083D2342A94", hash_generated_method = "CAD7BF66F51B5C14ECC77D1C0B058FCA")
    @Override
    public boolean isSiteLocalAddress() {
    if((ipaddress[0] & 0xff) == 10)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_2530483 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_741561933 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_741561933;
        } //End block
        else
    if(((ipaddress[0] & 0xff) == 172) && ((ipaddress[1] & 0xf0) == 16))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_761824679 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_804127060 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_804127060;
        } //End block
        else
    if(((ipaddress[0] & 0xff) == 192) && ((ipaddress[1] & 0xff) == 168))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1662318130 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_941894556 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_941894556;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_300893547 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1449822724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1449822724;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.667 -0400", hash_original_method = "ED281EE0C7A186E413EE6AFE3B25FC7C", hash_generated_method = "6DCA6FC5FC4134C9BA21AEE19917E769")
    private Object writeReplace() throws ObjectStreamException {
Object var018746D7CDD66E0C0F2B4CEA8F394772_1637989522 =         new Inet4Address(ipaddress, hostName);
        var018746D7CDD66E0C0F2B4CEA8F394772_1637989522.addTaint(taint);
        return var018746D7CDD66E0C0F2B4CEA8F394772_1637989522;
        // ---------- Original Method ----------
        //return new Inet4Address(ipaddress, hostName);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.668 -0400", hash_original_field = "6457221FED36AEA41AF6CB769203E35C", hash_generated_field = "D810DA6D1E5ECCA9B74B4757EAD39B08")

    private static final long serialVersionUID = 3286316764910316507L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.668 -0400", hash_original_field = "969124CBC112D36BF12EBF9F1807602A", hash_generated_field = "103A110B2CE2D2209A59D9B725C4482E")

    public static final InetAddress ANY =
            new Inet4Address(new byte[] { 0, 0, 0, 0 }, null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.668 -0400", hash_original_field = "6DF036A21540C43C3AA8C8CAC8126ED2", hash_generated_field = "BB6AED12F12CCF22F97AD9D972AF3194")

    public static final InetAddress ALL =
            new Inet4Address(new byte[] { (byte) 255, (byte) 255,
                                          (byte) 255, (byte) 255 }, null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.668 -0400", hash_original_field = "F28195100E02F94F61B5D92FE6326A4E", hash_generated_field = "3E1BF0CBCF49A9687059940E3F5B88B0")

    public static final InetAddress LOOPBACK =
            new Inet4Address(new byte[] { 127, 0, 0, 1 }, "localhost");
}

