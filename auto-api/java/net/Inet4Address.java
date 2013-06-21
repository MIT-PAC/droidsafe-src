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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.816 -0400", hash_original_method = "456618C96C185AE7EE8C57F26D0D0668", hash_generated_method = "00C87F30470BF47ABE996036FFAB3439")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Inet4Address(byte[] ipaddress, String hostName) {
        super(AF_INET, ipaddress, hostName);
        dsTaint.addTaint(hostName);
        dsTaint.addTaint(ipaddress[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.816 -0400", hash_original_method = "0C1A3E77D90A82A5EF8B4836AA337609", hash_generated_method = "7E5AE852DC11AD7723E72814B526C29B")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isAnyLocalAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ipaddress[0] == 0 && ipaddress[1] == 0 && ipaddress[2] == 0 && ipaddress[3] == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.816 -0400", hash_original_method = "38D1AA1924F9F7EC1F4EB08BE7254781", hash_generated_method = "9838CDF8160A8EE4026BC867F8B0D511")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isLinkLocalAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 169) && ((ipaddress[1] & 0xff) == 254);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.816 -0400", hash_original_method = "FB35E1A46B66244783B8471385CB1A76", hash_generated_method = "C74D1F37CFF4F177C07498AED2674AFB")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isLoopbackAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 127);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.817 -0400", hash_original_method = "7EC53D5BF716DEFD994FB15A461002F1", hash_generated_method = "69DD56EBA0A51FBE88BAD0056215EA2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isMCGlobal() {
        {
            boolean var0588D32C09A60BA0A448759EA893261D_170096115 = (!isMulticastAddress());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.817 -0400", hash_original_method = "CB22C78468AA446CA5A943070CD230A8", hash_generated_method = "EF8EA6DBEE6CA33C3B6DB2F94B76A534")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMCLinkLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 224) && (ipaddress[1] == 0) && (ipaddress[2] == 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.817 -0400", hash_original_method = "B0B42DF39D7CC893DB97C3031173A44B", hash_generated_method = "D896D081F26012F0111455895A14D508")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMCNodeLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.817 -0400", hash_original_method = "77DF4C339990FEF620E26E135CB9F40A", hash_generated_method = "8C72D67988603D1D16B38592D8EDC43B")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMCOrgLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xfc) == 192);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.818 -0400", hash_original_method = "9C14EBCA764FFF67AE16B4B98A6FB7C0", hash_generated_method = "ED9D53DC057EA27A4FA3F6A2F84DA9D1")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMCSiteLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xff) == 255);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.818 -0400", hash_original_method = "D19738A63A8D007E2A9921EAE82BC6DA", hash_generated_method = "FA33B3A26323CCAA7B9A0F67FDBEF566")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMulticastAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (ipaddress[0] & 0xf0) == 224;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.818 -0400", hash_original_method = "ACDDA2FDB8C312E800968083D2342A94", hash_generated_method = "D7E6FA53AF7EA73FD0B16FEAF203DBE6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.818 -0400", hash_original_method = "ED281EE0C7A186E413EE6AFE3B25FC7C", hash_generated_method = "33B9D2701096C4754E66A8D8C18D18CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object writeReplace() throws ObjectStreamException {
        Object varDDF12B0D9770160307F932778BB004F2_879833549 = (new Inet4Address(ipaddress, hostName));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Inet4Address(ipaddress, hostName);
    }

    
    private static final long serialVersionUID = 3286316764910316507L;
    public static final InetAddress ANY =
            new Inet4Address(new byte[] { 0, 0, 0, 0 }, null);
    public static final InetAddress ALL =
            new Inet4Address(new byte[] { (byte) 255, (byte) 255,
                                          (byte) 255, (byte) 255 }, null);
    public static final InetAddress LOOPBACK =
            new Inet4Address(new byte[] { 127, 0, 0, 1 }, "localhost");
}

