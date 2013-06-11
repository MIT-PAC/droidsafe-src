package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.ObjectStreamException;
import java.nio.ByteOrder;
import libcore.io.Memory;
import static libcore.io.OsConstants.*;

public final class Inet4Address extends InetAddress {
    private static final long serialVersionUID = 3286316764910316507L;
    public static final InetAddress ANY =
            new Inet4Address(new byte[] { 0, 0, 0, 0 }, null);
    public static final InetAddress ALL =
            new Inet4Address(new byte[] { (byte) 255, (byte) 255,
                                          (byte) 255, (byte) 255 }, null);
    public static final InetAddress LOOPBACK =
            new Inet4Address(new byte[] { 127, 0, 0, 1 }, "localhost");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.204 -0400", hash_original_method = "456618C96C185AE7EE8C57F26D0D0668", hash_generated_method = "8F6297983AE9E810E261C487F32F0440")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Inet4Address(byte[] ipaddress, String hostName) {
        super(AF_INET, ipaddress, hostName);
        dsTaint.addTaint(hostName);
        dsTaint.addTaint(ipaddress);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.204 -0400", hash_original_method = "0C1A3E77D90A82A5EF8B4836AA337609", hash_generated_method = "37712AE823A1BFC68E4E57FCFB3D206C")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isAnyLocalAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ipaddress[0] == 0 && ipaddress[1] == 0 && ipaddress[2] == 0 && ipaddress[3] == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.204 -0400", hash_original_method = "38D1AA1924F9F7EC1F4EB08BE7254781", hash_generated_method = "ACCBCED4B6AF0D13B7B1B93613642616")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isLinkLocalAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 169) && ((ipaddress[1] & 0xff) == 254);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.204 -0400", hash_original_method = "FB35E1A46B66244783B8471385CB1A76", hash_generated_method = "6396C9343F70151CA3142B0C98203B6D")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isLoopbackAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 127);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.204 -0400", hash_original_method = "7EC53D5BF716DEFD994FB15A461002F1", hash_generated_method = "C087E7F7013CA7A4DC12C3287D97C5D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isMCGlobal() {
        {
            boolean var0588D32C09A60BA0A448759EA893261D_496742656 = (!isMulticastAddress());
        } //End collapsed parenthetic
        int address;
        address = Memory.peekInt(ipaddress, 0, ByteOrder.BIG_ENDIAN);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.204 -0400", hash_original_method = "CB22C78468AA446CA5A943070CD230A8", hash_generated_method = "A8693D543167D403399CC503EFEDFEB7")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMCLinkLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 224) && (ipaddress[1] == 0) && (ipaddress[2] == 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.204 -0400", hash_original_method = "B0B42DF39D7CC893DB97C3031173A44B", hash_generated_method = "5508A68F47D8ED29B1A36C093E63B673")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMCNodeLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.204 -0400", hash_original_method = "77DF4C339990FEF620E26E135CB9F40A", hash_generated_method = "652515857BE273F1E4AB33E760FB2E06")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMCOrgLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xfc) == 192);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.204 -0400", hash_original_method = "9C14EBCA764FFF67AE16B4B98A6FB7C0", hash_generated_method = "66BEF588351C827CE13249DCF03E45F6")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMCSiteLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xff) == 255);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.204 -0400", hash_original_method = "D19738A63A8D007E2A9921EAE82BC6DA", hash_generated_method = "C0AD85E2909450A209E564DD15DBEBD2")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMulticastAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (ipaddress[0] & 0xf0) == 224;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.204 -0400", hash_original_method = "ACDDA2FDB8C312E800968083D2342A94", hash_generated_method = "B5005988C4C38B7577FA9F7ECAD5BEA5")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isSiteLocalAddress() {
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.204 -0400", hash_original_method = "ED281EE0C7A186E413EE6AFE3B25FC7C", hash_generated_method = "E90248C7BAC104E3D232D96E3F0B94A4")
    @DSModeled(DSC.SAFE)
    private Object writeReplace() throws ObjectStreamException {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Inet4Address(ipaddress, hostName);
    }

    
}


