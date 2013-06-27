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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.321 -0400", hash_original_method = "456618C96C185AE7EE8C57F26D0D0668", hash_generated_method = "F3B4005D187ABA8C2D33E37A2D4F3B68")
      Inet4Address(byte[] ipaddress, String hostName) {
        super(AF_INET, ipaddress, hostName);
        addTaint(ipaddress[0]);
        addTaint(hostName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.332 -0400", hash_original_method = "0C1A3E77D90A82A5EF8B4836AA337609", hash_generated_method = "4B86E9A3FDC0982F59C5A6DEDD233E59")
    @Override
    public boolean isAnyLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_885735537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_885735537;
        // ---------- Original Method ----------
        //return ipaddress[0] == 0 && ipaddress[1] == 0 && ipaddress[2] == 0 && ipaddress[3] == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.333 -0400", hash_original_method = "38D1AA1924F9F7EC1F4EB08BE7254781", hash_generated_method = "FBEA9850EE3A6A01AE744CC92391516F")
    @Override
    public boolean isLinkLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_713102861 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_713102861;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 169) && ((ipaddress[1] & 0xff) == 254);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.334 -0400", hash_original_method = "FB35E1A46B66244783B8471385CB1A76", hash_generated_method = "3E5580AF138E66DC4B4FF469B4CA48FA")
    @Override
    public boolean isLoopbackAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_465571032 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_465571032;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 127);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.338 -0400", hash_original_method = "7EC53D5BF716DEFD994FB15A461002F1", hash_generated_method = "B8AF0F7E2D04FF0D71E6946FB977AE62")
    @Override
    public boolean isMCGlobal() {
        {
            boolean var0588D32C09A60BA0A448759EA893261D_646799609 = (!isMulticastAddress());
        } //End collapsed parenthetic
        int address;
        address = Memory.peekInt(ipaddress, 0, ByteOrder.BIG_ENDIAN);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_356990780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_356990780;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.343 -0400", hash_original_method = "CB22C78468AA446CA5A943070CD230A8", hash_generated_method = "E8C5760DDAD04FCDFF7B840E76F540E5")
    @Override
    public boolean isMCLinkLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1829574422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1829574422;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 224) && (ipaddress[1] == 0) && (ipaddress[2] == 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.344 -0400", hash_original_method = "B0B42DF39D7CC893DB97C3031173A44B", hash_generated_method = "796B7B6FCCB52940AD1E3A6E8B6AF33B")
    @Override
    public boolean isMCNodeLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_654206030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_654206030;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.352 -0400", hash_original_method = "77DF4C339990FEF620E26E135CB9F40A", hash_generated_method = "CE2103787D77D5A0988F7384B9242E3B")
    @Override
    public boolean isMCOrgLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_40376778 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_40376778;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xfc) == 192);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.353 -0400", hash_original_method = "9C14EBCA764FFF67AE16B4B98A6FB7C0", hash_generated_method = "D16851BFFD7DF2E88D46603BAFFEF0B0")
    @Override
    public boolean isMCSiteLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1589369232 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1589369232;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xff) == 255);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.353 -0400", hash_original_method = "D19738A63A8D007E2A9921EAE82BC6DA", hash_generated_method = "4F79F96089AE6B6A0D891591CBB36ECF")
    @Override
    public boolean isMulticastAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_942756650 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_942756650;
        // ---------- Original Method ----------
        //return (ipaddress[0] & 0xf0) == 224;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.357 -0400", hash_original_method = "ACDDA2FDB8C312E800968083D2342A94", hash_generated_method = "C984EEDF916218719B9849685C9631F5")
    @Override
    public boolean isSiteLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1150167661 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1150167661;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.372 -0400", hash_original_method = "ED281EE0C7A186E413EE6AFE3B25FC7C", hash_generated_method = "0418F33E9031FA9AAEE5606CB1789E95")
    private Object writeReplace() throws ObjectStreamException {
        Object varB4EAC82CA7396A68D541C85D26508E83_954142465 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_954142465 = new Inet4Address(ipaddress, hostName);
        varB4EAC82CA7396A68D541C85D26508E83_954142465.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_954142465;
        // ---------- Original Method ----------
        //return new Inet4Address(ipaddress, hostName);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.372 -0400", hash_original_field = "6457221FED36AEA41AF6CB769203E35C", hash_generated_field = "FB607DA6C774EC8A3CC3DADFB3E8AC93")

    private static long serialVersionUID = 3286316764910316507L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.373 -0400", hash_original_field = "969124CBC112D36BF12EBF9F1807602A", hash_generated_field = "103A110B2CE2D2209A59D9B725C4482E")

    public static final InetAddress ANY =
            new Inet4Address(new byte[] { 0, 0, 0, 0 }, null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.373 -0400", hash_original_field = "6DF036A21540C43C3AA8C8CAC8126ED2", hash_generated_field = "BB6AED12F12CCF22F97AD9D972AF3194")

    public static final InetAddress ALL =
            new Inet4Address(new byte[] { (byte) 255, (byte) 255,
                                          (byte) 255, (byte) 255 }, null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.373 -0400", hash_original_field = "F28195100E02F94F61B5D92FE6326A4E", hash_generated_field = "3E1BF0CBCF49A9687059940E3F5B88B0")

    public static final InetAddress LOOPBACK =
            new Inet4Address(new byte[] { 127, 0, 0, 1 }, "localhost");
}

