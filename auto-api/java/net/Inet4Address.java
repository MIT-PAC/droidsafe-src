package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ObjectStreamException;
import java.nio.ByteOrder;
import libcore.io.Memory;
import static libcore.io.OsConstants.*;

public final class Inet4Address extends InetAddress {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.226 -0400", hash_original_method = "456618C96C185AE7EE8C57F26D0D0668", hash_generated_method = "F3B4005D187ABA8C2D33E37A2D4F3B68")
      Inet4Address(byte[] ipaddress, String hostName) {
        super(AF_INET, ipaddress, hostName);
        addTaint(ipaddress[0]);
        addTaint(hostName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.227 -0400", hash_original_method = "0C1A3E77D90A82A5EF8B4836AA337609", hash_generated_method = "E40E7AECD767515012F9063F74CC2ADC")
    @Override
    public boolean isAnyLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_763442545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_763442545;
        // ---------- Original Method ----------
        //return ipaddress[0] == 0 && ipaddress[1] == 0 && ipaddress[2] == 0 && ipaddress[3] == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.227 -0400", hash_original_method = "38D1AA1924F9F7EC1F4EB08BE7254781", hash_generated_method = "CA0E33D244AD0F4E0BC64E452347791C")
    @Override
    public boolean isLinkLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_532796783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_532796783;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 169) && ((ipaddress[1] & 0xff) == 254);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.227 -0400", hash_original_method = "FB35E1A46B66244783B8471385CB1A76", hash_generated_method = "B9E97F69844C8919CF67FC6D2FF7ADB8")
    @Override
    public boolean isLoopbackAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_485472153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_485472153;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 127);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.227 -0400", hash_original_method = "7EC53D5BF716DEFD994FB15A461002F1", hash_generated_method = "2BA8CCB641879874F3DF033C87BA6F44")
    @Override
    public boolean isMCGlobal() {
        {
            boolean var0588D32C09A60BA0A448759EA893261D_884358422 = (!isMulticastAddress());
        } //End collapsed parenthetic
        int address = Memory.peekInt(ipaddress, 0, ByteOrder.BIG_ENDIAN);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_140811442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_140811442;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.228 -0400", hash_original_method = "CB22C78468AA446CA5A943070CD230A8", hash_generated_method = "C6317499B96A42DC57446BF0EB82F59A")
    @Override
    public boolean isMCLinkLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1375734686 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1375734686;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 224) && (ipaddress[1] == 0) && (ipaddress[2] == 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.228 -0400", hash_original_method = "B0B42DF39D7CC893DB97C3031173A44B", hash_generated_method = "65DC34EAD109BE3E679A1CD7026B3AD9")
    @Override
    public boolean isMCNodeLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1879614270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1879614270;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.228 -0400", hash_original_method = "77DF4C339990FEF620E26E135CB9F40A", hash_generated_method = "4ACFEF8A9A08E5A61DA48C4EAEB0D8DC")
    @Override
    public boolean isMCOrgLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1520764947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1520764947;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xfc) == 192);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.228 -0400", hash_original_method = "9C14EBCA764FFF67AE16B4B98A6FB7C0", hash_generated_method = "3443AE578C4BFEF326F32D635410D73B")
    @Override
    public boolean isMCSiteLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_123330954 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_123330954;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xff) == 255);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.229 -0400", hash_original_method = "D19738A63A8D007E2A9921EAE82BC6DA", hash_generated_method = "596379D2021527DD9B8D359330F4BA41")
    @Override
    public boolean isMulticastAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1247988104 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1247988104;
        // ---------- Original Method ----------
        //return (ipaddress[0] & 0xf0) == 224;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.229 -0400", hash_original_method = "ACDDA2FDB8C312E800968083D2342A94", hash_generated_method = "2B8914047DCB8591CD6610D2039C51EB")
    @Override
    public boolean isSiteLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_711086834 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_711086834;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.230 -0400", hash_original_method = "ED281EE0C7A186E413EE6AFE3B25FC7C", hash_generated_method = "4D9F39FFF23041144527ADA32E086B63")
    private Object writeReplace() throws ObjectStreamException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1905151339 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1905151339 = new Inet4Address(ipaddress, hostName);
        varB4EAC82CA7396A68D541C85D26508E83_1905151339.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1905151339;
        // ---------- Original Method ----------
        //return new Inet4Address(ipaddress, hostName);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.231 -0400", hash_original_field = "6457221FED36AEA41AF6CB769203E35C", hash_generated_field = "D810DA6D1E5ECCA9B74B4757EAD39B08")

    private static final long serialVersionUID = 3286316764910316507L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.231 -0400", hash_original_field = "969124CBC112D36BF12EBF9F1807602A", hash_generated_field = "103A110B2CE2D2209A59D9B725C4482E")

    public static final InetAddress ANY =
            new Inet4Address(new byte[] { 0, 0, 0, 0 }, null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.231 -0400", hash_original_field = "6DF036A21540C43C3AA8C8CAC8126ED2", hash_generated_field = "BB6AED12F12CCF22F97AD9D972AF3194")

    public static final InetAddress ALL =
            new Inet4Address(new byte[] { (byte) 255, (byte) 255,
                                          (byte) 255, (byte) 255 }, null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.231 -0400", hash_original_field = "F28195100E02F94F61B5D92FE6326A4E", hash_generated_field = "3E1BF0CBCF49A9687059940E3F5B88B0")

    public static final InetAddress LOOPBACK =
            new Inet4Address(new byte[] { 127, 0, 0, 1 }, "localhost");
}

