package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InterfaceAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.353 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "220CE3F94E98B4B531A4938FAFF932C0")

    private InetAddress address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.353 -0400", hash_original_field = "56E381C3954FC3FF7DB3E92DA33AD137", hash_generated_field = "7567F98825AE2C855E0ED195DA10645B")

    private InetAddress broadcastAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.353 -0400", hash_original_field = "66E8BBB112C8BE88E6A5CE871B315D9D", hash_generated_field = "70DE7742499AEA0A92EA72A6919A370C")

    private short prefixLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.353 -0400", hash_original_method = "A47E632924417AF09C6FD6A35089DC11", hash_generated_method = "6C7401FF4356D724F85FF65FCAB96BE1")
      InterfaceAddress(Inet4Address address, Inet4Address broadcastAddress, Inet4Address mask) {
        this.address = address;
        this.broadcastAddress = broadcastAddress;
        this.prefixLength = countPrefixLength(mask);
        // ---------- Original Method ----------
        //this.address = address;
        //this.broadcastAddress = broadcastAddress;
        //this.prefixLength = countPrefixLength(mask);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.354 -0400", hash_original_method = "48C591F4E78B8661DAF333100DFF1834", hash_generated_method = "D149CCD7CE2B4038970F458D9B70116C")
      InterfaceAddress(Inet6Address address, short prefixLength) {
        this.address = address;
        this.broadcastAddress = null;
        this.prefixLength = prefixLength;
        // ---------- Original Method ----------
        //this.address = address;
        //this.broadcastAddress = null;
        //this.prefixLength = prefixLength;
    }

    
        private static short countPrefixLength(Inet4Address mask) {
        short count = 0;
        for (byte b : mask.ipaddress) {
            for (int i = 0; i < 8; ++i) {
                if ((b & (1 << i)) != 0) {
                    ++count;
                }
            }
        }
        return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.357 -0400", hash_original_method = "C2F63B53807D79A96FCD6544A2D6E3D6", hash_generated_method = "27F570C4ABDB0172C974F02781D708EF")
    @Override
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_1698778363 = (obj == this);
        } //End collapsed parenthetic
        InterfaceAddress rhs;
        rhs = (InterfaceAddress) obj;
        boolean varCD50253B938630268FE23FE3AAE7B570_1733670911 = (((address == null) ? rhs.address == null : address.equals(rhs.address)) &&
                (rhs.prefixLength == prefixLength) &&
                ((broadcastAddress == null) ? rhs.broadcastAddress == null : broadcastAddress.equals(rhs.broadcastAddress))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213354933 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213354933;
        // ---------- Original Method ----------
        //if (obj == this){
            //return true;
        //}
        //if (!(obj instanceof InterfaceAddress)) {
            //return false;
        //}
        //InterfaceAddress rhs = (InterfaceAddress) obj;
        //return ((address == null) ? rhs.address == null : address.equals(rhs.address)) &&
                //(rhs.prefixLength == prefixLength) &&
                //((broadcastAddress == null) ? rhs.broadcastAddress == null : broadcastAddress.equals(rhs.broadcastAddress));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.371 -0400", hash_original_method = "2A9C5EEED856061F72C9734D5432AB47", hash_generated_method = "634B53B658CDDC5E26E6DB7674B3D632")
    @Override
    public int hashCode() {
        int hashCode;
        hashCode = 0;
        hashCode = -address.hashCode();
        hashCode += broadcastAddress == null ? 0 : broadcastAddress.hashCode();
        hashCode += prefixLength;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1576928335 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1576928335;
        // ---------- Original Method ----------
        //int hashCode = address == null ? 0 : -address.hashCode();
        //hashCode += broadcastAddress == null ? 0 : broadcastAddress.hashCode();
        //hashCode += prefixLength;
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.379 -0400", hash_original_method = "1F9308CDA843BEB3E12C5EE04150EA0F", hash_generated_method = "90D73891836E6D74202F2873033C8BD8")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1542187250 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1542187250 = address + "/" + prefixLength + " [" + broadcastAddress + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1542187250.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1542187250;
        // ---------- Original Method ----------
        //return address + "/" + prefixLength + " [" + broadcastAddress + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.379 -0400", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "4B5480B2456125E81A8431B1B4BCC59F")
    public InetAddress getAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_970490070 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_970490070 = address;
        varB4EAC82CA7396A68D541C85D26508E83_970490070.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_970490070;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.380 -0400", hash_original_method = "CFDC66E7DE04051E5606E381D802784E", hash_generated_method = "A18DF60A917466CC9ECB8BB8E19D8425")
    public InetAddress getBroadcast() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_728784728 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_728784728 = broadcastAddress;
        varB4EAC82CA7396A68D541C85D26508E83_728784728.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_728784728;
        // ---------- Original Method ----------
        //return broadcastAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.380 -0400", hash_original_method = "D89613E4F9F0153F2E4A2BF9077CFCE5", hash_generated_method = "75DB14926BCDAE89265345B0921060F6")
    public short getNetworkPrefixLength() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_496236422 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_496236422;
        // ---------- Original Method ----------
        //return prefixLength;
    }

    
}

