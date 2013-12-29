package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.AF_INET;

import java.io.ObjectStreamException;
import java.nio.ByteOrder;

import libcore.io.Memory;





public final class Inet4Address extends InetAddress {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.335 -0500", hash_original_field = "C90A358F9020B90EC2F318C027EBE50C", hash_generated_field = "D810DA6D1E5ECCA9B74B4757EAD39B08")


    private static final long serialVersionUID = 3286316764910316507L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.336 -0500", hash_original_field = "B1D5021F108709308675EE61B00BF99D", hash_generated_field = "103A110B2CE2D2209A59D9B725C4482E")

    public static final InetAddress ANY =
            new Inet4Address(new byte[] { 0, 0, 0, 0 }, null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.337 -0500", hash_original_field = "E1C9BC3253E570C2A2350B8CC8BD0078", hash_generated_field = "BB6AED12F12CCF22F97AD9D972AF3194")

    public static final InetAddress ALL =
            new Inet4Address(new byte[] { (byte) 255, (byte) 255,
                                          (byte) 255, (byte) 255 }, null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.338 -0500", hash_original_field = "E0072382CA2392F40221424F896154BA", hash_generated_field = "3E1BF0CBCF49A9687059940E3F5B88B0")

    public static final InetAddress LOOPBACK =
            new Inet4Address(new byte[] { 127, 0, 0, 1 }, "localhost");

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.339 -0500", hash_original_method = "456618C96C185AE7EE8C57F26D0D0668", hash_generated_method = "456618C96C185AE7EE8C57F26D0D0668")
    Inet4Address(byte[] ipaddress, String hostName) {
        super(AF_INET, ipaddress, hostName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.340 -0500", hash_original_method = "0C1A3E77D90A82A5EF8B4836AA337609", hash_generated_method = "5FBAD234BBFCD9E183250A773C485443")
    @Override
public boolean isAnyLocalAddress() {
        return ipaddress[0] == 0 && ipaddress[1] == 0 && ipaddress[2] == 0 && ipaddress[3] == 0; // 0.0.0.0
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.341 -0500", hash_original_method = "38D1AA1924F9F7EC1F4EB08BE7254781", hash_generated_method = "E007A5EACDD8781EDCB19C243DA3BDA5")
    @Override
public boolean isLinkLocalAddress() {
        // The RI does not return true for loopback addresses even though RFC 3484 says to do so.
        return ((ipaddress[0] & 0xff) == 169) && ((ipaddress[1] & 0xff) == 254); // 169.254/16
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.342 -0500", hash_original_method = "FB35E1A46B66244783B8471385CB1A76", hash_generated_method = "7D2F186719117274906587AF854766D4")
    @Override
public boolean isLoopbackAddress() {
        return ((ipaddress[0] & 0xff) == 127); // 127/8
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.343 -0500", hash_original_method = "7EC53D5BF716DEFD994FB15A461002F1", hash_generated_method = "4C58AB6063507274493011388ABF0501")
    @Override
public boolean isMCGlobal() {
        // Check if we have a prefix of 1110
        if (!isMulticastAddress()) {
            return false;
        }

        int address = Memory.peekInt(ipaddress, 0, ByteOrder.BIG_ENDIAN);
        /*
         * Now check the boundaries of the global space if we have an address
         * that is prefixed by something less than 111000000000000000000001
         * (fortunately we don't have to worry about sign after shifting 8 bits
         * right) it is not multicast. ( < 224.0.1.0)
         */
        if (address >>> 8 < 0xE00001) {
            return false;
        }

        /*
         * Now check the high boundary which is prefixed by 11101110 = 0xEE. If
         * the value is higher than this than it is not MCGlobal ( >
         * 238.255.255.255 )
         */
        if (address >>> 24 > 0xEE) {
            return false;
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.343 -0500", hash_original_method = "CB22C78468AA446CA5A943070CD230A8", hash_generated_method = "927D0FB1529467CD6A13A4AEE2D87039")
    @Override
public boolean isMCLinkLocal() {
        return ((ipaddress[0] & 0xff) == 224) && (ipaddress[1] == 0) && (ipaddress[2] == 0); // 224.0.0/24
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.344 -0500", hash_original_method = "B0B42DF39D7CC893DB97C3031173A44B", hash_generated_method = "0585AE2BEE997250EF8BE53AC63FCF19")
    @Override
public boolean isMCNodeLocal() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.345 -0500", hash_original_method = "77DF4C339990FEF620E26E135CB9F40A", hash_generated_method = "C3A57EADA78345EA515D8856B7105A57")
    @Override
public boolean isMCOrgLocal() {
        return ((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xfc) == 192); // 239.192/14
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.346 -0500", hash_original_method = "9C14EBCA764FFF67AE16B4B98A6FB7C0", hash_generated_method = "1778DFA168E7A0C8889E5A199F675B01")
    @Override
public boolean isMCSiteLocal() {
        return ((ipaddress[0] & 0xff) == 239) && ((ipaddress[1] & 0xff) == 255); // 239.255/16
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.347 -0500", hash_original_method = "D19738A63A8D007E2A9921EAE82BC6DA", hash_generated_method = "582CB6E93105BBEA2E226F4B245AF7FD")
    @Override
public boolean isMulticastAddress() {
        return (ipaddress[0] & 0xf0) == 224; // 224/4
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.347 -0500", hash_original_method = "ACDDA2FDB8C312E800968083D2342A94", hash_generated_method = "A84FA89B7F076386CF6AEE7C66CA6B52")
    @Override
public boolean isSiteLocalAddress() {
        if ((ipaddress[0] & 0xff) == 10) { // 10/8
            return true;
        } else if (((ipaddress[0] & 0xff) == 172) && ((ipaddress[1] & 0xf0) == 16)) { // 172.16/12
            return true;
        } else if (((ipaddress[0] & 0xff) == 192) && ((ipaddress[1] & 0xff) == 168)) { // 192.168/16
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.348 -0500", hash_original_method = "ED281EE0C7A186E413EE6AFE3B25FC7C", hash_generated_method = "1AAE8317A2230F441F9711F6305DC8BC")
    private Object writeReplace() throws ObjectStreamException {
        return new Inet4Address(ipaddress, hostName);
    }
}

